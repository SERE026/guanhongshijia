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
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

/**
 * @Description 带删除按钮的输入框<br>
 * <br>
 *              <B>使用时推荐添加如下属性：</b><br>
 *              <em>
 * background ：输入框边框<br>
 * drawableLeft ：放大镜图片<br>
 * drawableRight：删除按钮</em>
 * 
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-6 15:25:59
 */
public class ClearEditText extends EditText implements OnFocusChangeListener, TextWatcher {
	/**
	 * 删除按钮的图片资源
	 */
	private Drawable mClearDrawable;

	/**
	 * @Description 带删除按钮的输入框<br>
	 * <br>
	 *              <B>使用时推荐添加如下属性：</b><br>
	 *              <em>
	 * background ：输入框边框<br>
	 * drawableLeft ：放大镜图片<br>
	 * drawableRight：删除按钮</em>
	 * 
	 * @<a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-6 15:25:59
	 */
	public ClearEditText(Context context) {
		this(context, null);
	}

	public ClearEditText(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.editTextStyle);
	}

	public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		// 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
		mClearDrawable = getCompoundDrawables()[2];
		if (mClearDrawable == null) {
			mClearDrawable = getResources().getDrawable(R.drawable.del_x_btn);
		}
		mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
		setClearIconVisible(false);
		setOnFocusChangeListener(this);
		addTextChangedListener(this);
	}

	/**
	 * 当按下的位置 在 EditText的宽度 -图标到控件右边的间距 - 图标的宽度 和 EditText的宽度 -
	 * 图标到控件右边的间距之间就算点击了图标
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (getCompoundDrawables()[2] != null) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				boolean touchable = event.getX() > (getWidth() - getPaddingRight() - mClearDrawable.getIntrinsicWidth())
						&& (event.getX() < ((getWidth() - getPaddingRight())));
				if (touchable) {
					this.setText("");
				}
			}
		}

		return super.onTouchEvent(event);
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if (hasFocus) {
			setClearIconVisible(getText().length() > 0);
		} else {
			setClearIconVisible(false);
		}
	}

	protected void setClearIconVisible(boolean visible) {
		Drawable right = visible ? mClearDrawable : null;
		setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int count, int after) {
		setClearIconVisible(s.length() > 0);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	public void setShakeAnimation() {
		this.setAnimation(BaseActivity.shakeAnim(5));
	}



}
