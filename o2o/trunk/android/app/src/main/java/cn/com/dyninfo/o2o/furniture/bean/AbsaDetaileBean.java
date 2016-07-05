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
 * 
 * 身边美容院详情bean
 * 
 * @author ly
 * @update 2014-7-22 17:06:59 by <a
 *         href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
 * 
 */
public class AbsaDetaileBean {

	private int goodId;
	private String Img;
	private String Name;
	private double NowPrice;
	private double OldPrice;
	private double discount;

	public AbsaDetaileBean(int goodId, String Img, String Name, double NowPrice, double OldPrice, double discount) {
		super();
		this.goodId = goodId;
		this.Img = Img;
		this.Name = Name;
		this.NowPrice = NowPrice;
		this.OldPrice = OldPrice;
		this.discount = discount;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String Img) {
		this.Img = Img;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public double getNowPrice() {
		return NowPrice;
	}

	public void setNowPrice(double NowPrice) {
		this.NowPrice = NowPrice;
	}

	public double getOldPrice() {
		return OldPrice;
	}

	public void setOldPrice(double OldPrice) {
		this.OldPrice = OldPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}