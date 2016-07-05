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

package cn.com.dyninfo.o2o.furniture.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.AccountActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.AddressActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.MessagesActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.OrdersActivity;
import cn.com.dyninfo.o2o.furniture.activity.my.ReturnActivity;
import cn.com.dyninfo.o2o.furniture.bean.LocalUser;
import cn.com.dyninfo.o2o.furniture.bean.MyBean;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.widget.RoundImageView;

/**
 * @Description 我的炫品
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-15
 * @update 2014-8-13 18:11:21 新增获取账户资料接口
 *         <hr>
 *         2014-8-13 13:52:15 新增修改账户信息入口
 */
public class MyFragment extends BaseFragment implements OnClickListener {

	public String PAGE_TITLE = "我的炫品";
	private Context context;
	private Handler handler;
	private TextView score, order, msg;
	private RoundImageView head, head_selector;
	private View return_goods, address, account;
	// 模拟数据
	private LocalUser localUser;
	private MyBean myBean;
	private TextView name;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity().getApplicationContext();
		handler = new Handler();
		localUser = BaseActivity.getLocalUserInfoInstance(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.my_main, container, false);
		initView(view);
		return view;
	}

	private void showLocalUser() {
		myBean = new MyBean();
		myBean.setName(localUser.name);
		myBean.setHead(localUser.head);
		myBean.setScore(localUser.score);
		updateUI();
	}

	private void initView(View view) {
		head = (RoundImageView) view.findViewById(R.id.head);
		head_selector = (RoundImageView) view.findViewById(R.id.head_selector);
		head_selector.setOnClickListener(this);
		name = (TextView) view.findViewById(R.id.name);
		// 积分
		score = (TextView) view.findViewById(R.id.score);
		// 订单、消息
		order = (TextView) view.findViewById(R.id.order);
		msg = (TextView) view.findViewById(R.id.msg);
		order.setOnClickListener(this);
		msg.setOnClickListener(this);
		//
		return_goods = view.findViewById(R.id.return_goods);
		return_goods.setOnClickListener(this);
		account = view.findViewById(R.id.account);
		account.setOnClickListener(this);
		address = view.findViewById(R.id.address);
		address.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.head_selector:
			// Tip("点击头像");
			break;
		case R.id.order:
			startActivity(new Intent(context, OrdersActivity.class));
			animLeftToRight();
			break;
		case R.id.msg:
			startActivity(new Intent(context, MessagesActivity.class));
			animLeftToRight();
			break;
		case R.id.return_goods:
			startActivity(new Intent(context, ReturnActivity.class));
			animLeftToRight();
			break;
		case R.id.address:
			startActivity(new Intent(context, AddressActivity.class));
			animLeftToRight();
			break;
		case R.id.account:
			startActivity(new Intent(context, AccountActivity.class));
			animLeftToRight();
			break;
		}
	}

	/** 更新界面 */
	protected void updateUI() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Log_info("用户头像为：" + myBean.getHead());
				bmpUtils_short_holder.display(head, APP.head_path(myBean.getHead()));
				name.setText(myBean.getName());
				score.setText("我的积分：" + myBean.getScore());
			}
		});
	}

	@Override
	public void onResume() {
		BaseActivity.getAccinfo(context);
		showLocalUser();
		super.onResume();
	}

}
