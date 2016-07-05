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
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.details.GoodsDetailsActivity;
import cn.com.dyninfo.o2o.furniture.activity.listener.ShakeListener;
import cn.com.dyninfo.o2o.furniture.activity.listener.ShakeListener.OnShakeListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.LBS;
import cn.com.dyninfo.o2o.furniture.view.SwitchButton;
import cn.com.dyninfo.o2o.furniture.view.SwitchButton.OnChangedListener;

/**
 * @Description 摇一摇
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-9-2 13:43:06 修复进入详情页面依然可以摇的问题
 *       <hr>
 *       2014-8-28 15:05:37 修改两点间计算距离的方法<br>
 *       2014-7-16 18:15:45 修改摇出商品后点击传值<br>
 *       2014-7-5 14:33:51 更新摇一摇声音开关和摇出商品界面，删除无用的代码
 */
public class GameShakeActivity extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.shake;
	private String PAGE_TITLE = "摇一摇";
	private Context context;
	private Handler handler;
	private TextView goods_layout_close;// 关闭商品提示层
	private MediaPlayer player;
	private SwitchButton switchButton;
	private ImageView shake_it_img;
	private TextView shake_it_goods_name, storetv;
	private TextView shake_it_goods_money, shake_it_goods_distance;

	// 摇晃监听
	private ShakeListener mShakeListener = null;
	// 震动
	private Vibrator mVibrator;

	private RelativeLayout mImgUp;
	private RelativeLayout mImgDn;
	private LinearLayout goods_layout;
	private boolean SoundEnabled = true;
	// 摇出来的商品信息
	private int goodsID;
	private double money;
	private double old_money = 0;
	private String img;
	private String goodsName;
	private String storeName;

	//
	private LinearLayout hands_layout;

	private double lng = 0d;
	private double lat = 0d;
	private double distance = 0d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		context = this;
		handler = new Handler();
		initView();
		initValues();
		initClick();
	}

	private void getData() {
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {

				String json = SyncApi.getShakeList(context);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {
						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								goodsID = object.getInt("goodsid");
								money = object.getDouble("xmoney");
								old_money = object.getDouble("money");
								img = object.getString("image");
								lng = object.getDouble("lng");
								lat = object.getDouble("lat");
								distance = LBS.getDistance(lat, lng, Constant.lat, Constant.lng);
								Log_info("两点距离为：" + distance);
								goodsName = object.getString("goodName");
								storeName = object.getString("shopname");

								handler.post(new Runnable() {

									@Override
									public void run() {
										hands_layout.setVisibility(View.GONE);
										goods_layout.setVisibility(View.VISIBLE);
										storetv.setText(storeName);
										shake_it_goods_name.setText(goodsName);
										shake_it_goods_money.setText(String.valueOf(money));
										bmpUtils_short_holder.display(shake_it_img, img);
										String str;
										if (distance < 0.1) {
											str = "就在你身边";
										} else if (distance < 1) {
											str = "离你很近";
										} else {
											str = "约" + distance + "公里";
										}
										shake_it_goods_distance.setText(str);
									}
								});
							} else if (object.getInt("status") == ErrorCode.ERROR) {
								Tip("服务器异常，再摇一次");
							}
						} catch (Exception e) {
							APP.exception("摇一摇获取数据", e);
							Tip("数据异常，再摇一次");
						}
					}
				} else {
					Tip("没有摇出任何商品，再摇一次");
				}

			}
		});
	}

	private void initView() {
		hands_layout = (LinearLayout) findViewById(R.id.hands_layout);

		mVibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);

		mImgUp = (RelativeLayout) findViewById(R.id.shakeImgUp);
		mImgDn = (RelativeLayout) findViewById(R.id.shakeImgDown);
		goods_layout = (LinearLayout) findViewById(R.id.goods_layout);
		goods_layout_close = (TextView) findViewById(R.id.goods_layout_close);

		shake_it_img = (ImageView) findViewById(R.id.shake_it_img);
		storetv = (TextView) findViewById(R.id.store_name);
		shake_it_goods_name = (TextView) findViewById(R.id.shake_it_goods_name);
		shake_it_goods_money = (TextView) findViewById(R.id.shake_it_goods_money);

		switchButton = (SwitchButton) findViewById(R.id.inculd_shake).findViewById(R.id.top_switch_btn);
		switchButton.setVisibility(View.VISIBLE);
		switchButton.setChecked(true);
		shake_it_goods_distance = (TextView) findViewById(R.id.shake_it_goods_distance);
		switchButton.setOnChangeListener(new OnChangedListener() {
			@Override
			public void OnChanged(boolean checkState) {
				if (checkState) {
					Tip("开启声音");
					SoundEnabled = true;
				} else {
					SoundEnabled = false;
					Tip("关闭声音");
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goods_layout:
			Intent intent = new Intent(context, GoodsDetailsActivity.class);
			Bundle bundle = new Bundle();
			bundle.putInt("id", goodsID);
			bundle.putString("name", goodsName);
			bundle.putString("img", img);
			bundle.putInt("actid", 0);
			bundle.putDouble("now", money);
			bundle.putDouble("old", old_money);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case R.id.goods_layout_close:
			goods_layout.setVisibility(View.GONE);
			hands_layout.setVisibility(View.VISIBLE);
			break;
		}
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		goods_layout_close.setOnClickListener(this);
		goods_layout.setOnClickListener(this);
	}

	private void initValues() {
		mShakeListener = new ShakeListener(context);
		mShakeListener.setOnShakeListener(new OnShakeListener() {
			public void onShake() {
				goods_layout.setVisibility(View.GONE);
				hands_layout.setVisibility(View.VISIBLE);
				startAnim(); // 开始 摇一摇手掌动画
				mShakeListener.stop();
				startVibrato(); // 开始 震动和音效
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						mVibrator.cancel();
						mShakeListener.start();
						getData();
					}
				}, 500);
			}
		});

	}

	/**
	 * 摇一摇动画
	 */
	public void startAnim() {
		AnimationSet animup = new AnimationSet(true);
		TranslateAnimation mytranslateanimup0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -0.5f);
		mytranslateanimup0.setDuration(500);
		TranslateAnimation mytranslateanimup1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, +0.5f);
		mytranslateanimup1.setDuration(500);
		mytranslateanimup1.setStartOffset(500);
		animup.addAnimation(mytranslateanimup0);
		animup.addAnimation(mytranslateanimup1);
		mImgUp.startAnimation(animup);

		AnimationSet animdn = new AnimationSet(true);
		TranslateAnimation mytranslateanimdn0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, +0.5f);
		mytranslateanimdn0.setDuration(500);
		TranslateAnimation mytranslateanimdn1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -0.5f);
		mytranslateanimdn1.setDuration(500);
		mytranslateanimdn1.setStartOffset(500);
		animdn.addAnimation(mytranslateanimdn0);
		animdn.addAnimation(mytranslateanimdn1);
		mImgDn.startAnimation(animdn);
	}

	public void startVibrato() {
		if (SoundEnabled) {
			// 播放音效
			player = MediaPlayer.create(this, R.raw.yaoyiyao);
			player.setLooping(false);
			player.start();
			// 定义震动
			// 第一个｛｝里面是节奏数组，
			// 第二个参数是重复次数，-1为不重复
			mVibrator.vibrate(new long[] { 500, 200, 500, 200 }, -1);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mShakeListener != null) {
			mShakeListener.stop();
		}
	}

	@Override
	protected void onPause() {
		mShakeListener.stop();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mShakeListener.start();
		super.onResume();
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

}