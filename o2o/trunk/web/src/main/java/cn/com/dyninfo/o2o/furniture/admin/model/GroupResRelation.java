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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
 * 权限组 资源中间关系表
 * @author jettang
 * Mar 23, 2011
 */
@Entity
@Table(name="BASE_RESCONTROL_RELATION")
public class GroupResRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;//ID
	
	@AccessType(value = "property")
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="GROUP_ID") 
	private ControlGroupInfo cgi;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RC_ID")
	private ResInfo res;
	
	@AccessType(value = "property")
	@Column(name = "ACCESSTYPE", length = 200)
	private String accessType;//数据范围 0全部  1指定父级（多个）及所有子级  2所在本级及所有子级  3个人
	
	
	@AccessType(value = "property")
	@Column(name = "ACCESSOBJ", length = 200)
	private String accessObj;//级别对应ognzId(当accessType为1,以,分隔)




	/**
	 * @return the cgi
	 */
	public ControlGroupInfo getCgi() {
		return cgi;
	}


	/**
	 * @param cgi the cgi to set
	 */
	public void setCgi(ControlGroupInfo cgi) {
		this.cgi = cgi;
	}


	/**
	 * @return the res
	 */
	public ResInfo getRes() {
		return res;
	}


	/**
	 * @param res the res to set
	 */
	public void setRes(ResInfo res) {
		this.res = res;
	}


	/**
	 * @return the accessType
	 */
	public String getAccessType() {
		return accessType;
	}


	/**
	 * @param accessType the accessType to set
	 */
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}


	/**
	 * @return the accessObj
	 */
	public String getAccessObj() {
		return accessObj;
	}


	/**
	 * @param accessObj the accessObj to set
	 */
	public void setAccessObj(String accessObj) {
		this.accessObj = accessObj;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	

}
