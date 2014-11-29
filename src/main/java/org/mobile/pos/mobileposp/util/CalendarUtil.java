/**
 * Project Name:mobileposp
 * File Name:CalendarUtil.java
 * Package Name:org.mobile.pos.mobileposp.util
 * Date:2014年11月29日下午8:19:00
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.mobileposp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:CalendarUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年11月29日 下午8:19:00 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class CalendarUtil {
	
	private CalendarUtil(){}
	
	//标准日志输出
	private static Logger LOG = LoggerFactory.getLogger(CalendarUtil.class);
	
	/**
	 * 格式：yyyyMMddHHmmss
	 */
	public static String DATE_TIME_PATTERN_0 = "yyyyMMddHHmmss";
	
	/**
	 * 格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String DATE_TIME_PATTERN_1 = "yyyy-MM-dd HH:mm:ss";
	
	
	public static long parse(String source){
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN_1);
		try {
			return format.parse(source).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOG.error("转换日期" + source + "异常：" + e.getMessage(),e);
		}
		return -1;
	}
	
	public static String formatNow(){
		return format(Calendar.getInstance().getTime());
	}
	
	public static String format(Date date){
		return format(date,DATE_TIME_PATTERN_0);
	}
	
	/**
	 * 
	 * format:(按照指定格式，格式化日期时间). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Wukunmeng
	 * @param date
	 * @param pattern
	 * @return
	 * @since JDK 1.6
	 */
	public static String format(Date date,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

}

