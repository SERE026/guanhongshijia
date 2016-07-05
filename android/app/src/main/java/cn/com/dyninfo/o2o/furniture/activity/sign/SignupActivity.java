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
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

/**
 * 
 * @Description 注册
 * @author ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-9-18 13:08:52 新增短信验证机制
 *       <hr>
 *       2014-9-11 11:17:45 删除原来的烂方法，优化其他
 *       <hr>
 *       2014-7-5 10:27:47 修改顶部按钮和返回事件
 */
public class SignupActivity extends BaseActivity implements OnClickListener {

	private Handler handler;
	private int layoutID = R.layout.signup;
	private String PAGE_TITLE = "注册";
	private TextView title;
	private Button top_btn_2;
	/** 户名、密码、重复密码、邀请码、手机号、验证码 */
	private EditText uname, pswd, pswd_re, invitedCode, tel_num, check;
	private TextView btn_reg;
	private TextView getcode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		handler = new Handler();
		initView();
		initValue();
		checkInputValueState();
	}

	private void initView() {

		top_btn_2 = (Button) findViewById(R.id.top_btn_2);
		top_btn_2.setBackgroundResource(R.drawable.corner_round_bg_normal_fenbai);
		// 页面标题
		title = (TextView) findViewById(R.id.title);

		uname = (EditText) findViewById(R.id.uname);
		pswd = (EditText) findViewById(R.id.pswd);
		pswd_re = (EditText) findViewById(R.id.pswd_re);
		invitedCode = (EditText) findViewById(R.id.invitedCode);
		tel_num = (EditText) findViewById(R.id.tel_num);
		check = (EditText) findViewById(R.id.check);
		getcode = (TextView) findViewById(R.id.getcode);
		getcode.setText("获取验证码");

		btn_reg = (TextView) findViewById(R.id.btn_reg);

		LayoutParams params = top_btn_2.getLayoutParams();
		params.width = LayoutParams.WRAP_CONTENT;
		params.height = LayoutParams.MATCH_PARENT;
		top_btn_2.setLayoutParams(params);

		initClick();
	}

	private void initValue() {
		top_btn_2.setVisibility(View.VISIBLE);
		top_btn_2.setText(R.string.log);
		title.setText(PAGE_TITLE);
	}

	private void initClick() {
		// 顶部返回按钮
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myfinish();
			}
		});

		getcode.setOnClickListener(this);
		getcode.setClickable(false);

		check.setOnClickListener(this);
		top_btn_2.setOnClickListener(this);
		btn_reg.setOnClickListener(this);
		// 手机号正确才显示获取短信按钮
		tel_num.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				checkInputValueState();
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (APP.isPhoneNO(s.toString())) {
					resetGetCodeStyle(true);
				} else {
					resetGetCodeStyle(false);
				}
			}
		});

		uname.addTextChangedListener(new Watcher());
		pswd.addTextChangedListener(new Watcher());
		pswd_re.addTextChangedListener(new Watcher());
		check.addTextChangedListener(new Watcher());
		invitedCode.addTextChangedListener(new Watcher());
	}

	private String acct, psw, regUserTwoPwd, tel, checkCode, inviCode;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.getcode:
			getSMSCode();
			break;

		case R.id.top_btn_2:
			startActivity(new Intent(SignupActivity.this, SigninActivity.class));
			myfinish();
			break;
		case R.id.btn_reg:
			acct = BaseActivity.getTextFromView(uname, true, false);
			psw = BaseActivity.getTextFromView(pswd, false, false);
			regUserTwoPwd = BaseActivity.getTextFromView(pswd_re, false, false);
			tel = BaseActivity.getTextFromView(tel_num);
			checkCode = BaseActivity.getTextFromView(check);
			inviCode = BaseActivity.getTextFromView(invitedCode);

			if (acct.isEmpty()) {
				Tip("请输入账户名");
				uname.requestFocus();
				showKeyboard();
				return;
			}
			if (acct.length() < 4) {
				Tip("账户名请大于4位");
				uname.requestFocus();
				showKeyboard();
				return;
			}
			if (psw.isEmpty()) {
				Tip("请输入登录密码");
				pswd.requestFocus();
				showKeyboard();
				return;
			}
			if (psw.length() < 6) {
				Tip("密码太短，请大于6位");
				pswd.requestFocus();
				showKeyboard();
				return;
			}
			if (psw.length() > 16) {
				Tip("密码太长了，不用这么麻烦的");
				pswd.requestFocus();
				showKeyboard();
				return;
			}

			if (!psw.equals(regUserTwoPwd)) {
				Tip("两次输入密码不一致");
				pswd_re.requestFocus();
				showKeyboard();
				return;
			}
			if (!APP.isPhoneNO(tel)) {
				Tip("请输入正确的大陆手机号");
				tel_num.requestFocus();
				showKeyboard();
				return;
			}
			if (checkCode.isEmpty()) {
				Tip("请输入短信验证码");
				check.requestFocus();
				showKeyboard();
				return;
			}

			loadingShow();
			cachedPool().execute(new Runnable() {

				@Override
				public void run() {
					handler.post(new Runnable() {

						@Override
						public void run() {
							String json = SyncApi.signup(acct, psw, tel, checkCode, inviCode);
							JSONObject object = APP.checkReturnData(json, context);
							// {status:0}注册成功，{status:1}手机号已被注册，
							// {status:2}帐户名已存在，{status:3}短信验证码错误，
							// {status:-1}通讯故障（服务器端exception）
							if (object != null) {
								try {
									switch (object.getInt("status")) {
									case -1:
										Tip("注册失败，请重试");
										break;
									case 0:
										Tip("注册成功，请登录");
										// TODO 带账户返回登录页
										Intent back = new Intent();
										back.putExtra("ac", acct);
										setResult(RESULT_OK, back);
										myfinish();
										break;
									case 1:
										Tip("该手机号已被注册，请更换或登录");
										tel_num.requestFocus();
										showKeyboard();
										break;
									case 2:
										Tip("该账户名已被注册，请更换或登录");
										uname.requestFocus();
										showKeyboard();
										break;
									case 3:
										Tip("短信验证码错误，请重新获取");
										check.requestFocus();
										showKeyboard();
										break;
									}
								} catch (Exception e) {
									APP.exception("signup", e);
								}
							} else {
								Tip("注册失败" + APPCode.WEB_NULL);
							}
							loadingDismiss();
						}
					});
				}
			});
			break;
		}
	}

	/**
	 * @Description 获取短信验证码，因为号码正常才能获取，所以这里不用验证
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-18 上午11:44:39
	 */
	private void getSMSCode() {

		cachedPool().execute(new Runnable() {
			@Override
			public void run() {
				String json = SyncApi.getSMSCode(BaseActivity.getTextFromView(tel_num));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							// {status:0}发送成功，{status:1}手机号已被注册，{status:-1}通讯故障（服务器端exception）
							switch (object.getInt("status")) {
							case 0:
								Tip("短信发送成功，请注册查收");
								startTimer();
								break;

							case 1:
								Tip("该手机号已注册，请更换或直接登录");
								break;

							case -1:
								Tip("短信网关繁忙，请稍后再试");
								break;
							}
						} catch (Exception e) {
							Tip("获取短信失败，请稍后再试");
							APP.exception("注册获取短信验证码", e);
						}

					}
				} else {
					Tip("获取短信失败" + APPCode.WEB_NULL);
				}

			}
		});
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
			resetGetCodeStyle(false);
		}

		@Override
		public void onFinish() {
			getcode.setText("重新获取");
			resetGetCodeStyle(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			getcode.setText("重新获取(" + millisUntilFinished / 1000 + ")");
		}
	}

	public void resetGetCodeStyle(boolean b) {
		if (b) {
			getcode.setClickable(true);
			getcode.setTextColor(getResources().getColor(R.color.white));
			getcode.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
		} else {
			getcode.setClickable(false);
			getcode.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
			getcode.setTextColor(getResources().getColor(R.color.black_transparent));
		}

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

	/**
	 * @Description 检查各文本的值
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-18 下午4:48:04
	 */
	public void checkInputValueState() {
		if (BaseActivity.getTextFromView(uname).isEmpty() || BaseActivity.getTextFromView(pswd).isEmpty()
				|| BaseActivity.getTextFromView(pswd_re).isEmpty() || BaseActivity.getTextFromView(tel_num).isEmpty()
				|| BaseActivity.getTextFromView(check).isEmpty()) {
			resetBtnStyle(false);
		} else {
			resetBtnStyle(true);
		}
	}

	/**
	 * @Description 设置注册按钮是否可用
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-18 下午3:03:52
	 */
	void resetBtnStyle(Boolean b) {
		if (b) {
			btn_reg.setClickable(true);
			btn_reg.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_fill_pink_light);
		} else {
			btn_reg.setBackgroundResource(R.drawable.corner_round_bg_fill_pink_light);
			btn_reg.setClickable(false);
		}
	}

	@Override
	public void onBackPressed() {
		ConfirmDialog dialog = new ConfirmDialog(context, "提示", "确定要放弃注册吗？", "放弃");
		dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void OnConfirmed(Boolean confirmed) {
				if (confirmed) {
					myfinish();
				}
			}
		});
		dialog.show();
	}
}