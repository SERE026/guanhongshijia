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
import cn.com.dyninfo.o2o.furniture.bean.AddressBean;
import cn.com.dyninfo.o2o.furniture.dialog.ProvincesDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ProvincesDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 新增收货地址
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-28 10:15:32
 * @update 2014-6-21 16:16:12
 */
public class EditAddressActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "新增地址";
	private String tag = " AddAddressActivity ";
	private int layoutID = R.layout.address_edit;
	private Context context;
	private Handler handler;
	private AddressBean bean;
	private ProvincesDialog dialog;
	/** 省市区 布局 */
	private View province_layout, city_layout, area_layout;
	/** 省市区 文本 */
	private TextView province_input, city_input, area_input;
	/** 姓名、街道、电话 */
	private EditText name_input, street_input, phone_input;
	/** 添加按钮 */
	private TextView btn_add;
	private Boolean isUpdate = false; // 是更新还是新增
	private String addressID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initView();
		initBundle();
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		showKeyboard();
		initClick();
	}

	/**
	 * @Description 解析是新增地址，还是维护地址
	 */
	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		if (bundle.getString("do").equals("add")) {

		} else if (bundle.getString("do").equals("edit")) {
			isUpdate = true;
			PAGE_TITLE = "修改地址";
			bean = (AddressBean) bundle.getSerializable("bean");
			province_input.setText(bean.getProvince());
			city_input.setText(bean.getCity());
			area_input.setText(bean.getArea());
			//
			name_input.setText(bean.getName());
			street_input.setText(bean.getStreet());
			phone_input.setText(bean.getPhone());

			addressID = bean.getId();
			street_input.requestFocus();
		}

	}

	private void initView() {
		// 省市布局
		province_layout = findViewById(R.id.province_layout);
		city_layout = findViewById(R.id.city_layout);
		area_layout = findViewById(R.id.area_layout);
		// 省市文本
		province_input = (TextView) findViewById(R.id.province_input);
		city_input = (TextView) findViewById(R.id.city_input);
		area_input = (TextView) findViewById(R.id.area_input);
		// 姓名街道电话
		name_input = (EditText) findViewById(R.id.name_input);
		street_input = (EditText) findViewById(R.id.street_input);
		phone_input = (EditText) findViewById(R.id.phone_input);
		//
		btn_add = (TextView) findViewById(R.id.btn_add);
	}

	private void initClick() {
		province_layout.setOnClickListener(this);
		city_layout.setOnClickListener(this);
		area_layout.setOnClickListener(this);
		btn_add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 省
		case R.id.province_layout:
			showProvincesWheel();
			break;
		// 市
		case R.id.city_layout:
			showProvincesWheel();
			break;
		// 区
		case R.id.area_layout:
			showProvincesWheel();
			break;

		// 添加按钮
		case R.id.btn_add:
			bean = new AddressBean(getTextFromView(name_input), getTextFromView(phone_input),
					getTextFromView(street_input), getTextFromView(province_input), getTextFromView(city_input),
					getTextFromView(area_input));
			if (bean.getName().replace(" ", "").equals("")) {
				tip("请完善收货人名称");
				name_input.requestFocus();
				return;
			} else if (bean.getProvince().equals("")) {
				tip("请完善所在地区");
				showProvincesWheel();
				return;
			} else if (bean.getStreet().replace(" ", "").length() < 3) {
				tip("请完善详细街道地址");
				street_input.requestFocus();
				return;
			} else if (bean.getPhone().length() < 4) {
				tip("请输入真实联系电话");
				phone_input.requestFocus();
				return;
			}

			new Thread() {
				public void run() {
					Looper.prepare();
					if (isUpdate) {
						String json = SyncApi.updateAddress(BaseActivity.getLastLocalUserInfoInstance(context).uid,
								addressID, bean.getProvince(), bean.getCity(), bean.getArea(), bean.getStreet(),
								bean.getName(), bean.getPhone());
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null && object.has("status")) {
							try {
								if (object.getInt("status") == ErrorCode.ERROR) {
									tip("修改失败，请重试");
								} else if (object.getInt("status") == ErrorCode.SUCCESS) {
									tip("修改成功");
									goBack();
								}
							} catch (Exception e) {
								APP.exception(tag, e);
							}
						}
					} else {
						String json = SyncApi.addAddress(BaseActivity.getLastLocalUserInfoInstance(context).uid,
								bean.getProvince(), bean.getCity(), bean.getArea(), bean.getStreet(), bean.getName(),
								bean.getPhone());
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null && object.has("status")) {
							try {
								if (object.getInt("status") == ErrorCode.ERROR) {
									tip("添加失败，请重试");
								} else if (object.getInt("status") == ErrorCode.SUCCESS) {
									tip("添加成功");
									goBack();
								}
							} catch (Exception e) {
								APP.exception(tag, e);
							}
						}
					}
				};
			}.start();

			break;
		default:
			break;
		}
	}

	protected void goBack() {
		setResult(RESULT_OK);
		myfinish();
	}

	/**
	 * @Description 【省市区】选择器
	 */
	private void showProvincesWheel() {
		if (dialog == null) {
			dialog = new ProvincesDialog(this);
		}
		dialog.show();
		dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void OnChoiced(String province, String city, String area) {
				province_input.setText(province);
				city_input.setText(city);
				area_input.setText(area);
			}
		});
	}

	private void tip(final String msg) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Tip(msg);
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}
}