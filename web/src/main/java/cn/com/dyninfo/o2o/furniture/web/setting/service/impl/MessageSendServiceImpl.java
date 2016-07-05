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

package cn.com.dyninfo.o2o.furniture.web.setting.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.setting.dao.MessageSendDao;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;
/**
 * 消息推送
 * @author Administrator
 *
 */
@Service("messageSendService")
public class MessageSendServiceImpl extends BaseService implements MessageSendService{
	@Resource
    private MessageSendDao messageSendDao;
    
    @Override
    public void initDao(){
 	   super.initDao();
 	   this.baseDao=messageSendDao;
    }

	@Override
	public int getmesBySlqCount(String uid) {
		
		return this.messageSendDao.getmesBySlqCount(uid);
	}

	@Override
	public List getmessage(String uid, PageInfo page) {
		
		return this.messageSendDao.getmessage(uid, page);
	}
}
