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

package cn.com.dyninfo.o2o.furniture.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.LogService;

@Controller
@RequestMapping("/manage/log")
public class LogController {

	
	@Resource
	private LogService logService;
	
	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		StringBuffer where=new StringBuffer();
		String url=(String) request.getSession().getAttribute("url");
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0)
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		else
			page.setPageNo(1);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		String time=request.getParameter("time");
		String name=request.getParameter("name");
		if(time!=null&&time.length()>0){
			mav.addObject("time", time);
			where.append(" and n.time like '"+time+"%'");
		}
		if(name!=null&&name.length()>0){
			mav.addObject("name", name);
			where.append(" and n.user.login_id like '%"+name+"%'");
		}
		mav.addAllObjects(logService.getListByPageWhere(where, page));
		//mav.setViewName("'"+"redirect:"+url+"'");
		mav.setViewName("/base/log/list");
		return mav;
	}
	
	/**
	 * 删除 表单 name=“list” 的对象
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/del/all",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			String ids[]=request.getParameterValues("list");
			if(ids!=null){
				for(String id:ids){
					logService.delObjById(id);
				}
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		mav.setViewName("redirect:/html/manage/log/list");
		
		return mav;
	}
	
	/**
	 * 删除 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/del/{id}")
	public ModelAndView del(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			logService.delObjById(id);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		mav.setViewName("redirect:/html/manage/log/list");
		
		return mav;
	}
}
