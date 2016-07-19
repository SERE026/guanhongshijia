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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;
/**
 * 商品参数
 * @author 王敏
 *
 */
@Entity
@Table(name="T_GOOD_SPEC")
public class GoodsSpec {

	@Id
	@AccessType(value = "property")
	@Column(name = "GOODS_SPEC_ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String goods_spec_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private String type;//0文本1图片
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODS_ID")
	private Goods goods;
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//1删除 0启用
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="spec")
	private List<GoodsSpecVal> valList;//产品参数

	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@Transient
	private int count;
	
	

	/**
	 * @return the count
	 */
	public int getCount() {
		count=0;
		if(valList!=null){
			for(GoodsSpecVal v:valList){
				if(v.getStatus()==0){
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * @return the goods_spec_id
	 */
	public String getGoods_spec_id() {
		return goods_spec_id;
	}

	/**
	 * @param goods_spec_id the goods_spec_id to set
	 */
	public void setGoods_spec_id(String goods_spec_id) {
		this.goods_spec_id = goods_spec_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the valList
	 */
	public List<GoodsSpecVal> getValList() {
		return valList;
	}

	/**
	 * @param valList the valList to set
	 */
	public void setValList(List<GoodsSpecVal> valList) {
		this.valList = valList;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
