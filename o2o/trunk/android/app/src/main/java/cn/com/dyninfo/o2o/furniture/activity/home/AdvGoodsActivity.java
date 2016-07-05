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
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.WomenStreetAdapter;
import cn.com.dyninfo.o2o.furniture.bean.WomenStreetBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;
import android.os.Bundle;
import android.os.Handler;
import android.content.Context;

/**
 * @Description 广告商品列表
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-6-28 15:06:38
 */
public class AdvGoodsActivity extends BaseActivity {

	private int layoutID = R.layout.refresh_with;
	private String PAGE_TITLE;
	private Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private WomenStreetAdapter adapter;
	private List<WomenStreetBean> list;
	private int PAGE = 1;
	private AdvHandler advHandler;
	private String adv_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initBundle();
		initView();
		xListViewListener.onRefresh();// 进来后启用刷新来获取数据
		initClick();
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		PAGE_TITLE = bundle.getString("page_title");
		adv_id = bundle.getString("adv_id");
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		pauseDisplay(refreshListView);
	}

	private void decodeJson(JSONObject object) {
		try {
			if (object != null) {
				if (object.has("status"))
					if (object.getInt("status") == ErrorCode.ERROR) {
						if (PAGE == 1) {
							// Tip("获取失败");
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
							list.add(new WomenStreetBean(object.getString("s_id"), object.getString("s_name"), (object
									.getString("nrjImage").split(","))[0]));
						}
					}
			} else {
				Tip("获取失败" + APPCode.WEB_NULL);
			}
		} catch (Exception e) {
			APP.exception("WomenStreetActivity JSON :", e);
			Tip("获取失败，下拉刷新试试");
		}
		Log_info("-------> 女人街信息共 " + list.size() + " 条");
		// 加载到的数据不能被整除时，则代表没有更多数据了
		refreshListView.setPullLoadEnable(list.size() == 0 ? false : list.size() % 10 == 0 ? true : false);
		setAdapter();
	}

	private void setAdapter() {
		if (adapter == null) {
			adapter = new WomenStreetAdapter(context, bmpUtils, list);
			refreshListView.setAdapter(adapter);
		}
		notifyAdapter();
	}

	private void initView() {
		refreshListView = (PullToRefreshListView) findViewById(R.id.content);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(false);
		list = new ArrayList<WomenStreetBean>();
		advHandler = new AdvHandler();
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
					map.put("id", adv_id);
					advHandler.init(map).execute();
				}
			}, 1000);
		}

		@Override
		public void onLoadMore() {
			++PAGE;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageno", PAGE);
			map.put("id", adv_id);
			advHandler.init(map).execute();
		}
	};

	class AdvHandler extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			Tip("加载失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			decodeJson(json);
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			return SyncApi.getAdvGoodsList(context, (String) parameters.get("id"), (Integer) parameters.get("pageno"));
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

	@Override
	public void onBackPressed() {
		myfinish();
	}
}