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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Key;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * 工具类
 * 
 * @author ly
 */
@SuppressLint("DefaultLocale")
public class Utils {

	public static Handler handler;

	static URL url;
	static InputStream in;
	static String content;

	public static ProgressDialog progress; // 进度条对话框

	// 获取当前系统目录使用的左右斜杠 路径分隔符
	public static String separator = File.separator;
	// 数据存储地址
	public static final String FOLDER_PATH = separator + "mnt" + separator
			+ "sdcard" + separator;

	/**
	 * 生成6位随机数的方法
	 * 
	 * @return
	 */
	public static String randomAccounts() {

		int accounts = (int) ((Math.random() * 9 + 1) * 100000);

		return accounts + "";
	}

	/**
	 * 检查当前网络状态（包括wi-fi，net等）
	 * 
	 */
	public static boolean checkNet(Context context) {

		// 获取手机所以连接管理对象（包括wi-fi，net等连接的管理）
		ConnectivityManager conn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conn != null) {
			// 网络管理连接对象
			NetworkInfo info = conn.getActiveNetworkInfo();

			if (info != null && info.isConnected()) {
				// 判断当前网络是否连接
				if (info.getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressLint("ShowToast")
	/**
	 * 线程中显示提示信息
	 * @param context
	 * @param msg
	 */
	public static void LooperToast(Context context, String msg) {
		Looper.loop();
		Toast.makeText(context, msg, 1).show();
		Looper.prepare();
	}
	
	
	
	/**
	 * get请求
	 * 
	 * @param strUrl
	 * @return
	 */
	public static String getRequest(String urlStr) {
		System.out.println(urlStr);
		try {
			url = new URL(urlStr);
			in = url.openStream();
			content = Utils.getContent(in, "utf-8");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * post请求
	 * 
	 * @param urlPath
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public static String postRequest(String urlPath, Map<String, String> map) {

		String content = null;

		try {
			StringBuilder builder = new StringBuilder(); // 拼接字符
			// 拿出键值
			if (map != null && !map.isEmpty()) {
				for (Map.Entry<String, String> param : map.entrySet()) {
					builder.append(param.getKey())
							.append('=')
							.append(URLEncoder.encode(param.getValue(), "utf-8"))
							.append('&');
				}
				builder.deleteCharAt(builder.length() - 1);
			}
			// 这个URL的二进制数据长度
			byte b[] = builder.toString().getBytes();

			System.out.println(builder);

			URL url = new URL(urlPath);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setReadTimeout(5 * 1000);
			con.setDoInput(true);// 设置可读取
			con.setDoOutput(true);// 设置可写入
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");// 内容类型
			con.setRequestProperty("Content-Length", String.valueOf(b.length));// 长度
			OutputStream outStream = con.getOutputStream();
			outStream.write(b);// 写入数据
			outStream.flush();// 刷新内存
			outStream.close();
			// 获取返回的结果
			// InputStream in = con.getInputStream();
			// content = getContent(in, "utf-8");
			if (con.getResponseCode() == 200) {
				InputStream in = con.getInputStream();
				content = getContent(in, "utf-8");
				return content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取返回的内容
	 * 
	 * @param in
	 *            流
	 * @param charset
	 *            编码格式
	 * @return
	 * @throws IOException
	 */
	public static String getContent(InputStream in, String charset)
			throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 10];
		int len = -1;
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		String content = out
				.toString(charset == null || charset.equals("") ? "UTF-8"
						: charset);
		return content;

	}

	/**
	 * 从服务器取图片
	 * 
	 * @param urlPic
	 * @return
	 */
	public static Bitmap getPic(String urlPic) {
		URL imageUrl = null;
		Bitmap bitmap = null;
		try {
			imageUrl = new URL(urlPic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			HttpURLConnection conn = (HttpURLConnection) imageUrl
					.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			bitmap = BitmapFactory.decodeStream(is);

			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	/**
	 * 关闭输入输出流
	 * 
	 * @param in
	 * @param out
	 */
	public static void closeStream(InputStream in, OutputStream out) {
		try {
			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载
	 * 
	 * @param url
	 *            下载地址
	 * @param path
	 *            储存路径
	 * @return
	 */
	public static boolean Download(String url, String path) {
		boolean copyIsFinish = false;
		// 得到后缀名
		String name = "";
		String[] st = url.split("/");
		name = st[st.length - 1];

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse httpResponse = new DefaultHttpClient()
					.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				InputStream is = httpResponse.getEntity().getContent();
				// 开始下载文件
				FileOutputStream fos = new FileOutputStream(path + "/" + name);
				byte[] buffer = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) != -1) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
				copyIsFinish = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copyIsFinish;
	}

	/**
	 * 显示手机型号
	 * 
	 * @return
	 */
	public static String showBrand() {
		return Build.BRAND;
	}

	/**
	 * 显示手机品牌型号
	 * 
	 * @return
	 */
	public static String showBrandModel() {
		return Build.MODEL;
	}

	/**
	 * 
	 * 获取SDCard的目录路径功能
	 */
	public static String getSDCardPath() {
		File sdcardDir = null;
		// 判断SDCard是否存在
		boolean sdcardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		if (sdcardExist) {
			sdcardDir = Environment.getExternalStorageDirectory();
		}
		return sdcardDir.toString();
	}

	/**
	 * 显示刷新当前系统时间
	 */
	@SuppressLint("SimpleDateFormat")
	public static void TimeShow() {
		try {
			while (true) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String str = sdf.format(new Date());
				handler.sendMessage(handler.obtainMessage(100, str));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件夹
	 * 
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 判断输入是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.equals("")) {
			return true;
		}

		return false;
	}

	/**
	 * 使用正则表达式检查邮箱地址格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmailAddress(String email) {

		return email
				.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
	}

	/**
	 * 验证密码格式
	 * 
	 * @param pwd
	 * @return
	 */
	public static boolean checkPassworld(String pwd) {

		return pwd.matches("[a-zA-Z]+\\d+");
	}

	/**
	 * 检查是否输入了特殊字符
	 * 
	 * @param s
	 *            输入字符
	 * @return true 有特殊字符 false 没有
	 */
	public static boolean checkStringSpecial(String s) {
		String regEx = "[`~!@#$%^&*()+-=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(s);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 过滤字符串中的html代码
	 * 
	 * @param inputString
	 * @return
	 */
	public static String filtHtml(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		java.util.regex.Pattern p_html1;
		java.util.regex.Matcher m_html1;

		try {
			String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>
																										// }
			String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	/**
	 * 从路径中获取文件名
	 * 
	 * @param url
	 * @return
	 */
	public static String getFileNameByUrl(String url) {
		String fileName = "";
		try {
			fileName = url.substring(url.lastIndexOf("/"), url.length());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

	/**
	 * 获得手机sdk版本号
	 * 
	 * @return
	 */
	public static int getAndroidSDKVersion() {
		return android.os.Build.VERSION.SDK_INT;
	}

	/**
	 * 保留小数点后几位
	 * 
	 * @param d
	 *            原数字
	 * @param placeNum
	 *            小数点后几位
	 * @return
	 */
	public static double decimal(double d, int placeNum) {
		String format = ".";

		for (int i = 0; i < placeNum; i++) {
			format += "#";
		}
		DecimalFormat df = new DecimalFormat(format);
		return Double.parseDouble(df.format(d));
	}

	/**
	 * 保留两位小数
	 * 
	 * @param d
	 *            原数字
	 * @return
	 */
	public static double decimalTwo(double d) {

		return decimal(d, 2);
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 通过mill按一定格式得到时间String,
	 * 
	 * @param mill
	 * @return
	 */
	public static String getStringFormatByMill(long mill) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分",
				Locale.getDefault());

		String date = format.format(new Date(mill));
		return date;
	}

	/**
	 * 通过mill按一定格式得到时间String,
	 * 
	 * @param mill
	 * @param format
	 *            格式
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getStringFormatByMill(long mill, String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		String date = f.format(new Date(mill));
		return date;
	}

	/**
	 * 通过mill按一定格式得到时间String,精确到天，时间为00:00:00
	 * 
	 * @param mill
	 * @return
	 */
	public static String getStringFormatByMillExactDay(long mill) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分",
				Locale.getDefault());
		String date = format.format(new Date(mill));
		return date + " 00:00:00";
	}

	/**
	 * 获取两个时间差距天数
	 * 
	 * @param millis1
	 *            起始毫秒时间
	 * @param millis2
	 *            结束毫秒时间
	 * @param isLenient
	 *            未满一天是否算一天
	 * @return
	 */
	public static long GetDeffDay(long millis1, long millis2, boolean isLenient) {

		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(millis1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(millis2);

		long diffMills = cal2.getTimeInMillis() - cal1.getTimeInMillis();
		long diffDays = (int) diffMills / (24 * 60 * 60 * 1000);

		if (isLenient) {
			// 加上这段代码后，就算差距未满一天，也算一天
			if (diffMills % (24 * 60 * 60 * 1000) > 0) {
				++diffDays;
			}
		}

		return diffDays;
	}

	/**
	 * 判断两个时间差距，若小于5分钟，返回"刚刚"
	 * 
	 * @param millis1
	 * @param millis2
	 * @return
	 */
	public static String GetDeffTime(long millis1, long millis2) {

		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(millis1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(millis2);

		long diffMills = cal2.getTimeInMillis() - cal1.getTimeInMillis();

		long diffMonthes = diffMills / (30 * 24 * 60 * 60 * 1000);
		long diffDays = diffMills / (24 * 60 * 60 * 1000);
		long diffHours = diffMills / (60 * 60 * 1000);
		long diffMinus = diffMills / (60 * 1000);

		if (diffMonthes > 0) {
			return "" + diffMonthes + "个月前";
		} else if (diffDays > 0) {
			return "" + diffDays + "天前";
		} else if (diffHours > 0) {
			return "" + diffHours + "小时前";
		} else if (diffMinus > 1) {
			return "" + diffMinus + "分钟前";
		} else {
			return "刚刚";
		}

	}

	/**
	 * ms转m(毫秒转分钟)
	 * 
	 * @param ms
	 * @return
	 */
	public static String msToM(int ms) {

		int seconds = ms / 1000;

		int minutes = seconds / 60;
		seconds = seconds % 60;

		String m = null;
		String s = null;

		if (minutes == 0 && seconds == 0)
			seconds = 1;

		if (minutes < 10)
			m = "0" + minutes;
		else
			m = "" + minutes;

		if (seconds < 10)
			s = "0" + seconds;
		else
			s = "" + seconds;

		return m + ":" + s;
	}

	/**
	 * 加,解密类
	 * 
	 * @author ly
	 * 
	 */
	public static class EncryptAndDecode {

		private static String strDefaultKey = "ly";
		private Cipher encryptCipher = null;
		private Cipher decryptCipher = null;

		public static String byteArr2HexStr(byte[] arrB) throws Exception {
			int iLen = arrB.length;
			// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
			StringBuffer sb = new StringBuffer(iLen * 2);

			for (int i = 0; i < iLen; i++) {
				int intTmp = arrB[i];
				// 把负数转换为正数
				while (intTmp < 0) {
					intTmp = intTmp + 256;
				}

				// 小于0F的数需要在前面补0
				if (intTmp < 16) {
					sb.append("0");
				}

				sb.append(Integer.toString(intTmp, 16));
			}
			return sb.toString();
		}

		public static byte[] hexStr2ByteArr(String strIn) throws Exception {
			byte[] arrB = strIn.getBytes();
			int iLen = arrB.length;
			// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
			byte[] arrOut = new byte[iLen / 2];
			for (int i = 0; i < iLen; i = i + 2) {
				String strTmp = new String(arrB, i, 2);
				arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
			}
			return arrOut;
		}

		public EncryptAndDecode() throws Exception {
			this(strDefaultKey);
		}

		public EncryptAndDecode(String strKey) {
			// Security.addProvider(null);
			Key key;
			try {
				key = getKey(strKey.getBytes());
				encryptCipher = Cipher.getInstance("DES");
				encryptCipher.init(Cipher.ENCRYPT_MODE, key);
				decryptCipher = Cipher.getInstance("DES");
				decryptCipher.init(Cipher.DECRYPT_MODE, key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public byte[] encrypt(byte[] arrB) throws Exception {
			return encryptCipher.doFinal(arrB);
		}

		/**
		 * 加密
		 * 
		 * @param strIn
		 *            待加密字符串
		 * @return
		 * @throws Exception
		 */
		public String encrypt(String strIn) throws Exception {
			return byteArr2HexStr(encrypt(strIn.getBytes()));
		}

		public byte[] decrypt(byte[] arrB) throws Exception {
			return decryptCipher.doFinal(arrB);
		}

		/**
		 * 解密
		 * 
		 * @param strIn
		 *            带解密字符串
		 * @return
		 * @throws Exception
		 */
		public String decrypt(String strIn) throws Exception {
			return new String(decrypt(hexStr2ByteArr(strIn)));
		}

		private Key getKey(byte[] arrBTmp) throws Exception {
			// 创建一个空的8位字节数组（默认值为0）
			byte[] arrB = new byte[8];
			// 将原始字节数组转换为8位
			for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
				arrB[i] = arrBTmp[i];
			}
			// 生成密钥
			Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
			return key;
		}

		// public static void main(String[] args) {
		// try {
		// String test = "liwc";
		// // 注意,自定义的加密的KEY要和解密的KEY一致,这就是钥匙,如果上锁了,却忘了钥匙,那么是解密不了的
		// EncryptAndDecode des = new EncryptAndDecode("leemenz");// 自定义密钥
		// System.out.println("加密前的字符：" + test);
		// System.out.println("加密后的字符：" + des.encrypt(test));
		// System.out.println("解密后的字符：" + des.decrypt(des.encrypt(test)));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
	}
}
