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
@Table(name="BASE_BUSINESSCONTROL_INFO")
public class BusinessControlInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6236878439211068712L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//ID
	
	@AccessType(value = "property")
	@Column(name="C_NAME",length=200)
	private String cname;//操作名称
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备注
	
	@AccessType(value = "property")
	@Column(name="IS_DEFAULT",length=200)
	private String isDefault;//是否系统默认 0否 1是
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUSINESS_ID") 
	private BusinessInfo bussinessInfo;	//业务信息
	
	@AccessType(value = "property")
	@OneToMany(mappedBy = "bussinessControlInfo", cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
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

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public BusinessInfo getBussinessInfo() {
		return bussinessInfo;
	}

	public void setBussinessInfo(BusinessInfo bussinessInfo) {
		this.bussinessInfo = bussinessInfo;
	}

	public List<BusFieldControlInfo> getFieldControlList() {
		return fieldControlList;
	}

	public void setFieldControlList(List<BusFieldControlInfo> fieldControlList) {
		this.fieldControlList = fieldControlList;
	}
	
	


}
