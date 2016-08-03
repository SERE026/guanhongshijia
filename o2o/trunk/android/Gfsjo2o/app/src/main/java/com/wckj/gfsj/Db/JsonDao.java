package com.wckj.gfsj.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class JsonDao {
	private DBHelper dbhelper;
	private SQLiteDatabase db;
	private String tableName = "commonjson";

	public JsonDao(Context context) {
		dbhelper = new DBHelper(context);
		db = dbhelper.getReadableDatabase();
	}

	/**
	 * 增加
	 * 
	 * @param url
	 * @param json
	 */
	public void insertJson(String url, String json,long time) {
		db.delete(tableName, "url=?", new String[] { url });
		ContentValues in = new ContentValues();
		in.put("url", url);
		in.put("json", json);
		in.put("time", time);
		db.insert(tableName, null, in);
	}

	/**
	 * 获得json
	 * 
	 * @param url
	 * @return
	 */
	public String getJsonByUrl(String url) {
		Cursor cursor = db.query(tableName, null, "url=?",
				new String[] { url }, null, null, null);
		String json = null;
		while (cursor.moveToNext()) {
			json = cursor.getString(cursor.getColumnIndex("json"));
		}
		return json;
	}
	/**
	 * 获得时间
	 * 
	 * @param url
	 * @return
	 */
	public int getTimeByUrl(String url) {
		Cursor cursor = db.query(tableName, null, "url=?",
				new String[] { url }, null, null, null);
		int  time = 0 ;
		while (cursor.moveToNext()) {
			time = cursor.getInt(cursor.getColumnIndex("time"));
		}
		return time;
	}
	/**
	 * 删除
	 * 
	 * @param url
	 */
	public void deleteJson(String url) {
		db.delete(tableName, "url=?", new String[] { url });
	}
	/**
	 * 删除所有得缓存
	 */
	public void deleteJson() {
		db.execSQL("delete from commonjson");
		closeDb();
	}

	/**
	 * 关闭
	 */
	public void closeDb() {
		dbhelper.close();
	}
}
