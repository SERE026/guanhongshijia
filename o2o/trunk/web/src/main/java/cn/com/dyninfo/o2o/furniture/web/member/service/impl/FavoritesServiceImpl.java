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

package cn.com.dyninfo.o2o.furniture.web.member.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.member.dao.FavoritesDAO;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;

@Service("favoritesService")
public class FavoritesServiceImpl extends BaseService implements FavoritesService {

	@Resource
	private FavoritesDAO favoritesDAO;

	@Override
	public void initDao() {
		this.baseDao=favoritesDAO;
	}

	@Override
	public void addGoods(List<Map> list) {
		favoritesDAO.addGoods(list);
		
	}

	@Override
	public List getGoodsactive(int memberId,PageInfo page) {
		return favoritesDAO.getGoodsactive(memberId,page);
	}

	@Override
	public int getGoodsActiveCount(int memberId) {
		// TODO Auto-generated method stub
		return favoritesDAO.getGoodsActiveCount(memberId);
	}
	
}
