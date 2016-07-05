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

package cn.com.dyninfo.o2o.furniture.web.port.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.port.model.Note;
import cn.com.dyninfo.o2o.furniture.web.port.service.NoteServeice;

/**
 * 短信接口
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/note")
public class NoteController extends BaseController{

	   @Resource
	   private NoteServeice noteServeice;
	   
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=noteServeice;
			 this.business="port";
			 this.table="note";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String skdh=request.getParameter("skdh");
	    	 String ddh=request.getParameter("ddh");
	    	
	 
	    	 if(skdh!=""&&skdh!=null){
	    	   	 where.append("and n.sendorder_id like'%").append(skdh).append("%'");
	    	 }
	     	 if(ddh!=""&&ddh!=null){
	    	   	 where.append("and n.order.order_id like'%").append(ddh).append("%'");
	    	 }
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("skdh", skdh);
	    	 mva.addObject("ddh", ddh);
	           return mva;
	     }
	    
			
	     
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Note info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  noteServeice.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/note/list");
				return mav;
		  }
		  
}
