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
import cn.com.dyninfo.o2o.furniture.bean.BeautyProjectBean;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.BitmapUtils;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 美容项目适配器
 * 
 * @author ly
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-7-9 11:59:06
 */
public class BeautyProjectAdapter extends BaseAdapter {

	private Context context;
	private List<BeautyProjectBean> list;

	public BeautyProjectAdapter(Context context, List<BeautyProjectBean> list) {
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
		return list.get(position).getGoods_id();
	}

	class HotMarketItemsHolder {
		ImageView goods_icon;
		TextView nearName;
		TextView nearAddress;
		TextView now_price;
		TextView old_price;
		TextView discount;
		TextView danwei;
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
			holder.nearAddress = (TextView) view.findViewById(R.id.address);
			holder.now_price = (TextView) view.findViewById(R.id.now_price);
			holder.old_price = (TextView) view.findViewById(R.id.old_price);
			holder.discount = (TextView) view.findViewById(R.id.rebae);
			holder.danwei = (TextView) view.findViewById(R.id.hot_at_danwei);
			holder.che = (ImageView) view.findViewById(R.id.cart);
			holder.hot_market_item = (LinearLayout) view.findViewById(R.id.hot_market_item);

			holder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			holder.danwei.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

			view.setTag(holder);
		} else {
			holder = (HotMarketItemsHolder) view.getTag();
		}
		// 赋值
		BeautyProjectBean bean = list.get(position);

		BitmapUtils utils = new BitmapUtils(context);
		utils.display(holder.goods_icon, bean.getBeautyProjectImg());
		holder.nearName.setText(bean.getBeautyProjectName());
		holder.nearAddress.setText(bean.getBeautyProjectAddress());
		holder.now_price.setText(bean.getNowPrice() + "");
		holder.old_price.setText(bean.getOldPrice() + "");
		holder.discount.setText(bean.getDiscount() + "");

		holder.che.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				BaseActivity.addToCartList(context, list.get(position).getGoods_id(), 1);
			}
		});

		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-9 11:59:06
		 */
		holder.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();

				BeautyProjectBean bean = list.get(position);

				bundle.putInt("id", bean.getGoods_id());
				bundle.putString("name", bean.getBeautyProjectName());
				bundle.putString("img", bean.getBeautyProjectImg());
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