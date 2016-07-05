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

package cn.com.dyninfo.o2o.furniture.bean;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import cn.com.dyninfo.o2o.furniture.db.DBPreferBeanHelper;
import cn.com.dyninfo.o2o.furniture.util.APP;
import cn.com.dyninfo.o2o.furniture.util.APPCode;
import cn.com.dyninfo.o2o.furniture.util.DESUtil;
import cn.com.dyninfo.o2o.furniture.util.MyDate;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @update 2014-6-24 17:14:57
 */
public class LocalUser extends DBPreferBeanHelper {

	public String uid = "";
	public String acct = "";
	public String name = "";
	public String psw = "";
	public int sex = 0;
	public int score = 0; // 积分
	public String phone = "";
	public String addr = "";
	public String last = "";
	public String head = "";
	/** 自动登录：0，当前登录有效：1，退出登录：2 */
	public int auto = 0;
	/** 炫品账户：0，QQ登录：1 */
	public int from = 0;
	/** 当前账户是否在登录中：0 是，其它否 */
	public int signed = 1;

	public void init(Context context) {
		super.init(context);
		super.setTableName(APPCode.DB_USER, null);
		addPrimaryKey("uid");
	}

	public LocalUser() {
	}

	public LocalUser(Context context) {
		init(context);
	}

	public LocalUser(Context context, String uid, String acct, String name, String psw, int sex, int score,
			String phone, String addr, String last, String head, int from, int signed) {
		this.uid = uid;
		this.name = name;
		this.acct = acct;
		this.psw = psw;
		this.sex = sex;
		this.score = score;
		this.phone = phone;
		this.addr = addr;
		this.last = last;
		this.head = head;
		this.from = from;
		init(context);
	}

	/** 根据主键更新用户账户信息 */
	public boolean updateLocalUser() {
		try {
			updateAll();
		} catch (Exception e) {
			APP.exception(" LocalUser ", e);
			return false;
		}
		return true;
	}

	public LocalUser getDBUser(String uid) {
		setTableName(APPCode.DB_USER, null);
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("uid", uid);
		loadFromDB(where);
		return this;
	}

	public LocalUser getLastUser() {
		setTableName(APPCode.DB_USER, null);
		loadFromDB(null, " ORDER BY last DESC ", false);
		return this;
	}

	/**
	 * @Description 登录成功后，存储到本地，记得存储密码
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public void json2db(String json, Context context) throws JSONException {
		JSONObject object = new JSONObject(json).getJSONObject("data");

		// 2014-7-18 16:49:27 区分是QQ登录还是普通登录
		// QQ 登录
		if (object.has("huiYuan_id")) {
			// this.acct = object.getString("qqid"); // open id
			this.acct = "";
			this.name = object.getString("userName");
			this.uid = object.getString("huiYuan_id");
			this.from = 1;
		} else
		// 普通登录
		// {"status":0,"accout":"237262911@qq.com","name":"月月姑娘","txImage":"1401786100484.jpg","jf":0}
		if (object.has("uid")) {
			this.acct = object.getString("accout"); // account 写错
			this.name = object.getString("name");
			this.uid = object.getString("uid");
			this.from = 0;
		}
		this.last = MyDate.getTimestamp() + "";
		this.signed = 0;
		this.score = object.getInt("jf");
		this.head = APP.head_path(object.getString("txImage"));
	}

	@Override
	public String toString() {
		String psw_decode = "";
		if (!psw.isEmpty()) {
			psw_decode = DESUtil.decode(psw);
		}
		return "LocalUser [acct =" + acct + ", uid =" + uid + ", name =" + name + ", psw=" + psw + ", sex=" + sex
				+ ", score=" + score + ", phone=" + phone + ", addr=" + addr + ", last=" + last + ", head=" + head
				+ ", auto=" + auto + ",  psw_decode = " + psw_decode + "，from = " + from + "，signed = " + signed
				+ "  ]";
	}
}
