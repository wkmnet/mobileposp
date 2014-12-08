/**
 * Project Name:mobileposp
 * File Name:SystemEnvironmentUtil.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年12月3日下午3:42:33
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.core.SimpleConfiguration;
import org.jpos.ext.security.SimpleDBKeyStore;
import org.jpos.ext.security.SoftSecurityModule;
import org.jpos.security.SecureKeyStore.SecureKeyStoreException;
import org.jpos.util.DailyLogListener;
import org.jpos.util.NameRegistrar;
import org.jpos.util.SimpleLogListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ClassName:SystemEnvironmentUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月3日 下午3:42:33 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
public class SystemEnvironmentUtil {

	//标准日志输出
	private Logger logger = LoggerFactory.getLogger(SystemEnvironmentUtil.class);
	
	public static String Q2_LOG = "q2_log";
	
	public static String DATASOURCE = "ds";
	
	public static String SSM = "ssm";
	
	public static String KEY_STORE = "key_store";
	
	public SystemEnvironmentUtil(){
		initSystemEnvironment();
	}
	
	private void initSystemEnvironment(){
		logger.info("初始化Q2日志配置...");
		initQ2Logger();
		logger.info("注册数据源...");
		initDataSource();
		logger.info("初始化DBKeyStore...");
		initDBKeyStore();
		logger.info("初始化SecurityModule...");
		initSecurityModule();
	}
	
	private void initQ2Logger(){
		org.jpos.util.Logger log = new org.jpos.util.Logger();
		log.addListener(new SimpleLogListener());
		Configuration cfg = new SimpleConfiguration();
		cfg.put("window", "86400");
		cfg.put("prefix", System.getProperty("LOG4j_PATH") + "/posp-q2");
		cfg.put("suffix", ".log");
		cfg.put("date-format", "-yyyy-MM-dd");
		cfg.put("compression-format", "zip");
		DailyLogListener dailyLogListener = new DailyLogListener();
		try {
			dailyLogListener.setConfiguration(cfg);
			log.addListener(dailyLogListener);
			NameRegistrar.register(Q2_LOG, log);
		} catch (ConfigurationException e){
			logger.info("初始化Q2日志配置错误：" + e.getMessage(),e);
		}
	}
	
	private void initDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(CustomizedPropertyConfigurer.getContextProperty("driverClassName", ""));
		dataSource.setUrl(CustomizedPropertyConfigurer.getContextProperty("url", ""));
		dataSource.setUsername(CustomizedPropertyConfigurer.getContextProperty("username", ""));
		dataSource.setPassword(CustomizedPropertyConfigurer.getContextProperty("password", ""));
		dataSource.setValidationQuery(CustomizedPropertyConfigurer.getContextProperty("validationQuery", ""));
		NameRegistrar.register(DATASOURCE, dataSource);
	}
	
	private void initDBKeyStore(){
		SimpleDBKeyStore simpleDBKeyStore = new SimpleDBKeyStore();
		simpleDBKeyStore.setLogger((org.jpos.util.Logger)NameRegistrar.getIfExists(Q2_LOG), SimpleDBKeyStore.class.getName());
		try {
			simpleDBKeyStore.init(DATASOURCE, "key_store", "seq_keystore");
			NameRegistrar.register(KEY_STORE, simpleDBKeyStore);
		} catch (SecureKeyStoreException e){
			logger.info("初始化SimpleDBKeyStore错误：" + e.getMessage(),e);
		}
	}
	
	private void initSecurityModule(){
		Configuration cfg = new SimpleConfiguration();
		cfg.put("lmk", System.getProperty("WEB_ROOT") + "/WEB-INF/config/lmk");
		SoftSecurityModule sm = new SoftSecurityModule();
		sm.setLogger((org.jpos.util.Logger)NameRegistrar.getIfExists(Q2_LOG), SoftSecurityModule.class.getName());
		try {
			sm.setConfiguration(cfg);
			NameRegistrar.register(SSM, sm);
		} catch (ConfigurationException e){
			logger.info("初始化SoftSecurityModule错误：" + e.getMessage(),e);
		}
	}
}

