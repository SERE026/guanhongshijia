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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 获取对象详细表
 * @author 王敏
 *	Dec 7, 2012
 */
public class UtilGetObject {
	
		                        
	                        
public static String getObjeJson(Object obj,Map map,int lev){
	if(lev<=4){
		String noS=map.get(lev)+"";
		String json="{";
		 Field [] f=null;
		 if(obj.getClass().getName().indexOf("_$$_javassist_")>0){
			 String className=obj.getClass().getName();
			 className=className.substring(0, className.indexOf("_$$_javassist_"));

			 try {
				f=Class.forName(className).getDeclaredFields();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		 }else{
			 f=obj.getClass().getDeclaredFields();
		 }
		 String  className=obj.getClass().getName();
		 if(className.indexOf("_$$_")>0)
			 className=className.substring(0,className.indexOf("_$$_"));
		 className=className.substring(className.lastIndexOf(".")+1);
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
					}else if(f[i].getType().getName().equals("java.util.List")&&map.get(className+".LIST")==null){
						if(noS.indexOf(f[i].getName())<0&&map.get(m.getName())==null){
							List v=(List) m.invoke(obj);
							String nextnoS=map.get((lev+1))+""+obj.getClass().getName();
							map.put((lev+1), nextnoS);
							if(lev<5){
								json+="\""+fieldname+"\":"+getJson(v,map,(lev+1)).toString()+",";
							}else{
								json+="\""+fieldname+"\":\"\",";
							}
						}
					}else if(f[i].getType().getName().indexOf("com.")>=0&&map.get(className+".OBJECT")==null){
						if(!noS.equals(f[i].getType().getName())&&map.get(m.getName())==null){
							Object v= m.invoke(obj);
							if(v==null)
								v=f[i].getType().newInstance();
							String nextnoS=obj.getClass().getName();
							map.put((lev+1), nextnoS);
							if(lev<5){
								if(map.get(m.getName())==null){
									json+="\""+fieldname+"\":"+getObjeJson(v,map,(lev+1))+",";
								}else{
									json+="\""+fieldname+"\":\"\",";
								}
									
								}else{
									json+="\""+fieldname+"\":\"\",";
								}
							}
					}
					
				} catch (Exception exc) {
				}
		   }
		   if(json.length()>0&&json.charAt(json.length()-1)==','){
			   json=json.substring(0, json.length()-1);
		   }
		json+="}";
		return json;
		
		}else{
			return "{}";
		}
	}

