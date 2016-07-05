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
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.BeautyProclaimDiscussAdapter;
import cn.com.dyninfo.o2o.furniture.bean.BeautyProclaimBean;
import cn.com.dyninfo.o2o.furniture.bean.BeautyProclaimDiscussBean;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;
import cn.com.dyninfo.o2o.furniture.view.LazyLoadScrollView;
import cn.com.dyninfo.o2o.furniture.view.LazyLoadScrollView.OnScrollListener;

/**
 * @Description 美丽宣言
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-23 11:04:19
 * @update 2014-8-20 17:02:37 新增线程池处理
 *         <hr>
 *         2014-6-18 17:55:44
 */
public class BeautyProclaimDetailsActivity extends BaseActivity {

	private int layoutID = R.layout.beauty_proclaim_details;
	private String PAGE_TITLE = "美丽宣言";
	private Context context;
	private Handler handler;
	private int MAX_LENGHT = 230; // 最大输入字数
	private Boolean needRefresh = true;
	private BeautyProclaimBean bean;
	private long id;
	private int PAGE = 1;
	private List<BeautyProclaimDiscussBean> list;
	private ImageView head;
	private LinearLayout imgs_layout;
	private EditText discuss_input;
	private TextView txt_count;
	private TextView btn_sub;
	private BeautyProclaimDiscussAdapter adapter;
	private CustomerListView listview;
	private LazyLoadScrollView scrollView;

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
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				getDetails();
				getDiscuss();
				initClick();
			}
		}, 100);
	}

	private void getDiscuss() {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getBeautyProclaimDiscusses(id, PAGE);
				JSONObject object = APP.checkReturnData(json, context);
				try {
					if (object != null) {
						if (object.has("status"))
							if (object.getInt("status") == ErrorCode.ERROR) {
								Tip("获取评论失败");
							} else if (object.getInt("status") == ErrorCode.SUCCESS) {
								if (list == null)
									list = new ArrayList<BeautyProclaimDiscussBean>();
								JSONArray array = object.getJSONArray("data");
								for (int i = 0; i < array.length(); i++) {
									object = array.getJSONObject(i);
									list.add(new BeautyProclaimDiscussBean(object.getString("txImage"), object
											.getString("content")));
								}
								handler.post(new Runnable() {
									@Override
									public void run() {
										if (adapter == null)
											initAdapter();
										notifyAdapter();
									}
								});
							}
					} else {
						Tip("获取评论失败" + APPCode.WEB_NULL);
					}
				} catch (Exception e) {
					APP.exception("BeautyProclaimDetailsActivity getDiscuss JSON :", e);
					Tip("获取评论失败");
				}
			}
		});
	}

	private void getDetails() {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getBeautyProclaimDetails(id);
				JSONObject object = APP.checkReturnData(json, context);
				try {
					if (object != null) {
						if (object.has("status"))
							if (object.getInt("status") == ErrorCode.ERROR) {
								Tip("获取详情失败");
							} else if (object.getInt("status") == ErrorCode.SUCCESS) {
								object = object.getJSONArray("data").getJSONObject(0);
								bean = new BeautyProclaimBean(id, object.getString("imageSrc"), null, object
										.getString("content"), object.getString("txImage"), object
										.getString("huiyuanname"), object.getInt("bbsnum"));
								handler.post(new Runnable() {
									@Override
									public void run() {
										initValue();
									}
								});
							}
					} else {
						Tip("获取详情失败" + APPCode.WEB_NULL);
					}
				} catch (Exception e) {
					APP.exception("BeautyProclaimDetailsActivity getDetails JSON :", e);
					Tip("获取详情失败");
				}
			}
		});
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		if (bundle == null) {
			return;
		}
		id = bundle.getLong("id", 0);
	}

	private void initAdapter() {
		adapter = new BeautyProclaimDiscussAdapter(context, list);
		listview.setAdapter(adapter);
	}

	private void initClick() {
		pauseDisplay(listview);
		scrollView.getView();
		scrollView.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onTop() {
			}

			@Override
			public void onScroll() {
			}

			@Override
			public void onBottom() {
				try {
					if (needRefresh) {
						needRefresh = false;
						if (list.size() != 0 && list.size() % 10 == 0) {
							Log_info("美丽宣言评论 已加载更多");
							++PAGE;
							getDiscuss();
						} else {
							Log_info("美丽宣言评论 没有更多评论了");
							Tip("没有更多评论了");
						}
						needRefresh = true;
					}
				} catch (Exception e) {
				}
			}
		});

		discuss_input.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				int size = MAX_LENGHT - getTextFromView(discuss_input).length();
				txt_count.setText(size + "");
				if ((MAX_LENGHT - count) > 50)
					txt_count.setTextColor(getResources().getColor(R.color.gray));
				else
					txt_count.setTextColor(getResources().getColor(R.color.pink));
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		btn_sub.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (getTextFromView(discuss_input, true, false).length() == 0) {
					Tip("请先输入评价哦");
				} else {
					discuss_input.clearFocus();
					cachedPool().execute(new Runnable() {

						@Override
						public void run() {
							handler.post(new Runnable() {

								@Override
								public void run() {
									LoadingDialog dialog = new LoadingDialog(context);
									dialog.show();
									String msg = getTextFromView(discuss_input, false, true);
									Log_info("评价内容：" + msg);
									String json = SyncApi.postBeautyProclaimDiscusses(id, msg);
									JSONObject object = APP.checkReturnData(json, context);
									try {
										if (object != null && object.has("status")) {
											if (object.getInt("status") == ErrorCode.SUCCESS) {
												Tip("评论成功");
												handler.post(new Runnable() {
													@Override
													public void run() {
														discuss_input.setText("");
													}
												});
												list.add(new BeautyProclaimDiscussBean(
														getLastLocalUserInfoInstance(context).head, msg));
												notifyAdapter();
											} else
												Tip("评论失败");
										}
									} catch (Exception e) {
										APP.exception("btn_sub Click", e);
									}
									dialog.dismiss();
								}
							});
						}
					});
				}
			}
		});
	}

	void notifyAdapter() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
			}
		});
	}

	private void initValue() {
		LayoutParams params = head.getLayoutParams();
		params.height = Sys.getScreenWidth(context) / 9;
		params.width = Sys.getScreenWidth(context) / 9;
		head.setLayoutParams(params);
		bmpUtils_short_holder.display(head, APP.head_path(bean.getHead()));
		((TextView) findViewById(R.id.name)).setText(bean.getName());
		((TextView) findViewById(R.id.count)).setText("发帖" + bean.getCount());
		((TextView) findViewById(R.id.goods_desc)).setText(bean.getDesc().equals("null") ? "" : bean.getDesc() + "");

		imgs_layout.removeAllViews();
		String imgs[] = bean.getImg().split(";");
		for (int i = 0; i < imgs.length; i++) {
			View view = LayoutInflater.from(context).inflate(R.layout.beauty_proclaim_details_pic, null);
			bmpUtils_short_holder.display(view.findViewById(R.id.img), APP.beauty_proclaim_path(imgs[i]));
			imgs_layout.addView(view);
		}
	}

	private void initView() {
		imgs_layout = (LinearLayout) findViewById(R.id.imgs_layout);
		head = (ImageView) findViewById(R.id.head);
		discuss_input = (EditText) findViewById(R.id.discuss_input);
		txt_count = (TextView) findViewById(R.id.txt_count);
		btn_sub = (TextView) findViewById(R.id.btn_submit_discuss);
		listview = (CustomerListView) findViewById(R.id.listview);
		scrollView = (LazyLoadScrollView) findViewById(R.id.lazyScrollview);
	}

	@Override
	public void onBackPressed() {
		bmpUtils_short_holder.stopTasks();
		myfinish();
	}

}