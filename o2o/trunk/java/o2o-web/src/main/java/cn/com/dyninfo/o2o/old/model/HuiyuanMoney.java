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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
/**
 * 会员流水信息
 * @author 王敏
 *
 */
@Entity
@Table(name="T_HUIYUAN_MONEY")
public class HuiyuanMoney {
	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private int flag;//0 支出 1收入 

	@AccessType(value = "property")
	@Column(name="MONEY")
	private double money;//交易金额
	
	@AccessType(value = "property")
	@Column(name="DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;//交易日期
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备注
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private Order order;//订单信息
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;//会员信息

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
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the ps
	 */
	public String getPs() {
		return ps;
	}

	/**
	 * @param ps the ps to set
	 */
	public void setPs(String ps) {
		this.ps = ps;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the huiyuan
	 */
	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}

	/**
	 * @param huiyuan the huiyuan to set
	 */
	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
