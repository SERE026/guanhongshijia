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

package cn.com.dyninfo.o2o.furniture.web.framework.context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginUser {

	private static int timeOut=1;//分钟
	private static Map<String,Integer> userTime;
	
	public static void addUser(String Login_id){
		if(userTime==null){
			userTime=new HashMap<String,Integer>();
		}
		userTime.put(Login_id, Context.getCurrentTime());
	}
	
	public static void updateUser(String Login_id){
		if(userTime!=null)
			userTime.put(Login_id, Context.getCurrentTime());
		else
			addUser(Login_id);
	}
	
	public static boolean checkUser(String Login_id){
		return userTime==null||userTime.get(Login_id)==null;
	}
	
	public static void exitUser(String login_id){
		userTime.remove(login_id);
	}
	
	public static void checkTimeout(){
		if(userTime!=null){
			int t=Context.getCurrentTime();
			Iterator<String> it=userTime.keySet().iterator();
			while(it.hasNext()){
				String key=it.next();
				if((userTime.get(key)+timeOut*60)<t){
					userTime.remove(key);
				}
			}
		}
	}
}
