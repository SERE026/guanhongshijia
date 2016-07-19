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

package cn.com.dyninfo.o2o.furniture.web.league.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.BusinessType;
import cn.com.dyninfo.o2o.old.service.BusinessTypeService;

@Controller
@RequestMapping("/manage/businessType")
public class BusinessTypeController extends BaseController {

	@Resource
	private BusinessTypeService businessTypeService;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, BusinessType obj) {
		return super.add(request, obj);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, BusinessType obj) {
		return super.endit(request, obj);
	}
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer(" and n.status=0 order by n.orderIndex asc ");
		return super.list(request, where);
	}
	@RequestMapping(value="/{id}/del")
	public ModelAndView del(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		BusinessType businesstype =	(BusinessType) businessTypeService.getObjById(id);
		businesstype.setStatus(1);
		businessTypeService.updateObj(businesstype);
		mav.setViewName("redirect:/html/manage/businessType/list");
		return mav;
	}
	@Override
	public void initService() {
		this.baseService=businessTypeService;
		this.table="businessType";
		this.business="shangjia";
		this.del=false;
	}
}
