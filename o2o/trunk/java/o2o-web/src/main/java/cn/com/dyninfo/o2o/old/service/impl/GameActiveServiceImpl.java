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

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.dao.GameActiveDAO;
import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.service.GameActiveService;

@Service("gameActiveService")
public class GameActiveServiceImpl extends BaseService implements
		GameActiveService {

	@Resource
	private GameActiveDAO gameActiveDAO;

	@Override
	public void initDao() {
		super.initDao();
		this.baseDao=gameActiveDAO;
	}
	@Override
	public void delObjStatusById(String id) {
		Active da=(Active) this.getObjById(id);
		da.setStatus(1);
		this.updateObj(da);
	}
	
}
