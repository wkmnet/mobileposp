/**
 * Project Name:mobileposp
 * File Name:TransactionAction.java
 * Package Name:org.mobile.pos.mobileposp.action.trans
 * Date:2014年11月26日下午6:26:30
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.action.trans;

import java.util.HashMap;
import java.util.Map;

import org.mobile.pos.mobileposp.action.AbstractAction;
import org.mobile.pos.mobileposp.entity.TransactionEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:TransactionAction <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月26日 下午6:26:30 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
@Scope("prototype")
@RequestMapping("/trans")
public class TransactionAction extends AbstractAction {

	/**
	 * 
	 * transaction:(接收并处理交易报文). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @return
	 * @since JDK 1.6
	 */
	@ResponseBody
	@RequestMapping(value="/trans.action",method=RequestMethod.POST)
	public Object transaction (TransactionEntity transactionParams){
		return null;
	}
	
	@RequestMapping(value="/test2.action",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object test(){
		Map<String,String> res = new HashMap<String,String>();
		res.put("a", "中國");
		return res;
	}
}

