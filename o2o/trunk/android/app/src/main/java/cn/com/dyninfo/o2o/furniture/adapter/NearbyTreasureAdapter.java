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
import cn.com.dyninfo.o2o.furniture.activity.details.GoodsDetailsActivity;
import cn.com.dyninfo.o2o.furniture.bean.NearbyTreasuredBean;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-7-9 11:52:56 修改点击事件
 */
public class NearbyTreasureAdapter extends BaseAdapter {

	private Context context;
	private List<NearbyTreasuredBean> list;

	public NearbyTreasureAdapter(Context context, List<NearbyTreasuredBean> list) {
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
		return list.get(possion).getGoods_id();
	}

	class HotMarketItemsHolder {
		ImageView goods_icon;
		TextView nearName;
		TextView range;
		TextView nearAddress;
		TextView now_price;
		TextView old_price;
		TextView danwei;
		TextView discount;
		ImageView che;
		LinearLayout hot_market_item;
		LinearLayout item_layout;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {

		HotMarketItemsHolder holder;

		if (view == null) {
			holder = new HotMarketItemsHolder();

			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.goods_list_item, null);

			holder.item_layout = (LinearLayout) view.findViewById(R.id.goods_item);
			holder.goods_icon = (ImageView) view.findViewById(R.id.goods_icon);
			holder.nearName = (TextView) view.findViewById(R.id.goods_name);
			holder.range = (TextView) view.findViewById(R.id.range);
			holder.nearAddress = (TextView) view.findViewById(R.id.address);
			holder.now_price = (TextView) view.findViewById(R.id.now_price);
			holder.old_price = (TextView) view.findViewById(R.id.old_price);
			holder.danwei = (TextView) view.findViewById(R.id.hot_at_danwei);
			holder.discount = (TextView) view.findViewById(R.id.rebae);
			holder.che = (ImageView) view.findViewById(R.id.cart);
			holder.hot_market_item = (LinearLayout) view.findViewById(R.id.hot_market_item);

			holder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			holder.danwei.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

			view.setTag(holder);
		} else {
			holder = (HotMarketItemsHolder) view.getTag();
		}
		// 赋值
		final NearbyTreasuredBean bean = list.get(position);

		BaseActivity.bmpUtils_short_holder.display(holder.goods_icon, bean.getNearImg());
		holder.nearName.setText(bean.getNearName());
		holder.range.setText(bean.getRange() + "km");
		holder.nearAddress.setText(bean.getNearAddress());
		holder.now_price.setText(bean.getNowPrice() + "");
		holder.old_price.setText(bean.getOldPrice() + "");
		holder.discount.setText(bean.getDiscount() + "");

		holder.che.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				BaseActivity.addToCartList(context, bean.getGoods_id(), 1);
			}
		});

		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-9 11:52:56
		 */
		holder.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();

				bundle.putInt("id", bean.getGoods_id());
				bundle.putString("name", bean.getNearName());
				bundle.putString("img", bean.getNearImg());
				bundle.putInt("actid", 0);
				bundle.putDouble("now", bean.getNowPrice());
				bundle.putDouble("old", bean.getOldPrice());

				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});

		return view;
	}
}