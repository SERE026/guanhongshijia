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
import cn.com.dyninfo.o2o.furniture.bean.AbsaDetaileBean;
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
 * 身边美容院详情 适配器
 * 
 * @author ly
 * @update 2014-7-8 15:03:10 更新加入到购物车
 * 
 */
public class AbsaDetailedAdapter extends BaseAdapter {

	private Context context;
	private List<AbsaDetaileBean> list;
	private int goods_id;

	public AbsaDetailedAdapter(Context context, List<AbsaDetaileBean> list) {
		super();
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
		ImageView goods_icon;
		TextView goods_name;
		TextView rebae;
		TextView range;
		TextView address;
		TextView now_price;
		TextView old_price;
		TextView hot_at_danwei;
		ImageView che;
		LinearLayout item_layout;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {

		HotMarketItemsHolder holder;

		if (view == null) {
			holder = new HotMarketItemsHolder();

			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.goods_list_item, null);

			holder.goods_icon = (ImageView) view.findViewById(R.id.goods_icon);
			holder.goods_name = (TextView) view.findViewById(R.id.goods_name);
			holder.rebae = (TextView) view.findViewById(R.id.rebae);
			holder.address = (TextView) view.findViewById(R.id.address);
			holder.now_price = (TextView) view.findViewById(R.id.now_price);
			holder.old_price = (TextView) view.findViewById(R.id.old_price);
			holder.hot_at_danwei = (TextView) view.findViewById(R.id.hot_at_danwei);
			holder.che = (ImageView) view.findViewById(R.id.cart);
			holder.item_layout = (LinearLayout) view.findViewById(R.id.goods_item);

			holder.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			holder.hot_at_danwei.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

			holder.address.setVisibility(View.INVISIBLE);

			view.setTag(holder);
		} else {
			holder = (HotMarketItemsHolder) view.getTag();
		}
		// 赋值
		final AbsaDetaileBean bean = list.get(position);

		BaseActivity.bmpUtils_short_holder.display(holder.goods_icon, bean.getImg());
		holder.goods_name.setText(bean.getName());
		holder.rebae.setText(bean.getDiscount() + "");
		holder.now_price.setText(bean.getNowPrice() + "");
		holder.old_price.setText(bean.getOldPrice() + "");

		holder.che.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				AbsaDetaileBean bean = list.get(position);
				goods_id = bean.getGoodId();

				BaseActivity.addToCartList(context, goods_id, 1);

			}
		});

		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-22 17:06:47
		 */
		holder.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt("id", bean.getGoodId());
				bundle.putString("name", bean.getName());
				bundle.putString("img", bean.getImg());
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