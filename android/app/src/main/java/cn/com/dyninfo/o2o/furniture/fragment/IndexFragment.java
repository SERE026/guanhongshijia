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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.com.dyninfo.o2o.furniture.activity.game.GameShakeActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.AtBeautyShopActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.BeautyProclaimActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.BeautyProjectActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.BoomSaleActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.GoodsListActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.NearbyTreasuredActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.PromotionSalesActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.WomenStreetActivity;
import cn.com.dyninfo.o2o.furniture.adapter.ViewpagerAdvAdapter;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.AsyncHandle;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView;
import cn.com.dyninfo.o2o.furniture.view.PullToRefreshListView.IXListViewListener;

/**
 * @Description 首页
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-15
 * @updated 2014-9-9 11:24:21 按比例显示（服务器上传图片需要严格按尺寸比例）
 *          <hr>
 *          2014-8-26 11:47:16 加载失败时，显示白色占位图片
 *          <hr>
 *          2014-8-19 16:04:30 更新为线程池（单）
 */
public class IndexFragment extends BaseFragment implements OnClickListener {

	public String PAGE_TITLE = "炫品首页";
	// 内容区域
	private int deviceWidth;
	private Context context;
	/** 大幅广告布局 */
	private View adv_layout;
	private String tag = "IndexFragment";
	/** 顶部 4 个ico : 活动商品 摇一摇 爆品 美丽宣言 **/
	private ImageView fun_ico_1, fun_ico_2, fun_ico_3, fun_ico_4;
	private LayoutParams params = null;
	/** 附近宝贝、炫品热销、女人街、美容项目、身边美容院 */
	private ImageView index_fct1, index_fct2, index_fct3, index_fct4, index_fct5;
	private View index_fct_layout;
	/** 品牌热卖 */
	private View index_brand_layout;
	/** 品牌热卖下功能 */
	private ImageView hot_fct_1, hot_fct_2, hot_fct_3, hot_fct_4, hot_fct_5;
	private String[] HOT_FCT_IDS = new String[5];
	//

	// 显示图片用
	private ImageView[] FUN_FCT_ARRAY = new ImageView[4];
	private ImageView[] INDEX_FCT_ARRAY = new ImageView[5];
	private ImageView[] HOT_FCT_ARRAY = new ImageView[5];
	/** 上下拉刷新 */
	private PullToRefreshListView refreshListView;
	private HomeHandle homeHandle;
	// 广告
	private ViewpagerAdvAdapter adapter;
	private ViewPager viewPager;
	private LinearLayout dot_layout;
	// 首页广告资源
	private List<String> adv_img = new ArrayList<String>();
	private List<String> adv_ids = new ArrayList<String>();
	private List<String> advNames = new ArrayList<String>();

