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

package cn.com.dyninfo.o2o.furniture.activity;

import java.util.ArrayList;

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.adapter.GuideViewPagerAdapter;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @Description 引导页面
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-23 下午6:11:06
 * @updated 2014-9-15 17:25:58 新增关闭向导按钮
 *          <hr>
 *          2014-5-26 09:56:57
 */
public class GuideActivity extends BaseActivity implements OnPageChangeListener, OnClickListener {

	private Context context;
	private Handler handler;
	private ViewPager viewPager;
	private GuideViewPagerAdapter adapter;
	private TextView close;
	private LayoutInflater inflater;
	private ArrayList<View> views;
	private static final int[] imgs = { R.drawable.guide_1, R.drawable.guide_2 };
	private ImageView[] dots;
	private int POINT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initView();
		initData();
	}

	private void initView() {
		views = new ArrayList<View>();
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		adapter = new GuideViewPagerAdapter(views);
		close = (TextView) findViewById(R.id.close);
		close.setVisibility(View.GONE);
		close.setOnClickListener(this);
	}

	private void initData() {
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		// 引导图片
		for (int i = 0; i < imgs.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setLayoutParams(mParams);
			iv.setBackgroundResource(imgs[i]);
			// iv.setImageResource(imgs[i]);
			views.add(iv);
		}

		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);

		initPoint();
	}

	private void initPoint() {
		dots = new ImageView[imgs.length];
		inflater = LayoutInflater.from(context);
		LinearLayout layout = (LinearLayout) findViewById(R.id.dot_layout);
		layout.removeAllViews();
		// 小点图片
		for (int i = 0; i < imgs.length; i++) {
			ImageView img = (ImageView) inflater.inflate(R.layout.guide_dot, null).findViewById(R.id.guide_dot);
			dots[i] = img;
			dots[i].setEnabled(true);
			dots[i].setTag(i);
			layout.addView(dots[i]);
		}

		POINT = 0;
		dots[POINT].setEnabled(false);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// arg0 :当前页面
		// arg1:当前页面偏移的百分比
		// arg2:当前页面偏移的像素位置
	}

	@Override
	public void onPageSelected(int position) {
		setPointDot(position);
		// 最后一页
		if (position + 1 == imgs.length) {
			// 显示按钮，设置动画
			try {
				Animation anim = AnimationUtils.loadAnimation(context, R.anim.gradient_adv);
				anim.setDuration(1000);
				close.startAnimation(anim);
			} catch (Exception e) {
			}
			close.setVisibility(View.VISIBLE);

		} else {
			close.setVisibility(View.GONE);
		}
	}

	private void openIndex() {
		Intent intent = new Intent();
		intent.setClass(context, IndexActivity.class);
		startActivity(intent);
		animRightToLeft();
		finish();
		System.gc();
	}

	private void setPointDot(int positon) {
		if (positon < 0 || positon > imgs.length - 1 || POINT == positon) {
			return;
		}
		dots[positon].setEnabled(false);
		dots[POINT].setEnabled(true);
		POINT = positon;

		if (positon + 1 != imgs.length)
			close.setVisibility(View.GONE);
	}

	@Override
	public void onClick(View v) {
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			SharedPreferences used = getSharedPreferences(APPCode.USED, 0);
			used.edit().putBoolean("used", true).putInt("code", info.versionCode).commit();
		} catch (NameNotFoundException e) {
		}
		openIndex();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}