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

import android.util.Base64;

/**
 * @Description ECB(Base64)加密解密
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-6-4 下午1:32:40
 */
public class ECBUtil {

	/**
	 * @Description 加密
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static String encode(String str) {
		return Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
	}

	/**
	 * @Description 解密
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static String decode(String str) {
		byte b[] = Base64.decode(str, Base64.DEFAULT);
		return new String(b);
	}
	/**
	 * @Description 解密
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static byte[] decode(byte[] b) {
		return Base64.decode(b,  Base64.DEFAULT);
	}
	/**
	 * @Description 解密
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public static byte[] decodeToByte(String str) {
		return Base64.decode(str,  Base64.DEFAULT);
	}
	
}