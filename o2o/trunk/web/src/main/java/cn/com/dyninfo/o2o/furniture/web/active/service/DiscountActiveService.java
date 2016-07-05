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

package cn.com.dyninfo.o2o.furniture.web.active.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

public interface DiscountActiveService extends IBaseService {

	// 根据商品获取活动
	public Active getActiveByGoods(Goods goods);
	
	public HashMap<String, ?> getGoodListByPageWhere(StringBuffer where,
			PageInfo page);
	
	public List getGoodListByWhere(StringBuffer where);
	
	public void addLink(List<Map> list);
	
	public void delLink(String actId,String goodId);

	public void updateActive(HttpServletRequest request,String id);
	
	public void updateActiveGoodsIndex(Active act);
	
	public int getActGoodsCount(StringBuffer where);
	
	public List getActGoodsByList(StringBuffer where,PageInfo page);

}
