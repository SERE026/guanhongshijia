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

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.service.SendMessageService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.dao.MessageDAO;

@Service("sendMessageService")
public class SendMessageServiceImpl extends BaseService implements SendMessageService {

	@Resource
	private MessageDAO messageDAO;
	@Override
	public void initDao() {
		this.baseDao=messageDAO;
	}
	@Override
	public void addData(String flag, String msg, String revcName,
			String revcInfo,String title) {
		messageDAO.addData(flag, msg, revcName, revcInfo,title);
		
	}
	@Override
	public void updateMsgStatus(int id) {
		messageDAO.updateMsgStatus(id);
	}
	@Override
	public void sendMessage() {
		messageDAO.sendMessage();
		
	}
	
	
}
