/**
 * Project Name:mobileposp
 * File Name:MobilePospInterceptor.java
 * Package Name:org.mobile.pos.mobileposp.interceptor
 * Date:2014年11月26日下午4:10:22
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ClassName:MobilePospInterceptor <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午4:10:22 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class MobilePospInterceptor extends HandlerInterceptorAdapter {
	
	//标准日志输出
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//打印用户请求的IP信息
		StringBuilder userAddrInfo = new StringBuilder();
		userAddrInfo.append("有来自：[");
		userAddrInfo.append(request.getRemoteAddr());
		userAddrInfo.append(";");
		userAddrInfo.append(request.getRemoteHost());
		userAddrInfo.append("]的请求，user=");
		userAddrInfo.append(request.getRemoteUser());
		userAddrInfo.append(";port=");
		userAddrInfo.append(request.getRemotePort());
		logger.info(userAddrInfo.toString());
		
		//打印请求参数信息
		StringBuilder params = new StringBuilder();
		params.append(System.getProperty("line.separator"));
		params.append("request：[");
		params.append(System.getProperty("line.separator"));
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String key = paramNames.nextElement();
			params.append("\t");
			params.append("{" + key);
			params.append("=");
			String[] values = request.getParameterValues(key);
			if( null == values){
				params.append("null");
			} else {
				for(String v:values){
					params.append(v);
					params.append(",");
				}
				params.deleteCharAt(params.length() - 1);
			}
			params.append("}");
			params.append(System.getProperty("line.separator"));
		}
		params.append("]");
		logger.info(params.toString());

		return true;		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null){
			Map<String,Object> map = modelAndView.getModel();
			logger.info("响应data信息：" + map);
			logger.info("响应jsp信息：" + modelAndView.getViewName());
			logger.info("响应url信息：" + modelAndView.getView());
		}
	}
}

