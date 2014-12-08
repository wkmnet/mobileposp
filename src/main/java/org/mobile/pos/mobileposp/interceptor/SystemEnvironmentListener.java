/**
 * Project Name:mobileposp
 * File Name:SystemEnvironmentListener.java
 * Package Name:org.mobile.pos.mobileposp.interceptor
 * Date:2014年11月26日下午4:39:51
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:SystemEnvironmentListener <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午4:39:51 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class SystemEnvironmentListener implements ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(SystemEnvironmentListener.class);

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent sce) {

		// TODO Auto-generated method stub
		if(!StringUtils.isBlank(System.getProperty("catalina.home"))){
			System.setProperty("LOG4j_PATH", System.getProperty("catalina.home") + System.getProperty("file.separator") + "logs");
		} else {
			System.setProperty("LOG4j_PATH", sce.getServletContext().getRealPath("/"));
		}
		System.setProperty("WEB_ROOT", sce.getServletContext().getRealPath("/"));
		logger.info("LOG4j_PATH:" + System.getProperty("LOG4j_PATH"));
		logger.info("WEB_ROOT:" + System.getProperty("WEB_ROOT"));
		
	}

}

