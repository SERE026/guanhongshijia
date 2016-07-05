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

package cn.com.dyninfo.o2o.furniture.net;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.Sys;
import android.util.Log;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public class NetHttpUtil {

	public static String getContentType(String fileName) {
		return null;
	}

	public static String getContentType(File file) {
		return null;
	}

	/**
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @return param list
	 */
	public static List<NetParam> getQueryParameters(String queryString) {
		if (queryString.startsWith("?")) {
			queryString = queryString.substring(1);
		}

		List<NetParam> result = new ArrayList<NetParam>();

		if (queryString != null && !queryString.equals("")) {
			String[] p = queryString.split("&");
			for (String s : p) {
				if (s != null && !s.equals("")) {
					if (s.indexOf('=') > -1) {
						String[] temp = s.split("=");
						if (temp.length == 2) {
							result.add(new NetParam(temp[0], temp[1]));
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Convert %XX
	 * 
	 * @param value
	 * @return
	 */
	public static String formParamDecode(String value) {
		int nCount = 0;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '%') {
				i += 2;
			}
			nCount++;
		}

		byte[] sb = new byte[nCount];

		for (int i = 0, index = 0; i < value.length(); i++) {
			if (value.charAt(i) != '%') {
				sb[index++] = (byte) value.charAt(i);
			} else {
				StringBuilder sChar = new StringBuilder();
				sChar.append(value.charAt(i + 1));
				sChar.append(value.charAt(i + 2));
				sb[index++] = Integer.valueOf(sChar.toString(), 16).byteValue();
				i += 2;
			}
		}
		String decode = "";
		try {
			decode = new String(sb, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decode;
	}

	public static boolean isEmpty(String str) {
		if (null == str || str.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static Map<String, String> splitResponse(String response) {
		Map<String, String> map = new HashMap<String, String>();
		if (!NetHttpUtil.isEmpty(response)) {
			String[] array = response.split("&");
			if (array.length > 2) {
				String tokenStr = array[0]; // oauth_token=xxxxx
				String secretStr = array[1];// oauth_token_secret=xxxxxxx
				String[] token = tokenStr.split("=");
				if (token.length == 2) {
					map.put("oauth_token", token[1]);
				}
				String[] secret = secretStr.split("=");
				if (secret.length == 2) {
					map.put("oauth_token_secret", secret[1]);
				}
			}
		}
		return map;
	}

	public static String download(String stringurl) {
		String imageURl = null;
		Log.i("url:", stringurl);
		try {
			URL url = new URL(stringurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			con.setDoInput(true);
			con.connect();
			String content_encode = con.getContentEncoding();
			BaseActivity.Log_info("-----------> content_encode:" + content_encode);
			BufferedOutputStream bos = null;
			imageURl = BaseActivity.FINAL_USER_IMAGE_PATH + Sys.md5(url.toString()) + ".png";
			bos = new BufferedOutputStream(new FileOutputStream(imageURl));
			byte[] buf = new byte[1024];
			int len = 0;
			int count = 0;
			if (con.getContentLength() > 0)
				BaseActivity.Log_info("image size:" + con.getContentLength());
			if (null != content_encode && !"".equals(content_encode) && content_encode.equals("gzip")) {
				GZIPInputStream zipin = new GZIPInputStream(con.getInputStream());
				if (zipin != null) {
					while ((len = zipin.read(buf)) > 0) {
						bos.write(buf, 0, len);
						count += len;
					}
					bos.close();
					zipin.close();
					return imageURl;
				}
			}
			InputStream in = con.getInputStream();
			while ((len = in.read(buf)) > 0) {
				bos.write(buf, 0, len);
				count += len;
			}
			bos.close();
			in.close();
		} catch (Exception e) {
			return null;
		}
		return imageURl;
	}

	public static byte[] download2(String stringurl) {
		try {
			URL url = new URL(stringurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			con.setDoInput(true);
			con.connect();
			String content_encode = con.getContentEncoding();
			BaseActivity.Log_info("content_encode:" + content_encode);
			ByteArrayOutputStream bos = null;
			bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			int count = 0;
			if (con.getContentLength() > 0)
				BaseActivity.Log_info("image size:" + con.getContentLength());

			if (null != content_encode && !"".equals(content_encode) && content_encode.equals("gzip")) {
				GZIPInputStream zipin = new GZIPInputStream(con.getInputStream());
				if (zipin != null) {
					while ((len = zipin.read(buf)) > 0) {
						bos.write(buf, 0, len);
						count += len;
					}
					bos.close();
					zipin.close();
					return bos.toByteArray();
				}
			}
			InputStream in = con.getInputStream();
			while ((len = in.read(buf)) > 0) {
				bos.write(buf, 0, len);
				count += len;
			}
			bos.close();
			in.close();
			return bos.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

}
