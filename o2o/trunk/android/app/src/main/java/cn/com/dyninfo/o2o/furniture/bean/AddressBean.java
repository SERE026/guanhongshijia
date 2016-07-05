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

public class AddressBean implements Serializable {

	private String id = "";
	private String name = "";
	private String street = "";
	private String phone = "";
	private String province = "";
	private String city = "";
	private String area = "";

	/**
	 * @Description 个人收货地址pojo
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-8 14:02:02
	 * @update 2014-7-5 16:12:15
	 */
	public AddressBean(String id, String name, String phone, String street, String province, String city, String area) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.street = street;
		this.province = province;
		this.city = city;
		this.area = area;
	}

	public AddressBean(String name, String phone, String street, String province, String city, String area) {
		this.name = name;
		this.phone = phone;
		this.street = street;
		this.province = province;
		this.city = city;
		this.area = area;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @Description 返回 详细地址
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 */
	public String getAddr() {
		return province + city + area + street;
	}

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
}
