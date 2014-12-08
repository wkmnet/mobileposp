/**
 * Project Name:mobileposp
 * File Name:MerchantMapper.java
 * Package Name:org.mobile.pos.mobileposp.dao
 * Date:2014年12月4日下午5:28:36
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.dao;

import org.mobile.pos.mobileposp.dao.entity.MerchantEntity;

/**
 * ClassName:MerchantMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午5:28:36 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface MerchantMapper {
	
	public MerchantEntity findMerchantById(String id);
}

