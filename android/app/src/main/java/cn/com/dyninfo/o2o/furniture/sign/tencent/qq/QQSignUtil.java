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

package cn.com.dyninfo.o2o.furniture.sign.tencent.qq;

import org.json.JSONException;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.sign.util.SocialSigninUtil;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * @Description 保存QQ账户登录信息
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-26 下午2:10:53
 * @update 2014-6-10 12:44:13
 */
public class QQSignUtil {

	private Context context;
	private int sex = 0;
	private SharedPreferences sp;
	private Activity activity;
	private QQAuth qqAuth;
	private UserInfo mInfo;
	private Tencent tencent;
	private String openid;

	public QQSignUtil(Context context, Activity activity, SharedPreferences sp) {
		this.context = context;
		this.activity = activity;
		this.sp = sp;
		qqAuth = QQAuth.createInstance(QQConstants.APP_ID, context);
		tencent = Tencent.createInstance(QQConstants.APP_ID, activity);
	}

	public void saveQQSignInfoToLocal(Context context, String openid, String token, int time_in) {
		Editor editor = sp.edit();
		editor.putString("qquid", openid);
		editor.putString("token", token);
		editor.putInt("time_in", time_in);
		editor.commit();
	}

	/**
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				JSONObject json = (JSONObject) msg.obj;
				if (json.has("nickname")) {
					try {
						BaseActivity.Log_info("当前登录账户：" + json.getString("nickname") + "，性别："
								+ json.getString("gender"));
						// sex = json.getString("gender").equals("女") ? 2 : 1;
						// 社会化工具统一处理
						new SocialSigninUtil(context).signin("QQ", "qq_" + openid, json.getString("figureurl_qq_2"),
								json.getString("nickname"));
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} else if (msg.what == 1) {
				// Bitmap bitmap = (Bitmap) msg.obj;
			}
		}
	};

	private void updateUserInfo() {
		if (qqAuth != null && qqAuth.isSessionValid()) {
			IUiListener listener = new IUiListener() {
				@Override
				public void onError(UiError e) {
					Log.e(" QQSignUtil ", e.errorMessage);
				}

				@Override
				public void onComplete(final Object response) {
					Message msg = new Message();
					msg.obj = response;
					msg.what = 0;
					mHandler.sendMessage(msg);
					// new Thread() {
					// @Override
					// public void run() {
					// JSONObject json = (JSONObject) response;
					// if (json.has("figureurl")) {
					// Bitmap bitmap = null;
					// try {
					// bitmap =
					// QQUtil.getbitmap(json.getString("figureurl_qq_2"));
					// } catch (JSONException e) {
					// }
					// Message msg = new Message();
					// msg.obj = bitmap;
					// msg.what = 1;
					// mHandler.sendMessage(msg);
					// }
					// }
					// }.start();
				}

				@Override
				public void onCancel() {
					// BaseActivity.Tip("IUiListener onCancel");
				}
			};
			mInfo = new UserInfo(context, qqAuth.getQQToken());
			mInfo.getUserInfo(listener);
		}
	}

	/**
	 * @Description: 登录结果处理
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @version V1.0
	 */
	class QQUiListener implements IUiListener {
		@Override
		public void onComplete(Object response) {
			// System.out.println("获取授权成功" + response.toString());
			try {
				JSONObject object = new JSONObject(response.toString());
				if (object.has("ret")) {
					String token = object.getString("access_token");
					openid = object.getString("openid");
					int time_in = object.getInt("expires_in");
					saveQQSignInfoToLocal(context, openid, token, time_in);
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
			doComplete((JSONObject) response);
		}

		protected void doComplete(JSONObject values) {

		}

		@Override
		public void onError(UiError e) {
			System.out.println("QQUiListener onError");
			QQUtil.dismissDialog();
		}

		@Override
		public void onCancel() {
			System.out.println("QQUiListener onCancel");
			QQUtil.dismissDialog();
		}
	}

	public void startSign() {
		if (!qqAuth.isSessionValid()) {
			IUiListener listener = new QQUiListener() {
				@Override
				protected void doComplete(JSONObject values) {
					updateUserInfo();
				}
			};
			tencent.login(activity, "all", listener);
		} else {
			qqAuth.logout(activity);
			updateUserInfo();
		}
	}

}
