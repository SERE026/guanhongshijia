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
import cn.com.dyninfo.o2o.furniture.web.publish.dao.MerchantMoneyDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.WithdrawalDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.Withdrawal;
import cn.com.dyninfo.o2o.furniture.web.publish.service.WithdrawalService;

@Service("withdrawalService")
public class WithdrawalServiceImpl extends BaseService implements
		WithdrawalService {

	@Resource
	private WithdrawalDAO withdrawalDAO;
	
	@Resource
	private MerchantMoneyDAO merchantMoneyDAO;

	@Override
	public void initDao() {
		this.baseDao=withdrawalDAO;
	}
	
	public void updateQueRen(Withdrawal info){
		Double mondy=info.getMoney();
		ShangJiaInfo shanjia=info.getMerchants();
		if(shanjia.getMoney()>=mondy){
			if(merchantMoneyDAO.addTX(info)){
				withdrawalDAO.updateObj(info);
			}
		}
		
	}
}
