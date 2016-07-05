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

package cn.com.dyninfo.o2o.furniture.activity.my;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 修改账户昵称
 * @created 2014-8-13 15:36:22 by <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update
 */
public class EditNickActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "修改昵称";
	private String tag = " AccountActivity ";
	private int layoutID = R.layout.edit_nick;
	private Context context;
	private Handler handler;
	private LocalUser user;
	private EditText nick;
	private TextView btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		user = getLastLocalUserInfoInstance(context);

		initView();
		initValue();
		nick.requestFocus();
		showKeyboard();
	}

	private void initView() {
		nick = (EditText) findViewById(R.id.nick);
		btn = (TextView) findViewById(R.id.btn);
		btn.setOnClickListener(this);
	}

	private void initValue() {
		nick.setText(user.name);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn:
			doPostNick();
			break;
		}
	}

	private void doPostNick() {
		if (getTextFromView(nick).isEmpty()) {
			Tip("新昵称不能为空");
			return;
		}
		if (getTextFromView(nick).equals(user.name)) {
			Tip("没有改动");
			return;
		}
		new Thread() {
			public void run() {
				Looper.prepare();
				loadingShow();
				// 开始修改昵称
				String json = SyncApi.updateNick(getTextFromView(nick));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							// TODO 更新本地账户昵称
							user.name = getTextFromView(nick);
							user.updateLocalUser();
							myfinish();
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							Tip("修改失败，请重试");
						}
					} catch (JSONException e) {
						APP.exception("修改昵称返回值异常", e);
					}
				} else {
					Tip("修改失败");
				}
				loadingDismiss();
			};
		}.start();
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

}