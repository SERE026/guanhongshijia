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

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.SpecBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @Description 商品详情页面需要的尺码、颜色等参数
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-9-2 17:43:42
 */
public class SpecAdapter extends BaseAdapter {

	private List<SpecBean> list;
	private Context context;
	private LayoutInflater inflater;
	private int point = -1;
	private String specID = "";

	public SpecAdapter(Context context, List<SpecBean> list) {
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
		return 0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.city_item, null);

			wrapper.name = (TextView) view.findViewById(R.id.city_name);

			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		wrapper.name.setText(list.get(position).getTxt());

		if (point == position)
			wrapper.name.setBackgroundResource(R.drawable.right_angle_orange_lite_stroke);
		else
			wrapper.name.setBackgroundResource(R.drawable.right_angle_white);

		wrapper.name.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				BaseActivity.Log_info("参数适配器，点击了：" + position);
				point = position;
				specID = list.get(position).getId();
				notifyDataSetChanged();
			}
		});
		return view;
	}

	class ItemWrapper {
		TextView name;
	}

	public int getChoice() {
		return point;
	}

	public String getSpecID() {
		return specID;
	}
}
