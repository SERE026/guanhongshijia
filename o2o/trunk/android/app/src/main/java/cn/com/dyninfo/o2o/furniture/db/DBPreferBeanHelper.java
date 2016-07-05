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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import cn.com.dyninfo.o2o.furniture.activity.BaseActivity;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.FieldUtil;
import cn.com.dyninfo.o2o.furniture.util.PreferenceBeanHelper;
import android.content.Context;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-6-3 16:22:03
 */
public abstract class DBPreferBeanHelper extends PreferenceBeanHelper {
	protected DatabaseApi dbApi = null;
	// protected String TableName = APPCode.DB_USER;
	protected String TableName = this.getClass().getSimpleName();
	protected Set<String> tablePrimary = new HashSet<String>();

	public void init(Context context) {
		super.init(context);
		dbApi = DatabaseApi.getDataBaseApi(context);
	}

	public String getTableName() {
		return TableName;
	}

	public void setTableName(String tableName, String create) {
		if (create != null && !create.equals("")) {
			dbApi.open();
			dbApi.mDb.execSQL(create);
			dbApi.close();
		}
		TableName = tableName;
	}

	public void updateAll() throws Exception {
		BaseActivity.Log_info("-----> 正在更新本地登录信息....");
		updatePreferAll();
		Map<String, Object> setMap = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				setMap.put(field.getName(), FieldUtil.getFieldValue(field, this));
		}
		updateDB(setMap, false);
	}

	public void update() throws Exception {
		Map<String, Object> setMap = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				setMap.put(field.getName(), FieldUtil.getFieldValue(field, this));
		}
		updateDB(setMap, false);
	}

	public void update(String field, Object value) throws Exception {

		updatePrefer(field, value);
		Map<String, Object> setMap = new HashMap<String, Object>();
		setMap.put(field, value);
		updateDB(setMap, true);

	}

	public void loadFromDB(Map<String, Object> where, String extra, boolean pref) {
		try {
			String sql = "SELECT * FROM " + TableName;
			if (where != null && where.size() > 0) {
				sql += (" WHERE " + getPriWhereSQL(where));
			}
			if (extra != null) {
				sql += (" " + extra);
			}
			BaseActivity.Log_info(sql);
			List all = dbApi.executeQuery(sql, this.getClass());
			if (all.size() > 0) {
				APP.copyto(all.get(0), this);
				if (pref)
					updatePreferAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadFromDB(Map<String, Object> where) {
		try {

			String sql = "SELECT * FROM " + TableName + " WHERE " + getPriWhereSQL(where);

			BaseActivity.Log_info(sql);
			List list = dbApi.executeQuery(sql, this.getClass());
			if (list.size() > 0) {
				APP.copyto(list.get(0), this);
				updatePreferAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execSql(String sql) {
		dbApi.open();
		dbApi.mDb.execSQL(sql);
		dbApi.close();
	}

	public void delete() {
		try {
			List<String> where = new LinkedList<String>();
			for (String key : tablePrimary) {
				Field keyfield = this.getClass().getDeclaredField(key);
				keyfield.setAccessible(true);
				String value = FieldUtil.getFieldValue(keyfield, this).toString();
				where.add(key + "='" + value + "'");
			}
			String sql = "DELETE FROM " + TableName + " WHERE " + APP.implode(where, " AND ");
			dbApi.open();
			dbApi.mDb.execSQL(sql);
			dbApi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPrimaryKey(String key) {
		tablePrimary.add(key);
	}

	public void remobePrimaryKey(String key) {
		tablePrimary.remove(key);
	}

	protected void updateDB(Map<String, Object> setMap, boolean update) throws Exception {
		dbApi.open();
		String sql = "";
		if (!update) {
			List<String> name = new LinkedList<String>();
			List<String> values = new LinkedList<String>();
			for (String key : setMap.keySet()) {
				Object value = setMap.get(key);
				name.add(key);
				values.add(value.toString());
			}

			for (String key : tablePrimary) {
				if (!setMap.keySet().contains(key)) {
					Field keyfield = this.getClass().getDeclaredField(key);
					keyfield.setAccessible(true);
					String value = FieldUtil.getFieldValue(keyfield, this).toString();
					name.add(key);
					values.add(value);
				}
			}
			sql = "REPLACE INTO " + TableName + " (" + APP.sImplode(name) + ") VALUES (" + APP.sImplode(values) + ")";
		} else {
			List<String> set = new LinkedList<String>();
			List<String> where = new LinkedList<String>();
			for (String key : setMap.keySet()) {
				String value = setMap.get(key).toString();
				set.add(key + "='" + APP.formatSqlValue(value) + "'");
			}
			for (String key : tablePrimary) {
				Field keyfield = this.getClass().getDeclaredField(key);
				keyfield.setAccessible(true);
				String value = FieldUtil.getFieldValue(keyfield, this).toString();
				where.add(key + "='" + value + "'");
			}
			sql = "UPDATE " + TableName + " SET " + APP.implode(set, ",") + " WHERE " + APP.implode(where, " AND ");
		}
		dbApi.mDb.execSQL(sql);
		dbApi.close();
	}

	private String getPriWhereSQL(Map<String, Object> limit) throws Exception {
		String where = "";
		for (String key : limit.keySet()) {
			if (!"".equals(where)) {
				where += " AND ";
			}
			where += (" " + key + "='" + limit.get(key).toString() + "' ");
		}
		return where;
	}

}