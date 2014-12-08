/**
 * Project Name:mobileposp
 * File Name:LoadAndCheckMerchant.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年12月4日下午3:39:51
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import org.apache.commons.lang3.StringUtils;
import org.mobile.pos.mobileposp.dao.DeviceMapper;
import org.mobile.pos.mobileposp.dao.MerchantMapper;
import org.mobile.pos.mobileposp.dao.TerminalMapper;
import org.mobile.pos.mobileposp.dao.entity.DeviceEntity;
import org.mobile.pos.mobileposp.dao.entity.MerchantEntity;
import org.mobile.pos.mobileposp.dao.entity.TerminalEntity;
import org.mobile.pos.mobileposp.entity.BaseEntity;
import org.mobile.pos.mobileposp.entity.MobileTransactionEntity;
import org.mobile.pos.mobileposp.exception.PospException;
import org.mobile.pos.mobileposp.util.UnionpayResponseCode;

/**
 * ClassName:LoadAndCheckMerchant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月4日 下午3:39:51 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class LoadAndCheckMerchant extends AbstractISOHandler {

	private void loadTerminal(MobileTransactionEntity mobileTransactionEntity)throws PospException{
		DeviceMapper deviceMapper = getSqlSession().getMapper(DeviceMapper.class);
		DeviceEntity device = deviceMapper.findDeviceByKsnNo(mobileTransactionEntity.getDeviceCode());
		if(device == null){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + mobileTransactionEntity.getDeviceCode() + "]不存在.");
		}
		
		if(StringUtils.isBlank(device.getTerminalId())){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + device.getKsnNo() + "]找不到对应的终端.");
		}
		
		TerminalMapper terminalMapper = getSqlSession().getMapper(TerminalMapper.class);
		TerminalEntity terminal = terminalMapper.findTerminalById(device.getTerminalId());
		
		if(terminal == null){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + mobileTransactionEntity.getDeviceCode() + "]对应终端无法找到.");
		}
		
		if(!terminal.enabled()){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + device.getKsnNo() + "]对应终端未启用.");
		}
		mobileTransactionEntity.setTerminalNo(terminal.getTerminalNo());
		
		
		MerchantMapper merchantMapper = getSqlSession().getMapper(MerchantMapper.class);
		MerchantEntity merchant = merchantMapper.findMerchantById(terminal.getMerchantId());
		
		if(merchant == null){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + mobileTransactionEntity.getDeviceCode() + "]对应商户无法找到.");
		}
		
		if(!merchant.enable()){
			throw new PospException(UnionpayResponseCode.ILLEGAL_DEVICE.getResponseCode(),"设备[" + device.getKsnNo() + "]对应商户未启用.");
		}
		mobileTransactionEntity.setMerchantNo(merchant.getMerchantNo());;
	}
	
	
	public Object processe(BaseEntity baseEntity) throws PospException {
		// TODO Auto-generated method stub
		//读取商户及终端
		loadTerminal((MobileTransactionEntity) baseEntity);
		
		return getNextISOHandler().processe(baseEntity);
	}

}

