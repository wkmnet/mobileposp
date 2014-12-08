/**
 * Project Name:mobileposp
 * File Name:TerminalEntity.java
 * Package Name:org.mobile.pos.mobileposp.dao.entity
 * Date:2014年12月4日下午4:23:42
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName:TerminalEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午4:23:42 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class TerminalEntity {
	
	public static String ENABLED = "1";
	
	public static String DISABLED = "0";

	
	//ID
	private String id = null;
	
	//批次号
	private String batchNo = null;
	
	//设备是否可用 0不可用 1可用
	private  String enabled = null;
	
	//设备SN，设备号
	private String machineCode = null;
	
	//商户ID
	private String merchantId = null;
	
	//商户号
	private String merchantNo = null;
	
	//终端号
	private String terminalNo = null;
	
	//跟踪号
	private String traceNo = null;
	
	//ic状态 00和空不需要更新密钥
	private String icStatus = null;

	@Override
	public String toString() {
		return "TerminalEntity [id=" + id + ", batchNo=" + batchNo
				+ ", enabled=" + enabled + ", machineCode=" + machineCode
				+ ", merchantId=" + merchantId + ", merchantNo=" + merchantNo
				+ ", terminalNo=" + terminalNo + ", traceNo=" + traceNo
				+ ", icStatus=" + icStatus + "]";
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getIcStatus() {
		return icStatus;
	}

	public void setIcStatus(String icStatus) {
		this.icStatus = icStatus;
	}
	
	public boolean enabled(){
		return StringUtils.equals(this.enabled, ENABLED);
	}
}

