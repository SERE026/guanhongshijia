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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilTag {

	public UtilTag(){
		System.out.println("创建对象");
	}
	public static void main(String[] args) {
		Method methods[]= UtilTag.class.getMethods();
		for(Method method:methods){
			System.out.println(method.getName());
		}
	}
	
	public static String parseSpecValue(Object obj,Integer item){
		Method m;
		try {
			m = obj.getClass().getMethod("getSpecValue"+item);
			String result=(String) m.invoke(obj);
			return result;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
