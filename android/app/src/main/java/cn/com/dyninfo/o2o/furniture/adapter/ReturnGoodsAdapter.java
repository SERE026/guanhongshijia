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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.ReturnGoodsBean;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;

/**
 * @Description 退换货
 * @author ceychen@foxmail.com
 * @date 2014-5-10 下午3:30:19
 * @update 2014-5-12 10:54:48
 */
public class ReturnGoodsAdapter extends BaseAdapter {

	private Context context;
	private List<ReturnGoodsBean> list;
	private LayoutInflater inflater;

	public ReturnGoodsAdapter(Context context, List<ReturnGoodsBean> list) {
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
		return Integer.parseInt(list.get(position).getId());
	}

	class ItemWrapper {
		RelativeLayout layout;
		TextView orderNo;
		TextView order_time;
		CustomerListView listview;
		TextView status;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.return_goods_item, null);

			wrapper.layout = (RelativeLayout) view.findViewById(R.id.return_ing_item_layout);
			wrapper.orderNo = (TextView) view.findViewById(R.id.order_no);
			wrapper.order_time = (TextView) view.findViewById(R.id.order_time);
			wrapper.listview = (CustomerListView) view.findViewById(R.id.listview);
			wrapper.status = (TextView) view.findViewById(R.id.status);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		wrapper.layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				BaseActivity.Tip(list.get(position).getOrderNo());
			}
		});
		wrapper.listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int location, long id) {
				BaseActivity.Tip(list.get(position).getItem_list().get(location).getName());
			}
		});

		wrapper.orderNo.setText(list.get(position).getOrderNo());
		wrapper.order_time.setText(list.get(position).getDatetime());
		wrapper.status.setText(list.get(position).getStatus());
		wrapper.listview.setAdapter(new OrderGoodsAdapter(context, list.get(position).getItem_list()));

		return view;
	}
}