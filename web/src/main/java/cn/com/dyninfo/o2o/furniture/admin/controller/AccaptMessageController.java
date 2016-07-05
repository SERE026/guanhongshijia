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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.admin.model.AccaptMessageInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.MessageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;


/**
 * 	接收消息
 *  @author 王敏
 *	Feb 20, 2012
 */
@Controller
@RequestMapping("/manage/accapt")
public class AccaptMessageController extends BaseController{
	@Resource
	private MessageService messageService;
	
	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		StringBuffer sb=new StringBuffer();
//		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
//		sb.append(" and n.ids ='"+user.getLogin_id()+"' ");
		sb.append(" and n.statu ='0'");
		sb.append(" and n.type='0'");
		sb.append(" and n.status ='0'");
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0)
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		else
			page.setPageNo(1);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/message/accaptlist");
	
		mav.addAllObjects(messageService.getListAccaptByPageWhere(sb, page));
		return mav;
	}
	
	/**
	 * 查看
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/show")
	public ModelAndView show(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		AccaptMessageInfo accapt=(AccaptMessageInfo) messageService.getAccaptById(id);
		accapt.setStatus("1");
		messageService.updateObj(accapt);
		mav.addObject("info", accapt);
		mav.setViewName("/base/message/accaptshow");
		return mav;
	}
	
	/**
	 * 查看
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/status")
	public void status(@PathVariable String id,HttpServletResponse response ){
		AccaptMessageInfo accapt=(AccaptMessageInfo) messageService.getAccaptById(id);
		accapt.setStatus("1");
		messageService.updateObj(accapt);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try {
			response.getWriter().write("1");
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/search")
	public void search(String ids,HttpServletRequest request,HttpServletResponse response ){
		
//			UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
			List<AccaptMessageInfo> list=(List<AccaptMessageInfo>) messageService.getListAccaptByPageWhere(new StringBuffer("  and n.status='0' and statu='0' and type='0'"));
			HashMap map=new HashMap();
			map.put("accaptList", list);
			ResponseUtil.printl(response, ResponseUtil.getJson(map).toString(), "json");
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request) {
	    StringBuffer where=new StringBuffer();
	    StringBuffer sb=new StringBuffer();
	    sb.append(" and n.statu ='0'");
	    sb.append(" and n.type ='0'");
		sb.append(" and n.status ='0'");
		List<AccaptMessageInfo> list=messageService.getListAccaptByPageWhere(sb);
		if(list!=null){
		for(AccaptMessageInfo info:list){
			info.setStatu("1");
			messageService.updateObj(info);
		}
		}
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0)
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		else
			page.setPageNo(1);
	    where.append(" and n.status='0' and  n.is_tj='1'");
	    where.append(" and n.type='1' order by n.id desc");
	    ModelAndView mav=new ModelAndView();
		return new ModelAndView("redirect:/html/manage/order/list?id=4028819a418b799b01418c98502c0003","订单管理",0);
	}
}
