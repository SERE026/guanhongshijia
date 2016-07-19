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

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.MerchantsApplyService;

/**
 * 商家加盟
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/merchantsApply")
public class MerchantsApplyController  {

	@Resource
	private MerchantsApplyService merchantsApplyService;
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		PageInfo  page=new PageInfo();
		StringBuffer where=	new StringBuffer();
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			page.setPageNo(1);
		}else{
			page.setPageNo(Integer.parseInt(pageNo));
		}
		page.setPageSize(25);
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		if(name!=null&&name.length()>0){
			where.append(" and n.name like '%"+name+"%'");
			mav.addObject("name", name);
		}
		if(type!=null&&type.length()>0){
			where.append(" and n.storeType.name like '%"+type+"%'");
			mav.addObject("type", type);
		}
		mav.addAllObjects(merchantsApplyService.getListByPageWhere(where, page));
		mav.setViewName("/jiameng/merchants/list");
		return mav;
	} 
	
	
	/**
	 * 删除 表单 name=“list” 的对象
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/all/del",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			String ids[]=request.getParameterValues("list");
			if(ids!=null){
				for(String id:ids){
					merchantsApplyService.delObjById(id);
				}
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		
		mav.setViewName("redirect:/html/manage/merchantsApply/list");
		return mav;
	}
	
	/**
	 * 删除 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/del")
	public ModelAndView del(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			merchantsApplyService.delObjById(id);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		
		mav.setViewName("redirect:/html/manage/merchantsApply/list");
		return mav;
	}
	
}
