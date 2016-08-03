package com.wckj.gfsj.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wckj.gfsj.GlobalUtils;

/**
 * 数据库辅助类
 * 
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	public DBHelper(Context context) {
		super(context, GlobalUtils.DB_Name, null, GlobalUtils.DB_CODE);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 当数据库被首次创建时执行该方法
	 */
	@Override
	public void onCreate(SQLiteDatabase sqlite) {// 之前不存在时调用
		// 创建用户json缓存字段
		sqlite.execSQL("create table commonjson(_id integer primary key autoincrement,url text,json text,time text)");
	}

	/**
	 * 当打开数据库时传入的版本号与当前的版本号不同时会调用该方法。
	 */
	
	@Override
	public void onUpgrade(SQLiteDatabase sqlite, int oldVersion, int newVersion) {
		int upgradeVersion = oldVersion;

	}

	/**
	 * 关闭任何打开的数据库对象。
	 */
	@Override
	public synchronized void close() {
		// TODO Auto-generated method stub
		super.close();
	}

}
