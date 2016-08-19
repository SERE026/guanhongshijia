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
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;

public interface CarsService extends IBaseService{

	/**
	 * 加入购物车
	 * @param Money
	 * @param num
	 * @param good_id
	 * @param response
	 * @param request
	 * @param specVal
	 * @param actId
	 * @param actMoney
	 */
	public Map addGoods(Double Money,int num,int good_id,HttpServletResponse response,HttpServletRequest request,String specVal,String actId,Double actMoney);

	/**
	 * 安卓加入购物车
	 * @param Money
	 * @param num
	 * @param good_id
	 * @param specVal
	 * @param huiYuan_id
	 * @param actInfo
	 */
	public Map addGoodsApp(Double Money,int num,int good_id,String specVal,int huiYuan_id,String actInfo);

	public List getGoods(HttpServletRequest request);
	
	
	public void delCar(List<HashMap> delVal,HttpServletResponse response,HttpServletRequest request);
	
	public void checkCar(HttpServletResponse response,HttpServletRequest request);
	
	public void checkCarGoodSpec(HttpServletResponse response,HttpServletRequest request);
	
	public String checkGoodSpecVal(String goodID,String specVal);
	
	/**
	 * 直接购买
	 * @param Money
	 * @param num
	 * @param good_id
	 * @param response
	 * @param request
	 * @param specVal
	 * @param actId
	 * @param actMoney
	 * @return 购物车ID
	 */
	public String BuyGoods(Double Money,int num,int good_id,HttpServletResponse response,HttpServletRequest request,String specVal,String actId,Double actMoney);

	
}
