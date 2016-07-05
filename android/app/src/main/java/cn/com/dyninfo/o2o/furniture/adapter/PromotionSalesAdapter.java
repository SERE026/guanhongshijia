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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.details.GoodsDetailsActivity;
import cn.com.dyninfo.o2o.furniture.activity.game.GameClick;
import cn.com.dyninfo.o2o.furniture.activity.game.GameTurntable;
import cn.com.dyninfo.o2o.furniture.bean.PlayingGoodsBean;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 活动商品
 * 
 * @author ly
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-8-15 17:31:07 解决以前列表和详情数据不一致问题（ly 遗留的错误写法）
 */
public class PromotionSalesAdapter extends BaseAdapter {

	private Context context;
	private List<PlayingGoodsBean> list;

	public PromotionSalesAdapter(Context context, List<PlayingGoodsBean> list) {
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
		TextView time;
		TextView rebae;
		TextView now_price;
		TextView old_price;
		TextView danwei;
		ImageView che;
		ImageView game;
		LinearLayout item_layout;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {

		final HotMarketItemsHolder wrapper;
		PlayingGoodsBean bean = list.get(position);

		if (view == null) {
			wrapper = new HotMarketItemsHolder();

			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.goods_list_item, null);

			wrapper.item_layout = (LinearLayout) view.findViewById(R.id.goods_item);
			wrapper.goods_icon = (ImageView) view.findViewById(R.id.goods_icon);
			wrapper.time = (TextView) view.findViewById(R.id.address);
			wrapper.now_price = (TextView) view.findViewById(R.id.now_price);
			wrapper.old_price = (TextView) view.findViewById(R.id.old_price);
			wrapper.danwei = (TextView) view.findViewById(R.id.hot_at_danwei);
			wrapper.che = (ImageView) view.findViewById(R.id.cart);
			wrapper.game = (ImageView) view.findViewById(R.id.game);
			wrapper.rebae = (TextView) view.findViewById(R.id.rebae);
			wrapper.goods_name = (TextView) view.findViewById(R.id.goods_name);

			view.setTag(wrapper);
		} else {
			wrapper = (HotMarketItemsHolder) view.getTag();
		}

		wrapper.old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		wrapper.danwei.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

		wrapper.che.setVisibility(View.GONE);
		wrapper.game.setVisibility(View.VISIBLE);
		// 赋值
		BaseActivity.bmpUtils_short_holder.display(wrapper.goods_icon, bean.getPlayingGoodsImg());
		wrapper.goods_name.setText(bean.getPlayingGoodsName());
		wrapper.rebae.setText(bean.getDiscount() + "");
		wrapper.now_price.setText(bean.getNowPrice() + "");
		wrapper.old_price.setText(bean.getOldPrice() + "");

		// 活动结束倒计时

		long timeend = list.get(position).getEndTime() - MyDate.getTimestamp();
		// System.out.println(position + "离结束" + timeend + "，规定时间：" +
		// list.get(position).getEndTime());
		wrapper.time.setText("离结束：" + MyDate.timestamp2hours(timeend));
		if (timeend > 0) {
			wrapper.time.setText("离结束：" + MyDate.timestamp2hours(timeend));
		} else {
			wrapper.time.setText("已结束");
		}

		wrapper.game.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				PlayingGoodsBean bean = list.get(position);
				final Bundle bundle = new Bundle();
				bundle.putInt("id", bean.getGoodId());
				bundle.putInt("actid", bean.getActId());
				bundle.putString("img", bean.getPlayingGoodsImg());
				bundle.putDouble("now", bean.getNowPrice());
				bundle.putString("name", bean.getPlayingGoodsName());
				bundle.putDouble("old", bean.getOldPrice());

				// 根据 活动id 判断 游戏类型，进行跳转
				new Thread() {
					@Override
					public void run() {
						Looper.prepare();
						LoadingDialog dialog = new LoadingDialog(context);
						dialog.show();
						String json = SyncApi.getGameType(String.valueOf(list.get(position).getActId()));
						JSONObject object = APP.checkReturnData(json, context);
						if (object != null) {
							if (object.has("status")) {
								try {
									if (object.getInt("status") == ErrorCode.SUCCESS) {
										JSONArray array = object.getJSONArray("data");
										if (array.length() > 0) {
											if (array.getJSONObject(0).getString("gamename").equals("zhuanpan")) {
												// 转盘游戏
												Intent intent = new Intent(context, GameTurntable.class);
												intent.putExtras(bundle);
												context.startActivity(intent);
											} else if (array.getJSONObject(0).getString("gamename").equals("diandian")) {
												// 点击游戏
												Intent intent = new Intent(context, GameClick.class);
												intent.putExtras(bundle);
												context.startActivity(intent);
											}
										}
									} else if (object.getInt("status") == ErrorCode.ERROR) {
										// 这个产品做得活动，不是玩游戏，直接去详情页购买即可
										openDetails(position);
									}
								} catch (JSONException e) {
									BaseActivity.Tip("获取活动信息失败");
									e.printStackTrace();
								}
							}
						} else {
							BaseActivity.Tip(APPCode.WEB_NULL);
						}
						dialog.dismiss();
						super.run();
					}
				}.start();
			}

		});
		/**
		 * 每一项点击事件
		 * 
		 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
		 * @date 2014-7-9 11:49:55
		 */
		wrapper.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				openDetails(position);
			}
		});

		return view;
	}

	protected void openDetails(int position) {
		Intent intent = new Intent(context, GoodsDetailsActivity.class);
		Bundle bundle = new Bundle();
		PlayingGoodsBean bean = list.get(position);
		bundle.putString("name", bean.getPlayingGoodsName());
		bundle.putString("img", bean.getPlayingGoodsImg());
		bundle.putInt("actid", bean.getActId());
		bundle.putInt("id", bean.getGoodId());
		bundle.putDouble("now", bean.getNowPrice());
		bundle.putDouble("old", bean.getOldPrice());
		intent.putExtras(bundle);
		context.startActivity(intent);
	}

}