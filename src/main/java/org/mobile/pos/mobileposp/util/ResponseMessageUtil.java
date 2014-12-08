/**
 * Project Name:mobileposp
 * File Name:ResponseMessageUtil.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年11月27日下午6:21:14
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * ClassName:ResponseMessageUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月27日 下午6:21:14 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ResponseMessageUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ResponseMessageUtil.class);

	private ResponseMessageUtil(){}
	
	public static Map<String,Object> failMessage(UnionpayResponseCode unionpayResponseCode){
		return failMessage(unionpayResponseCode.getResponseCode());
	}
	
	public static Map<String,Object> failMessage(String errorCode){
		return failMessage(errorCode,null);
	}
	
	public static Map<String,Object> failMessage(String errorCode,String message){
		return resetResponseMessage(false,errorCode,message,null);
	}
	
	public static Map<String,Object> failMessage(String errorCode,String message,Map<String,Object> body){
		return resetResponseMessage(false,errorCode,message,null);
	}
	
	
	public static Map<String,Object> successMessage(){
		return resetResponseMessage(true,UnionpayResponseCode.SUCCESS.getResponseCode(),null,null);
	}
	
	public static Map<String,Object> successMessage(String message){
		return resetResponseMessage(true,UnionpayResponseCode.SUCCESS.getResponseCode(),message,null);
	}
	
	public static Map<String,Object> successMessage(String message,Map<String,Object> body){
		return resetResponseMessage(true,UnionpayResponseCode.SUCCESS.getResponseCode(),message,body);
	}
	
	public static Map<String,Object> successMessage(Map<String,Object> body){
		return resetResponseMessage(true,UnionpayResponseCode.SUCCESS.getResponseCode(),null,body);
	}
	
	/**
	 * 
	 * resetResponseMessage:(组织交易响应信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @param isSuccess
	 * @param responseCode
	 * @param responseMessage
	 * @param body
	 * @return
	 * @since JDK 1.6
	 */
	public static Map<String,Object> resetResponseMessage(boolean isSuccess,String responseCode,String responseMessage,Map<String,Object> body){
		Map<String,Object> result = new HashMap<String,Object>();
		if(!MapUtils.isEmpty(body)){
			result.putAll(body);
		}
		result.put("respTime", "");
		result.put("isSuccess", String.valueOf(isSuccess));
		result.put("respCode", responseCode);
		result.put("respMsg", getResponseMessage(responseCode));
		logger.info(System.getProperty("line.separator"));
		logger.info("response:" + result);
		return result;
	}
	
	/**
	 * 
	 * getResponseMessage:(根据响应码，获取对应的响应中文描述信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @param responseCode
	 * @return
	 * @since JDK 1.6
	 */
	public static String getResponseMessage(String responseCode){
		UnionpayResponseCode[] codes = UnionpayResponseCode.values();
		for(UnionpayResponseCode code:codes){
			if(StringUtils.equals(code.getResponseCode(), responseCode)){
				return code.getMessage();
			}
		}
		return CustomizedPropertyConfigurer.getContextProperty(responseCode, "未知信息!");
	}
}

