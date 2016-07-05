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

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.my.AccountActivity;
import cn.com.dyninfo.o2o.furniture.bean.CitiesBean;
import cn.com.dyninfo.o2o.furniture.dialog.CityChoiceDialog;
import cn.com.dyninfo.o2o.furniture.dialog.CityChoiceDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog;
import cn.com.dyninfo.o2o.furniture.fragment.CartFragment;
import cn.com.dyninfo.o2o.furniture.fragment.IndexFragment;
import cn.com.dyninfo.o2o.furniture.fragment.MyFragment;
import cn.com.dyninfo.o2o.furniture.fragment.SearchFragment;
import cn.com.dyninfo.o2o.furniture.fragment.SideFragment;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.util.Update;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @Description 首页
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @create 2014-4-15
 * @updated 2014-9-11 11:56:11 新增新注册用户引导
 *          <hr>
 *          2014-7-31 16:58:08 新增切换区域后刷新 by <a
 *          href="http://t.cn/RvIApP5">ceychen</a>
 */
public class IndexActivity extends BaseActivity implements OnClickListener {

	private String tag = " IndexActivity ";
	public String PAGE_TITLE = "炫品妆成";
	/** 炫品首页 */
	private View index_layout;
	private ImageView index_image;
	/** 搜索 */
	private View search_layout;
	private ImageView search_image;
	/** 身边店家 */
	private View side_layout;
	private ImageView side_image;
	/** 购物车 */
	private View cart_layout;
	private ImageView cart_image;
	/** 我的炫品 */
	private View my_layout;
	private ImageView my_image;

	private static Context context;
	private static Handler handler;
	private FragmentManager fragmentManager;
	private FragmentTransaction transaction;
	/** 五大界面 */
	private IndexFragment indexFragment;
	private SearchFragment searchFragment;
	private SideFragment sideFragment;
	private CartFragment cartFragment;
	private MyFragment myFragment;
	// 城市选择
	private TextView city;
	private SharedPreferences city_sp;
	// 内容区域
	private int containerViewId = R.id.content;
	//
	private static TextView title;
	private static ImageView back;
	public static int nowPoint = 0;
	public static int nowPoint_temp = 1;

	// 购物车数量
	private TextView cart_num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		addToActManager(this);
		context = this;
		handler = new Handler();
		fragmentManager = getFragmentManager();
		city_sp = context.getSharedPreferences(APPCode.CITY, MODE_APPEND);

