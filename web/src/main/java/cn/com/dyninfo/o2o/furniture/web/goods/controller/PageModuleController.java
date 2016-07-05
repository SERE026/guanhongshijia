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

package cn.com.dyninfo.o2o.furniture.web.goods.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import cn.com.dyninfo.o2o.furniture.web.goods.model.PageModule;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PageModuleService;

/**
 * 页面模块
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/pageModule")
public class PageModuleController extends BaseController{

     @Resource
     private PageModuleService pageModuleService;
     

     
     @Resource
     private GoodsService goodsService;
       
     @Override
	 public void initService(){
		 super.initService();
		 this.baseService=pageModuleService;
		 this.business="shangpin";
		 this.table="pageModule";
	 }
	      
	      /**
			 * 列表
			 * 
			 * @param request
			 * @return
			 */
		@RequestMapping("/list")
		public ModelAndView list(HttpServletRequest request) {
			StringBuffer buff=null;
			PageInfo page = new PageInfo();
			// 分页
			ModelAndView mav=new ModelAndView();
			page.setPageSize(25);
			if (request.getParameter("pageNo") != null&& request.getParameter("pageNo").length() > 0) {
				Pattern pattern = Pattern.compile("^[0-9]+$");
				Matcher m = pattern.matcher(request.getParameter("pageNo"));
				if (m.matches()) {
					page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
				}
			} else{
				page.setPageNo(1);
			}
			buff=new StringBuffer();
			buff.append("and status = '0'");
			buff.append("  order by n.pageModule_id desc ");
			mav.addAllObjects(this.pageModuleService.getListByPageWhere(buff, page));
			mav.setViewName("/shangpin/pageModule/list");
			return mav;
		}
		@Override
		@RequestMapping(value="/disAdd")
		public ModelAndView disAdd(HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
		
			mav.setViewName("/shangpin/pageModule/add");
			return mav;
		}
		
		/**
		 * 修改
		 * @param id
		 * @param request
		 * @return
		 */
		 @Override
		@RequestMapping(value="/{id}/disUpdate")
		public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			initService();
			try{
				mav.addObject("info",pageModuleService.getObjById(id));
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.setViewName("/shangpin/pageModule/update");
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
	      public ModelAndView add(HttpServletRequest request,PageModule info){
	    	    ModelAndView mav=new ModelAndView();
	    	    try {
	    	    	pageModuleService.addObj(info);
					mav.addObject("C_STATUS",1);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    			mav.addObject("C_STATUS", 0);
	    		}
	    		mav.setViewName("redirect:/html/manage/pageModule/list");
	    		return mav;
	      }
	      
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,PageModule info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  pageModuleService.updateObj(info);
				mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				mav.setViewName("redirect:/html/manage/pageModule/list");
				return mav;
		  }
		  
		  /**
		   * 删除
		   * @param id
		   * @param request
		   * @param response
		   * @return
		   */
		  @RequestMapping(value="/{id}/del",method=RequestMethod.GET)
		  public ModelAndView del(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
			  PageModule info=null;
			  ModelAndView mav=new ModelAndView();
			    try {
				    info=(PageModule) pageModuleService.getObjById(id);
				    info.setStatus("1");
				    pageModuleService.updateObj(info);
				}catch(Exception e){
					e.printStackTrace();
				}
				mav.setViewName("redirect:/html/manage/pageModule/list");
				return mav;
		  }
		  
		  @RequestMapping(value="/all/del",method=RequestMethod.DELETE)
			public ModelAndView delete(HttpServletRequest request){
				initService();
				ModelAndView mav=new ModelAndView();
				try{
					String ids[]=request.getParameterValues("list");
					if(ids!=null){
						for(String id:ids){
							PageModule	 info=(PageModule) pageModuleService.getObjById(id);
							    info.setStatus("1");
							    pageModuleService.updateObj(info);
						}
					}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				
				mav.setViewName("redirect:/html/manage/pageModule/list");
				return mav;
			}
}
