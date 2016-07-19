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

import cn.com.dyninfo.o2o.old.service.BbsPostService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.dao.BbsPostDAO;
import cn.com.dyninfo.o2o.old.model.BbsUserInfo;

@Service("bbsPostService")
public class BbsPostServiceImpl extends BaseService implements BbsPostService {

	@Resource
	private BbsPostDAO bbsPostDAO;

	@Override
	public void initDao() {
		this.baseDao=bbsPostDAO;
	}

	@Override
	public BbsUserInfo getUser(String id, String role) {
		return bbsPostDAO.getUser(id, role);
	}
	
	
}
