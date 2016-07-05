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

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

@Entity
@Table(name="T_ADV_GOODS")
public class AdvGoods  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;
	
	@AccessType("property")
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private AreaInfo city;

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADV_ID")
	private AadvInfo adv;
	
	@AccessType("property")
	@Column(name="ORDER_INDEX")
	private int orderIndex=0;

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
	 * @return the adv
	 */
	public AadvInfo getAdv() {
		return adv;
	}

	/**
	 * @param adv the adv to set
	 */
	public void setAdv(AadvInfo adv) {
		this.adv = adv;
	}

	/**
	 * @return the orderIndex
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * @param orderIndex the orderIndex to set
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
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
	
	
}
