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

public class OrderGoodsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name = "";
	private double price;
	private int count;
	private double totalPrice;

	/**
	 * @Description 订单内商品
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-10 16:27:28
	 * @update 2014-6-20 14:25:01
	 */
	public OrderGoodsBean(String name, double price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public OrderGoodsBean(String name, double price, int count, double totalPrice) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.totalPrice = totalPrice;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderGoodsBean [name=" + name + ", price=" + price + ", count=" + count + ", totalPrice=" + totalPrice
				+ "]";
	}

}
