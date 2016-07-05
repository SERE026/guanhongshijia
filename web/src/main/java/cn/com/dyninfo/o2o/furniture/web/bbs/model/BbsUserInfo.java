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

package cn.com.dyninfo.o2o.furniture.web.bbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_BBS_USERINFO")
public class BbsUserInfo {


	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name="IAMGE")
	private String image;
	
	@AccessType(value = "property")
	@Column(name="LEV")
	private int  lev;//发5个贴升一级 2级 10 3级15 4
	
	@AccessType(value = "property")
	@Column(name="BBS_ID")
	private String bbs_id; //管理人员admin+ID 前台人员member+id

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lev
	 */
	public int getLev() {
		return lev;
	}

	/**
	 * @param lev the lev to set
	 */
	public void setLev(int lev) {
		this.lev = lev;
	}

	/**
	 * @return the bbs_id
	 */
	public String getBbs_id() {
		return bbs_id;
	}

	/**
	 * @param bbs_id the bbs_id to set
	 */
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
