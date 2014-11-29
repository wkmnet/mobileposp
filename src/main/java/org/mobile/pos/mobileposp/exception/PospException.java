/**
 * Project Name:mobileposp
 * File Name:PospException.java
 * Package Name:org.mobile.pos.mobileposp.exception
 * Date:2014年11月27日下午1:20:37
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.exception;
/**
 * ClassName:PospException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月27日 下午1:20:37 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class PospException extends Exception {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 异常码
	 */
	private String exceptionCode = null;
	
	/**
	 * 异常描述信息
	 */
	private String message = null;
	
	public PospException(String exceptionCode){
		this.exceptionCode = exceptionCode;
	}
	
	public PospException(String exceptionCode,String message){
		super(message);
		this.exceptionCode = exceptionCode;
		this.message = message;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getMessage() {
		return message;
	}
}

