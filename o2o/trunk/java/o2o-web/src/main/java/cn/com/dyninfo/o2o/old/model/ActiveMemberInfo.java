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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

/**
 * 会员游戏记录
 * @author 王敏
 *
 */
@Entity
@Table(name="T_ACTIVE_MEMBER_INFO")
public class ActiveMemberInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ACT_MEB_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int act_meb_id;
	
	@AccessType(value = "property")
	@Column(name="LEV")
	private int lev;//游戏等级
	
	
	@AccessType(value = "property")
	@Column(name="MONEY")
	private Double money;//获得优惠
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEBER_ID")
	private HuiyuanInfo member;//会员
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACT_ID")
	private Active act;//游戏
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOOD_ID")
	private Goods goods;//产品
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String  time;//游戏时间
	
	@AccessType(value = "property")
	@Column(name="DATE")
	private String  date;//游戏日期
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备足

	/**
	 * @return the act_meb_id
	 */
	public int getAct_meb_id() {
		return act_meb_id;
	}

	/**
	 * @param act_meb_id the act_meb_id to set
	 */
	public void setAct_meb_id(int act_meb_id) {
		this.act_meb_id = act_meb_id;
	}

	/**
	 * @return the lev
	 */
	public int getLev() {
		return lev;
	}

	/**
	 * @param lev the lev to set
	 */
	public void setLev(int lev) {
		this.lev = lev;
	}

	/**
	 * @return the money
	 */
	public Double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Double money) {
		this.money = money;
	}

	/**
	 * @return the member
	 */
	public HuiyuanInfo getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(HuiyuanInfo member) {
		this.member = member;
	}

	/**
	 * @return the act
	 */
	public Active getAct() {
		return act;
	}

	/**
	 * @param act the act to set
	 */
	public void setAct(Active act) {
		this.act = act;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
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
	
	
	
}
