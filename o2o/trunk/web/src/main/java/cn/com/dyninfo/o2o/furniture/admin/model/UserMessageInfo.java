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

package cn.com.dyninfo.o2o.furniture.admin.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASE_MESSAGE_INFO")
public class UserMessageInfo implements Serializable {

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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserInfo user;//发出通知人
	
	@AccessType(value = "property")
	@Column(name="MESSAGE")
	private String message;//通知信息
	
	@AccessType(value = "property")
	@Column(name="TITLE")
	private String title;//消息标题
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//通知时间
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="message",cascade=CascadeType.ALL)
	private  List<AccaptMessageInfo> accaptList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AccaptMessageInfo> getAccaptList() {
		return accaptList;
	}

	public void setAccaptList(List<AccaptMessageInfo> accaptList) {
		this.accaptList = accaptList;
	}

}
