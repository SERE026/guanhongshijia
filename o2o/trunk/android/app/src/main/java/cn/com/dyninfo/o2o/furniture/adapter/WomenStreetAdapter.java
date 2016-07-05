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

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.home.GoodsListActivity;
import cn.com.dyninfo.o2o.furniture.bean.WomenStreetBean;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.BitmapUtils;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

/**
 * @Description 女人街 adapter
 * @author ceychen@foxmail.com
 * @date 2014-4-23 下午2:17:58
 * @update 2014-6-29 14:32:09
 */
public class WomenStreetAdapter extends BaseAdapter {

	private Context context;
	private BitmapUtils bmpUtils;
	private List<WomenStreetBean> list;
	private LayoutInflater inflater;
	private Boolean needAnim = true;

	public WomenStreetAdapter(Context context, BitmapUtils bmpUtils, List<WomenStreetBean> list) {
		this.context = context;
		this.bmpUtils = bmpUtils;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ItemWrapper {
		RelativeLayout item_layout;
		ImageView item_img;
		ImageView item_img_selector;
		TextView item_txt;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.woman_street_item, null);

			wrapper.item_layout = (RelativeLayout) view.findViewById(R.id.women_street_item_layout);
			wrapper.item_img = (ImageView) view.findViewById(R.id.img_img);
			wrapper.item_img_selector = (ImageView) view.findViewById(R.id.img_selector);
			wrapper.item_txt = (TextView) view.findViewById(R.id.txt);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		// 显示图片 679 * 194
		LayoutParams params = wrapper.item_img.getLayoutParams();
		params.height = APP.getImgSimpleHeight(context, 679, 194, 16);
		params.width = LayoutParams.MATCH_PARENT;
		wrapper.item_img.setLayoutParams(params);
		wrapper.item_img_selector.setLayoutParams(params);
		bmpUtils.display(wrapper.item_img,
				APP.women_street_path(list.get(position).getStoreID(), list.get(position).getImgUrl()));
		wrapper.item_txt.setText(list.get(position).getDescp());

		wrapper.item_img_selector.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent temp = new Intent(context, GoodsListActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("store_id", list.get(position).getStoreID());
				bundle.putString("page_title", list.get(position).getDescp());
				bundle.putInt("from", APPCode.WOMEN_STREEET_LIST);
				temp.putExtras(bundle);
				context.startActivity(temp);
			}
		});

		if (needAnim) {
			Animation animation;
			// animation = new TranslateAnimation(position * 200 +
			// Sys.getScreenWidth(context), 0, 0, 0);
			// animation.setDuration(600);
			animation = AnimationUtils.loadAnimation(context, R.anim.gradient_adv);
			if (animation != null)
				view.setAnimation(animation);
		}
		if (position == getCount() - 1) {
			needAnim = false;
		}
		return view;
	}
}