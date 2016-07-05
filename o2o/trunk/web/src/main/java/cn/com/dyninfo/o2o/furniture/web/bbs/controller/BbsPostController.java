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

package cn.com.dyninfo.o2o.furniture.web.bbs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsPostInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsUserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;

@Controller
@RequestMapping("/manage/bbsPost")
public class BbsPostController extends BaseController{
    
	   @Resource
	   private BbsPostService bbsPostService;
	   
	      @RequestMapping("/list")
	      public ModelAndView list(HttpServletRequest request){
	    	  ModelAndView mav=new ModelAndView();
	    	  StringBuffer where=new StringBuffer();
	    	  PageInfo page=new PageInfo();
				page.setPageSize(10);
				int pageNo = 0;
//				int totalpage = 0;
//				if((request.getParameter("pageNo") != null)
//						&& (request.getParameter("totalpage") != null)) {
//					pageNo = Integer.parseInt(request.getParameter("pageNo"));
//					totalpage = Integer.parseInt(request.getParameter("totalpage"));
//				}
				if(request.getParameter("pageNo") != null) {
					pageNo = Integer.parseInt(request.getParameter("pageNo"));
				}
//				if(pageNo > 0 && pageNo <= totalpage) {
//					page.setPageNo(pageNo);
//				}else{
//					page.setPageNo(1);
//				}
				if(pageNo > 0) {
					page.setPageNo(pageNo);
				}else{
					page.setPageNo(1);
				}
	    	  String title=request.getParameter("title");
	    	  String btime=request.getParameter("btime");
	    	  String htime=request.getParameter("htime");
	    	  if(title!=null&&!"".equals(title)){
	    		  where.append(" and n.title like '%").append(title).append("%'");
	    	  }
	    	  if(btime!=null&&!"".equals(btime)){
	    		  where.append(" and n.time >'").append(btime).append("'");
	    	  }
	    	  if(htime!=null&&!"".equals(htime)){
	    		  where.append(" and n.time <='").append(htime).append("'");
	    	  }
	    	  where.append(" and n.status !=2");
	    	  where.append(" order by type asc ,top ASC,status ASC,time DESC");
	    	  mav.addAllObjects(bbsPostService.getListByPageWhere(where, page));
	    	  mav.addObject("title", title);
	    	  mav.addObject("btime", btime);
	    	  mav.addObject("PAGE_INFO",page);
	    	  mav.addObject("htime", htime);
	    	  mav.setViewName("/bbsPost/list");
	    	  return mav;
	      }
	      
	      /**
	       * 审核
	       * @param id
	       * @param request
	       * @return
	       */
	      @RequestMapping("/{id}/audit")
	      public ModelAndView audit(@PathVariable String id,HttpServletRequest request){
	    	    ModelAndView mav=new ModelAndView();
	    	    try {
					BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
					info.setStatus(1);
					int lev=0;
					int count=bbsPostService.getCountByWhere(new StringBuffer("and n.user.bbs_id='"+info.getUser().getBbs_id()+"' "));
					if(count>5){
						lev++;
					}
					if(count>50){
						lev++;
					}
					if(count>100){
						lev++;
					}
					if(count>200){
						lev++;
					}
					if(count>1000){
						lev++;
					}
					BbsUserInfo user=info.getUser();
					user.setLev(lev);
					bbsPostService.updateObj(info);
					bbsPostService.updateObj(user);
					mav.addObject("C_STATUS", 1);
				} catch (RuntimeException e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				return new ModelAndView("redirect:/html/manage/bbsPost/list");
	      }
	      
	      /**
	       * 置顶或取消置顶
	       * @param id
	       * @param top
	       * @param request
	       * @return
	       */
	      @RequestMapping("/{id}/{top}/first")
	      public ModelAndView first(@PathVariable String id,@PathVariable int top,HttpServletRequest request){
	    	    try {
	    	    	BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
	    	    	if(top==1){
	    	    		info.setTop(0);
	    	    	}else{
	    	    		info.setTop(1);
	    	    	}
					bbsPostService.updateObj(info);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
				return new ModelAndView("redirect:/html/manage/bbsPost/list");
	      }
	      
	      /****
			 * 删除
			 * @param id
			 * @param request
			 * @param response
			 * @return
			 */
			@RequestMapping(value="/{id}/del")
			public ModelAndView del(@PathVariable String id, HttpServletRequest request){
				BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
				   if(info!=null){
				   info.setStatus(2);
				   bbsPostService.updateObj(info);
				   }
				return new ModelAndView("redirect:/html/manage/bbsPost/list");
			}
			
			/***
			 * 删除多个
			 * @param request
			 * @param response
			 * @return ModelAndView
			 */
			@RequestMapping(value="/del/all")
			public ModelAndView del(HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				try{
						String ids[]=request.getParameterValues("list");
						for(String id:ids){
							BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
						    if(info!=null){
						    info.setStatus(2);
						    bbsPostService.updateObj(info);
						    }
						}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				return new ModelAndView("redirect:/html/manage/bbsPost/list");
			}
			
			/**
			 * 编辑跳转
			 */
			 @RequestMapping("/{id}/disUpdate")
			 public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
				 ModelAndView mav=new ModelAndView();
				 mav.addObject("info",bbsPostService.getObjById(id));
				 mav.setViewName("/bbsPost/update");
				 return mav;
			 }
			 
			 /**
			  * 编辑
			  * @param request
			  * @return
			  */
			 @RequestMapping("/update")
			 public ModelAndView update(HttpServletRequest request){
				     ModelAndView mav=new ModelAndView();
				     String id=request.getParameter("id");
				     String title=request.getParameter("title");
				     String context=request.getParameter("context");
				     String flag=request.getParameter("flag");
				     BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
				     if(info!=null){
				    	 info.setTitle(title);
				    	 info.setContext(context);
				    	 info.setFlag(Integer.parseInt(flag));
				    	 bbsPostService.updateObj(info);
				     }
				     mav.setViewName("redirect:/html/manage/bbsPost/list");
				     return mav;
			 }
			 
			   /**
				 * 添加
				 */
				@RequestMapping(value="/disAdd")
				public ModelAndView disAdd(HttpServletRequest request) {
					ModelAndView mav = new ModelAndView();
					mav.setViewName("/bbsPost/add");
					return mav;
				}
				
				/**
				 * 添加保存
				 */
				@RequestMapping("/add")
				public ModelAndView add(HttpServletRequest request) {
					try{
						UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
						BbsUserInfo uInfo=bbsPostService.getUser(""+info.getLogin_id(), Context.BBS_ROLE_ADMIN);
						String title=request.getParameter("title");
					     String context=request.getParameter("context");
					     String flag=request.getParameter("flag");
					     Date date=new Date();
					     SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						BbsPostInfo bInfo=new BbsPostInfo();
						if(uInfo!=null){
							bInfo.setUser(uInfo);
							bInfo.setTitle(title);
							bInfo.setContext(context);
							bInfo.setTime(format.format(date));
							bInfo.setType(0);
							bInfo.setStatus(1);
							bInfo.setFlag(Integer.parseInt(flag));
							bInfo.setParent(bInfo);
							bbsPostService.addObj(bInfo);
						}
						
						return new ModelAndView("redirect:/html/manage/bbsPost/list","C_STATUS",1);
					}catch(Exception e){
						e.printStackTrace();
						return new ModelAndView("redirect:/html/manage/bbsPost/list","C_STATUS",0);
					}
					
				}
}
