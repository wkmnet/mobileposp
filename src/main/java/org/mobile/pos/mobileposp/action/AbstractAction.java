/**
 * Project Name:mobileposp
 * File Name:AbstractAction.java
 * Package Name:org.mobile.pos.mobileposp.action
 * Date:2014年11月26日下午3:45:26
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

/**
 * ClassName:AbstractAction <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午3:45:26 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public abstract class AbstractAction {
	
	//标准的日志输出
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

}

