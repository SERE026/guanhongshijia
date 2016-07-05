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

import java.util.LinkedList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;

import android.app.Activity;
import android.app.Application;

/**
 * @Description 管理全部activity
 * @Tip 创建activity时调用 APPManager.getInstance().addActivity(this); <br>
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-25 上午11:22:11
 * @update 2014-7-3 16:06:08 优化：不结束baseactivity 和 indexactivity
 */
public class APPManager extends Application {
	private List<Activity> activityList = new LinkedList<Activity>();
	private static APPManager instance;

	private APPManager() {

	}

	/** @author <a href="http://t.cn/RvIApP5">ceychen</a> */
	public static APPManager getInstance() {
		if (instance == null) {
			synchronized (APPManager.class) {
				if (instance == null)
					instance = new APPManager();
			}
		}
		return instance;
	}

	public void add(Activity activity) {
		activityList.add(activity);
	}

	/**
	 * @Description 不结束主 activity
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public void finish() {
		for (Activity activity : activityList) {
			if (activity.getClass().getName().equals(BaseActivity.class.getName())
					|| activity.getClass().getName().equals(IndexActivity.class.getName())) {
				// 如果是 BaseActivity 或者 IndexActivity 则跳过
			} else {
				activity.finish();
			}
		}
		System.gc();
	}

	public void finishAll() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.gc();
	}

	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.gc();
		System.exit(0);
	}

	public List<Activity> getList() {
		return activityList;
	}
}
