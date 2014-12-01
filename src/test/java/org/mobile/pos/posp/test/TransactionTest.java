/**
 * Project Name:mobileposp
 * File Name:TransactionTest.java
 * Package Name:org.mobile.pos.posp.test
 * Date:2014年12月1日下午2:25:15
 * Copyright (c) 2014, wukm@cnepay.com.cn All Rights Reserved.
 **/

package org.mobile.pos.posp.test;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:TransactionTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014年12月1日 下午2:25:15 <br/>
 * @author   Wukunmeng
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class TransactionTest {
	
	private Logger logger = LoggerFactory.getLogger(TransactionTest.class);
	
	@Test
	public void testSale(){
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod("http://127.0.0.1:8080/trans/trans.action");
		method.addParameters(new NameValuePair[]{
				new NameValuePair("amount","100"),
				new NameValuePair("currency","RMB"),
				new NameValuePair("deviceCode",""),
				new NameValuePair("encryptPinBlock",""),
				new NameValuePair("cardSerialNum","001"),
				new NameValuePair("dataFieldIc","9F2608A75D11C9845065C49F2701809F101307000103A08810010A01000000980053AFF2859F37044125FAE49F36020190950508800400009A031412019C01009F02060000000001005F2A02015682027C009F1A0201569F03060000000000009F33036040C89F34034203009F3501229F1E0837383432363631338408A0000003330101029F090200209F410400000000"),
				new NameValuePair("cardTail","1010"),
				new NameValuePair("position",""),
				new NameValuePair("traceCode","5"),
				new NameValuePair("batchCode","1"),
				new NameValuePair("encryptTracks","6214441000011010=301020100000")});
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		try {
			int status = client.executeMethod(method);
			logger.info("返回交易状态：" + status);
			String body = method.getResponseBodyAsString();
			if(status == 200){
				logger.info("接收到的返回数据：" + body);
				JSONObject jsonObject = JSONObject.fromObject(body);
				if(jsonObject.getBoolean("isSuccess")){
					logger.info("成功：" + jsonObject.toString());
				} else {
					logger.error("服务器返回错误信息：" + jsonObject.toString());
				}
			} else {
				logger.error("错误的返回数据：" + body);
			}
			method.releaseConnection();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			logger.error("HttpException请求：" + e.getMessage(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("url请求IOException：" + e.getMessage(),e);
		}
	}

}

