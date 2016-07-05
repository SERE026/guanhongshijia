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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;

/**
 * android 地区
 * @author feng
 *
 */
@Controller
@RequestMapping("/aarea")
public class AareaController{
    

	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		List list=areaService.getListByWhere(new StringBuffer(" and n.isDefault='1' "));
		String json=ResponseUtil.getJson(list).toString();
		String newJson="{\"status\":0,\"data\":"+json+"}";
		ResponseUtil.printl(response, newJson, "json");
	 }
 }