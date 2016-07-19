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

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.MerchantTypeDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantTypeService;

@Service("merchantTypeService")
public class MerchantTypeServiceImpl extends BaseService implements
		MerchantTypeService {

	@Resource
	private MerchantTypeDAO merchantTypeDAO;

	@Override
	public void initDao() {
		this.baseDao=merchantTypeDAO;
	}

	@Override
	public void delObjStatusById(String id) {
		MerchantType type=(MerchantType) this.getObjById(id);
		type.setStatus(1);
		this.updateObj(type);
	}
	
	
}
