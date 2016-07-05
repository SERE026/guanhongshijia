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

package cn.com.dyninfo.o2o.furniture.web.publish.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Refundorder;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.MerchantMoneyDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantMoneyService;

@Service("merchantMoneyService")
public class MerchantMoneyServiceImpl extends BaseService implements
MerchantMoneyService {

	@Resource
	private MerchantMoneyDAO merchantMoneyDAO;

	@Override
	public void initDao() {
		this.baseDao=merchantMoneyDAO;
	}

	/**
	 * 添加订单购买流水
	 * @param order
	 */
	@Override
	public boolean addOrderMoney(Order order){
		return merchantMoneyDAO.addOrderMoney(order);
	}
	
	/**
	 * 添加归属购买流水
	 * @param order
	 */
	@Override
	public boolean addAttribution(Order order){
		return merchantMoneyDAO.addAttribution(order);
	}

	/**
	 * 添加退款流水
	 */
	@Override
	public boolean addRefundOrderMoney(Refundorder order) {
		return merchantMoneyDAO.addRefundOrderMoney(order);
	}


}
