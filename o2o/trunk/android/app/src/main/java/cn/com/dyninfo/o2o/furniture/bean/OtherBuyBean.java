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

package cn.com.dyninfo.o2o.furniture.bean;

public class OtherBuyBean {
	// "name": "玉兰油保湿清新面膜1片",
	// "imgUrl": "http://www.xpzc.com/upload/goods/1396234290297.jpg",
	// "shopname": "国际名妆",
	// "salesMoney": "15.0",
	// "goods_id": 70,
	// "bazaarMoney": 15

	private String goodsID;
	private String name;
	private String shopName;
	private String img;
	private double beforePrice;
	private double nowPrice;

	/**
	 * @ClassName OtherBuyBean
	 * @Description 其他人还买了pojo
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-7-11 下午2:39:48
	 */
	public OtherBuyBean(String goodsID, String name, String shopName, String img, double beforePrice, double nowPrice) {
		this.goodsID = goodsID;
		this.name = name;
		this.shopName = shopName;
		this.img = img;
		this.beforePrice = beforePrice;
		this.nowPrice = nowPrice;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getBeforePrice() {
		return beforePrice;
	}

	public void setBeforePrice(double beforePrice) {
		this.beforePrice = beforePrice;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

}
