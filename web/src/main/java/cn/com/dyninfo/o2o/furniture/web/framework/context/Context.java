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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import cn.com.dyninfo.o2o.furniture.web.error.ParseTime;

import freemarker.template.Configuration;

public class Context {


	public static ServletContext context;
	
	public static Configuration freeMakercfg;
	
	public static Map freeMakerData;
	
	public static Map<String,Map<String,Map<String,String>>> pageList;
	
	
	public static String tempPath;
	
	public static String webPath;
	
	public static final String PASSWORDY="s+s_h_u";
	public static Map<String,String> regular;//访问地址正则匹配
	
	public final static String  COOKIE_AEAR_ID="_a_r_c";//COOKIE中保存的城市ID
	
	public final static String  BBS_ROLE_ADMIN="admin";//BBS角色 之 管理
	
	public final static String  BBS_ROLE_MEMBER="member";//BBS角色 之 会员
	
	public final static String COOKIE_CARS_ID="_c_g_p";//COOKIE中保存的购物车ID 
	
	public final static String SESSION_MEMBER="HUIYUANIFNO";//session中保存的当前登录用户
	
	public final static String SESSION_QQUSER = "QQUSER";; //session中保存的QQ用户
	
	public final static String SESSION_FORWORD="FORWORD";//登录之后跳转
	
	public final static String SESSION_AEAR="AEARINFO";//session中保存的当前城市
	
	public final static String COOKIE_CLIENT_ID="CLIENT_ID";//客户ID
	
	public final static String SESSION_TRADENO="TRADENO";//交易号
	
	public final static String COOKIE_CARS_DATA="_c_g_p_d";//COOKIE中购物车数据商品格式[货品ID;货品价格;货品数量:货品ID;货品价格;货品数量]
	
	public final static float PROPORTRION=0.05f;//归属会员在其他店铺购物获得的金额比例
	/**
	 * 获取当前系统日期和时间 
	 * @param ish true 详细时间 false 只获取日期
	 * @return
	 */
	public static String getCurrentTime(boolean ish){
		return new SimpleDateFormat("yyyy-MM-dd"+(ish?" HH:mm:ss":"")).format(new Date());
	}
	
	/**
	 * 获取当前系统日期和时间 Integert 
	 * @return
	 */
	public static int getCurrentTime(){
		return (int) (new Date().getTime()/1000);
	}
	
	/**
	 * 解析字符串格式时间为Integert
	 * @param time
	 * @return
	 */
	public static int parseTime(String time){
		try {
			if(time.length()==10)
				time+=" 00:00:00";
			return (int) (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			new ParseTime(time).printStackTrace();
		}
		return 0;
	}
}
