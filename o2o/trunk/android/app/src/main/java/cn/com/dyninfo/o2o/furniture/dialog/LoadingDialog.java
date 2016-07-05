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

package cn.com.dyninfo.o2o.furniture.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

/**
 * @Description 加载中等待框（纯动画，show即可）
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-22下午4:40:32
 * @update 2014-6-22 17:32:52
 */
public class LoadingDialog extends Dialog {

	private TextView mHtvText;
	private String mText;
	private ImageView load_ico;
	private Context context;

	public LoadingDialog(Context context) {
		super(context, R.style.FullScreenDialog);

		this.context = context;
		// 改动了，提示框不需要文字，布局中已经隐藏
		mText = context.getResources().getString(R.id.load_tip);

		initView();
		initWindow();
		setCancelable(true);
		setCanceledOnTouchOutside(false);
		getWindow().setBackgroundDrawableResource(android.R.color.transparent); // 透明，避免黑色背景框
	}

	private void initWindow() {
		Window window = getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.dimAmount = 0.0f; // 不变暗
		window.setAttributes(lp);
		window.setWindowAnimations(R.style.top_in_top_out);
		onWindowAttributesChanged(lp);
	}

	private void initView() {
		setContentView(R.layout.loading);
		load_ico = (ImageView) findViewById(R.id.load_round);
		Animation load_ring = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
		load_ico.setAnimation(load_ring);
		mHtvText = (TextView) findViewById(R.id.load_tip);
		mHtvText.setText(mText);
	}

	public void setText(String text) {
		mText = text;
		mHtvText.setText(mText);
	}

	@Override
	public void dismiss() {
		try {
			if (isShowing()) {
				super.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
