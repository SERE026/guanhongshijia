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

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class CustomerViewPager extends ViewPager {

	private int mTouchSlop;
	private float mLastMotionX;
	private float mLastMotionY;
	/** 是否能够左右滑动 */
	private boolean isMoveToDetails = true;

	public CustomerViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		final ViewConfiguration configuration = ViewConfiguration.get(getContext());
		mTouchSlop = configuration.getScaledTouchSlop();
		System.out.println("-------> mTouchSlop = " + mTouchSlop);
	}

	/**
	 * @Description 试图解决slideViewpager 在部分手机上不能滑动的问题
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-29 上午11:08:36
	 */
	public CustomerViewPager(Context context) {
		this(context, null);
	}

	public void setMoveToDetails(boolean isMoveToDetails) {
		this.isMoveToDetails = isMoveToDetails;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		try {
			final float x = ev.getX(0);
			final float y = ev.getY(0);
			switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				mLastMotionX = x;
				mLastMotionY = y;
				break;

			case MotionEvent.ACTION_MOVE:
				int xDiff = (int) Math.abs(x - mLastMotionX);
				int yDiff = (int) Math.abs(y - mLastMotionY);
				final int x_yDiff = xDiff * xDiff + yDiff * yDiff;
				boolean xMoved = x_yDiff > mTouchSlop * mTouchSlop;
				System.out.println("---> xDiff = " + xDiff + " ，yDiff = " + yDiff);
				if (xMoved) {
					if (xDiff > yDiff) {
						System.out.println("-------------> viewpager onInterceptTouchEvent ：true");
						BaseActivity.Tip("viewpager true");
						return true;
					} else {
						System.out.println("-------------> viewpager onInterceptTouchEvent ：false");
						BaseActivity.Tip("viewpager false");
						return false;
					}
				}
				break;

			default:
				break;
			}
			return super.onInterceptTouchEvent(ev);
		} catch (IllegalArgumentException ex) {
		}
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		if (!isMoveToDetails)
			return false;
		try {
			return super.onTouchEvent(ev);
		} catch (IllegalArgumentException ex) {
		}

		return false;
	}

}
