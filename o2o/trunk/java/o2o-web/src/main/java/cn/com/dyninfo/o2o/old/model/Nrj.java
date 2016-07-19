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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;


/**
 * 广告列表
 * @author lxf
 *
 */
@Entity
@Table(name="T_NRJ")
public class Nrj implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="NRJ_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nrj_id; 
	
	@AccessType(value="property")
	@Column(name="NRJ_COUNT")
	private int nrj_count;  //排序
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHANGJIA_ID")
	private ShangJiaInfo shangJiaInfo;  //商家

	public int getNrj_id() {
		return nrj_id;
	}

	public void setNrj_id(int nrj_id) {
		this.nrj_id = nrj_id;
	}


	public int getNrj_count() {
		return nrj_count;
	}

	public void setNrj_count(int nrj_count) {
		this.nrj_count = nrj_count;
	}

	public ShangJiaInfo getShangJiaInfo() {
		return shangJiaInfo;
	}

	public void setShangJiaInfo(ShangJiaInfo shangJiaInfo) {
		this.shangJiaInfo = shangJiaInfo;
	}


	


}
