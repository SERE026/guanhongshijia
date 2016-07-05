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

package cn.com.dyninfo.o2o.furniture.fragment;

import java.util.concurrent.ExecutorService;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.dyninfo.o2o.furniture.R;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.activity.IndexActivity;
import cn.com.dyninfo.o2o.furniture.bitmap.xutils.BitmapUtils;
import cn.com.dyninfo.o2o.furniture.util.ThreadPool;

/**
 * @Description 嗯
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-6-10 11:39:38
 */
public class BaseFragment extends Fragment {

	public FragmentManager manager;
	private Context context;
	/** 位图工具（占位图片较长版本） **/
	public static BitmapUtils bmpUtils;
	/** 位图工具（占位图片较短版本） **/
	public static BitmapUtils bmpUtils_short_holder;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		context = getActivity();
		bmpUtils = BaseActivity.getBmpUtils();
		bmpUtils_short_holder = BaseActivity.getBmpUtilsShort();
		manager = getActivity().getFragmentManager();
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public void Tip(String msg) {
		BaseActivity.Tip(msg);
	}

	public static void Log_info(String log) {
		BaseActivity.Log_info(log);
	}

	public static void Log_error(String log) {
		BaseActivity.Log_error(log);
	}

	public static void Log_warn(String log) {
		BaseActivity.Log_warn(log);
	}

	public void setTitle(Handler handler, final TextView title, final String page_title) {
		BaseActivity.setTitle(handler, title, page_title);
	}

	public void setTitle(final String PAGE_TITLE) {
		BaseActivity.setTitle(PAGE_TITLE);
	}

	public void setBack() {
		IndexActivity.setBackVisible(true);
	}

	public void setBackGone() {
		IndexActivity.setBackVisible(false);
	}

	/**
	 * @Description 用户登录状态判断
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-6-4 14:29:32
	 * @update 2014-6-10 11:12:48
	 */
	public void checkUser(Context context) {
		BaseActivity.getBaseActivityInstance(context).checkUserSignStatus(context);
	}

	public void loadingShow() {
		BaseActivity.getBaseActivityInstance(context).loadingShow();
	}

	public void loadingDismiss() {
		BaseActivity.getBaseActivityInstance(context).loadingDismiss();
	}

	/** 清空回退栈 */
	public void clearBackStack() {
		int backStackCount = getFragmentManager().getBackStackEntryCount();
		for (int i = 0; i < backStackCount; i++) {
			getFragmentManager().popBackStack();
		}
	}

	protected void animRightToLeft() {
		getActivity().overridePendingTransition(R.anim.push_right_in2, R.anim.push_right_to2);
	}

	protected void animLeftToRight() {
		getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	protected void animBottomToTop() {
		getActivity().overridePendingTransition(R.anim.roll_up, R.anim.roll);
	}

	/**
	 * @Description 不固定线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:42:06
	 */
	public static ExecutorService cachedPool() {
		return ThreadPool.getCachedThreadPool();
	}

	/**
	 * @Description 单线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:47:27
	 */
	public static ExecutorService singlePool() {
		return ThreadPool.getSingleThreadPool();
	}

}
