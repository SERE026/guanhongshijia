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

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.page.model.Nrj;
import cn.com.dyninfo.o2o.furniture.web.page.service.NrjService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 广告列表管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/nrj")
public class NrjController extends BaseController{

	   @Resource
	   private NrjService nrjService;
	   
		@Resource
		private ShangJiaService shangJiaService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=nrjService;
			 this.business="pageInfo";
			 this.table="nrj";
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
	    	   	 where.append("and n.shangJiaInfo.name like'%").append(title).append("%'");
	    	 }
	    	 where.append("order by n.nrj_count desc");
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("title", title);
	           return mva;
	     }
	     /**
	 	 * 添加跳转
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping(value="/goAdd")
	 	public ModelAndView goAdd(HttpServletRequest request){
	 		ModelAndView mav=new ModelAndView();
	 		List<ShangJiaInfo> sjinfo=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(""));
	 		mav.addObject("sjinfo", sjinfo);
	 		mav.setViewName("/pageInfo/nrj/add");
	 		return mav;
	 	}
	 	
	 	 /**
	 	 * 添加跳转
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping(value="/{id}/goEdit")
	 	public ModelAndView goEdit(@PathVariable String id,HttpServletRequest request){
	 		ModelAndView mav=new ModelAndView();
	 		List<ShangJiaInfo> sjinfo=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(""));
	 		mav.addObject("sjinfo", sjinfo);
	 		Nrj info= (Nrj) nrjService.getObjById(id);
	 		mav.addObject("info", info);
	 		mav.setViewName("/pageInfo/nrj/update");
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
	      public ModelAndView add(HttpServletRequest request,Nrj info){
	    	    ModelAndView mav=new ModelAndView();
	    	    nrjService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/nrj/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Nrj info){
			  ModelAndView mav=new ModelAndView();
			 
			  try {
				 nrjService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/nrj/list");
				return mav;
		  }
		  
	  
}
