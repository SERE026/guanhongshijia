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

package cn.com.dyninfo.o2o.furniture.web.active.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="T_GAME_INFO")
public class Game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="GAME_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int game_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;//游戏名称
	
	@AccessType(value = "property")
	@Column(name="PLUGIN")
	private String plugin;//游戏页面
	
	@AccessType(value = "property")
	@Column(name="PAGE_URL")
	private String pageUrl;//游戏页面
	
	@AccessType(value = "property")
	@Column(name="MANAGE_URL")
	private String manageUrl;//后台数据处理地址
	
	@AccessType(value = "property")
	@Column(name="AJAX_URL")
	private String ajaxUrl;//ajax数据处理地址
	
	@AccessType(value = "property")
	@Column(name="PARAM_URL")
	private String paramUrl;//游戏参数设置地址
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//ajax数据处理地址
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//1删除 0不删

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getManageUrl() {
		return manageUrl;
	}

	public void setManageUrl(String manageUrl) {
		this.manageUrl = manageUrl;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the paramUrl
	 */
	public String getParamUrl() {
		return paramUrl;
	}

	/**
	 * @param paramUrl the paramUrl to set
	 */
	public void setParamUrl(String paramUrl) {
		this.paramUrl = paramUrl;
	}

	/**
	 * @return the plugin
	 */
	public String getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin the plugin to set
	 */
	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}
	
}
