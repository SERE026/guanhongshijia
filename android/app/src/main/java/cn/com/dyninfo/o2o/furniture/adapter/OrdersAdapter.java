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
import cn.com.dyninfo.o2o.furniture.bean.OrderBean;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import cn.com.dyninfo.o2o.furniture.view.CustomerListView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class OrdersAdapter extends BaseAdapter {

	private Context context;
	// private NumArithmetic numArithmetic;
	private List<OrderBean> list;
	private LayoutInflater inflater;

	/**
	 * @Description 我的订单 adapter
	 * @author ceychen@foxmail.com
	 * @date 2014-5-14 下午4:52:13
	 * @update 2014-6-19 14:56:12
	 */
	public OrdersAdapter(Context context, List<OrderBean> list) {
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

	class ItemWrapper {
		RelativeLayout layout;
		TextView pay_status;
		TextView order_no;
		TextView order_time;
		TextView label_total_price;
		TextView btn;
		CustomerListView listview;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.order_item, null);

			wrapper.layout = (RelativeLayout) view.findViewById(R.id.layout);
			wrapper.pay_status = (TextView) view.findViewById(R.id.pay_status);
			wrapper.order_no = (TextView) view.findViewById(R.id.order_no);
			wrapper.order_time = (TextView) view.findViewById(R.id.order_time);
			wrapper.listview = (CustomerListView) view.findViewById(R.id.listview);
			wrapper.label_total_price = (TextView) view.findViewById(R.id.label_total_price);
			wrapper.btn = (TextView) view.findViewById(R.id.btn);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		// wrapper.layout.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// BaseActivity.Tip(list.get(position).getId());
		// }
		// });
		wrapper.listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int location, long id) {
				BaseActivity.Tip(list.get(position).getItem_list().get(location).getName());
			}
		});
		wrapper.btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("id", list.get(position).getId());
				System.out.println("------>点击订单详情按钮，订单编号：" + intent.getStringExtra("id"));
				intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity#detail");
				context.sendBroadcast(intent);
			}
		});

		wrapper.pay_status.setText(list.get(position).getPayStatus());
		wrapper.order_no.setText(list.get(position).getOrderNo());
		wrapper.order_time.setText(MyDate.timestamp2date(list.get(position).getDatetime()));
		// // 计算总价和运费
		// double totalPrice = 0;
		// numArithmetic = new NumArithmetic();
		// for (int i = 0; i < list.get(position).getItem_list().size(); i++) {
		// totalPrice +=
		// numArithmetic.mul(list.get(position).getItem_list().get(i).getprice(),
		// list.get(position)
		// .getItem_list().get(i).getCount());
		// }
		// // 假设 49 免运费
		// double Freight = totalPrice > 49 ? 0 : 5;

		wrapper.label_total_price.setText("合计 " + list.get(position).getTotalPrice() + " 元(不含运费 "
				+ list.get(position).getFreight() + " 元)");
		wrapper.listview.setAdapter(new OrderGoodsAdapter(context, list.get(position).getItem_list()));

		// numArithmetic = null;
		return view;
	}
}