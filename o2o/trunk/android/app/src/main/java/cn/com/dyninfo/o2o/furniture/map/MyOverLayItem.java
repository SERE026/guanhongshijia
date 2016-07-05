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

package cn.com.dyninfo.o2o.furniture.map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cn.com.dyninfo.o2o.furniture.R;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import cn.com.dyninfo.o2o.furniture.fragment.SideFragment;
import cn.com.dyninfo.o2o.furniture.util.APP;

public class MyOverLayItem extends ItemizedOverlay<OverlayItem> {

	public static int onId = 0;
	public static String onName = "";
	private Context context;

	// 用MapView构造ItemizedOverlay
	public MyOverLayItem(Context context, Drawable mark, MapView mapView) {
		super(mark, mapView);
		this.context = context;
	}

	public boolean onTap(GeoPoint pt, MapView mapView) {
		// 在此处理MapView的点击事件，当返回 true时
		super.onTap(pt, mapView);
		return false;
	}

	@Override
	public boolean onTap(int i) {
		onId = Integer.parseInt(this.getItem(i).getTitle());
		onName = this.getItem(i).getSnippet();
		try {
			Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_from_bottom);
			SideFragment.shop_layout.setAnimation(anim);
		} catch (Exception e) {
			SideFragment.shop_layout.setVisibility(View.VISIBLE);
			APP.exception("地图设置底部栏", e);
		}

		SideFragment.click_shop.setText(this.getItem(i).getSnippet());
		return true;
	}
}
