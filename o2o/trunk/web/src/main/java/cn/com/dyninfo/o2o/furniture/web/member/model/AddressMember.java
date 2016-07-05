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

package cn.com.dyninfo.o2o.furniture.web.member.model;

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

@Entity
@Table(name="T_ADDRESS_MEMBER")
public class AddressMember {

	  @Id
	  @AccessType(value="property")
	  @Column(name="ADDRESS_ID")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int address_id;
	 
	  @AccessType(value="property")
	  @Column(name="RECEIVE_NAME")
	  private String receiveName;//收件人姓名
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_TEL")
	  private String receiveTel;//收件人电话
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_PHONE")
	  private String receivePhone;//收件人手机
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "PROVINCE_ID")
	  private AreaInfo province;
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "CITY_ID")
	  private AreaInfo city;
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "COUNTY_ID")
	  private AreaInfo county;
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_ADDRESS")
	  private String address;//街道地址
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_CODE")
	  private String code; //邮政编码
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_status")
	  private int status=0;
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "MEMBER_ID")
	  private HuiyuanInfo member; //会员
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_EMAIL")
	  private String email;
	  
	  @AccessType(value="property")
	  @Column(name="IS_DEFAULT")
	  private int isdefault=0;//是否默认 0为不默认 1为默认
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_DATE")
	  private String receiveDate;

	/**
	 * @return the address_id
	 */
	public int getAddress_id() {
		return address_id;
	}

	/**
	 * @param address_id the address_id to set
	 */
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	/**
	 * @return the receiveName
	 */
	public String getReceiveName() {
		return receiveName;
	}

	/**
	 * @param receiveName the receiveName to set
	 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	/**
	 * @return the receiveTel
	 */
	public String getReceiveTel() {
		return receiveTel;
	}

	/**
	 * @param receiveTel the receiveTel to set
	 */
	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}

	/**
	 * @return the receivePhone
	 */
	public String getReceivePhone() {
		return receivePhone;
	}

	/**
	 * @param receivePhone the receivePhone to set
	 */
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	/**
	 * @return the province
	 */
	public AreaInfo getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(AreaInfo province) {
		this.province = province;
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

	/**
	 * @return the county
	 */
	public AreaInfo getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(AreaInfo county) {
		this.county = county;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the member
	 */
	public HuiyuanInfo getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(HuiyuanInfo member) {
		this.member = member;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the isdefault
	 */
	public int getIsdefault() {
		return isdefault;
	}

	/**
	 * @param isdefault the isdefault to set
	 */
	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}

	/**
	 * @return the receiveDate
	 */
	public String getReceiveDate() {
		return receiveDate;
	}

	/**
	 * @param receiveDate the receiveDate to set
	 */
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

}
