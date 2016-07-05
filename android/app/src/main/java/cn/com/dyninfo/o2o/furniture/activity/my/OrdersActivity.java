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
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.OrdersAdapter;
import cn.com.dyninfo.o2o.furniture.adapter.ViewPagerAdapter;
import cn.com.dyninfo.o2o.furniture.bean.OrderBean;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;
import cn.com.dyninfo.o2o.furniture.listener.SlideTabOnClickListener;
import cn.com.dyninfo.o2o.furniture.listener.ViewPagerOnPageChangeListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.view.CusHoriScrollView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;
import cn.com.dyninfo.o2o.furniture.widget.SlidePagerUtil;

/**
 * @Description 我的订单
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-13 15:33:11
 * @update 2014-7-8 09:34:40 支持点击tab切换
 */
public class OrdersActivity extends BaseActivity {

	private String PAGE_TITLE = "我的订单";
	private String tag = " OrdersActivity ";
	private int layoutID = R.layout.slide_viewpager_frame;
	private Context context;
	private Handler handler;
	private LayoutInflater inflater;
	private LayoutParams params;
	private LinearLayout menu_layout;// 顶部 tab layou
	private ViewPager viewPager;// 页卡内容
	private List<View> view_list; // Tab页面列表
	private RelativeLayout slide_line_layout;// 动画图片
	// 顶部tab文本
	private String[] tabs = { "有效", "未付款", "已付款", "交易完成", "无效" };
	// Tab 文本集
	private List<TextView> tab_tv_list;
	// Tab Tab 集
	private List<RelativeLayout> tab_layout_list;
	// ListView 集
	private List<PullToRefreshListView> listview_list;
	private int[] PAGE_ARRAY = { 1, 1, 1, 1, 1 };
	private OrdersAdapter[] ADAPTER_ARRAY = new OrdersAdapter[5];
	private OrderListHandler[] HANDLER_ARRAY = { new OrderListHandler(), new OrderListHandler(),
			new OrderListHandler(), new OrderListHandler(), new OrderListHandler() };
	private List<List<OrderBean>> ORDER_LIST_ARRAY = new ArrayList<List<OrderBean>>();
	private List<List<OrderGoodsBean>> ORDER_ITEM_LIST_ARRAY = new ArrayList<List<OrderGoodsBean>>();
	private ViewPagerAdapter viewpager_adapter;
	private CusHoriScrollView horiScrollView;// 顶部选项卡水平scroll
	private RelativeLayout scroll_son_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		handler = new Handler();