	private Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		deviceWidth = Sys.getScreenWidth(context);
		handler = new Handler();
		homeHandle = new HomeHandle();
		initBroadcast();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.index_frame, container, false);
		initView(view);
		initViewSize();
		xListViewListener.onRefresh();
		initClick();
		return view;
	}

	/**
	 * 广告
	 * 
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-13 11:48:13
	 */
	private void getAdv() {
		getTopBannerAdv();
		// // 获取 游戏优惠 一栏 4 个图片
		int[] funposition = { 1, 2, 3, 4 };
		for (int i = 0; i < FUN_FCT_ARRAY.length; i++) {
			getMenuAdvPic(false, FUN_FCT_ARRAY[i], funposition[i]);
		}
		// 获取 彩色方块 一栏 5 个图片
		int[] indexposition = { 5, 6, 7, 8, 9 };
		for (int i = 0; i < INDEX_FCT_ARRAY.length; i++) {
			getMenuAdvPic(false, INDEX_FCT_ARRAY[i], indexposition[i]);
		}
		// 获取 底部广告 一栏 5 个图片
		int[] hotposition = { 2, 3, 4, 5, 6 };
		for (int i = 0; i < HOT_FCT_ARRAY.length; i++) {
			getMenuAdvPic(true, HOT_FCT_ARRAY[i], hotposition[i]);
		}
		refreshListView.setTime();
	}

	private void getTopBannerAdv() {
		adv_img.clear();
		adv_ids.clear();
		advNames.clear();

		cachedPool().execute(new Runnable() {
			@Override
			public void run() {
				// 获取巨幅广告信息
				String advJson = SyncApi.getIndexAdv(1, context.getSharedPreferences(APPCode.CITY, context.MODE_APPEND)
						.getString(APPCode.CHOICE_CITY_ID, ""));
				try {
					JSONObject object = APP.checkReturnData(advJson, context);
					if (object != null) {
						if (object.has("status"))
							if (object.getInt("status") == ErrorCode.ERROR)
								Tip("请下拉刷新或切换所在城市");
							else if (object.getInt("status") == ErrorCode.SUCCESS) {
								JSONArray array = object.getJSONArray("data");
								for (int i = 0; i < array.length(); i++) {
									object = array.getJSONObject(i);
									adv_img.add(APP.adv_path(object.getString("img")));
									adv_ids.add(object.getString("aadv_id"));
									advNames.add(object.getString("name"));
								}
							}
					}
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 解析成功后清空原布局
							dot_layout.removeAllViews();
							viewPager.removeAllViews();
							startADV();
						}
					});
				} catch (Exception e) {
					APP.exception("IndexFragment ADV Top :", e);
					Tip("获取失败，下拉刷新试试");
				}
			}
		});
	}

	/**
	 * 根据位置展示图片
	 * 
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-25 14:02:52
	 * @update 2014-8-26 11:46:40 加载失败时，显示为白色透明背景
	 *         <hr>
	 *         2014-6-28 11:16:07
	 * */
	private void getMenuAdvPic(final Boolean isAdv, final ImageView imgview, final int position) {
		cachedPool().execute(new Runnable() {
			@Override
			public void run() {

				final String json;
				if (isAdv) {
					json = SyncApi.getIndexAdv(
							position,
							context.getSharedPreferences(APPCode.CITY, context.MODE_APPEND).getString(
									APPCode.CHOICE_CITY_ID, ""));// (底部和底部广告)
				} else {
					json = SyncApi.getIndexMenu(position);// (中间部分菜单)
				}

				handler.post(new Runnable() {

					@Override
					public void run() {

						JSONObject object = APP.checkReturnData(json, context, false);
						if (object != null) {
							try {
								if (object.has("status"))
									if (object.getInt("status") == ErrorCode.ERROR) {
										imgview.setTag(null);
										bmpUtils_short_holder.display(imgview, "assets/img/none_png.png");
										imgview.setBackgroundColor(context.getResources().getColor(R.color.white));
										// Tip("部分信息加载失败，请下拉刷新");
									} else if (object.getInt("status") == ErrorCode.SUCCESS) {
										JSONObject obj = object.getJSONArray("data").getJSONObject(0);
										Log_info("位置 " + position + " 的图片 ：" + APP.img_path(obj.getString("img")));
										final String txt = obj.getString("name");
										final String img = obj.getString("img");
										imgview.setTag(txt);
										if (isAdv) {
											int[] hotposition = { 2, 3, 4, 5, 6 };
											for (int i = 0; i < hotposition.length; i++) {
												if (position == hotposition[i]) {
													HOT_FCT_IDS[i] = obj.getString("aadv_id");
												}
											}
										}
										bmpUtils_short_holder.display(imgview, APP.img_path(img));
										imgview.setBackgroundColor(context.getResources().getColor(R.color.none_color));
									}
							} catch (Exception e) {
								APP.exception("首页每一项图片异常", e);
							}
						}

					}
				});
			}
		});

	}

	private void startADV() {
		// TODO
		if (adapter == null)
			adapter = new ViewpagerAdvAdapter();
		adapter.notifyData(context, handler, viewPager, adv_img, adv_ids, advNames, dot_layout);

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				adv_layout.setBackgroundColor(context.getResources().getColor(R.color.white));
			}
		}, 3000);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.index_fun_ico_1:
			// 活动商品
			startActivity(new Intent(context, PromotionSalesActivity.class));
			break;

		case R.id.index_fun_ico_2:
			// 摇一摇
			startActivity(new Intent(context, GameShakeActivity.class));
			break;

		case R.id.index_fun_ico_3:
			// 爆品
			startActivity(new Intent(context, BoomSaleActivity.class));
			break;

		case R.id.index_fun_ico_4:
			// 美丽宣言
			startActivity(new Intent(context, BeautyProclaimActivity.class));
			break;

		case R.id.index_fct1:
			// 附近宝贝
			startActivity(new Intent(context, NearbyTreasuredActivity.class));
			break;
		case R.id.index_fct2:
			// 会员专区
			Intent intent_fct_2 = new Intent(context, GoodsListActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("page_title", "会员专区");
			bundle.putInt("from", APPCode.VIP_ZONE);
			intent_fct_2.putExtras(bundle);
			startActivityForResult(intent_fct_2, 9527);
			break;
		case R.id.index_fct3:
			// 女人街
			Intent intent_fct_3 = new Intent(context, WomenStreetActivity.class);
			startActivity(intent_fct_3);
			animLeftToRight();
			break;

		case R.id.index_fct4:
			// 美容项目
			startActivity(new Intent(context, BeautyProjectActivity.class));
			break;

		case R.id.index_fct5:
			// 身边美容院
			startActivity(new Intent(context, AtBeautyShopActivity.class));
			break;

		// 炫品热销 5 个广告位
		case R.id.hot_fct_1:
			Intent intent_fct_1 = new Intent(context, GoodsListActivity.class);
			Bundle bundle_fct_1 = new Bundle();
			bundle_fct_1.putString("adv_id", HOT_FCT_IDS[0]);
			bundle_fct_1.putString("page_title", String.valueOf(hot_fct_1.getTag()));
			bundle_fct_1.putInt("from", APPCode.ADV_LIST);
			intent_fct_1.putExtras(bundle_fct_1);
			startActivity(intent_fct_1);
			break;

		case R.id.hot_fct_2:
			Intent intent_hot_fct_2 = new Intent(context, GoodsListActivity.class);
			Bundle bundle_fct_2 = new Bundle();
			bundle_fct_2.putString("adv_id", HOT_FCT_IDS[1]);
			bundle_fct_2.putString("page_title", String.valueOf(hot_fct_2.getTag()));
			bundle_fct_2.putInt("from", APPCode.ADV_LIST);
			intent_hot_fct_2.putExtras(bundle_fct_2);
			startActivity(intent_hot_fct_2);
			break;

		case R.id.hot_fct_3:
			Intent intent_hot_fct_3 = new Intent(context, GoodsListActivity.class);
			Bundle bundle_fct_3 = new Bundle();
			bundle_fct_3.putString("adv_id", HOT_FCT_IDS[2]);
			bundle_fct_3.putString("page_title", String.valueOf(hot_fct_3.getTag()));
			bundle_fct_3.putInt("from", APPCode.ADV_LIST);
			intent_hot_fct_3.putExtras(bundle_fct_3);
			startActivity(intent_hot_fct_3);
			break;

		case R.id.hot_fct_4:
			Intent intent_hot_fct_4 = new Intent(context, GoodsListActivity.class);
			Bundle bundle_fct_4 = new Bundle();
			bundle_fct_4.putString("adv_id", HOT_FCT_IDS[3]);
			bundle_fct_4.putString("page_title", String.valueOf(hot_fct_4.getTag()));
			bundle_fct_4.putInt("from", APPCode.ADV_LIST);
			intent_hot_fct_4.putExtras(bundle_fct_4);
			startActivity(intent_hot_fct_4);
			break;

		case R.id.hot_fct_5:
			Intent intent_hot_fct_5 = new Intent(context, GoodsListActivity.class);
			Bundle bundle_fct_5 = new Bundle();
			bundle_fct_5.putString("adv_id", HOT_FCT_IDS[4]);
			bundle_fct_5.putString("page_title", String.valueOf(hot_fct_5.getTag()));
			bundle_fct_5.putInt("from", APPCode.ADV_LIST);
			intent_hot_fct_5.putExtras(bundle_fct_5);
			startActivity(intent_hot_fct_5);
			break;
		}
	}

	private IXListViewListener xListViewListener = new IXListViewListener() {
		@Override
		public void onRefresh() {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					// 开始拉取
					Log.i("Tip", tag + " 开始刷新 ");
					homeHandle.init(null).execute();
				}
			}, 500);
		}

		@Override
		public void onLoadMore() {
			// 加载更多
			// 不需要写
		}
	};

	class HomeHandle extends AsyncHandle {

		@Override
		protected void errorFinally(Map<String, Object> params) {
			stopLoad();
			Tip("加载失败");
		}

		@Override
		protected void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException {
			getAdv();
			stopLoad();
		}

		@Override
		protected String runTask(Map<String, Object> parameters) {
			return "{\"status\":1}";
		}

	}

	void stopLoad() {
		refreshListView.stopRefresh();
		refreshListView.stopLoadMore();
		refreshListView.setTime();
	}

	/** 计算控件大小 */
	private void initViewSize() {
		// 广告
		params = adv_layout.getLayoutParams();
		params.height = deviceWidth / 2;
		adv_layout.setLayoutParams(params);
		// 4 个不变功能块
		params = fun_ico_1.getLayoutParams();
		params.height = (deviceWidth - Sys.Dp2Px(context, 32)) / 4;
		params.width = params.height;

		fun_ico_1.setLayoutParams(params);
		fun_ico_2.setLayoutParams(params);
		fun_ico_3.setLayoutParams(params);
		fun_ico_4.setLayoutParams(params);
		// 5 张推荐项目
		int space = Sys.Dp2Px(context, 20);// 左右各8dp+中间4dp
		// 右边的小图尺寸 330 * 155
		int smallImgWidth = (deviceWidth - space) / 2;
		int smallImgHeight = smallImgWidth * 155 / 330;
		int layoutHeight = smallImgHeight * 3 + Sys.Dp2Px(context, 8);

		Log_info("首页尺寸(小图)：宽" + smallImgWidth + "，高" + smallImgHeight);

		params = index_brand_layout.getLayoutParams();
		params.width = LayoutParams.MATCH_PARENT;
		params.height = layoutHeight;
		index_fct_layout.setLayoutParams(params);
		index_brand_layout.setLayoutParams(params);

		params = null;
	}

	private void initClick() {
		// 广告下 4 个功能
		fun_ico_1.setOnClickListener(this);
		fun_ico_2.setOnClickListener(this);
		fun_ico_3.setOnClickListener(this);
		fun_ico_4.setOnClickListener(this);
		// 再下面 5个 功能
		index_fct1.setOnClickListener(this);
		index_fct2.setOnClickListener(this);
		index_fct3.setOnClickListener(this);
		index_fct4.setOnClickListener(this);
		index_fct5.setOnClickListener(this);
		// 品牌热卖下 5 个功能
		hot_fct_1.setOnClickListener(this);
		hot_fct_2.setOnClickListener(this);
		hot_fct_3.setOnClickListener(this);
		hot_fct_4.setOnClickListener(this);
		hot_fct_5.setOnClickListener(this);
	}

	private void initView(View view) {
		// 上下拉刷新
		refreshListView = (PullToRefreshListView) view.findViewById(R.id.index_frame_pull_layout);
		refreshListView.addHeaderView(LayoutInflater.from(context).inflate(R.layout.index_main, null));
		refreshListView.setXListViewListener(xListViewListener);
		refreshListView.setPullLoadEnable(false);
		refreshListView.setAdapter(null);

		adv_layout = view.findViewById(R.id.adv_layout);
		// 广告
		viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		dot_layout = (LinearLayout) view.findViewById(R.id.dot_layout);
		// 广告下4个功能入口
		fun_ico_1 = (ImageView) view.findViewById(R.id.index_fun_ico_1);
		fun_ico_2 = (ImageView) view.findViewById(R.id.index_fun_ico_2);
		fun_ico_3 = (ImageView) view.findViewById(R.id.index_fun_ico_3);
		fun_ico_4 = (ImageView) view.findViewById(R.id.index_fun_ico_4);
		FUN_FCT_ARRAY[0] = fun_ico_1;
		FUN_FCT_ARRAY[1] = fun_ico_2;
		FUN_FCT_ARRAY[2] = fun_ico_3;
		FUN_FCT_ARRAY[3] = fun_ico_4;
		// 附近宝贝等5个入口
		index_fct1 = (ImageView) view.findViewById(R.id.index_fct1);
		index_fct2 = (ImageView) view.findViewById(R.id.index_fct2);
		index_fct3 = (ImageView) view.findViewById(R.id.index_fct3);
		index_fct4 = (ImageView) view.findViewById(R.id.index_fct4);
		index_fct5 = (ImageView) view.findViewById(R.id.index_fct5);
		INDEX_FCT_ARRAY[0] = index_fct1;
		INDEX_FCT_ARRAY[1] = index_fct2;
		INDEX_FCT_ARRAY[2] = index_fct3;
		INDEX_FCT_ARRAY[3] = index_fct4;
		INDEX_FCT_ARRAY[4] = index_fct5;
		// 热卖下5个功能
		index_fct_layout = (LinearLayout) view.findViewById(R.id.index_fct_layout);
		index_brand_layout = (LinearLayout) view.findViewById(R.id.index_brand_layout);
		hot_fct_1 = (ImageView) view.findViewById(R.id.hot_fct_1);
		hot_fct_2 = (ImageView) view.findViewById(R.id.hot_fct_2);
		hot_fct_3 = (ImageView) view.findViewById(R.id.hot_fct_3);
		hot_fct_4 = (ImageView) view.findViewById(R.id.hot_fct_4);
		hot_fct_5 = (ImageView) view.findViewById(R.id.hot_fct_5);
		HOT_FCT_ARRAY[0] = hot_fct_1;
		HOT_FCT_ARRAY[1] = hot_fct_2;
		HOT_FCT_ARRAY[2] = hot_fct_3;
		HOT_FCT_ARRAY[3] = hot_fct_4;
		HOT_FCT_ARRAY[4] = hot_fct_5;
	}

	private BroadcastReceiver refreshBR = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.fragment.IndexFragment#refresh")) {
				xListViewListener.onRefresh();
			}
		};
	};

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.fragment.IndexFragment#refresh");
		context.registerReceiver(refreshBR, intentFilter);
	}

	@Override
	public void onDestroy() {
		context.unregisterReceiver(refreshBR);
		super.onDestroy();
	}

}
