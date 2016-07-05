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

import java.io.Serializable;

/**
 * @author ly
 * @updated 2014-8-1 16:40:56 by <a
 *          href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 */
public class BuyCarBean implements Serializable {

	private static final long serialVersionUID = 20140801171322L;

	private String buyCarImg;
	private String buyCarName;
	private double item_line_money;
	private int count;
	private String cars_box_id;// 购物车id
	private int good_id;// 商品id
	private int shop_id;// 店铺id
	private String specVal;// 属性值
	private String actInfo; // 活动的相关值
	private String type; // 类型（基本不用）

	public BuyCarBean(String buyCarImg, String buyCarName, double item_line_money, int count, String cars_box_id,
			int good_id, int shop_id, String specVal, String actInfo, String type) {
		super();
		this.buyCarImg = buyCarImg;
		this.buyCarName = buyCarName;
		this.item_line_money = item_line_money;
		this.count = count;
		this.cars_box_id = cars_box_id;
		this.good_id = good_id;
		this.shop_id = shop_id;
		this.specVal = specVal;
		this.actInfo = actInfo;
		this.type = type;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getBuyCarImg() {
		return buyCarImg;
	}

	public void setBuyCarImg(String buyCarImg) {
		this.buyCarImg = buyCarImg;
	}

	public String getBuyCarName() {
		return buyCarName;
	}

	public void setBuyCarName(String buyCarName) {
		this.buyCarName = buyCarName;
	}

	public double getItem_line_money() {
		return item_line_money;
	}

	public void setItem_line_money(double item_line_money) {
		this.item_line_money = item_line_money;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCars_box_id() {
		return cars_box_id;
	}

	public void setCars_box_id(String cars_box_id) {
		this.cars_box_id = cars_box_id;
	}

	public int getGood_id() {
		return good_id;
	}

	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}

	public String getSpecVal() {
		return specVal;
	}

	public void setSpecVal(String specVal) {
		this.specVal = specVal;
	}

	public String getActInfo() {
		return actInfo;
	}

	public void setActInfo(String actInfo) {
		this.actInfo = actInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
