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
import java.util.Timer;
import java.util.TimerTask;

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
import cn.com.dyninfo.o2o.furniture.adapter.PromotionSalesAdapter;
import cn.com.dyninfo.o2o.furniture.bean.PlayingGoodsBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;

/**
 * 活动商品
 * 
 * @author ly
 * @editor <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-9-13 11:13:15 修复无法加载更多的问题
 *         <hr>
 *         2014-7-9 11:51:01 更新点击事件
 */
public class PromotionSalesActivity extends BaseActivity {

	private int layoutID = R.layout.refresh_with;
	private String PAGE_TITLE = "活动商品";
	private Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private PromotionSalesAdapter adapter;
	private List<PlayingGoodsBean> list, tempList;
	private int PAGE = 1;
	private ThisHandler beautyProclaimHandler;
	private Timer timer;
	private TimerTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		loadingShow();
		initView();
		xListViewListener.onRefresh();
		initClick();

	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
	}

	private void initValue(JSONObject object) {
		loadingDismiss();
		try {
			if (object != null) {
				if (object.has("status")) {
					if (object.getInt("status") == ErrorCode.ERROR) {
						if (PAGE == 1) {
							// Tip("获取活动商品信息失败");
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

							int goods_id = object.getInt("goodId");
							int act_id = object.getInt("actId");
							String img = object.getString("image");
							String name = object.getString("goodName");
							double old = object.getDouble("xmoney");
							double now = object.getDouble("money");
							double discount = object.getDouble("discount");

							list.add(new PlayingGoodsBean(img, name, goods_id, Utils.decimal(now, 2), Utils.decimal(
									old, 2), Utils.decimal(discount, 2), act_id, object.getLong("etimel")));
						}
					}
				}
			}else {
				Tip("获取失败" + APPCode.WEB_NULL);
			}
		} catch (Exception e) {
			APP.exception("PlayingGoods JSON :", e);
			Tip("获取失败，下拉刷新试试");
		}
		Log_info("-------> 活动商品信息共 " + list.size() + " 条");
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
		refreshListView.setPullLoadEnable(true);// 加载更多
		refreshListView.setDivider(null);

		list = new ArrayList<PlayingGoodsBean>();
		tempList = new ArrayList<PlayingGoodsBean>();
		beautyProclaimHandler = new ThisHandler();
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
			}, 500);
		}

		@Override
		public void onLoadMore() {
			++PAGE;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageno", PAGE);
			beautyProclaimHandler.init(map).execute();
		}
	};

	private void setAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (adapter == null) {
					adapter = new PromotionSalesAdapter(context, list);
					refreshListView.setAdapter(adapter);
				}
			}
		});

		notifyAdapter();

		if (task == null) {
			task = new TimerTask() {
				@Override
				public void run() {
					while (true) {
						sleep(1000);
						setAdapter();
					}
				}
			};
		}
		if (timer == null) {
			timer = new Timer();
			timer.schedule(task, 1000);
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
//				Log_info("活动商品，正在更新适配器");
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}


	class ThisHandler extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			loadingDismiss();
			--PAGE;
			Tip("加载数据失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			initValue(json);
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			return SyncApi.getPromotionSales(context, (Integer) parameters.get("pageno"));
		}
	}
}