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
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.AddressBean;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

/**
 * @Description 收货地址 adapter
 * @author ceychen@foxmail.com
 * @date 2014-5-8 下午2:11:48
 * @update 2014-8-7 10:45:16 开线程去执行删除
 */
public class AddressAdapter extends BaseAdapter {

	private Context context;
	private List<AddressBean> list;
	private LayoutInflater inflater;
	private Handler handler;

	public AddressAdapter(Context context, List<AddressBean> list) {
		this.context = context;
		this.list = list == null ? new ArrayList<AddressBean>() : list;
		handler = new Handler();
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
		RelativeLayout item_layout;
		TextView addr;
		TextView name;
		TextView tel;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.address_item, null);

			wrapper.item_layout = (RelativeLayout) view.findViewById(R.id.address_item_layout);
			wrapper.addr = (TextView) view.findViewById(R.id.addr);
			wrapper.name = (TextView) view.findViewById(R.id.name);
			wrapper.tel = (TextView) view.findViewById(R.id.phone);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		final AddressBean bean = list.get(position);
		if (getCount() > 1) {
			if (position == 0) {
				wrapper.item_layout.setBackgroundResource(R.drawable.corner_round_bg_normal_top);
			} else if (position == getCount() - 1) {
				wrapper.item_layout.setBackgroundResource(R.drawable.corner_round_bg_normal_bottom);
			} else {
				wrapper.item_layout.setBackgroundResource(R.drawable.corner_round_bg_normal_center_right_angle);
			}
		} else {
			wrapper.item_layout.setBackgroundResource(R.drawable.corner_round_bg_normal);
		}

		wrapper.addr.setText(bean.getProvince() + " - " + bean.getCity()
				+ (bean.getArea().length() == 0 ? "   " : (" - " + bean.getArea() + "   ")) + bean.getStreet());
		wrapper.name.setText(bean.getName());
		wrapper.tel.setText(bean.getPhone());

		wrapper.item_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("cn.com.dyninfo.o2o.furniture.activity.my.AddressActivity#click");
				intent.putExtra("position", position);
				context.sendBroadcast(intent);
			}
		});
		wrapper.item_layout.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				ConfirmDialog dialog;
				if (getCount() == 1) {
					dialog = new ConfirmDialog(context, "删除地址", "这是最后一条收货地址，确定要删除吗？", "删除");
				} else {
					dialog = new ConfirmDialog(context, "删除地址", "确定要删除这个收货地址吗？", "删除");
				}
				dialog.setOnDismissListener(new OnDismissListener() {
					@Override
					public void OnConfirmed(Boolean confirmed) {
						if (confirmed) {
							new Thread() {
								public void run() {

									String json = SyncApi.delAddress(list.get(position).getId());
									JSONObject object = APP.checkReturnData(json, context);
									if (object != null && object.has("status")) {
										try {
											if (object.getInt("status") == ErrorCode.SUCCESS) {
												BaseActivity.Tip("删除成功");
												handler.post(new Runnable() {
													@Override
													public void run() {
														notifyDataSetChanged();
														wrapper.item_layout.setAnimation(AnimationUtils.loadAnimation(
																context, R.anim.item_del));
													}
												});
												// 动画
												handler.postDelayed(new Runnable() {
													@Override
													public void run() {
														list.remove(position);
														notifyDataSetChanged();
													}
												}, 350);
											} else if (object.getInt("status") == ErrorCode.ERROR) {
												BaseActivity.Tip("删除失败，请重试");
											}
										} catch (Exception e) {
											APP.exception("删除收货地址", e);
										}
									}

								};
							}.start();
						}
					}
				});
				dialog.show();
				return false;
			}
		});

		return view;
	}

}