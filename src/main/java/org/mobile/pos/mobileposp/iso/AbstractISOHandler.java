/**
 * Project Name:mobileposp
 * File Name:AbstractISOHandler.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年12月4日下午3:24:00
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:AbstractISOHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午3:24:00 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public abstract class AbstractISOHandler extends SqlSessionDaoSupport implements ISOHandler {

	private ISOHandler nextISOHandler = null;
	
	//标准日志
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public ISOHandler getNextISOHandler() {
		return nextISOHandler;
	}

	public void setNextISOHandler(ISOHandler nextISOHandler) {
		this.nextISOHandler = nextISOHandler;
	}
	
}

