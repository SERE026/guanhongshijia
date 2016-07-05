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

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;



public class ResponseUtil {
	public static String getObjeJson(Object obj,Map map){
		return UtilGetObject.getObjeJson(obj,map,0);
	}
	
	
	public static StringBuffer getJson(HashMap map){
	   StringBuffer jsons=new StringBuffer("[{");
		   Set set=map.keySet();
		   Iterator it= set.iterator();
		   while(it.hasNext()){
			   String key=(String) it.next();
			   String json=new String();
			   List val=(List) map.get(key);
			   for(Object obj:val){
				   Field [] f=obj.getClass().getDeclaredFields();
				   json+="{";
				   for(int i=0;i<f.length;i++){
					  String fieldname= f[i].getName();
					   try {
							Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
							if(f[i].getType().getName().equals("int")){
								Integer v=(Integer) m.invoke(obj);
								json+="\""+fieldname+"\":\""+v+"\",";
							}
							else if(f[i].getType().getName().equals("java.lang.String")){
								String v=(String) m.invoke(obj);
								json+="\""+fieldname+"\":\""+v+"\",";
							}else if(f[i].getType().getName().equals("java.lang.Double")){
								Double v=(Double) m.invoke(obj);
								json+="\""+fieldname+"\":\""+v+"\",";
							}
						} catch (Exception exc) {
						}
				   }
				   if(json.length()>0&&json.charAt(json.length()-1)==','){
					   json=json.substring(0, json.length()-1);
				   }
				   json+="},";
			   }
			   if(json.length()>0&&json.charAt(json.length()-1)==','){
				   json=json.substring(0, json.length()-1);
			   }
			   jsons.append("\""+key+"\":["+json+"],");
		   }
		   if(jsons.length()>0&&jsons.charAt(jsons.length()-1)==','){
			   jsons.deleteCharAt(jsons.length()-1);
		   }
		   jsons.append("}]");
	   return jsons;
	}
	
