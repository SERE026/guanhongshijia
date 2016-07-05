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
import cn.com.dyninfo.o2o.furniture.web.page.model.Ckhdsp;
import cn.com.dyninfo.o2o.furniture.web.page.service.CkhdspService;

/**
 * 
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/ckhdsp")
public class CkhdspController extends BaseController{

	   @Resource
	   private CkhdspService ckhdspService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=ckhdspService;
			 this.business="pageInfo";
			 this.table="ckhdsp";
		 }
	   
	  
	   /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Ckhdsp info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  ckhdspService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/ckhdsp/1/disUpdate");
				return mav;
		  }
}
		  