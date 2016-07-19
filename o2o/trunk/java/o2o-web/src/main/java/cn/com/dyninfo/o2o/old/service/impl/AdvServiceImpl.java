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

import cn.com.dyninfo.o2o.old.dao.AdvDao;
import cn.com.dyninfo.o2o.old.service.AdvService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.service.BaseService;


@Service("advService")
public class AdvServiceImpl extends BaseService implements AdvService {

	    @Resource
	    private AdvDao advDao;
	    
	    @Override
	    public void initDao(){
	    	super.initDao();
	    	this.baseDao=advDao;
	    }
}