	public static StringBuffer getJson(List val){
		   StringBuffer jsons=new StringBuffer("[");
		   String json="";
		   String noF="";
		   int count=0;
				   for(Object obj:val){
					   if(obj!=null){
						   Field [] f=obj.getClass().getDeclaredFields();
						   json+="{";
						   for(int i=0;i<f.length;i++){
							   if(noF.indexOf(f[i].getName())>0)
								   continue;
							  String fieldname= f[i].getName();
							  Class cl=f[i].getType();
							   try {
									if(cl.getName().equals("int")){
										Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
										Integer v=(Integer) m.invoke(obj);
										json+="\""+fieldname+"\":\""+v+"\",";
									}
									else if(cl.getName().equals("java.lang.String")){
										Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
										String v=(String) m.invoke(obj);
										json+="\""+fieldname+"\":\""+v+"\",";
									}else if(cl.getName().equals("java.lang.Double")){
										Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
										Double v=(Double) m.invoke(obj);
										json+="\""+fieldname+"\":\""+v+"\",";
									}else if(cl.getName().equals("double")){
										Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
										Double v=(Double) m.invoke(obj);
										json+="\""+fieldname+"\":\""+v+"\",";
									}else if(cl.getName().equals("float")){
										Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
										Float v=(Float) m.invoke(obj);
										json+="\""+fieldname+"\":\""+v+"\",";
									}
								} catch (Exception exc) {
									//exc.printStackTrace();
								}
						   }
						   if(json.length()>0&&json.charAt(json.length()-1)==','){
							   json=json.substring(0, json.length()-1);
						   }
						   json+="},";
					  
					 
					   }
					   
				   }
				   if(json.length()>0&&json.charAt(json.length()-1)==','){
					   json=json.substring(0, json.length()-1);
				   }
				   jsons.append(json);
			   jsons.append("]");
		   return jsons;
		}
	/**
	 * 默认html
	 * @param response
	 * @param str
	 */
	public static void printl(HttpServletResponse response,String str){
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.write(str);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ResponseUtil.printl 出错");
		}
	}
	
	
	/**
	 * 自定义数据类型
	 * @param response
	 * @param str
	 * @param type
	 */
	public static void printl(HttpServletResponse response,String str,String type){
		try{
			//System.out.println("response_out:"+response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/"+type);
			PrintWriter out=response.getWriter();
			str=str.replace("\\", "");
			str=str.replaceAll("	", "");
			
			str=str.replaceAll("\r\n", "");
			out.write(str);
			out.flush();
			out.close();
			System.out.println(str);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ResponseUtil.printl 出错");
		}
	}
	/**
	 * 获取对象基础信息
	 * @param obj
	 * @return
	 */
	public static String getObjeJson(Object obj){

		String json="{";
		 Field [] f=obj.getClass().getDeclaredFields();
		   for(int i=0;i<f.length;i++){
			  String fieldname= f[i].getName();
			   try {
					Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
					if(f[i].getType().getName().equals("int")){
						Integer v=(Integer) m.invoke(obj);
						json+="\""+fieldname+"\":\""+v+"\",";
					}
					else if(f[i].getType().getName().equals("java.lang.String")){
						String v=(String) m.invoke(obj);
						json+="\""+fieldname+"\":\""+v+"\",";
					}else if(f[i].getType().getName().equals("java.lang.Double")){
						Double v=(Double) m.invoke(obj);
						json+="\""+fieldname+"\":\""+v+"\",";
					}
				} catch (Exception exc) {
				}
		   }
		   if(json.length()>0&&json.charAt(json.length()-1)==','){
			   json=json.substring(0, json.length()-1);
		   }
		json+="}";
		return json;
	}
	public static String getJsonVal(String name,String val){
		return "\""+name+"\":"+"\""+val+"\"";
	}
	public static StringBuffer getJsonListMap(List <HashMap> list){
		   StringBuffer json=new StringBuffer("[");
		   for(int i=0;i<list.size();i++){
			   HashMap map=list.get(i);
			   Set set=map.keySet();
			   Iterator it= set.iterator();
			   json.append("{");
			   while(it.hasNext()){
				   String key=(String) it.next();
				   Object val=(Object) map.get(key);
				   if(val instanceof String) {
					String v=(String) val;
					v=v.replaceAll("\"", "");
					 json.append("\""+key+"\":\""+v+"\",");
				   }else{
					   json.append("\""+key+"\":\""+val+"\",");

			   }}
			   if(json.charAt(json.length()-1)==','){
				   json.deleteCharAt(json.length()-1);
			   }
			   json.append("},");
			   }
		   if(json.charAt(json.length()-1)==','){
			   json.deleteCharAt(json.length()-1);
		   }
		   json.append("]");
		   return json;
		}
	public static StringBuffer getJson(PageInfo page,List <HashMap> list){
		String pageJson="{\"pageNo\":"+page.getPageNo()+",\"totalpage\":"+page.getTotalpage()+",";
			   pageJson+="\"totalcount\":"+page.getTotalCount()+",\"id\":\""+page.getId()+"\"}";
	   StringBuffer json=new StringBuffer("[{\"page\":"+pageJson+",\"data\":[");
	   for(int i=0;i<list.size();i++){
		   HashMap map=list.get(i);
		   Set set=map.keySet();
		   Iterator it= set.iterator();
		   json.append("{");
		   while(it.hasNext()){
			   String key=(String) it.next();
			   Object val=(Object) map.get(key);
			   if(val instanceof String) {
				String v=(String) val;
				v=v.replaceAll("\"", "");
				v=v.replaceAll("	", "");
				 json.append("\""+key+"\":\""+v+"\",");
			   }else{
				   json.append("\""+key+"\":\""+val+"\",");

		   }}
		   if(json.charAt(json.length()-1)==','){
			   json.deleteCharAt(json.length()-1);
		   }
		   json.append("},");
		   }
	   if(json.charAt(json.length()-1)==','){
		   json.deleteCharAt(json.length()-1);
	   }
	   json.append("]}]");
	   return json;
	}
}
