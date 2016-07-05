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

package cn.com.dyninfo.o2o.furniture.web.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;


/**
 * 
 * 购物车
 * 购物车设计 --
 * 	在用户没有登录时添加一个购物车 然后将ID存入cookie 中 
 * 	当用户登录之后先查看cookie中是否有购物车 如果有将cookie的购物车上物品 加入到用户私有购车上 然后删除cookie的购物车
 * 
 * @author 王敏
 *
 */
@Entity
@Table(name="T_CARS")
public class Cars {

	@Id
	@AccessType(value = "property")
	@Column(name = "CARS_ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String cars_id;// id
	
//	@AccessType(value = "property")
//	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="car")
//	private List<CarsBox> box;
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo member; 

	/**
	 * @return the cars_id
	 */
	public String getCars_id() {
		return cars_id;
	}

	/**
	 * @param cars_id the cars_id to set
	 */
	public void setCars_id(String cars_id) {
		this.cars_id = cars_id;
	}

//	/**
//	 * @return the box
//	 */
//	public List<CarsBox> getBox() {
//		return box;
//	}
//
//	/**
//	 * @param box the box to set
//	 */
//	public void setBox(List<CarsBox> box) {
//		this.box = box;
//	}

	/**
	 * @return the member
	 */
	public HuiyuanInfo getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(HuiyuanInfo member) {
		this.member = member;
	} 
	

	
}
