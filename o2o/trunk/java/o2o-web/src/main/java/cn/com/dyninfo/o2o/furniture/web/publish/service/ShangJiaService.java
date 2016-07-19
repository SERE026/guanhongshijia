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

package cn.com.dyninfo.o2o.furniture.web.publish.service;

import java.util.List;
import java.util.Map;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

public interface ShangJiaService extends IBaseService{
	public List<ShangJiaInfo> getWhere(StringBuffer where);
	public Map getGoodsByAct(String sql,String shopId,PageInfo page,String orderBy);
	public Map getGoodsBySort(String sql,String shopId,PageInfo page,String orderBy);
	public Map getActGood(String sql,String shopId,PageInfo page,String orderBy);
	public void updateShangpin(int Id);
	public List getNearshop(double lon,double lat,PageInfo page);
	public List getNeargoods(double lon,double lat , int moduleId,PageInfo page,String sql);
	public List getNearmrxm(double lon,double lat,PageInfo page);
	public List getByCityId(String cityid, PageInfo page);
}