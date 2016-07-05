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

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Description 保存异常到内存卡目录
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
 *          2014-8-11 下午5:09:55
 */
public class SaveLog {
	public static void save(String txt, String name) {
		try {
			FileOutputStream outStream = new FileOutputStream(Util.APK_LOG_PATH + name + ".log", true);
			OutputStreamWriter writer = new OutputStreamWriter(outStream, "utf-8");
			writer.write(txt);
			writer.flush();
			writer.close();
			outStream.close();
		} catch (Exception e) {
			APP.exception("保存log到内存卡异常", e);
		}
	}
}