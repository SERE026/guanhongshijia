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
 * 收款单
 * @author lxf
 *
 */
@Entity
@Table(name="T_PAYMENT")
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="PAYMENT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String payment_id = "p"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//收款单号
	
	@AccessType(value="property")
	@Column(name="PAYMONEY")
	private String paymoney;//支付金额
	
	@AccessType("property")
	@Column(name="STATUS")
	private String status="0";//0.不删除 1.删除
	

	@AccessType("property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="payment",cascade=CascadeType.ALL)
	private Order order; 

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
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
