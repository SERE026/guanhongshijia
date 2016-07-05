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

package cn.com.dyninfo.o2o.furniture.web.wuliu.model;

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
 * 指定物流配送地区及费用
 * @author lxf
 *
 */
@Entity
@Table(name="T_PSAREA")
public class Psarea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="PSAREA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int psarea_id ;
	

	
	@AccessType("property")
	@Column(name="AREANMAE")
	private String areaname;//地区名连接的字符
	
	@AccessType("property")
	@Column(name="AREAID")
	private String areaid;//地区id
	
	
	@AccessType("property")
	@Column(name="MRSCFR")
	private Double mrscfr;//首重费用
	
	@AccessType("property")
	@Column(name="MRXZFR")
	private Double mrxzfr;//续重费用
	
	@AccessType("property")
	@Column(name="PAYTYPE")
	private String paytype="0";//	支持货到付款 0.不支持 1.支持
	
	

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DLYTYPE_ID")
	private Dlytype dlytype;//对应配送方案

	public Dlytype getDlytype() {
		return dlytype;
	}

	public void setDlytype(Dlytype dlytype) {
		this.dlytype = dlytype;
	}

	public int getPsarea_id() {
		return psarea_id;
	}

	public void setPsarea_id(int psarea_id) {
		this.psarea_id = psarea_id;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public Double getMrscfr() {
		return mrscfr;
	}

	public void setMrscfr(Double mrscfr) {
		this.mrscfr = mrscfr;
	}

	public Double getMrxzfr() {
		return mrxzfr;
	}

	public void setMrxzfr(Double mrxzfr) {
		this.mrxzfr = mrxzfr;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
}
