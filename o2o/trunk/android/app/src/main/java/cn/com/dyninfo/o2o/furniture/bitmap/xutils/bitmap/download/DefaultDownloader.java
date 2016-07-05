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

package cn.com.dyninfo.o2o.furniture.bitmap.xutils.bitmap.download;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.BitmapUtils;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.util.IOUtils;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.util.LogUtils;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.util.OtherUtils;

public class DefaultDownloader extends Downloader {

	/**
	 * Download bitmap to outputStream by uri.
	 * 
	 * @param uri
	 *            file path, assets path(assets/xxx) or http url.
	 * @param outputStream
	 * @param task
	 * @return The expiry time stamp or -1 if failed to download.
	 */
	@Override
	public long downloadToStream(String uri, OutputStream outputStream, final BitmapUtils.BitmapLoadTask<?> task) {

		if (task == null || task.isCancelled() || task.getTargetContainer() == null)
			return -1;

		URLConnection urlConnection = null;
		BufferedInputStream bis = null;

		OtherUtils.trustAllSSLForHttpsURLConnection();

		long result = -1;
		long fileLen = 0;
		long currCount = 0;
		try {
			if (uri.startsWith("/")) {
				FileInputStream fileInputStream = new FileInputStream(uri);
				fileLen = fileInputStream.available();
				bis = new BufferedInputStream(fileInputStream);
				result = System.currentTimeMillis() + this.getDefaultExpiry();
			} else if (uri.startsWith("assets/")) {
				InputStream inputStream = this.getContext().getAssets().open(uri.substring(7, uri.length()));
				fileLen = inputStream.available();
				bis = new BufferedInputStream(inputStream);
				result = Long.MAX_VALUE;
			} else {
				try {
					final URL url = new URL(uri);
					urlConnection = url.openConnection();
					urlConnection.setConnectTimeout(this.getDefaultConnectTimeout());
					urlConnection.setReadTimeout(this.getDefaultReadTimeout());
					bis = new BufferedInputStream(urlConnection.getInputStream());
					result = urlConnection.getExpiration();
					result = result < System.currentTimeMillis() ? System.currentTimeMillis() + this.getDefaultExpiry()
							: result;
					fileLen = urlConnection.getContentLength();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				if (task.isCancelled() || task.getTargetContainer() == null)
					return -1;

				byte[] buffer = new byte[4096];
				int len = 0;
				while ((len = bis.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
					currCount += len;
					if (task.isCancelled() || task.getTargetContainer() == null)
						return -1;
					task.updateProgress(fileLen, currCount);
				}
				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Throwable e) {
			try {
				result = -1;
				LogUtils.e(e.getMessage(), e);
			} catch (Exception e2) {
				LogUtils.e(e2.getMessage(), e2);
			}
		} finally {
			IOUtils.closeQuietly(bis);
		}
		return result;
	}
}
