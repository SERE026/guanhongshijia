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

package cn.com.dyninfo.o2o.furniture.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.service.PullNoticesService;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.util.Util;

/**
 * @Description 每次启动时的欢迎页
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @date 2014-4-21 15:34:26
 * @updated 2014-8-28 10:43:49 更新向导机制
 */
public class WelcomeActivity extends BaseActivity {

	private Context context;
	private String tag = "WelcomeActivity";
	private Class<?> cls;
	private static final int GOTO_MAIN_ACTIVITY = 001;
	private static final int TIMEOUT = 1500; // 延迟跳转时间
	LocationClient mLocationClient;
	private int verCode = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		context = this;
		VerInfo();
		startService(new Intent(context, PullNoticesService.class));
		checkSDCard();
		checkLocalUser();
		checkCachePath();
		checkGuide();
		baiduMap();

	}

	private void VerInfo() {
		String vername = "";
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			vername = info.versionName;
			verCode = info.versionCode;
		} catch (NameNotFoundException e) {
		}
		((TextView) findViewById(R.id.ver)).setText(vername);
	}

	public void baiduMap() {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				mLocationClient = new LocationClient(context.getApplicationContext());
				MyLocationListenner myListener = new MyLocationListenner();
				mLocationClient.registerLocationListener(myListener);
				mLocationClient.start();
				LocationClientOption option = new LocationClientOption();
				option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度，默认值gcj02
				mLocationClient.setLocOption(option);
				mLocationClient.requestLocation();
			}
		}, 500);
	}

	/**
	 * 定位信息
	 */
	public class MyLocationListenner implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;
			Constant.lat = location.getLatitude();
			Constant.lng = location.getLongitude();
		}

		public void onReceivePoi(BDLocation poiLocation) {
			if (poiLocation == null) {
				return;
			}
			Constant.lat = poiLocation.getLatitude();
			Constant.lng = poiLocation.getLongitude();
		}
	}

	private void checkCachePath() {
		Util util = Util.getInstance(context);
		// 检查缓存路径
		util.init_path();

		// 删除分享时的临时图片
		Sys.deleteAllFilesOfDir(Util.IMG_SHARE_PATH, false);
	}

	private void checkLocalUser() {
		LocalUser user = getLastLocalUserInfoInstance(context);
		if (user.auto == 1) {
			user.delete();
		} else {
			// 设置为未登录状态，(自动)登录后将设置为0
			user.signed = 1;
			user.updateLocalUser();
		}
	}

	private void checkSDCard() {
		if (!Sys.isSDcardExist()) {
			Tip("建议装载外置存储卡");
		}
	}

	private void checkNetStatus() {
		if (!Sys.CheckNetworkState(context, false))
			Sys.confirmSetNetwork(context);
		else
			// 开始跳转
			mHandler.sendMessageDelayed(mHandler.obtainMessage(GOTO_MAIN_ACTIVITY), TIMEOUT);
	}

	private void checkGuide() {
		cls = IndexActivity.class;
		SharedPreferences used = getSharedPreferences(APPCode.USED, 0);
		try {
			if (verCode > used.getInt("code", 0)) {
				cls = GuideActivity.class;
				// 强制必须看完引导，没看完，下次启动继续看
				// used.edit().putBoolean("used", true).putInt("code",
				// verCode).commit();//不强制
			} else
				cls = IndexActivity.class;
		} catch (Exception e) {
			APP.exception(tag + " checkGuide ", e);
		}
	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GOTO_MAIN_ACTIVITY:
				Intent intent = new Intent();
				intent.setClass(context, cls);
				startActivity(intent);
				animLeftToRight();
				finish();
				System.gc();
				break;
			}
		}
	};

	@Override
	protected void onResume() {
		checkNetStatus();
		super.onResume();
	};
}