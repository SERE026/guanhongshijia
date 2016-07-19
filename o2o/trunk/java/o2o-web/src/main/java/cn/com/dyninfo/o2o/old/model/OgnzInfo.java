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

/**
 * @author jettang
 * May 17, 2010
 * 
 */
package cn.com.dyninfo.o2o.old.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author jettang May 17, 2010
 */
@Entity
@Table(name = "BASE_OGNZ_INFO")
public class OgnzInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -922538975613184625L;

	@Id
	@AccessType(value = "property")
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;// id

	@AccessType(value = "property")
	@Column(name = "OGNZ_NAME", length = 200)
	private String ognz_name;// 组织结构名称

	@AccessType(value = "property")
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private OgnzInfo parent;// 父组织结构

	@AccessType(value = "property")
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy(value ="index_order asc")
	private List<OgnzInfo> children;// 子组织结构
	
	@AccessType(value = "property")
	@Column(name = "ISUSED", length = 1)
	private String isUsed;// 是否启用 0否 1是

	@AccessType(value = "property")
	@Column(name = "PS", columnDefinition = "text")
	private String ps;// 描述

	@AccessType(value = "property")
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name="BASE_OGNZ_USER",joinColumns=@JoinColumn(name="OGNZ_ID"),
			inverseJoinColumns=@JoinColumn(name="USER_ID"))
    @OrderBy(value ="index_order asc")
	private List<UserInfo> users;//该组织结构所拥有的用户对象
	
	@AccessType(value = "property")
	@Column(name = "ISOGNZ", length = 1)
	private String isognz;// 该组织结构是否是行政机构
	
	@AccessType(value = "property")
	@Column(name = "INDEX_ORDER")
	private int index_order;// 排序
	
	
	/** ******************************************************************** */

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ognz_name
	 */
	public String getOgnz_name() {
		return ognz_name;
	}

	/**
	 * @param ognz_name
	 *            the ognz_name to set
	 */
	public void setOgnz_name(String ognz_name) {
		this.ognz_name = ognz_name;
	}

	/**
	 * @return the parent
	 */
	public OgnzInfo getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(OgnzInfo parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<OgnzInfo> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<OgnzInfo> children) {
		this.children = children;
	}

	/**
	 * @return the isUsed
	 */
	public String getIsUsed() {
		return isUsed;
	}

	/**
	 * @param isUsed
	 *            the isUsed to set
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * @return the ps
	 */
	public String getPs() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(String ps) {
		this.ps = ps;
	}

	/**
	 * @return the users
	 */
	public List<UserInfo> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}


	/**
	 * @return the isognz
	 */
	public String getIsognz() {
		return isognz;
	}

	/**
	 * @param isognz the isognz to set
	 */
	public void setIsognz(String isognz) {
		this.isognz = isognz;
	}

	/**
	 * @return the index_order
	 */
	public int getIndex_order() {
		return index_order;
	}

	/**
	 * @param index_order the index_order to set
	 */
	public void setIndex_order(int index_order) {
		this.index_order = index_order;
	}

}
