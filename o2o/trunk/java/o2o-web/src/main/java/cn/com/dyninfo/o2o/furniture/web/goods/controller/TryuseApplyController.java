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

import java.util.ArrayList;
import java.util.List;
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
import cn.com.dyninfo.o2o.furniture.util.TradeUtil;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.TryuseApply;
import cn.com.dyninfo.o2o.old.service.TryuseApplyService;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.model.OrderProduct;
import cn.com.dyninfo.o2o.old.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 试用申请
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/tryuseapply")
public class TryuseApplyController extends BaseController{

     @Resource
     private TryuseApplyService tryuseApplyService;
     
 	@Resource
	private OrderService orderService;
 	
	@Resource
	private ShangJiaService shangJiaService;
       
     @Override
	 public void initService(){
		 super.initService();
		 this.baseService=tryuseApplyService;
		 this.business="shangpin";
		 this.table="tryuse";
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
			buff.append("  order by n.applyDate desc ");
			mav.addAllObjects(this.tryuseApplyService.getListByPageWhere(buff, page));
			mav.setViewName("/shangpin/tryuse/list");
			return mav;
		}
		
		/**
		 * 查看
		 * @param id
		 * @param request
		 * @return
		 */
		@Override
		@RequestMapping(value="/{id}/show")
		public ModelAndView show(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			initService();
			try{
				mav.addObject("info",tryuseApplyService.getObjById(id));
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.setViewName("/shangpin/tryuse/show");
			return mav;
		}
		
		/**
		 * 审核
		 * @param id
		 * @param request
		 * @return
		 */
		@Override
		@RequestMapping(value="/{id}/disUpdate")
		public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			initService();
			
			TryuseApply info =(TryuseApply)	tryuseApplyService.getObjById(id);
			if(info.getApplytype().equals("0")){
				info.setApplytype("1");
				//生成订单
				Order order=new Order();
				String tradeNo=TradeUtil.createTradeNumber();
				order.setTradeNo(tradeNo);
				order.setState("1");
				order.setIsPay("1");
				order.setReceiveName(info.getReceiveName());
				order.setReceivePhone(info.getReceivePhone());
				order.setReceiveTel(info.getReceiveTel());
				order.setCode(info.getCode());
				order.setProvince(info.getProvince());
				order.setCity(info.getCity());
				order.setCounty(info.getCounty());
				order.setAddress(info.getAddress());
				order.setHuiyuan(info.getHuiyuan());
				order.setProtectPrice(0.0);
				order.setGoodsPrice(0.0);
				order.setOriginalPrice(0.0);
				order.setOrderPrice(0.0);
				order.setShippingPrice(0.0);
				order.setDly("1");
				List opList=new ArrayList();
				OrderProduct op=new OrderProduct();
				op.setOrder(order);
				op.setGoodMoney(0.0);
				op.setNum(1);
				op.setProduct(info.getGoods().getProduct());
				opList.add(op);
				order.setOrderProductList(opList);
				
				List shangjialist=shangJiaService.getListByWhere(new StringBuffer("and n.sort=2"));
				if(shangjialist!=null&&shangjialist.size()>0){
					ShangJiaInfo shangjia=(ShangJiaInfo)shangjialist.get(0);
					order.setMerchants(shangjia);
				}
				orderService.addObj(order);
			}else{
				info.setApplytype("0");
			}
			tryuseApplyService.updateObj(info);
			mav.setViewName("redirect:/html/manage/tryuseapply/list");
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
			  ModelAndView mav=new ModelAndView();
			  tryuseApplyService.delObjById(id);
				mav.setViewName("redirect:/html/manage/tryuseapply/list");
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
							tryuseApplyService.delObjById(id);
						}
					}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				
				mav.setViewName("redirect:/html/manage/tryuseapply/list");
				return mav;
			}
}
