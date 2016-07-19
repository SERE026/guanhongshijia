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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.UserService;

/**
 * 个人办公
 * @author jettang
 * Apr 5, 2011
 */
@Controller
@RequestMapping("/manage/personal")
public class PersonalController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 修改密码页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/changePassWord")
	public ModelAndView changePassWord(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/personal/changePassWord");
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		return mav;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/changePW")
	public ModelAndView changePW(HttpServletRequest request,HttpServletResponse response){
		try{
			HttpSession session = request.getSession();
			UserInfo user = (UserInfo)session.getAttribute("UserInfo");
			if(MD5Encoder.isPasswordValid(user.getPasswd(), request.getParameter("old_pass"), user.getLogin_id())){//判断旧密码是否正确
				userService.changePassWord(user.getLogin_id(), MD5Encoder.encodePassword(request.getParameter("new_pass"), user.getLogin_id()));
			}else{
				return new ModelAndView("redirect:/html/manage/personal/changePassWord","C_STATUS",0);
			}
			return new ModelAndView("redirect:/html/manage/personal/changePassWord","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/personal/changePassWord","C_STATUS",0);
		}
	}
}
