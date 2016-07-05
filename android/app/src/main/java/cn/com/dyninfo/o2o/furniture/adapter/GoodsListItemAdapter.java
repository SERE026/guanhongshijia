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
import cn.com.dyninfo.o2o.furniture.bean.HotMarketBean;
import cn.com.dyninfo.o2o.furniture.widget.RoundImageView;

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
 * 商品列表 item adapter
 * 
 * @author ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-7-9 11:55:28 更新点击事件
 */
public class GoodsListItemAdapter extends BaseAdapter {

	private Context context;
	private List<HotMarketBean> list;

	public GoodsListItemAdapter(Context context, List<HotMarketBean> list) {
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
		return list.get(possion).getGoodId();
	}

	class HotMarketItemsHolder {
		RoundImageView goods_icon;
		TextView goods_name;
		TextView rebae;
		TextView address;
		TextView now_price;
		TextView old_price;
		TextView hot_at_danwei;
		ImageView cart;
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
			holder.goods_icon = (RoundImageView) view.findViewById(R.id.goods_icon);
			holder.goods_name = (TextView) view.findViewById(R.id.goods_name);
			holder.rebae = (TextView) view.findViewById(R.id.rebae);
			holder.address = (TextView) view.findViewById(R.id.address);
			holder.now_price = (TextView) view.findViewById(R.id.now_price);
			holder.old_price = (TextView) view.findViewById(R.id.old_price);
			holder.hot_at_danwei = (TextView) view.findViewById(R.id.hot_at_danwei);
			holder.cart = (ImageView) view.findViewById(R.id.cart);

			holder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			holder.hot_at_danwei.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

			holder.address.setVisibility(View.INVISIBLE);

			view.setTag(holder);
		} else {
			holder = (HotMarketItemsHolder) view.getTag();
		}

		HotMarketBean bean = list.get(position);

		BaseActivity.bmpUtils_short_holder.display(holder.goods_icon, bean.getHotImg());
		holder.goods_name.setText(bean.getHotName());
		holder.rebae.setText(String.valueOf(bean.getDiscount()));
		holder.now_price.setText(String.valueOf(bean.getNowPrice()));
		holder.old_price.setText(String.valueOf(bean.getOldPrice()));
		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-9 11:55:28
		 */
		holder.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();
				HotMarketBean bean = list.get(position);
				bundle.putInt("id", bean.getGoodId());
				bundle.putString("name", bean.getHotName());
				bundle.putString("img", bean.getHotImg());
				bundle.putInt("actid", 0);
				bundle.putDouble("now", bean.getNowPrice());
				bundle.putDouble("old", bean.getOldPrice());
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});

		holder.cart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				BaseActivity.addToCartList(context, list.get(position).getGoodId(), 1);
			}
		});

		return view;
	}

}