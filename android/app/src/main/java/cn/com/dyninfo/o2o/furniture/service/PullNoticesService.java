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

package cn.com.dyninfo.o2o.furniture.service;

import java.util.Timer;
import java.util.TimerTask;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.MyDate;

/**
 * @Description 每15分钟拉取一次系统消息
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-6-21 下午5:05:53
 * @update 2014-8-20 16:22:02 修改为15分钟一次
 */
public class PullNoticesService extends Service {

	private Context context;
	private Handler handler;
	private SharedPreferences sp;
	private static final String tag = "PullNoticesService";
	private IBinder binder = new PullNoticesService.LocalBinder();
	private NotificationManager manager;
	private Notification notification;
	private Intent intent;
	private PendingIntent contentIntent;

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}

	@Override
	public void onCreate() {
		context = getApplicationContext();
		handler = new Handler();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// send("后台服务运行中", "这是来自炫品妆成的消息");

		fuckingPull();

		return super.onStartCommand(intent, flags, startId);
	}

	void fuckingPull() {
		// 定时拉取
		Timer timer = new Timer();
		timer.schedule(new fuckingTask(), 0, 15 * 60 * 1000);// 0 秒后开始执行，每隔 15 分钟
	}

	class fuckingTask extends TimerTask {
		@Override
		public void run() {

			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					System.out.println("炫品妆成服务运行中：" + MyDate.getDateCNSSS());
					sp = context.getSharedPreferences(APPCode.DATE, MODE_APPEND);
					new Thread() {
						public void run() {
							handler.post(new Runnable() {

								@Override
								public void run() {

									String json = SyncApi.pullNotices(sp.getString("id", "0"),
											sp.getString("date", MyDate.getDate()));
									JSONObject object = APP.checkReturnData(json, context);
									if (object != null && object.has("status")) {
										try {
											if (object.getInt("status") == ErrorCode.SUCCESS) {
												JSONArray array = object.getJSONArray("data");
												if (array.length() > 0) {
													object = array.getJSONObject(0);
													send(object.getString("title"), object.getString("context"));
													sp.edit().putString("date", MyDate.getDate())
															.putString("id", object.getString("messagesend_id"))
															.commit();
												}
											} else if (object.getInt("status") == ErrorCode.ERROR) {
												Log.e(tag, "拉取到的系统消息数据存在错误或者没有更新的推送");
											}
										} catch (Exception e) {
											Log.e(tag, "拉取到的系统消息解析失败");
											APP.exception(tag, e);
										}
									}

								}
							});
						};
					}.start();
				}
			}, 10000);

		}
	}

	protected void send(String title, String content) {
		if (manager == null)
			manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//		notification = new Notification(R.drawable.xuan_logo, "来自 炫品妆成 的消息", System.currentTimeMillis());
//		intent = new Intent(context, MessagesActivity.class);
//		contentIntent = PendingIntent.getActivity(context, 100, intent, 0);
//		notification.setLatestEventInfo(context, title, content, contentIntent);
//		notification.flags = Notification.FLAG_AUTO_CANCEL;

		Notification.Builder builder = new Notification.Builder(this);//新建Notification.Builder对象
//PendingIntent点击通知后所跳转的页面
		builder.setContentTitle("来自 炫品妆成 的消息");
		builder.setContentText(content);
		builder.setSmallIcon(R.drawable.xuan_logo);
		builder.setContentIntent(contentIntent);//执行intent
		Notification notification = builder.getNotification();//将builder对象转换为普通的notification
		notification.flags |= Notification.FLAG_AUTO_CANCEL;//点击通知后通知消失

		manager.notify(9527, notification);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public class LocalBinder extends Binder {
		PullNoticesService getService() {
			return PullNoticesService.this;
		}
	}
}
