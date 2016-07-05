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

/**
 * @Description 退换货
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-10 16:29:32
 * @update 2014-5-12 12:06:18
 */
public class ReturnGoodsBean {

	private String id;
	private String orderNo = "";
	private String datetime = "";
	private String status = "";
	private List<OrderGoodsBean> item_list;

	public ReturnGoodsBean(String id, String orderNo, String datetime, String status, List<OrderGoodsBean> item_list) {
		this.id = id;
		this.orderNo = orderNo;
		this.datetime = datetime;
		this.status = status;
		this.item_list = item_list;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderGoodsBean> getItem_list() {
		return item_list;
	}

	public void setItem_list(List<OrderGoodsBean> item_list) {
		this.item_list = item_list;
	}

}
