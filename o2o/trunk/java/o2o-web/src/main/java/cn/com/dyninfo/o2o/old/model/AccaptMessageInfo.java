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
package cn.com.dyninfo.o2o.old.model;

import java.io.Serializable;

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
 *	Feb 20, 2012
 */
@Entity
@Table(name="BASE_ACCAPT_MESSAGE_INFO")
public class AccaptMessageInfo implements Serializable {

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
	@JoinColumn(name="MESSAGE_ID")
	private UserMessageInfo message;
	
	@AccessType(value = "property")
	@Column(name="IDS")
	private String ids;   
	
	@AccessType(value = "property")
	@Column(name="TITLE")
	private String title;
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time;
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status="0";
	
	@AccessType(value = "property")
	@Column(name="CONTEXT")
	private String context;
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private String type="0";//0消息类型 0 用户消息 1系统消息 2自定义消息 备忘录
	
	@AccessType(value = "property")
	@Column(name="STATU")
	private String statu="0";  //0没看 1看了

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserMessageInfo getMessage() {
		return message;
	}

	public void setMessage(UserMessageInfo message) {
		this.message = message;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}
}
