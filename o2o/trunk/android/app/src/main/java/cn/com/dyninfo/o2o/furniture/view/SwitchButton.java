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

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import cn.com.dyninfo.o2o.furniture.R;


/**
 * @Description 自定义 Switch
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-4 下午4:30:15
 * @update 2014-5-5 17:19:59
 */
@SuppressLint("DrawAllocation")
public class SwitchButton extends View implements OnTouchListener {
	// 当前按钮状态
	private boolean checked = false;
	// 用户是否在滑动
	private boolean onSlip = false;
	// 按下时的X，当时的X
	private float downX, nowX;
	// 打开和关闭状态下的，游标的Rect
	private Rect btn_On, btn_Off;

	private boolean isChgLsnOn = false;
	private OnChangedListener ChgLsn;

	private Bitmap bg_on, bg_off, slip_btn;

	public SwitchButton(Context context) {
		super(context);
		init();
	}

	public SwitchButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SwitchButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		bg_on = BitmapFactory.decodeResource(getResources(),
				R.drawable.switch_on);
		bg_off = BitmapFactory.decodeResource(getResources(),
				R.drawable.switch_off);
		slip_btn = BitmapFactory.decodeResource(getResources(),
				R.drawable.switch_point);
		int tmp = bg_off.getWidth() / 2;
		btn_On = new Rect(tmp, 0, slip_btn.getWidth() + tmp,
				slip_btn.getHeight());
		btn_Off = new Rect(bg_off.getWidth() - tmp - slip_btn.getWidth(), 0,
				bg_off.getWidth() - tmp, slip_btn.getHeight());
		setOnTouchListener(this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Matrix matrix = new Matrix();
		Paint paint = new Paint();
		float x;
		if (onSlip) {
			if (nowX >= bg_on.getWidth()) {
				x = bg_on.getWidth() - slip_btn.getWidth() / 2;
			} else {
				x = nowX - slip_btn.getWidth() / 2;
			}
		} else {
			if (checked) {
				x = btn_On.left;
			} else {
				x = btn_Off.left;
			}
		}
		if (nowX < (bg_on.getWidth() / 2)) {
			canvas.drawBitmap(bg_off, matrix, paint);
		} else {
			canvas.drawBitmap(bg_on, matrix, paint);
		}
		if (x < 0) {
			x = 0;
		} else if (x > bg_on.getWidth() - slip_btn.getWidth()) {
			x = bg_on.getWidth() - slip_btn.getWidth();
		}
		canvas.drawBitmap(slip_btn, x, 0, paint);
	}

	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			nowX = event.getX();
			break;
		case MotionEvent.ACTION_DOWN:
			if (event.getX() > bg_on.getWidth()
					|| event.getY() > bg_on.getHeight()) {
				return false;
			}
			onSlip = true;
			downX = event.getX();
			nowX = downX;
			break;
		case MotionEvent.ACTION_UP:
			onSlip = false;
			boolean lastChoose = checked;
			if (event.getX() >= (bg_on.getWidth() / 2)) {
				checked = true;
			} else {
				checked = false;
			}
			if (isChgLsnOn && (lastChoose != checked)) {
				ChgLsn.OnChanged(checked);
			}
			break;
		default:
			break;
		}
		invalidate();
		return true;
	}

	public void setOnChangeListener(OnChangedListener l) {
		isChgLsnOn = true;
		ChgLsn = l;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
		if (checked) {
			nowX = btn_On.left;
		} else {
			nowX = btn_Off.left;
		}
		invalidate();
	}

	// OnChangedListener代码如下
	public interface OnChangedListener {
		abstract void OnChanged(boolean checkState);
	}

}