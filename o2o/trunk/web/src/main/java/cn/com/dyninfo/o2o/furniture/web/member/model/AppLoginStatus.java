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

package cn.com.dyninfo.o2o.furniture.web.member.model;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="T_APP_LOGIN_STATUS")
public class AppLoginStatus implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value="property")
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@AccessType("property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;

	@AccessType(value="property")
	@Column(name="DEVICE_ID")
	private String deviceId;

	@AccessType(value="property")
	@Column(name="TOKEN")
	private String token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}

	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
