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

package cn.com.dyninfo.o2o.furniture.android.model;

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
 * android menu位置
 * @author wenjie
 *
 */
@Entity
@Table(name="T_AMEUNWZ_INFO")
public class AmenuwzInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="MENUWZ_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String menuwz_id; 
	
	@AccessType(value="property")
	@Column(name="TITLE")
	private String menuwz_title;//图片位置名称
	
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="amenuwz",cascade=CascadeType.ALL)
	private List<AmenuInfo> amenu;//对应的MENU




	public String getMenuwz_id() {
		return menuwz_id;
	}


	public void setMenuwz_id(String menuwz_id) {
		this.menuwz_id = menuwz_id;
	}


	public String getMenuwz_title() {
		return menuwz_title;
	}


	public void setMenuwz_title(String menuwz_title) {
		this.menuwz_title = menuwz_title;
	}


	public List<AmenuInfo> getAmenu() {
		return amenu;
	}


	public void setAmenu(List<AmenuInfo> amenu) {
		this.amenu = amenu;
	}


	
	

}
