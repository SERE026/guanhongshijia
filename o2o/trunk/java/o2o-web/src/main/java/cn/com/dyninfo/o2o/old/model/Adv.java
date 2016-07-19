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
 * 广告列表
 * @author lxf
 *
 */
@Entity
@Table(name="T_ADV")
public class Adv implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ADV_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adv_id; 
	
	@AccessType(value="property")
	@Column(name="NAME")
	private String adv_name;//广告名称
	
	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADVWZ_ID")
	private Advwz advwz;//广告位置
	
	@AccessType(value="property")
	@Column(name="ADV_USE")
	private String adv_use;  //是否启用 0为没有启用 1为启用
	
	@AccessType(value="property")
	@Column(name="STARTTIME")
	private String adv_starttime;  //起始时间


	@AccessType(value="property")
	@Column(name="ENDTIME")
	private String adv_endtime;  //终止时间

	@AccessType(value="property")
	@Column(name="LINK")
	private String adv_link;  //广告链接
	
	@AccessType(value="property")
	@Column(name="FILE")
	private String adv_flie;  //上传文件
	
	@AccessType(value="property")
	@Column(name="UNIT")
	private String adv_unit;  //单位名称
	
	@AccessType(value="property")
	@Column(name="LINKMAN")
	private String adv_linkman;  //联系人
	
	@AccessType(value="property")
	@Column(name="LINKTYPE") 
	private String adv_linktype;  //联系方式
	
	@AccessType(value="property")
	@Column(name="ADV_BGCOLOR") 
	private String adv_bgColor;
	
	@AccessType(value="property")
	@Column(name="HITS") 
	private int adv_hits;  //点击次数
	
	@AccessType(value = "property")
	@Column(name="ORDER_INDEX")
	private int orderIndex=0;//排序
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREA_ID")
	private AreaInfo area;//城市

	public int getAdv_id() {
		return adv_id;
	}

	public void setAdv_id(int adv_id) {
		this.adv_id = adv_id;
	}

	public String getAdv_name() {
		return adv_name;
	}

	public void setAdv_name(String adv_name) {
		this.adv_name = adv_name;
	}

	public Advwz getAdvwz() {
		return advwz;
	}

	public void setAdvwz(Advwz advwz) {
		this.advwz = advwz;
	}

	public String getAdv_use() {
		return adv_use;
	}

	public void setAdv_use(String adv_use) {
		this.adv_use = adv_use;
	}

	public String getAdv_starttime() {
		return adv_starttime;
	}

	public void setAdv_starttime(String adv_starttime) {
		this.adv_starttime = adv_starttime;
	}

	public String getAdv_endtime() {
		return adv_endtime;
	}

	public void setAdv_endtime(String adv_endtime) {
		this.adv_endtime = adv_endtime;
	}

	public String getAdv_link() {
		return adv_link;
	}

	public void setAdv_link(String adv_link) {
		this.adv_link = adv_link;
	}

	public String getAdv_flie() {
		return adv_flie;
	}

	public void setAdv_flie(String adv_flie) {
		this.adv_flie = adv_flie;
	}

	public String getAdv_unit() {
		return adv_unit;
	}

	public void setAdv_unit(String adv_unit) {
		this.adv_unit = adv_unit;
	}

	public String getAdv_linkman() {
		return adv_linkman;
	}

	public void setAdv_linkman(String adv_linkman) {
		this.adv_linkman = adv_linkman;
	}

	public String getAdv_linktype() {
		return adv_linktype;
	}

	public void setAdv_linktype(String adv_linktype) {
		this.adv_linktype = adv_linktype;
	}

	public int getAdv_hits() {
		return adv_hits;
	}

	public void setAdv_hits(int adv_hits) {
		this.adv_hits = adv_hits;
	}

	/**
	 * @return the area
	 */
	public AreaInfo getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(AreaInfo area) {
		this.area = area;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the adv_bgColor
	 */
	public String getAdv_bgColor() {
		return adv_bgColor;
	}

	/**
	 * @param adv_bgColor the adv_bgColor to set
	 */
	public void setAdv_bgColor(String adv_bgColor) {
		this.adv_bgColor = adv_bgColor;
	}

	/**
	 * @return the orderIndex
	 */
	public int getOrderIndex() {
		return orderIndex;
	}

	/**
	 * @param orderIndex the orderIndex to set
	 */
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

}
