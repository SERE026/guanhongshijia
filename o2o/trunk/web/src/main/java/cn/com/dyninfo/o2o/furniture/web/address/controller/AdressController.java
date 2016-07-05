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

package cn.com.dyninfo.o2o.furniture.web.address.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
/**
 *地区管理
 * @author 
 * Jan 27, 2011
 */
@Controller
@RequestMapping("/adress")
public class AdressController {

	@Resource
	private AreaService areaService;
	
	@RequestMapping("/json/selection")
	public void selection(HttpServletRequest request,HttpServletResponse response,String parentId) {
		if(parentId!=null&&parentId.length()>0){
			List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
			ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
		}else{
			List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id is null "));
			ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
		}
	}
	@RequestMapping("/elId/selection")
	public void selectionEl(HttpServletRequest request,HttpServletResponse response,String parentId,String elId) {
		List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
		String jsoin="{\"elId\":\""+elId+"\",\"data\":"+ResponseUtil.getJson(list).toString()+"}";
		ResponseUtil.printl(response,jsoin , "json");
	}
}