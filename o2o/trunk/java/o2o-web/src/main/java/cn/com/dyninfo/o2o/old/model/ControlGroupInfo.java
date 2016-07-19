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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASE_CONTROLGROUP_INFO")
public class ControlGroupInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 448675103035333278L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//ID
	
	@AccessType(value = "property")
	@Column(name="GROUP_NAME",length=200)
	private String groupName;//权限组名称
	
	@AccessType(value = "property")
	@Column(name="IS_DEFAULT",length=1)
	private String isDefault;//是否系统默认
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//备注
	
	@AccessType(value = "property")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cgi", fetch = FetchType.LAZY)
	private Set<GroupResRelation> grr;//资源权限中间对象
	
	
	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_ROLE_CONTROL", joinColumns={@JoinColumn(name="GROUP_ID")},  
			inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	private Set<RoleInfo> roles;//角色
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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	 * @return the roles
	 */
	public Set<RoleInfo> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<RoleInfo> roles) {
		this.roles = roles;
	}

	/**
	 * @return the grr
	 */
	public Set<GroupResRelation> getGrr() {
		return grr;
	}

	/**
	 * @param grr the grr to set
	 */
	public void setGrr(Set<GroupResRelation> grr) {
		this.grr = grr;
	}


	

}
