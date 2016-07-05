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

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.search.SearchActivity;
import cn.com.dyninfo.o2o.furniture.adapter.AutoCompleteAdapter;
import cn.com.dyninfo.o2o.furniture.adapter.GoodsListItemAdapter;
import cn.com.dyninfo.o2o.furniture.bean.HotMarketBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Utils;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @Description 搜索
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4
 * @editor ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update_date 2014-9-10 18:07:18 新增联想功能
 *              <hr>
 *              2014-7-5 15:31:13 更新列表点击事件
 */
public class SearchFragment extends BaseFragment implements OnClickListener {

	public String PAGE_TITLE = "搜索";
	private Context context;
	private Handler handler;
	private PullToRefreshListView refreshListView;
	private GoodsListItemAdapter adapter;
	private Button btn_search;
	private AutoCompleteTextView key_box;
	private List<HotMarketBean> list;
	// 候选词
	private List<String> keys;
	private AutoCompleteAdapter<String> completeAdapter;
	// 清空按钮
	private ImageView clear;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		handler = new Handler();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.search_main, container, false);
		initView(view);
		initBoxAdapter();
		initValuse();
		initClick();
		return view;
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

	private void initValuse() {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {

				String json = SyncApi.getRecomList(context);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					try {
						if (object.has("status")) {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								JSONArray jsonArray = object.getJSONArray("data");
								list = new ArrayList<HotMarketBean>();
								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonObject = jsonArray.getJSONObject(i);

									int id = jsonObject.getInt("goods_id");
									String img = jsonObject.getString("imgUrl");
									String name = jsonObject.getString("name");
									double nowPrice = jsonObject.getDouble("salesMoney");
									double oldPrice = jsonObject.getDouble("bazaarMoney");
									double discount = jsonObject.getDouble("discount");

									list.add(new HotMarketBean(id, img, name, Utils.decimal(nowPrice, 2), Utils
											.decimal(oldPrice, 2), Utils.decimal(discount, 2)));
								}
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								Tip("没有相关的商品");
							}
						}
					} catch (Exception e) {
					}
				}
				notifyAdapter();

			}
		});
	}

	private void initClick() {
		btn_search.setOnClickListener(this);
		clear.setOnClickListener(this);

		key_box.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(final CharSequence s, int start, int before, int count) {
				// 设置清除按钮
				clear.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
				// 查询关联词
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

	private void initView(View view) {
		refreshListView = (PullToRefreshListView) view.findViewById(R.id.search_frame_pull_layout);
		refreshListView.setPullLoadEnable(false);
		refreshListView.setPullRefreshEnable(false);

		clear = (ImageView) view.findViewById(R.id.clear);
		clear.setVisibility(View.GONE);
		btn_search = (Button) view.findViewById(R.id.serach_btn);
		key_box = (AutoCompleteTextView) view.findViewById(R.id.key_box);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.serach_btn:
			String kw = BaseActivity.getTextFromView(key_box, true, false);
			if (kw.isEmpty()) {
				Tip("请输入关键词");
				key_box.requestFocus();
				return;
			}
			Intent intent = new Intent(context, SearchActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("keywords", kw);
			intent.putExtras(bundle);
			startActivity(intent);
			animLeftToRight();
			break;
		case R.id.clear:
			key_box.setText("");
			break;
		}
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	void notifyAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (adapter == null) {
					adapter = new GoodsListItemAdapter(context, list);
					refreshListView.setAdapter(adapter);
				}
				adapter.notifyDataSetChanged();
			}
		});
	}

}
