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

package cn.com.dyninfo.o2o.furniture.web.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;

@Entity
@Table(name="T_TRADE_INFO")
public class Trade {

	@Id
	@AccessType(value = "property")
	@Column(name="TRADE_ID",length=32)
	private String trade_id ;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ZFFS_ID")
	private Zffs zffs;
	
	@AccessType(value = "property")
	@Column(name="MONEY")
	private Double money;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;//当前会员
	
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private int flag=0;//交易类型0 充值 1订单支付
	
	@AccessType(value = "property")
	@Column(name="STATUS")
	private int status=0;//交易状态0 未成功 1成功



	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Zffs getZffs() {
		return zffs;
	}

	public void setZffs(Zffs zffs) {
		this.zffs = zffs;
	}

	/**
	 * @return the huiyuan
	 */
	public HuiyuanInfo getHuiyuan() {
		return huiyuan;
	}

	/**
	 * @param huiyuan the huiyuan to set
	 */
	public void setHuiyuan(HuiyuanInfo huiyuan) {
		this.huiyuan = huiyuan;
	}


	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * @return the money
	 */
	public Double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Double money) {
		this.money = money;
	}

}
