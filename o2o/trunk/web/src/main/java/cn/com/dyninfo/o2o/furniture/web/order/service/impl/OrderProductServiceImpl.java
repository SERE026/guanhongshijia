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

package cn.com.dyninfo.o2o.furniture.web.order.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.order.dao.OrderProductDao;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderProductServeice;

@Service("orderProductServeice")
public class OrderProductServiceImpl extends BaseService implements
OrderProductServeice {
	@Resource
	private OrderProductDao orderProductDao;

	@Override
	public void initDao() {
		this.baseDao=orderProductDao;
	}

}
