/**
 * Project Name:mobileposp
 * File Name:DeviceEntity.java
 * Package Name:org.mobile.pos.mobileposp.dao.entity
 * Date:2014年12月3日上午11:00:50
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao.entity;


/**
 * ClassName:DeviceEntity 设备实体<br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月3日 上午11:00:50 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class DeviceEntity {
	
	//设备编号
	private String ksnNo = null;
	
	//是否使用 1使用 0未使用
	private String isUsed = null;
	
	//是否激活 1已激活 0未激活
	private String isActivated = null;
	
	//关联设备终端号
	private String terminalId = null;
	
	//MAC地址
	private String macAddress = null;
	
	//蓝牙名
	private String bluetoothName = null;

	public String getKsnNo() {
		return ksnNo;
	}

	public void setKsnNo(String ksnNo) {
		this.ksnNo = ksnNo;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(String isActivated) {
		this.isActivated = isActivated;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getBluetoothName() {
		return bluetoothName;
	}

	public void setBluetoothName(String bluetoothName) {
		this.bluetoothName = bluetoothName;
	}

	@Override
	public String toString() {
		return "DeviceEntity [ksnNo=" + ksnNo + ", isUsed=" + isUsed
				+ ", isActivated=" + isActivated + ", terminalId=" + terminalId
				+ ", macAddress=" + macAddress + ", bluetoothName="
				+ bluetoothName + "]";
	}
}

