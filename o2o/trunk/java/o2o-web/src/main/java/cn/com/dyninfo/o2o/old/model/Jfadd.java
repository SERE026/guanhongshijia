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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
/**
 * 积分增加方案
 * @author lxf
 *
 */
@Entity
@Table(name="T_JFADD")
public class Jfadd implements Serializable{

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
    private String jfadd_id;//ID
    
    @AccessType("property")
    @Column(name="NAME")
    private String jfadd_name;//名称
    
    @AccessType("property")
    @Column(name="ZJJF")
    private Double jfadd_zjjf;//增加积分

	public String getJfadd_id() {
		return jfadd_id;
	}

	public void setJfadd_id(String jfadd_id) {
		this.jfadd_id = jfadd_id;
	}

	public String getJfadd_name() {
		return jfadd_name;
	}

	public void setJfadd_name(String jfadd_name) {
		this.jfadd_name = jfadd_name;
	}

	/**
	 * @return the jfadd_zjjf
	 */
	public Double getJfadd_zjjf() {
		return jfadd_zjjf;
	}

	/**
	 * @param jfadd_zjjf the jfadd_zjjf to set
	 */
	public void setJfadd_zjjf(Double jfadd_zjjf) {
		this.jfadd_zjjf = jfadd_zjjf;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


    
}
