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

package cn.com.dyninfo.o2o.furniture.web.publish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantTypeService;

@Controller
@RequestMapping("/manage/merchantType")
public class MerchantTypeController extends BaseController {

	@Resource
	private MerchantTypeService merchantTypeService;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, MerchantType obj) {
		String TypeId=request.getParameter("TypeId");
		if(TypeId!=null&&TypeId.length()>0){
			MerchantType mt=(MerchantType) merchantTypeService.getObjById(TypeId);
			obj.setParent(mt);
		}
		return super.add(request, obj);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, MerchantType obj) {
		String TypeId=request.getParameter("TypeId");
		if(TypeId!=null&&TypeId.length()>0){
			MerchantType mt=(MerchantType) merchantTypeService.getObjById(TypeId);
			obj.setParent(mt);
		}
		return super.endit(request, obj);
	}

	@Override
	public void initService() {
		this.baseService=merchantTypeService;
		this.table="merchantType";
		this.business="shangjia";
		this.del=false;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer(" and n.status=0 order by n.orderIndex asc ");
		return super.list(request, where);
	}

	@RequestMapping("/disAdd")
	public ModelAndView disAdd(HttpServletRequest request) {
		ModelAndView mav=super.disAdd(request);
		mav.addObject("data", merchantTypeService.getListByWhere(new StringBuffer(" and n.status=0 ")));
		return mav;
	}

	@RequestMapping("/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id, HttpServletRequest request) {
		ModelAndView mav=super.disUpdate(id,request);
		mav.addObject("data", merchantTypeService.getListByWhere(new StringBuffer(" and n.status=0 ")));
		return mav;
	}
	
}
