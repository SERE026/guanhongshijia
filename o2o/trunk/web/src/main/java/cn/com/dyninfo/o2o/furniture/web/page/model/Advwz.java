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

package cn.com.dyninfo.o2o.furniture.web.page.model;

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
 * 广告位置
 * @author lxf
 *
 */
@Entity
@Table(name="T_ADVWZ")
public class Advwz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int advwz_id; 
	
	@AccessType(value="property")
	@Column(name="TITLE")
	private String advwz_title;//广告位置名称
	
	@AccessType(value="property")
	@Column(name="TYPE")
	private String advwz_type;  //广告类型   1为图片 0为flash 2幻灯片
	
	
	@AccessType(value="property")
	@Column(name="WIDTH")
	private int advwz_width;  //宽度
	
	
	@AccessType(value="property")
	@Column(name="HEIGHT")
	private int advwz_height;  //高度

	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="advwz",cascade=CascadeType.ALL)
	private List<Adv> adv;//对应的广告

	public int getAdvwz_id() {
		return advwz_id;
	}


	public void setAdvwz_id(int advwz_id) {
		this.advwz_id = advwz_id;
	}


	public String getAdvwz_title() {
		return advwz_title;
	}


	public void setAdvwz_title(String advwz_title) {
		this.advwz_title = advwz_title;
	}


	public String getAdvwz_type() {
		return advwz_type;
	}


	public void setAdvwz_type(String advwz_type) {
		this.advwz_type = advwz_type;
	}


	public int getAdvwz_width() {
		return advwz_width;
	}


	public void setAdvwz_width(int advwz_width) {
		this.advwz_width = advwz_width;
	}


	public int getAdvwz_height() {
		return advwz_height;
	}


	public void setAdvwz_height(int advwz_height) {
		this.advwz_height = advwz_height;
	}


	public List<Adv> getAdv() {
		return adv;
	}


	public void setAdv(List<Adv> adv) {
		this.adv = adv;
	}


	



}
