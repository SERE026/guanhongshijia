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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.android.model.AmenuInfo;
import cn.com.dyninfo.o2o.furniture.android.service.AmenuService;
import cn.com.dyninfo.o2o.furniture.android.service.AmenuwzService;
import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;

/**
 * 广告管理
 * @author wenjie
 *
 */
@Controller
@RequestMapping("/manage/amenu")
public class AmenuController extends BaseController{

	   @Resource
	   private AmenuService amenuService;
	   
	   @Resource
	   private AmenuwzService amenuwzService;
	   
	   
//		@Resource
//		private GoodsService goodsService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=amenuService;
			 this.business="android";
			 this.table="amenu";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String name=request.getParameter("name");
	    	 if(name!=""&&name!=null){
	    	   	 where.append("and n.name like'%").append(name).append("%'");
	    	 }
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("name", name);
	         return mva;
	     }
	     
	 	/**
	 	 * 添加
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping(value="/disAdd")
	 	public ModelAndView disAdd(HttpServletRequest request){
	 		ModelAndView mav=new ModelAndView();
	 		List list=amenuwzService.getListByWhere(new StringBuffer());
	 		mav.addObject("amenuwz", list);
	 		mav.setViewName("/android/amenu/add");
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
	      public ModelAndView add(HttpServletRequest request,AmenuInfo info){
	    	    ModelAndView mav=new ModelAndView();
	    	    amenuService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/amenu/list");
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
	  		List list=amenuwzService.getListByWhere(new StringBuffer());
	 		mav.addObject("amenuwz", list);
	 		mav.addObject("info", amenuService.getObjById(id));
	  		mav.setViewName("/android/amenu/update");
	  		return mav;
	  	}
	  	
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,AmenuInfo info){
			  ModelAndView mav=new ModelAndView();
	    	    amenuService.updateObj(info);
				mav.setViewName("redirect:/html/manage/amenu/list");
				return mav;
		  }
		  
	  
}
