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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 *  退货单
 * @author lxf
 *
 */
@Entity
@Table(name="T_RETURNEDORDER")
public class Returnedorder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="RETURNEDORDER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String returnedorder_id = "r"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//退货单号
	
	
	@AccessType("property")
	@Column(name="STATUS")
	private String status="0";//0.不删除 1.删除
	

	@AccessType("property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="returnedorder",cascade=CascadeType.ALL)
	private Order order;


	public String getReturnedorder_id() {
		return returnedorder_id;
	}


	public void setReturnedorder_id(String returnedorder_id) {
		this.returnedorder_id = returnedorder_id;
	}




	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	} 

	




}
