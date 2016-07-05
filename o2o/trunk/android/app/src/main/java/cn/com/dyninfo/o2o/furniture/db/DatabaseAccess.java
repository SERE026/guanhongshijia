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

package cn.com.dyninfo.o2o.furniture.db;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.FieldUtil;
import cn.com.dyninfo.o2o.furniture.util.Util;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-6-18 16:46:24
 */
public class DatabaseAccess {

	private static final int DATABASE_VERSION = Util.databaseversion;

	private static DatabaseHelper mDbHelper;

	public SQLiteDatabase mDb;
	protected final Context context;

	public DatabaseAccess(Context ctx) {
		this.context = ctx;
		InstallDatabase();
	}

	protected OnDBInstalledListener onDBInstalledListener;

	public void setOnDBInstalledListener(OnDBInstalledListener onDBInstalledListener) {

		this.onDBInstalledListener = onDBInstalledListener;

	}

	public interface OnDBInstalledListener {

		void OnDBInstalled();

	}

	public void InstallDatabase() {
		BaseActivity.Log_info("----->  正在检查本地数据库....");
		open();

		mDb.execSQL("CREATE TABLE IF NOT EXISTS " + APPCode.DB_USER + "("
				+ "[uid] TEXT NOT NULL PRIMARY KEY  DEFAULT ('')," + "[acct] TEXT NOT NULL DEFAULT (''),"
				+ "[name] TEXT NOT NULL DEFAULT ('')," + "[psw] TEXT NOT NULL DEFAULT (''),"
				+ "[sex] INTEGER NOT NULL DEFAULT 0," + "[score] INTEGER NOT NULL DEFAULT 0,"
				+ "[phone] TEXT NOT NULL DEFAULT ('')," + "[addr] TEXT NOT NULL DEFAULT (''),"
				+ "[last] TEXT NOT NULL DEFAULT (''), " + "[head] TEXT NOT NULL DEFAULT ('') ,"
				+ "[auto] int NOT NULL DEFAULT 0  ," + "[from] int NOT NULL DEFAULT 0 ,"
				+ "[signed] int NOT NULL DEFAULT 1 " + ");");

		close();
	}

	public DatabaseAccess open() throws SQLException {

		if (mDbHelper == null)

			mDbHelper = new DatabaseHelper(context, APPCode.DATABASE, DATABASE_VERSION);

		if (mDb == null)

			mDb = mDbHelper.getWritableDatabase();

		if (!mDb.isOpen())

			mDb = mDbHelper.getWritableDatabase();

		return this;

	}

	public void close() {
		mDb.close();
		mDbHelper.close();
	}

	public void forceclose() {
		mDb.close();
		mDbHelper.close();
	}

	private static Map<Class, Class> basicMap = new HashMap<Class, Class>();
	static {
		basicMap.put(int.class, Integer.class);
		basicMap.put(long.class, Long.class);
		basicMap.put(float.class, Float.class);
		basicMap.put(double.class, Double.class);
		basicMap.put(boolean.class, Boolean.class);
		basicMap.put(byte.class, Byte.class);
		basicMap.put(short.class, Short.class);
	}

	public List executeQuery(String sql, Class clazz) {
		try {
			open();
			Cursor cursor = mDb.rawQuery(sql, null);
			if (cursor != null) {
				List tmp = cursor2VOList(cursor, clazz);
				// close();
				cursor.close();
				return tmp;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List cursor2VOList(Cursor c, Class clazz) {
		if (c == null) {
			return null;
		}
		List list = new LinkedList();
		Object obj;
		try {
			while (c.moveToNext()) {
				obj = setValues2Fields(c, clazz);
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR @cursor2VOList");
			return null;
		} finally {
			c.close();
		}
	}

	private static boolean isBasicType(Class typeClass) {
		if (typeClass.equals(Integer.class) || typeClass.equals(Long.class) || typeClass.equals(Float.class)
				|| typeClass.equals(Double.class) || typeClass.equals(Boolean.class) || typeClass.equals(Byte.class)
				|| typeClass.equals(Short.class) || typeClass.equals(String.class)) {

			return true;

		} else {
			return false;
		}
	}

	private static Object setValues2Fields(Cursor c, Class clazz) throws Exception {
		String[] columnNames = c.getColumnNames();
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field _field : fields) {
			if (Modifier.isFinal(_field.getModifiers()))
				continue;
			Class<? extends Object> typeClass = _field.getType();
			for (int j = 0; j < columnNames.length; j++) {
				String columnName = columnNames[j];
				typeClass = getBasicClass(typeClass);
				boolean isBasicType = isBasicType(typeClass);
				if (isBasicType) {
					if (columnName.equalsIgnoreCase(_field.getName())) {
						String _str = c.getString(c.getColumnIndex(columnName));
						if (_str == null) {
							break;
						}
						_str = _str == null ? "" : _str;
						FieldUtil.setValueToFiled(_field, obj, _str);
						break;
					}
				} /*
				 * else { Object obj2 = setValues2Fields(c, typeClass);// 
				 * _field.set(obj, obj2); break; }
				 */

			}
		}
		return obj;
	}

	@SuppressWarnings("all")
	private static Class<? extends Object> getBasicClass(Class typeClass) {
		Class _class = basicMap.get(typeClass);
		if (_class == null)
			_class = typeClass;
		return _class;
	}

}
