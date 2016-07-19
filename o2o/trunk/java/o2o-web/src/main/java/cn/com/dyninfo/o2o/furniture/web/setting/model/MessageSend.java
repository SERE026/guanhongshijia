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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.Goods;
/**
 * @author 消息推送
 *	Oct 8, 2011
 */
@Entity
@Table(name="T_MESSAGESEND")
public class MessageSend {
	
	@Id
	@AccessType(value = "property")
	@Column(name="MESSAGESEND_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int messagesend_id;//ID
	
	
	@AccessType(value = "property")
	@Column(name="TITLE")
	private String title;//标题
	
	@AccessType(value = "property")
	@Column(name="SYS_TIME")
	private String sys_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status="0"; //删除 0未删除 1删除
	
	@AccessType(value = "property")
	@Column(name="CONTEXT")
	private String context;//内容
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserInfo user;//操作人

	@AccessType(value = "property")
	@Column(name="UID")
	private String uid;//用户收藏的id
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;//商品
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVE_ID")
	private Active active;//活动
	
	
	public Active getActive() {
		return active;
	}


	public void setActive(Active active) {
		this.active = active;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public int getMessagesend_id() {
		return messagesend_id;
	}


	public void setMessagesend_id(int messagesendId) {
		messagesend_id = messagesendId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSys_time() {
		return sys_time;
	}


	public void setSys_time(String sysTime) {
		sys_time = sysTime;
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


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
	
	
	
}
