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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 友情连接
 * @author lxf
 *
 */
@Entity
@Table(name="T_YQLj")
public class Yqlj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int yqlj_id; 
	
	@AccessType(value="property")
	@Column(name="NAME")
	private String yqlj_name;//友情链接名称
	
	@AccessType(value="property")
	@Column(name="DRESS")
	private String yqlj_dress;  //友情连接地址
	
	@AccessType(value="property")
	@Column(name="COUNT")
	private int yqlj_count;  //排序

	@AccessType(value="property")
	@Column(name="IMG")
	private String yqlj_img;  //图片
	
	public String getYqlj_img() {
		return yqlj_img;
	}

	public void setYqlj_img(String yqlj_img) {
		this.yqlj_img = yqlj_img;
	}

	public int getYqlj_id() {
		return yqlj_id;
	}

	public void setYqlj_id(int yqlj_id) {
		this.yqlj_id = yqlj_id;
	}

	public String getYqlj_name() {
		return yqlj_name;
	}

	public void setYqlj_name(String yqlj_name) {
		this.yqlj_name = yqlj_name;
	}

	public String getYqlj_dress() {
		return yqlj_dress;
	}

	public void setYqlj_dress(String yqlj_dress) {
		this.yqlj_dress = yqlj_dress;
	}

	public int getYqlj_count() {
		return yqlj_count;
	}

	public void setYqlj_count(int yqlj_count) {
		this.yqlj_count = yqlj_count;
	}




}
