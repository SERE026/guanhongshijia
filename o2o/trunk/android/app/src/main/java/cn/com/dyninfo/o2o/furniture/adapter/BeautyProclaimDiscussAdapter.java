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
import cn.com.dyninfo.o2o.furniture.bean.BeautyProclaimDiscussBean;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BeautyProclaimDiscussAdapter extends BaseAdapter {
	private Context context;
	private List<BeautyProclaimDiscussBean> list;
	private LayoutInflater inflater;

	/**
	 * @Description 美丽宣言 讨论 adapter
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-23 上午11:01:31
	 * @update 2014-6-18 17:19:51
	 */
	public BeautyProclaimDiscussAdapter(Context context, List<BeautyProclaimDiscussBean> list) {
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
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ItemWrapper wrapper;
		BeautyProclaimDiscussBean bean = list.get(position);
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.beauty_proclaim_details_discuss_item, null);

			wrapper.txt = (TextView) view.findViewById(R.id.txt);
			wrapper.head = (ImageView) view.findViewById(R.id.head);

			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		LayoutParams params = wrapper.head.getLayoutParams();
		params.height = Sys.getScreenWidth(context) / 9;
		params.width = Sys.getScreenWidth(context) / 9;
		wrapper.head.setLayoutParams(params);

		wrapper.txt.setText(bean.getTxt());
		BaseActivity.bmpUtils_short_holder.display(wrapper.head, APP.head_path(bean.getHead()));

		return view;
	}

	class ItemWrapper {
		TextView txt;
		ImageView head;
	}

}