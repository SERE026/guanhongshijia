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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/***
 *规格
 * @author 008
 *
 */
@Entity
@Table(name="T_SIZE")
public class Size {
	
	@Id
	@AccessType(value = "property")
	@Column(name="SIZE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int size_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name="UNIT")
	private String unit;//单位
	
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private String status; //0不删除 1删除
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;

	
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

	public int getSize_id() {
		return size_id;
	}

	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
