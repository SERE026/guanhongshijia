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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

/***
 * 商品类型
 * @author 008
 *
 */
@Entity
@Table(name="T_GOODSTYPE")
public class GoodsType {
	
	@Id
	@AccessType(value = "property")
	@Column(name="GOODSTYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int goodsType_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status; //0不删除 1删除
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;
	
	@AccessType(value = "property")
	@Column(name="LINKBRANK")
	private String linkBrank;
	
	@AccessType(value = "property")
	@Column(name="OWNSPEC")
	private String ownSpec;

	@AccessType(value = "property")
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinTable(name="T_GOODSTYPE_OR_BRAND",joinColumns={@JoinColumn(name="GOODS_TYPE_ID")},
		inverseJoinColumns={@JoinColumn(name="BRAND_ID")})
	private List<Brand> brandList;
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="type")
	private List<GoodsTypeSpec>  specList;
	
	@Transient
	private String brandStr;
	
	
	public String getBrandStr() {
		brandStr="";
		for(Brand b:brandList){
			brandStr+=":"+b.getBrand_id()+":";
		}
		return brandStr;
	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public List<GoodsTypeSpec> getSpecList() {
		return specList;
	}

	public void setSpecList(List<GoodsTypeSpec> specList) {
		this.specList = specList;
	}

	public int getGoodsType_id() {
		return goodsType_id;
	}

	public void setGoodsType_id(int goodsType_id) {
		this.goodsType_id = goodsType_id;
	}

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

	public String getLinkBrank() {
		return linkBrank;
	}

	public void setLinkBrank(String linkBrank) {
		this.linkBrank = linkBrank;
	}

	public String getOwnSpec() {
		return ownSpec;
	}

	public void setOwnSpec(String ownSpec) {
		this.ownSpec = ownSpec;
	} 
	
	

}
