/**
 * Project Name:mobileposp
 * File Name:TerminalMapper.java
 * Package Name:org.mobile.pos.mobileposp.dao
 * Date:2014年12月4日下午4:21:11
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao;

import org.mobile.pos.mobileposp.dao.entity.TerminalEntity;

/**
 * ClassName:TerminalMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午4:21:11 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface TerminalMapper {

	public TerminalEntity findTerminalById(String id);
	
}

