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

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.MerchantOrderDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantOrderInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantOrderService;

@Service("merchantOrderService")
public class MerchantOrderServiceImpl extends BaseService implements
		MerchantOrderService {

	@Resource
	private MerchantOrderDAO merchantOrderDAO;

	@Override
	public void initDao() {
		this.baseDao=merchantOrderDAO;
	}

	@Override
	public HashMap<String, ?> getOrderListByPageWhere(StringBuffer where,
			PageInfo page) {
		return merchantOrderDAO.getOrderListByPageWhere(where, page);
	}

	@Override
	public MerchantOrderInfo checkMerchant(String o_id, String m_id) {
		// TODO Auto-generated method stub
		return merchantOrderDAO.checkMerchant(o_id, m_id);
	}
	
	public Object getOrderObjById(String id){
		return merchantOrderDAO.getOrderObjById(id);
	}

	@Override
	public List getMerchantPageBywhere(String orderId, String sql, PageInfo page) {
		// TODO Auto-generated method stub
		return merchantOrderDAO.getMerchantPageBywhere(orderId, sql, page);
	}
	
	
	
}
