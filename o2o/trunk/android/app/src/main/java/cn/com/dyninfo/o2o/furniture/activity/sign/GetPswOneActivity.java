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

package cn.com.dyninfo.o2o.furniture.activity.sign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APP;

/**
 * @ClassName GetPswOneActivity
 * @Description 找回密码第一步：输入账户名/手机号
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @date 2014-7-9 下午3:50:27
 */
public class GetPswOneActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.getpsw_one;
	private String PAGE_TITLE = "输入手机号";
	private Context context;
	private Handler handler;
	private EditText tel;
	private TextView btn_next;
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initView();
		initClick();
		showKeyboard();
	}

	private void initView() {
		((TextView) findViewById(R.id.title)).setText(PAGE_TITLE);
		back = (ImageView) findViewById(R.id.back);
		tel = (EditText) findViewById(R.id.tel);
		btn_next = (TextView) findViewById(R.id.btn_next);
		btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
		btn_next.setClickable(false);
		tel.requestFocus();
	}

	private void initClick() {
		back.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		tel.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				if (getTextFromView(tel).trim().length() == 11) {
					if (APP.isPhoneNO(getTextFromView(tel).trim())) {
						btn_next.setClickable(true);
						btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
					} else
						Tip("请输入中国大陆手机号码");
				} else {
					btn_next.setClickable(false);
					btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			myfinish();
			break;
		case R.id.btn_next:
			// TODO 下一步
			String phone = tel.getText().toString().trim();
			if (APP.isPhoneNO(phone)) {
				myfinish();
				Intent intent = new Intent(context, GetPswTwoActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("tel", phone);
				intent.putExtras(bundle);
				startActivity(intent);
				animLeftToRight();
			} else
				Tip("请输入中国大陆手机号码");
			break;
		}
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}
}