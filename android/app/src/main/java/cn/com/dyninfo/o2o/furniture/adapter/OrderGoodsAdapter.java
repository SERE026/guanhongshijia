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
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;

public class OrderGoodsAdapter extends BaseAdapter {

	private Context context;
	private List<OrderGoodsBean> item_list;
	private LayoutInflater inflater;

	/**
	 * @Description 退换货-进行中- 每一项 里面的 商品列表
	 * @author ceychen@foxmail.com
	 * @date 2014-5-10 下午5:08:01
	 * @update 2014-5-12 09:44:01
	 */
	public OrderGoodsAdapter(Context context, List<OrderGoodsBean> item_list) {
		this.context = context;
		this.item_list = item_list;
		if (this.item_list == null) {
			this.item_list = new ArrayList<OrderGoodsBean>();
		}
	}

	@Override
	public int getCount() {
		return item_list.size();
	}

	@Override
	public Object getItem(int position) {
		return item_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ItemWrapper {
		TextView name;
		TextView price;
		TextView count;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.order_goods_item, null);

			wrapper.name = (TextView) view.findViewById(R.id.detail_name);
			wrapper.price = (TextView) view.findViewById(R.id.detail_price);
			wrapper.count = (TextView) view.findViewById(R.id.detail_count);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		if (item_list.get(position) != null) {
			wrapper.name.setText(item_list.get(position).getName());
			wrapper.price.setText(item_list.get(position).getprice() + " 元");
			wrapper.count.setText(" × " + item_list.get(position).getCount());
		}

		return view;
	}

}