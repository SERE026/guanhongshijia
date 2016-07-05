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

package cn.com.dyninfo.o2o.furniture.admin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASE_BUSINESS_FIELD_INFO")
public class BusinessFiledInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8720331757713735155L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//ID
	
	@AccessType(value = "property")
	@Column(name="FIELD_C_NAME",length=200)
	private String cname;//中文名
	
	@AccessType(value = "property")
	@Column(name="FIELD_E_NAME",length=200)
	private String ename;//英文名
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备注
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUSINESS_ID") 
	private BusinessInfo fieldbussinessInfo;//所属业务表
	
	@AccessType(value = "property")
	@OneToMany(mappedBy = "bussinessFieldInfo", cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	private List<BusFieldControlInfo> fieldControlList;//字段权限

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public BusinessInfo getFieldbussinessInfo() {
		return fieldbussinessInfo;
	}

	public void setFieldbussinessInfo(BusinessInfo fieldbussinessInfo) {
		this.fieldbussinessInfo = fieldbussinessInfo;
	}

	public List<BusFieldControlInfo> getFieldControlList() {
		return fieldControlList;
	}

	public void setFieldControlList(List<BusFieldControlInfo> fieldControlList) {
		this.fieldControlList = fieldControlList;
	}

	

}
