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
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.BeautyProjectAdapter;
import cn.com.dyninfo.o2o.furniture.bean.BeautyProjectBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;

/**
 * @author ly
 * @editor <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-8-25 11:32:29 修改为显示当前城市的数据（之前是身边）
 */
public class BeautyProjectActivity extends BaseActivity {

	private int layoutID = R.layout.refresh_with;
	private String PAGE_TITLE = "美容项目";
	private Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private List<BeautyProjectBean> list;
	private BeautyProjectAdapter adapter;
	private int PAGE = 1;
	private BeautyProjectHandle beautyProjectHandle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		APPManager.getInstance().add(this);
		context = this;
		list = new ArrayList<BeautyProjectBean>();
		beautyProjectHandle = new BeautyProjectHandle();
		handler = new Handler();
		loadingShow();
		initView();
		xListViewListener.onRefresh();
		initClick();
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		pauseDisplay(refreshListView);
	}

	private int id;
	private String img;
	private String name;
	private double oldPrice;
	private double nowPrice;

	private void initValue(JSONObject object) {
		loadingDismiss();
		try {
			if (object != null) {
				if (object.has("status"))
					if (object.getInt("status") == ErrorCode.ERROR) {
						if (PAGE == 1) {
							// Tip("获取美容项目信息失败");
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

							img = object.getString("defaultImage");
							name = object.getString("goodsname");
							nowPrice = object.getDouble("salesMoney");
							oldPrice = object.getDouble("bazaarMoney");
							double discount = object.getDouble("discount");
							String address = object.getString("shopname");
							id = object.getInt("goods_id");

							list.add(new BeautyProjectBean(img, name, address, Utils.decimal(nowPrice, 2), Utils
									.decimal(oldPrice, 2), Utils.decimal(discount, 2), id));
						}
					}
			}else {
				Tip("获取失败" + APPCode.WEB_NULL);
			}
		} catch (Exception e) {
			APP.exception("PlayingGoods JSON :", e);
			Tip("获取失败，下拉刷新试试");
		}
		Log_info("-------> 美容项目信息共 " + list.size() + " 条");
		// 加载到的数据不能被整除时，则代表没有更多数据了
		refreshListView.setPullLoadEnable(list.size() == 0 ? false : list.size() % 10 == 0 ? true : false);
		setAdapter();
	}

	private void initView() {
		refreshListView = (PullToRefreshListView) findViewById(R.id.content);
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.woman_street_content, null);
		refreshListView.addHeaderView(v);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(true);

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
					beautyProjectHandle.init(map).execute();
				}
			}, 1000);
		}

		@Override
		public void onLoadMore() {
			++PAGE;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageno", PAGE);
			beautyProjectHandle.init(map).execute();
		}
	};

	private void setAdapter() {
		if (adapter == null) {
			adapter = new BeautyProjectAdapter(context, list);
			refreshListView.setAdapter(adapter);
		}
		notifyAdapter();
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

	class BeautyProjectHandle extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			loadingDismiss();
			Tip("加载数据失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			initValue(json);
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {

			return SyncApi.getBeautifulProjectData(context, (Integer) parameters.get("pageno"));
		}
	}
}