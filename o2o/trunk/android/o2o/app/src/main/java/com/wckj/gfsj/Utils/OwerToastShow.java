package com.wckj.gfsj.Utils;

import android.content.Context;
import android.widget.Toast;


/**
 * 全局Toast显示
 * 避免Toast长时间显示问题
 * @author 霜林
 *
 */
public class OwerToastShow {
	private static Toast toast = null;

	public static void show(Context context,String msg) {
		if (toast == null) {
			toast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
	public static void show(String msg) {
		if (toast == null) {
//			toast = Toast.makeText(AppApplication.context, msg, Toast.LENGTH_SHORT);
		} else {
			toast.setText(msg);
		}
		toast.show();
	}
}