public static String getObjJson(Object obj,Map map,int lev){
	if(lev<=4){
	String noS=map.get(lev)+"";
	String json="{";
	 Field [] f=null;
	 if(obj.getClass().getName().indexOf("_$$_javassist_")>0){
		 String className=obj.getClass().getName();
		 className=className.substring(0, className.indexOf("_$$_javassist_"));

		 try {
			f=Class.forName(className).getDeclaredFields();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	 }else{
		 f=obj.getClass().getDeclaredFields();
	 }
	 String  className=obj.getClass().getName();
	 if(className.indexOf("_$$_")>0)
		 className=className.substring(0,className.indexOf("_$$_"));
	 className=className.substring(className.lastIndexOf(".")+1);
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
				}else if(f[i].getType().getName().indexOf("com.")>=0&&map.get(className+"."+m.getName())!=null){
					if(!noS.equals(f[i].getType().getName())&&map.get(m.getName())==null){
						Object v= m.invoke(obj);
						if(v==null)
							v=f[i].getType().newInstance();
						String nextnoS=obj.getClass().getName();
						map.put((lev+1), nextnoS);
						if(lev<5){
							if(map.get(m.getName())==null){
								json+="\""+fieldname+"\":"+getObjeJson(v,map,(lev+1))+",";
							}else{
								json+="\""+fieldname+"\":\"\",";
							}
								
							}else{
								json+="\""+fieldname+"\":\"\",";
							}
						}
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
	return "{}";
}
public static StringBuffer getJson(List val,Map map,int lev){
		String noS=map.get(lev)+"";
	    StringBuffer jsons=new StringBuffer("[");
	    String json="";
	    if(lev<=4){
	    for(Object obj:val){
				    String  className=obj.getClass().getName();
					 if(className.indexOf("_$$_")>0)
						 className=className.substring(0,className.indexOf("_$$_"));
					 className=className.substring(className.lastIndexOf(".")+1);
				   if(obj!=null){
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
								}else if(f[i].getType().getName().equals("double")){
									Double v=(Double) m.invoke(obj);
									json+="\""+fieldname+"\":\""+v+"\",";
								}else if(f[i].getType().getName().equals("java.util.List")&&map.get(className+".LIST")==null){
									if(noS.indexOf(f[i].getName())<0&&map.get(m.getName())==null){
										List v=(List) m.invoke(obj);
										json+="\""+fieldname+"\":"+getJson(v,map,(lev+1)).toString()+",";
									}
								}else if(f[i].getType().getName().indexOf("com.")>=0&&map.get(className+".OBJECT")==null){
									String fName=f[i].getType().getName();
									if(fName.indexOf("_$$_")>0)
										fName=fName.substring(0,fName.indexOf("_$$_"));
									if(noS.indexOf(fName)<0&&map.get(m.getName())==null){
										Object v= m.invoke(obj);
										map.put((lev+1), obj.getClass().getName());
										json+="\""+fieldname+"\":"+getObjeJson(v,map,(lev+1))+",";
									}
								}
							} catch (Exception exc) {
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
	    }else{
	    	jsons.append("]");
	    	return jsons;
	    }
	}


	public static String getBusJson(Object obj,String fieds[]){
			Class cl=obj.getClass();
			if(obj.getClass().getName().indexOf("_$$_javassist_")>0){
				 String className=obj.getClass().getName();
				 className=className.substring(0, className.indexOf("_$$_javassist_"));
				 try {
					 cl=Class.forName(className);
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		
			String result="{";
			if(fieds!=null&&fieds.length>0){
				for(String fields:fieds){
					if(fields==null)
						continue;
					fields=fields.replace("-", ".");
					String files[]=fields.split("\\.");
					String fName=files[0];
					if(fName.length()>0&&fields.indexOf(fName)==0){
						String methodName=fName.charAt(0)+"";
						methodName=methodName.toUpperCase();
						methodName+=fName.substring(1, fName.length());
						try {
							Field field=cl.getDeclaredField(fName);
							if(field.getType().getName().equals("java.util.List")){
								Method m=cl.getMethod("get"+methodName);
								List list=(List) m.invoke(obj);
								fields=fields.replace(fName+".", "");
								String fieds2[]=fields.split("$"+fName+"$");
								result+="\""+fName+"\":"+getListJson(list,fieds2)+",";
							}else{
								Method m=cl.getMethod("get"+methodName);
								Object mobj=m.invoke(obj);
								fields=fields.replace(fName+".", "");
								String fieds2[]=fields.split("="+fName+"=");
								if(mobj==null)
									mobj=field.getType().newInstance();
								result+="\""+fName+"\":"+getBusJson(mobj,fieds2)+",";
							}
						} catch (Exception e) {
							//e.printStackTrace();
						} 
					}
					
				}
			}
			Field [] f=null;
			if(obj.getClass().getName().indexOf("_$$_javassist_")>0){
				 String className=obj.getClass().getName();
				 className=className.substring(0, className.indexOf("_$$_javassist_"));
				 try {
					f=Class.forName(className).getDeclaredFields();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}else{
				f=obj.getClass().getDeclaredFields();
			}
			 for(int i=0;i<f.length;i++){
				  String fieldname= f[i].getName();
				   try {
						Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
						if(f[i].getType().getName().equals("int")){
							if(obj.getClass().getName().indexOf("Products")<0&&f[i].getAnnotation(Transient.class)==null){
								Integer v=(Integer) m.invoke(obj);
								result+="\""+fieldname+"\":\""+v+"\",";
							}
						}
						else if(f[i].getType().getName().equals("java.lang.String")){
							String v=(String) m.invoke(obj);
							result+="\""+fieldname+"\":\""+v+"\",";
						}else if(f[i].getType().getName().equals("java.lang.Double")){
							Double v=(Double) m.invoke(obj);
							result+="\""+fieldname+"\":\""+v+"\",";
						}
				   }catch(Exception e){
					   }
			 }
			if(result.length()>1)
				result=result.substring(0,result.length()-1);
			result+="}";
			return result;
		}

	public static String getObjeJson(Object obj,String fieds[]){
		String result="{";
		if(fieds!=null&&fieds.length>0){
			for(String fields:fieds){
				if(fields==null)
					System.out.print("");
				fields=fields.replace("-", ".");
				String files[]=fields.split("\\.");
				String fName=files[0];
				if(fName.length()>0&&fields.indexOf(fName)==0){
					String methodName=fName.charAt(0)+"";
					methodName=methodName.toUpperCase();
					methodName+=fName.substring(1, fName.length());
					try {
						Field field=obj.getClass().getDeclaredField(fName);
						if(field.getType().getName().equals("java.util.List")){
							Method m=obj.getClass().getMethod("get"+methodName);
							List list=(List) m.invoke(obj);
							fields=fields.replace(fName+".", "");
							String fieds2[]=fields.split("$"+fName+"$");
							result+="\""+fName+"\":"+getListJson(list,fieds2)+",";
						}else{
							Method m=obj.getClass().getMethod("get"+methodName);
							Object mobj=m.invoke(obj);
							String fieds2[]=new String[files.length-1];
							for(int i=0;i<fieds2.length;i++){
								fieds2[i]=files[i+1];
							}
							if(mobj==null)
								mobj=field.getType().newInstance();
							result+="\""+fName+"\":"+getObjeJson(mobj,fieds2)+",";
						}
					} catch (Exception e) {
						//e.printStackTrace();
					} 
				}
				
			}
		}
		Field [] f=null;
		if(obj.getClass().getName().indexOf("_$$_javassist_")>0){
			 String className=obj.getClass().getName();
			 className=className.substring(0, className.indexOf("_$$_javassist_"));
			 try {
				f=Class.forName(className).getDeclaredFields();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}else{
			f=obj.getClass().getDeclaredFields();
		}
		 for(int i=0;i<f.length;i++){
			  String fieldname= f[i].getName();
			   try {
					Method m=obj.getClass().getMethod("get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1));
					if(f[i].getType().getName().equals("int")){
						if(obj.getClass().getName().indexOf("Products")<0&&f[i].getAnnotation(Transient.class)==null){
							Integer v=(Integer) m.invoke(obj);
							result+="\""+fieldname+"\":\""+v+"\",";
						}
					}
					else if(f[i].getType().getName().equals("java.lang.String")){
						String v=(String) m.invoke(obj);
						result+="\""+fieldname+"\":\""+v+"\",";
					}else if(f[i].getType().getName().equals("java.lang.Double")){
						Double v=(Double) m.invoke(obj);
						result+="\""+fieldname+"\":\""+v+"\",";
					}
			   }catch(Exception e){
				   }
		 }
		if(result.length()>1)
			result=result.substring(0,result.length()-1);
		result+="}";
		return result;
	}
	public static String getListJson(List list,String fieds[]){
		String result="[";
		for(Object obj:list){
			result+=getObjeJson(obj,fieds)+",";
			
		}
		if(result.length()>1)
			result=result.substring(0,result.length()-1);
		result+="]";
		return result;
	}
	
	
}
