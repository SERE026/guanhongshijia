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

import java.util.HashMap;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantOrderInfo;

public interface MerchantOrderService extends IBaseService {

	public HashMap<String, ?> getOrderListByPageWhere(StringBuffer where,
			PageInfo page);
	
	public MerchantOrderInfo checkMerchant(String o_id,String m_id);
	
	public Object getOrderObjById(String id);
	
	/**
	 * 根据排序模块获取商家
	 * @param orderId 模块ID
	 * @param sql
	 * @param page
	 * @return
	 */
	public List getMerchantPageBywhere(String orderId,String sql,PageInfo page);
}
