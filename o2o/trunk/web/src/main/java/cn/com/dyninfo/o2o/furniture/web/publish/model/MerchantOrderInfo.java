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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="T_MERCHANT_ORDER_INFO")
public class MerchantOrderInfo {

	@Id
	@AccessType(value = "property")
	@Column(name="MERCHANT_ORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int merchant_order_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID")
	private ShangJiaInfo merchant;;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private MerchantOrder order;
	
	@AccessType(value = "property")
	@Column(name="T_INDEX")
	private int index;

	/**
	 * @return the merchant_order_id
	 */
	public int getMerchant_order_id() {
		return merchant_order_id;
	}

	/**
	 * @param merchant_order_id the merchant_order_id to set
	 */
	public void setMerchant_order_id(int merchant_order_id) {
		this.merchant_order_id = merchant_order_id;
	}

	/**
	 * @return the merchant
	 */
	public ShangJiaInfo getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(ShangJiaInfo merchant) {
		this.merchant = merchant;
	}

	/**
	 * @return the order
	 */
	public MerchantOrder getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(MerchantOrder order) {
		this.order = order;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
