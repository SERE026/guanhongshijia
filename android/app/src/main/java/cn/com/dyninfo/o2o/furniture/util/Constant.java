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

/**
 * 
 * @author ly
 * 
 */
public class Constant {

	public static double lat = 0;
	public static double lng = 0;

	public static String service = APP.host;

	/***************************** 接口 *****************************/
	public static String add = service + "/html/";

	/**
	 * 身边美容院 lon:经度 lat:纬度 pageno:页码
	 */
	public static String at_beauty = add + "ashop/nearshop";

	/**
	 * 获取游戏参数
	 */
	public static String addgameInfo = add + "aactive/addgameInfo";

	/**
	 * 实体商家 id:地区编号
	 */
	public static String side = add + "ashop/list";

	/**
	 * 查询配送方式
	 */
	// public static String queryDistribution = service
	// +
	// "/widget.html?action=phone&widget=confirmOrder&dataType=json&event=queryYF&memberId=";

	/**
	 * 创建订单
	 */
	// public static String createOrder = service
	// +
	// "/widget.html?action=phone&widget=confirmOrder&dataType=json&event=create&memberId=";

}
