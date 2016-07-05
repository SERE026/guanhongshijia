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

package cn.com.dyninfo.o2o.furniture.web.league.model;

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
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;

/**
 * 商家入驻申请
 * @author Administrator
 *
 */
@Entity
@Table(name="T_MERCHANTS_APPLY")
public class MerchantsApply {

	@Id
	@AccessType(value = "property")
	@Column(name="MERCHANTS_APPLY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int merchants_apply_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STORE_TYPE")
	private MerchantType storeType;//店铺类型
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUS_TYPE")
	private BusinessType busType;//经营类型
	
	@AccessType(value = "property")
	@Column(name="CONTATCT_MAN")
	private String contactMan;
	
	@AccessType(value = "property")
	@Column(name="CONTATCT_TEL")
	private String contactTel;
	
	@AccessType(value = "property")
	@Column(name="CONTATCT_PHONE")
	private String contactPhone;
	
	@AccessType(value = "property")
	@Column(name="CONTATCT_EMAIL")
	private String contactEmail;
	
	@AccessType(value = "property")
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROVINCE_ID")
	private AreaInfo province;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CITY_ID")
	private AreaInfo city;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNT_ID")
	private AreaInfo county;
	
	@AccessType(value = "property")
	@Column(name="ADDRESS")
	private String address;
	
	@AccessType(value = "property")
	@Column(name="STATE")
	private String state="0";//0 不删 1删除

	public int getMerchants_apply_id() {
		return merchants_apply_id;
	}

	public void setMerchants_apply_id(int merchants_apply_id) {
		this.merchants_apply_id = merchants_apply_id;
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

	public String getContactMan() {
		return contactMan;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public AreaInfo getProvince() {
		return province;
	}

	public void setProvince(AreaInfo province) {
		this.province = province;
	}

	public AreaInfo getCity() {
		return city;
	}

	public void setCity(AreaInfo city) {
		this.city = city;
	}

	public AreaInfo getCounty() {
		return county;
	}

	public void setCounty(AreaInfo county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the storeType
	 */
	public MerchantType getStoreType() {
		return storeType;
	}

	/**
	 * @param storeType the storeType to set
	 */
	public void setStoreType(MerchantType storeType) {
		this.storeType = storeType;
	}

	/**
	 * @return the busType
	 */
	public BusinessType getBusType() {
		return busType;
	}

	/**
	 * @param busType the busType to set
	 */
	public void setBusType(BusinessType busType) {
		this.busType = busType;
	}

	/**
	 * @return the contactTel
	 */
	public String getContactTel() {
		return contactTel;
	}

	/**
	 * @param contactTel the contactTel to set
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
}
