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
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * 文章管理
 * @author lxf
 *
 */
@Entity
@Table(name="T_ARTICLES")
public class Articles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int artices_id; 
	
	@AccessType(value="property")
	@Column(name="NAME")
	private String artices_name;//文章标题
	
	@AccessType(value="property")
	@Column(name="CONTENT")
	private String artices_content;  //文章内容
	
	@AccessType(value="property")
	@Column(name="TIME")
	private String articles_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  //发布时间

	public int getArtices_id() {
		return artices_id;
	}

	public void setArtices_id(int artices_id) {
		this.artices_id = artices_id;
	}

	public String getArtices_name() {
		return artices_name;
	}

	public void setArtices_name(String artices_name) {
		this.artices_name = artices_name;
	}

	public String getArtices_content() {
		return artices_content;
	}

	public void setArtices_content(String artices_content) {
		this.artices_content = artices_content;
	}

	public String getArticles_time() {
		return articles_time;
	}

	public void setArticles_time(String articles_time) {
		this.articles_time = articles_time;
	}




}
