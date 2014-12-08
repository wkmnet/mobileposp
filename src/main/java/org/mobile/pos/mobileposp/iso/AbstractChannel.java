/**
 * Project Name:mobileposp
 * File Name:AbstractChannel.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年11月30日下午6:07:42
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.lang3.math.NumberUtils;
import org.jpos.ext.channel.HEXChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.mobile.pos.mobileposp.exception.PospException;
import org.mobile.pos.mobileposp.util.CustomizedPropertyConfigurer;
import org.mobile.pos.mobileposp.util.UnionpayResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:AbstractChannel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月30日 下午6:07:42 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public abstract class AbstractChannel  implements ISOHandler{
	
	//标准日志输出
	protected Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	//ISO包
	protected ISOPackager packager = null;
	
	//发送通道
	protected HEXChannel channel = null;
	
	//目的的地址
	private String host = null;
	
	//目的的地址
	private String port = null;
	
	//超时时间
	private String timeOut = null;

	public AbstractChannel()throws PospException{
		this.host = CustomizedPropertyConfigurer.getContextProperty("server.host", "192.168.1.52");
		this.port = CustomizedPropertyConfigurer.getContextProperty("server.port", "5555");
		this.timeOut = CustomizedPropertyConfigurer.getContextProperty("server.timeout", "6000");
		if(!NumberUtils.isNumber(this.port)){
			throw new PospException(UnionpayResponseCode.ILLEGAL_ARGUMENT.getResponseCode(),"服务核心端口号错误：" + this.port);
		}
		init();
	}
	
	private void init()throws PospException{
		logger.info("初始化配置文件...");
		try {
			logger.info("初始化:iso8583.xml");
			packager = new GenericPackager(this.getClass().getClassLoader().getResourceAsStream("acq.xml"));
		} catch (ISOException e){
			logger.error("初始化[acq.xml]错误:" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.INIT_CONFIG_FAIL.getResponseCode(),"Message:" + e.getMessage());
		}
		
		try{
			logger.info("初始化HEXChannel...");
			channel = new HEXChannel(this.host,NumberUtils.toInt(this.port),this.packager);
			channel.setTimeout(NumberUtils.toInt(this.timeOut));
			channel.setOverrideHeader(true);
		} catch (SocketException e){
			logger.error("网络超时：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.TIME_OUT_NET.getResponseCode(),"核心服务超时!");
		}
		
	}
	
	public final void setHeader(String header){
		channel.setHeader(header);
	}
	
	protected ISOMsg sendMessage(ISOMsg message) throws PospException{
		return sendMessage(message,NumberUtils.toInt(this.timeOut));
	}
	
	protected ISOMsg sendMessage(ISOMsg message,int timeout) throws PospException{
		try{
			StringBuilder builder = new StringBuilder();
			builder.append(System.getProperty("line.separator"));
			builder.append("send:");
			builder.append(System.getProperty("line.separator"));
			builder.append(ISOUtil.hexdump(message.pack()));
			builder.append(System.getProperty("line.separator"));
			logger.info(builder.toString());
		} catch (ISOException e){
			logger.error("待发送的ISO8583报文,打包出现问题：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.ISO_MESSAGE_EXCEPTION.getResponseCode(),"ISO打包出现问题：" + e.getMessage());
		}
		return sendAndReceiveMessage(message,timeout);
	}
	
	private ISOMsg sendAndReceiveMessage(ISOMsg message,int timeout) throws PospException{
		try{
			channel.setTimeout(timeout);
			channel.connect();
			channel.send(message);
			ISOMsg result = channel.receive();
			return result;
		} catch (ISOException e){
			logger.error("发送ISO8583报文异常：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.ISO_MESSAGE_EXCEPTION.getResponseCode(),"发送ISO8583报文异常：" + e.getMessage());
		} catch (SocketException e){
			logger.error("网络超时：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.TIME_OUT_NET.getResponseCode(),"核心服务超时!");
		} catch (IOException e){
			logger.error("网络异常：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.NET_CONNECT_EXCEPTION.getResponseCode(),"网络连接异常：" + e.getMessage());
		} catch (Exception e){
			logger.error("未知异常信息：" + e.getMessage(),e);
			throw new PospException(UnionpayResponseCode.UNKNOW_EXCEPTION.getResponseCode(),"网络连接异常：" + e.getMessage());
		} finally {
			close();
		}
	}
	
	private void close(){
		try {
			if(channel != null && channel.isConnected()) {
				channel.disconnect();
			}
		} catch (Exception e){
			logger.error("关闭通道异常：" + e.getMessage(),e);
		}
	}
}

