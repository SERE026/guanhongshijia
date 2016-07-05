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

package cn.com.dyninfo.o2o.furniture.web.goods.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;
/**
 * 商品参数明细
 * @author 王敏
 *
 */
@Entity
@Table(name="T_GOODS_SPEC_VAL")
public class GoodsSpecVal {
	@Id
	@AccessType(value = "property")
	@Column(name = "SPEC_VAL_ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String spec_val_id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_SPEC_ID")
	private GoodsSpec spec;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;
	
	@AccessType(value = "property")
	@Column(name="VAL")
	private String val;
	
	@AccessType(value = "property")
	@Column(name="IMG")
	private String img;
	
	@AccessType(value = "property")
	@Column(name="SPEC_SALES")
	private Double sales = 0.0;//销售价格
	
	@AccessType(value = "property")
	@Column(name="SPEC_BAZAAR")
	private Double bazaar = 0.0;//市场价格
	
	
	@AccessType(value = "property")
	@Column(name="SPEC_COST")
	private Double cost = 0.0;//成本价格
	
	@AccessType(value = "property")
	@Column(name="SPEC_WEIGHT")
	private Double weight = 0.0;//重量
	
	
	@AccessType(value = "property")
	@Column(name="INVENTORY")
	private Double inventory = 0.0;//库存数量
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//1删除 0启用





	/**
	 * @return the spec_val_id
	 */
	public String getSpec_val_id() {
		return spec_val_id;
	}


	/**
	 * @param spec_val_id the spec_val_id to set
	 */
	public void setSpec_val_id(String spec_val_id) {
		this.spec_val_id = spec_val_id;
	}


	public GoodsSpec getSpec() {
		return spec;
	}


	public void setSpec(GoodsSpec spec) {
		this.spec = spec;
	}


	public String getVal() {
		return val;
	}


	public void setVal(String val) {
		this.val = val;
	}


	public Double getSales() {
		return sales;
	}


	public void setSales(Double sales) {
		this.sales = sales;
	}


	public Double getBazaar() {
		return bazaar;
	}


	public void setBazaar(Double bazaar) {
		this.bazaar = bazaar;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Double getInventory() {
		return inventory;
	}


	public void setInventory(Double inventory) {
		this.inventory = inventory;
	}


	/**
	 * @return the goods
	 */
	public Goods getGoods() {
		return goods;
	}


	/**
	 * @param goods the goods to set
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
}
