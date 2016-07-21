package com.wckj.gfsj.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.wckj.gfsj.Application.AppApplication;


/**
 * 执行更新一些UI的工具栏
 */
public class UiUtils {
	public static void removeParent(View v) {
		// 先找到爹 在通过爹去移除孩子
		ViewParent parent = v.getParent();
		// 所有的控件 都有爹 爹一般情况下 就是ViewGoup
		if (parent instanceof ViewGroup) {
			ViewGroup group = (ViewGroup) parent;
			group.removeView(v);

		}
	}

	/**
	 * 把Runnable 方法提交到主线程运行
	 *
	 * @param runnable
	 */
	public static void runOnUiThread(Runnable runnable, long delayMillis) {
		// 在主线程运行
		if (android.os.Process.myTid() == AppApplication.mainTid) {
			if (delayMillis > 0)
				AppApplication.handler.postDelayed(runnable, delayMillis);
			else
				runnable.run();
		} else { // 获取handler
			if (AppApplication.handler != null) {
				if (delayMillis == 0)
					AppApplication.handler.post(runnable);
				else
					AppApplication.handler.postDelayed(runnable, delayMillis);
			}
		}
	}
}
