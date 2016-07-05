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

package cn.com.dyninfo.o2o.furniture.web.order.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Returnedorder;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Yqlj;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/**
 * 退货单管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/returnedorder")
public class ReturnedorderController extends BaseController{

	   @Resource
	   private OrderService orderService;
	   
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=orderService;
			 this.business="orderInfo";
			 this.table="returnedorder";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String ddh=request.getParameter("ddh");
	    	 if(ddh!=""&&ddh!=null){
	    	   	 where.append("and n.order_id like'%").append(ddh).append("%'");
	    	 }
	    	 ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
    		if(merchants!=null){
    			where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
    		}
	    	 where.append("and n.status='0'");
	    	 where.append(" and n.is_return>'0'");
	    	 where.append(" and n.sendstate='1'");
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("ddh", ddh);
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
	      public ModelAndView add(HttpServletRequest request,Yqlj info){
	    	    ModelAndView mav=new ModelAndView();
	    	    orderService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/yqlj/list");
	    		return mav;
	      }
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,Returnedorder info){
			  ModelAndView mav=new ModelAndView();
			  Returnedorder returnedorder=(Returnedorder) orderService.getObjById(info.getReturnedorder_id());
			  Order order=(Order)returnedorder.getOrder();
			  String shouMen=request.getParameter("shouMen");
			 // order.setShouMen(shouMen);
			  returnedorder.setOrder(order);
			  try {
				  orderService.updateObj(returnedorder);
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/returnedorder/list");
				return mav;
		  }
		  
		  /**
			 * 假删除 
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value="/{id}/godel")
			public ModelAndView godel(@PathVariable String id,HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				Returnedorder returnedorder=(Returnedorder)orderService.getObjById(id);
				returnedorder.setStatus("1");
				orderService.updateObj(returnedorder);
				mav.setViewName("redirect:/html/manage/returnedorder/list");
				return mav;
			}
			
			/**
			 * 同意退货
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value="/{id}/goupdate")
			public ModelAndView goupdate(@PathVariable String id,HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				Order info=(Order) orderService.getObjById(id);
				info.setIs_return("2");
				info.setState("6");
				orderService.updateObj(info);
			    mav.setViewName("redirect:/html/manage/returnedorder/list");
				return mav;
			}
}
