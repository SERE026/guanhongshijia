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

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONException;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.details.GoodsDetailsActivity;
import cn.com.dyninfo.o2o.furniture.bean.BuyCarBean;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.fragment.CartFragment;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;
import cn.com.dyninfo.o2o.furniture.widget.RoundImageView;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @Description 购物车界面
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-9-3 16:07:36 如果活动商品添加了多件，则强制提交修改为1件
 *       <hr>
 *       2014-8-26 12:06:20 修复活动限购缓存问题
 *       <hr>
 *       2014-7-12 10:08:41 新增活动限购功能
 */
public class CartAdapter extends BaseAdapter {

	private Context context;
	private List<BuyCarBean> list;
	private List<Boolean> checkList;
	private ConfirmDialog dialog;
	private int shu = 0;

	public CartAdapter(Context context, List<BuyCarBean> list) {
		this.context = context;
		this.list = list == null ? new ArrayList<BuyCarBean>() : list;
		initMap();
	}

	private void initMap() {
		checkList = new ArrayList<Boolean>();
		for (int i = 0; i < list.size(); i++)
			checkList.add(i, false);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position).getItem_line_money() * list.get(position).getCount();
	}

	@Override
	public long getItemId(int position) {
		return list.get(position).getGood_id();
	}

	class ItemWrapper {
		LinearLayout item_layout;
		CheckBox checkbox;
		RoundImageView buy_goods_img;
		RelativeLayout buy_car_item_delete;
		TextView buy_goods_name;
		TextView add;
		TextView sub;
		TextView count;
		TextView item_line_moneg;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {

		final ItemWrapper wrapper;

		if (view == null) {
			wrapper = new ItemWrapper();
			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.cart_item, null);

			wrapper.item_layout = (LinearLayout) view.findViewById(R.id.buy_car_item);
			wrapper.checkbox = (CheckBox) view.findViewById(R.id.checkbox);
			wrapper.buy_goods_img = (RoundImageView) view.findViewById(R.id.buy_goods_img);
			wrapper.buy_car_item_delete = (RelativeLayout) view.findViewById(R.id.buy_car_item_delete);
			wrapper.add = (TextView) view.findViewById(R.id.add);
			wrapper.sub = (TextView) view.findViewById(R.id.sub);
			wrapper.count = (TextView) view.findViewById(R.id.count);
			wrapper.buy_goods_name = (TextView) view.findViewById(R.id.buy_goods_name);
			wrapper.item_line_moneg = (TextView) view.findViewById(R.id.item_line_money);

			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}
		// 如果是活动商品，则不支持修改数量
		Boolean isActGoods = false;
		StringBuffer addStr = new StringBuffer();
		if (!list.get(position).getActInfo().equals("|")) {
			wrapper.add.setVisibility(View.INVISIBLE);
			wrapper.sub.setVisibility(View.INVISIBLE);
			addStr.append("活动限购");
			isActGoods = true;
		} else {
			wrapper.add.setVisibility(View.VISIBLE);
			wrapper.sub.setVisibility(View.VISIBLE);
			isActGoods = false;
		}
		addStr.append(list.get(position).getBuyCarName());
		SpannableString actTip = new SpannableString(addStr);
		if (isActGoods) {
			// 粉色
			actTip.setSpan(new ForegroundColorSpan(Color.parseColor("#f50d61")), 0, 4,
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			// 粗体
			actTip.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		// 赋值
		BaseActivity.bmpUtils_short_holder.display(wrapper.buy_goods_img, list.get(position).getBuyCarImg());
		wrapper.buy_goods_name.setText(actTip);
		wrapper.item_line_moneg.setText(list.get(position).getItem_line_money() + " 元 ×");

		if (isActGoods && list.get(position).getCount() > 1) {
			// 设计缺陷导致可活动商品可以同时加多件到购物车，这里强制改为 1 件
			wrapper.count.setText(String.valueOf(1));
			BuyCarBean bean = list.get(position);
			bean.setCount(1);
			CartFragment.list.set(position, bean);
			BaseActivity.cachedPool().execute(new Runnable() {
				@Override
				public void run() {
					BaseActivity.editCartList(context, list.get(position).getCars_box_id(), 1, false);
				}
			});
		} else {
			wrapper.count.setText(String.valueOf(list.get(position).getCount()));
		}

		wrapper.buy_car_item_delete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try {
					dialog = new ConfirmDialog(context, "删除",
							"确定从购物车中删除 " + list.get(position).getBuyCarName() + " 吗？", "删除");
					dialog.setOnDismissListener(new OnDismissListener() {
						@Override
						public void OnConfirmed(Boolean confirmed) {
							if (confirmed) {
								doDel(list.get(position).getCars_box_id());
							}
						}
					});
					dialog.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		shu = list.get(position).getCount();
		if (shu > 1) {
			wrapper.sub.setClickable(true);
			wrapper.add.setClickable(true);
		}
		if (shu == 1) {
			wrapper.sub.setClickable(false);
			wrapper.add.setClickable(true);
		}

		wrapper.add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				shu = Integer.valueOf(wrapper.count.getText().toString().trim());
				System.out.println("------------> 数量：" + shu);
				if (BaseActivity.editCartList(context, list.get(position).getCars_box_id(), ++shu, true)) {
					CartFragment.result += list.get(position).getItem_line_money();
					CartFragment.baycar_result.setText(CartFragment.result + "");
					wrapper.count.setText(String.valueOf(shu));
					BuyCarBean bean = list.get(position);
					bean.setCount(shu);
					CartFragment.list.set(position, bean);
				}
			}
		});

		wrapper.sub.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				shu = Integer.valueOf(wrapper.count.getText().toString().trim());
				System.out.println("------------> 数量：" + shu);
				if (shu > 1) {
					wrapper.sub.setClickable(true);
					if (BaseActivity.editCartList(context, list.get(position).getCars_box_id(), --shu, true)) {
						CartFragment.result -= list.get(position).getItem_line_money();
						CartFragment.baycar_result.setText(CartFragment.result + "");
						wrapper.count.setText(String.valueOf(shu));
						BuyCarBean bean = list.get(position);
						bean.setCount(shu);
						CartFragment.list.set(position, bean);
					}
				}
			}
		});
		// 初始化 checkbox
		try {
			wrapper.checkbox.setChecked(checkList.get(position));
		} catch (Exception e) {
			APP.exception("根据checkList设置选中状态", e);
		}

		wrapper.checkbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				checkList.set(position, !checkList.get(position));
				wrapper.checkbox.setChecked(checkList.get(position));
			}
		});
		// 点击每一项效果和 checkbox 一样
		wrapper.item_layout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				checkList.set(position, !checkList.get(position));
				wrapper.checkbox.setChecked(checkList.get(position));
			}
		});

		// 点击图片时去详情页
		wrapper.buy_goods_img.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent_details = new Intent(context, GoodsDetailsActivity.class);
				Bundle bundle = new Bundle();
				BuyCarBean bean = list.get(position);
				bundle.putInt("id", bean.getGood_id());
				bundle.putString("name", bean.getBuyCarName());
				bundle.putString("img", bean.getBuyCarImg());
				bundle.putInt("actid", 0);
				bundle.putDouble("now", bean.getItem_line_money());
				bundle.putDouble("old", 0);
				intent_details.putExtras(bundle);
				context.startActivity(intent_details);
			}
		});

		return view;
	}

	public List<Boolean> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<Boolean> checkList) {
		this.checkList = checkList;
	}

	public void initCheckList() {
		checkList.clear();
		for (int i = 0; i < list.size(); i++)
			checkList.add(i, false);
	}

	void doDel(final String cartGoodsID) {
		new Thread() {
			public void run() {
				String json = SyncApi.delCartGood(cartGoodsID);
				final JSONObject object = APP.checkReturnData(json, context);
				if (object != null) {
					if (object.has("status")) {

						try {
							if (object.getInt("status") == ErrorCode.SUCCESS) {
								BaseActivity.Tip("删除成功");
								BaseActivity.notifyCartList(context);
							} else if (object.getInt("status") == ErrorCode.ERROR)
								BaseActivity.Tip("删除失败，请重试");
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}else {
					BaseActivity.Tip("删除失败" + APPCode.WEB_NULL);
				}
			};
		}.start();

	}
}
