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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Where;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/***
 * 商品分类
 * @author 008
 *
 */
@Entity
@Table(name="T_GoodsSort")
public class GoodsSort {
	
	@Id
	@AccessType(value = "property")
	@Column(name="GOODSSORT_ID")
	private int goodsSort_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID")
	private GoodsSort parent;
	
	@AccessType(value="property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parent")
	@Where(clause="status='0' and flag='0'")
	@OrderBy("index asc")
	private List<GoodsSort> children;
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TYPE_ID")
	private GoodsType type;
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status; //0不删除 1删除
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private String flag; //0平台 1商家
	
	@AccessType(value = "property")
	@Column(name="IMAGESRC")
	private String imagesrc;
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;
	
	@AccessType(value = "property")
	@Column(name="T_INDEX")
	private int index;
	
	@AccessType(value = "property")
	@Column(name="REVEAL")
	private String reveal="0";   //是否在全部商品分类中显示 0 不显示  1 显示
;
	
	
	@Transient
	private String levStr;
	
	public String getLevStr(){
		String result="";
		if(this.getParent()!=null)
			result+="——"+this.getParent().getLevStr();
		
		return result;
	}

	public int getGoodsSort_id() {
		return goodsSort_id;
	}

	public void setGoodsSort_id(int goodsSort_id) {
		this.goodsSort_id = goodsSort_id;
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

	public GoodsSort getParent() {
		return parent;
	}

	public void setParent(GoodsSort parent) {
		this.parent = parent;
	}

	public String getImagesrc() {
		return imagesrc;
	}

	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}

	public GoodsType getType() {
		return type;
	}

	public void setType(GoodsType type) {
		this.type = type;
	}

	/**
	 * @return the children
	 */
	public List<GoodsSort> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<GoodsSort> children) {
		this.children = children;
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


	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	public String getReveal() {
		return reveal;
	}

	public void setReveal(String reveal) {
		this.reveal = reveal;
	} 
	
	

}
