/**
 * Project Name:mobileposp
 * File Name:TransactionService.java
 * Package Name:org.mobile.pos.mobileposp.service.trans
 * Date:2014年11月27日下午6:12:41
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.service.trans;

import org.mobile.pos.mobileposp.entity.TransactionEntity;
import org.mobile.pos.mobileposp.service.AbstractService;
import org.mobile.pos.mobileposp.util.ResponseMessageUtil;
import org.mobile.pos.mobileposp.util.UnionpayResponseCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * ClassName:TransactionService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月27日 下午6:12:41 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
@Scope("prototype")
public class TransactionService extends AbstractService {
	
	public static String SALE_CODE = "0200";

	/**
	 * 
	 * transaction:(处理交易消费等请求). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @param transactionParams
	 * @return
	 * @since JDK 1.6
	 */
	public Object transaction(TransactionEntity transactionParams){
		if( null == transactionParams){
			return ResponseMessageUtil.failMessage(UnionpayResponseCode.ILLEGAL_ARGUMENT.getResponseCode());
		}
		
		
		return null;
	}
	
	
}

