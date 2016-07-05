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

package cn.com.dyninfo.o2o.furniture.web.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

/**
 * 购物车
 * @author 王敏
 *
 */
@Entity
@Table(name="T_CARS_BOX")
public class CarsBox {
	
	@Id
	@AccessType(value = "property")
	@Column(name = "CARS_BOX_ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String cars_box_id;// id
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOOD_ID")
	private Goods goods;//货品
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo member; 
	
	@AccessType(value = "property")
	@Column(name = "NUM")
	private int num;//数量
	
	@AccessType(value = "property")
	@Column(name = "PRICE")
	private Double price=0.0;//单价
	
	@AccessType(value = "property")
	@Column(name = "SPEC_VAL")
	private String specVal;//名称
	
	
	@AccessType(value = "property")
	@Column(name = "ACT_INFO")
	private String actInfo;//活动信息

	/**
	 * @return the cars_box_id
	 */
	public String getCars_box_id() {
		return cars_box_id;
	}

	/**
	 * @param cars_box_id the cars_box_id to set
	 */
	public void setCars_box_id(String cars_box_id) {
		this.cars_box_id = cars_box_id;
	}

	

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the specVal
	 */
	public String getSpecVal() {
		return specVal;
	}

	/**
	 * @param specVal the specVal to set
	 */
	public void setSpecVal(String specVal) {
		this.specVal = specVal;
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
	 * @return the actInfo
	 */
	public String getActInfo() {
		return actInfo;
	}

	/**
	 * @param actInfo the actInfo to set
	 */
	public void setActInfo(String actInfo) {
		this.actInfo = actInfo;
	}
}
