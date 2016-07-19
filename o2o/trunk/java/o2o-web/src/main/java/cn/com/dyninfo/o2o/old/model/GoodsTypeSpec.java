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
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

/**
 * 商品类型属性
 * @author Administrator
 *
 */
@Entity
@Table(name="T_GOOS_TYPE_SPEC")
public class GoodsTypeSpec {

	@Id
	@AccessType(value = "property")
	@Column(name="GOODS_TYPE_SPEC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int goods_type_spec_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String spec_name;
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status; //0不删除 1删除
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private String flag;//0选择 1输入

	@AccessType(value = "property")
	@Column(name="VALSTR")
	private String valStr;//选择是可选值,分开
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_TYPE_ID")
	private GoodsType type;
	
	@Transient
	private String[] vals;

	public String[] getVals() {
		if(valStr!=null)
			return valStr.split(",");
		return null;
	}

	public int getGoods_type_spec_id() {
		return goods_type_spec_id;
	}

	public void setGoods_type_spec_id(int goods_type_spec_id) {
		this.goods_type_spec_id = goods_type_spec_id;
	}

	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getValStr() {
		return valStr;
	}

	public void setValStr(String valStr) {
		this.valStr = valStr;
	}

	public void setVals(String[] vals) {
		this.vals = vals;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public GoodsType getType() {
		return type;
	}

	public void setType(GoodsType type) {
		this.type = type;
	}
	
	
}
