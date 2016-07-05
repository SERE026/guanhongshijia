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

import android.util.Log;

/**
 * 
 * @Description LBS常用工具
 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
 *          2014-8-28 下午2:05:48
 * @read http://www.cnblogs.com/ycsfwhh/archive/2010/12/20/1911232.html
 */
public class LBS {
	private static double EARTH_RADIUS = 6378.137;// 地球半径
	private static NumArithmetic num = new NumArithmetic();

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * @Description 计算2个经纬度点间距离
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-28 下午2:20:08
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {

		Log.i("计算地球两点距离", "位置1: " + lng1 + "," + lat1 + " ， 位置2: " + lng2 + "," + lat2);
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);

		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		try {
			s = num.div(s, 1.0, 2);
		} catch (Exception e) {
			s = Math.round(s * 10000) / 10000;
		}
		return s;
	}
}
