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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 物流公司
 * @author lxf
 *
 */
@Entity
@Table(name="T_WLCOMPANY")
public class Wlcompany implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="WLCOMPANY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wlcompany_id ;
	
	@AccessType("property")
	@Column(name="NMAE")
	private String name;//物流公司名称

	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="wlcompany")
	private  List<Dlytype> dlytype;//物流配送方式

	@AccessType("property")
	@Column(name="ENGLISHNAME")
	private String englishName;  //物流公司英文名称
	
	public List<Dlytype> getDlytype() {
		return dlytype;
	}

	public void setDlytype(List<Dlytype> dlytype) {
		this.dlytype = dlytype;
	}

	public int getWlcompany_id() {
		return wlcompany_id;
	}

	public void setWlcompany_id(int wlcompany_id) {
		this.wlcompany_id = wlcompany_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
}
