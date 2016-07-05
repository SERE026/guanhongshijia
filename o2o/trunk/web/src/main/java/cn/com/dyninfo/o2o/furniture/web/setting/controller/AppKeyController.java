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

package cn.com.dyninfo.o2o.furniture.web.setting.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.setting.model.AppKey;
import cn.com.dyninfo.o2o.furniture.web.setting.service.AppKeyService;
/**
 * appKey
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/appKey")
public class AppKeyController {
		@Resource
		private AppKeyService appKeyService;
		
		
		/**
		 * 列表
		 */
		@RequestMapping(value = "/list")
		public ModelAndView list(HttpServletRequest request,
				HttpServletResponse response) {
			
			ModelAndView mav = new ModelAndView();
			PageInfo page = new PageInfo();
			page.setPageSize(25);
			int no = 0;
			if ((request.getParameter("pageNo") != null)) {
				no = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (no > 0) {
				page.setPageNo(no);
			} else
				page.setPageNo(1);
			
			StringBuffer where = new StringBuffer();
			String appKey = request.getParameter("appKey");
			if(appKey!=null&&appKey.length()>0){
				where.append(" and n.appKey like '%"+appKey+"%' ");
				mav.addObject("appKey", appKey);
			}
			
			HashMap<String, ?> mapp = appKeyService.getListByPageWhere(where, page);
			List<AppKey> users = (List<AppKey>)mapp.get("DATA");
			page = (PageInfo) mapp.get("PAGE_INFO");
			mav.addObject("DATA", users);
			mav.addObject("PAGE_INFO", page);
			mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
			mav.setViewName("/appKey/list");
			return mav;
		}
		
		
		/**
		 * 添加
		 */
		@RequestMapping(value = "/disAdd")
		public ModelAndView disAdd(HttpServletRequest request,
				HttpServletResponse response) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/appKey/add");
			return mav;
		}
		
		
		/**
		 * 添加保存
		 */
		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView add(HttpServletRequest request,
				HttpServletResponse response,AppKey info) {
			try{
				appKeyService.addObj(info);
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",1);
			}catch(Exception e){
				e.printStackTrace();
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",0);
			}
			
		}
		
		
		
		
		/**
		 * 显示
		 */
		@RequestMapping(value = "/{id}/show")
		public ModelAndView show(@PathVariable
		String id, HttpServletRequest request, HttpServletResponse response) {
			ModelAndView mav = new ModelAndView();
			AppKey info = (AppKey)appKeyService.getObjById(id);
			mav.addObject("info", info);
			mav.setViewName("/appKey/show");
			return mav;
		}
		
		
		/**
		 * 编辑
		 */
		@RequestMapping(value = "/{id}/disUpdate")
		public ModelAndView disUpdate(@PathVariable
		String id, HttpServletRequest request, HttpServletResponse response) {
			
			ModelAndView mav = new ModelAndView();
			AppKey info = (AppKey)appKeyService.getObjById(id);
			mav.setViewName("/appKey/update");
			mav.addObject("info", info);
			return mav;
		}
		
		
		/**
		 * 更新保存
		 */
		@RequestMapping(method = RequestMethod.PUT)
		public ModelAndView update(HttpServletRequest request,
				HttpServletResponse response,AppKey info) {
			try{
				appKeyService.updateObj(info);
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",1);
			}catch(Exception e){
				e.printStackTrace();
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",0);
			}
		}

		/**
		 * 删除
		 */
		@RequestMapping(value = "/delall", method = RequestMethod.DELETE)
		public ModelAndView del(String ognzId, HttpServletRequest request, HttpServletResponse response) {
			try{
				if (request.getParameterValues("list") != null) {
					String[] list = request.getParameterValues("list");
					for (String userid : list) {
						appKeyService.delObjById(userid);
					}
				}
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",1);
			}catch(Exception e){
				e.printStackTrace();
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",0);
			}
		}
		
		/**
		 * 禁用
		 */
		@RequestMapping(value = "/{id}/del", method = RequestMethod.GET)
		public ModelAndView del(@PathVariable String id, String ognzId, HttpServletRequest request, HttpServletResponse response) {
			try{
				appKeyService.delObjById(id);
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",1);
			}catch(Exception e){
				e.printStackTrace();
				return new ModelAndView("redirect:/html/manage/appKey/list","C_STATUS",0);
			}
		}

}
