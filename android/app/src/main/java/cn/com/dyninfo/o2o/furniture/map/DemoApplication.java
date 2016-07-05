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

package cn.com.dyninfo.o2o.furniture.map;

import android.app.Application;
import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

/**
 * 
 * @author ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a><br>
 *         2014-7-8 09:54:08 更新配置
 */
public class DemoApplication extends Application {

	private static DemoApplication mInstance = null;
	public static boolean m_bKeyRight = true;
	public BMapManager mBMapManager = null;

	@Override
	public void onCreate() {
		mInstance = this;
		initEngineManager(this);
		super.onCreate();
	}

	public void initEngineManager(Context context) {
		if (mBMapManager == null) {
			mBMapManager = new BMapManager(context);
		}

		if (!mBMapManager.init(new MyGeneralListener())) {
			BaseActivity.Tip("地图加载出错");
		}
	}

	public static DemoApplication getInstance() {
		return mInstance;
	}

	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
	public static class MyGeneralListener implements MKGeneralListener {

		@Override
		public void onGetNetworkState(int iError) {
			if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
				BaseActivity.Tip("网络出错");
			} else if (iError == MKEvent.ERROR_NETWORK_DATA) {
				BaseActivity.Tip("检索条件有误");
			}
		}

		@Override
		public void onGetPermissionState(int iError) {
			// 非零值表示key验证未通过
			if (iError != 0) {
				// 授权Key错误：
				BaseActivity.Tip("地图配置有误");
				m_bKeyRight = false;
			} else {
				m_bKeyRight = true;
			}
		}
	}
}