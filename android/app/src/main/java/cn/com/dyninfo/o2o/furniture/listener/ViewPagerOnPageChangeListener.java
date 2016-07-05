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

package cn.com.dyninfo.o2o.furniture.listener;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.view.CusHoriScrollView;
import cn.com.dyninfo.o2o.furniture.widget.SlidePagerUtil;

public class ViewPagerOnPageChangeListener implements OnPageChangeListener {

	private Context context;
	private List<TextView> tab_tv_list;// tab textvew 的list
	private CusHoriScrollView horiScrollView;
	private RelativeLayout scroll_son_layout;
	/** 页卡 */
	private RelativeLayout tab_line;
	private int offset = 0;// 动画图片偏移量
	private int POINT = 0;// 当前页卡编号（滑动时判断是左向右，还是右向左）
	private int slide_img_width;// 动画图片宽度
	/** 页面、slide 的动画 */
	public static Animation anim = null;
	public static Animation anim2 = null;
	/** 页面来源标记 */
	private int from;

	/**
	 * @Description 带Slide 的ViewPager滑动监听
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-12 下午4:24:49
	 * @updated 2014-9-17 13:19:35 新增动画效果
	 *          <hr>
	 *          取消 整个选项区域随着切换滑动的动画
	 * @param context
	 * @param tab_line
	 *            下划线
	 */

	public ViewPagerOnPageChangeListener(Context context, RelativeLayout scroll_son_layout, List<TextView> tab_tv_list,
			RelativeLayout tab_line, int from) {
		this.context = context;
		this.scroll_son_layout = scroll_son_layout;
		this.tab_tv_list = tab_tv_list;
		this.tab_line = tab_line;
		this.from = from;

		initView();
		initAnim();
	}

	/**
	 * @Description 如果选项超过一屏，则先向左移动，再移动会原位置，用来提示用户，可以左右滑动
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-9-17 下午1:18:45
	 */
	private void initAnim() {
		final int layoutW = scroll_son_layout.getWidth();
		final int screenW = Sys.getScreenWidth(context);
		if (layoutW > screenW) {
			BaseActivity.Log_info("选项卡超过一屏");
			anim = new TranslateAnimation(0, -(layoutW - screenW), 0, 0);
			anim.setFillAfter(true);
			anim.setDuration(800);
			scroll_son_layout.startAnimation(anim);
			anim.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {
					anim = new TranslateAnimation(-(layoutW - screenW), 0, 0, 0);
					anim.setFillAfter(true);
					anim.setDuration(800);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					scroll_son_layout.startAnimation(anim);
				}
			});
		}
	}

	private void initView() {
		slide_img_width = SlidePagerUtil.getSlideWidth(context); // 下划线宽度
		offset = (SlidePagerUtil.getItemWidth(context) - slide_img_width) / 2;// 计算偏移量（每个TextView比SlideImg多的宽度）
		setColor(0);
	}

	public void onPageSelected(final int position) {
		BaseActivity.Log_info("onPageSelected 当前下标：" + position);
		int one = offset * 2 + slide_img_width;// 一个tab的宽度：页卡1 -> 页卡2 偏移量
		int tab_item_width = SlidePagerUtil.getItemWidth(context);

		/** 计算一个屏幕可以显示几个slde_menu */
		int count = Sys.getScreenWidth(context) / tab_item_width;
		BaseActivity.Log_info("====>手机宽 " + Sys.getScreenWidth(context) + "，每个 tab 宽 "
				+ SlidePagerUtil.getItemWidth(context));
		BaseActivity.Log_info("====>可以显示 " + count + " 个 Tab");
		// TODO 以下是根据偏移量，移动顶部选项卡
		// 如果超过一半了
		// if (position > count / 2) {
		// if (position == tab_tv_list.size() - 1) {
		// // 在末尾了
		// } else {
		// // 将 tab_layout 左移
		// int move_px = (position - count / 2) * tab_item_width;
		// anim = new TranslateAnimation(-(POINT - count / 2) * tab_item_width,
		// -move_px, 0, 0);
		// anim.setFillAfter(true);
		// anim.setDuration(300);
		// scroll_son_layout.startAnimation(anim);
		// // BaseActivity.Tip("position > count / 2，标题从" + -(POINT - count
		// // / 2) * tab_item_width + "移动到" + -move_px);
		// }
		// } else if (position == count / 2) {
		// // 从右到左
		// if (POINT > position) {
		// anim = new TranslateAnimation(-(POINT - position) * tab_item_width,
		// 0, 0, 0);
		// anim.setFillAfter(true);
		// anim.setDuration(300);
		// scroll_son_layout.startAnimation(anim);
		// // BaseActivity.Tip("等于一半，从右往左\n" + "标题从 " + (-(POINT -
		// // position) * tab_item_width) + "  移动到 " + 0);
		// }
		// }

		anim = new TranslateAnimation(POINT * tab_item_width, position * tab_item_width, 0, 0);
		anim.setFillAfter(true);
		anim.setDuration(300);
		tab_line.startAnimation(anim);

		setColor(position);
		POINT = position;
		anim = null;
		// 2014-6-20 12:54:24
		Intent intent = new Intent();
		intent.putExtra("position", position);
		BaseActivity.Log_info("------> 切换页面至：" + intent.getIntExtra("position", 0));
		// 这里判断是来自哪个页面的，然后发送对应的广播
		if (from == APPCode.ORDER)
			intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#change");
		else if (from == APPCode.MSG)
			intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.MessagesActivity#change");
		else if (from == APPCode.RETURN)
			intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.MessagesActivity#change");
		context.sendBroadcast(intent);
	}

	private void setColor(int position) {
		for (int i = 0; i < tab_tv_list.size(); i++) {
			if (i == position)
				tab_tv_list.get(i).setTextColor(context.getResources().getColor(R.color.pink));
			else
				tab_tv_list.get(i).setTextColor(context.getResources().getColor(R.color.black_light));
		}
	}

	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	public void onPageScrollStateChanged(int arg0) {
	}
}