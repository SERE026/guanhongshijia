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

@Entity
@Table(name="T_BBS_POST_INFO")
public class BbsPostInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1223395410407952074L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private BbsUserInfo user;//作者
	
	@AccessType(value = "property")
	@Column(name="TITLE")
	private String title;//主题
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID")
	private BbsPostInfo parent;//主贴
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private int flag;//0公告 1网站活动 2自由发帖
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private int type;//0主贴 1回帖
	
	@AccessType(value = "property")
	@Column(name="CONTEXT")
	private String context;//内容
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time;//时间
	
	@AccessType(value = "property")
	@Column(name="HTIME")
	private String htime;//最后回复时间
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUSER_ID")
	private BbsUserInfo hname;//最后回复人
	
	@AccessType(value = "property")
	@Column(name="HNUM")
	private int hnum=0;//回复数量
	
	@AccessType(value = "property")
	@Column(name="SNUM")
	private int snum=0;//查看数量
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//0审核中 1审核通过 2删除
	
	@AccessType(value = "property")
	@Column(name="TOP")
	private int top=0;//1置顶 0非置顶

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public BbsUserInfo getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(BbsUserInfo user) {
		this.user = user;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the parent
	 */
	public BbsPostInfo getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(BbsPostInfo parent) {
		this.parent = parent;
	}


	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the htime
	 */
	public String getHtime() {
		return htime;
	}

	/**
	 * @param htime the htime to set
	 */
	public void setHtime(String htime) {
		this.htime = htime;
	}


	/**
	 * @return the hname
	 */
	public BbsUserInfo getHname() {
		return hname;
	}

	/**
	 * @param hname the hname to set
	 */
	public void setHname(BbsUserInfo hname) {
		this.hname = hname;
	}

	/**
	 * @return the hnum
	 */
	public int getHnum() {
		return hnum;
	}

	/**
	 * @param hnum the hnum to set
	 */
	public void setHnum(int hnum) {
		this.hnum = hnum;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the snum
	 */
	public int getSnum() {
		return snum;
	}

	/**
	 * @param snum the snum to set
	 */
	public void setSnum(int snum) {
		this.snum = snum;
	}

	/**
	 * @return the top
	 */
	public int getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(int top) {
		this.top = top;
	}
	
	
	
	
}
