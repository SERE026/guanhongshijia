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

package cn.com.dyninfo.o2o.furniture.web.score.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.google.gson.annotations.Expose;
/**
 * 积分方案
 * @author lxf
 *
 */
@Entity
@Table(name="T_JFFA")
public class Jffa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @AccessType("property")
    @Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Expose
    private String jffa_id;//ID
    
	@AccessType("property")
    @Column(name="XFJF")
    private Integer jffa_xfjf;//每消费1元，得到xfjf个积分
	
	@AccessType("property")
    @Column(name="JFDK")
    private Double jffa_jfdk;//每1元，等于多少积分

	public String getJffa_id() {
		return jffa_id;
	}

	public void setJffa_id(String jffa_id) {
		this.jffa_id = jffa_id;
	}

	public Integer getJffa_xfjf() {
		return jffa_xfjf;
	}

	public void setJffa_xfjf(Integer jffa_xfjf) {
		this.jffa_xfjf = jffa_xfjf;
	}

	public Double getJffa_jfdk() {
		return jffa_jfdk;
	}

	public void setJffa_jfdk(Double jffa_jfdk) {
		this.jffa_jfdk = jffa_jfdk;
	}



}
