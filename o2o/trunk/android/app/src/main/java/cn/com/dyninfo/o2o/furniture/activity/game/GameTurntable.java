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
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.share.Share;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.LBS;
import cn.com.dyninfo.o2o.furniture.util.NumArithmetic;
import cn.com.dyninfo.o2o.furniture.util.ScreenShot;

/**
 * 
 * @author
 * @updated 2014-9-12 19:06:53 完全重新，不用surface，实现了截屏分享
 *          <hr>
 *          2014-9-11 09:46:39 修正关闭中奖框后页面白色的问题
 *          <hr>
 *          2014-9-3 17:45:02 优化游戏时的音乐
 *          <hr>
 *          2014-7-31 10:10:52 by <a
 *          href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 */

public class GameTurntable extends BaseActivity implements OnClickListener {

	private int layoutID = R.layout.game_turntable;
	private Context context;
	private String PAGE_TITLE = "炫品幸运转盘";

	// 开始按钮
	private ImageView pointer, table_bg;

	private int goodsid, actID, agmId;

	private int level = 0;// 中奖级别
	private Double cutPrice = 0d;
	private Double nowPrice = 0d;
	private double lat, lng;

	/** 每一项所占度数 */
	private float ITEM_OFFSET = 360 / 12;// 360° 共12项
	/** 获取到了游戏结果 */
	private Boolean hadResult = false;
	/** 正在游戏中 */
	private Boolean starting = false;
	/** 中奖提示 dialog */
	private FavourableDialog dialog;
	// 旋转动画
	private RotateAnimation anim;
	// 商品图片
	private String img;// 分享时 可选
	// 音乐播放
	private SoundPool pool;
	private int audioID, audioPlayID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		context = this;
		checkUserSignStatus(context);
		initBundle();
		initView();
		initClick();
	}

	private void getData() {
		hadResult = false;
		cachedPool().execute(new Runnable() {

			@Override
			public void run() {
				int retry = 0;
				String json;
				do {
					++retry;
					json = SyncApi.getGameParam(String.valueOf(goodsid), String.valueOf(actID));
					// json =
					// "{\"status\":0,\"lev\":5,\"agmId\":1,\"money\":\"20.00\",\"lat\":\"30.13215\",\"lng\":\"103.5465\"}";
					if (!json.isEmpty()) {
						decodeJson(json);
					}
				} while (json.isEmpty() && retry < 5);
			}
		});
	}

	protected void decodeJson(String json) {
		try {
			JSONObject object = APP.checkReturnData(json, context);

			if (object != null)
				if (object.getInt("status") == 0) {
					level = object.getInt("lev");
					agmId = object.getInt("agmId");
					cutPrice = object.getDouble("money");
					lat = object.getDouble("lat");
					lng = object.getDouble("lng");
					hadResult = true;
					// dialogDismiss();
				}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private void initBundle() {
		Bundle bundle = getIntent().getExtras();
		actID = bundle.getInt("actid");
		goodsid = bundle.getInt("id");
		img = bundle.getString("img");
		nowPrice = bundle.getDouble("now");
	}

	private void initClick() {
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		pointer.setOnClickListener(this);
	}

	private void initView() {
		pointer = (ImageView) findViewById(R.id.pointer);
		table_bg = (ImageView) findViewById(R.id.table_bg);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.pointer:
			if (!starting) {
				starting = true;
				getData();
				setRotateAnim();
			}
			break;

		}
	}

	/**
	 * @Description 开始旋转
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-12 下午4:48:06
	 */
	private void setRotateAnim() {
		anim = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		anim.setDuration(100);// 设置动画持续时间
		anim.setRepeatCount(6);// 转6圈
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// 注意，中奖选项是顺时针转过来
				if (hadResult) {
					// 随机度数： <5~25度>
					float radom = Float.valueOf(APP.getRandomNum(20)) + 5;
					// 停止度数，用逆时针看（假如是一等奖，距离下一个一等奖还有 180 - 随机度数 ）
					// 还需转动：等于 [（总个数-中奖级别）*每一项度数 +最后一项的随机度数radom ]
					// 这里转的是转盘，不是指针
					// 如果是指针转动，转动角度 = ((5 - level) * ITEM_OFFSET + radom)
					// level是下标，所以 6个奖项的下标是5
					float angle = (5 - level) * ITEM_OFFSET + radom;
					Log_info("转盘游戏，中奖结果：" + (level + 1) + " 等奖，转盘顺时针转动：" + angle + "°");
					anim = new RotateAnimation(0, angle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
							0.5f);
					long animTime = (long) (angle / 360 * 100);
					anim.setDuration(animTime);// 设置动画持续时间
					anim.setFillAfter(true);// 停留在执行完
					table_bg.startAnimation(anim);
					hadResult = false;
					// 动画结束后展示中奖信息
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							showFavourableDialog();
						}
					}, animTime);
				} else {
					table_bg.startAnimation(anim);
				}
			}
		});
		table_bg.startAnimation(anim);
		// 开始播放音频
		audioPlay();
	}

	/**
	 * @Description 显示中奖提示
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 */
	void showFavourableDialog() {
		audioPause();
		// 开始分享
		Log_info("中奖信息：即将初始化");
		dialog = new FavourableDialog(context, nowPrice, cutPrice, goodsid, actID, agmId, lat, lng);
		dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss() {
				starting = false;
			}
		});
		dialog.show();
	}

	protected void onResume() {
		audioPerpared();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		audioStop();
		super.onDestroy();
	}

	/**
	 * @Description 停止播放音效
	 */
	void audioPause() {
		Log_info("播放音频，暂停");
		pool.pause(audioPlayID);
	}

	// TODO 播放音乐
	void audioPlay() {
		try {
			Log_info("播放音频，开始");
			// 播放音频，第二个参数为左声道音量;第三个参数为右声道音量;第四个参数为优先级；
			// 第五个参数为循环次数，0不循环，-1循环;第六个参数为速率，速率最低0.5最高为2，1代表正常速度
			audioPlayID = pool.play(audioID, 1, 1, 0, -1, 1);// 每一次paly后的值不一样的
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO 终止音乐
	void audioStop() {
		Log_info("播放音频，终止");
		pool.stop(audioPlayID);
		pool.release();
	}

	// 音乐缓冲
	void audioPerpared() {
		Log_info("播放音频，初始化");
		if (pool == null) {
			Log_info("播放音频，初始化");
			// 指定声音池的最大音频流数目为10，声音品质为5
			pool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
			// 载入音频流，返回在池中的id
			audioID = pool.load(context, R.raw.turntable, 1);
		}
	}

	@Override
	public void onBackPressed() {
		if (dialog != null && dialog.isShowing)
			dialog.dismiss();
		else {
			myfinish();
		}
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
				// 分享宝贝图片版本
				// new Share(context).doit("哈哈，有什么能比直接从原价上减去" + cutPrices +
				// "元更优惠的？红包什么的弱爆了！一想到你羡慕的眼光，感觉整个人一下子都好起来了呢！"
				// + " http://www.xpzc.com/active-" + actID + "-" + goodsID +
				// ".html ",
				// " http://www.xpzc.com/active-" + actID + "-" + goodsID +
				// ".html", APP.img_path(img));

				// 分享截屏版本
				new Share(context).doit("哈哈，有什么能比直接从原价上减去" + cutPrices + "元更优惠的？红包什么的弱爆了！一想到你羡慕的眼光，感觉整个人一下子都好起来了呢！"
						+ " http://www.xpzc.com/item-" + goodsID + ".html ", " http://www.xpzc.com/item-" + goodsID
						+ ".html ", ScreenShot.getScreenShootPath(GameTurntable.this));

				// turntableView.setDrawingCacheEnabled(true);
				// turntableView.buildDrawingCache(true);
				break;
			}
		}

		public void dismiss() {
			if (isShowing) {
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