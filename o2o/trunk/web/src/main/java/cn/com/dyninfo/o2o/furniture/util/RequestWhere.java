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

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RequestWhere {

	public static String getWhere(HttpServletRequest request){
		String result="";
		String order="";
		Enumeration et=request.getParameterNames();
		while(et.hasMoreElements()){
			String name=(String) et.nextElement();
			String value=request.getParameter(name);
			name=name.replaceAll("。", ".");
			if(value.length()>0){
				if(name.equals("order")){
					value=value.replaceAll("。", ".");
					if(value.indexOf("order_5")==0){
						order=" order by oa."+value.replace("order_5", "");
					}
					if(value.indexOf("order_u")==0){
						order=" order by u."+value.replace("order_5", "");
					}
					else{
						order=" order by n."+value.replace("order_", "");
					}
				}else if(name.indexOf("attr_")==0){
					name=name.replace("attr_", "");
					char f=name.charAt(0);
					name=name.substring(1);
					switch(f){
						case '2':{
							result+=" and n."+name+" ='"+value+"' ";
							break;
						}
						case '1':{
							result+=" and n."+name+" like '%"+value+"%' ";
							break;
						}
						case '3':{
							result+=" and n."+name+" >= '"+value+"' ";
							break;
						}
						case '4':{
							result+=" and n."+name+" < '"+value+"' ";
							break;
						}

					}
				}else if(name.indexOf("attr1_")==0){
					name=name.replace("attr1_", "");
					char f=name.charAt(0);
					name=name.substring(1);
					switch(f){
						case '2':{
							result+=" and oa."+name+" ='"+value+"' ";
							break;
						}
						case '1':{
							result+=" and oa."+name+" like '%"+value+"%' ";
							break;
						}
					}
				}else if(name.indexOf("attru_")==0){
					name=name.replace("attru_", "");
					char f=name.charAt(0);
					name=name.substring(1);
					switch(f){
						case '2':{
							result+=" and u."+name+" ='"+value+"' ";
							break;
						}
						case '1':{
							result+=" and u."+name+" like '%"+value+"%' ";
							break;
						}
					}
				}
			}
		}
		result+=order;
		return result;
	}
}
