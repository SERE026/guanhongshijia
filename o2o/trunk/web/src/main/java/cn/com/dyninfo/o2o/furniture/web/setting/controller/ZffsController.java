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


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;
/**
 * 支付方式
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/zffs")
public class ZffsController extends BaseController{
	 @Resource
	   private ZffsService zffsService;
	   
	  
	   
	   @RequestMapping("/list")
		public ModelAndView list(HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			PageInfo  page=new PageInfo();
			StringBuffer where=	new StringBuffer();
			String name = request.getParameter("name");
			if(name!=null&&name.length()>0){
				where.append(" and n.name like '%"+name+"%' ");
				mav.addObject("name", name);
			}
			page.setPageSize(25);
			String pageNo=request.getParameter("pageNo");
			if(pageNo==null||pageNo.length()==0){
				page.setPageNo(1);
			}else{
				page.setPageNo(Integer.parseInt(pageNo));
			}
			where.append(" order by n.zffs_id desc ");
			mav.addAllObjects(zffsService.getListByPageWhere(where, page));
			mav.setViewName("/zffs/list");
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
			mav.setViewName("/zffs/add");
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
			initService();
			try{
				Zffs info = (Zffs) zffsService.getObjById(id);
				mav.addObject("info",info);
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("/zffs/update");
			return mav;
		}
		 
		 /**
		  * 添加
		  * @param request
		  * @param cardInfo
		  * @return
		  */
		 @RequestMapping(method=RequestMethod.POST)
		 public ModelAndView add(HttpServletRequest request,Zffs info){
			 ModelAndView mav=new ModelAndView();
			 try {
				 zffsService.addObj(info);
				 mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				mav.setViewName("redirect:/html/manage/zffs/list");
				return mav;
		 }
		 
		 /**
		  * 更改
		  * @param request
		  * @param cardInfo
		  * @return
		  */
		 @RequestMapping(method=RequestMethod.PUT)
		 public ModelAndView endit(HttpServletRequest request,Zffs info){
			 ModelAndView mav=new ModelAndView();
			 try {
				 zffsService.updateObj(info);
				 mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				
				mav.setViewName("redirect:/html/manage/zffs/list");
			 return mav;
		 }
		 /**
			 * 删除 
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value = "/{id}/del", method = RequestMethod.GET)
			public ModelAndView del(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
				try{
					Zffs p=(Zffs)zffsService.getObjById(id);
					zffsService.delObj(p);
					return new ModelAndView("redirect:/html/manage/zffs/list","C_STATUS",1);
				}catch(Exception e){
					e.printStackTrace();
					return new ModelAndView("redirect:/html/manage/zffs/list","C_STATUS",0);
				}
			}
}
