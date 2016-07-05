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
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.details.AbsaDetailedActivity;
import cn.com.dyninfo.o2o.furniture.bean.AtBeautyShopBean;

/**
 * 
 * @author ly
 * 
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-7-9 12:01:16 更新点击事件
 */
public class AtBeautyShopAdapter extends BaseAdapter {

	private Context context;
	private List<AtBeautyShopBean> list;

	public AtBeautyShopAdapter(Context context, List<AtBeautyShopBean> list) {
		this.context = context;
		this.list = list == null ? new ArrayList<AtBeautyShopBean>() : list;
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

	class HotMarketItemsHolder {
		ImageView img;
		TextView name;
		TextView address;
		TextView range;
		TextView phone;
		LinearLayout item_layout;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {

		HotMarketItemsHolder holder;

		if (view == null) {
			holder = new HotMarketItemsHolder();

			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.at_beauty_items, null);

			holder.item_layout = (LinearLayout) view.findViewById(R.id.hot_market_item);
			holder.img = (ImageView) view.findViewById(R.id.at_beauty_goods_icon);
			holder.name = (TextView) view.findViewById(R.id.at_beauty_goods_name);
			holder.address = (TextView) view.findViewById(R.id.at_beauty_address);
			holder.range = (TextView) view.findViewById(R.id.at_beauty_range);
			holder.phone = (TextView) view.findViewById(R.id.at_beauty_phone);

			view.setTag(holder);
		} else {
			holder = (HotMarketItemsHolder) view.getTag();
		}
		// 赋值
		AtBeautyShopBean bean = list.get(position);

		BaseActivity.bmpUtils_short_holder.display(holder.img, bean.getAtBeautyImg());

		holder.name.setText(bean.getAtBeautyName());
		holder.address.setText(bean.getAtBeautyAddress());
		holder.range.setText(bean.getRange() + "");
		holder.phone.setText(bean.getPhone());

		/**
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-9 12:01:16
		 */
		holder.item_layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AbsaDetailedActivity.class);
				Bundle bundle = new Bundle();
				AtBeautyShopBean bean = list.get(position);
				bundle.putInt("id", bean.getId());
				bundle.putString("name", bean.getAtBeautyName());
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});

		return view;

	}
}