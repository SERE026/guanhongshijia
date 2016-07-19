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

package cn.com.dyninfo.o2o.furniture.web.score.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.Jffa;
import cn.com.dyninfo.o2o.old.service.JffaService;

/**
 * 积分方案管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/jffa")
public class JffaController extends BaseController{

	   @Resource
	   private JffaService jffaService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=jffaService;
			 this.business="pageInfo";
			 this.table="jf";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String jffaname=request.getParameter("jffaname");
	    	 if(jffaname!=""&&jffaname!=null){
	    	   	 where.append("and n.jffa_name like'%").append(jffaname).append("%'");
	    	 }
	    	 ModelAndView mav= super.list(request, where);
	    	 
	    	 
	           return mav;
	     }
	    
			
	     
	     /**
			 * 添加
			 * 
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,Jffa info){
	    	    ModelAndView mav=new ModelAndView();
	    	    jffaService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/jffa/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Jffa info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  jffaService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/jffa/list");
				return mav;
		  }
		  
}
