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

package cn.com.dyninfo.o2o.furniture.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;
import cn.com.dyninfo.o2o.furniture.activity.home.GoodsListActivity;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

/**
 * @Description 首页巨幅广告适配器
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @return
 * @update 2014-9-1 18:03:31 优化性能
 *         <hr>
 *         2014-8-29 11:27:11 更新timer ，避免刷新后会出现多个timer在发消息
 *         <hr>
 *         2014-06-14 18:45:01 ( 全面改写，以前是 ViewFlipper 实现的，分发有点小问题，方法也有点过时 )
 */
public class ViewpagerAdvAdapter {

	private Context context;
	private Handler handler;
	private ViewPager viewPager;
	private List<View> view_list;
	private List<ImageView> dot_img;
	private List<String> advImgs;
	private List<String> advIds;
	private List<String> advNames;
	private LinearLayout dot_layout;
	private long AUTO_TIME = 4000;// 自动切换时间
	private Timer timer;
	private TimerTask task;
	private static int point = 0;

	public void notifyData(Context context, Handler handler, ViewPager viewPager, List<String> advImgs,
			List<String> advIds, List<String> advNames, LinearLayout dot_layout) {
		this.context = context;
		this.handler = handler;
		this.viewPager = viewPager;
		this.dot_layout = dot_layout;
		this.advImgs = advImgs;
		this.advIds = advIds;
		this.advNames = advNames;

		initImage();
		initAdapter();
		start();
	}

	/**
	 * @update：2014-6-14 19:44:26
	 */
	public void start() {
		// if (task != null) {
		// task.cancel();
		// task = null;
		// }

		if (task == null) {
			task = new TimerTask() {
				@Override
				public void run() {
					// System.out.println("首页广告正在切换，请求来自 timer " +
					// timer);
					handler.post(new Runnable() {

						@Override
						public void run() {
							point++;
							point = point == advImgs.size() ? 0 : point;
							viewPager.setCurrentItem(point);
							if (advImgs.size() > 1) {
								Animation anim = AnimationUtils.loadAnimation(context, R.anim.gradient_adv);
								if (anim != null)
									viewPager.setAnimation(anim);
							}
						}
					});
				}
			};
		}
		if (timer == null) {
			timer = new Timer();
			timer.schedule(task, 0, AUTO_TIME);
		}
	}

	private void initAdapter() {
		viewPager.setAdapter(new ViewPagerAdapter(view_list));
		viewPager.setOnPageChangeListener(new ViewpagerListener());
	}

	private void initImage() {
		// 图片源
		if (view_list == null)
			view_list = new ArrayList<View>();
		for (int i = 0; i < advImgs.size(); i++) {
			ImageView iv = new ImageView(context);
			IndexActivity.getBmpUtils().display(iv, advImgs.get(i));
			iv.setId(Integer.parseInt(advIds.get(i)));
			iv.setScaleType(ScaleType.FIT_XY);
			iv.setTag(advNames.get(i));
			iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			iv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					// 跳转到商品列表 
					Intent intent = new Intent(context, GoodsListActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("adv_id", String.valueOf(view.getId()));
					bundle.putString("page_title", String.valueOf(view.getTag()));
					bundle.putInt("from", APPCode.ADV_LIST);
					intent.putExtras(bundle);
					context.startActivity(intent);
				}
			});
			view_list.add(iv);
		}

		// 小圆点
		dot_img = new ArrayList<ImageView>();
		for (int i = 0; i < advImgs.size(); i++) {
			ImageView iv = new ImageView(context);
			iv.setImageResource(i == point ? R.drawable.adv_point : R.drawable.adv_normal);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(8, 8);
			lp.setMargins(4, 4, 4, 4);
			iv.setLayoutParams(lp);
			dot_layout.addView(iv);
			dot_img.add(iv);
		}
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class ViewpagerListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int position) {
			for (int i = 0; i < dot_img.size(); i++)
				dot_img.get(i).setImageResource(i == position ? R.drawable.adv_point : R.drawable.adv_normal);
			point = position;
		}

	}
}