		initView();
		initBroadcast();
		notifyCartCountAtIndex(context);
		checkUpdate();
	}

	private void checkUpdate() {
		new Update(context).check(true, false);
	}

	private void initView() {
		city = (TextView) findViewById(R.id.city);
		title = (TextView) findViewById(R.id.title);
		back = (ImageView) findViewById(R.id.back);
		index_layout = findViewById(R.id.index_layout);
		search_layout = findViewById(R.id.search_layout);
		side_layout = findViewById(R.id.side_layout);
		cart_layout = findViewById(R.id.cart_layout);
		my_layout = findViewById(R.id.my_layout);
		index_image = (ImageView) findViewById(R.id.index_image);
		search_image = (ImageView) findViewById(R.id.search_image);
		side_image = (ImageView) findViewById(R.id.side_image);
		cart_image = (ImageView) findViewById(R.id.cart_image);
		my_image = (ImageView) findViewById(R.id.my_image);
		cart_num = (TextView) findViewById(R.id.cart_ico_num);

		city.setOnClickListener(this);
		back.setOnClickListener(this);
		index_layout.setOnClickListener(this);
		search_layout.setOnClickListener(this);
		side_layout.setOnClickListener(this);
		cart_layout.setOnClickListener(this);
		my_layout.setOnClickListener(this);
	}

	/** 1 - 5 ，设置页面，顺便检查判断用户登录状态（第4、5页才判断） **/
	private void setTabSelection(int pos) {
		nowPoint_temp = nowPoint = pos;
		ResetTab();
		transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);

		city.setVisibility(View.GONE);

		switch (pos) {
		case 1:
			index_layout.setBackgroundColor(getResources().getColor(R.color.white));
			index_image.setImageResource(R.drawable.home_tab_ico_1_press);
			city.setText(city_sp.getString("city_name", "全国"));
			city.setVisibility(View.VISIBLE);
			if (indexFragment == null) {
				indexFragment = new IndexFragment();
				transaction.add(containerViewId, indexFragment, "indexFragment");
				transaction.addToBackStack("indexFragment");
			} else {
				transaction.show(indexFragment);
			}
			setTitle(indexFragment.PAGE_TITLE);
			break;

		case 2:
			search_layout.setBackgroundColor(getResources().getColor(R.color.white));
			search_image.setImageResource(R.drawable.home_tab_ico_2_press);
			if (searchFragment == null) {
				searchFragment = new SearchFragment();
				transaction.add(containerViewId, searchFragment, "searchFragment");
				transaction.addToBackStack("searchFragment");
			} else {
				transaction.show(searchFragment);
			}
			setTitle(searchFragment.PAGE_TITLE);
			break;
		case 3:
			side_layout.setBackgroundColor(getResources().getColor(R.color.white));
			side_image.setImageResource(R.drawable.home_tab_ico_3_press);
			if (sideFragment == null) {
				sideFragment = new SideFragment();
				transaction.add(containerViewId, sideFragment, "sideFragment");
				transaction.addToBackStack("sideFragment");
			} else {
				transaction.show(sideFragment);
			}
			setTitle(sideFragment.PAGE_TITLE);
			break;
		case 4:
			checkUserSignStatus(context);
			cart_layout.setBackgroundColor(getResources().getColor(R.color.white));
			cart_image.setImageResource(R.drawable.home_tab_ico_4_press);
			if (cartFragment == null) {
				cartFragment = new CartFragment();
				transaction.add(containerViewId, cartFragment, "cartFragment");
				transaction.addToBackStack("cartFragment");
			} else {
				transaction.show(cartFragment);
			}
			setTitle(cartFragment.PAGE_TITLE);
			break;
		case 5:
			checkUserSignStatus(context);
			my_layout.setBackgroundColor(getResources().getColor(R.color.white));
			my_image.setImageResource(R.drawable.home_tab_ico_5_press);
			if (myFragment == null) {
				myFragment = new MyFragment();
				transaction.add(containerViewId, myFragment, "myFragment");
				transaction.addToBackStack("myFragment");
			} else {
				transaction.show(myFragment);
			}
			setTitle(myFragment.PAGE_TITLE);
			break;
		default:
			setTabSelection(1);
			break;
		}

		transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
		// transaction.commit();// 容易报错：Can not perform this action after
		// onSaveInstanceState
		transaction.commitAllowingStateLoss();
	}

	/**
	 * @Description 将所有的 Fragment 隐藏
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (indexFragment != null) {
			transaction.hide(indexFragment);
		}
		if (searchFragment != null) {
			transaction.hide(searchFragment);
		}
		if (sideFragment != null) {
			transaction.hide(sideFragment);
		}
		if (cartFragment != null) {
			transaction.hide(cartFragment);
		}
		if (myFragment != null) {
			transaction.hide(myFragment);
		}
	}

	/**
	 * @Description 重置导航图片
	 */
	private void ResetTab() {
		index_image.setImageResource(R.drawable.home_tab_ico_1_normal);
		search_image.setImageResource(R.drawable.home_tab_ico_2_normal);
		side_image.setImageResource(R.drawable.home_tab_ico_3_normal);
		cart_image.setImageResource(R.drawable.home_tab_ico_4_normal);
		my_image.setImageResource(R.drawable.home_tab_ico_5_normal);
		index_layout.setBackgroundColor(getResources().getColor(R.color.home_ico_bg));
		search_layout.setBackgroundColor(getResources().getColor(R.color.home_ico_bg));
		side_layout.setBackgroundColor(getResources().getColor(R.color.home_ico_bg));
		cart_layout.setBackgroundColor(getResources().getColor(R.color.home_ico_bg));
		my_layout.setBackgroundColor(getResources().getColor(R.color.home_ico_bg));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.city:
			CityChoiceDialog dialog = new CityChoiceDialog(context, 0);
			dialog.setOnDismissListener(new OnDismissListener() {
				@Override
				public void OnChosed(Boolean chosed, int position, CitiesBean bean) {
					if (chosed) {
						city.setText(bean.getName());
						city_sp.edit().putString(APPCode.CHOICE_CITY_ID, bean.getId())
								.putString("city_name", bean.getName()).commit();
						sendBroadcast(new Intent().setAction("cn.com.dyninfo.o2o.furniture.fragment.IndexFragment#refresh"));
					}
				}
			});
			dialog.show();
			break;
		case R.id.index_layout:
			setTabSelection(1);
			break;
		case R.id.search_layout:
			setTabSelection(2);
			break;
		case R.id.side_layout:
			setTabSelection(3);
			break;
		case R.id.cart_layout:
			setTabSelection(4);
			break;
		case R.id.my_layout:
			setTabSelection(5);
			break;
		}
	}

	public void setPage() {
		nowPoint = getNowPoint();
		setTabSelection(nowPoint);
		Log_info(tag + " nowPoint = " + nowPoint);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log_info(tag + " onActivityResult");
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 确保从其他界面返回时选中 fragment
		setPage();
	}

	@Override
	protected void onStart() {
		Log_info("本程序被分配内存：" + Sys.getMemorySize() + " M");
		setBackVisible(false);
		super.onStart();
	}

	@Override
	public void onBackPressed() {
		exit();
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(setCartCountBR);
		super.onDestroy();
	}

	/** 设置页面标题 */
	public static void setPageTitle(String PAGE_TITLE) {
		APP.setTitle(handler, title, PAGE_TITLE);
	}

	/** 设置返回按钮是否可见 */
	public static void setBackVisible(Boolean bool) {
		APP.setBackVisible(handler, back, bool);
	}

	/**
	 * @Description 其它界面回到首页时用
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.IndexActivity#cartcount");
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.sign.SigninActivity#signup&signin");
		registerReceiver(setCartCountBR, intentFilter);
	}

	private BroadcastReceiver setCartCountBR = new BroadcastReceiver() {
		@Override
		public void onReceive(final Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals("cn.com.dyninfo.o2o.furniture.IndexActivity#cartcount")) {
				System.out.println("-------> 接收到刷新购物车通知  IndexActivity#cartcount 本地");
				// 设置购物车数量
				handler.post(new Runnable() {
					@Override
					public void run() {
						cart_num.setText(String.valueOf(getSharedPreferences(APPCode.CART, 0).getInt("cartCount", 0)));
					}
				});
			} else if (action.equals("cn.com.dyninfo.o2o.furniture.activity.sign.SigninActivity#signup&signin")) {
				// 手机上注册后第一次登录
				handler.post(new Runnable() {
					@Override
					public void run() {
						ConfirmDialog guideDialog = new ConfirmDialog(context, "提示",
								"现在，你可以很方便地修改昵称、头像以及收货地址了，需要马上去修改这些信息吗？", "立即修改");
						guideDialog.setOnDismissListener(new ConfirmDialog.OnDismissListener() {
							@Override
							public void OnConfirmed(Boolean confirmed) {
								if (confirmed) {
									Intent newGuide = new Intent(context, AccountActivity.class);
									startActivity(newGuide);
									animLeftToRight();
								} else {
									Tip("如需修改，请前往 [账号管理] 页面操作");
								}
							}
						});
						guideDialog.show();
					}
				});
			}

		}
	};

}