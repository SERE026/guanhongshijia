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

package cn.com.dyninfo.o2o.furniture.web.active.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

@Entity
@Table(name="T_ACTIVE")
public class Active implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ACTIVE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int active_id;
	
	@AccessType(value = "property")
	@Column(name="ROLE")
	private String role="MERCHANTS";//活动对象 ADMIN 平台 MERCHANTS 商家
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	

//	@AccessType(value = "property")
//	@Column(name="IMG")
//	private String img;//活动图片
	
	@AccessType(value = "property")
	@Column(name="BDATE")
	private String bdate;//活动开始日期
	
	@AccessType(value = "property")
	@Column(name="EDATE")
	private String edate;//活动结束日期
	
	@AccessType(value = "property")
	@Column(name="BTIME")
	private String btime;//活动开始时间
	
	@AccessType(value = "property")
	@Column(name="ETIME")
	private String etime;//活动结束时间
	
	@AccessType(value = "property")
	@Column(name="BTIMEL")
	private int btimel;//int 记载活动开始时间
	
	@AccessType(value = "property")
	@Column(name="ETIMEL")
	private int etimel;//int 记载活动结束时间
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private String type;//打折方式 1减少一定金额 2折扣金额
	
	@AccessType(value = "property")
	@Column(name="VAL")
	private Double val;//活动值，如果是减少一定金额 此值是金额 如果是打折 此值是折扣
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;//活动名称
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GAME_ID")
	private Game game;
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private int flag;//0打折促销 1游戏促销
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//活动介绍
	
	@AccessType(value = "property")
	@Column(name="GOODS_COUNT")
	private int count;//活动商品数量
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//1删除 0不删
	
	@AccessType(value = "property")
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinTable(name="T_ACTIVE_GOODS",joinColumns={@JoinColumn(name="ACT_ID")},inverseJoinColumns={@JoinColumn(name="GOODS_ID")})
	private List<Goods> goods;
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="act")
	@OrderBy(value="idnex asc ")
	private List<ActiveGoods> deatList;

	
	/**
	 * @return the goods
	 */
	public List<Goods> getGoods() {
		return goods;
	}

	/**
	 * @param goods the goods to set
	 */
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	

	/**
	 * @return the active_id
	 */
	public int getActive_id() {
		return active_id;
	}

	/**
	 * @param active_id the active_id to set
	 */
	public void setActive_id(int active_id) {
		this.active_id = active_id;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public int getBtimel() {
		return btimel;
	}

	public void setBtimel(int btimel) {
		this.btimel = btimel;
	}

	public int getEtimel() {
		return etimel;
	}

	public void setEtimel(int etimel) {
		this.etimel = etimel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the merchants
	 */
	public ShangJiaInfo getMerchants() {
		return merchants;
	}

	/**
	 * @param merchants the merchants to set
	 */
	public void setMerchants(ShangJiaInfo merchants) {
		this.merchants = merchants;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return "";
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		
	}

	/**
	 * @return the deatList
	 */
	public List<ActiveGoods> getDeatList() {
		return deatList;
	}

	/**
	 * @param deatList the deatList to set
	 */
	public void setDeatList(List<ActiveGoods> deatList) {
		this.deatList = deatList;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
