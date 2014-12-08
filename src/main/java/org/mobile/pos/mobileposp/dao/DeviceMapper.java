/**
 * Project Name:mobileposp
 * File Name:DeviceMapper.java
 * Package Name:org.mobile.pos.mobileposp.dao
 * Date:2014年12月3日上午11:12:50
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao;

import org.mobile.pos.mobileposp.dao.entity.DeviceEntity;

/**
 * ClassName:DeviceMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月3日 上午11:12:50 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface DeviceMapper {

	public DeviceEntity findDeviceByKsnNo(String ksnNo);
}

