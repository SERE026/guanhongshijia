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

package cn.com.dyninfo.o2o.furniture.activity.details;

import java.util.ArrayList;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.game.GameClick;
import cn.com.dyninfo.o2o.furniture.activity.game.GameTurntable;
import cn.com.dyninfo.o2o.furniture.activity.home.GoodsListActivity;
import cn.com.dyninfo.o2o.furniture.adapter.SpecAdapter;
import cn.com.dyninfo.o2o.furniture.bean.OtherBuyBean;
import cn.com.dyninfo.o2o.furniture.bean.SpecBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.share.Share;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.util.Utils;

/**
 * @Description 商品详情页面
 * @author ly
 * @editor <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-7-31 16:19:54 新增去店铺功能 by <a
 *          href="http://t.cn/RvIApP5">ceychen</a>
 *          <hr>
 *          2014-7-10 18:50:33 颠覆 webView 实现方式 by <a
 *          href="http://t.cn/RvIApP5">ceychen</a>
 */
public class GoodsDetailsActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.goods_details;
	private String PAGE_TITLE = "商品介绍";
	private String tag = "GoodsDetailsActivity";
	private Context context;
	private Handler handler;
	private Button share;
	// 按钮
	private TextView play_game, add_cart;
	private Bundle bundle;
	private TextView g_name;
	private String name;
	private String img;
	/** 活动id **/
	private int actId;
	public int goodId;
	private double old;
	private double now;
	// 大家还买了
	private LinearLayout other_one, other_two;
	private ImageView other_one_img, other_two_img;
	private TextView other_one_txt, other_one_now_price, other_one_old_price, other_two_txt, other_two_now_price,
			other_two_old_price, ps_tv;
	private List<OtherBuyBean> listOtherBuy;
	// 宝贝详情
	private WebView webViewLeft, webViewRight;
	private TextView tabLeft, tabRight;
	/** 是否是游戏：-1 不是活动商品，0 是活动但不是游戏，1 点点，2 转盘 */
	private int gameType = -1;// 不是活动商品
	// 该商品归属店铺信息
	private String storeID = null, storeName = null;
	private Object position;
	private TextView store_name;
	// 尺码、颜色等规格信息
	private GridView gridView;
	private List<SpecBean> listSpec;
	private SpecAdapter specAdapter;
	private TextView specName;
	private LinearLayout spec_layout;
	private Boolean hasSpec;
	// 购买数量
	private TextView sub, add;
	private EditText count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initBundle();
		initView();
		initClick();
		initValue();
		initOtherValues();
		initShareIcoAndPrice();
	}

	private void initBundle() {
		bundle = getIntent().getExtras();
		actId = bundle.getInt("actid");
		goodId = bundle.getInt("id");
		name = bundle.getString("name");
		img = bundle.getString("img");
		old = bundle.getDouble("old");
		now = bundle.getDouble("now");
		if (actId == 0) {
			gameType = -1;
		}
	}

	private void initValue() {
		// 获取商品额外信息
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getPromotionDetails(goodId, actId, getLastLocalUserInfoInstance(context).uid);
				// 这里的json包含html标签，处理一下
				try {
					json = json.replaceAll("</?[a-zA-Z]+[^><]*>", "").replaceAll("(^\\s*)|(\\s*$)", "");
				} catch (Exception e) {
					APP.exception("去除描述中的html标签", e);
				}
				final JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								handler.post(new Runnable() {
									@Override
									public void run() {
										try {
											// 备注
											String str = object.getString("ps");
											if (!str.isEmpty()) {
												visibleView(ps_tv, true);
												ps_tv.setText(str);
											}
											if (actId != 0) {
												if (object.has("gameName")) {
													if (object.getString("gameName").equals("diandian")) {
														// 点击游戏
														gameType = 1;
													} else if (object.getString("gameName").equals("zhuanpan")) {
														gameType = 2;
													}
												} else {
													gameType = 0;
												}
											} else {
												gameType = -1;
											}
											initGame();
										} catch (JSONException e) {
											e.printStackTrace();
										}
										// 初始化活动商品
										if (gameType != -1) {
											add.setAlpha(0.8f);
											sub.setAlpha(0.8f);
											add.setEnabled(false);
											sub.setEnabled(false);
											count.setEnabled(false);
										}
									}
								});
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								// Tip("获取商品详情失败，请重试");
							}

						} catch (JSONException e) {
							APP.exception(tag, e);
						}

					}
				} else {
					// 这里是获取附加信息，不用提示
				}
			}
		});
		// 获取商品归属店铺
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getStoreByGoods(String.valueOf(goodId));
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								// {"status":0,"data":[{"shopid":"70","shopename":"炫品妆成德阳试用中心","num":"0"},]}
								JSONArray array = object.getJSONArray("data");
								for (int i = 0; i < array.length(); i++) {
									object = array.getJSONObject(i);
									storeName = object.getString("shopename");
									final long rec = object.getLong("num");
									storeID = object.getString("shopid");
									handler.post(new Runnable() {
										@Override
										public void run() {
											((TextView) findViewById(R.id.sell_rec)).setText("成交记录" + rec + "件");
											store_name.setText(storeName);
											store_name.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);// 下划线
										}
									});
								}
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								// Tip("获取店铺信息失败，请重试");
							}
						} catch (JSONException e) {
							APP.exception(tag, e);
						}
					}
				} else {
					// 这里是没有获取到宝贝的归属店铺
				}
			}
		});
		// TODO 获取商品参数信息
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				hasSpec = false;
				if (hadSpec(goodId)) {
					if (specItems != null) {
						initAdapter();
						hasSpec = true;
						for (int i = 0; i < specItems.length; i++) {
							listSpec.add(new SpecBean(specItemsids[i], specItems[i]));
						}
						notifySpecAdapter();
					}
				}
				visibleView(spec_layout, hasSpec);
			}
		});
	}

	protected void notifySpecAdapter() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				specName.setText("请选择" + specTitle);
				specAdapter.notifyDataSetChanged();
			}
		});
	}

	private void initAdapter() {

		if (listSpec == null) {
			listSpec = new ArrayList<SpecBean>();
			specAdapter = new SpecAdapter(context, listSpec);
			handler.post(new Runnable() {

				@Override
				public void run() {
					gridView.setAdapter(specAdapter);
				}
			});
		}
	}

	private void initGame() {
		if (gameType == 1 || gameType == 2) {
			play_game.setVisibility(View.VISIBLE);
		} else {
			add_cart.setVisibility(View.VISIBLE);
		}
	}

	private void initShareIcoAndPrice() {
		share.setVisibility(View.VISIBLE);
		share.setBackgroundResource(R.drawable.ico_share);
		LayoutParams params = share.getLayoutParams();
		params.height = Sys.Dp2Px(context, 35);
		params.width = Sys.Dp2Px(context, 35);
		share.setLayoutParams(params);

		// 原价，删除线
		((TextView) findViewById(R.id.before_price)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		((TextView) findViewById(R.id.before_price)).setText("专柜价：" + Utils.decimal(old, 2) + " 元");
		// 现价
		((TextView) findViewById(R.id.now_price)).setText("炫品价：" + Utils.decimal(now, 2) + " 元");
		Log_info("---------> 已经设置好价格： now = " + now + "，old =  " + old);
	}

	/**
	 * @Description 大家还买了
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	private void initOtherValues() {
		if (listOtherBuy == null)
			listOtherBuy = new ArrayList<OtherBuyBean>();
		listOtherBuy.clear();
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				String json = SyncApi.getOtherPeopleBuy(context);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								JSONArray jsonArray = object.getJSONArray("data");
								JSONObject jsonObject;
								for (int i = 0; i < jsonArray.length(); i++) {
									jsonObject = jsonArray.getJSONObject(i);
									listOtherBuy.add(new OtherBuyBean(jsonObject.getString("goods_id"), jsonObject
											.getString("name"), jsonObject.getString("shopname"), jsonObject
											.getString("imgUrl"), jsonObject.getDouble("bazaarMoney"), jsonObject
											.getDouble("salesMoney")));
								}
								setOtherBuy();
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								// Tip("服务器异常，请重试");
							}
						} catch (JSONException e) {
							Tip("服务器异常，请重试");
							APP.exception("", e);
						}
					}
				}else {
					//没有获取到其他人也买了
				}
			}
		});
	}

	private void setOtherBuy() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				for (int j = 0; j < listOtherBuy.size(); j++) {
					if (j == 0) {
						bmpUtils_short_holder.display(other_one_img, listOtherBuy.get(j).getImg());
						other_one_txt.setText(listOtherBuy.get(j).getName());
						other_one_now_price.setText(Utils.decimal(listOtherBuy.get(j).getNowPrice(), 2) + "元");
						other_one_old_price.setText(Utils.decimal(listOtherBuy.get(j).getBeforePrice(), 2) + "元");
					} else if (j == 1) {
						bmpUtils_short_holder.display(other_two_img, listOtherBuy.get(j).getImg());
						other_two_txt.setText(listOtherBuy.get(j).getName());
						other_two_now_price.setText(Utils.decimal(listOtherBuy.get(j).getNowPrice(), 2) + "元");
						other_two_old_price.setText(Utils.decimal(listOtherBuy.get(j).getBeforePrice(), 2) + "元");
					}
				}
			}
		});
	}

	private void initView() {
		// 规格
		spec_layout = (LinearLayout) findViewById(R.id.spec_layout);
		specName = (TextView) findViewById(R.id.type);
		gridView = (GridView) findViewById(R.id.gridview);
		// 数量
		sub = (TextView) findViewById(R.id.sub);
		add = (TextView) findViewById(R.id.add);
		count = (EditText) findViewById(R.id.count);
		// 附加信息
		ps_tv = (TextView) findViewById(R.id.ps);

		share = (Button) findViewById(R.id.com_introduce_include).findViewById(R.id.top_btn_1);
		play_game = (TextView) findViewById(R.id.play_game);
		add_cart = (TextView) findViewById(R.id.add_cart);
		store_name = (TextView) findViewById(R.id.store_name);

		g_name = (TextView) findViewById(R.id.name);
		g_name.setText(name);
		bmpUtils_short_holder.display(findViewById(R.id.goods_img), img);
		/** 大家还买了 */
		other_one = (LinearLayout) findViewById(R.id.other_one);
		other_two = (LinearLayout) findViewById(R.id.other_two);
		// 1
		other_one_img = (ImageView) findViewById(R.id.other_one_img);
		other_one_txt = (TextView) findViewById(R.id.other_one_txt);
		other_one_now_price = (TextView) findViewById(R.id.other_one_now_price);
		other_one_old_price = (TextView) findViewById(R.id.other_one_old_price);
		other_one_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		// 2
		other_two_img = (ImageView) findViewById(R.id.other_two_img);
		other_two_txt = (TextView) findViewById(R.id.other_two_txt);
		other_two_now_price = (TextView) findViewById(R.id.other_two_now_price);
		other_two_old_price = (TextView) findViewById(R.id.other_two_old_price);
		other_two_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

		visibleView(spec_layout, false);
		// 2014-7-10 15:02:44 修改宝贝详情显示方法
		tabLeft = (TextView) findViewById(R.id.tabLeft);
		tabRight = (TextView) findViewById(R.id.tabRight);
		webViewLeft = (WebView) findViewById(R.id.webviewLeft);
		webViewRight = (WebView) findViewById(R.id.webviewRight);
		WebViewVisible(0);
		initWebView(webViewLeft);
		initWebView(webViewRight);

		// 初始化加载
		Log_info("宝贝详情页面：" + "http://www.xpzc.com/html/aactive/goodstuwen?goodId=" + goodId);
		webViewLeft.loadUrl("http://www.xpzc.com/html/aactive/goodstuwen?goodId=" + goodId);
		webViewRight.loadUrl("http://www.xpzc.com/html/aactive/saidantuwen?goodId=" + goodId + "&pageno=1");
	}

	private void visibleView(final View view, final Boolean show) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				view.setVisibility(show ? View.VISIBLE : View.GONE);
			}
		});
	}

	private void WebViewVisible(int position) {
		switch (position) {
		case 0:
			tabLeft.setTextColor(getResources().getColor(R.color.pink));
			tabRight.setTextColor(getResources().getColor(R.color.black_light));
			webViewLeft.setVisibility(View.VISIBLE);
			webViewRight.setVisibility(View.GONE);
			break;
		case 1:
			tabLeft.setTextColor(getResources().getColor(R.color.black_light));
			tabRight.setTextColor(getResources().getColor(R.color.pink));
			webViewLeft.setVisibility(View.GONE);
			webViewRight.setVisibility(View.VISIBLE);
			break;
		}
	}

	private void initWebView(final WebView webView) {
		WebSettings settings = webView.getSettings();
		settings.setDomStorageEnabled(true);
		webView.setInitialScale(100);// 页面缩小百分比
		// 支持缩放
		settings.setSupportZoom(true);
		// 启用内置多点缩放
		settings.setBuiltInZoomControls(true);
		// 隐藏放大缩小按钮
		settings.setDisplayZoomControls(false);
		// 适应屏幕
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);
		// 无滚动条
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		webView.setWebChromeClient(new WebChromeClient());
		webView.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		webView.setOnTouchListener(new WebViewTouch(webView));
	}

	class WebViewTouch implements OnTouchListener {
		WebView webView;
		float DownX = 0, DownY = 0;

		public WebViewTouch(WebView webView) {
			this.webView = webView;
		}

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			System.out.println("webView.getScaleY() = " + webView.getScaleY());

			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				DownX = event.getX();
				DownY = event.getY();
				// 手指按下，告诉父控件不要拦截事件
				webView.requestDisallowInterceptTouchEvent(true);
			}

			if (event.getAction() == MotionEvent.ACTION_MOVE) {
				float moveX = event.getX() - DownX;// X轴距离
				float moveY = event.getY() - DownY;// y轴距离
				// 如果是向上滑，滑动到顶部则放弃拦截
				if (moveY > 0) {
					// 滑动到了顶部
					if (webView.getScaleY() == 0) {
						webView.requestDisallowInterceptTouchEvent(false);
					}
				}
				// 如果是向下滑，滑动到了底部则放弃拦截
				else if (moveY < 0) {
					// 滑动到了底部
					if ((int) (webView.getContentHeight() * webView.getScale()) == (webView.getHeight() + webView
							.getScrollY()))
						webView.requestDisallowInterceptTouchEvent(false);
				}
				// Log_info("手势：DownX = " + DownX + "，DownY" + DownY +
				// "，moveX = " + moveX + "，moveY = " + moveY);
			}
			if (event.getAction() == MotionEvent.ACTION_UP) {
				// 手指抬起，告诉父控件可以拦截事件
				webView.requestDisallowInterceptTouchEvent(false);
			}
			return false;
		}
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		play_game.setOnClickListener(this);
		add_cart.setOnClickListener(this);
		store_name.setOnClickListener(this);
		share.setOnClickListener(this);
		other_one.setOnClickListener(this);
		other_two.setOnClickListener(this);
		// 详情选项卡
		tabLeft.setOnClickListener(this);
		tabRight.setOnClickListener(this);
		// 数量
		sub.setOnClickListener(this);
		add.setOnClickListener(this);
		count.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (Integer.valueOf(s.toString()) <= 1) {
					sub.setEnabled(false);
					sub.setAlpha(0.8f);
				} else {
					sub.setEnabled(true);
					sub.setAlpha(1.0f);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	@Override
	public void onClick(View v) {
		int numb = 0;
		try {
			numb = Integer.valueOf(getTextFromView(count));
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch (v.getId()) {
		// TODO 加入购物车
		case R.id.add_cart:
			if (hasSpec && specAdapter.getChoice() == -1) {
				Tip("请先选择" + specTitle);
				return;
			}
			String specid = "";
			// 加入的是活动商品
			if (hasSpec)
				specid = specAdapter.getSpecID();
			if (gameType == 1 || gameType == 2) {
				// 加入的是活动商品
				doAddtoCart4Action(context, goodId, actId, 0, specid);
			} else if (gameType == 0) {
				// 普通限时商品
				doAddtoCart4Action(context, goodId, actId, 0, specid);
			} else {
				// 加入的是普通商品
				doAddtoCart(goodId, numb, specid);
			}
			break;

		case R.id.sub:
			if (gameType != -1) {
				Tip("活动商品限购1件");
				return;
			}
			if (numb > 1) {
				count.setText(String.valueOf(--numb));
			} else {
				count.setText(String.valueOf(1));
			}
			if (numb == 1) {
				sub.setEnabled(false);
				sub.setAlpha(0.8f);
			}
			break;

		case R.id.add:
			if (gameType != -1) {
				Tip("活动商品限购1件");
				return;
			}
			if (numb > 100) {
				count.setText(String.valueOf(100));
			} else {
				count.setText(String.valueOf(++numb));
			}
			if (numb > 1) {
				sub.setEnabled(true);
				sub.setAlpha(1.0f);
			}
			break;

		case R.id.play_game:
			Bundle bundle = new Bundle();
			bundle.putInt("id", goodId);
			bundle.putString("img", img);
			bundle.putDouble("now", now);
			bundle.putString("name", name);
			bundle.putInt("actid", actId);
			bundle.putDouble("old", old);
			if (gameType == 1) {
				Intent intent = new Intent(context, GameClick.class);
				intent.putExtras(bundle);
				context.startActivity(intent);
			} else if (gameType == 2) {
				Intent intent = new Intent(context, GameTurntable.class);
				intent.putExtras(bundle);
				context.startActivity(intent);
			} else {
				initGame();
			}
			break;

		case R.id.other_one:
			if (listOtherBuy.size() == 0)
				return;
			Intent intent_details = new Intent(context, GoodsDetailsActivity.class);
			Bundle bundle_1 = new Bundle();
			OtherBuyBean bean = listOtherBuy.get(0);
			bundle_1.putInt("id", Integer.parseInt(bean.getGoodsID()));
			bundle_1.putString("name", bean.getName());
			bundle_1.putString("img", bean.getImg());
			bundle_1.putInt("actid", 0);
			bundle_1.putDouble("now", bean.getNowPrice());
			bundle_1.putDouble("old", bean.getBeforePrice());
			intent_details.putExtras(bundle_1);
			context.startActivity(intent_details);
			break;

		case R.id.other_two:
			if (listOtherBuy.size() < 1)
				return;
			Intent intent_details_2 = new Intent(context, GoodsDetailsActivity.class);
			Bundle bundle_2 = new Bundle();
			OtherBuyBean bean_2 = listOtherBuy.get(1);
			bundle_2.putInt("id", Integer.parseInt(bean_2.getGoodsID()));
			bundle_2.putString("name", bean_2.getName());
			bundle_2.putString("img", bean_2.getImg());
			bundle_2.putInt("actid", 0);
			bundle_2.putDouble("now", bean_2.getNowPrice());
			bundle_2.putDouble("old", bean_2.getBeforePrice());
			intent_details_2.putExtras(bundle_2);
			context.startActivity(intent_details_2);
			break;

		// 分享：
		case R.id.top_btn_1:
			// 分享内容随便写
			new Share(context).doit(name + " http://www.xpzc.com/item-" + String.valueOf(goodId).trim() + ".html ",
					"http://www.xpzc.com/item-" + String.valueOf(goodId).trim() + ".html ", img);
			break;

		// 详情选项卡
		case R.id.tabLeft:
			WebViewVisible(0);
			break;

		case R.id.tabRight:
			WebViewVisible(1);
			break;

		// 点击店铺名
		case R.id.store_name:
			if (storeID == null) {
				Tip("获取店铺信息失败");
				return;
			}
			Intent temp = new Intent(context, GoodsListActivity.class);
			Bundle bun = new Bundle();
			bun.putString("id", storeID);
			bun.putString("page_title", storeName);
			bun.putInt("from", APPCode.SHOP_GOODS_LIST);
			temp.putExtras(bun);
			context.startActivity(temp);
			break;
		}
	}

	@Override
	public void onBackPressed() {
		webViewLeft.clearHistory();
		webViewLeft.clearCache(true);
		webViewRight.clearHistory();
		webViewRight.clearCache(true);
		myfinish();
	}
}