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

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/****
 * 地区
 * @author Administrator
 *
 */
@Entity
@Table(name="T_AREAX_INFO")
public class AreaInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@Column(name = "NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name = "STATUS")
	private String status="1";
	
	@AccessType(value = "property")
	@Column(name = "IS_DEFAULT")
	private String isDefault="0";//是否默认城市 0.不默认 1.默认
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="parent")
	private  List<AreaInfo> children;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID")
	private AreaInfo parent;
	
	
	@AccessType(value = "property")
	@Column(name = "PS", columnDefinition = "text")
	private String ps;// 描述

	@AccessType(value = "property")
	@Column(name = "m_id")
	private String m_id = "1";

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the children
	 */
	public List<AreaInfo> getChildren() {
		return children;
	}


	/**
	 * @param children the children to set
	 */
	public void setChildren(List<AreaInfo> children) {
		this.children = children;
	}


	/**
	 * @return the parent
	 */
	public AreaInfo getParent() {
		return parent;
	}


	/**
	 * @param parent the parent to set
	 */
	public void setParent(AreaInfo parent) {
		this.parent = parent;
	}


	/**
	 * @return the ps
	 */
	public String getPs() {
		return ps;
	}


	/**
	 * @param ps the ps to set
	 */
	public void setPs(String ps) {
		this.ps = ps;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	/**
	 * @return the isDefault
	 */
	public String getIsDefault() {
		return isDefault;
	}


	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	

}
