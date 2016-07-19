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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 短信 邮件信息表
 * @author 王敏
 *
 */
@Entity
@Table(name="T_MESSAGE_INFO")
public class MessageInfo {

	@Id
	@AccessType(value="property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@AccessType("property")
	@Column(name="MSG")
	private String msg;//发送内容
	
	@AccessType("property")
	@Column(name="STATUS")
	private int status;//发送状态
	
	@AccessType("property")
	@Column(name="TIME")
	private String time;//发送时间
	
	@AccessType("property")
	@Column(name="TITLE")
	private String title;//主题
	
	@AccessType("property")
	@Column(name="FLAG")
	private String flag;//0短信 1邮件 
	
	@AccessType("property")
	@Column(name="REVC_NAME")
	private String revcName;//接收人
	
	@AccessType("property")
	@Column(name="REVC_INFO")
	private String revcInfo;//接收人信息

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the revcName
	 */
	public String getRevcName() {
		return revcName;
	}

	/**
	 * @param revcName the revcName to set
	 */
	public void setRevcName(String revcName) {
		this.revcName = revcName;
	}

	/**
	 * @return the revcInfo
	 */
	public String getRevcInfo() {
		return revcInfo;
	}

	/**
	 * @param revcInfo the revcInfo to set
	 */
	public void setRevcInfo(String revcInfo) {
		this.revcInfo = revcInfo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
