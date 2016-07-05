/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class SendDx {

	public static long prvTime=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String currentTime=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			System.out.print(currentTime);
			
			new SendDx().sendSMS("13982257430","您的订单请求我已经收到！","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/*
	 * 发送方法  其他方法同理      返回0 或者 1 都是  提交成功
	 */
	public static int sendSMS(String Mobile,String Content, String send_time) throws HttpException, IOException {
		
		int inputLine = 0;

		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod("http://www.82009668.com/SDK/Service.asmx/sendMessage");// 
		postMethod.addParameter("username", "cf-xpzc");
		postMethod.addParameter("pwd", "884cb5");
		postMethod.addParameter("phones", Mobile);
		postMethod.addParameter("contents", Content);
		postMethod.addParameter("scode", "");
		postMethod.addParameter("setTime", send_time);
		postMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		httpClient.executeMethod(postMethod);
		InputStream in = postMethod.getResponseBodyAsStream();
		byte b[] = new byte[1024];
		StringBuffer sb = new StringBuffer("");
		while (in.read(b) > -1) {
			sb.append(new String(b));
		}
		postMethod.releaseConnection();
		Matcher mth=Pattern.compile("<int xmlns=\"http://www.82009668.com/\">(-?[0-9]{1,2})</int>").matcher(sb);
		while(mth.find()){
			inputLine=Integer.parseInt(mth.group(1));
		};
		
		return inputLine;
	}
}
