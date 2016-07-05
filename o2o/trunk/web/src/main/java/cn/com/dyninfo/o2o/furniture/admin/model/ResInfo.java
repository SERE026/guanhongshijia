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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BASE_RES_INFO")
public class ResInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;// 资源信息id
	
	@AccessType(value = "property")
	@Column(name = "RES_NAME", length = 200)
	private String res_name;// 资源名称
	
	@AccessType(value = "property")
	@Column(name = "res_role")
	private String role;// 适用角色
	
	@AccessType(value = "property")
	@Column(name = "IS_MENU", length = 1)
	private String is_menu;// 是否是系统菜单  0否 1是
	
	@AccessType(value = "property")
	@Column(name = "URL", length = 255)
	private String url;// 资源访问路径
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private ResInfo parent;// 父资源ID
	
	@AccessType(value = "property")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	@OrderBy(value ="index_order asc")
	private Set<ResInfo> children;// 子资源
	
	@AccessType(value = "property")
	@Column(name = "IS_DEFAULT", length = 1)
	private String is_default;// 是否是系统默认资源
	
	@AccessType(value = "property")
	@Column(name = "INDEX_ORDER")
	private int index_order;// 排序
	
	@AccessType(value = "property")
	@Column(name = "PS", columnDefinition = "text")
	private String ps;// 备注
	
	@AccessType(value="property")
	@Column(name="IMG_URL",length=255)
	private String img_url;//菜单图片地址
	
	@AccessType(value="property")
	@Column(name="MODULE_NAME",length=20)
	private String module_name;//模块名称
	
	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_FUNCTION_RES", joinColumns={@JoinColumn(name="FUNID")},  
	  inverseJoinColumns={@JoinColumn(name="RESID")})
	private Set<FunctionInfo> funs;
	
	@AccessType(value = "property")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "res", fetch = FetchType.LAZY)
	private List<GroupResRelation> grrList;
	


	/**
	 * @return the grrList
	 */
	public List<GroupResRelation> getGrrList() {
		return grrList;
	}

	/**
	 * @param grrList the grrList to set
	 */
	public void setGrrList(List<GroupResRelation> grrList) {
		this.grrList = grrList;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getIs_menu() {
		return is_menu;
	}

	public void setIs_menu(String is_menu) {
		this.is_menu = is_menu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ResInfo getParent() {
		return parent;
	}

	public void setParent(ResInfo parent) {
		this.parent = parent;
	}

	public Set<ResInfo> getChildren() {
		return children;
	}

	public void setChildren(Set<ResInfo> children) {
		this.children = children;
	}

	public String getIs_default() {
		return is_default;
	}

	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}

	public int getIndex_order() {
		return index_order;
	}

	public void setIndex_order(int index_order) {
		this.index_order = index_order;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	/**
	 * @return the module_name
	 */
	public String getModule_name() {
		return module_name;
	}

	/**
	 * @param module_name the module_name to set
	 */
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public Set<FunctionInfo> getFuns() {
		return funs;
	}

	public void setFuns(Set<FunctionInfo> funs) {
		this.funs = funs;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
