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

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/*
 * 收藏
 */
@Entity
@Table(name="T_FAORITES")
public class Favorites {

   @Id
   @AccessType(value="property")
   @Column(name="FAVORITES_ID")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int favorites_id;
   
   @AccessType(value="property")
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="MEMBER_ID")
   private HuiyuanInfo member;//会员
   
   @AccessType(value="property")
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="GOODS_ID")
   private Goods good;//货品
   
   @AccessType(value="property")
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="SHANGJIA_ID")
   private ShangJiaInfo shangJiaInfo;//商家
   
   @AccessType(value="property")

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="MERCHANT_ID")
   private ShangJiaInfo merchant;//店铺
   
   @AccessType(value="property")
   @Column(name="TIME")
   private int time;//收藏时间(当前DATE 取时间除以1000)
   
   @AccessType(value="property")
   @Column(name="TYPE")
   private String type;//收藏类型 0.收藏商品 1.收藏商家

/**
 * @return the favorites_id
 */
public int getFavorites_id() {
	return favorites_id;
}

/**
 * @param favorites_id the favorites_id to set
 */
public void setFavorites_id(int favorites_id) {
	this.favorites_id = favorites_id;
}

/**
 * @return the member
 */
public HuiyuanInfo getMember() {
	return member;
}

/**
 * @param member the member to set
 */
public void setMember(HuiyuanInfo member) {
	this.member = member;
}



/**
 * @return the time
 */
public int getTime() {
	return time;
}

/**
 * @param time the time to set
 */
public void setTime(int time) {
	this.time = time;
}

/**
 * @return the good
 */
public Goods getGood() {
	return good;
}

/**
 * @param good the good to set
 */
public void setGood(Goods good) {
	this.good = good;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}


public ShangJiaInfo getShangJiaInfo() {
	return shangJiaInfo;
}

public void setShangJiaInfo(ShangJiaInfo shangJiaInfo) {
	this.shangJiaInfo = shangJiaInfo;
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


   
}
