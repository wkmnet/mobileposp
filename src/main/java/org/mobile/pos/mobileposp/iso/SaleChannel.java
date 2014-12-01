/**
 * Project Name:mobileposp
 * File Name:SaleChannel.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年11月30日下午6:04:36
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jpos.core.CardHolder;
import org.jpos.core.InvalidCardException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.mobile.pos.mobileposp.entity.TransactionEntity;
import org.mobile.pos.mobileposp.exception.PospException;
import org.mobile.pos.mobileposp.util.ResponseMessageUtil;
import org.mobile.pos.mobileposp.util.UnionpayResponseCode;

/**
 * ClassName:SaleChannel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月30日 下午6:04:36 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class SaleChannel extends AbstractChannel{

	public SaleChannel() throws PospException {
		super();		
	}

	
	public Map<String,Object> sale(TransactionEntity transactionEntity) throws PospException{
		try {
			CardHolder cradHolder = new CardHolder(transactionEntity.getEncryptTracks());
			logger.info("二磁道信息：" + transactionEntity.getEncryptTracks());
			logger.info("PAN：" + cradHolder.getPAN());
			
			ISOMsg message = new ISOMsg();
			message.set(0, "0200");
			message.set(2, cradHolder.getPAN());
			message.set(3, "000000");
			message.set(4, String.format("%012d", NumberUtils.toInt(transactionEntity.getAmount())));
			message.set(11, String.format("%06d", NumberUtils.toInt(transactionEntity.getTraceCode())));
			if(!StringUtils.isBlank(cradHolder.getEXP())){
				message.set(14, cradHolder.getEXP());
			}
			if(StringUtils.isBlank(transactionEntity.getDataFieldIc())){
				message.set(22,StringUtils.isBlank(transactionEntity.getEncryptPinBlock())?"051":"052");
			} else {
				message.set(22,StringUtils.isBlank(transactionEntity.getEncryptPinBlock())?"021":"022");
			}
			if(!StringUtils.isBlank(transactionEntity.getCardSerialNum())){
				message.set(23,transactionEntity.getCardSerialNum());
			}
			message.set(25,"00");
			if(!StringUtils.isBlank(transactionEntity.getEncryptPinBlock())){
				message.set(26,"06");
			}
			message.set(28,"E00000001");
			message.set(35,cradHolder.getTrack2());
			message.set(41,"30597848");
			message.set(42,"500000000524699");
			message.set(49,"156");
			if(!StringUtils.isBlank(transactionEntity.getEncryptPinBlock())){
				message.set(52,ISOUtil.hex2byte(transactionEntity.getEncryptPinBlock()));
			}
			message.set(53,"2000000000000000");
			if(!StringUtils.isBlank(transactionEntity.getDataFieldIc())){
				message.set(55,ISOUtil.hex2byte(transactionEntity.getDataFieldIc()));
			}
			message.set(60,"22" + String.format("%06d", NumberUtils.toInt(transactionEntity.getBatchCode())) + "000500");
			message.set(64,new byte[8]);
			
			message.setPackager(channel.getPackager());
			message.setDirection(ISOMsg.OUTGOING);
			channel.setHeader("6000050008031003100000");
			
			ISOMsg response = sendMessage(message);
			String responseCode = response.getString(39);
			if(StringUtils.equals(responseCode, UnionpayResponseCode.SUCCESS.getResponseCode())){
				return ResponseMessageUtil.successMessage();
			}
			return ResponseMessageUtil.failMessage(responseCode);
		} catch (InvalidCardException e){
			logger.error("InvalidCardException:" + e.getMessage(),e);
			return ResponseMessageUtil.failMessage(UnionpayResponseCode.ILLEGAL_ARGUMENT.getResponseCode(),"无效的卡号!");
		} catch (ISOException e){
			logger.error("ISOException:" + e.getMessage(),e);
			return ResponseMessageUtil.failMessage(UnionpayResponseCode.ISO_MESSAGE_EXCEPTION);
		}
	}
	
}

