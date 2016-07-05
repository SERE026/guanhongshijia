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
import cn.com.dyninfo.o2o.furniture.adapter.GoodsListItemAdapter;
import cn.com.dyninfo.o2o.furniture.bean.HotMarketBean;
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
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-7-9 11:55:28 更新点击事件
 * @Tip 2014-8-6 13:38:24 服务器那边根本就没有分页!!!
 */
public class GoodsListActivity extends BaseActivity {

	private int layoutID = R.layout.refresh_with;
	private String PAGE_TITLE = "商品列表";
	private Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private GoodsListItemAdapter adapter;
	private List<HotMarketBean> list;
	private int PAGE = 1;
	private ThisHandler beautyProclaimHandler;

	private int id;
	private int actid = 0;
	private String img;
	private String name;
	private double oldPrice;
	private double nowPrice;

	// 根据来源处理数据
	private int FROM;
	private String ADV_ID;
	private String STORE_ID;

	private String SHOPID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		APPManager.getInstance().add(this);

		context = this;
		handler = new Handler();
		list = new ArrayList<HotMarketBean>();
		initBundle();
		loadingShow();
		initView();
		xListViewListener.onRefresh();
		initClick();
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		PAGE_TITLE = bundle.getString("page_title");
		FROM = bundle.getInt("from");
		if (FROM == APPCode.ADV_LIST) {
			ADV_ID = bundle.getString("adv_id");
		} else if (FROM == APPCode.WOMEN_STREEET_LIST) {
			STORE_ID = bundle.getString("store_id");
		} else if (FROM == APPCode.SHOP_GOODS_LIST) {
			SHOPID = bundle.getString("id");
		}
	}

	private void initValue(JSONObject object) {
		loadingDismiss();
		try {
			if (object != null) {
				if (object.has("status"))
					if (object.getInt("status") == ErrorCode.ERROR) {
						if (PAGE == 1) {
							// Tip("获取商品信息失败");
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

							id = object.getInt("goodId");
							img = object.getString("image");
							name = object.getString("goodName");
							nowPrice = object.getDouble("salesMoney");
							oldPrice = object.getDouble("bazaarMoney");
							double discount = object.getDouble("discount");

							list.add(new HotMarketBean(id, img, name, Utils.decimal(nowPrice, 2), Utils.decimal(
									oldPrice, 2), Utils.decimal(discount, 2)));
						}
					}
			}else {
				Tip("获取失败" + APPCode.WEB_NULL);
			}
		} catch (Exception e) {
			APP.exception("PlayingGoods JSON :", e);
		}
		Log_info("-------> 商品共 " + list.size() + " 条");
		// 加载到的数据不能被整除时，则代表没有更多数据了
		refreshListView.setPullLoadEnable(list.size() == 0 ? false : list.size() % 10 == 0 ? true : false);
		setAdapter();
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		pauseDisplay(refreshListView);
	}

	private void initView() {
		refreshListView = (PullToRefreshListView) findViewById(R.id.content);
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.woman_street_content, null);
		refreshListView.addHeaderView(v);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(true);// 加载更多
		refreshListView.setDivider(null);

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

	private void setAdapter() {
		if (adapter == null) {
			adapter = new GoodsListItemAdapter(context, list);
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

	class ThisHandler extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			loadingDismiss();
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			initValue(json);
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			String json = "";
			if (FROM == APPCode.VIP_ZONE) {
				// 会员专区
				json = SyncApi.getHotData(context, (Integer) parameters.get("pageno"));
			} else if (FROM == APPCode.ADV_LIST) {
				// 广告商品列表
				json = SyncApi.getAdvGoodsList(context, ADV_ID, (Integer) parameters.get("pageno"));
			} else if (FROM == APPCode.WOMEN_STREEET_LIST) {
				// 女人街店家商品列表
				json = SyncApi.getStoreGoodsList(STORE_ID, (Integer) parameters.get("pageno"));
			} else if (FROM == APPCode.SHOP_GOODS_LIST) {
				// 店家商品列表
				json = SyncApi.getStoreGoodsList(SHOPID, (Integer) parameters.get("pageno"));
			}

			return json;
		}
	}
}