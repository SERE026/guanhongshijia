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

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
/**
 * 页面模块中间表
 * @author Administrator
 *
 */
@Entity
@Table(name="T_PAGEMODULE_IN_GOODS")
public class PagModInGoods {
	
	@Id
	@AccessType(value = "property")
	@Column(name="PAGMODINGOODS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pagModInGoods_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAGEMODULE_ID")
	private PageModule pageModule;//页面模块
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHANGJIAINFO_ID")
	private ShangJiaInfo shangJiaInfo;//商家
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOOD_ID")
	private Goods goods;//商品
	
	@AccessType(value = "property")
	@Column(name="EXPIRE_TIME")
	private String expireTime;//失效时间
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	private AreaInfo city;
	
	@AccessType(value = "property")
	@Column(name="INDEXS")
	private int indexs;//序号
	

	public int getPagModInGoods_id() {
		return pagModInGoods_id;
	}

	public void setPagModInGoods_id(int pagModInGoods_id) {
		this.pagModInGoods_id = pagModInGoods_id;
	}

	public PageModule getPageModule() {
		return pageModule;
	}

	public void setPageModule(PageModule pageModule) {
		this.pageModule = pageModule;
	}

	

	public ShangJiaInfo getShangJiaInfo() {
		return shangJiaInfo;
	}

	public void setShangJiaInfo(ShangJiaInfo shangJiaInfo) {
		this.shangJiaInfo = shangJiaInfo;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public int getIndexs() {
		return indexs;
	}

	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}


	public AreaInfo getCity() {
		return city;
	}

	public void setCity(AreaInfo city) {
		this.city = city;
	}
	
	

}
