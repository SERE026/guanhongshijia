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

package cn.com.dyninfo.o2o.furniture.web.port.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 短信接口
 * @author lxf
 *
 */
@Entity
@Table(name="T_NOTE")
public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="NOTE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int note_id ;
	

	
	@AccessType("property")
	@Column(name="ADDRESS")
	private String address;//短信地址
	

	@AccessType("property")
	@Column(name="ACCOUT")
	private String accout;//帐户
	
	@AccessType("property")
	@Column(name="PASSWORD")
	private String password;//密码
	
	@AccessType("property")
	@Column(name="SENDMEN")
	private String sendmen;//发送人

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccout() {
		return accout;
	}

	public void setAccout(String accout) {
		this.accout = accout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSendmen() {
		return sendmen;
	}

	public void setSendmen(String sendmen) {
		this.sendmen = sendmen;
	}

	





}
