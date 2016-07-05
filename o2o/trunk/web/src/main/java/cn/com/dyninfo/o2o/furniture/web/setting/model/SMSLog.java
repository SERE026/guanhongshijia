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

package cn.com.dyninfo.o2o.furniture.web.setting.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 短信验证码日志
 * @author Zebe
 * @date 2014/4/29
 *
 */
@Entity
@Table(name="T_SMS_LOG")
public class SMSLog {

	@Id
	@AccessType(value = "property")
	@Column(name="SMS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int sms_id;
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // 记录时间
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private int type; // 类型 0注册时手机验证 1手机修改密码验证
	
	@AccessType(value = "property")
	@Column(name="PHONE")
	private String phone; // 电话
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps; // 备注

	public int getSms_id() {
		return sms_id;
	}

	public void setSms_id(int sms_id) {
		this.sms_id = sms_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}


	
}
