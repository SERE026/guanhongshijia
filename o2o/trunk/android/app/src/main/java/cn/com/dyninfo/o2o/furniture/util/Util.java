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

import java.io.File;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

/**
 * @Description 主要是一些目录的创建
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-7-8 13:46:31 新增检测更新时路径
 */
public class Util extends Application {
	private static Util util;
	private static Context context;
	public static int databaseversion = 1;
	public File XuanPinPath;
	public static String APP_DATA_ROOT_PATH;
	public static String IMG_SAVE_PATH;
	public static String IMG_SHARE_PATH;
	public static String APK_INSTALL_PATH;
	public static String APK_LOG_PATH;
	public static String IMG_SAVE_PATH_CAP_TEMP;
	public static String IMG_SAVE_PATH_CAP_CUT;
	public static String IMG_CACHE_XUTILS_SDCARD_PATH;
	public static String IMG_CACHE_XUTILS_DEFAULT_PATH;
	public static String FINAL_IMAGE_PATH;
	public static String FINAL_TEMP_PATH;
	public static String SDPATH;

	public File ImgCachePath;
	public File ImgSavePath;
	public File ImgSharePath;
	public File ApkSavePath;
	public File LogSavePath;
	public File ImgCapTempPath;
	public File ImgCapCutPath;
	public File ImgCacheDefaultPath;

	@Override
	public void onCreate() {
		super.onCreate();
		util = this;
		init_path();

	}

	public String getAppPath() {
		return context.getFilesDir().getParent() + "/";
	}

	public void init_path() {
		Log.e("Util", "checking folder ...");
		if (Sys.isSDcardExist()) {
			SDPATH = Environment.getExternalStorageDirectory() + "/";
			IMG_SAVE_PATH = SDPATH + "XuanPin/images/save";
			IMG_SHARE_PATH = SDPATH + "XuanPin/images/share";
			APK_INSTALL_PATH = SDPATH + "XuanPin/app/";
			APK_LOG_PATH = SDPATH + "XuanPin/log/";
			IMG_SAVE_PATH_CAP_TEMP = SDPATH + "XuanPin/images/save/capture/xuanpin_temp";
			IMG_SAVE_PATH_CAP_CUT = SDPATH + "XuanPin/images/save/capture/xuanpin_cut";
			IMG_CACHE_XUTILS_SDCARD_PATH = SDPATH + "XuanPin/images/cache/";
			IMG_CACHE_XUTILS_DEFAULT_PATH = SDPATH + "Android/data/" + context.getPackageName() + "/cache/imgCache/";
			APP_DATA_ROOT_PATH = getAppPath() + "XuanPin/";

			Log.i(Var.info, "FINAL_DATA_ROOT_PATH = " + APP_DATA_ROOT_PATH);
			Log.i(Var.info, "IMG_CACHE_XUTILS_DEFAULT_PATH = " + IMG_CACHE_XUTILS_DEFAULT_PATH);

			FINAL_IMAGE_PATH = APP_DATA_ROOT_PATH + "images/";
			FINAL_TEMP_PATH = APP_DATA_ROOT_PATH + "temp/";

			XuanPinPath = new File(APP_DATA_ROOT_PATH);
			if (!XuanPinPath.exists()) {
				XuanPinPath.mkdirs();
			}
			XuanPinPath = new File(FINAL_IMAGE_PATH);
			if (!XuanPinPath.exists()) {
				XuanPinPath.mkdirs();
			}

			XuanPinPath = new File(FINAL_TEMP_PATH);
			if (!XuanPinPath.exists()) {
				XuanPinPath.mkdirs();
			}

			// 拍照图片保存地址
			ImgCapTempPath = new File(IMG_SAVE_PATH_CAP_TEMP);
			if (!ImgCapTempPath.exists()) {
				ImgCapTempPath.mkdirs();
			}
			// 裁剪后图片保存地址
			ImgCapCutPath = new File(IMG_SAVE_PATH_CAP_CUT);
			if (!ImgCapCutPath.exists()) {
				ImgCapCutPath.mkdirs();
			}
			// 图片保存、缓存地址
			ImgSavePath = new File(IMG_SAVE_PATH);
			if (!ImgSavePath.exists()) {
				ImgSavePath.mkdirs();
			}
			// 分享图片的临时保存路径
			ImgSharePath = new File(IMG_SHARE_PATH);
			if (!ImgSharePath.exists()) {
				ImgSharePath.mkdirs();
			}
			// 检测更新时保存路径
			ApkSavePath = new File(APK_INSTALL_PATH);
			if (!ApkSavePath.exists()) {
				ApkSavePath.mkdirs();
			}
			// 异常保存路径
			LogSavePath = new File(APK_LOG_PATH);
			if (!LogSavePath.exists()) {
				LogSavePath.mkdirs();
			}
			ImgCachePath = new File(IMG_CACHE_XUTILS_SDCARD_PATH);
			if (!ImgCachePath.exists()) {
				ImgCachePath.mkdirs();
			}
			ImgCacheDefaultPath = new File(IMG_CACHE_XUTILS_DEFAULT_PATH);
			if (!ImgCacheDefaultPath.exists()) {
				ImgCacheDefaultPath.mkdirs();
			}

		} else {
			Log.e("Util", " SD Card does not exist ...");
			BaseActivity.Tip("请插入外置存储卡");
		}

	}

	public static Util getInstance(Context context) {
		Util.context = context;
		if (util == null) {
			synchronized (Util.class) {
				if (util == null)
					util = new Util();
			}
		}
		return util;
	}

}
