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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 退款单
 * @author Zebe
 * @date 2014/4/26
 *
 */
@Entity
@Table(name="T_REFUNDORDER")
public class Refundorder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="REFUNDORDER_ID")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String refundorder_id; // ID
	
	@AccessType(value="property")
	@Column(name="REFUNDMONEY")
	private double refundmoney; // 退款金额
	
	@AccessType("property")
	@Column(name="STATUS")
	private String status="0"; // 0.不删除 1.删除
	
	@AccessType("property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="refundorder",cascade=CascadeType.ALL)
	private Order order; // 关联的订单
	
	@AccessType("property")
	@Column(name="REASON_TYPE")
	private String reasonType; // 退款原因类型 0 快递问题 1产品质量问题 2其它问题
	
	@AccessType("property")
	@Column(name="PS")
	private String ps; // 退款详情描述
	
	@AccessType(value = "property")
	@Column(name="DATE")
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // 申请退款时间（超3天商家未处理自动交给平台审核）
	
	
	@AccessType("property")
	@Column(name="STATE")
	private int state; // 退款状态  0用户申请阶段  1由于金额和订单金额不符，处于平台审核阶段 2申请通过


	public String getRefundorder_id() {
		return refundorder_id;
	}


	public void setRefundorder_id(String refundorder_id) {
		this.refundorder_id = refundorder_id;
	}


	public double getRefundmoney() {
		return refundmoney;
	}


	public void setRefundmoney(double refundmoney) {
		this.refundmoney = refundmoney;
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


	public String getReasonType() {
		return reasonType;
	}


	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}


	public String getPs() {
		return ps;
	}


	public void setPs(String ps) {
		this.ps = ps;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	
	
	

}
