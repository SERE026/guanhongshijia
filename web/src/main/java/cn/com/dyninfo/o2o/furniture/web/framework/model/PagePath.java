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

package cn.com.dyninfo.o2o.furniture.web.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="t_PAGE_PATH")
public class PagePath {

	@Id
	@AccessType(value = "property")
	@Column(name="PAGE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int page_id;
	
	@AccessType(value = "property")
	@Column(name="PAGE")
	private String page;
	
	@AccessType(value = "property")
	@Column(name="PATH")
	private String path;
	
	
	@AccessType(value = "property")
	@Column(name="INTRODUCE")
	private String introduce;


	/**
	 * @return the page_id
	 */
	public int getPage_id() {
		return page_id;
	}


	/**
	 * @param page_id the page_id to set
	 */
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}


	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}


	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}


	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
