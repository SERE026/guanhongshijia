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
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.model.Adv;
import cn.com.dyninfo.o2o.old.model.Advwz;
import cn.com.dyninfo.o2o.old.service.AdvService;
import cn.com.dyninfo.o2o.old.service.AdvwzService;

/**
 * 广告列表管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/adv")
public class AdvController extends BaseController{

	   @Resource
	   private AdvService advService;
	   
	   @Resource
	   private AdvwzService advwzService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=advService;
			 this.business="pageInfo";
			 this.table="adv";
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
	    	 String area_id=request.getParameter("area_id");
	    	 String area_name=request.getParameter("area_name");
	    	 if(title!=""&&title!=null){
	    	   	 where.append("and n.adv_name like'%").append(title).append("%'");
	    	 }
	    	 if(area_id!=""&&area_id!=null){
	    	   	 where.append(" and n.area.id ='").append(area_id).append("'");
	    	 }
	    	 where.append(" order by n.id desc ");
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("title", title);
	    	 mva.addObject("area_id", area_id);
	    	 mva.addObject("area_name", area_name);
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
	 		List<Advwz> advinfo=(List<Advwz>) advwzService.getListByWhere(new StringBuffer(""));
	 		mav.addObject("advinfo", advinfo);
	 		mav.setViewName("/pageInfo/adv/add");
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
	 		List<Advwz> advinfo=(List<Advwz>) advwzService.getListByWhere(new StringBuffer(""));
	 		Adv info= (Adv) advService.getObjById(id);
	 		mav.addObject("advinfo", advinfo);
	 		mav.addObject("info", info);
	 		mav.setViewName("/pageInfo/adv/update");
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
	      public ModelAndView add(HttpServletRequest request,Adv info){
	    	  	String area_id=request.getParameter("area_id");
	    	  	if(area_id!=null&&area_id.length()>0){
	    	  		AreaInfo  area=new AreaInfo ();
	    	  		area.setId(area_id);
	    	  		info.setArea(area);
	    	  	}
	    	    ModelAndView mav=new ModelAndView();
	    	    advService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/adv/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Adv info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  String area_id=request.getParameter("area_id");
		    	  	if(area_id!=null&&area_id.length()>0){
		    	  		AreaInfo  area=new AreaInfo ();
		    	  		area.setId(area_id);
		    	  		info.setArea(area);
		    	  	}
				  	advService.updateObj(info);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/adv/list");
				return mav;
		  }
		  
	  
}
