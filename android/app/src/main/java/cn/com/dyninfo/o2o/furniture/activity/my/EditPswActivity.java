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
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 修改账户密码
 * @created 2014-8-13 16:10:14 by <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update
 */
public class EditPswActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "修改密码";
	private String tag = " AccountActivity ";
	private int layoutID = R.layout.edit_psw;
	private Context context;
	private Handler handler;
	private EditText old, now, renow;
	private TextView btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);

		initView();
		old.requestFocus();
		showKeyboard();
	}

	private void initView() {
		old = (EditText) findViewById(R.id.old);
		now = (EditText) findViewById(R.id.now);
		renow = (EditText) findViewById(R.id.renow);
		btn = (TextView) findViewById(R.id.btn);
		btn.setOnClickListener(this);
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
		if (getTextFromView(old).isEmpty()) {
			Tip("密码不能为空");
			return;
		}
		if (!getTextFromView(now).equals(getTextFromView(renow))) {
			Tip("两次输入不一致");
			return;
		}
		if (getTextFromView(old).equals(getTextFromView(now))) {
			Tip("新旧密码相同");
			return;
		}
		new Thread() {
			public void run() {
				Looper.prepare();
				loadingShow();
				// 开始修改密码
				String json = SyncApi.updatePsw(getTextFromView(old), getTextFromView(now));
				JSONObject object = APP.checkReturnData(json, context);
				if (object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							// TODO 返回
							myfinish();
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							Tip("修改失败，请重试");
						}
					} catch (JSONException e) {
						APP.exception("修改密码返回值异常", e);
					}
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