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

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

/**
 * @Description 不用解释，本来是地图切换省市用的，现在没用到
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @updated 2014-5-21 下午4:30:01 by ceychen
 */
public class PopWindowAdapter extends BaseAdapter {
	private ArrayList<String> itemList;
	private Context context;

	public PopWindowAdapter(Context context, ArrayList<String> itemList) {
		this.context = context;
		this.itemList = itemList;
	}

	@Override
	public int getCount() {
		return itemList.size();
	}

	@Override
	public Object getItem(int position) {
		return itemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		ViewHolder holder;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(R.layout.pomenu_item, null);
			holder = new ViewHolder();

			view.setTag(holder);

			holder.txt = (TextView) view.findViewById(R.id.txt);

		} else {
			holder = (ViewHolder) view.getTag();
		}
		holder.txt.setText(itemList.get(position));

		holder.txt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("cn.com.dyninfo.o2o.furniture.fragment.side.SideFragment#click");
				intent.putExtra("position", position);
				context.sendBroadcast(intent);
			}
		});

		return view;
	}

	private final class ViewHolder {
		TextView txt;
	}
}