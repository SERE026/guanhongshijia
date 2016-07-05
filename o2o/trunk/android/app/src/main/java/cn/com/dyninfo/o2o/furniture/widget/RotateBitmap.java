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
/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.widget;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class RotateBitmap {
	public static final String TAG = "RotateBitmap";
	private Bitmap mBitmap;
	private int mRotation;

	public RotateBitmap(Bitmap bitmap) {
		mBitmap = bitmap;
		mRotation = 0;
	}

	public RotateBitmap(Bitmap bitmap, int rotation) {
		mBitmap = bitmap;
		mRotation = rotation % 360;
	}

	public void setRotation(int rotation) {
		mRotation = rotation;
	}

	public int getRotation() {
		return mRotation;
	}

	public Bitmap getBitmap() {
		return mBitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		mBitmap = bitmap;
	}

	public Matrix getRotateMatrix() {
		// By default this is an identity matrix.
		Matrix matrix = new Matrix();
		if (mRotation != 0) {
			// We want to do the rotation at origin, but since the bounding
			// rectangle will be changed after rotation, so the delta values
			// are based on old & new width/height respectively.
			int cx = mBitmap.getWidth() / 2;
			int cy = mBitmap.getHeight() / 2;
			matrix.preTranslate(-cx, -cy);
			matrix.postRotate(mRotation);
			matrix.postTranslate(getWidth() / 2, getHeight() / 2);
		}
		return matrix;
	}

	public boolean isOrientationChanged() {
		return (mRotation / 90) % 2 != 0;
	}

	public int getHeight() {
		if (isOrientationChanged()) {
			return mBitmap.getWidth();
		} else {
			return mBitmap.getHeight();
		}
	}

	public int getWidth() {
		if (isOrientationChanged()) {
			return mBitmap.getHeight();
		} else {
			return mBitmap.getWidth();
		}
	}

	public void recycle() {
		if (mBitmap != null) {
			mBitmap.recycle();
			mBitmap = null;
		}
	}
}
