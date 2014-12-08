/**
 * Project Name:mobileposp
 * File Name:CheckMerchant.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年12月2日下午6:15:50
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mobile.pos.mobileposp.dao.DeviceMapper;
import org.mobile.pos.mobileposp.dao.entity.DeviceEntity;
import org.mobile.pos.mobileposp.entity.BaseEntity;
import org.mobile.pos.mobileposp.entity.MobileTransactionEntity;
import org.mobile.pos.mobileposp.exception.PospException;
import org.mobile.pos.mobileposp.util.ResponseMessageUtil;
import org.mobile.pos.mobileposp.util.UnionpayResponseCode;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ClassName:CheckMerchant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月2日 下午6:15:50 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
@Scope("prototype")
public class CheckMerchant implements ISOHandler{
	
	@Autowired
	protected SqlSessionFactoryBean sessionFactoryBean = null;
	
	@Autowired
	protected SaleChannel channel = null;

	public Object processe(BaseEntity baseEntity) throws PospException {
		if(!(baseEntity instanceof MobileTransactionEntity)){
			return ResponseMessageUtil.failMessage(UnionpayResponseCode.ILLEGAL_ARGUMENT);
		}
		MobileTransactionEntity mobile = (MobileTransactionEntity) baseEntity;
		
		try {
			SqlSessionFactory sessionFactory = sessionFactoryBean.getObject();
			SqlSession session = sessionFactory.openSession();
			DeviceMapper deviceMapper = session.getMapper(DeviceMapper.class);
			DeviceEntity deviceEntity = deviceMapper.findDeviceByKsnNo(mobile.getDeviceCode());
			if(deviceEntity != null){
				System.out.println("-------" + deviceEntity);
			}
			System.out.println("deviceEntity==null");
		} catch (Exception e){
			
		}
		
		System.out.println("CheckMerchant=" + this);
		// TODO Auto-generated method stub
		return ResponseMessageUtil.successMessage();
	}

}

