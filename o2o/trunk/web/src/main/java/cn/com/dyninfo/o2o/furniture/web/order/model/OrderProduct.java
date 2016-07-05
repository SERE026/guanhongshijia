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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Product;

@Entity
@Table(name="T_ORDER_PRODUCT")
public class OrderProduct {

	@Id
	@AccessType(value = "property")
	@Column(name="ORDER_PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_product_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;//订单
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;//产品
	
	@AccessType(value = "property")
	@Column(name = "GOOD_MONEY")
	private Double goodMoney;//购买时产品价格
	
	@AccessType(value = "property")
	@Column(name = "GOOD_NUM")
	private Integer num;//购买数量
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACT_ID")
	private Active act;//参加的活动
	
	@AccessType(value = "property")
	@Column(name = "WIDGET")
	private Double widget;//商品重量
	
	@AccessType(value = "property")
	@Column(name = "ACT_MONEY")
	private Double actMoney;//活动金额
	
	@AccessType(value = "property")
	@Column(name = "GOODS_SPEC")
	private String goodSpec;//购买的商品属性 以#分开

	
	@AccessType(value = "property")
	@Column(name = "SHOW_STATS")
	private String showstats="0";//是否晒单 0.没有 1.晒了
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACT_Game_ID")
	private ActiveMemberInfo ami;
	
	/**
	 * @return the ami
	 */
	public ActiveMemberInfo getAmi() {
		return ami;
	}

	/**
	 * @param ami the ami to set
	 */
	public void setAmi(ActiveMemberInfo ami) {
		this.ami = ami;
	}

	public String getShowstats() {
		return showstats;
	}

	public void setShowstats(String showstats) {
		this.showstats = showstats;
	}

	/**
	 * @return the order_product_id
	 */
	public int getOrder_product_id() {
		return order_product_id;
	}

	/**
	 * @param order_product_id the order_product_id to set
	 */
	public void setOrder_product_id(int order_product_id) {
		this.order_product_id = order_product_id;
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the goodMoney
	 */
	public Double getGoodMoney() {
		return goodMoney;
	}

	/**
	 * @param goodMoney the goodMoney to set
	 */
	public void setGoodMoney(Double goodMoney) {
		this.goodMoney = goodMoney;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
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
	 * @return the widget
	 */
	public Double getWidget() {
		return widget;
	}

	/**
	 * @param widget the widget to set
	 */
	public void setWidget(Double widget) {
		this.widget = widget;
	}

	/**
	 * @return the actMoney
	 */
	public Double getActMoney() {
		return actMoney;
	}

	/**
	 * @param actMoney the actMoney to set
	 */
	public void setActMoney(Double actMoney) {
		this.actMoney = actMoney;
	}

	/**
	 * @return the goodSpec
	 */
	public String getGoodSpec() {
		return goodSpec;
	}

	/**
	 * @param goodSpec the goodSpec to set
	 */
	public void setGoodSpec(String goodSpec) {
		this.goodSpec = goodSpec;
	}
}
