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
import cn.com.dyninfo.o2o.old.service.PhoneCodeService;
import cn.com.dyninfo.o2o.old.service.SendMessageService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.dao.PhoneCodeDao;
import cn.com.dyninfo.o2o.old.model.PhoneCode;


@Service("phoneCodeService")
public class PhoneCodeServiceImpl extends BaseService implements PhoneCodeService {

	       @Resource
	       private PhoneCodeDao phonecodedao;
	       
		  	 @Resource
			 private SendMessageService sendMessageService;
	       
	       @Override
	       public void initDao(){
	    	   super.initDao();
	    	   this.baseDao=phonecodedao;
	       }

		@Override
		public Object addObj(Object obj) {
			PhoneCode pc = (PhoneCode)obj;
			//
			 sendMessageService.addData("0", "您正在进行炫品妆成手机号验证："+pc.getCode(), pc.getPhone(), "手机号验证", "手机号验证");
			//
			return phonecodedao.addObj(obj);
		}
	       
	       
}
