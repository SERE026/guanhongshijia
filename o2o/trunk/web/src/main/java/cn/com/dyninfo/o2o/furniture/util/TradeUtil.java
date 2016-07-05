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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 交易工具类
 * @author Zebe
 * @date 2014/4/15
 * @update 2014/4/16
 *
 */
public class TradeUtil {

	// 转换工具类引用
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

	/**
	 * 生成16位交易号
	 * @return 16位数字字符串，格式为年月日时分秒 + 随机数字
	 */
	public static String createTradeNumber() {
		String prefix = sdf.format(new Date()); // 14位前缀
		String suffix = getRndNumber(2); // 2位随机数字
		return prefix + suffix;
	}

	/**
	 * 生成任意大于14位的交易号
	 * @param length 交易号长度
	 * @return 长度为 length 的数字字符串，格式为年月日时分秒 + 随机数字
	 */
	public static String createTradeNumber(int length) {
		String prefix = sdf.format(new Date()); // 14位前缀
		String suffix = "";
		if (length <= 14) {
			return null;
		} else {
			suffix = getRndNumber(length - prefix.length());
			return prefix + suffix;
		}
	}
	
	/**
	 * 生成指定长度的随机数组成的字符串
	 * @param length 随机数长度
	 * @return 长度为 length 的随机数字字符串
	 */
	private static String getRndNumber(int length) {
		Random r = new Random(); 
		StringBuffer rnd = new StringBuffer();
		for (int i=1; i<=length; i++) {
			rnd.append(r.nextInt(9));
		}
		return rnd.toString();
	}
	

}
