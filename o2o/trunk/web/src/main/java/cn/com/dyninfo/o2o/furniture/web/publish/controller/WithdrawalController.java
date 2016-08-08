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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.Withdrawal;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.WithdrawalService;

@Controller
@RequestMapping("/manage/withdrawal")
public class WithdrawalController extends BaseController {

	@Resource
	private WithdrawalService withdrawalService;
	
	@Resource
	private ShangJiaService shangJiaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, Withdrawal obj) {
		ModelAndView mav=new ModelAndView();
		ShangJiaInfo  shangjia=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(shangjia==null){
			mav.setViewName("redirect:/html/manage/withdrawal/list");
			return mav;
		}
		shangjia=(ShangJiaInfo) shangJiaService.getObjById(""+shangjia.getShangjia_id());
		StringBuffer where=new StringBuffer();
		where.append(" and n.merchants.shangjia_id="+shangjia.getShangjia_id());
		where.append(" and n.state=0 ");
		List list=withdrawalService.getListByWhere(where);
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		if(obj.getMoney()<=shangjia.getMoney()&&list.size()==0&&obj.getUserName().equals(user.getUser_name())){
			obj.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			obj.setMerchants(shangjia);
			withdrawalService.addObj(obj);
		}
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
		
	}
	
	@RequestMapping(value="/ch/list")
	public void chList(HttpServletRequest request,HttpServletResponse response) {
		StringBuffer where=new StringBuffer();
		ShangJiaInfo  shangjia=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		shangjia=(ShangJiaInfo) shangJiaService.getObjById(""+shangjia.getShangjia_id());
		where.append(" and n.merchants.shangjia_id="+shangjia.getShangjia_id());
		where.append(" and n.state=0 ");
		List list=withdrawalService.getListByWhere(where);
		String money=request.getParameter("money");
		String name=request.getParameter("name");
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		if(Double.parseDouble(money)<=shangjia.getMoney()&&list.size()==0&&name.equals(user.getUser_name())){
			ResponseUtil.printl(response, "{\"status\":0}", "json");
			//可以提交
		}else{
			ResponseUtil.printl(response, "{\"status\":1}", "json");
			//不能提交
		}
		
		
	}

	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/"+business+"/"+table+"/add");
		ShangJiaInfo  shangjia=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(shangjia!=null){
			shangjia=(ShangJiaInfo) shangJiaService.getObjById(""+shangjia.getShangjia_id());
			mav.addObject("info", shangjia);
		}else{
			mav.setViewName("redirect:/html/manage/"+table+"/list");
		}
		return mav;
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Withdrawal obj) {
		return super.endit(request, obj);
	}

	@Override
	public void initService() {
		this.baseService=withdrawalService;
		this.business="shangjia";
		this.table="withdrawal";
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer();
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(merchants!=null){
			where.append(" and n.merchants.shangjia_id="+merchants.getShangjia_id());
		}
		return super.list(request, where);
	}
	
	
}
