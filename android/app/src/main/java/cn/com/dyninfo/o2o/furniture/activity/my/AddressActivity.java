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

import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.AddressAdapter;
import cn.com.dyninfo.o2o.furniture.bean.AddressBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 收货地址管理
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-28 12:01:54
 * @update 2014-7-5 16:21:35 优化为支持从订单页面跳转过来选择收货地址
 */
public class AddressActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "地址管理";
	private int layoutID = R.layout.address;
	private Context context;
	private Handler handler;
	private View add_address;
	private ListView listview;
	private List<AddressBean> list;
	private AddressAdapter adapter;
	private int POINT;
	//
	private Boolean fromOrder = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		handler = new Handler();
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		initView();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				initBundle();
				getData();
				initBroadcast();
			}
		}, 100);

	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		if (bundle.getString("from").equals("order")) {
			fromOrder = true;
		}

	}

	protected void getData() {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getAddressList(BaseActivity.getLastLocalUserInfoInstance(context).uid);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							if (list == null)
								list = new ArrayList<AddressBean>();
							list.clear();

							JSONArray array = object.getJSONArray("data");
							for (int i = 0; i < array.length(); i++) {
								JSONObject item_object = array.getJSONObject(i);
								list.add(new AddressBean(item_object.getString("address_id"), item_object
										.getString("receiveName"), item_object.getString("receivePhone"), item_object
										.getString("address"), item_object.getString("province"), item_object
										.getString("city"), item_object.getString("county")));
							}
							initAdapter();
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							// Tip("没有收货地址");
						}
					} catch (Exception e) {
						APP.exception("解析收货地址", e);
					}
				} else {
					Tip("服务器返回数据异常");
				}
			}
		});
	}

	private void initAdapter() {
		if (adapter == null) {
			handler.post(new Runnable() {
				@Override
				public void run() {
					adapter = new AddressAdapter(context, list);
					listview.setAdapter(adapter);
				}
			});
		}
		notifyAdapter();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add_address:
			Intent intent_add = new Intent(this, EditAddressActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("do", "add");
			intent_add.putExtras(bundle);
			startActivityForResult(intent_add, APPCode.ADD_ADDRESS);
			animLeftToRight();
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			// // 新增地址
			// if (requestCode == APPCode.ADD_ADDRESS) {
			// if (data != null) {
			// list.add((AddressBean) data.getExtras().getSerializable("bean"));
			// }
			// }
			// // 更新地址
			// if (requestCode == APPCode.EDIT_ADDRESS) {
			// if (data != null) {
			// list.set(POINT, (AddressBean)
			// data.getExtras().getSerializable("bean"));
			// }
			// }
			//
			// notifyAdapter();

			// 地址新增、更新成功后，这个页面刷新一次
			getData();
		}
	}

	private void initView() {
		add_address = findViewById(R.id.add_address);
		add_address.setOnClickListener(this);
		listview = (ListView) findViewById(R.id.listview);
	}

	public void notifyAdapter() {
		Log_info("正在更新适配器");
		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
			}
		});
	}

	private BroadcastReceiver listClickBR = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			POINT = intent.getIntExtra("position", 0);
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.my.AddressActivity#click")) {
				if (fromOrder) {
					// 是从订单页来的，则把参数返回去，否则跳转到更新地址页面
					Intent intent_order = new Intent();
					Bundle bundle = new Bundle();
					bundle.putString("name", list.get(POINT).getName());
					bundle.putString("tel", list.get(POINT).getPhone());
					bundle.putString("addr", list.get(POINT).getAddr());
					bundle.putString("id", list.get(POINT).getId());
					intent_order.putExtras(bundle);
					((Activity) AddressActivity.this.context).setResult(RESULT_OK, intent_order);
					myfinish();
				} else {
					intent = new Intent(context, EditAddressActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("do", "edit");
					bundle.putSerializable("bean", list.get(POINT));
					intent.putExtras(bundle);
					startActivityForResult(intent, APPCode.EDIT_ADDRESS);
				}
			}
		}
	};

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.my.AddressActivity#click");
		registerReceiver(listClickBR, intentFilter);
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(listClickBR);
		super.onDestroy();
	}

}