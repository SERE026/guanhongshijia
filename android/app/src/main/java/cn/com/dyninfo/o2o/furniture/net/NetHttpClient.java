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

import java.io.File;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

/**
 * @Description method for request
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public class NetHttpClient {

	private static final int TIMEOUT = APPCode.TIMEOUT;

	private long totalsiaze;

	public long getTotalsiaze() {
		return totalsiaze;
	}

	public NetHttpClient() {

	}

	/**
	 * @Description get
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public String httpGet(String url, String queryString) throws Exception {
		return httpGet(url, queryString, 0);
	}

	public String httpGet(String url, String queryString, int timeout) throws Exception {
		String responseData = null;

		if (queryString != null && !queryString.equals("")) {
			if (url.indexOf("?") != -1) {
				url += "&" + queryString;
			} else {
				url += "?" + queryString;
			}
		}
		if (timeout == 0) {
			timeout = TIMEOUT;
		}
		HttpClient httpClient = new HttpClient();
		GetMethod httpGet = new GetMethod(url);
		httpGet.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		httpGet.getParams().setParameter("http.socket.timeout", new Integer(timeout));
		try {
			int statusCode = httpClient.executeMethod(httpGet);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("HttpGet Method failed: " + httpGet.getStatusLine());
			}
			responseData = httpGet.getResponseBodyAsString();
			System.err.println("NetHttpClient：httpGet 请求编码：" + httpGet.getRequestCharSet() + "，响应编码："
					+ httpGet.getResponseCharSet());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			httpClient = null;
		}

		return responseData;
	}

	/**
	 * @Description post
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public String httpPost(String url, String queryString) throws Exception {
		return httpPost(url, queryString, 0);
	}

	public String httpPost(String url, String queryString, int timeout) throws Exception {
		String responseData = null;
		HttpClient httpClient = new HttpClient();
		PostMethod httpPost = new PostMethod(url);
		httpPost.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		httpPost.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		if (timeout == 0) {
			timeout = TIMEOUT;
		}
		httpPost.getParams().setParameter("http.socket.timeout", new Integer(timeout));
		if (queryString != null && !queryString.equals("")) {
			httpPost.setRequestEntity(new ByteArrayRequestEntity(queryString.getBytes()));
		}

		try {
			int statusCode = httpClient.executeMethod(httpPost);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("HttpPost Method failed: " + httpPost.getStatusLine());
			}
			responseData = httpPost.getResponseBodyAsString();
			System.err.println("NetHttpClient：httpPost 请求编码：" + httpPost.getRequestCharSet() + "，响应编码："
					+ httpPost.getResponseCharSet());
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			httpPost.releaseConnection();
			httpClient = null;
		}

		return responseData;
	}

	/**
	 * @Description post
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public String httpPostWithFile(String url, String queryString, List<NetParam> files) throws Exception {
		return httpPostWithFile(url, queryString, files, 0);
	}

	public String httpPostWithFile(String url, String queryString, List<NetParam> files, int timeout,
			final OnProgressListener progressListener) throws Exception {
		String responseData = null;
		url += '?' + queryString;
		HttpClient httpClient = new HttpClient();
		PostMethod httpPost = new PostMethod(url);
		httpPost.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		try {
			List<NetParam> listParams = NetHttpUtil.getQueryParameters(queryString);
			int length = listParams.size() + (files == null ? 0 : files.size());
			Part[] parts = new Part[length];
			int i = 0;
			for (NetParam param : listParams) {
				parts[i++] = new StringPart(param.mName, NetHttpUtil.formParamDecode(param.mValue), "UTF-8");
			}
			for (NetParam param : files) {
				File file = new File(param.mValue);
				parts[i++] = new FilePart(param.mName, file.getName(), file, NetHttpUtil.getContentType(file), "UTF-8");
			}
			CustomMultipartRequestEntity cMultipartRequestEntity = new CustomMultipartRequestEntity(parts,
					httpPost.getParams(), new CustomMultipartRequestEntity.ProgressListener() {

						@Override
						public void transferred(long num) {
							BaseActivity.Log_info("-----> 上传 " + num + " byte，等于 " + num / 1024 + " K");
							long i = num, j = totalsiaze;
							float x = (float) i / j;
							int z = ((int) ((i / (float) j) * 100));
							progressListener.pregress(z);
							BaseActivity.Log_info("-----> 共" + totalsiaze + "，等于 " + num / 1024 + " K");
						}
					});
			totalsiaze = cMultipartRequestEntity.getContentLength();
			httpPost.setRequestEntity(cMultipartRequestEntity);

			if (timeout != 0) {
				timeout = TIMEOUT;
				httpPost.getParams().setParameter("http.socket.timeout", new Integer(timeout));
			}
			int statusCode = httpClient.executeMethod(httpPost);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("HttpPost Method failed: " + httpPost.getStatusLine());
			}
			responseData = httpPost.getResponseBodyAsString();
			System.err.println("NetHttpClient：httpPostWithFile 1 请求编码：" + httpPost.getRequestCharSet() + "，响应编码："
					+ httpPost.getResponseCharSet());
		} finally {
			httpPost.releaseConnection();
			httpClient = null;
		}
		return responseData;
	}

	public String httpPostWithFile(String url, String queryString, List<NetParam> files, int timeout) throws Exception {

		String responseData = null;
		url += '?' + queryString;
		HttpClient httpClient = new HttpClient();
		PostMethod httpPost = new PostMethod(url);
		httpPost.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		try {
			List<NetParam> listParams = NetHttpUtil.getQueryParameters(queryString);
			int length = listParams.size() + (files == null ? 0 : files.size());
			System.out.println("-------> POST 文件数 = " + files.size() + "，parts 数 = " + length);
			Part[] parts = new Part[length];
			int i = 0;
			for (NetParam param : listParams) {
				parts[i++] = new StringPart(param.mName, NetHttpUtil.formParamDecode(param.mValue), "UTF-8");
			}
			for (NetParam param : files) {
				File file = new File(param.mValue);
				System.out.println("--------> 正在添加待上传文件，图片名 = " + param.mName);
				parts[i++] = new FilePart(param.mName, file.getName(), file, NetHttpUtil.getContentType(file), "UTF-8");
			}

			httpPost.setRequestEntity(new CustomMultipartRequestEntity(parts, httpPost.getParams(),
					new CustomMultipartRequestEntity.ProgressListener() {
						@Override
						public void transferred(long num) {
							BaseActivity.Log_info("-----> 上传 " + num + " byte ， 等于 " + num / 1024 + " K");
						}
					}));

			if (timeout != 0) {
				timeout = TIMEOUT;
				httpPost.getParams().setParameter("http.socket.timeout", new Integer(timeout));
			}
			int statusCode = httpClient.executeMethod(httpPost);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("HttpPost Method failed: " + httpPost.getStatusLine());
			}
			responseData = httpPost.getResponseBodyAsString();
			System.err.println("NetHttpClient：httpPostWithFile 2 请求编码：" + httpPost.getRequestCharSet() + "，响应编码："
					+ httpPost.getResponseCharSet());
		} finally {
			httpPost.releaseConnection();
			httpClient = null;
		}

		return responseData;
	}

	public interface OnProgressListener {
		void pregress(int num);
	}

}
