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

package cn.com.dyninfo.o2o.furniture.activity.search;

import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.AutoCompleteAdapter;
import cn.com.dyninfo.o2o.furniture.adapter.GoodsListItemAdapter;
import cn.com.dyninfo.o2o.furniture.bean.HotMarketBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author ly
 * @update 2014-9-15 10:42:25 修改搜索类型界面、效果
 *         <hr>
 *         2014-9-10 18:07:18 新增联想功能 by <a
 *         href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 *         <hr>
 *         2014-8-29 16:10:52 优化搜索
 *         <hr>
 *         2014-7-8 09:56:33 更新 list
 * 
 */
@SuppressLint("ResourceAsColor")
public class SearchActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.search;
	private Context context;
	private String PAGE_TITLE = "搜索";
	private PullToRefreshListView refreshListView;
	private GoodsListItemAdapter adapter;
	private Handler handler;
	private Button serach_btn;
	private AutoCompleteTextView key_box;
	private List<HotMarketBean> list;
	private String kw;// keywords
	private int pageno = 1;
	private int serchType = 0;
	private Boolean isLoadMore = false;
	// 候选词
	private List<String> keys;
	private AutoCompleteAdapter<String> completeAdapter;
	// 清空按钮
	private ImageView clear;
	// 搜索类型
	private TextView type_1, type_2, type_3, type_4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		APPManager.getInstance().add(this);
		context = this;
		handler = new Handler();
		initTitleAndClick(context, layoutID, PAGE_TITLE);

		initBundle();
		initView();
		initAdapter();
		initBoxAdapter();
		initClick();
		getQuery();
	}

	private void initBoxAdapter() {
		if (keys == null) {
			keys = new ArrayList<String>();
		}
		keys.add("a");
		keys.add("apply");
		keys.add("assign");
		keys.add("appearance");
		keys.add("adequate");
		keys.add("alternative");
		keys.add("analysis");
		keys.add("affect");
		keys.add("bill");
		keys.add("bear");
		completeAdapter = new AutoCompleteAdapter<String>(context, keys);
		key_box.setAdapter(completeAdapter);
	}

	private void getQuery() {
		if (kw.isEmpty()) {
			Tip("请输入关键词后进行搜索");
			return;
		}
		cachedPool().execute(new Runnable() {
			@Override
			public void run() {
				if (!isLoadMore) {
					list.clear();// 加载更多不清空
				}
				isLoadMore = false;
				String json = SyncApi.getQuery(context, kw, pageno, serchType);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					try {
						if (object.has("status")) {
							if (object.getInt("status") == ErrorCode.SUCCESS) {

								JSONArray jsonArray = object.getJSONArray("data");
								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonObject = jsonArray.getJSONObject(i);
									jsonObject.remove("shopname");
									int id = jsonObject.getInt("goodId");
									String img = jsonObject.getString("image");
									String name = jsonObject.getString("goodName");
									double nowPrice = jsonObject.getDouble("salesMoney");
									double oldPrice = jsonObject.getDouble("bazaarMoney");
									double discount = jsonObject.getDouble("discount");

									list.add(new HotMarketBean(id, img, name, Utils.decimal(nowPrice, 2), Utils
											.decimal(oldPrice, 2), Utils.decimal(discount, 2)));
								}
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								Tip("没有找到结果");
								key_box.requestFocus();
								showKeyboard();
							}

						}
					} catch (Exception e) {
						APP.exception("搜索商品", e);
						Tip("搜索失败，请重试");
					}

					notifyAdapter();
				}else {
					Tip("搜索失败" + APPCode.WEB_NULL);
				}
			}
		});
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		kw = bundle.getString("keywords");
	}

	private void initView() {
		refreshListView = (PullToRefreshListView) findViewById(R.id.content);
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullRefreshEnable(false);
		refreshListView.setPullLoadEnable(false);

		type_1 = (TextView) findViewById(R.id.type_1);
		type_2 = (TextView) findViewById(R.id.type_2);
		type_3 = (TextView) findViewById(R.id.type_3);
		type_4 = (TextView) findViewById(R.id.type_4);

		clear = (ImageView) findViewById(R.id.clear);
		serach_btn = (Button) findViewById(R.id.serach_btn);
		key_box = (AutoCompleteTextView) findViewById(R.id.key_box);

		key_box.setText(kw);
		key_box.requestFocus();
		setImgGone(1);
	}

	private void initAdapter() {
		list = new ArrayList<HotMarketBean>();
		adapter = new GoodsListItemAdapter(context, list);
		refreshListView.setAdapter(adapter);
	}

	private IXListViewListener xListViewListener = new IXListViewListener() {
		@Override
		public void onRefresh() {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					// 开始拉取
				}
			}, 500);
		}

		@Override
		public void onLoadMore() {
			// 加载更多
			++pageno;
			isLoadMore = true;
			getQuery();
		}
	};

	private void initClick() {
		serach_btn.setOnClickListener(this);
		type_1.setOnClickListener(this);
		type_2.setOnClickListener(this);
		type_3.setOnClickListener(this);
		type_4.setOnClickListener(this);
		clear.setOnClickListener(this);

		key_box.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				clear.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
				doComplete(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	/**
	 * @Description 开始联想
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-10 下午6:02:36
	 */
	protected void doComplete(final String key) {
		if (key.length() > 0) {
			cachedPool().execute(new Runnable() {
				@Override
				public void run() {
					String json = SyncApi.getQuery(context, key, 1, 0);
					final JSONObject object = APP.checkReturnData(json, context);
					if (object != null) {
						handler.post(new Runnable() {
							@Override
							public void run() {
								try {
									if (object.has("status")) {
										if (object.getInt("status") == ErrorCode.SUCCESS) {

											keys.clear();

											JSONArray jsonArray = object.getJSONArray("data");
											for (int i = 0; i < jsonArray.length(); i++) {
												JSONObject jsonObject = jsonArray.getJSONObject(i);
												keys.add(jsonObject.getString("goodName"));
											}

											completeAdapter.notifyDataSetChanged();
										} else if (object.getInt("status") == ErrorCode.ERROR) {
											key_box.requestFocus();
										}
									}
								} catch (Exception e) {
									APP.exception("搜索商品", e);
								}
							}
						});
					}
				}
			});
		}
	}

	void stopLoad() {
		refreshListView.stopRefresh();
		refreshListView.stopLoadMore();
		refreshListView.setTime();
	}

	void notifyAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Log_info("正在更新适配器");
				refreshListView.setPullLoadEnable(list.size() % 10 == 0 ? true : false);
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	public void onClick(View v) {
		kw = getTextFromView(key_box);
		switch (v.getId()) {
		case R.id.serach_btn:
			if (kw.isEmpty()) {
				Tip("请输入要查找的商品");
				showKeyboard();
				return;
			}
			serchType = 0;
			getQuery();
			break;

		case R.id.type_1:
			setImgGone(1);
			serchType = 0;
			getQuery();
			break;

		case R.id.type_2:
			setImgGone(2);
			serchType = 1;
			getQuery();
			break;

		case R.id.type_3:
			setImgGone(3);
			serchType = 2;
			getQuery();
			break;

		case R.id.type_4:
			setImgGone(4);
			serchType = 3;
			getQuery();
			break;

		case R.id.clear:
			key_box.setText("");
			break;
		}
	}

	@SuppressLint("ResourceAsColor")
	private void setImgGone(int position) {
		type_1.setBackgroundResource(R.drawable.corner_round_bg_normal_center_right_angle);
		type_2.setBackgroundResource(R.drawable.corner_round_bg_normal_center_right_angle);
		type_3.setBackgroundResource(R.drawable.corner_round_bg_normal_center_right_angle);
		type_4.setBackgroundResource(R.drawable.corner_round_bg_normal_center_right_angle);
		int colorNormal = getResources().getColor(R.color.black_light);
		type_1.setTextColor(colorNormal);
		type_2.setTextColor(colorNormal);
		type_3.setTextColor(colorNormal);
		type_4.setTextColor(colorNormal);
		switch (position) {
		case 1:
			type_1.setBackgroundColor(getResources().getColor(R.color.pink));
			type_1.setTextColor(getResources().getColor(R.color.white));
			break;
		case 2:
			type_2.setBackgroundColor(getResources().getColor(R.color.pink));
			type_2.setTextColor(getResources().getColor(R.color.white));
			break;
		case 3:
			type_3.setBackgroundColor(getResources().getColor(R.color.pink));
			type_3.setTextColor(getResources().getColor(R.color.white));
			break;
		case 4:
			type_4.setBackgroundColor(getResources().getColor(R.color.pink));
			type_4.setTextColor(getResources().getColor(R.color.white));
			break;

		}
	}

}