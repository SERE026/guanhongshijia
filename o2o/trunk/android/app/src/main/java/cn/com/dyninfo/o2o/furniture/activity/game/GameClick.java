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

package cn.com.dyninfo.o2o.furniture.activity.game;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.share.Share;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.LBS;
import cn.com.dyninfo.o2o.furniture.util.NumArithmetic;
import cn.com.dyninfo.o2o.furniture.util.ScreenShot;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.util.Utils;

/**
 * 
 * @author ly
 * @updated 2014-8-19 09:54:57 resume 时不清空每次点击价格 by <a
 *          href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 */
public class GameClick extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.game_diandian;
	private Context context;
	private String PAGE_TITLE = "炫品点点点";
	private Handler handler;
	// private PrizeInfoDialog dialog;
	private FavourableDialog dialog;
	private ImageButton click_zone;
	private TextView diandian_time;
	private TextView diandian_favorable_price;
	private TextView for_animation;
	public static Double cutPrice = 0d;
	private long time = 10; // 一共10秒游戏时间
	private AnimationSet animationSet;
	private TextView yuanjia;
	private ImageView diandian_img;
	private int count = 0;// 游戏点击次数
	private double lat, lng;
	private Boolean hasStarted = false;

	private double clickMoney;
	private Double max;

	private int goodsid;
	private int actID;// 活动id
	private String img;
	private double nowPrice;
	private int agmId;// 游戏信息ID
	private RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		checkUserSignStatus(context);
		initBundle();
		initView();
		getSpec();
		initClick();
		initAnimtion();
	}

	private void getSpec() {
		loadingShow();
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {

				int retry = 0;
				String json;
				do {
					++retry;
					json = SyncApi.getGameParam(String.valueOf(goodsid), String.valueOf(actID));
					if (!json.isEmpty()) {
						try {
							JSONObject object = APP.checkReturnData(json, context);
							if (object.getInt("status") == 0) {
								clickMoney = object.getDouble("click");
								max = object.getDouble("max");
								lat = object.getDouble("lat");
								lng = object.getDouble("lng");
								loadingDismiss();
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				} while (json.isEmpty() && retry < 5);

			}
		});
	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		goodsid = bundle.getInt("id");
		actID = bundle.getInt("actid");
		img = bundle.getString("img");
		nowPrice = bundle.getDouble("now");
	}

	private void initView() {

		diandian_img = (ImageView) findViewById(R.id.diandian_img);
		click_zone = (ImageButton) findViewById(R.id.click_zone);
		diandian_time = (TextView) findViewById(R.id.diandian_time);
		diandian_favorable_price = (TextView) findViewById(R.id.diandian_favorable_price);
		for_animation = (TextView) findViewById(R.id.for_animation);
		yuanjia = (TextView) findViewById(R.id.yuanjia);

		layout = (RelativeLayout) findViewById(R.id.dialog_layout);

		bmpUtils_short_holder.display(diandian_img, img);

		yuanjia.setText(nowPrice + "");

		setTextLocation();
		click_zone.setOnClickListener(this);

	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
	}

	private void initAnimtion() {
		if (animationSet == null) {
			animationSet = new AnimationSet(true);
			Animation animation_t = new TranslateAnimation(0, 0, 60, 0);
			animation_t.setDuration(180);
			Animation animation_a = new AlphaAnimation(1, 0);
			animation_a.setDuration(180);
			animationSet.addAnimation(animation_t);
			animationSet.addAnimation(animation_a);
			for_animation.setAnimation(animationSet);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.click_zone:
			if (hasStarted == false) {
				handler.post(runnable);
				hasStarted = true;
			}
			for_animation.setText(Math.round(clickMoney * 100) * 1.0 / 100 + "");
			for_animation.startAnimation(animationSet);
			++count;
			cutPrice += clickMoney;
			diandian_favorable_price.setText(Math.round(cutPrice * 100) * 1.0 / 100 + "");
//			Log_info("----> 点击优惠价格 = " + Math.round(cutPrice * 100) * 1.0 / 100 + "");
			break;
		}
	}

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			time--;
			diandian_time.setText("" + formatLongToTimeStr(time));
			if (time > 0) {
				handler.postDelayed(this, 1000);
			}
			if (time == 1) {
				try {
					// 禁止点击
					click_zone.setClickable(false);
					cutPrice = count * clickMoney;
					diandian_favorable_price.setText(cutPrice + "");
					String url = Constant.addgameInfo + "?memberId=" + getLastLocalUserInfoInstance(context).uid
							+ "&goodId=" + goodsid + "&actid=" + actID + "&count=" + count;
					String content = Utils.getRequest(url);
					if (content != null) {
						try {
							JSONObject object = new JSONObject(content);
							if (object.getInt("status") == 0) {
								agmId = object.getInt("agmId");
								// dialog = new PrizeInfoDialog(context, nub,
								// goodsid, actID, agmId, lat, lng);
								// dialog.setContentView(R.layout.prize_info_dialog);
								// dialog.setOnDismissListener(new
								// OnDismissListener() {
								// @Override
								// public void onDismiss(DialogInterface dialog)
								// {
								// reSetScore();
								// }
								// });
								// dialog.show();

								Log_info("中奖信息：即将初始化");
								dialog = new FavourableDialog(context, nowPrice, cutPrice, goodsid, actID, agmId, lat,
										lng);
								dialog.setOnDismissListener(new OnDismissListener() {
									@Override
									public void onDismiss() {
										reSetScore();
									}
								});
								dialog.show();
							}
						} catch (JSONException e) {
							click_zone.setClickable(true);
							APP.exception("解析游戏信息", e);
						}
					}
					diandian_time.setText("游戏结束");
				} catch (Exception e) {
					click_zone.setClickable(true);
				}
			}
			if (time == 0) {
				reSetScore();
			}
		}
	};

	public String formatLongToTimeStr(Long l) {
		int hour = 0;
		int minute = 0;
		int second = 0;
		second = l.intValue();
		if (second > 60) {
			minute = second / 60;
			second = second % 60;
		}

		if (minute > 60) {
			hour = minute / 60;
			minute = minute % 60;
		}
		return String.valueOf(second);
	}

	/**
	 * 指定textview位置
	 */
	private void setTextLocation() {
		RelativeLayout.LayoutParams params = new LayoutParams(yuanjia.getLayoutParams());
		params.setMargins(Sys.getScreenWidth(context) / 3, Sys.getScreenHeight(context) / 12, 0, 0);
		yuanjia.setLayoutParams(params);
	}

	private void reSetScore() {
		hasStarted = false;
		diandian_favorable_price.setText("0.00");
		time = 10;
		cutPrice = 0.0;
		count = 0;
	}

	@Override
	protected void onResume() {
		reSetScore();
		super.onResume();
	}

	@Override
	public void onBackPressed() {
		if (dialog != null && dialog.isShowing)
			dialog.dismiss();
		else
			myfinish();
	}

	/** TODO 弹出中奖框，为了实现截屏，不高档的写法 */
	class FavourableDialog implements OnClickListener {

		private Context context;
		private RelativeLayout layout;
		public Boolean isShowing = false;
		private Button prize_info_now_buy, price_info_add_buycar;
		private TextView prize_info_jiang, juli, close, old;
		private ImageView share;
		private int goodsID, actID, agmId;
		private OnDismissListener onDismissListener;
		private double lat, lng;
		private double oldPrice, cutPrices;// 减价多少元
		private NumArithmetic numArithmetic = new NumArithmetic();

		public FavourableDialog(Context context, double oldPrice, double cutPrices, int goodsID, int actID, int agmId,
				double lat, double lng) {
			this.context = context;
			this.cutPrices = numArithmetic.div(cutPrices, 1.0, 2);// 取 2 位
			this.oldPrice = oldPrice;
			this.goodsID = goodsID;
			this.actID = actID;
			this.agmId = agmId;
			this.lat = lat;
			this.lng = lng;
			initView();
		}

		protected void initView() {
			try {
				layout = (RelativeLayout) findViewById(R.id.dialog_layout);

				old = (TextView) findViewById(R.id.oldprice);
				close = (TextView) findViewById(R.id.dialog_exit);
				prize_info_jiang = (TextView) findViewById(R.id.prize_info_jiang);
				share = (ImageView) findViewById(R.id.share);
				close = (TextView) findViewById(R.id.close);
				juli = (TextView) findViewById(R.id.juli);
				prize_info_now_buy = (Button) findViewById(R.id.prize_info_now_buy);
				price_info_add_buycar = (Button) findViewById(R.id.price_info_add_buycar);
				old.setText("商品原价：" + oldPrice + "元");
				prize_info_jiang.setText(cutPrices + "元优惠");
				close.setOnClickListener(this);
				share.setOnClickListener(this);
				close.setOnClickListener(this);
				prize_info_now_buy.setOnClickListener(this);
				price_info_add_buycar.setOnClickListener(this);
				juli.setText("离你约有" + LBS.getDistance(lat, lng, Constant.lat, Constant.lng) + "公里");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			case R.id.close:
				dismiss();
				break;

			case R.id.prize_info_now_buy:
				BaseActivity.doAddtoCart4ActionAndBuy(context, goodsID, actID, agmId);
				dismiss();
				break;

			case R.id.price_info_add_buycar:
				BaseActivity.addToCartList(context, goodsID, actID, agmId);
				dismiss();
				break;

			case R.id.share:
				// 活动商品地址：http://www.xpzc.com/active-活动id-商品id.html
				new Share(context).doit("这年头，要是不上图，说我中奖了都没人信，手快有，手慢？呵呵.. " + " http://www.xpzc.com/active-" + actID
						+ "-" + goodsID + ".html", " http://www.xpzc.com/active-" + actID + "-" + goodsID + ".html",
						ScreenShot.getScreenShootPath(GameClick.this));
				break;
			}
		}

		public void dismiss() {
			if (isShowing) {
				click_zone.setClickable(true);
				isShowing = false;
				onDismissListener.onDismiss();
				layout.setVisibility(View.GONE);
			}
		}

		public void show() {
			if (!isShowing) {
				isShowing = true;
				layout.setVisibility(View.VISIBLE);
			}
		}

		public void setOnDismissListener(OnDismissListener l) {
			onDismissListener = l;
		}
	}

	public interface OnDismissListener {
		public void onDismiss();
	}

}