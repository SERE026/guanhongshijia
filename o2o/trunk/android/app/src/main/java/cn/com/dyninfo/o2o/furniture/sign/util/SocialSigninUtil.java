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

package cn.com.dyninfo.o2o.furniture.sign.util;

import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import android.content.Context;
import android.content.Intent;

public class SocialSigninUtil {
	private Context context;
	private BaseActivity baseActivity;

	/**
	 * @Description 社会化登录工具，主要是结果判断与处理
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-5-27 上午11:52:46
	 * @update 2014-9-15 14:19:41
	 */
	public SocialSigninUtil(Context context) {
		this.context = context;
		baseActivity = BaseActivity.getBaseActivityInstance(this.context);
	}

	/**
	 * @Description 社会化登录集中处理
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-15 下午2:16:43
	 */
	public void signin(String from, final String openid, final String headUrl, final String nickName) {
		BaseActivity.Log_info("正在执行社会化登录，昵称：" + nickName + "，来自：" + from);
		BaseActivity.cachedPool().execute(new Runnable() {

			@Override
			public void run() {

				LocalUser user = BaseActivity.getLastLocalUserInfoInstance(context);
				String json = SyncApi.SocialSignin(openid, headUrl, nickName);
				try {
					JSONObject object = APP.checkReturnData(json, context);
					if (object != null && object.has("status")) {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							user.json2db(json, context);
							user.psw = "";
							user.auto = 1;
							user.updateLocalUser();
							baseActivity.loadingDismiss();
							context.startActivity(new Intent(context, IndexActivity.class));
						} else if (object.getInt("status") == ErrorCode.ERROR)
							BaseActivity.Tip("登录失败");
					}
				} catch (Exception e) {
					APP.exception(" SigninUtil ", e);
				}

			}
		});
	}
}
