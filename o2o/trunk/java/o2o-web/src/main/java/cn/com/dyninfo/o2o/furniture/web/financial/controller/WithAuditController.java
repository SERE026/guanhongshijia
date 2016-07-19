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

package cn.com.dyninfo.o2o.furniture.web.financial.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.Withdrawal;
import cn.com.dyninfo.o2o.furniture.web.publish.service.WithdrawalService;

@Controller
@RequestMapping("/manage/withdrawalAudit")
public class WithAuditController extends BaseController{

	@Resource
	private WithdrawalService withdrawalService;
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer(" and n.state=0");
		return super.list(request, where);
	}
	
	@Override
	public void initService() {
		this.baseService=withdrawalService;
		this.business="financial";
		this.table="withdrawal";
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Withdrawal obj) {
		obj=(Withdrawal) withdrawalService.getObjById(obj.getId());
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		obj.setNo(request.getParameter("no"));
		obj.setUser(user);
		obj.setState(2);
		obj.setCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		withdrawalService.updateQueRen(obj);
		ModelAndView mav=new ModelAndView();
		if(obj.getId()!=null){
			mav.addObject("C_STATUS", 1);
		}else{
			mav.addObject("C_STATUS", 0);
		}
		
		mav.setViewName("redirect:/html/manage/withdrawalAudit/list");
		return mav;
	}
	@RequestMapping(value="/{id}/zf/disUpdate")
	public ModelAndView disUpdateZf(@PathVariable String id,HttpServletRequest request) {
		Withdrawal obj=(Withdrawal) withdrawalService.getObjById(id);
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		obj.setUser(user);
		obj.setState(1);
		obj.setCtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		withdrawalService.updateObj(obj);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/html/manage/withdrawalAudit/list");
		return mav;
	}
	
}
