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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.ShangJiaDao;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
/**
 * 商家资料
 * @author Administrator
 *
 */
@Service("shangJiaService")
public class ShangJiaServiceImpl extends BaseService implements ShangJiaService{
	@Resource
	private ShangJiaDao shangJiaDAO;

	@Override
	public void initDao() {
		super.initDao();
		this.baseDao=shangJiaDAO;
	
	}
	public void delObjStatusById(String id) {
		ShangJiaInfo user = (ShangJiaInfo) shangJiaDAO.getObjById(id);
		user.setState("1");
		shangJiaDAO.updateObj(user);//假删除
	}
	public List<ShangJiaInfo> getWhere(StringBuffer where) {
		return shangJiaDAO.getWhere(where);
	}
	@Override
	public Map getActGood(String sql, String shopId, PageInfo page,String orderBy) {
		return shangJiaDAO.getActGood(sql, shopId, page,orderBy);
	}
	@Override
	public Map getGoodsByAct(String sql, String shopId, PageInfo page,String orderBy) {
		return shangJiaDAO.getGoodsByAct(sql, shopId, page,orderBy);
	}
	@Override
	public Map getGoodsBySort(String sql, String shopId, PageInfo page,String orderBy) {
		return shangJiaDAO.getGoodsBySort(sql, shopId, page,orderBy);
	}
	
	@Override
	public void updateShangpin(int Id) {
       shangJiaDAO.updateShangpin(Id);		
	}
	
	@Override
	public List getNearshop(double lon, double lat,PageInfo page) {
		return shangJiaDAO.getNearshop(lon, lat,page);
	}
	@Override
	public List getNeargoods(double lon, double lat, int moduleId,PageInfo page,String sql) {
		return shangJiaDAO.getNeargoods(lon, lat, moduleId,page, sql);
	}
	@Override
	public List getNearmrxm(double lon, double lat, PageInfo page) {
		
		return shangJiaDAO.getNearmrxm(lon, lat,page);
	}
	
	public List getByCityId(String cityid, PageInfo page){
		return shangJiaDAO.getByCityId(cityid, page);
	}
}
