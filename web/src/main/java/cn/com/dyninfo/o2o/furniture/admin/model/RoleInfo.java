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
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 * @author jettang
 *	设计师 Designer
 *	客服 CustomerService
 *	业务员 Salesman
 *	跟单员 Merchandiser
 *	质检 QualityInspection
 *	配送 Distribution
 *	财务 Financial
 *	部门主管 DepartmentHead
 *
 *
 */
@Entity
@Table(name="BASE_ROLE_INFO")
public class RoleInfo implements GrantedAuthority,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4463999165480898313L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//角色ID
	
	@AccessType(value = "property")
	@Column(name="ROLE_E_NAME",length=200)
	private String role_e_name;//角色英文名称
	
	@AccessType(value = "property")
	@Column(name="ROLE_C_NAME",length=200)
	private String role_c_name;//角色中文名称
	
	@AccessType(value = "property")
	@Column(name="IS_SYS",length=1)
	private String isSys;//是否系统角色 1.是 0.否
	
	@AccessType(value = "property")
	@Column(name="IS_JOB",length=1)
	private String is_job;//是否行政职位
	
	@AccessType(value = "property")
	@Column(name = "INDEX_ORDER")
	private int index_order;// 排序

	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_ROLE_CONTROL", joinColumns={@JoinColumn(name="ROLE_ID")},  
			inverseJoinColumns={@JoinColumn(name="GROUP_ID")})
	private Set<ControlGroupInfo> groups;//角色对应的权限组
	
	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_USER_ROLE", joinColumns={@JoinColumn(name="ROLE_ID")},  
			inverseJoinColumns={@JoinColumn(name="USER_ID")})
	
	private Set<UserInfo> user;//用户对应的角色


	
	public String getAuthority() {
		// TODO 返回角色名称
		return this.getRole_e_name();
	}
	
	
	public String getName() {
		return role_c_name;
	}

	
	public String getType() {
		return isSys;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole_e_name() {
		return role_e_name;
	}

	public void setRole_e_name(String role_e_name) {
		this.role_e_name = role_e_name;
	}

	public String getRole_c_name() {
		return role_c_name;
	}

	public void setRole_c_name(String role_c_name) {
		this.role_c_name = role_c_name;
	}

	public String getIsSys() {
		return isSys;
	}

	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}

	public String getIs_job() {
		return is_job;
	}

	public void setIs_job(String is_job) {
		this.is_job = is_job;
	}


	public int getIndex_order() {
		return index_order;
	}

	public void setIndex_order(int index_order) {
		this.index_order = index_order;
	}

	/**
	 * @return the groups
	 */
	public Set<ControlGroupInfo> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Set<ControlGroupInfo> groups) {
		this.groups = groups;
	}

	public Set<UserInfo> getUser() {
		return user;
	}

	public void setUser(Set<UserInfo> user) {
		this.user = user;
	}

	
}
