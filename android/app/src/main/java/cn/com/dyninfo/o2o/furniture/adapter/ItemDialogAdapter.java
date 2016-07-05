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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

/**
 * @Description 列表选择框 dialog adapter
 * @author ceychen@foxmail.com
 * @date 2014-5-21 上午10:47:33
 */
public class ItemDialogAdapter extends BaseAdapter {

	private Context context;
	private String[] items;
	private LayoutInflater inflater;

	public ItemDialogAdapter(Context context, String[] items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public Object getItem(int position) {
		return items[position];
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
			view = inflater.inflate(R.layout.item_dialog_item, null);

			wrapper.txt = (TextView) view.findViewById(R.id.txt);

			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		wrapper.txt.setText(items[position]);

		return view;
	}

	class ItemWrapper {
		TextView txt;
	}

}