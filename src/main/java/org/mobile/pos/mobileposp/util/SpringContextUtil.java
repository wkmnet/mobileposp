/**
 * Project Name:mobileposp
 * File Name:SpringContextUtil.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年12月4日下午2:58:35
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ClassName:SpringContextUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午2:58:35 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	
	public static <T> T getBean(Class<T> requiredType)throws BeansException{
		return applicationContext.getBean(requiredType);
	}

	public static <T> T getBean(String name,Class<T> requiredType)throws BeansException{
		return applicationContext.getBean(name,requiredType);
	}
	
	public static Object getBean(String name) throws BeansException{
		return applicationContext.getBean(name);
	}
	
}

