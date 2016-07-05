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

package cn.com.dyninfo.o2o.furniture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

public class XListViewFooter extends LinearLayout {
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;
	public final static int STATE_NOTDATA = 3;

	private Context mContext;
	private View mContentView;
	private View mProgressBar;
	private TextView mHintView;
	private ImageView Mloading;
	private Animation mLoadingAnimation;
	private TextView mLoadMsg;

	/**
	 * @Description 上拉加载的尾巴
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public XListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	/**
	 * @Description 上拉加载的尾巴
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public XListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public void setState(int state) {
		mHintView.setVisibility(View.INVISIBLE);
		mProgressBar.setVisibility(View.INVISIBLE);
		Mloading.clearAnimation();
		mHintView.setVisibility(View.INVISIBLE);
		if (state == STATE_READY) {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.pull_refresh_footer_hint_ready);
		} else if (state == STATE_NOTDATA) {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.pull_refresh_footer_hint_loading_notdata);
		} else if (state == STATE_LOADING) {
			mProgressBar.setVisibility(View.VISIBLE);
			Mloading.startAnimation(mLoadingAnimation);
			mHintView.setText(R.string.pull_refresh_footer_hint_loading);
		} else {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.pull_refresh_footer_hint_normal);
		}
	}

	public void setBottomMargin(int height) {
		if (height < 0)
			return;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}

	public int getBottomMargin() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView.getLayoutParams();
		return lp.bottomMargin;
	}

	/**
	 * normal status
	 */
	public void normal() {
		mHintView.setVisibility(View.VISIBLE);
		mProgressBar.setVisibility(View.GONE);
		Mloading.clearAnimation();
	}

	public void setMsg(String msg) {
		mLoadMsg.setText(msg);
	}

	/**
	 * loading status
	 */
	public void loading() {
		mHintView.setVisibility(View.GONE);
		mProgressBar.setVisibility(View.VISIBLE);
		Mloading.startAnimation(mLoadingAnimation);
	}

	/**
	 * hide footer when disable pull load more
	 */
	public void hide() {
		mContentView.setVisibility(View.GONE);
	}

	/**
	 * show footer
	 */
	public void show() {
		mContentView.setVisibility(View.VISIBLE);
	}

	private void initView(Context context) {
		mContext = context;
		mLoadingAnimation = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
		LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext)
				.inflate(R.layout.pull_refresh_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		mContentView = moreView.findViewById(R.id.pull_refresh_footer_content);
		mProgressBar = moreView.findViewById(R.id.pull_refresh_footer_progressbar);
		Mloading = (ImageView) moreView.findViewById(R.id.img_xlistview);
		mLoadMsg = (TextView) moreView.findViewById(R.id.tv_xlistview);
		mHintView = (TextView) moreView.findViewById(R.id.pull_refresh_footer_hint_textview);
	}

}