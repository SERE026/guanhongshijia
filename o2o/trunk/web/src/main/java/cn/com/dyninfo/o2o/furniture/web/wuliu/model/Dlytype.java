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
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/**
 * 配送方式
 * @author lxf
 *
 */
@Entity
@Table(name="T_DLYTYPE")
public class Dlytype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="DLYTYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dlytype_id ;
	

	@AccessType("property")
	@Column(name="DLYNMAE")
	private String dlyname;//配送方式名称


	@AccessType("property")
	@Column(name="FIRSTWT")
	private Double firstwt;//首重重量

	@AccessType("property")
	@Column(name="ADDWT")
	private Double addwt;// 续重单位 
	
	
	@AccessType("property")
	@Column(name="FIRSTMONEY")
	private Double firstmoney;//首重费用
	
	@AccessType("property")
	@Column(name="ADDWTMONEY")
	private Double addwtmoney;//续重费用
	
	@AccessType("property")
	@Column(name="VALUATION")
	private String valuation="0";//支持物流保价 0.不支持 1.支持
	
	@AccessType("property")
	@Column(name="BJFL")
	private Double bjfl;//保价费率
	
	@AccessType("property")
	@Column(name="LOWEST")
	private Double lowest;//最低保价费
	
	@AccessType("property")
	@Column(name="PAYTYPE")
	private String paytype="0";//	支持货到付款 0.不支持 1.支持
	
	@AccessType("property")
	@Column(name="VALUETYPE")
	private String valuetype;//地区费用类型 0.统一设置  1.指定配送地区和费用 
  

	
	@AccessType("property")
	@Column(name="STATS")
	private String stats="0";		//	状态 0.启用 1.没有启用
	

	@AccessType("property")
	@Column(name="STAT")
	private String stat="0";		//	删除状态 0.没有删除 1.删除
	
	@AccessType("property")
	@Column(name="DETAILED")
	private String detailed;		//		详细介绍
	
	@AccessType("property")
	@Column(name="COUNT")
	private int count;		//	排序
	
	

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WLCOMPANY_ID")
	private Wlcompany wlcompany;//对应物流公司
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="dlytype")
	private  List<Psarea> psarea;//指定地区费用

	
	@AccessType("property")
	@Column(name="MRFR")
	private String mrfr="0";		//	启用默认费用 0.没有启用 1.启用
	
	
	@AccessType("property")
	@Column(name="MRSCFR")
	private Double mrscfr;//默认首重费用
	
	@AccessType("property")
	@Column(name="MRXZFR")
	private Double mrxzfr;//默认续重费用
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值


	public int getDlytype_id() {
		return dlytype_id;
	}



	public void setDlytype_id(int dlytype_id) {
		this.dlytype_id = dlytype_id;
	}



	public String getDlyname() {
		return dlyname;
	}



	public void setDlyname(String dlyname) {
		this.dlyname = dlyname;
	}



	public Double getFirstwt() {
		return firstwt;
	}



	public void setFirstwt(Double firstwt) {
		this.firstwt = firstwt;
	}



	public Double getAddwt() {
		return addwt;
	}



	public void setAddwt(Double addwt) {
		this.addwt = addwt;
	}



	public Double getFirstmoney() {
		return firstmoney;
	}



	public void setFirstmoney(Double firstmoney) {
		this.firstmoney = firstmoney;
	}



	public Double getAddwtmoney() {
		return addwtmoney;
	}



	public void setAddwtmoney(Double addwtmoney) {
		this.addwtmoney = addwtmoney;
	}



	public String getValuation() {
		return valuation;
	}



	public void setValuation(String valuation) {
		this.valuation = valuation;
	}



	public Double getBjfl() {
		return bjfl;
	}



	public void setBjfl(Double bjfl) {
		this.bjfl = bjfl;
	}



	public Double getLowest() {
		return lowest;
	}



	public void setLowest(Double lowest) {
		this.lowest = lowest;
	}



	public String getPaytype() {
		return paytype;
	}



	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}



	public String getValuetype() {
		return valuetype;
	}



	public void setValuetype(String valuetype) {
		this.valuetype = valuetype;
	}



	public String getStats() {
		return stats;
	}



	public void setStats(String stats) {
		this.stats = stats;
	}



	public String getDetailed() {
		return detailed;
	}



	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public Wlcompany getWlcompany() {
		return wlcompany;
	}



	public void setWlcompany(Wlcompany wlcompany) {
		this.wlcompany = wlcompany;
	}



	public String getMrfr() {
		return mrfr;
	}



	public void setMrfr(String mrfr) {
		this.mrfr = mrfr;
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



	public List<Psarea> getPsarea() {
		return psarea;
	}



	public void setPsarea(List<Psarea> psarea) {
		this.psarea = psarea;
	}



	public String getStat() {
		return stat;
	}



	public void setStat(String stat) {
		this.stat = stat;
	}



	/**
	 * @return the merchants
	 */
	public ShangJiaInfo getMerchants() {
		return merchants;
	}



	/**
	 * @param merchants the merchants to set
	 */
	public void setMerchants(ShangJiaInfo merchants) {
		this.merchants = merchants;
	}



	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}




}
