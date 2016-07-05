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

import javax.persistence.CascadeType;
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
@Table(name = "BASE_DICTIONARY_INFO")
public class DictionaryInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4755006342514359240L;

	@Id
	@AccessType(value = "property")
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;// id

	@AccessType(value = "property")
	@Column(name = "DATA_C_NAME", length = 200)
	private String data_c_name;// 数据中文名称

	@AccessType(value = "property")
	@Column(name = "DATA_E_NAME", length = 200)
	private String data_e_name;// 数据英文名称

	@AccessType(value = "property")
	@Column(name = "DATA_VALUE", length = 200)
	private String data_value;// 数据值

	@AccessType(value = "property")
	@Column(name = "DATA_TYPE", length = 25)
	private String data_type;// 数据类型

	@AccessType(value = "property")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID",referencedColumnName="ID" )
	private DictionaryInfo parent;// 父字典数据

	@AccessType(value = "property")
	@Column(name = "INDEX_ORDER")
	private int index_order;// 排序

	@AccessType(value = "property")
	@Column(name = "PS", columnDefinition = "text")
	private String ps;// 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData_c_name() {
		return data_c_name;
	}

	public void setData_c_name(String data_c_name) {
		this.data_c_name = data_c_name;
	}

	public String getData_e_name() {
		return data_e_name;
	}

	public void setData_e_name(String data_e_name) {
		this.data_e_name = data_e_name;
	}

	public String getData_value() {
		return data_value;
	}

	public void setData_value(String data_value) {
		this.data_value = data_value;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public DictionaryInfo getParent() {
		return parent;
	}

	public void setParent(DictionaryInfo parent) {
		this.parent = parent;
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
}
