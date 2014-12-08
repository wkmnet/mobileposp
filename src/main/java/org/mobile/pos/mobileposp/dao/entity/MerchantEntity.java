/**
 * Project Name:mobileposp
 * File Name:MerchantEntity.java
 * Package Name:org.mobile.pos.mobileposp.dao.entity
 * Date:2014年12月4日下午5:30:22
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName:MerchantEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午5:30:22 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class MerchantEntity {
	
	public static String ENABLED = "1";
	
	public static String DISABLED = "0";

	//ID
	private String id = null;
	
	//是否启用 0未启用 1已启用
	private String enabled = null;
	
	//商户号
	private String merchantNo = null;
	
	//费率
	private String feeRate = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}

	@Override
	public String toString() {
		return "MerchantEntity [id=" + id + ", enabled=" + enabled
				+ ", merchantNo=" + merchantNo + ", feeRate=" + feeRate + "]";
	}
	
	public boolean enable(){
		return StringUtils.equals(this.enabled, ENABLED);
	}
}

