/**
 * Project Name:mobileposp
 * File Name:TransactionEntity.java
 * Package Name:org.mobile.pos.mobileposp.entity
 * Date:2014年11月26日下午6:53:35
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.entity;
/**
 * ClassName:TransactionEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午6:53:35 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class TransactionEntity {

	//加密磁道
	private String encryptTracks = null;
	
	//交易金额
	private String amount = null;
	
	//交易币种
	private String currency = null;
	
	//设备标号
	private String deviceCode = null;
	
	//加密PinBlock
	private String encryptPinBlock = null;
	
	//卡序列号
	private String cardSerialNum = null;
	
	//IC数据域，集成电路卡系统相关数据
	private String dataFieldIc = null;
	
	//卡号后四位
	private String cardTail = null;
	
	//交易发生地点(经度，纬度)
	private String position = null;
	
	//校验值
	private String checksum = null;
	
	//流水编号
	private String traceCode = null;
	
	//批次编号
	private String batchCode = null;

	public String getEncryptTracks() {
		return encryptTracks;
	}

	public void setEncryptTracks(String encryptTracks) {
		this.encryptTracks = encryptTracks;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getEncryptPinBlock() {
		return encryptPinBlock;
	}

	public void setEncryptPinBlock(String encryptPinBlock) {
		this.encryptPinBlock = encryptPinBlock;
	}

	public String getCardSerialNum() {
		return cardSerialNum;
	}

	public void setCardSerialNum(String cardSerialNum) {
		this.cardSerialNum = cardSerialNum;
	}

	public String getDataFieldIc() {
		return dataFieldIc;
	}

	public void setDataFieldIc(String dataFieldIc) {
		this.dataFieldIc = dataFieldIc;
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

	public String getTraceCode() {
		return traceCode;
	}

	public void setTraceCode(String traceCode) {
		this.traceCode = traceCode;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
}

