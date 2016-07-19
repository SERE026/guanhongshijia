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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/***
 *页面模块
 * @author 008
 *
 */
@Entity
@Table(name="T_PAGEMODULE")
public class PageModule {
	
	@Id
	@AccessType(value = "property")
	@Column(name="PAGEMODULE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pageModule_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;//名称
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pageModule",cascade=CascadeType.ALL)
	@OrderBy("indexs asc ")
	private List<PagModInGoods> goodsList;
	
	@AccessType(value = "property")
	@Column(name="MDATE")
	private String mdate;//修改时间
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status;
	
	@AccessType(value = "property")
	@Column(name="ISDEFAULT")
	private String isDefault="0";
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;
	

	public int getPageModule_id() {
		return pageModule_id;
	}

	public void setPageModule_id(int pageModule_id) {
		this.pageModule_id = pageModule_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
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

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the goodsList
	 */
	public List<PagModInGoods> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList the goodsList to set
	 */
	public void setGoodsList(List<PagModInGoods> goodsList) {
		this.goodsList = goodsList;
	}


	

}
