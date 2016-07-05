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

import java.util.List;
import cn.com.dyninfo.o2o.furniture.util.APPCode;

/**
 * @Description 我的订单
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-14 下午4:26:56
 * @update 2014-8-15 18:14:24
 */
public class OrderBean {

	private int payStatusCode; // 支付状态码
	private String payStatus; // 支付状态文本说明
	private String id;
	private String orderNo = "";
	private String datetime = "";
	private List<OrderGoodsBean> item_list;
	private double totalPrice; // 总价
	private double freight; // 运费

	public OrderBean(String id, int payStatusCode, String orderNo, String datetime, List<OrderGoodsBean> item_list,
			double totalPrice, double freight) {
		this.id = id;
		this.payStatusCode = payStatusCode;
		this.orderNo = orderNo;
		this.datetime = datetime;
		this.item_list = item_list;
		this.totalPrice = totalPrice;
		this.freight = freight;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public int getPayStatusCode() {
		return payStatusCode;
	}

	public void setPayStatusCode(int payStatusCode) {
		this.payStatusCode = payStatusCode;
	}

	public String getPayStatus() {
		return APPCode.getOrderPay(payStatusCode);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public List<OrderGoodsBean> getItem_list() {
		return item_list;
	}

	public void setItem_list(List<OrderGoodsBean> item_list) {
		this.item_list = item_list;
	}

}
