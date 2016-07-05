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

package cn.com.dyninfo.o2o.furniture.activity.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.BeautyProclaimAdapter;
import cn.com.dyninfo.o2o.furniture.bean.BeautyProclaimBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.view.CustomerGridView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;

/**
 * @Description 美丽宣言
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-22 上午9:11:40
 * @update 2014-6-18 12:05:51
 */
public class BeautyProclaimActivity extends BaseActivity {

	private int layoutID = R.layout.beauty_proclaim;
	private String PAGE_TITLE = "美丽宣言";
	private Context context;
	private Handler handler;
	private int POINT; // 点中
	private int PAGE = 1; // 页码
	private PullToRefreshListView refreshListView;
	private CustomerGridView gridview;
	private List<BeautyProclaimBean> list;
	private BeautyProclaimAdapter adapter;
	private BeautyProclaimHandler beautyProclaimHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		APPManager.getInstance().add(this);
		context = this;
		handler = new Handler();
		loadingShow();
		initView();
		xListViewListener.onRefresh();
		initClick();
		initBroadcast();
	}

	public void decodeJson(JSONObject object) {
		loadingDismiss();
		try {
			if (object != null) {
				if (object.has("status"))
					if (object.getInt("status") == ErrorCode.ERROR) {
						if (PAGE == 1) {
							// Tip("获取美丽宣言信息失败");
						} else
							Tip("没有了");
					} else if (object.getInt("status") == ErrorCode.SUCCESS) {
						if (PAGE == 1) {
							list.clear();
							refreshListView.setTime();
						}
						JSONArray array = object.getJSONArray("data");
						for (int i = 0; i < array.length(); i++) {
							object = array.getJSONObject(i);
							list.add(new BeautyProclaimBean(Long.valueOf(object.getString("bbsid")), object
									.getString("imgUrl"), object.getString("goodsname"), object.getString("txImage"),
									object.getString("huiyuanname"), Long.valueOf(object.getString("bbsnum"))));
						}
					}
			}else {
				Tip("获取失败" + APPCode.WEB_NULL);
			}
		} catch (Exception e) {
			APP.exception("BeautyProclaimActivity JSON :", e);
			Tip("获取失败，下拉刷新试试");
		}
		Log_info("-------> 美丽宣言信息共 " + list.size() + " 条");
		// 加载到的数据不能被整除时，则代表没有更多数据了
		refreshListView.setPullLoadEnable(list.size() == 0 ? false : list.size() % 10 == 0 ? true : false);
		setAdapter();
	}

	private void setAdapter() {
		if (adapter == null) {
			adapter = new BeautyProclaimAdapter(context, list);
			gridview.setAdapter(adapter);
		}
		notifyAdapter();
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		pauseDisplay(refreshListView);
	}

	private void initView() {
		refreshListView = (PullToRefreshListView) findViewById(R.id.refreshListView);
		View v = LayoutInflater.from(context).inflate(R.layout.gridview_customer, null);
		refreshListView.addHeaderView(v);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(false);
		refreshListView.setAdapter(null);
		gridview = (CustomerGridView) findViewById(R.id.gridview);
		list = new ArrayList<BeautyProclaimBean>();
		beautyProclaimHandler = new BeautyProclaimHandler();

	}

	private IXListViewListener xListViewListener = new IXListViewListener() {
		@Override
		public void onRefresh() {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					PAGE = 1;
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("pageno", PAGE);
					beautyProclaimHandler.init(map).execute();
				}
			}, 1000);
		}

		@Override
		public void onLoadMore() {
			++PAGE;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageno", PAGE);
			beautyProclaimHandler.init(map).execute();
		}
	};

	class BeautyProclaimHandler extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			loadingDismiss();
			Tip("加载美丽宣言数据失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			decodeJson(json);
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			return SyncApi.getBeautyProclaim((Integer) parameters.get("pageno"));
		}
	}

	private void stopLoad() {
		refreshListView.stopRefresh();
		refreshListView.stopLoadMore();
	}

	private void notifyAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
			}
		});
	}

	private BroadcastReceiver toDetailsBroadcast = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			POINT = intent.getIntExtra("position", 0);
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.home.BeautyProclaim#click")) {
				Log_info("美丽宣言点击 id =" + list.get(POINT).getId() + "");
				intent = new Intent(context, BeautyProclaimDetailsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putLong("id", list.get(POINT).getId());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		}
	};

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.home.BeautyProclaim#click");
		registerReceiver(toDetailsBroadcast, intentFilter);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(toDetailsBroadcast);
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		bmpUtils_short_holder.stopTasks();
		myfinish();
	}
}