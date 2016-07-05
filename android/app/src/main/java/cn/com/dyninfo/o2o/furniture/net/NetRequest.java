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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.net.NetHttpClient.OnProgressListener;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-27 上午11:27:18
 */
public class NetRequest {

	public NetRequest() {

	}

	private long totalsiaze;

	public long getTotalsiaze() {
		return totalsiaze;
	}

	/**
	 * 
	 * @Description 执行请求
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @param url
	 * @param httpMethod
	 *            (POST,GET,PUT, etc)
	 * @param listParam
	 *            parameters
	 * @param listFile
	 *            要post 的文件
	 */

	public String syncRequest(String url, String httpMethod, List<NetParam> listParam, List<NetParam> listFile) {
		return syncRequest(url, httpMethod, listParam, listFile, 0);
	}

	public String syncRequest(String url, String httpMethod, List<NetParam> listParam, List<NetParam> listFile,
			int timeout, OnProgressListener listener) {
		if (url == null || "".equals(url)) {
			Log.i("url", "error url:null");
			return null;
		}
		String reValue = null;
		try {
			StringBuffer sbQueryString = new StringBuffer();
			sbQueryString.append(formEncodeParameters(listParam));
			String queryString = sbQueryString.toString();
			Log.i("url", url + "?" + queryString);
			NetHttpClient http = new NetHttpClient();
			if ("GET".equals(httpMethod)) {
				reValue = http.httpGet(url, queryString, timeout);
			} else if ((listFile == null) || (listFile.size() == 0)) {
				reValue = http.httpPost(url, queryString, timeout);
			} else {
				reValue = http.httpPostWithFile(url, queryString, listFile, timeout, listener);
				totalsiaze = http.getTotalsiaze();
			}
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("status", "-1");
			} catch (JSONException e1) {
			}
			reValue = json.toString();
			e.printStackTrace();
		}
		return reValue;
	}

	public String syncRequest(String url, String httpMethod, List<NetParam> listParam, List<NetParam> listFile,
			int timeout) {
		if (url == null || "".equals(url)) {
			Log.i("url", "error url:null");
			return null;
		}

		String reValue = null;
		try {
			StringBuffer sbQueryString = new StringBuffer();
			sbQueryString.append(formEncodeParameters(listParam));
			String queryString = sbQueryString.toString();
			Log.i("url", url + "?" + queryString);
			NetHttpClient http = new NetHttpClient();
			if ("GET".equals(httpMethod)) {
				reValue = http.httpGet(url, queryString, timeout);
			} else if ((listFile == null) || (listFile.size() == 0)) {
				reValue = http.httpPost(url, queryString, timeout);
			} else {
				reValue = http.httpPostWithFile(url, queryString, listFile, timeout);
			}
		} catch (Exception e) {
			JSONObject json = new JSONObject();
			try {
				json.put("status", "-1");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			reValue = json.toString();
			e.printStackTrace();
		}
		return reValue;
	}

	/**
	 * Do async request
	 * 
	 * @param url
	 *            The full url that needs to be signed including its non OAuth
	 *            url parameters
	 * @param httpMethod
	 *            The http method used. Must be a valid HTTP method verb
	 *            (POST,GET,PUT, etc)
	 * @param key
	 *            OAuth key
	 * @param listParam
	 *            Query parameters
	 * @param listFile
	 *            Files for post
	 * @param asyncHandler
	 *            The async handler
	 * @param cookie
	 *            Cookie response to handler
	 * @return
	 */
	public boolean asyncRequest(Context ctx, String url, String httpMethod, List<NetParam> listParam,
			List<NetParam> listFile, NetAsyncHandler asyncHandler, Object cookie) {

		boolean reValue = false;
		try {
			StringBuffer sbQueryString = new StringBuffer();
			sbQueryString.append(formEncodeParameters(listParam));
			String queryString = sbQueryString.toString();
			NetAsyncHttpClient asyncHttp = new NetAsyncHttpClient();
			if ("GET".equals(httpMethod)) {
				reValue = asyncHttp.httpGet(url, queryString, asyncHandler, cookie);
			} else if ((listFile == null) || (listFile.size() == 0)) {
				reValue = asyncHttp.httpPost(url, queryString, asyncHandler, cookie);
			} else {
				reValue = asyncHttp.httpPostWithFile(url, queryString, listFile, asyncHandler, cookie);
			}

		} catch (Exception e) {
//			BaseActivity.Tip("数据异常");
		}
		return reValue;
	}

	/**
	 * Encode each parameters in list.
	 * 
	 * @param parameters
	 *            List of parameters
	 * @return Encoded parameters
	 */
	private String formEncodeParameters(List<NetParam> parameters) {
		List<NetParam> encodeParams = new ArrayList<NetParam>();
		for (NetParam a : parameters) {
			if (a.mValue == null) {
				BaseActivity.Log_info(a.mName + "value null");
			}
			encodeParams.add(new NetParam(a.mName, encode(a.mValue)));
		}

		return normalizeRequestParameters(encodeParams);
	}

	private static String encode(String value) {
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
		}
		return encoded;
	}

	private String normalizeRequestParameters(List<NetParam> parameters) {
		StringBuffer sb = new StringBuffer();
		NetParam p = null;
		for (int i = 0, size = parameters.size(); i < size; i++) {
			p = parameters.get(i);
			sb.append(p.mName);
			sb.append("=");
			sb.append(p.mValue);

			if (i < size - 1) {
				sb.append("&");
			}
		}

		return sb.toString();
	}
}
