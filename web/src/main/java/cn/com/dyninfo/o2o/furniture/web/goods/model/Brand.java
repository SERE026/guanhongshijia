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

package cn.com.dyninfo.o2o.furniture.web.goods.model;

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

/***
 *品牌
 * @author 008
 *
 */
@Entity
@Table(name="T_BRAND")
public class Brand {
	
	@Id
	@AccessType(value = "property")
	@Column(name="BRAND_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brand_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name="LOGO")
	private String logo;//品牌logo
	
	@AccessType(value = "property")
	@Column(name="T_INDEX")
	private int index;//品牌logo
	

	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	
	@AccessType(value = "property")
	@Column(name="PROVIDER")
	private String provider;//供应商
	
	@AccessType(value = "property")
	@Column(name="PROVIDER_PHONE")
	private String provider_phone;//供应商电话
	
	@AccessType(value = "property")
	@Column(name="PROVIDER_MOVABLE")
	private String provider_movable;//供应商移动电话
	
	@AccessType(value = "property")
	@Column(name="PROVIDER_ADDRESS")
	private String provider_address;//供商地址
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status; //0不删除 1删除
	
	@AccessType(value = "property")
	@Column(name="IS_R")
	private String isr="0"; // 1热销
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private String flag="0"; //0平台 1商家
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;

	@AccessType(value = "property")
	@Column(name="PAIXU")
	private String paixu="0";   //是否显示  0不显示 1显示
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getProvider_phone() {
		return provider_phone;
	}

	public void setProvider_phone(String provider_phone) {
		this.provider_phone = provider_phone;
	}

	public String getProvider_movable() {
		return provider_movable;
	}

	public void setProvider_movable(String provider_movable) {
		this.provider_movable = provider_movable;
	}

	public String getProvider_address() {
		return provider_address;
	}

	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
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

	/**
	 * @return the isr
	 */
	public String getIsr() {
		return isr;
	}

	/**
	 * @param isr the isr to set
	 */
	public void setIsr(String isr) {
		this.isr = isr;
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
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	public String getPaixu() {
		return paixu;
	}

	public void setPaixu(String paixu) {
		this.paixu = paixu;
	} 
	
	

}
