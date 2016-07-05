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
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;

/**
 * @Description 贴在右侧的字母表快速查询bar
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-6 下午3:49:44
 * @update 2014-5-6 18:04:01
 */
public class SideFastQueryBar extends View {
	private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	// 26个字母 ，由于是省市，里面没有非拼音的 ，所以不需要："#"
	public static String[] PY = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private int choose = -1;
	private Paint paint = new Paint();

	private TextView mTextDialog;

	public void setTextView(TextView mTextDialog) {
		this.mTextDialog = mTextDialog;
	}

	public SideFastQueryBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SideFastQueryBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SideFastQueryBar(Context context) {
		super(context);
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 获取焦点改变背景颜色
		int height = getHeight();
		int width = getWidth();
		int singleHeight = height / PY.length;// 每个字母的高度
		for (int i = 0; i < PY.length; i++) {
			paint.setColor(getResources().getColor(R.color.pink_lite)); // 浅粉色
			paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setAntiAlias(true);
			paint.setTextSize(20);
			if (i == choose) {
				paint.setColor(getResources().getColor(R.color.white)); // 白色
				paint.setFakeBoldText(true);
			}
			// x坐标等于中间-字符串宽度的一半.
			float xPos = width / 2 - paint.measureText(PY[i]) / 2;
			float yPos = singleHeight * i + singleHeight;
			canvas.drawText(PY[i], xPos, yPos, paint);
			paint.reset();
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		final int action = event.getAction();
		final float y = event.getY();
		final int oldChoose = choose;
		final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
		final int c = (int) (y / getHeight() * PY.length);// 点击y坐标所占总高度的比例*b数组的长度等于点击b中的个数

		switch (action) {
		case MotionEvent.ACTION_UP:
			setBackgroundDrawable(new ColorDrawable(0x00000000));
			choose = -1;//
			invalidate();
			if (mTextDialog != null) {
				mTextDialog.setVisibility(View.INVISIBLE);
			}
			break;

		default:
			setBackgroundResource(R.drawable.corner_round_bg_fill_pink_stroke_gray_white);
			if (oldChoose != c) {
				if (c >= 0 && c < PY.length) {
					if (listener != null) {
						listener.onTouchingLetterChanged(PY[c]);
					}
					if (mTextDialog != null) {
						mTextDialog.setText(PY[c]);
						mTextDialog.setVisibility(View.VISIBLE);
					}
					choose = c;
					invalidate();
				}
			}
			break;
		}
		return true;
	}

	public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
		this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	public interface OnTouchingLetterChangedListener {
		public void onTouchingLetterChanged(String s);
	}

}