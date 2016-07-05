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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.OrderCommentImgBean;
import cn.com.dyninfo.o2o.furniture.bean.OrderGoodsBean;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import cn.com.dyninfo.o2o.furniture.view.ClearEditText;

public class OrderCommentAdapter extends BaseAdapter {

	private Context context;
	private String tag = " OrderCommentAdapter ";
	private List<OrderGoodsBean> item_list;
	private List<OrderCommentImgBean> item_list_img;
	private LayoutInflater inflater;
	private double[] ratings = null;
	private String[] comTxt = null;

	/**
	 * @Description 晒单
	 * @author ceychen@foxmail.com
	 * @date 2014-5-19 下午3:02:29
	 * @update 2014-8-11 17:49:10 新增文字评价
	 *         <hr>
	 *         2014-5-20 18:10:22
	 */
	public OrderCommentAdapter(Context context, List<OrderGoodsBean> item_list, List<OrderCommentImgBean> item_list_img) {
		this.context = context;
		this.item_list = item_list == null ? new ArrayList<OrderGoodsBean>() : item_list;
		this.item_list_img = item_list_img == null ? new ArrayList<OrderCommentImgBean>() : item_list_img;

		ratings = new double[getCount()];
		comTxt = new String[getCount()];
		for (int i = 0; i < getCount(); i++) {
			ratings[i] = 5;
			comTxt[i] = " ";
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
		RatingBar rating;
		ClearEditText txt;
		ImageView upload_btn;
		ImageView img_1, img_2, img_3, img_4;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.order_comment_item, null);

			wrapper.name = (TextView) view.findViewById(R.id.goods_name);
			wrapper.txt = (ClearEditText) view.findViewById(R.id.txt);
			wrapper.rating = (RatingBar) view.findViewById(R.id.rating);
			wrapper.upload_btn = (ImageView) view.findViewById(R.id.upload_btn);
			// 四张图片
			wrapper.img_1 = (ImageView) view.findViewById(R.id.img_1);
			wrapper.img_2 = (ImageView) view.findViewById(R.id.img_2);
			wrapper.img_3 = (ImageView) view.findViewById(R.id.img_3);
			wrapper.img_4 = (ImageView) view.findViewById(R.id.img_4);

			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		if (item_list.get(position) != null) {
			wrapper.name.setText(item_list.get(position).getName());
		}
		wrapper.upload_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (item_list_img.get(position).getImg_4() != null) {
					BaseActivity.Tip("最多上传4张图片");
					return;
				}
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putInt("position", position);
				bundle.putSerializable("img_list", (Serializable) item_list_img);
				intent.putExtras(bundle);
				intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.OrderCommentActivity#addpic");
				context.sendBroadcast(intent);
			}
		});
		if (item_list_img.get(position) != null) {
			String[] uris = { item_list_img.get(position).getImg_1(), item_list_img.get(position).getImg_2(),
					item_list_img.get(position).getImg_3(), item_list_img.get(position).getImg_4() };
			ImageView[] imgViews = { wrapper.img_1, wrapper.img_2, wrapper.img_3, wrapper.img_4 };
			try {
				for (int i = 0; i < uris.length; i++) {
					if (uris[i] != null) {
						BaseActivity.bmpUtils_short_holder.display(imgViews[i], uris[i]);
						imgViews[i].setVisibility(View.VISIBLE);
					} else {
						imgViews[i].setBackgroundColor(context.getResources().getColor(R.color.none_color));
						if (uris[0] == null)
							imgViews[i].setVisibility(View.GONE);
						else
							imgViews[i].setVisibility(View.INVISIBLE);
					}
				}
			} catch (Exception e) {
				APP.exception(tag, e);
			}
		}
		wrapper.rating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				ratings[position] = rating;
			}
		});

		// 评价文本
		wrapper.txt.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				comTxt[position] = wrapper.txt.getText().toString();
			}
		});
		LayoutParams params = wrapper.img_1.getLayoutParams();
		params.width = (Sys.getScreenWidth(context) - Sys.Dp2Px(context, 36)) / 4;
		params.height = params.width;
		wrapper.img_1.setLayoutParams(params);
		wrapper.img_2.setLayoutParams(params);
		wrapper.img_3.setLayoutParams(params);
		wrapper.img_4.setLayoutParams(params);
		params = wrapper.rating.getLayoutParams();
		params.height = BitmapFactory.decodeResource(context.getResources(), R.drawable.rating_normal).getHeight();
		params.width = 5 * BitmapFactory.decodeResource(context.getResources(), R.drawable.rating_normal).getWidth();

		return view;
	}

	public String getRatings() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ratings.length; i++) {
			sb.append(ratings[i]);
			if (i != ratings.length - 1)
				sb.append(",");
		}
		System.out.println(" --------> 星星依次为：" + sb.toString());
		return sb.toString();
	}

	public String getComTxt() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < comTxt.length; i++) {
			sb.append(comTxt[i].replace(" ", "").length() == 0 ? " " : comTxt[i]);// 没有输入时，添加空格方便服务器解析
			if (i != comTxt.length - 1)
				sb.append(":end-");// 约定的分隔符
		}
		System.out.println(" --------> 评论内容是：" + sb.toString());
		return sb.toString();
	}

}