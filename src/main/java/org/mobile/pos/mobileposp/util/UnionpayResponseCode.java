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
	ILLEGAL_ARGUMENT("P001","无效参数");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

