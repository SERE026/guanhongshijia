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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.model.Payment;
import cn.com.dyninfo.o2o.old.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.old.model.Wlcompany;
import cn.com.dyninfo.o2o.old.service.WlcompanyService;

/**
 * 收款单管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/payment")
public class PaymentController extends BaseController{

	   @Resource
	   private OrderService orderService;
	   
	   @Resource
	   private WlcompanyService wlcompanyService;
	   
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=orderService;
			 this.business="orderInfo";
			 this.table="payment";
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
	    	 where.append(" and n.isPay='1'");
	    	 where.append(" order by n.isPay asc ");
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("ddh", ddh);
	           return mva;
	     }
	    
	    
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(value="/update")
		  public ModelAndView endit(HttpServletRequest request){
			  ModelAndView mav=new ModelAndView();
			  String order_id=request.getParameter("order_id");
			  Order payment=(Order) orderService.getObjById(order_id);
			  String wlcompanyId=request.getParameter("wlcompanyId");
			  Wlcompany wlcompany=(Wlcompany) wlcompanyService.getObjById(wlcompanyId);
			  String dlyCode=request.getParameter("dlyCode");
			  Date date=new Date();
			 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			  try {
				  if(payment!=null){
					  payment.setWlcompany(wlcompany);
					  payment.setDlyCode(dlyCode);
					  payment.setSendstate("1"); 
					  payment.setState("2");
					  if(payment.getSendtime()==null){
					     payment.setSendtime(format.format(date));
					  }
					  orderService.updateObj(payment);
				  }
				  
				  	mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
	    		mav.setViewName("redirect:/html/manage/payment/list");
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
				Payment payment=(Payment)orderService.getObjById(id);
				payment.setStatus("1");
				orderService.updateObj(payment);
				mav.setViewName("redirect:/html/manage/payment/list");
				return mav;
			}
			
			/**
			 * 修改跳转
			 * @param id
			 * @param request
			 * @return
			 */
			@RequestMapping(value="/{id}/goupdate")
			public ModelAndView goupdate(@PathVariable String id,HttpServletRequest request){
				ModelAndView mav=new ModelAndView();
				Order order=(Order) orderService.getObjById(id);
				if(order.getDly().equals("0")){
					order.setSendstate("1");
					order.setState("2");
					order.setSendtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					orderService.updateObj(order);
					mav.setViewName("redirect:/html/manage/payment/list");
				}else{
					mav.addObject("info", order);
					mav.setViewName("/orderInfo/payment/update");
				}
				
				return mav;
			}
			
			@RequestMapping("/selection")
			public void selection(HttpServletRequest request,HttpServletResponse response){
				    StringBuffer where = new StringBuffer();
					List<Wlcompany> list=(List<Wlcompany>) wlcompanyService.getListByWhere(where);
					ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
			}
}
