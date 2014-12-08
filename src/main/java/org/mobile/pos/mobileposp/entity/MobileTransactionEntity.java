/**
 * Project Name:mobileposp
 * File Name:MobileTransactionEntity.java
 * Package Name:org.mobile.pos.mobileposp.entity
 * Date:2014年11月26日下午6:53:35
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.entity;
/**
 * ClassName:MobileTransactionEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午6:53:35 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class MobileTransactionEntity extends TransactionBaseEntity{

	//设备标号
	private String deviceCode = null;
	
	//卡号后四位
	private String cardTail = null;
	
	//交易发生地点(经度，纬度)
	private String position = null;
	
	//校验值
	private String checksum = null;
	
	//交易发送标志,手机发送的posp
	private String header = null;

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getCardTail() {
		return cardTail;
	}

	public void setCardTail(String cardTail) {
		this.cardTail = cardTail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}

