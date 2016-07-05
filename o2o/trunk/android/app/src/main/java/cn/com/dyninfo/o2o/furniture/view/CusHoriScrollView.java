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
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * @Description 自定义水平 ScrollView
 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
 *          2014-9-17 上午9:37:10
 */
public class CusHoriScrollView extends HorizontalScrollView {
	public CusHoriScrollView(Context context) {
		super(context);
	}

	public CusHoriScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public CusHoriScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		View view = (View) getChildAt(getChildCount() - 1);
		// 如果为0，证明滑动到最左边
		if (view.getLeft() - getScrollX() == 0) {
			onScrollListener.onLeft();
			// 如果为0证明滑动到最右边
		} else if ((view.getRight() - (getWidth() + getScrollX())) == 0) {
			onScrollListener.onRight();
			// 说明在中间
		} else {
			onScrollListener.onScroll();
		}
		super.onScrollChanged(l, t, oldl, oldt);
	}

	/**
	 * 定义接口
	 * 
	 * @author admin
	 */
	public interface OnScrollListener {
		void onRight();

		void onLeft();

		void onScroll();
	}

	private OnScrollListener onScrollListener = new OnScrollListener() {
		
		@Override
		public void onScroll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onRight() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLeft() {
			// TODO Auto-generated method stub
			
		}
	};

	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}
}
