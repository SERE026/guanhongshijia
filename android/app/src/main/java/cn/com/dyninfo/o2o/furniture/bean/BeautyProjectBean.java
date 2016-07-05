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
 * 美容项目
 * 
 * @author ly
 * 
 */
public class BeautyProjectBean {

	private String beautyProjectImg;
	private String beautyProjectName;
	private String beautyProjectAddress;
	private double nowPrice;
	private double oldPrice;
	private double discount;
	private int goods_id;// 商品id

	public BeautyProjectBean(String beautyProjectImg, String beautyProjectName, String beautyProjectAddress,
			double nowPrice, double oldPrice, double discount, int goods_id) {
		this.beautyProjectImg = beautyProjectImg;
		this.beautyProjectName = beautyProjectName;
		this.beautyProjectAddress = beautyProjectAddress;
		this.nowPrice = nowPrice;
		this.oldPrice = oldPrice;
		this.discount = discount;
		this.goods_id = goods_id;
	}

	public String getBeautyProjectImg() {
		return beautyProjectImg;
	}

	public void setBeautyProjectImg(String beautyProjectImg) {
		this.beautyProjectImg = beautyProjectImg;
	}

	public String getBeautyProjectName() {
		return beautyProjectName;
	}

	public void setBeautyProjectName(String beautyProjectName) {
		this.beautyProjectName = beautyProjectName;
	}

	public String getBeautyProjectAddress() {
		return beautyProjectAddress;
	}

	public void setBeautyProjectAddress(String beautyProjectAddress) {
		this.beautyProjectAddress = beautyProjectAddress;
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