		initView();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				initDate();
				initViewPagerAndAdapter();
				initBroadcast();
			}
		}, 100);
	}

	protected void initDate() {
		for (int i = 0; i < PAGE_ARRAY.length; i++) {
			ORDER_LIST_ARRAY.add(new ArrayList<OrderBean>());
		}
		for (int i = 0; i < PAGE_ARRAY.length; i++) {
			ORDER_ITEM_LIST_ARRAY.add(null);
		}
		for (int i = 0; i < PAGE_ARRAY.length; i++) {
			ADAPTER_ARRAY[i] = new OrdersAdapter(context, ORDER_LIST_ARRAY.get(i));
		}
		// 获取页卡 1
		new Listener(0).getListener().onRefresh();
	}

	protected void initListAdapter() {
		for (int i = 0; i < PAGE_ARRAY.length; i++) {
			listview_list.get(i).setPullRefreshEnable(true);
			listview_list.get(i).setPullLoadEnable(true);
			listview_list.get(i).setXListViewListener(new Listener(i).getListener());
			listview_list.get(i).setAdapter(ADAPTER_ARRAY[i]);
		}
	}

	class Listener {
		int position = 0;

		public Listener(final int position) {
			this.position = position;
		}

		public IXListViewListener getListener() {
			return xlistener;
		}

		IXListViewListener xlistener = new IXListViewListener() {
			@Override
			public void onRefresh() {
				new Handler(getMainLooper()).postDelayed(new Runnable() {
					@Override
					public void run() {
						Log_warn("正在刷新数据，页卡：" + position);
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("position", position);
						for (int i = 0; i < PAGE_ARRAY.length; i++) {
							if (i == position) {
								PAGE_ARRAY[i] = 1;
								map.put("page", PAGE_ARRAY[i]);
								HANDLER_ARRAY[i].init(map).execute();
							}
						}
					}
				}, 0);
			}

			@Override
			public void onLoadMore() {
				Log_warn("正在加载更多，页卡：" + position);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("position", position);
				for (int i = 0; i < PAGE_ARRAY.length; i++) {
					if (i == position) {
						++PAGE_ARRAY[i];
						map.put("page", PAGE_ARRAY[i]);
						HANDLER_ARRAY[i].init(map).execute();
					}
				}
			}
		};
	}

	class OrderListHandler extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			int position = (Integer) params.get("position");
			stopLoad(position);
			Log_error("加载失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			decodeJson((Integer) parameters.get("position"), json);
			stopLoad((Integer) parameters.get("position"));
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			// code 和 position 一样
			return SyncApi.getOrderList((Integer) parameters.get("position"), (Integer) parameters.get("page"));
		}

	}

	private void stopLoad(int position) {
		listview_list.get(position).stopRefresh();
		listview_list.get(position).stopLoadMore();
	}

	public void decodeJson(int position, JSONObject object) {
		try {
			if (object != null && object.has("status")) {
				if (object.getInt("status") == ErrorCode.ERROR) {
					checkValueSize(position);
				} else if (object.getInt("status") == ErrorCode.SUCCESS) {
					JSONArray array = object.getJSONArray("data");
					for (int fuck = 0; fuck < PAGE_ARRAY.length; fuck++) {
						if (fuck == position) {
							Log_info("----------> 正在解析页面 " + position + " 数据....");
							if (PAGE_ARRAY[position] == 1)
								ORDER_LIST_ARRAY.get(position).clear();
							for (int i = 0; i < array.length(); i++) {
								JSONObject obj_signle = array.getJSONObject(i);
								JSONArray array_item = obj_signle.getJSONArray("orderProductList");
								ORDER_ITEM_LIST_ARRAY.set(position, new ArrayList<OrderGoodsBean>());
								for (int j = 0; j < array_item.length(); j++) {
									JSONObject object_item = array_item.getJSONObject(j);
									ORDER_ITEM_LIST_ARRAY.get(position).add(
											new OrderGoodsBean(object_item.getString("name"), object_item
													.getDouble("goodMoney"), object_item.getInt("num")));
								}
								ORDER_LIST_ARRAY.get(position).add(
										new OrderBean(obj_signle.getString("order_id"), Integer.valueOf(obj_signle
												.getString("state")), obj_signle.getString("order_id"), obj_signle
												.getString("creatTime"), ORDER_ITEM_LIST_ARRAY.get(position),
												obj_signle.getDouble("countMoney"), obj_signle
														.getDouble("shippingPrice")));
							}
							notifyAdapter(ADAPTER_ARRAY[position]);
						}
					}
					showPagerHolder(position, false);
					listview_list.get(position).setTime();
					int size = ORDER_LIST_ARRAY.get(position).size();
					listview_list.get(position).setPullLoadEnable(size == 0 ? false : size % 10 == 0 ? true : false);
				}
			}
		} catch (Exception e) {
			APP.exception(" OrdersActivity decodeJson EXCEPTION: ", e);
		}
	}

	// 跳转到详情页
	private BroadcastReceiver orderBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#detail")) {
				Bundle bundle = new Bundle();
				bundle.putString("orderNo", intent.getStringExtra("id"));
				intent = new Intent(context, OrderDetailsActivity.class);
				intent.putExtras(bundle);
				startActivityForResult(intent, APPCode.EDIT_ADDRESS);
			} else if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#change")) {
				new Listener(intent.getIntExtra("position", 0)).getListener().onRefresh();
			}
		}
	};

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#detail");
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#change");
		registerReceiver(orderBroadcastReceiver, intentFilter);
	}

	private void initView() {
		inflater = LayoutInflater.from(context);
		horiScrollView = (CusHoriScrollView) findViewById(R.id.hs);
		scroll_son_layout = (RelativeLayout) findViewById(R.id.scroll_son_layout);
		// slide line and pager
		slide_line_layout = (RelativeLayout) findViewById(R.id.slide_line_layout);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		// viewpager 界面：
		view_list = new ArrayList<View>();
		for (int i = 0; i < tabs.length; i++) {
			view_list.add(inflater.inflate(R.layout.pulltorefresh, null));
		}
		viewpager_adapter = new ViewPagerAdapter(view_list);
		// ListView
		listview_list = new ArrayList<PullToRefreshListView>();
		for (int i = 0; i < view_list.size(); i++) {
			listview_list.add((PullToRefreshListView) view_list.get(i).findViewById(R.id.refreshlist));
		}
		// tab 布局
		tab_tv_list = new ArrayList<TextView>();
		tab_layout_list = new ArrayList<RelativeLayout>();
		menu_layout = (LinearLayout) findViewById(R.id.slide_main_tab_layout);
		menu_layout.removeAllViews();
		params = menu_layout.getLayoutParams();
		for (int i = 0; i < tabs.length; i++) {
			View view = inflater.inflate(R.layout.slide_tab_textview, null);
			RelativeLayout tab_layout = (RelativeLayout) view.findViewById(R.id.tab_layout);
			TextView tv = (TextView) view.findViewById(R.id.tab_tv);
			tab_layout.setId(i);
			tv.setText(tabs[i]);
			params.width = SlidePagerUtil.getItemWidth(context);
			params.height = LayoutParams.WRAP_CONTENT;
			tab_layout.setLayoutParams(params);
			tab_layout.setOnClickListener(new SlideTabOnClickListener(viewPager, i));
			menu_layout.addView(tab_layout, i);

			tab_tv_list.add(tv);
			tab_layout_list.add(tab_layout);
		}

		params.height = LayoutParams.WRAP_CONTENT;
		params.width = SlidePagerUtil.getItemWidth(context) * tabs.length;
		menu_layout.setLayoutParams(params);

		params = null;
	}

	private void initViewPagerAndAdapter() {
		viewPager.setAdapter(viewpager_adapter);
		viewPager.setOnPageChangeListener(new ViewPagerOnPageChangeListener(context, scroll_son_layout, tab_tv_list,
				slide_line_layout, APPCode.ORDER));
		viewPager.setCurrentItem(0);
		initListAdapter();
	}

	private void notifyAdapter(final OrdersAdapter adapter) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
			}
		});
	}

	private void checkValueSize(int position) {
		if (PAGE_ARRAY[position] == 1) {
			Log_error(tabs[position] + "订单获取失败");
			// Tip("没有获取到" + tabs[position] + "订单");
			showPagerHolder(position, true);
		} else
			Tip("没有了");
	}

	/** 展示占位图 */
	private void showPagerHolder(int position, Boolean needHolder) {
		view_list.get(position).findViewById(R.id.holder).setVisibility(View.GONE);
		view_list.get(position).findViewById(R.id.refreshlist).setVisibility(View.VISIBLE);
		if (needHolder) {
			view_list.get(position).findViewById(R.id.holder).setVisibility(View.VISIBLE);
			view_list.get(position).findViewById(R.id.refreshlist).setVisibility(View.GONE);
			((TextView) view_list.get(position).findViewById(R.id.txt)).setText("您没有" + tabs[position] + "的订单");
			view_list.get(position).findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					findViewById(R.id.index_layout).performClick();
				}
			});
		}
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(orderBroadcastReceiver);
		super.onDestroy();
	}

}