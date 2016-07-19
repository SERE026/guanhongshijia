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

import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

/***
 *试用申请
 * @author lxf
 *
 */
@Entity
@Table(name="T_TRYUSE_APPLY")
public class TryuseApply {
	
	@Id
	@AccessType(value = "property")
	@Column(name="TRYUSE_APPLY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tryuse_apply_id;
	
	@AccessType(value = "property")
	@Column(name="REASON")
	private String reason;//申请理由
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;//会员信息  如果不是会员的申请就为空
	
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;//对应商品
	
	@AccessType("property")
	@Column(name="STATE")
	private String state="0";//删除状态 0为不删除 1为删除
	
	@AccessType("property")
	@Column(name="APPLYTYPE")
	private String applytype="2";//通过状态 0为不通过 1为通过 2.等待审核

	
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
	  private String address;
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_CODE")
	  private String code;
	  
	  
	  @AccessType(value="property")
	  @Column(name="RECEIVE_EMAIL")
	  private String email;
	  
		@AccessType(value="property")
		@Column(name="APPLYDATE")
		private String applyDate;//申请时间
		
		
	/**
	 * @return the tryuse_apply_id
	 */
	public int getTryuse_apply_id() {
		return tryuse_apply_id;
	}

	/**
	 * @param tryuse_apply_id the tryuse_apply_id to set
	 */
	public void setTryuse_apply_id(int tryuse_apply_id) {
		this.tryuse_apply_id = tryuse_apply_id;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the huiyuan
	 */
	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}

	/**
	 * @param huiyuan the huiyuan to set
	 */
	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the applytype
	 */
	public String getApplytype() {
		return applytype;
	}

	/**
	 * @param applytype the applytype to set
	 */
	public void setApplytype(String applytype) {
		this.applytype = applytype;
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
	 * @return the applyDate
	 */
	public String getApplyDate() {
		return applyDate;
	}

	/**
	 * @param applyDate the applyDate to set
	 */
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	
	
}