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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.dyninfo.o2o.furniture.R;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;

/**
 * @Description 一些配置和方法
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-16 10:21:31
 * @update 2014-6-28 17:12:57
 */
public class APP {

	/** 图片加载失败时，展示的图片 **/
	public static int IMG_LOAD_FAILD = R.drawable.img_load_failed;
	public static int IMG_LOAD_FAILD_SHORT = R.drawable.img_load_failed_short;
	/** 图片加载中，显示的占位图片 **/
	public static int IMG_LOAD_HOLDER = R.drawable.img_load_holder;
	public static int IMG_LOAD_HOLDER_SHORT = R.drawable.img_load_holder_short;

	private static Toast toast;

	public static String formatSqlValue(String value) {
		return value.replaceAll("'", "''");
	}

	public static String sImplode(Object ids) {
		return "'" + implode(ids, "','") + "'";
	}

	public static void copyto(Object one, Object two) throws Exception {
		Field[] fields = two.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (!Modifier.isFinal(field.getModifiers()))
					FieldUtil.setValueToFiled(field, two, FieldUtil.getFieldValue(field, one).toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Description 根据图片尺寸，屏幕边距计算出 填充控件时该图片需要的高度
	 * @param imgW
	 *            图片宽
	 * @param imgH
	 *            图片高
	 * @param subtractW
	 *            除去距离（dp）
	 */
	public static int getImgSimpleHeight(Context context, int imgW, int imgH, int subtractW) {
		return (int) (Sys.getScreenWidth(context) - Sys.Dp2Px(context, subtractW)) * imgH / imgW;
	}

	/** 设置activity 标题 */
	public static void setTitle(Handler handler, final TextView title, final String PAGE_TITLE) {
		Log.i(Var.info, "正在设置页面标题：" + PAGE_TITLE);
		handler.post(new Runnable() {
			@Override
			public void run() {
				title.setText(PAGE_TITLE);
			}
		});
	}

	/** 设置activity 返回按钮可见 */
	public static void setBackVisible(Handler handler, final ImageView back, final Boolean bool) {
		Log.i(Var.info, "正在设置返回按钮可见度：" + bool);
		handler.post(new Runnable() {
			@Override
			public void run() {
				if (bool)
					back.setVisibility(View.VISIBLE);
				else
					back.setVisibility(View.GONE);
			}
		});
	}

	/** 得到一个 max 以内的随机数 */
	public static int getOneRandomNum(int max) {
		int num = 0;
		int a[] = new int[max];
		for (int i = 0; i < max; i++) {
			a[i] = (int) (Math.random() * max);
		}
		num = a[a.length - 1];
		System.out.println("num = " + num);
		return num;
	}

	/**
	 * 产生一个最大为max随机数
	 */
	public static String getRandomNum(int max) {
		Random rad = new Random();
		return rad.nextInt(max + 1) + "";
	}

	/** 打印异常信息 */
	public static void exception(String tag, Exception e) {
		BaseActivity.Log_error(tag + " Exception：");
		e.printStackTrace();
	}

	/**
	 * 数组转为字符串
	 */
	@SuppressWarnings("unchecked")
	public static String implode(Object data, String separator) {
		if (data == null) {
			return "";
		}
		StringBuffer out = new StringBuffer();
		if (data instanceof Object[]) {
			boolean flag = false;
			for (Object obj : (Object[]) data) {
				if (flag) {
					out.append(separator);
				} else {
					flag = true;
				}
				out.append(obj);
			}
		} else if (data instanceof Map) {
			Map<Object, ?> temp = (Map<Object, ?>) data;
			Set<Object> keys = temp.keySet();
			boolean flag = false;
			for (Object key : keys) {
				if (flag) {
					out.append(separator);
				} else {
					flag = true;
				}
				out.append(temp.get(key));
			}
		} else if (data instanceof Collection) {
			boolean flag = false;
			for (Object obj : (Collection) data) {
				if (flag) {
					out.append(separator);
				} else {
					flag = true;
				}
				out.append(obj);
			}
		} else {
			return data.toString();
		}
		return out.toString();
	}

	/**
	 * 展示提示信息
	 */
	public static void tip(Context context, String msg) {
		tip(context, msg, 0);
	}

	/**
	 * 展示提示信息
	 * 
	 * @param time
	 *            = 0 代表短时间
	 */
	public static void tip(Context context, String msg, int time) {
		TextView message;
		if (toast == null) {
			View view = LayoutInflater.from(context).inflate(R.layout.mytoast, null);
			message = (TextView) view.findViewById(R.id.toast_tip);
			message.setText(msg);
			toast = new Toast(context);
			if (0 == time) {
				toast.setDuration(Toast.LENGTH_SHORT);
			} else {
				toast.setDuration(Toast.LENGTH_LONG);
			}
			toast.setView(view);
		} else {
			View layout = toast.getView();
			message = (TextView) layout.findViewById(R.id.toast_tip);
			message.setText(msg);
		}
		// 距离顶部100dp
		// toast.setGravity(Gravity.CENTER, 0, -(Sys.getScreenHeight(context) /
		// 2 - Sys.Dp2Px(context, 100)));
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	/**
	 * 取消提示信息
	 */
	public void dismissTip() {
		if (toast != null) {
			toast.cancel();
		}
	}

	public static JSONObject checkReturnData(String jsonString, Context context) {
		return checkReturnData(jsonString, context, true);
	}

	public static JSONObject checkReturnData(String jsonString, Context context, boolean tip) {
		JSONObject object = null;
		if (!APP.empty(jsonString)) {
			try {
				object = new JSONObject(jsonString);
				BaseActivity.Log_info("APP.checkReturnData：返回的 json 不为空");
				if (object.has("status") && object.getInt("status") == -1) {
					BaseActivity.Tip("网络状态不佳");
				}
			} catch (Exception e) {
				try {
					new JSONArray(jsonString);
				} catch (Exception e2) {
					if (context != null && tip) {
						// 返回的结果不是json
						// APP.tip(context, "数据异常");
					}
				}
			}
		} else {
			if (context != null && tip) {
				// APP.tip(context, "服务器异常，请重试");
			}
		}
		return object;

	}

	/** 对常见类型判断是否为空 */
	public static boolean empty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String && (obj.equals("") || obj.equals("0"))) {
			return true;
		} else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
			return true;
		} else if (obj instanceof Boolean && !((Boolean) obj)) {
			return true;
		} else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Map && ((Map) obj).isEmpty()) {
			return true;
		} else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
			return true;
		}
		return false;
	}

	public static void KeyboardDismiss(Activity context) {
		InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		manager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}

	/**
	 * 通过 url 下载 bmp图片 <br>
	 * 获取图片失败时，默认用 logo
	 */
	public static Bitmap getBmpFromUrl(Context context, String imageUri) {
		Bitmap bitmap = null;
		try {
			URL myFileUrl = new URL(imageUri);
			HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			Log.v("getBmpFromUrl", "图片下载失败" + imageUri);
			return null;
		}
		if (bitmap == null) {
			bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xuan_logo);
		}
		return bitmap;
	}

	/**
	 * @Description
	 * @created by <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a> on
	 *          2014-8-2 下午5:37:49
	 */
	public static String InputStream2String(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		try {
			while ((i = is.read()) != -1) {
				baos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toString();
	}

	/**
	 * @Description 校验是否是手机号（13、14、15、18 xxxx）
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-7-9 17:46:54
	 */
	public static boolean isPhoneNO(String no) {
		Pattern p = Pattern.compile("^1[3|4|5|8]\\d{9}$");
		Matcher m = p.matcher(no);
		return m.matches();
	}

	/**
	 * 保存bmp到本地（分享到微信时用）
	 */
	public static String saveBmp2SDCard(Bitmap bitmap, String timestamp) throws IOException {
		String path = Util.IMG_SHARE_PATH + "/share_" + timestamp + ".jpg";
		File file = new File(path);
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
				out.flush();
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * 保存bmp到本地指定目录
	 */
	public static void saveBmp2SDPath(Bitmap bitmap, String path) throws IOException {
		File file = new File(path);
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)) {
				out.flush();
				out.close();
				BaseActivity.Log_info("-------------> saveBmp2SDPath 成功执行");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据文件路径保存bmp
	 */
	public static Bitmap saveBmp2SDByPath(String filePath, int w, int h) {
		try {
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(filePath, opts);
			int srcWidth = opts.outWidth;
			int srcHeight = opts.outHeight;
			int destWidth = 0;
			int destHeight = 0;
			double ratio = 0.0;
			if (srcWidth < w || srcHeight < h) {
				ratio = 0.0;
				destWidth = srcWidth;
				destHeight = srcHeight;
			} else if (srcWidth > srcHeight) {
				ratio = (double) srcWidth / w;
				destWidth = w;
				destHeight = (int) (srcHeight / ratio);
			} else {
				ratio = (double) srcHeight / h;
				destHeight = h;
				destWidth = (int) (srcWidth / ratio);
			}
			BitmapFactory.Options newOpts = new BitmapFactory.Options();
			newOpts.inSampleSize = (int) ratio + 1;
			newOpts.inJustDecodeBounds = false;
			newOpts.outHeight = destHeight;
			newOpts.outWidth = destWidth;
			return BitmapFactory.decodeFile(filePath, newOpts);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 拍照后图片的保存路径
	 */
	public static String getPicTempPath() {
		String saveDir = Util.IMG_SAVE_PATH_CAP_TEMP;
		try {
			File dir = new File(saveDir);
			if (!dir.exists())
				dir.mkdir();
		} catch (Exception e) {
		}
		return saveDir + "/" + MyDate.getTimestamp() + ".png";
	}

	/**
	 * 裁剪后的图片路径
	 */
	public static String getPicCutPath() {
		String saveDir = Util.IMG_SAVE_PATH_CAP_CUT;
		try {
			File dir = new File(saveDir);
			if (!dir.exists())
				dir.mkdir();
		} catch (Exception e) {
		}
		return saveDir + "/" + "pic_" + MyDate.getTimestamp() + ".png";
	}

	/**
	 * 读取图片的旋转的角度 (某些机型拍照后图片是旋转过的)
	 * 
	 * @param path
	 *            图片绝对路径
	 * @return 图片的旋转角度
	 */
	public static int getBmpDegree(String path) {
		int degree = 0;
		try {
			// 从指定路径下读取图片，并获取其EXIF信息
			ExifInterface exifInterface = new ExifInterface(path);
			// 获取图片的旋转信息
			int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	/**
	 * 将图片按照某个角度进行旋转
	 * 
	 * @param bm
	 *            需要旋转的图片
	 * @param degree
	 *            旋转角度
	 * @return 旋转后的图片
	 */
	public static Bitmap rotateBmpByDegree(Bitmap bitmap, int degree) {
		Bitmap bmp = null;
		// 根据旋转角度，生成旋转矩阵
		Matrix matrix = new Matrix();
		matrix.postRotate(degree);
		try {
			// 将原始图片按照旋转矩阵进行旋转，并得到新的图片
			bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		} catch (OutOfMemoryError e) {
		}
		if (bmp == null) {
			bmp = bitmap;
		}
		if (bitmap != bmp) {
			bitmap.recycle();
		}
		return bmp;
	}

	/** -----------------------服务器 路径------------------------- */
	// TODO 服务器路径配置
	public static String host = "http://192.168.1.107:8080/Dress"; // 上线地址
//	 public static String host = "http://www.xpzc.com"; // 地址
	/** 图片加载失败地址 */
	static String imgholder = "http://www.c-1-tech.com/Dress/upload/failed/img_load_holder.png";
	static String imgholder_short = "http://www.c-1-tech.com/Dress/upload/failed/img_load_holder_short.png";

	/** 服务器根地址 */
	public static String domains(String relativeurl) {
		return host + "/html/" + relativeurl;
	}

	/**
	 * @Description 购物车地址
	 */
	public static String cart = host + "/widget.html";

	/** 用户头像地址 */
	public static String head_path(String img) {
		System.out.println("用户头像 = " + img);
		if (img.isEmpty() || img.equals("null"))
			return host + "/img/spdet_30.gif";// 默认头像
		if (checkUrl(img)) {
			return img;
		}
		return img_path(img);
	}

	/** 幻灯片广告图片地址 */
	public static String adv_path(String img) {
		if (img.isEmpty() || img.equals("null"))
			return imgholder;
		if (checkUrl(img)) {
			return img;
		}
		return host + "/upload/adv/" + img;
	}

	/** 女人街图片地址 */
	public static String women_street_path(String storeID, String img) {
		if (img.isEmpty() || img.equals("null"))
			return imgholder;
		if (checkUrl(img)) {
			return img;
		}
		// return host + "/merchants/" + storeID + "/" + img;
		return host + "/merchants/" + img;
	}

	/** 美丽宣言图片地址( 商品地址 ) */
	public static String goods_path(String img) {
		if (img.isEmpty() || img.equals("null"))
			return imgholder;
		if (checkUrl(img)) {
			return img;
		}
		return host + "/upload/goods/" + img;
	}

	/** 美丽宣言图片地址( 上传图片地址 ) */
	public static String beauty_proclaim_path(String img) {
		if (img.isEmpty() || img.equals("null"))
			return imgholder;
		if (checkUrl(img)) {
			return img;
		}
		return host + "/upload/issue/" + img;
	}

	/** 缺省图片地址 */
	public static String img_path(String img) {
		if (checkUrl(img)) {
			return img;
		}
		return host + "/upload/" + img;
	}

	public static Boolean checkUrl(String fukingUrl) {
		if (fukingUrl.length() > 8 && fukingUrl.substring(0, 7).equals("http://"))
			return true;
		return false;
	}

}
