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

import java.text.DecimalFormat;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.GuideActivity;
import cn.com.dyninfo.o2o.furniture.activity.sign.SigninActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.APPManager;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.util.Update;
import cn.com.dyninfo.o2o.furniture.util.Util;
import cn.com.dyninfo.o2o.furniture.view.SwitchButton;

/**
 * @Description 账号管理
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-26 14:44:12
 * @update 2014-7-16 15:34:27 更新退出登录时机制，更新检查新版本
 */
public class AccountActivity extends BaseActivity implements OnClickListener {

	private String PAGE_TITLE = "账号管理";
	private String tag = " AccountActivity ";
	private int layoutID = R.layout.account;
	private Context context;
	private Handler handler;
	private Util util;
	private View address, edit_acc, location_layout, location, btn_cache, sina, tencent, auto_share, update_layout,
			signout;
	private TextView cache_size, location_now, guide, about;
	private SwitchButton sina_switch, tencent_switch, auto_switch;
	// 检测更新
	private Update update;
	private ImageView new_ver_dot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		context = this;
		handler = new Handler();
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		util = Util.getInstance(context);
		initView();
		initValue();
		// initSwitchTouch();
		initBroadcast();
		// 进入后检测一次更新
		if (update == null)
			update = new Update(context);
		update.check(false, false);
	}

	private void initView() {
		// 地址管理
		address = findViewById(R.id.address);
		address.setOnClickListener(this);
		// 账户信息
		edit_acc = findViewById(R.id.edit);
		edit_acc.setOnClickListener(this);
		// 省市管理
		location_layout = findViewById(R.id.location_layout);
		location_layout.setOnClickListener(this);
		location = findViewById(R.id.location);
		location.setOnClickListener(this);
		// 清缓存
		btn_cache = findViewById(R.id.btn_cache);
		btn_cache.setOnClickListener(this);
		// 更新
		update_layout = findViewById(R.id.update);
		update_layout.setOnClickListener(this);
		// 退出
		signout = findViewById(R.id.signout);
		signout.setOnClickListener(this);
		// 微博
		auto_share = findViewById(R.id.auto);
		auto_share.setOnClickListener(this);
		tencent = findViewById(R.id.tencent);
		tencent.setOnClickListener(this);
		sina = findViewById(R.id.sina);
		sina.setOnClickListener(this);

		// 关于
		guide = (TextView) findViewById(R.id.guide);
		guide.setOnClickListener(this);
		about = (TextView) findViewById(R.id.about);
		about.setOnClickListener(this);

		cache_size = (TextView) findViewById(R.id.cache_size);
		location_now = (TextView) findViewById(R.id.location_now);

		sina_switch = (SwitchButton) findViewById(R.id.sina_switch);
		tencent_switch = (SwitchButton) findViewById(R.id.tencent_switch);
		auto_switch = (SwitchButton) findViewById(R.id.auto_switch);
		// 新版本小圆点
		new_ver_dot = (ImageView) findViewById(R.id.new_ver_dot);
	}

	private void initValue() {
		sina_switch.setChecked(true);
	}

	// private void initSwitchTouch() {
	// sina_switch.setOnChangeListener(new OnChangedListener() {
	// @Override
	// public void OnChanged(boolean checkState) {
	// Tip("新浪微博 = " + checkState);
	// }
	// });
	// tencent_switch.setOnChangeListener(new OnChangedListener() {
	// @Override
	// public void OnChanged(boolean checkState) {
	// Tip("腾讯微博 = " + checkState);
	// }
	// });
	// auto_switch.setOnChangeListener(new OnChangedListener() {
	// @Override
	// public void OnChanged(boolean checkState) {
	// if (checkState) {
	// Log_info("想要开启自动分享，等待用户确认....");
	// ConfirmDialog dialog = new ConfirmDialog(context, "绑定微博",
	// "自动分享需要先绑定一个微博账号，需要现在绑定新浪微博吗？", "立即绑定");
	// dialog.show();
	// dialog.setOnDismissListener(new OnDismissListener() {
	// @Override
	// public void OnConfirmed(Boolean confirmed) {
	// if (confirmed) {
	// Log_info("用户进行了确认");
	// Tip("好吧，假设你绑定成功了");
	// auto_switch.setChecked(true);
	// } else {
	// Log_info("用户没有确认");
	// auto_switch.setChecked(false);
	// }
	// }
	// });
	// } else {
	// // 不自动分享
	// Log_info("用户取消了自动分享");
	// }
	//
	// }
	// });
	// }

	private long getCacheSize() {
		try {
			long default_size = 0, save_size = 0, cap_temp_size = 0, cap_cut_size = 0, cache_size = 0, share_size = 0;
			if (util.ImgCacheDefaultPath.exists()) {
				default_size = Sys.getFolderSize(util.ImgCacheDefaultPath);
			}
			if (util.ImgSavePath.exists()) {
				save_size = Sys.getFolderSize(util.ImgSavePath);
			}
			if (util.ImgCapCutPath.exists()) {
				cap_cut_size = Sys.getFolderSize(util.ImgCapCutPath);
			}
			if (util.ImgCapTempPath.exists()) {
				cap_temp_size = Sys.getFolderSize(util.ImgCapTempPath);
			}
			if (util.ImgCachePath.exists()) {
				cache_size = Sys.getFolderSize(util.ImgCachePath);
			}
			if (util.ImgSharePath.exists()) {
				share_size = Sys.getFolderSize(util.ImgSharePath);
			}
			Log.e("缓存大小", " 缓存共 " + (default_size + save_size + cap_temp_size + cap_cut_size + cache_size)
					+ " K , 其中图片缓存  " + (cache_size + default_size) + " K , 保存图片 " + save_size + " K ，图片拍摄 "
					+ cap_temp_size + " K ，裁剪后 " + cap_cut_size + " K" + " K ，分享图片 " + share_size + " K");
			return default_size + save_size + cap_temp_size + cap_cut_size + cache_size + share_size;
		} catch (Exception e) {
			APP.exception(tag, e);
		}

		return 0;
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		// 收货地址管理
		case R.id.address:
			startActivity(new Intent(context, AddressActivity.class));
			animLeftToRight();
			break;
			
		// 编辑账户信息
		case R.id.edit:
			startActivity(new Intent(context, EditInfoActivity.class));
			animLeftToRight();
			break;
			
		// 所在地区管理
		case R.id.location:
			Log_error(" location 被点击 ");
			startActivityForResult(new Intent(context, ProvincesListActivity.class), APPCode.CHOICE_LOCATION);
			animLeftToRight();
			break;

		case R.id.btn_cache:
			Log_info(tag + "正在清除缓存...");
			bmpUtils.clearMemoryCache();
			bmpUtils_short_holder.clearMemoryCache();
			try {
				Sys.deleteAllFilesOfDir(Util.IMG_SAVE_PATH, false);
				Sys.deleteAllFilesOfDir(Util.IMG_SHARE_PATH, false);
				Sys.deleteAllFilesOfDir(Util.IMG_CACHE_XUTILS_SDCARD_PATH, false);
				Sys.deleteAllFilesOfDir(Util.IMG_CACHE_XUTILS_DEFAULT_PATH, false);
				Tip("已清除缓存和保存的图片");
				initCacheSize();
			} catch (Exception e) {
				Log_info(tag + "清除缓存失败(可能是SD Card不存在)");
				APP.exception(tag, e);
			}
			break;

		case R.id.update:
			// 检查新版本
			if (update == null)
				update = new Update(context);
			update.check(true, true);
			break;
			
		// 向导
		case R.id.guide:
			startActivity(new Intent(context, GuideActivity.class));
			animLeftToRight();
			break;
			
		// 关于
		case R.id.about:
			startActivity(new Intent(context, AboutActivity.class));
			animLeftToRight();
			break;

		// 退出
		case R.id.signout:
			LocalUser user = getLastLocalUserInfoInstance(context);
			if (user.auto == 1) {
				user.delete();
			} else if (user.auto == 0) {
				user.auto = 2; // 退出
				user.signed = 1;// 未校验状态
				user.updateLocalUser();
			}
			myfinish();
			APPManager.getInstance().finish();
			startActivity(new Intent(this, SigninActivity.class));
			break;
		default:
			break;
		}
	}

	private void initCacheSize() {
		// 保留两位
		double size = getCacheSize() / 1024.0;
		DecimalFormat df = new DecimalFormat("###.00");
		Log.e("size", "size =  " + size + " M");
		if (size < 1) {
			cache_size.setText("0" + df.format(size) + " M");
			return;
		}
		cache_size.setText(df.format(size) + " M");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			// 修改当前分站（所在地区）
			if (requestCode == APPCode.CHOICE_LOCATION) {
				if (data != null) {
					setLocation(data.getStringExtra("provinces"));
				}
			}

			// 绑定微博

		}
	}

	private void setLocation(final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				location_now.setText(text);
			}
		});
	}

	private void initBroadcast() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("cn.com.dyninfo.o2o.furniture.activity.AccountActivity#showVerDot");
		registerReceiver(showVerDotBR, intentFilter);
	}

	private BroadcastReceiver showVerDotBR = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("cn.com.dyninfo.o2o.furniture.activity.AccountActivity#showVerDot")) {
				new_ver_dot.setVisibility(View.VISIBLE);
			}
		}
	};

	@Override
	protected void onResume() {
		initCacheSize();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(showVerDotBR);
		super.onDestroy();
	}

}