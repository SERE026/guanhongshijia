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

/**
 * 附近宝贝
 * 
 * @author ly
 * 
 */
public class NearbyTreasuredBean {

	private String nearImg;
	private String nearName;
	private double range;
	private String nearAddress;
	private double nowPrice;
	private double oldPrice;
	private double discount;
	private int goods_id;// 商品id

	public NearbyTreasuredBean(String nearImg, String nearName, double range, String nearAddress, double nowPrice,
			double oldPrice, double discount, int goods_id) {
		this.nearImg = nearImg;
		this.nearName = nearName;
		this.range = range;
		this.nearAddress = nearAddress;
		this.nowPrice = nowPrice;
		this.oldPrice = oldPrice;
		this.discount = discount;
		this.goods_id = goods_id;
	}

	public String getNearImg() {
		return nearImg;
	}

	public void setNearImg(String nearImg) {
		this.nearImg = nearImg;
	}

	public String getNearName() {
		return nearName;
	}

	public void setNearName(String nearName) {
		this.nearName = nearName;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public String getNearAddress() {
		return nearAddress;
	}

	public void setNearAddress(String nearAddress) {
		this.nearAddress = nearAddress;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
}
