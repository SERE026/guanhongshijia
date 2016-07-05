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

package cn.com.dyninfo.o2o.furniture.android.model;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;

/**
 * android 广告表
 * @author FENG
 *	
 */
@Entity
@Table(name="T_AADV_INFO")
public class AadvInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aadv_id; 
	
	@AccessType(value = "property")
	@Column(name = "NAME")
	private String name;//名称
	
	@AccessType("property")
	@Column(name="ORDER_INDEX")
	private Integer orderIndex=9999;//排序
	
	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AADVWZ_ID")
	private AadvwzInfo aadvwz;//图片位置
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="adv")
	@OrderBy(value="orderIndex asc ")
	private List<AdvGoods> goods;
	
	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREA_ID")
	private AreaInfo city;
	
	@AccessType(value="property")
	@Column(name="IMG")
	private String img;//图片
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAadv_id() {
		return aadv_id;
	}

	public void setAadv_id(int aadv_id) {
		this.aadv_id = aadv_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AadvwzInfo getAadvwz() {
		return aadvwz;
	}

	public void setAadvwz(AadvwzInfo aadvwz) {
		this.aadvwz = aadvwz;
	}


	/**
	 * @return the goods
	 */
	public List<AdvGoods> getGoods() {
		return goods;
	}

	/**
	 * @param goods the goods to set
	 */
	public void setGoods(List<AdvGoods> goods) {
		this.goods = goods;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the city
	 */
	public AreaInfo getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(AreaInfo city) {
		this.city = city;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}


	}