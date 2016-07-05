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

package cn.com.dyninfo.o2o.furniture.widget;

import java.io.IOException;

import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ImageFilterCropActivity extends BaseActivity {
	private String PAGE_TITLE = "编辑图片";
	private ImageView mCancel;
	private Button mConfirm;
	private CropImageView mDisplay;
	private ProgressBar mProgressBar;
	private TextView mLeft, mRight;

	public static final int SHOW_PROGRESS = 0;
	public static final int REMOVE_PROGRESS = 1;

	private String mPath;
	private Bitmap mBitmap;
	private CropImage mCropImage;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cut);
		addToActManager(this);
		initView();
		initClick();
		initBundle();
	}

	private void initBundle() {
		mPath = getIntent().getStringExtra("path");
		try {
			mBitmap = APP.saveBmp2SDByPath(mPath, Sys.getScreenWidth(context), Sys.getScreenHeight(context));
			if (mBitmap == null) {
				Tip("选择图片失败");
				setResult(RESULT_CANCELED);
				finish();
			} else {
				resetImageView(mBitmap);
			}
		} catch (Exception e) {
			APP.exception("获取要裁剪的图片", e);
			Tip("选择的图片有误");
			setResult(RESULT_CANCELED);
			finish();
		}
	}

	private void initView() {
		((TextView) findViewById(R.id.title)).setText(PAGE_TITLE);
		mCancel = (ImageView) findViewById(R.id.back);
		mConfirm = (Button) findViewById(R.id.top_btn_2);
		mConfirm.setBackgroundResource(R.drawable.corner_round_bg_normal_fenbai);
		mConfirm.setVisibility(View.VISIBLE);
		mConfirm.setText("完成");
		int pd = Sys.Dp2Px(context, 4);
		mConfirm.setPadding(pd, pd / 2, pd, pd / 2);
		mDisplay = (CropImageView) findViewById(R.id.imagefilter_crop_display);
		mProgressBar = (ProgressBar) findViewById(R.id.imagefilter_crop_progressbar);
		mLeft = (TextView) findViewById(R.id.imagefilter_crop_left);
		mRight = (TextView) findViewById(R.id.imagefilter_crop_right);
	}

	private void initClick() {
		mCancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				myfinish();
			}
		});
		mConfirm.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String imgPath = APP.getPicCutPath();
				BaseActivity.Log_info("-------------> 即将保存图片到：" + imgPath);
				try {
					Bitmap bmp = mCropImage.cropAndSave();
					APP.saveBmp2SDPath(bmp, imgPath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Intent intent = new Intent();
				if (imgPath != null) {
					intent.putExtra("path", imgPath);
				}
				setResult(RESULT_OK, intent);
				BaseActivity.Log_info("-------------> mConfirm.Click 即将关闭页面");
				myfinish();
			}
		});
		mLeft.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mCropImage.startRotate(270.f);
			}
		});
		mRight.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mCropImage.startRotate(90.f);
			}
		});
	}

	private void resetImageView(Bitmap b) {
		mDisplay.clear();
		mDisplay.setImageBitmap(b);
		mDisplay.setImageBitmapResetBase(b, true);
		mCropImage = new CropImage(this, mDisplay, handler);
		mCropImage.crop(b);
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_PROGRESS:
				mProgressBar.setVisibility(View.VISIBLE);
				break;
			case REMOVE_PROGRESS:
				handler.removeMessages(SHOW_PROGRESS);
				mProgressBar.setVisibility(View.INVISIBLE);
				break;
			}
		}
	};

}
