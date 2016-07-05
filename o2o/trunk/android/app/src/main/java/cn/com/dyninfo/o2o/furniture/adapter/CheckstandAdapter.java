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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.bean.CheckstandBean;

/**
 * 收银台 adapter
 * 
 * @author ly
 * 
 */
public class CheckstandAdapter extends BaseAdapter {

	private Context context;
	private List<CheckstandBean> list;

	public CheckstandAdapter(Context context, List<CheckstandBean> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int possion) {
		return list.get(possion);
	}

	@Override
	public long getItemId(int possion) {
		return possion;
	}

	class Holder {
		TextView car_name;
		TextView car_count;
		TextView car_money;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		Holder holder;

		if (view == null) {
			holder = new Holder();

			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.cart_activity_list_item, null);

			holder.car_name = (TextView) view.findViewById(R.id.car_name);
			holder.car_count = (TextView) view.findViewById(R.id.car_count);
			holder.car_money = (TextView) view.findViewById(R.id.car_money);

			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();
		}

		CheckstandBean bean = list.get(position);
		holder.car_name.setText(bean.getName());
		holder.car_count.setText(String.valueOf(bean.getCount()));
		holder.car_money.setText(bean.getMoney() + "");

		return view;
	}
}
