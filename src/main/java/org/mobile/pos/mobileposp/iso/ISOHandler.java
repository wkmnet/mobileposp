/**
 * Project Name:mobileposp
 * File Name:ISOHandler.java
 * Package Name:org.mobile.pos.mobileposp.iso
 * Date:2014年12月2日下午3:37:05
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.iso;

import org.mobile.pos.mobileposp.entity.BaseEntity;
import org.mobile.pos.mobileposp.exception.PospException;

/**
 * ClassName:ISOHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月2日 下午3:37:05 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface ISOHandler {
	
	/**
	 * 
	 * processe:(处理具体的业务逻辑). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @param baseEntity
	 * @return
	 * @throws PospException
	 * @since JDK 1.6
	 */
	public abstract Object processe(BaseEntity baseEntity)throws PospException;

}

