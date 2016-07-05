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

package cn.com.dyninfo.o2o.furniture.activity.my;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup.LayoutParams;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.adapter.ReturnGoodsAdapter;
import cn.com.dyninfo.o2o.furniture.adapter.ViewPagerAdapter;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;
import cn.com.dyninfo.o2o.furniture.bean.ReturnGoodsBean;
import cn.com.dyninfo.o2o.furniture.listener.SlideTabOnClickListener;
import cn.com.dyninfo.o2o.furniture.listener.ViewPagerOnPageChangeListener;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.view.CusHoriScrollView;
import cn.com.dyninfo.o2o.furniture.widget.SlidePagerUtil;

/**
 * @Description 退换货管理 （入口隐藏了）
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-28 14:50:59
 * @update 2014-7-8 09:34:40 支持点击tab切换
 */
public class ReturnActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "退换货查看";
	private String tag = " ReturnActivity ";
	private int layoutID = R.layout.slide_viewpager_frame;
	private Context context;
	private Handler handler;
	private LayoutInflater inflater;
	private LinearLayout menu_layout;// 顶部 tab layou
	private ViewPager viewPager;// 页卡内容
	private List<View> view_list; // Tab页面列表
	private RelativeLayout slide_line_layout;// 动画图片
	// 顶部tab文本
	private String[] tabs = { "处理中", "已解决" };
	// Tab 文本集
	private List<TextView> tab_tv_list;
	// ListView 集
	private List<ListView> listview_list;
	private CusHoriScrollView horiScrollView;// 顶部选项卡水平scroll
	private RelativeLayout scroll_son_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		handler = new Handler();

		initView();

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				initViewPager();
				initAdapter();
			}
		}, 100);
	}

	protected void initAdapter() {
		// 进行中
		List<ReturnGoodsBean> list = new ArrayList<ReturnGoodsBean>();
		List<OrderGoodsBean> item_list = new ArrayList<OrderGoodsBean>();
		item_list.add(new OrderGoodsBean("自然堂 雪域精粹 纯粹滋润冰川水(凝润型) 160ml 补水保湿", 97.5, 1));
		item_list.add(new OrderGoodsBean("妮维雅 男士护肤套装 洗面奶 爽肤水乳液 洁面保湿补水控油化妆品", 149.00, 1));
		item_list.add(new OrderGoodsBean("美宝莲 绝色持久唇膏 彩妆裸色口红 唇彩红唇 保湿 专柜正品", 79.00, 1));
		item_list.add(new OrderGoodsBean("美宝莲精纯矿物防晒BB霜 裸妆遮瑕美白 隔离霜", 89.00, 1));
		list.add(new ReturnGoodsBean("2014051201", "T-2014051201", "2014-5-12 09:36:05", "您的申请正在处理中，请耐心等待。", item_list));
		item_list = new ArrayList<OrderGoodsBean>();
		item_list.add(new OrderGoodsBean("SK II Pitera基础美白护肤套装(含神仙水/面膜) 补水保湿", 640.0, 1));
		item_list.add(new OrderGoodsBean("SK II 环采臻皙钻白精华露30ml", 1070.0, 1));
		list.add(new ReturnGoodsBean("2014051201", "T-2014043050", "2014-4-30 14:24:34", "退货成功，银行退款中。", item_list));
		for (int i = 0; i < 5; i++) {
			item_list = new ArrayList<OrderGoodsBean>();
			item_list.add(new OrderGoodsBean("SK II Pitera 神仙水 40ml", 1280.0, 1));
			list.add(new ReturnGoodsBean("2014052801", "T-2014052801", "2014-5-28 12:01:29", "已收到货，正在审核。", item_list));
			listview_list.get(0).setAdapter(new ReturnGoodsAdapter(context, list));
		}

		// 已完成
		list = new ArrayList<ReturnGoodsBean>();
		List<OrderGoodsBean> item_list_ed = new ArrayList<OrderGoodsBean>();
		item_list_ed.add(new OrderGoodsBean("美宝莲 脸部唇部卸妆水 70ml", 14.0, 1));
		list.add(new ReturnGoodsBean("20131208209", "T-20131208209", "2013-12-8 09:41:00", "退货完成。", item_list_ed));
		listview_list.get(1).setAdapter(new ReturnGoodsAdapter(context, list));
	}

	private void initView() {
		inflater = LayoutInflater.from(context);
		horiScrollView = (CusHoriScrollView) findViewById(R.id.hs);
		scroll_son_layout = (RelativeLayout) findViewById(R.id.scroll_son_layout);
		// slide line and pager
		slide_line_layout = (RelativeLayout) findViewById(R.id.slide_line_layout);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		/** ----------------ViewPager包含的内容页，都是用的 ListView----------------- **/
		// viewpager包含的所有界面：
		view_list = new ArrayList<View>();
		for (int i = 0; i < tabs.length; i++) {
			view_list.add(inflater.inflate(R.layout.listview_default, null));
		}
		// ListView
		listview_list = new ArrayList<ListView>();
		for (int i = 0; i < view_list.size(); i++) {
			listview_list.add((ListView) view_list.get(i).findViewById(R.id.listview));
		}
		// tab 布局
		tab_tv_list = new ArrayList<TextView>();
		menu_layout = (LinearLayout) findViewById(R.id.slide_main_tab_layout);
		menu_layout.removeAllViews(); // 先移除
		LayoutParams params = menu_layout.getLayoutParams();
		for (int i = 0; i < tabs.length; i++) {
			View view = inflater.inflate(R.layout.slide_tab_textview, null);
			RelativeLayout tab_layout = (RelativeLayout) view.findViewById(R.id.tab_layout);
			TextView tv = (TextView) view.findViewById(R.id.tab_tv);
			tab_layout.setId(i);
			tv.setText(tabs[i]);
			params.width = SlidePagerUtil.getItemWidth(context);
			params.height = LayoutParams.WRAP_CONTENT;
			tab_layout.setLayoutParams(params);
			tab_layout.setOnClickListener(new SlideTabOnClickListener(viewPager, i));
			menu_layout.addView(tab_layout, i);

			tab_tv_list.add(tv);
			// tab_layout_list.add(tab_layout);//这个页面没有使用，有错也就不改了
		}

		params.height = LayoutParams.WRAP_CONTENT;
		params.width = SlidePagerUtil.getItemWidth(context) * tabs.length;
		menu_layout.setLayoutParams(params);

		params = null;
	}

	private void initViewPager() {
		viewPager.setAdapter(new ViewPagerAdapter(view_list));
		viewPager.setOnPageChangeListener(new ViewPagerOnPageChangeListener(context, scroll_son_layout, tab_tv_list,
				slide_line_layout, APPCode.RETURN));
		viewPager.setCurrentItem(0);
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		default:
			break;
		}
	}
}