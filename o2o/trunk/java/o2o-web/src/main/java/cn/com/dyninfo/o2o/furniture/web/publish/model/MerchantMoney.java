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

package cn.com.dyninfo.o2o.furniture.web.publish.model;

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

import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.model.Order;

/**
 * 商家店铺流水信息
 * @author 王敏
 *
 */

@Entity
@Table(name="T_MERCHANT_MONEY")
public class MerchantMoney {

	@Id
	@AccessType(value = "property")
	@Column(name="ID",length=32)
	@GeneratedValue(generator = "system-uuid")  
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID")
	private ShangJiaInfo merchant;//自己店铺
	
	@AccessType(value = "property")
	@Column(name="MONEY")
	private Double money;//交易金额
	
	@AccessType(value = "property")
	@Column(name="FLAG")
	private int flag;//交易类型 0支付 1收入
	
	@AccessType(value = "property")
	@Column(name="PS")
	private String ps;//交易备注
	
	@AccessType(value = "property")
	@Column(name="TYPE")
	private int type;//0 店铺购买 1归属会员在其他店铺购买 2其他店铺会员在自己店铺购买 3自己会员在其他店铺购买 
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHANGJIA_ID")
	private ShangJiaInfo shangjia;//对方店铺
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HUIYUAN_ID")
	private HuiyuanInfo huiyuan;//会员账号
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private Order order;//订单
	
	@AccessType(value = "property")
	@Column(name="BRANK_CARD")
	private String brankCard;//提现时 银行卡号
	
	@AccessType(value = "property")
	@Column(name="BRANK_NAME")
	private String brankName;//提现时 银行名称
	
	@AccessType(value = "property")
	@Column(name="TIME")
	private String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // 日期

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

	/**
	 * @return the merchant
	 */
	public ShangJiaInfo getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(ShangJiaInfo merchant) {
		this.merchant = merchant;
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
	 * @return the ps
	 */
	public String getPs() {
		return ps;
	}

	/**
	 * @param ps the ps to set
	 */
	public void setPs(String ps) {
		this.ps = ps;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the shangjia
	 */
	public ShangJiaInfo getShangjia() {
		return shangjia;
	}

	/**
	 * @param shangjia the shangjia to set
	 */
	public void setShangjia(ShangJiaInfo shangjia) {
		this.shangjia = shangjia;
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
	 * @return the brankCard
	 */
	public String getBrankCard() {
		return brankCard;
	}

	/**
	 * @param brankCard the brankCard to set
	 */
	public void setBrankCard(String brankCard) {
		this.brankCard = brankCard;
	}

	/**
	 * @return the brankName
	 */
	public String getBrankName() {
		return brankName;
	}

	/**
	 * @param brankName the brankName to set
	 */
	public void setBrankName(String brankName) {
		this.brankName = brankName;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
