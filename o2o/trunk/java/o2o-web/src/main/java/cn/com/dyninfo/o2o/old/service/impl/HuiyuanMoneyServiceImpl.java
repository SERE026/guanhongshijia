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

package cn.com.dyninfo.o2o.old.service.impl;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.old.dao.HuiyuanMoneyDAO;
import cn.com.dyninfo.o2o.old.service.HuiyuanMoneyService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;

@Service("huiyuanMoneyService")
public class HuiyuanMoneyServiceImpl extends BaseService implements
		HuiyuanMoneyService {

	@Resource
	private HuiyuanMoneyDAO huiyuanMoneyDAO;

	@Override
	public void initDao() {
		this.baseDao=huiyuanMoneyDAO;
	}

	@Override
	public boolean addOder(Order order) {
		return huiyuanMoneyDAO.addOder(order);
	}

	@Override
	public boolean addTopup(double money, Zffs zffs, HuiyuanInfo huiyuan) {
		return huiyuanMoneyDAO.addTopup(money, zffs, huiyuan);
	}
	
	
}
