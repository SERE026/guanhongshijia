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

package cn.com.dyninfo.o2o.furniture.share;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cn.com.dyninfo.o2o.furniture.R;
import cn.sharesdk.framework.ShareSDK;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.share.tools.OnekeyShare;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.Constant;
import cn.com.dyninfo.o2o.furniture.util.MyDate;
import cn.com.dyninfo.o2o.furniture.util.Util;

/**
 * @Description 分享到微博、腾讯微博、微信
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-6-22 上午11:46:09
 * @update 2014-9-2 16:49:00 支持截屏后分享
 *         <hr>
 *         2014-7-18 17:52:29 分享到微信，优化分享链接方法，避免404
 *         <hr>
 *         2014-7-4 15:07:48 优先选择本地图片缓存进行分享，如果不存在，则分享网络图片
 */
public class Share extends BaseActivity {

	private String tag = " Share ";
	private Context context;

	public Share(Context context) {
		this.context = context;
	}

	/**
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @param txt
	 *            文本
	 * @param pic
	 *            网络图片绝对地址
	 */
	public void doit(String txt, String url, final String pic) {
		BaseActivity.Log_info("分享的图片路径是：" + pic);
		ShareSDK.initSDK(context);
		OnekeyShare oks = new OnekeyShare();
		// oks.setEditPageBackground( );

		oks.setLatitude((float) Constant.lat);
		oks.setLongitude((float) Constant.lng);
		// 直接分享，不需要编辑页面
		oks.setSilent(true);
		// 关闭sso授权
		// oks.disableSSOWhenAuthorize();

		oks.setNotification(R.drawable.xuan_logo, "分享中....");
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle("分享");
		// 标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://www.xpzc.com");
		// 分享此内容的网站名称，仅在QQ空间使用
		oks.setSite(context.getResources().getString(R.string.app_name));
		// 分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://www.xpzc.com");

		oks.setText(txt + "@炫品妆成 ");
		final String time = String.valueOf(MyDate.getTimestamp());
		String path = "";
		Bitmap bmp = null;
		// 这里判断本地磁盘缓存中是否有商品图片，如果有则取本地，否则取网络上的
		File file = null;

		if (APP.checkUrl(pic))
			file = bmpUtils_short_holder.getBitmapFileFromDiskCache(pic);
		else
			file = new File(pic);

		if (file == null) {
			if (APP.checkUrl(pic))
				bmp = APP.getBmpFromUrl(context, pic);
		} else {
			InputStream input = null;
			try {
				// 存在于SD card 目录
				input = new FileInputStream(file.getAbsolutePath());
			} catch (Exception e) {
				BaseActivity.Log_info("不存在于 XuanPin 目录，正在检查 Data 目录");
				try {
					// 存在于SD android/data/ 目录
					input = new FileInputStream(Util.IMG_CACHE_XUTILS_DEFAULT_PATH + file.getName());
					BaseActivity.Log_info("Data 目录下找到该缓存图片，即将解析图片");
				} catch (FileNotFoundException e1) {
					BaseActivity.Log_info("Data 目录下没有该图片的缓存");
					// APP.exception("Data 目录下没有该图片的缓存", e1);
				}
			}
			bmp = BitmapFactory.decodeStream(input);
		}
		if (bmp == null) {
			BaseActivity.Log_info("需要分享的图片为空");
		} else {
			try {
				path = APP.saveBmp2SDCard(bmp, time);
			} catch (IOException e) {
				APP.exception("分享时将bmp存到sdcard", e);
			}
		}
		BaseActivity.Log_info("需要分享的图片设置成功，即将开始分享：" + path);
		oks.setImagePath(path);
		// url仅在微信（包括好友和朋友圈）中使用
		try {
			oks.setUrl(new URL(url).toString());
		} catch (MalformedURLException e) {
			oks.setUrl(APP.host);
			APP.exception(tag, e);
		}

		// 启动分享
		oks.show(context);

	}
}
