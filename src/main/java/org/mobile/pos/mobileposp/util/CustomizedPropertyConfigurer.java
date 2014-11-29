/**
 * Project Name:mobileposp
 * File Name:CustomizedPropertyConfigurer.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年11月29日上午11:52:37
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * ClassName:CustomizedPropertyConfigurer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月29日 上午11:52:37 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class CustomizedPropertyConfigurer extends
		PropertyPlaceholderConfigurer {
	
	private static Map<String, String> ctxPropertiesMap;  
	 
	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.Properties)
	 */
   @Override  
   protected void processProperties(  
            ConfigurableListableBeanFactory beanFactoryToProcess,  
            Properties props) throws BeansException {  
        super.processProperties(beanFactoryToProcess, props);  
        ctxPropertiesMap = new HashMap<String, String>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            ctxPropertiesMap.put(keyStr, value);  
        }  
    }  
  
    /**
      * 
     * getContextProperty:(获取属性文件中值). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
      *
     * @author Wukunmeng
     * @param name
     * @param defaultValue
     * @return
     * @since JDK 1.6
      */
   public static String getContextProperty(String name,String defaultValue) {
	   if(StringUtils.isBlank(ctxPropertiesMap.get(name))){
		   return defaultValue;
	    }
	   return ctxPropertiesMap.get(name);  
    }

}

