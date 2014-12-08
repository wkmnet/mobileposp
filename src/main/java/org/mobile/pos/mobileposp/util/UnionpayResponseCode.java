/**
 * Project Name:mobileposp
 * File Name:UnionpayResponseCode.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年11月27日下午6:33:06
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;
/**
 * ClassName:UnionpayResponseCode <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月27日 下午6:33:06 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public enum UnionpayResponseCode {
	
	//无效参数
	SUCCESS("00","交易成功!"),
	
	//无效参数
	ILLEGAL_ARGUMENT("RES001","无效参数"),
	
	//初始化配置文件错误
	INIT_CONFIG_FAIL("RES002","初始化配置文件错误!"),
	
	//超时
	TIME_OUT_NET("RES003","网络已超时!"),
	
	//报文异常
	ISO_MESSAGE_EXCEPTION("RES004","报文出现异常!"),
	
	//网络连接异常
	NET_CONNECT_EXCEPTION("RES005","网络连接异常!"),
	
	//无效参数
	ILLEGAL_REQUSET("RES006","未知请求!"),
	
	//无效设备
	ILLEGAL_DEVICE("RES007","无效的设备!"),
	
	
	
	
	
	
	
	
	
	//未知异常
	UNKNOW_EXCEPTION("RES999","未知异常!");
	
	//响应码
	private String responseCode = null;
	//响应信息
	private String message = null;
	
	private UnionpayResponseCode(String responseCode,String message){
		 this.responseCode = responseCode;
		 this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getMessage() {
		return message;
	}
}

