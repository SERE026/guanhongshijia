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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * android Meun表
 * @author wenjie
 *	
 */
@Entity
@Table(name="T_AMENU_INFO")
public class AmenuInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="AMENU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String amenu_id; 
	
	@AccessType(value = "property")
	@Column(name = "NAME")
	private String amenu_name;//名称
	
	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AMENUWZ_ID")
	private AmenuwzInfo amenuwz;//图片位置
	
	
	@AccessType(value="property")
	@Column(name="IMG")
	private String img;//图片
	



	public String getAmenu_id() {
		return amenu_id;
	}


	public void setAmenu_id(String amenu_id) {
		this.amenu_id = amenu_id;
	}


	public String getAmenu_name() {
		return amenu_name;
	}


	public void setAmenu_name(String amenu_name) {
		this.amenu_name = amenu_name;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public AmenuwzInfo getAmenuwz() {
		return amenuwz;
	}


	public void setAmenuwz(AmenuwzInfo amenuwz) {
		this.amenuwz = amenuwz;
	}


	
	

}
