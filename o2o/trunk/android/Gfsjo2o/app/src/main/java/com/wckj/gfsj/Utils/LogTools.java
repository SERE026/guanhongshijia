package com.wckj.gfsj.Utils;

import android.util.Log;

/**
 * @Description 调试Log.d
 * @author 霜林
 *
 */
public class LogTools {
	public static void println(String hint, String msg) {
		if (hint == null) {
			Log.d("yishuo", msg+"");
		} else {
			Log.d(hint, msg+"");
		}
	}
}
