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

@Entity
@Table(name="T_ACTIVE_GOODS")
public class ActiveGoods {

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACT_ID")
	private Active act;
	
	@AccessType(value = "property")
	@Column(name="ORDER_INDEX")
	private int idnex=999999;
	
	
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
	 * @return the idnex
	 */
	public int getIdnex() {
		return idnex;
	}

	/**
	 * @param idnex the idnex to set
	 */
	public void setIdnex(int idnex) {
		this.idnex = idnex;
	}
}
