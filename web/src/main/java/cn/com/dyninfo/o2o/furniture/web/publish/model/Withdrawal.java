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

package cn.com.dyninfo.o2o.furniture.web.publish.model;

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

import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;

/**
 * 提现表
 * @author Administrator
 *
 */
@Entity
@Table(name="T_WITHDRAWAL")
public class Withdrawal {

	
	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@Column(name="MONEY")
	private Double money;
	
	@AccessType(value = "property")
	@Column(name="BANK_NAME")
	private String bankName;//开户行名称
	
	@AccessType(value = "property")
	@Column(name="BANK_NO")
	private String bankNo;//银行卡账号
	
	@AccessType(value = "property")
	@Column(name="USER_NAME")
	private String userName;//开户名称
	
	@AccessType(value = "property")
	@Column(name="STATE")
	private int state;//提款状态0申请中 1作废 2提款成功 
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time;//申请时间
	
	@AccessType(value = "property")
	@Column(name="C_TIME")
	private String ctime;//提款时间
	
	@AccessType(value = "property")
	@Column(name="NO")
	private String no;//交易流水号
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserInfo user;//处理人
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备注
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public ShangJiaInfo getMerchants() {
		return merchants;
	}

	public void setMerchants(ShangJiaInfo merchants) {
		this.merchants = merchants;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
}
