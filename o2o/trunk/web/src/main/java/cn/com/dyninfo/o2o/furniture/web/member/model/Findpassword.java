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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="T_FINDPASSWORD_INFO")
public class Findpassword implements Serializable{
	  @Id
	  @AccessType(value="property")
	  @Column(name="FINDPASSWORD_ID")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int Findpassword_id;
	  
	  @AccessType(value="property")
	  @Column(name="EMAIL")
	  private String Email;  //修改的邮箱
	  
	  @AccessType(value="property")
	  @Column(name="UUID")
	  private String uuid;  //找回密码uuid
	  
	  @AccessType(value="property")
	  @Column(name="FINDTIME")
	  private String findtime;  //找回密码时间
	  
	  @AccessType(value="property")
	  @Column(name="EDITSTAT")
	  private String editstat;  //是否已经修改过密码 0.没有 1.已修改
	  
	  public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getFindtime() {
			return findtime;
		}

		public void setFindtime(String findtime) {
			this.findtime = findtime;
		}

		public String getEditstat() {
			return editstat;
		}

		public void setEditstat(String editstat) {
			this.editstat = editstat;
		}

		public int getFindpassword_id() {
			return Findpassword_id;
		}

		public void setFindpassword_id(int findpassword_id) {
			Findpassword_id = findpassword_id;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
	  
}