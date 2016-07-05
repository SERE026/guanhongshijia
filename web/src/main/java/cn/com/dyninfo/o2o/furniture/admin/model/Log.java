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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author 王敏
 *	Oct 8, 2011
 */
@Entity
@Table(name="BASE_LOG")
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//ID
	
	@AccessType(value = "property")
	
	private String ip;
	
	@AccessType(value = "property")
	@Column(name="TARGET")
	private String  target;//目标
	
	@AccessType(value = "property")
	@Column(name="OBJECT")
	private String  object;//对象
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@AccessType(value = "property")
	@Column(name="INFO")
	private String info;//记录信息
	
	

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserInfo user;//对应用户

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
}
