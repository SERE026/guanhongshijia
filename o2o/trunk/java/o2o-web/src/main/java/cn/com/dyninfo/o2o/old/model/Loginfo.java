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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name="T_LOG_INFO")
public class Loginfo implements Serializable{

	  @Id
	  @AccessType(value="property")
	  @Column(name="INTERGRAL_ID")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int intergral_id;
	
	  @AccessType(value="property")
	  @Column(name="TIME")
	  private String time;  //日期
	  
	  @AccessType(value="property")
	  @Column(name="EXPLAIN_INFO")
	  private String explain;  //说明内容
	  
	  @AccessType(value="property")
	  @Column(name="TYPE")
	  private String type;  //类型 0为积分日志 1为消息日志
	  
	  @AccessType(value="property")
	  @Column(name="JF")
	  private int jf=0;  //当为正数时为增加积分，为负数时减少积分
	  
	  
	  @AccessType(value = "property")
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="HUIYUAN_ID")
	  private HuiyuanInfo huiyuan;


	public int getIntergral_id() {
		return intergral_id;
	}


	public void setIntergral_id(int intergral_id) {
		this.intergral_id = intergral_id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getJf() {
		return jf;
	}


	public void setJf(int jf) {
		this.jf = jf;
	}


	public String getExplain() {
		return explain;
	}


	public void setExplain(String explain) {
		this.explain = explain;
	}


	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}


	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	  
}