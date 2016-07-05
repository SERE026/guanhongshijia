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

package cn.com.dyninfo.o2o.furniture.web.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;

public interface OrderService extends IBaseService{
	public List getOrderConfirm(String memberId,String carId[]);
	public Map getDistribution(String area_id,String s_ds[]);
	public List getOrderConfirm(HttpServletRequest request); 
	public Map getDistribution(HttpServletRequest request);
	public Double getDistributionMoney(HttpServletRequest request);
	public Map getShopPrice(HttpServletRequest request);
	public boolean create(HttpServletRequest request);
	public List getordershow(int id,PageInfo page);
	public List getbaobei(int id,String name,PageInfo page);
	public HashMap<String,?> getByPageWhere(StringBuffer where,PageInfo page,StringBuffer where2);
	public HashMap<String, ?> getBySqlSjhy(StringBuffer where,PageInfo page);
	
	//会员消费纪录
	public HashMap<String, ?> getBySqlhyxfjl(StringBuffer where,PageInfo page);
	
	public List getListByPage(StringBuffer where);
	
	public void updateOrderPlay(String tradeNo);
	public int getOrderShowCount(int id);
	public int getbaobeiCount(int id,String name);
	
	public void addTrade(Trade trade);
	
	public Trade getTrade(String tradeNo);
	
	public void updateTrade(Trade trade);
	
	//根据交易单号获取金额
	public Double getTradeMoney(String tradeNo);
	
	public List<?> getorderlist(StringBuffer where);
}
