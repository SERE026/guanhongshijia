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
 * 炫品热销
 * 
 * @author ly
 * 
 */
public class HotMarketBean {

	private int goodId;
	private String hotImg;
	private String hotName;
	private double nowPrice;
	private double oldPrice;
	private double discount;

	public HotMarketBean(int goodId, String hotImg, String hotName, double nowPrice, double oldPrice, double discount) {
		super();
		this.goodId = goodId;
		this.hotImg = hotImg;
		this.hotName = hotName;
		this.nowPrice = nowPrice;
		this.oldPrice = oldPrice;
		this.discount = discount;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getHotImg() {
		return hotImg;
	}

	public void setHotImg(String hotImg) {
		this.hotImg = hotImg;
	}

	public String getHotName() {
		return hotName;
	}

	public void setHotName(String hotName) {
		this.hotName = hotName;
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
}
