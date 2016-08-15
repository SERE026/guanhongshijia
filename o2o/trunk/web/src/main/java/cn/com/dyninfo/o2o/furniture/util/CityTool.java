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

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;


public class CityTool {

	private static Logger log = Logger.getLogger(CityTool.class);
	public final static String IP_SERVICE_PATH="http://ip.taobao.com/service/getIpInfo.php";
	private static String getCityIdByIp(String ip){

		String cityId="";
		try{
			HttpClient httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60*1000);
			PostMethod postMethod=new PostMethod(IP_SERVICE_PATH);
			postMethod.addParameter("ip", ip);
			httpClient.executeMethod(postMethod);
			if(postMethod.getStatusCode()==200){
				InputStream  in=postMethod.getResponseBodyAsStream();
				byte b[]=new byte[1024];
				StringBuffer sb=new StringBuffer("");
				int len=0;
				while((len=in.read(b))>-1){
					sb.append(new String(b,0,len));
				}
//				System.out.println(sb);
				JSONObject person1 = JSONObject.fromObject(sb.toString());
//				System.out.println(person1.get("data"));
				person1= (JSONObject) person1.get("data");
				cityId=(String) person1.get("city");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cityId;
	}
	
	public static String  getClientIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
//		log.warn("IP is: " + ip);
	   return ip;
	}
	/**
	 * 获取客户所在城市
	 * @param request
	 * @return
	 */
	public static String getClientCityId(HttpServletRequest request){
		return getCityIdByIp(getClientIp(request));

	}
	
	public static void main(String args[]){
//		System.out.println(getCityIdByIp("175.152.39.120"));//175.152.39.120
	}
}
