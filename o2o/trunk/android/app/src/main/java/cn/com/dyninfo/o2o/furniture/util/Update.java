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
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog;
import cn.com.dyninfo.o2o.furniture.dialog.ConfirmDialog.OnDismissListener;
import cn.com.dyninfo.o2o.furniture.net.SyncApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.webkit.URLUtil;

/**
 * @Description 自动更新
 *              <hr>
 *              1.通过Url检测更新 2.下载并安装更新 3.删除临时路径
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014年7月8日 上午11:14:39
 * @update 2014-9-11 09:58:24 修正下载速度太快时偶尔出现的进度超过100%的情况
 *         <hr>
 *         2014-7-18 10:56:41 新增升级说明
 *         <hr>
 *         2014-7-11 10:34:14 更新解析服务，有新版本时显示小圆点
 */
public class Update {
	// 调用更新的Activity
	public Context context = null;
	private Handler handler;
	// 当前版本号
	public int versionCode = 0;
	// 当前版本名称
	public String versionName = "";
	// 控制台信息标识
	private static final String TAG = "Update";
	// 文件当前路径
	private String currentFilePath = "";
	// 安装包文件临时路径
	private String currentTempFilePath = "";
	// 获得文件扩展名字符串
	private String fileEx = "";
	// 获得文件名字符串
	private String fileNa = "";
	// 服务器地址，2014-7-8 11:53:10
	private String strURL = "http://www.xpzc.com/upload/phoneAPK/Dress.apk";
	// 签名存在冲突 2014-7-8 11:53:10
	// private String strURL = "http://192.168.1.109:8080/android/Dress.apk";

	/** 总文件大小 **/
	private double FILE_SIZE = 0;
	private ProgressDialog dialog;
	/** 下载百分比 **/
	private Double size;
	private NumArithmetic numArithmetic;
	/** 更新说明 */
	private StringBuffer desc = new StringBuffer();

	/**
	 * 构造方法，获得当前版本信息
	 * 
	 * @param activity
	 */
	public Update(Context context) {
		this.context = context;
		numArithmetic = new NumArithmetic();
		try {
			// 删除上一次下载的版本
			Sys.deleteAllFilesOfDir(Util.APK_INSTALL_PATH, false);
		} catch (Exception e) {
			APP.exception("更新删除历史版本", e);
		}
		// 获得当前版本
		getCurrentVersion();
		handler = new Handler();
	}

	/**
	 * 检测更新（有更新时弹窗，否则无操作）
	 * 
	 * @date 2014-7-16 15:31:35
	 * @update 2014-8-8 16:45:07 by <a
	 *         href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 */
	public void check(final Boolean showDialog, final Boolean showTips) {
		new Thread() {
			public void run() {
				String verCode = SyncApi.getVer() + " ";// 最后增加个空格，服务器返回的格式是：版本号-安装包大小-说明，避免说明为空时报错
				// // 13-8041126-新增微信分享链接给好友\n优化微博分享\n修复不能检测更新的问题
				// // 弹出对话框，选择是否需要更新版本
				// String verCode = SyncApi.getVer() + " ";//
				// 添加空格，避免没有填写更新说明时无法继续
				String[] verInfo = verCode.split("-");
				if (verInfo.length != 3) {
					// if (showDialog)
					// BaseActivity.Tip("检测更新失败，请稍后重试");
					return;
				}
				desc.setLength(0);// 最高效率清空它
				try {
					desc.append(verInfo[2]);
					FILE_SIZE = Double.valueOf(verInfo[1]);
					if (versionCode < Integer.valueOf(verInfo[0])) {
						// 通知账户管理页面 版本更新一栏 显示个小圆点
						Intent intent = new Intent();
						intent.setAction("cn.com.dyninfo.o2o.furniture.activity.AccountActivity#showVerDot");
						context.sendBroadcast(intent);
						if (showDialog) {
							handler.post(new Runnable() {
								@Override
								public void run() {
									showUpdateDialog();
								}
							});
						}
					} else {
						if (showDialog && showTips)
							BaseActivity.Tip("当前已是最新版本");
					}
				} catch (Exception e) {
					APP.exception("Update check 时出错，可能是乱码", e);
				}
			};
		}.start();
	}

	/**
	 * 检测是否有可用网络
	 * 
	 * @param context
	 * @return 网络连接状态
	 */
	public static boolean isNetworkAvailable(Context context) {
		try {
			ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			// 获取网络信息
			NetworkInfo info = cm.getActiveNetworkInfo();
			// 返回检测的网络状态
			return (info != null && info.isConnected());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 弹出对话框，选择是否需要更新版本
	 */
	public void showUpdateDialog() {
		ConfirmDialog dialog = new ConfirmDialog(context, "可用更新", "发现新版本，共 "
				+ numArithmetic.div(FILE_SIZE, Double.valueOf(1024 * 1024), 2) + " M，需要现在更新吗？\n" + desc, "更新");
		dialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void OnConfirmed(Boolean confirmed) {
				if (confirmed) {
					// 通过地址下载文件
					downloadTheFile(strURL);
					// 显示更新状态，进度条
					showWaitDialog();
				}
				// else {
				// BaseActivity.Tip("如需更新请到 [我的炫品-账号管理] 页面操作");
				// }
			}
		});
		dialog.show();
	}

