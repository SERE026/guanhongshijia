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
 * 身边美容院
 * 
 * @author ly
 * 
 */
public class AtBeautyShopBean {

	private int id;
	private String atBeautyImg;
	private String atBeautyName;
	private double range;
	private String atBeautyAddress;
	private String phone;
	public AtBeautyShopBean(int id, String atBeautyImg, String atBeautyName,
			double range, String atBeautyAddress, String phone) {
		super();
		this.id = id;
		this.atBeautyImg = atBeautyImg;
		this.atBeautyName = atBeautyName;
		this.range = range;
		this.atBeautyAddress = atBeautyAddress;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAtBeautyImg() {
		return atBeautyImg;
	}
	public void setAtBeautyImg(String atBeautyImg) {
		this.atBeautyImg = atBeautyImg;
	}
	public String getAtBeautyName() {
		return atBeautyName;
	}
	public void setAtBeautyName(String atBeautyName) {
		this.atBeautyName = atBeautyName;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
	public String getAtBeautyAddress() {
		return atBeautyAddress;
	}
	public void setAtBeautyAddress(String atBeautyAddress) {
		this.atBeautyAddress = atBeautyAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
