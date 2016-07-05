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
import org.json.JSONObject;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.bean.MessagesBean;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.ErrorCode;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MessagesAdapter extends BaseAdapter {

	private Context context;
	private List<MessagesBean> list;
	private LayoutInflater inflater;

	/**
	 * @Description 消息中心、系统公告adapter
	 * @author ceychen@foxmail.com
	 * @date 2014-5-13 下午2:41:43
	 * @update 2014-5-14 15:33:24
	 */
	public MessagesAdapter(Context context, List<MessagesBean> list) {
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
		return position;
	}

	class ItemWrapper {
		RelativeLayout layout;
		TextView title;
		TextView time;
		TextView txt;
		ImageView ico_del;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final ItemWrapper wrapper;
		if (view == null) {
			wrapper = new ItemWrapper();
			inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.messages_item, null);

			wrapper.layout = (RelativeLayout) view.findViewById(R.id.layout);
			wrapper.title = (TextView) view.findViewById(R.id.title);
			wrapper.time = (TextView) view.findViewById(R.id.time);
			wrapper.txt = (TextView) view.findViewById(R.id.txt);
			wrapper.ico_del = (ImageView) view.findViewById(R.id.ico_del);
			view.setTag(wrapper);
		} else {
			wrapper = (ItemWrapper) view.getTag();
		}

		// wrapper.layout.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// BaseActivity.Tip(list.get(position).getId());
		// }
		// });
		wrapper.ico_del.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String json = SyncApi.delNotices(list.get(position).getId(),
						BaseActivity.getLastLocalUserInfoInstance(context).uid);
				JSONObject object = APP.checkReturnData(json, context);
				if (object != null && object.has("status")) {
					try {
						if (object.getInt("status") == ErrorCode.SUCCESS) {
							// BaseActivity.Tip("删除成功");
							notifyDataSetChanged();
							wrapper.layout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.item_del));
							new Handler().postDelayed(new Runnable() {
								@Override
								public void run() {
									list.remove(position);
									notifyDataSetChanged();
								}
							}, 350);
						} else if (object.getInt("status") == ErrorCode.ERROR) {
							BaseActivity.Tip("删除失败");
						}
					} catch (Exception e) {
						APP.exception("MessagesAdapter", e);
					}
				}

			}
		});
		//
		wrapper.title.setText(list.get(position).getTitle());
		wrapper.time.setText(list.get(position).getTime());
		wrapper.txt.setText(list.get(position).getTxt());

		return view;
	}

}