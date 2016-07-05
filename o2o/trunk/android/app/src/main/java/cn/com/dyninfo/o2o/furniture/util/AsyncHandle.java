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

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.dialog.LoadingDialog;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * @Description  
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-6-17 10:54:31
 */
public abstract class AsyncHandle {
	private LoadingDialog dialog;
	private Context context;
	private Map<String, Object> params;
	private ThreadHandler handler = null;
	private boolean showdeftip = true;
	private JSONObject reData = null;
	private static ExecutorService exeService = Executors.newCachedThreadPool();

	protected abstract void handleData(JSONObject json, Map<String, Object> parameters) throws JSONException;

	protected abstract String runTask(Map<String, Object> parameters);

	protected void endWaitView(Map<String, Object> params) {

	}

	protected void handleLongTime(JSONObject json, Map<String, Object> parameters) throws JSONException {
	}

	protected void startWaitView(Map<String, Object> params) {

	}

	protected void errorFinally(Map<String, Object> params) {
	}

	protected void netWorkFail(Map<String, Object> params) {
	}

	public AsyncHandle init(Map<String, Object> params) {
		context = null;
		dialog = null;
		this.params = params;
		return this;
	}

	public AsyncHandle init(Context cont, Map<String, Object> params, boolean needDialog) {
		context = cont;
		this.params = params;
		if (needDialog && context != null) {
			dialog = new LoadingDialog(context) {
				@Override
				public void onBackPressed() {
					super.onBackPressed();
					exeService.shutdownNow();
				}
			};
		} else
			dialog = null;

		return this;
	}

	public AsyncHandle init(Context cont, Map<String, Object> params, boolean needDialog, String msg) {
		context = cont;
		this.params = params;
		if (needDialog && context != null) {
			dialog = new LoadingDialog(context) {
				@Override
				public void onBackPressed() {
					super.onBackPressed();
					exeService.shutdownNow();
				}
			};
		} else
			dialog = null;

		return this;
	}

	public boolean isShowdeftip() {
		return showdeftip;
	}

	public void setShowdeftip(boolean showdeftip) {
		this.showdeftip = showdeftip;
	}

	@SuppressLint("HandlerLeak")
	class ThreadHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			if (dialog != null) {
				dialog.dismiss();
			}
			endWaitView(params);
			try {
				int type = msg.getData().getInt("type");
				if (type == 0 && reData != null) {
					handleData(reData, params);
				} else {
					if (type == 1) {
						netWorkFail(params);
					}
					errorFinally(params);
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorFinally(params);
			}
		}
	}

	class UpdateThread extends Thread {
		public void run() {
			try {
				Looper.prepare();
				String returnStr = runTask(params);
				int type = 0;
				try {
					JSONObject returnData = APP.checkReturnData(returnStr, context, showdeftip);
					if (returnData != null) {
						reData = returnData;
						handleLongTime(returnData, params);
					} else {
						type = 1;
					}
				} catch (JSONException e) {
					type = 2;
				} catch (Exception e) {
					type = 3;
				}
				Message msg = new Message();
				Bundle data = new Bundle();
				data.putInt("type", type);
				msg.setData(data);
				if (handler != null) {
					handler.sendMessage(msg);
				}
				Looper.loop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void execute() {
		handler = new ThreadHandler();
		UpdateThread thread = new UpdateThread();

		exeService.execute(thread);
		if (dialog != null) {
			dialog.show();
		}
		startWaitView(params);
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	};

}
