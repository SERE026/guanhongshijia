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

package cn.com.dyninfo.o2o.furniture.web.order.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

/**
 * 订单确认信息
 * @author 王敏
 *
 */
@Controller
@RequestMapping("/confirm")
public class ConfirmController {

	@Resource
	private OrderService orderService;
	
	
	@RequestMapping(value="/distribution",method=RequestMethod.POST)
	public void distribution(HttpServletRequest request,HttpServletResponse reponse){
		String json="";
		Map map=orderService.getDistribution(request);
		List list=(List) map.get("data");
		String status=(String) map.get("status");
		json="{\"status\":\""+status+"\", \"money\":\""+map.get("money")+"\",\"data\":";
		if(list!=null)
			json+=ResponseUtil.getJson(list).toString();
		else
			json+="[]";
		json+="}";
		ResponseUtil.printl(reponse, json, "json");
	}

	@RequestMapping(value="/getShopPrice",method=RequestMethod.POST)
	public void getShopPrice(HttpServletRequest request,HttpServletResponse reponse){
		Map map=orderService.getShopPrice(request);
		String json="{\"dlyprice\":\""+map.get("dlyprice")+"\",\"goodPrice\":"+map.get("goodPrice")+",\"actPrice\":"+map.get("actPrice")+"}";
		ResponseUtil.printl(reponse, json, "json");
	}
	
	
}
