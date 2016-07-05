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

package cn.com.dyninfo.o2o.furniture.db;

import android.content.Context;

/**
 * @Description 
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-16 上午10:38:51 
 */
public class DatabaseApi extends DatabaseAccess {
	private static DatabaseApi dbApi = null;
	public final int limitnum = 10;

	// 用户数据
	String[] UserField = new String[] { "uid", "name", "sex", "addr", "phone" };

	private DatabaseApi(Context context) {
		super(context);
	}

	public static DatabaseApi getDataBaseApi(Context context) {
		if (dbApi == null) {
			dbApi = new DatabaseApi(context);
		}
		return dbApi;
	}
}
