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

package cn.com.dyninfo.o2o.furniture.web.page.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;

/**
 * 广告位置管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/advwz")
public class AdvwzController extends BaseController{

	   @Resource
	   private AdvwzService advwzService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=advwzService;
			 this.business="pageInfo";
			 this.table="advwz";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String title=request.getParameter("title");
	    	 if(title!=""&&title!=null){
	    	   	 where.append("and n.advwz_title like'%").append(title).append("%'");
	    	 }
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("title", title);
	           return mva;
	     }
	     
	     /**
			 * 添加
			 * 
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,Advwz info){
	    	    ModelAndView mav=new ModelAndView();
	    	    advwzService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/advwz/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Advwz info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  advwzService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/advwz/list");
				return mav;
		  }
		  
	  
}
