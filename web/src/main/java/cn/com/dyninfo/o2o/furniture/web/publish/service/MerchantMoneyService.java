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

package cn.com.dyninfo.o2o.furniture.web.publish.service;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Refundorder;

public interface MerchantMoneyService extends IBaseService {

	
	/**
	 * 添加退款流水
	 * @param order
	 * @return
	 */
	public boolean addRefundOrderMoney(Refundorder order);
	
	
	/**
	 * 添加订单购买流水
	 * @param order
	 */
	public boolean addOrderMoney(Order order);
	
	/**
	 * 添加归属购买流水
	 * @param order
	 */
	public boolean addAttribution(Order order);
	
}
