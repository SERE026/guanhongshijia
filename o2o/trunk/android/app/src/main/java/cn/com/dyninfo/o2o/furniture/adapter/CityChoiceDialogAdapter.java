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
import cn.com.dyninfo.o2o.furniture.bean.CitiesBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @Description 首页选择城市
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-6-6 下午5:44:37
 * @update 2014-6-9 10:07:18
 */
public class CityChoiceDialogAdapter extends BaseAdapter {

	private Context context;
	private List<CitiesBean> citys;
	private LayoutInflater inflater;

	public CityChoiceDialogAdapter(Context context, List<CitiesBean> citys) {
		this.context = context;
		this.citys = citys;
	}

	@Override
	public int getCount() {
		return citys.size();
	}

	@Override
	public Object getItem(int position) {
		return citys.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
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

		wrapper.name.setText(citys.get(position).getName());

		return view;
	}

	class ItemWrapper {
		TextView name;
	}

}