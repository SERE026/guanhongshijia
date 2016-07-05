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

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

/**
 * @Description 关于软件
 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
 *          2014-9-15 下午5:45:00
 */
public class AboutActivity extends BaseActivity {

	private String PAGE_TITLE = "关于";
	private int layoutID = R.layout.about;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutID);
		addToActManager(this);
		initTitleAndClick(context, layoutID, PAGE_TITLE);
		// 显示版本信息
		PackageInfo info;
		try {
			info = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
			((TextView) findViewById(R.id.version)).setText(info.versionName);
		} catch (NameNotFoundException e) {
		}
	}

	@Override
	public void onBackPressed() {
		myfinish();
	}

}