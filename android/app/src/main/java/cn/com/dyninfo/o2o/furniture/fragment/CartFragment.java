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

package cn.com.dyninfo.o2o.furniture.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.cart.CartActivity;
import cn.com.dyninfo.o2o.furniture.activity.details.GoodsDetailsActivity;
import cn.com.dyninfo.o2o.furniture.adapter.CartAdapter;
import cn.com.dyninfo.o2o.furniture.bean.BuyCarBean;
import cn.com.dyninfo.o2o.furniture.bean.CheckstandBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.NumArithmetic;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;

/**
 * @Description 购物车
 * @date 2014-4
 * @editor ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-8-7 10:45:41 修复支付订单时放弃付款，回来后FC： <i>The content of the adapter
 *         has changed but ListView did not receive a notification. Make sure
 *         the content of your adapter is not modified from a background thread,
 *         but only from the UI thread。</i>
 *         <hr>
 *         2014-8-6 16:39:39 更新某些情况下 金额会出现很长很长 以及报错的问题
 */
public class CartFragment extends BaseFragment implements OnClickListener {

	public String PAGE_TITLE = "购物车";
	public static Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private CartAdapter adapter;
	private TextView check;
	private TextView buy_car_count;
	public static volatile List<BuyCarBean> list = new ArrayList<BuyCarBean>();
	private int actid = 0;
	private double old = 0;
	public static TextView baycar_result;
	public static double money;
	private int num;
	public static double result;
	private RelativeLayout cartHolder;
	// 复选
	private List<Boolean> checkList;
	private CheckBox checkall;
	private String[] goodsInfo;
	private NumArithmetic bArithmetic;
	// 单线程
	private ExecutorService singleService = Executors.newSingleThreadExecutor();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		handler = new Handler();
		bArithmetic = new NumArithmetic();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cart, container, false);
		initView(view);
		initClick();
		initBroadcast();
		return view;
	}

	private void initValue() {
		singleService.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String json = SyncApi.getCartList(BaseActivity.getLastLocalUserInfoInstance(context).uid);
					JSONObject object = APP.checkReturnData(json, getActivity());
					if (object != null) {
						if (object.has("status")) {
							if (object.getInt("status") == ErrorCode.SUCCESS) {

								JSONArray jsonArray = object.getJSONArray("data");
								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonObject = jsonArray.getJSONObject(i);

									String name = jsonObject.getString("goodsname");
									String carsBoxId = jsonObject.getString("cars_box_id");
									String img = jsonObject.getString("image");
									money = jsonObject.getDouble("money");
									num = jsonObject.getInt("num");
									int goods_id = jsonObject.getInt("good_id");
									String specVal = jsonObject.getString("specVal");
									String type = jsonObject.getString("type");
									String actInfo = jsonObject.getString("actInfo");
									int shopid = Integer.valueOf(jsonObject.getString("shopid"));

									list.add(new BuyCarBean(img, name, Utils.decimal(money, 2), num, carsBoxId,
											goods_id, shopid, specVal, actInfo, type));
								}

							} else if (object.getInt("status") == ErrorCode.ERROR) {
								// Tip("服务器异常,请重试");
							}
						}
					} else {
						Tip("获取购物车信息失败" + APPCode.WEB_NULL);
					}
				} catch (Exception e) {
					APP.exception("服务器异常", e);
					Tip("网络连接错误，请重试");
				}

				handler.post(new Runnable() {

					@Override
					public void run() {
						notifyCart(true);
						stopLoad();
					}
				});

			}
		});
	}

	private void initView(View view) {
		refreshListView = (PullToRefreshListView) view.findViewById(R.id.buycar_frame_pull_layout);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(false);// 加载更不可用
		refreshListView.setAdapter(null);

		cartHolder = (RelativeLayout) view.findViewById(R.id.buy_car_relat);
		check = (TextView) view.findViewById(R.id.check);
		buy_car_count = (TextView) view.findViewById(R.id.buy_car_count);
		baycar_result = (TextView) view.findViewById(R.id.baycar_result);

		checkall = (CheckBox) view.findViewById(R.id.checkall);
	}

	BroadcastReceiver refreshListBR = new BroadcastReceiver() {
		public void onReceive(Context arg0, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.fragment.CartFragment#update")) {
				xListViewListener.onRefresh();
			} else if ((intent.getAction().equals("cn.com.dyninfo.o2o.furniture.fragment.CartFragment#details"))) {
				Intent intent_details = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();
				BuyCarBean bean = list.get(intent.getIntExtra("pos", 0));
				bundle.putInt("id", bean.getGood_id());
				bundle.putString("name", bean.getBuyCarName());
				bundle.putString("img", bean.getBuyCarImg());
				bundle.putInt("actid", actid);
				bundle.putDouble("now", bean.getItem_line_money());
				bundle.putDouble("old", old);
				intent_details.putExtras(bundle);
				startActivity(intent_details);
			}
		};
	};

	public void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.fragment.CartFragment#update");
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.fragment.CartFragment#details");
		context.registerReceiver(refreshListBR, intentFilter);
	}

	private void initClick() {
		check.setOnClickListener(this);
		checkall.setOnClickListener(this);
		BaseActivity.pauseDisplay(refreshListView);
	}

	private IXListViewListener xListViewListener = new IXListViewListener() {
		@Override
		public void onRefresh() {
			// 开始拉取
			result = 0;
			list.clear();
			notifyCart(true);
			initValue();
		}

		@Override
		public void onLoadMore() {
			// 加载更多
			// 不需要写
		}
	};

	void stopLoad() {
		refreshListView.stopRefresh();
		refreshListView.stopLoadMore();
		refreshListView.setTime();
	}

	private double result() {
		double oneItem = 0;
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			oneItem = (Double) adapter.getItem(i);
			result += oneItem;
		}
		return result;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 结算
		case R.id.check:
			if (list.size() == 0) {
				Tip("购物车里还没有商品");
				return;
			}
			String chekedPostion = "";
			int checkCount = 0;
			checkList = adapter.getCheckList();
			for (int i = 0; i < checkList.size(); i++)
				if (checkList.get(i)) {
					chekedPostion += i + "-";
					++checkCount;
				}

			if (checkCount == 0) {
				Tip("请勾选要购买的商品");
				return;
			}
			// 购买的商品
			double mon = 0.0;
			List<CheckstandBean> goodsList = new ArrayList<CheckstandBean>();
			goodsInfo = new String[checkCount];
			String[] pos = chekedPostion.split("-");
			for (int i = 0; i < checkCount; i++) {
				BuyCarBean bean = list.get(Integer.valueOf(pos[i]));
				// 收银台 ListView 展示的商品
				goodsList.add(new CheckstandBean(bean.getBuyCarName(), bean.getCount(), bean.getItem_line_money()));
				// 付款用到的参数
				goodsInfo[i] = "";
				goodsInfo[i] += bean.getCars_box_id();
				mon += bean.getItem_line_money() * bean.getCount();
			}

			for (int i = 0; i < goodsInfo.length; i++) {
				Log_info("提交的宝贝信息：goodsInfo [ " + i + " ] = " + goodsInfo[i]);
			}
			Intent intent = new Intent(context, CartActivity.class);
			Bundle bundle = new Bundle();
			bundle.putDouble("money", mon);
			bundle.putStringArray("goodsInfo", goodsInfo);
			intent.putExtras(bundle);
			startActivity(intent);

			break;

		// 全选
		case R.id.checkall:
			if (checkList == null)
				checkList = new ArrayList<Boolean>();
			checkList.clear();
			for (int i = 0; i < list.size(); i++)
				checkList.add(checkall.isChecked());
			adapter.setCheckList(checkList);
			notifyCart(false);
			break;
		}
	}

	private void notifyCart(Boolean resetCheck) {
		context.getSharedPreferences(APPCode.CART, 0).edit().putInt("cartCount", list.size()).commit();
		if (adapter == null) {
			adapter = new CartAdapter(context, list);
			refreshListView.setAdapter(adapter);
		}
		if (resetCheck)
			adapter.initCheckList();

		adapter.notifyDataSetChanged();
		BaseActivity.notifyCartCountAtIndex(context);

		if (list.size() == 0) {
			// Tip("购物车里没有商品");
			refreshListView.setVisibility(View.GONE);
			cartHolder.setVisibility(View.VISIBLE);
		} else {
			refreshListView.setVisibility(View.VISIBLE);
			cartHolder.setVisibility(View.GONE);
		}
		result = result();
		baycar_result.setText(String.valueOf(bArithmetic.div(result, 1.0, 2)));
		// 商品数量
		buy_car_count.setText("商品数量：" + list.size());
		Log_info("-------------> 现在购物车有商品：" + list.size());

		checkList = adapter.getCheckList();
	}

	@Override
	public void onResume() {
		xListViewListener.onRefresh();
		super.onResume();
	}

	@Override
	public void onDestroyView() {
		context.unregisterReceiver(refreshListBR);
		super.onDestroyView();
	}
}
