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

package cn.com.dyninfo.o2o.furniture.sign.tencent.weixin;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.sign.util.SocialSigninUtil;
import cn.com.dyninfo.o2o.furniture.util.APP;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/***
 * @Description 微信登录工具
 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
 *          2014-9-15 上午11:01:37
 */
public class WeixinSignUtil {
	private Context context;
	private IWXAPI weixin;

	public WeixinSignUtil(Context context) {
		this.context = context;
		init();
	}

	public void init() {
		if (weixin == null) {
			weixin = WXAPIFactory.createWXAPI(context, WeixinConstants.APP_ID, true);
			weixin.registerApp(WeixinConstants.APP_ID);
		}
	}

	/**
	 * @Description 发起登录请求
	 */
	public void signin() {
		SendAuth.Req req = new SendAuth.Req();
		req.scope = "snsapi_userinfo";// 接口名
		req.state = WeixinConstants.STATE;
		weixin.sendReq(req);
	}

	/**
	 * @Description 处理微信登录结果
	 */
	public void decodeResult(final SendAuth.Resp response) {
		if (response.state.equals(WeixinConstants.STATE)) {// 这句话可以不要，校验来源用
			BaseActivity.cachedPool().execute(new Runnable() {

				@Override
				public void run() {
					// 获取token
					String json = SyncApi.getWeixinToken(response.code);
					JSONObject object = APP.checkReturnData(json, context);
					if (object != null) {
						try {
							String openid = object.getString("openid");
							// 获取账户信息
							String info = SyncApi.getWeixinAcInfo(object.getString("access_token"), openid);
							JSONObject infoObject = APP.checkReturnData(info, context);
							if (infoObject != null) {
								String nick = infoObject.getString("nickname");
								String head = infoObject.getString("headimgurl");
								// 交给统一工具处理
								new SocialSigninUtil(context).signin("微信", "weixin_" + openid, head, nick);
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}

}
