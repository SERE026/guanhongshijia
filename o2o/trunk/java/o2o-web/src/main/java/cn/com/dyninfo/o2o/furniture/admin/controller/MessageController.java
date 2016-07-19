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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.old.model.AccaptMessageInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.UserMessageInfo;
import cn.com.dyninfo.o2o.old.service.MessageService;
import cn.com.dyninfo.o2o.old.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import cn.com.dyninfo.o2o.furniture.util.PageInfo;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/message")
public class MessageController {

	@Resource
	private MessageService messageService;
	
	@Resource
	private UserService userService;
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
//		user=(UserInfo) userService.getObjById(user.getLogin_id());
//		sb.append(" and n.user.login_id ='"+user.getLogin_id()+"' ");
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0)
			page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		else
			page.setPageNo(1);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/message/list");
		mav.addAllObjects(messageService.getListByPageWhere(sb, page));
		return mav;
	}
	/**
	 * 添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/base/message/add");
		return mav;
	}
	/**
	 * 保存
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,UserMessageInfo info){
		ModelAndView mav=new ModelAndView();
		try{
			String ognzId=request.getParameter("ognz");
			if(ognzId!=null){
					AccaptMessageInfo accapt=new AccaptMessageInfo();
					UserInfo user=new UserInfo();
					user.setLogin_id(ognzId);
					accapt.setIds(ognzId);
					accapt.setTitle(info.getTitle());
					accapt.setMessage(info);
					accapt.setContext(info.getMessage());
					accapt.setTime(info.getTime());
					accapt.setMessage(info);
			     messageService.addObj(accapt);
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/message/list");
		return mav;
	}
	/**
	 * 修改
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("info", messageService.getObjById(id));
		mav.setViewName("/base/message/update");
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

		mav.addObject("info", messageService.getObjById(id));
		mav.setViewName("/base/message/show");
		return mav;
	}
	
	/**
	 * 删除 表单 name=“list” 的对象
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delall",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			String ids[]=request.getParameterValues("list");
			for(String id:ids){
				messageService.delObjById(id);
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/message/list");
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
			messageService.delObjById(id);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/message/list");
		return mav;
	}
}
