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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;

/**
 * 配送费用
 * @author 王敏
 *
 */
@Entity
@Table(name="T_GOODS_DELIVERY")
public class GoodsDelivery {

	@Id
	@AccessType(value = "property")
	@Column(name="DELIVER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int delivery_id;
	
	@AccessType(value = "property")
	@Column(name="DELIVERY")
	private String delivery;//配送方式 0指定配送费 1快递配置
	
	@AccessType(value = "property")
	@Column(name="DELIVERY_FLAG")
	private String deliveryFlag = "2";//0 包邮 1指定费用 2默认快递 3指定快递
	
	@AccessType(value = "property")
	@Column(name="DELIVERY_MONEY")
	private Double deliveryMoney;//指定配送费用
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="T_GOODS")
	private Goods goods;//产品
	
	
	@AccessType(value = "property")
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinTable(name="T_DELIVER_DLY",joinColumns={@JoinColumn(name="DELIVER_ID")},inverseJoinColumns={@JoinColumn(name="DLY_ID")})
	private List<Dlytype> dlyList;//指定快递

	/**
	 * @return the delivery_id
	 */
	public int getDelivery_id() {
		return delivery_id;
	}

	/**
	 * @param delivery_id the delivery_id to set
	 */
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	/**
	 * @return the delivery
	 */
	public String getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the deliveryFlag
	 */
	public String getDeliveryFlag() {
		return deliveryFlag;
	}

	/**
	 * @param deliveryFlag the deliveryFlag to set
	 */
	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}

	/**
	 * @return the deliveryMoney
	 */
	public Double getDeliveryMoney() {
		return deliveryMoney;
	}

	/**
	 * @param deliveryMoney the deliveryMoney to set
	 */
	public void setDeliveryMoney(Double deliveryMoney) {
		this.deliveryMoney = deliveryMoney;
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
	 * @return the dlyList
	 */
	public List<Dlytype> getDlyList() {
		return dlyList;
	}

	/**
	 * @param dlyList the dlyList to set
	 */
	public void setDlyList(List<Dlytype> dlyList) {
		this.dlyList = dlyList;
	}
	
}
