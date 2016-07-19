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


import java.util.HashMap;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.old.dao.PageModuleDAO;
import cn.com.dyninfo.o2o.old.service.PageModuleService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.BaseService;

@Service("pageModuleService")
public class PageModuleServiceImpl extends BaseService implements PageModuleService {

	       @Resource
	       private PageModuleDAO pageModuleDAO;
	       
	       @Override
	       public void initDao(){
	    	   super.initDao();
	    	   this.baseDao=pageModuleDAO;
	       }
	       
	       public void delPagModInGoodsByPagModID(int id){
	    	   pageModuleDAO.delPagModInGoodsByPagModID(id);
	       }

		@Override
		public HashMap<String, ?> getGoodsOrder(StringBuffer where,
				PageInfo page) {
			pageModuleDAO.getGoodsOrder(where,page);
			return pageModuleDAO.getGoodsOrder(where,page);
		}
}
