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

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

public class SlideTabOnClickListener implements OnClickListener {

	private ViewPager viewPager;
	private int position = 0;

	/**
	 * @Description slide tab 文字点击监听
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-12 下午4:25:09
	 * @update 2014-8-15 12:44:10
	 */
	public SlideTabOnClickListener(ViewPager viewPager, int position) {
		this.viewPager = viewPager;
		this.position = position;
	}

	public void onClick(View v) {
		BaseActivity.Log_info("slide_pager：点击了：" + position);
		viewPager.setCurrentItem(position);
	}

};