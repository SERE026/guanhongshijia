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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASE_BUSFIELDCONTROL_INFO")
public class BusFieldControlInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1223395410407952074L;

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
	@Column(name="PS",columnDefinition ="text")
	private String ps;//备注
	
	@AccessType(value = "property")
	@Column(name="ACCESS_TYPE",length=200)
	private String accesstype;//访问权限
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUSINESS_ID") 
	private BusinessControlInfo bussinessControlInfo;	//业务表权限
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIELD_ID") 
	private BusinessFiledInfo bussinessFieldInfo;	//业务表字段

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

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public BusinessControlInfo getBussinessControlInfo() {
		return bussinessControlInfo;
	}

	public void setBussinessControlInfo(BusinessControlInfo bussinessControlInfo) {
		this.bussinessControlInfo = bussinessControlInfo;
	}

	public BusinessFiledInfo getBussinessFieldInfo() {
		return bussinessFieldInfo;
	}

	public void setBussinessFieldInfo(BusinessFiledInfo bussinessFieldInfo) {
		this.bussinessFieldInfo = bussinessFieldInfo;
	}

}
