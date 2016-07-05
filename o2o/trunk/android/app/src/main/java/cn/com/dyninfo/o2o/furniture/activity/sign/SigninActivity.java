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
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.sign.tencent.qq.QQSignUtil;
import cn.com.dyninfo.o2o.furniture.sign.tencent.weixin.WeixinSignUtil;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.DESUtil;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.view.SwitchButton;

/**
 * @Description
 * @author ly
 * @editor <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-9-15 15:34:55 新增微信登录，优化放弃登录时返回首页时不再刷新
 *         <hr>
 *         2014-9-4 10:10:59 新增qq登陆后显示加载中提示框
 *         <hr>
 *         2014-8-7 16:27:01 取消登录成功后跳转到首页
 */
public class SigninActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "登录";
	private Handler handler;
	private Context context;
	private int layoutID = R.layout.signin;
	private TextView title;
	private Button top_btn_2;
	private SwitchButton keep_sign_switch;
	private EditText edit_uname, edit_pswd;
	private TextView signin_with_qq, signin_with_weixin, btn_signin;
	private LoadingDialog dialog;
	// 忘记密码
	private RelativeLayout forget_psw;
	// 一般社会化登录授权比较慢，这里让它显示加载框
	private Boolean clickedSocial = false;
	// 新注册
	private String signup_ac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		dialog = new LoadingDialog(context);
		initView();
		initValue();
		initClick();
		edit_uname.requestFocus();
	}

	private void initView() {

		top_btn_2 = (Button) findViewById(R.id.top_btn_2);

		top_btn_2.setBackgroundResource(R.drawable.corner_round_bg_normal_fenbai);
		// 页面标题
		title = (TextView) findViewById(R.id.title);
		// 记住状态
		keep_sign_switch = (SwitchButton) findViewById(R.id.keep_sign_switch);
		edit_uname = (EditText) findViewById(R.id.edit_uname);
		edit_pswd = (EditText) findViewById(R.id.edit_pswd);
		btn_signin = (TextView) findViewById(R.id.btn_signin);
		signin_with_qq = (TextView) findViewById(R.id.signin_with_qq);
		signin_with_weixin = (TextView) findViewById(R.id.signin_with_weixin);
		LayoutParams params = top_btn_2.getLayoutParams();
		params.width = LayoutParams.WRAP_CONTENT;
		params.height = LayoutParams.MATCH_PARENT;
		top_btn_2.setLayoutParams(params);
		top_btn_2.setOnClickListener(this);
		btn_signin.setOnClickListener(this);
		signin_with_qq.setOnClickListener(this);
		signin_with_weixin.setOnClickListener(this);

		forget_psw = (RelativeLayout) findViewById(R.id.forget_psw);
		forget_psw.setOnClickListener(this);
	}

	private void initValue() {
		top_btn_2.setVisibility(View.VISIBLE);
		top_btn_2.setText(R.string.reg);
		title.setText(PAGE_TITLE);
		keep_sign_switch.setChecked(true);

		// 本地账户判断
		LocalUser user = new LocalUser(context);
		user = user.getLastUser();
		Log_info("上次登录账户：" + user.toString());
		if (user.auto == 0 || user.auto == 2) {
			if (!user.acct.equals("") && !user.psw.equals("")) {
				edit_uname.setText(user.acct);
				edit_pswd.setText(DESUtil.decode(user.psw));
			}
		}
		checkInputValueState();
	}

	private void initClick() {
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				IndexActivity.nowPoint_temp = 1;
				myfinish();
			}
		});

		edit_uname.addTextChangedListener(new Watcher());
		edit_pswd.addTextChangedListener(new Watcher());
	}

	class Watcher implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			checkInputValueState();
		}

		@Override
		public void afterTextChanged(Editable s) {
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.top_btn_2:
			Intent signup = new Intent(context, SignupActivity.class);
			startActivityForResult(signup, APPCode.TO_SIGNUP);
			animLeftToRight();
			break;
		case R.id.btn_signin:
			final String acct = getTextFromView(edit_uname, true, false);
			final String psw = getTextFromView(edit_pswd);
			if (APP.empty(acct))
				Tip("请输入账号");
			else if (APP.empty(psw))
				Tip("请输入密码");
			else {
				loadingShow();
				cachedPool().execute(new Runnable() {
					@Override
					public void run() {
						String json = SyncApi.signin(acct, psw);
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null && object.has("status")) {
							try {
								if (object.getInt("status") == ErrorCode.SUCCESS) {
									if (acct.equals(signup_ac)) {
										// 新注册，并且登录通过的，通知 index
										// 邀请用户补全个人信息
										Intent broadcast = new Intent();
										broadcast
												.setAction("cn.com.dyninfo.o2o.furniture.activity.sign.SigninActivity#signup&signin");
										sendBroadcast(broadcast);
									}
									LocalUser user = getLocalUserInfoInstance(context);
									user.json2db(json, context);
									user.psw = DESUtil.encode(psw);
									user.auto = keep_sign_switch.isChecked() ? 0 : 1;
									user.updateLocalUser();
									myfinish();
								} else if (object.getInt("status") == ErrorCode.ERROR) {
									Tip("账号/密码错误");
								}
							} catch (JSONException e) {
								APP.exception("登录返回结果检验失败", e);
								Tip("登录失败，请重试");
							}
						} else {
							Tip("服务器临时维护，请稍后再试");
						}
						loadingDismiss();
					}
				});
			}
			break;

		case R.id.forget_psw:
			startActivity(new Intent(context, GetPswOneActivity.class));
			animLeftToRight();
			break;

		case R.id.signin_with_qq:
			clickedSocial = true;
			new QQSignUtil(context, SigninActivity.this, context.getSharedPreferences(APPCode.SIGN, MODE_APPEND))
					.startSign();
			break;

		case R.id.signin_with_weixin:
			clickedSocial = true;
			new WeixinSignUtil(context).signin();
			break;

		}
	}

	public void checkInputValueState() {
		if (!BaseActivity.getTextFromView(edit_uname).isEmpty() && !BaseActivity.getTextFromView(edit_pswd).isEmpty()) {
			resetBtnStyle(true);
		} else {
			resetBtnStyle(false);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			if (requestCode == APPCode.TO_SIGNUP) {
				// 注册成功
				signup_ac = data.getStringExtra("ac");
				edit_uname.setText(signup_ac);
				edit_pswd.setText("");
				edit_pswd.requestFocus();
			}
		}
	}

	@Override
	protected void onResume() {
		if (clickedSocial) {
			loadingShow();
			clickedSocial = false;
			handler.postDelayed(new Runnable() {

				@Override
				public void run() {
					loadingDismiss();
				}
			}, 3000);
		}
		super.onResume();
	}

	@Override
	public void onBackPressed() {
		IndexActivity.nowPoint_temp = 1;
		myfinish();
	}

	/**
	 * @Description 设置登录按钮是否可用
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-18 下午3:03:52
	 */
	void resetBtnStyle(Boolean b) {
		if (b) {
			btn_signin.setClickable(true);
			btn_signin.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
		} else {
			btn_signin.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
			btn_signin.setClickable(false);
		}
	}

}