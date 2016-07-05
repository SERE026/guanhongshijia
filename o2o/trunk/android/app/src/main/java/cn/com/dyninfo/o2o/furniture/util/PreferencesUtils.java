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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharePreferences的工具类
 * 
 * @author chenkb
 * @update <a href="http://t.cn/RvIApP5">ceychen</a>
 */
public class PreferencesUtils {

	private Context mContext;
	private static PreferencesUtils preferencesUtils = null;

	private PreferencesUtils(Context mContext) {
		this.mContext = mContext;
	}

	public static PreferencesUtils getPreferencesUtilsInstance(Context mContext) {
		if (preferencesUtils == null) {
			preferencesUtils = new PreferencesUtils(mContext);
		}
		return preferencesUtils;
	}

	/**
	 * 存储单个属性
	 * 
	 * @param field
	 * @param sp
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void saveField(Field field, SharedPreferences sp, Object object) throws IllegalArgumentException,
			IllegalAccessException {
		field.setAccessible(true);
		Class fildType = field.getType();
		if (String.class == fildType || Character.class == fildType) {
			String a = String.valueOf(field.get(object));
			sp.edit().putString(field.getName(), String.valueOf(field.get(object))).commit();
		} else if (Integer.TYPE == fildType || Integer.class == fildType) {
			int xx = field.getInt(object);
			sp.edit().putInt(field.getName(), field.getInt(object)).commit();
		} else if (boolean.class == fildType) {
			sp.edit().putBoolean(field.getName(), field.getBoolean(object)).commit();
		} else if (Long.class == fildType) {
			sp.edit().putLong(field.getName(), field.getLong(object)).commit();
		} else if (Float.class == fildType) {
			sp.edit().putFloat(field.getName(), field.getFloat(object)).commit();
		}

		// sp.edit().putString(field.getName(),
		// String.valueOf(field.get(object))).commit();
	}

	/**
	 * 拿到单个属性
	 * 
	 * @param field
	 * @param sp
	 * @return
	 */
	private String getFieldFromSp(Field field, SharedPreferences sp) {
		field.setAccessible(true);
		Class fildType = field.getType();
		if (String.class == fildType || Character.class == fildType) {
			return sp.getString(field.getName(), "");
		} else if (Integer.TYPE == fildType || Integer.class == fildType) {
			return String.valueOf(sp.getInt(field.getName(), 0));
		} else if (Boolean.class == fildType) {
			return String.valueOf(sp.getBoolean(field.getName(), false));
		} else if (Long.class == fildType) {
			return String.valueOf(sp.getLong(field.getName(), 0L));
		} else if (Float.class == fildType) {
			return String.valueOf(sp.getFloat(field.getName(), 0F));
		}
		return "";

	}

	/**
	 * 数据存储
	 * 
	 * @param sp
	 * @param classzz
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void save(Object object) throws IllegalArgumentException, IllegalAccessException {
		SharedPreferences sp = mContext.getSharedPreferences(object.getClass().getSimpleName(), 2);// 1:read
																									// 2:write
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				saveField(field, sp, object);
		}
	}

	public void clear(Object object) {
		SharedPreferences sp = mContext.getSharedPreferences(object.getClass().getSimpleName(), 2);// 1:read
																									// 2:write
		Editor editor = sp.edit();
		editor.clear();
		editor.commit();
	}

	/**
	 * 获得存储对象
	 * 
	 * @param classzz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public Object getObjectFromSp(Class<?> classzz) throws InstantiationException, IllegalAccessException {
		Object object = classzz.newInstance();
		String name = object.getClass().getSimpleName();
		SharedPreferences sp = mContext.getSharedPreferences(classzz.getSimpleName(), 1);// 1:read
																							// 2:write
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				if (!Modifier.isFinal(field.getModifiers()))
					FieldUtil.setValueToFiled(field, object, getFieldFromSp(field, sp));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return object;
	}

	public Object getObjectFromSp(Class<?> classzz, Object object) throws InstantiationException,
			IllegalAccessException {
		String name = object.getClass().getSimpleName();
		SharedPreferences sp = mContext.getSharedPreferences(classzz.getSimpleName(), 1);// 1:read
																							// 2:write
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {

			try {
				if (!Modifier.isFinal(field.getModifiers()))
					FieldUtil.setValueToFiled(field, object, getFieldFromSp(field, sp));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return object;
	}

	/**
	 * 存储一个域
	 */
	public void saveOne(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		String name = object.getClass().getSimpleName();
		SharedPreferences sp = mContext.getSharedPreferences(object.getClass().getSimpleName(), 2);// 1:read
																									// 2:write
		saveField(field, sp, object);
	}

	/** 获取一个域的值 */
	public String getOne(Object object, Field field) {
		SharedPreferences sp = mContext.getSharedPreferences(object.getClass().getSimpleName(), 2);// 1:read
																									// 2:write
		return getFieldFromSp(field, sp);
	}

}