	/**
	 * 显示更新状态，进度条
	 */
	public void showWaitDialog() {
		dialog = new ProgressDialog(context);
		dialog.setMessage("正在连接服务器");
		dialog.setIndeterminate(true);
		dialog.setCancelable(true);
		dialog.show();
	}

	/**
	 * 获得当前版本信息
	 */
	public void getCurrentVersion() {
		try {
			// 获取应用包信息
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			this.versionCode = info.versionCode;
			this.versionName = info.versionName;
			BaseActivity.Log_info("----------> 当前版本名称：" + this.versionName + "，版本号：" + this.versionCode);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 截取文件名称并执行下载
	 * 
	 * @param strPath
	 */
	private void downloadTheFile(final String strPath) {
		// 获得文件文件扩展名字符串
		fileEx = strURL.substring(strURL.lastIndexOf(".") + 1, strURL.length()).toLowerCase();
		// 获得文件文件名字符串
		fileNa = strURL.substring(strURL.lastIndexOf("/") + 1, strURL.lastIndexOf("."));
		try {
			if (strPath.equals(currentFilePath)) {
				doDownloadTheFile(strPath);
			}
			currentFilePath = strPath;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// 执行下载
						doDownloadTheFile(strPath);
					} catch (Exception e) {
						Log.e(TAG, e.getMessage(), e);
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行新版本进行下载，并安装
	 * 
	 * @param strPath
	 * @throws Exception
	 */
	private void doDownloadTheFile(String strPath) throws Exception {
		// 判断strPath是否为网络地址
		if (!URLUtil.isNetworkUrl(strPath)) {
			BaseActivity.Log_info(" ----->下载失败，地址有误");
		} else {
			URL myURL = new URL(strPath);
			URLConnection conn = myURL.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			if (is == null) {
				throw new RuntimeException("stream is null");
			}
			// 生成一个临时文件
			// final File myTempFile = File.createTempFile(fileNa, "." +
			// fileEx);
			// 备注：使用File.createTempFile方法下载的文件，在不同android系统下文件的存储位置不同。
			// 在android1.6、android2.2、android2.3.x系统下，用File.createTempFile方法创建的文件会存放到sd卡上；在android
			// 4.1.1系统下，则会将临时文件存放到/data/data/应用包名/cache目录下，而这个目录仅对本应用程序有读写权限，所以当程序下载成功后发送意图（Intent）给系统安装时，系统安装程序没有访问该文件的权限，于是系统就会打印“
			// Permission denied ”的log，弹出“解析包时出现错误”。

			// 安装包文件临时路径
			final File myTempFile = new File(Util.APK_INSTALL_PATH + "/xuan.apk");
			currentTempFilePath = myTempFile.getAbsolutePath();
			FileOutputStream fos = new FileOutputStream(myTempFile);
			byte buf[] = new byte[1024];
			do {
				final int lenght = is.read(buf);
				if (lenght <= 0) {
					break;
				}
				fos.write(buf, 0, lenght);
				NumArithmetic numArithmetic = new NumArithmetic();
				size = numArithmetic.div(Double.valueOf(String.valueOf(myTempFile.length())), FILE_SIZE, 2);
				handler.post(updateLenght);
			} while (true);

			dialog.cancel();
			dialog.dismiss();
			// 打开文件
			openFile(myTempFile);
			BaseActivity.Log_info(" ----->打开下载到的文件，成功");
			try {
				is.close();
			} catch (Exception ex) {
				BaseActivity.Log_info(" ----->打开下载到的文件，失败： " + ex.getMessage());
			}
		}
	}

	/**
	 * 更新下载进度
	 */
	Runnable updateLenght = new Runnable() {
		@Override
		public void run() {
			double ratio = numArithmetic.round(size * 100, 2);
			dialog.setMessage("正在后台进行下载，已完成 " + (ratio > 100 ? "100" : ratio) + "%\n" + "可返回进行别的操作，下载完成后请选择安装");
		}
	};

	/**
	 * 打开文件进行安装
	 * 
	 * @param f
	 */
	private void openFile(File f) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		String type = getMIMEType(f);
		intent.setDataAndType(Uri.fromFile(f), type);
		context.startActivity(intent);
	}

	/**
	 * 获得下载文件的类型
	 * 
	 * @param f
	 *            文件名称
	 * @return 文件类型
	 */
	private String getMIMEType(File f) {
		String type = "";
		// 获得文件名称
		String fName = f.getName();
		// 获得文件扩展名
		String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
		if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") || end.equals("xmf") || end.equals("ogg")
				|| end.equals("wav")) {
			type = "audio";
		} else if (end.equals("3gp") || end.equals("mp4")) {
			type = "video";
		} else if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg")
				|| end.equals("bmp")) {
			type = "image";
		} else if (end.equals("apk")) {
			type = "application/vnd.android.package-archive";
		} else {
			type = "*";
		}
		if (end.equals("apk")) {
		} else {
			type += "/*";
		}
		return type;
	}
}