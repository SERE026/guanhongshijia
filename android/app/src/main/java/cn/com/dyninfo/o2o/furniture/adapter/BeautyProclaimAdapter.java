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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.BeautyProclaimBean;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Sys;

/**
 * @Description 美丽宣言 adapter
 * @author ceychen@foxmail.com
 * @date 2014-5-22 下午5:08:48
 * @update 2014-6-18 09:31:45
 */
public class BeautyProclaimAdapter extends BaseAdapter {

	private Context context;
	private List<BeautyProclaimBean> list;
	private LayoutInflater inflater;

	public BeautyProclaimAdapter(Context context, List<BeautyProclaimBean> list) {
		this.context = context;
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
		return list.get(position).getId();
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		BeautyProclaimBean bean = list.get(position);
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.beauty_proclaim_item, null);

			wrapper.layout = (RelativeLayout) view.findViewById(R.id.layout);
			wrapper.img = (ImageView) view.findViewById(R.id.img);
			wrapper.head = (ImageView) view.findViewById(R.id.head);
			wrapper.goodsName = (TextView) view.findViewById(R.id.txt);
			wrapper.name = (TextView) view.findViewById(R.id.name);
			wrapper.count = (TextView) view.findViewById(R.id.count);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		wrapper.layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("cn.com.dyninfo.o2o.furniture.activity.home.BeautyProclaim#click");
				intent.putExtra("position", position);
				context.sendBroadcast(intent);
			}
		});
		LayoutParams params = wrapper.head.getLayoutParams();
		params.height = Sys.getScreenWidth(context) / 9;
		params.width = Sys.getScreenWidth(context) / 9;
		wrapper.head.setLayoutParams(params);
		params = wrapper.img.getLayoutParams();
		params.height = (Sys.getScreenWidth(context) - Sys.sp2px(context, 24)) / 2;
		params.width = (Sys.getScreenWidth(context) - Sys.sp2px(context, 24)) / 2;
		wrapper.img.setLayoutParams(params);

		BaseActivity.bmpUtils_short_holder.display(wrapper.img, APP.goods_path(bean.getImg()));
		BaseActivity.bmpUtils_short_holder.display(wrapper.head, APP.head_path(bean.getHead()));

		wrapper.goodsName.setText(bean.getGoodsName());
		wrapper.name.setText(bean.getName());
		wrapper.count.setText("发帖" + bean.getCount() + "条");

		return view;
	}

	class ItemWrapper {
		RelativeLayout layout;
		ImageView img;
		ImageView head;
		TextView goodsName;
		TextView name;
		TextView count;
	}
}