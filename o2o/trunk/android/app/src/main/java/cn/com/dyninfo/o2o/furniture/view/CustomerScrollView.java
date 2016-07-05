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
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * @Description 自定义ScrollView (到尽头时依然可以拉动，仿ios)
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-16 下午4:32:06
 * @update 2014-6-1 15:53:32
 */
public class CustomerScrollView extends ScrollView {

	// 移动回弹比 1/2
	private static final float MOVE_FACTOR = 0.3f;

	// 复位动画时间
	private static final int ANIM_TIME = 300;

	// ScrollView的子View
	private View contentView;

	// 如果按下时不能上拉和下拉， 会在手指移动时更新为当前手指的Y值
	private float startY;

	// 用于记录正常的布局位置
	private Rect originalRect = new Rect();

	// 手指按下时记录是否可以继续下拉
	private boolean canPullDown = false;

	// 手指按下时记录是否可以继续上拉
	private boolean canPullUp = false;

	// 在手指滑动的过程中记录是否移动了布局
	private boolean isMoved = false;

	public CustomerScrollView(Context context) {
		super(context);
	}

	public CustomerScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		if (getChildCount() > 0) {
			contentView = getChildAt(0);
		}
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);

		if (contentView == null)
			return;
		// ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
		originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(), contentView.getBottom());
	}

	/**
	 * 在触摸事件中, 处理上拉和下拉的逻辑
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (contentView == null) {
			return super.dispatchTouchEvent(ev);
		}

		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			canPullDown = isCanPullDown();
			canPullUp = isCanPullUp();
			startY = ev.getY();
			break;

		case MotionEvent.ACTION_UP:
			if (!isMoved)
				break;

			// 开启动画
			TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop(), originalRect.top);
			anim.setDuration(ANIM_TIME);
			contentView.startAnimation(anim);
			// 设置回到正常的布局位置
			contentView.layout(originalRect.left, originalRect.top, originalRect.right, originalRect.bottom);
			// 将标志位设回false
			canPullDown = false;
			canPullUp = false;
			isMoved = false;
			break;

		case MotionEvent.ACTION_MOVE:
			// 在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
			if (!canPullDown && !canPullUp) {
				startY = ev.getY();
				canPullDown = isCanPullDown();
				canPullUp = isCanPullUp();
				break;
			}

			// 计算手指移动的距离
			float nowY = ev.getY();
			int deltaY = (int) (nowY - startY);
			// 是否应该移动布局
			boolean shouldMove = (canPullDown && deltaY > 0) // 可以下拉， 并且手指向下移动
					|| (canPullUp && deltaY < 0) // 可以上拉， 并且手指向上移动
					|| (canPullUp && canPullDown); // 既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）
			if (shouldMove) {
				// 计算偏移量
				int offset = (int) (deltaY * MOVE_FACTOR);
				// 随着手指的移动而移动布局
				contentView.layout(originalRect.left, originalRect.top + offset, originalRect.right,
						originalRect.bottom + offset);
				isMoved = true; // 记录移动了布局
			}
			break;

		default:
			break;
		}

		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 判断是否滚动到顶部
	 */
	private boolean isCanPullDown() {
		return getScrollY() == 0 || contentView.getHeight() < getHeight() + getScrollY();
	}

	/**
	 * 判断是否滚动到底部
	 */
	private boolean isCanPullUp() {
		return contentView.getHeight() <= getHeight() + getScrollY();
	}

}