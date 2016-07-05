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

package cn.com.dyninfo.o2o.furniture.util;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

/**
 * 截屏工具，根据window 截
 * 
 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 */
public class ScreenShot {

	public static Bitmap getScreenShoot(Activity activity) {
		// 需要截图的View
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap full = view.getDrawingCache();

		// 获取状态栏高度
		Rect frame = new Rect();
		view.getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		// 新建一张没有状态栏的图
		Bitmap bmp = Bitmap.createBitmap(full, 0, statusBarHeight, Sys.getScreenWidth(activity),
				Sys.getScreenHeight(activity) - statusBarHeight);
		view.destroyDrawingCache();
		full = null;
		return bmp;
	}

	public static String getScreenShootPath(Activity activity) {
		String path = "";
		try {
			path = APP.saveBmp2SDCard(getScreenShoot(activity), MyDate.getTimestamp() + "");
		} catch (IOException e) {
			APP.exception("截屏保存时异常", e);
		}
		return path;
	}

}
