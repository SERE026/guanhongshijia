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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * COOKIE 工具
 * @author Administrator
 *
 */
public class CookTool {

	public static String getCookIEValue(String key,HttpServletRequest request){
		String data="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie ck:cookies){
//				System.out.println(ck.getName()+"======="+ck.getValue());
				if(ck.getName().equals(key)){
					data=ck.getValue();
					break;
				}
			}
		}
		return data;
	}
	

	public static void addCookValue(String key,String value,HttpServletResponse response){
		Cookie ck=new Cookie(key, value);
		ck.setMaxAge(365 * 24 * 60 * 60);
		ck.setPath("/");
	    response.addCookie(ck);
	}
}
