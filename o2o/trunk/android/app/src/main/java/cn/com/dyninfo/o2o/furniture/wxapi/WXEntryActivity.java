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

package cn.com.dyninfo.o2o.furniture.wxapi;

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.sign.tencent.weixin.WeixinConstants;
import cn.com.dyninfo.o2o.furniture.sign.tencent.weixin.WeixinSignUtil;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import android.os.Bundle;

/**
 * @Description 微信客户端回调
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @created 2014-7-18 10:07:52 实现分享
 * @updated 2014-9-15 15:05:57 实现微信登录
 */
public class WXEntryActivity extends BaseActivity implements IWXAPIEventHandler {

	private IWXAPI weixin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weixin_layout);

		weixin = WXAPIFactory.createWXAPI(this, WeixinConstants.APP_ID, true);
		weixin.registerApp(WeixinConstants.APP_ID);

		weixin.handleIntent(getIntent(), this);
	}

	@Override
	public void onReq(BaseReq req) {
		back();
	}

	/************ 接收微信处理结果 *******************/
	@Override
	public void onResp(BaseResp resp) {
		BaseActivity.Log_info("微信 onResp");

		switch (resp.errCode) {
		case BaseResp.ErrCode.ERR_OK:
			switch (resp.getType()) {
			// 授权
			case ConstantsAPI.COMMAND_SENDAUTH:
				new WeixinSignUtil(context).decodeResult((SendAuth.Resp) resp);
				break;
			}
			break;
		case BaseResp.ErrCode.ERR_USER_CANCEL:
			// BaseActivity.Tip("请不要取消授权");
			break;
		case BaseResp.ErrCode.ERR_AUTH_DENIED:
			// BaseActivity.Tip("请不要拒绝授权");
			break;
		}

		back();
	}

	/**
	 * @Description 发送/处理请求后关闭页面，让用户感觉不到这个页面存在
	 */
	private void back() {
		myfinish();
	}
}
