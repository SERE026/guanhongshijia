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

package cn.com.dyninfo.o2o.furniture.web.wuliu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Wlcompany;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.WlcompanyService;

/**
 * 物流公司
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/wlcompany")
public class WlcompanyController extends BaseController{

	   @Resource
	   private WlcompanyService wlcompanyService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=wlcompanyService;
			 this.business="wuliu";
			 this.table="wlcompany";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 ModelAndView mva= super.list(request, where);
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
	      public ModelAndView add(HttpServletRequest request,Wlcompany info){
	    	    ModelAndView mav=new ModelAndView();
	    	    wlcompanyService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/wlcompany/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Wlcompany info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  wlcompanyService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/wlcompany/list");
				return mav;
		  }
		  
}
