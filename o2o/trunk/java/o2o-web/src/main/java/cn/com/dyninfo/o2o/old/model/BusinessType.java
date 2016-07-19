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

@Entity
@Table(name="T_BUSINESS_TYPE")
public class BusinessType {
	@Id
	@AccessType(value = "property")
	@Column(name="TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int type_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;
	
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//1删除 0不删
	
	@AccessType(value = "property")
	@Column(name="ORDER_INDEX")
	private int orderIndex=0;

	/**
	 * @return the type_id
	 */
	public int getType_id() {
		return type_id;
	}

	/**
	 * @param type_id the type_id to set
	 */
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
