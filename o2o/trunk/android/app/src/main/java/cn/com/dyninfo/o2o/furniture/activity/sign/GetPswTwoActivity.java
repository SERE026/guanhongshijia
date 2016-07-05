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

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @ClassName GetPswTwoActivity
 * @Description 找回密码第二步：输入验证码
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * @date 2014-7-10 19:20:11 完成逻辑
 */
public class GetPswTwoActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.getpsw_two;
	private String PAGE_TITLE = "账户校验";
	private String tag = "GetPswTwoActivity";
	private Context context;
	private Handler handler;
	private TextView btn_next, getcode;
	private ImageView back;
	private EditText code, psw, repsw;
	private String phoneNum = "";
	private Boolean retried = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initBundle();
		initView();
		initClick();
		showKeyboard();
		getCode();
	}

	private void getCode() {
		if (phoneNum != null && phoneNum != "") {
			String json = SyncApi.getSmsCode(phoneNum);
			JSONObject object = APP.checkReturnData(json, context);
			if (object != null) {
				if (object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							Tip("请注意查收验证短信");
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							if (retried == false) {
								getCode();
								retried = true;
							} else
								Tip("获取验证码失败，请稍后再试");
						}
					} catch (JSONException e) {
						Tip("获取验证码失败，请稍后再试");
						APP.exception(tag, e);
					}
				}
			} else {
				Tip("获取短信失败" + APPCode.WEB_NULL);
			}

			startTimer();
		} else {
			Tip("请重新输入手机号");
			myfinish();
		}
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		phoneNum = bundle.getString("tel");
	}

	private void initView() {
		((TextView) findViewById(R.id.title)).setText(PAGE_TITLE);
		back = (ImageView) findViewById(R.id.back);
		code = (EditText) findViewById(R.id.code);
		psw = (EditText) findViewById(R.id.psw);
		repsw = (EditText) findViewById(R.id.repsw);
		getcode = (TextView) findViewById(R.id.getcode);
		btn_next = (TextView) findViewById(R.id.btn_next);
		((TextView) findViewById(R.id.phone)).setText(phoneNum);
		btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
		btn_next.setClickable(false);
		code.requestFocus();
	}

	private void initClick() {
		back.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		getcode.setOnClickListener(this);

		code.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				if (getTextFromView(code).trim().length() == 0) {
					btn_next.setClickable(true);
					btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
					btn_next.setClickable(false);
					btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
				} else {
					btn_next.setClickable(true);
					btn_next.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
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

		case R.id.getcode:
			getCode();
			break;

		case R.id.btn_next:
			if (getTextFromView(psw).length() < 6) {
				Tip("密码应该是 6 - 12 位");
				return;
			}

			if (getTextFromView(psw).equals(getTextFromView(repsw))) {
				String json = SyncApi.resetPsw(phoneNum, code.getText().toString().trim(), getTextFromView(repsw));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								Tip("密码修改成功，请重新登录");
								myfinish();
								startActivity(new Intent(context, SigninActivity.class));
								animLeftToRight();
							} else if (object.getInt("status") == ErrorCode.ERROR)
								Tip("修改密码失败，请重试");
						} catch (JSONException e) {
							Tip("修改密码失败，请稍后再试");
							APP.exception(tag, e);
						}
					}
				} else {
					Tip("修改密码失败" + APPCode.WEB_NULL);
				}
			} else {
				Tip("再次输入的密码不一致");
				repsw.requestFocus();
			}

			break;
		}
	}

	private void startTimer() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				new MyTimer(90000, 1000).start();
			}
		});
	}

	class MyTimer extends CountDownTimer {

		public MyTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			getcode.setClickable(false);
			getcode.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
			getcode.setTextColor(getResources().getColor(R.color.black_transparent));
		}

		@Override
		public void onFinish() {
			getcode.setText("重新获取");
			getcode.setClickable(true);
			getcode.setTextColor(getResources().getColor(R.color.white));
			getcode.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			getcode.setText("重新获取(" + millisUntilFinished / 1000 + ")");
		}
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}
}