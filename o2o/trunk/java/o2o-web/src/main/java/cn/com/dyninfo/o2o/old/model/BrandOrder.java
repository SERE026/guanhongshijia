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

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/**
 * 品牌排序
 * @author Administrator
 *
 */
@Entity
@Table(name="T_BRAND_ORDER")
public class BrandOrder {
	
	@Id
	@AccessType(value = "property")
	@Column(name="BRAND_ORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandOrderId;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BRAND_ID")
	private Brand brand;;
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	private AreaInfo city;
	
	@AccessType(value = "property")
	@Column(name="INDEXS")
	private String indexs;//序号
	

	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BRAND_MERCHANTS_ID")
	private ShangJiaInfo brandMerchants;//品牌商家
	
	public ShangJiaInfo getBrandMerchants() {
		return brandMerchants;
	}

	public void setBrandMerchants(ShangJiaInfo brandMerchants) {
		this.brandMerchants = brandMerchants;
	}

	public int getBrandOrderId() {
		return brandOrderId;
	}

	public void setBrandOrderId(int brandOrderId) {
		this.brandOrderId = brandOrderId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public AreaInfo getCity() {
		return city;
	}

	public void setCity(AreaInfo city) {
		this.city = city;
	}

	public String getIndexs() {
		return indexs;
	}

	public void setIndexs(String indexs) {
		this.indexs = indexs;
	} 
}
