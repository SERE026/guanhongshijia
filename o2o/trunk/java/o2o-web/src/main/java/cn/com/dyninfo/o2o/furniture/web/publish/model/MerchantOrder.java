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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="T_MERCHANT_ORDER")
public class MerchantOrder {

	
	@Id
	@AccessType(value = "property")
	@Column(name="MERCHANT_ORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int merchant_order_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="order",cascade=CascadeType.ALL)
	private List<MerchantOrderInfo> moiList;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the moiList
	 */
	public List<MerchantOrderInfo> getMoiList() {
		return moiList;
	}

	/**
	 * @param moiList the moiList to set
	 */
	public void setMoiList(List<MerchantOrderInfo> moiList) {
		this.moiList = moiList;
	}
	
	
}
