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

package cn.com.dyninfo.o2o.furniture.web.setting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;
/**
 * appKey接口管理
 * @author Administrator
 *
 */
@Entity
@Table(name="T_APPKEY")
public class AppKey {
	@Id
	@AccessType(value = "property")
	@Column(name="APPKEY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int appkey_id;
	
	
	@AccessType(value = "property")
	@Column(name = "APP_KEY")
	private String appKey;


	public int getAppkey_id() {
		return appkey_id;
	}


	public void setAppkey_id(int appkeyId) {
		appkey_id = appkeyId;
	}


	public String getAppKey() {
		return appKey;
	}


	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	
	
	
	

	


	
	
	
	
	
	
}
