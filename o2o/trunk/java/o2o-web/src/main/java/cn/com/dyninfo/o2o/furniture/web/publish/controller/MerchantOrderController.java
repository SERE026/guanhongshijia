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

package cn.com.dyninfo.o2o.furniture.web.publish.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantOrder;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantOrderInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantOrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

@Controller
@RequestMapping("/manage/merchantOrder")
public class MerchantOrderController {

	@Resource
	private MerchantOrderService merchantOrderService;

	@Resource
	private ShangJiaService shangJiaService ;
	
	@Resource
	private AreaService areaService;

	@RequestMapping("/area/list")
	public ModelAndView areaList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		request.getSession().removeAttribute("shangjiaOrderArea");
		mav.setViewName("/shangjia/order/areaList");
		return mav;
	}
	
	/**
	 * 列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		
		StringBuffer buff=null;
		PageInfo page = new PageInfo();
		String cityId=request.getParameter("cityId");
		if(cityId!=null&&cityId.length()>0){
			AreaInfo area=(AreaInfo) areaService.getObjById(cityId);
			if(area!=null){
				request.getSession().setAttribute("shangjiaOrderArea", area);
			}
		}
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

		mav.addAllObjects(merchantOrderService.getListByPageWhere(buff, page));
		mav.setViewName("/shangjia/order/list");
		
		//////////////////////////////////////////////////////////////////
//		
//		ModelAndView mav=new ModelAndView();
//		PageInfo page=new PageInfo();
//		page.setPageSize(25);
//		String pageNo=request.getParameter("pageNo");
//		if(pageNo==null||pageNo.length()==0){
//			pageNo="1";
//		}
//		page.setPageNo(Integer.parseInt(pageNo));
//		StringBuffer where=new StringBuffer();
//		mav.addAllObjects(merchantOrderService.getListByPageWhere(where, page));
//		mav.setViewName("/shangjia/order/list");
		return mav;
	}

	@RequestMapping(value="/order",method=RequestMethod.GET)
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		PageInfo page=new PageInfo();
		page.setPageSize(25);
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		StringBuffer where=new StringBuffer();
		String merchant_id=request.getParameter("merchant_order_id");
		where.append(" and n.order.merchant_order_id="+merchant_id);
		// 如果传入了城市ID，添加搜索条件
		AreaInfo area = (AreaInfo) request.getSession().getAttribute("shangjiaOrderArea");
		if (area != null) {
			where.append(" and n.merchant.city.id='"+ area.getId() + "'");
		}
		mav.addObject("info", merchantOrderService.getObjById(merchant_id));
		mav.addAllObjects(merchantOrderService.getOrderListByPageWhere(where, page));
		HashMap map = merchantOrderService.getOrderListByPageWhere(where, page);
		List list = (List)map.get("DATA");

		mav.setViewName("/shangjia/order/orderlist");
		return mav;
	}

	/**
	 * 保存商家排序
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/order",method=RequestMethod.PUT)
	public ModelAndView orderUpdate(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		PageInfo page=new PageInfo();
		page.setPageSize(25);
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		StringBuffer where=new StringBuffer();
		String merchant_order_id=request.getParameter("merchant_order_id");
		where.append(" and n.order.merchant_order_id="+merchant_order_id);

		// 如果传入了城市ID，添加搜索条件
		AreaInfo area = (AreaInfo) request.getSession().getAttribute("shangjiaOrderArea");
		if (area != null) {
			where.append(" and n.merchant.city.id='"+ area.getId() + "'");
		}
		
		// 保存商家排序
		MerchantOrder info=(MerchantOrder) merchantOrderService.getObjById(merchant_order_id);
		String shangjia_id[]= request.getParameterValues("merchant_id"); // 取商家ID数组
		String index[]= request.getParameterValues("index"); // 取排序数组
		if(shangjia_id!=null){
			List list=new ArrayList();
			for(int i=0;i<shangjia_id.length;i++){
				MerchantOrderInfo pmg=merchantOrderService.checkMerchant(merchant_order_id, shangjia_id[i]);
				if(pmg==null){
					pmg=new MerchantOrderInfo();
					pmg.setMerchant_order_id(0);
				}
				ShangJiaInfo merchant= (ShangJiaInfo) shangJiaService.getObjById(shangjia_id[i]);
				pmg.setMerchant(merchant);
				pmg.setOrder(info);
				pmg.setIndex(Integer.parseInt(index[i]));
				if(pmg.getMerchant_order_id()==0)
					list.add(pmg);
				else
					merchantOrderService.updateObj(pmg);
			}
			info.setMoiList(list);
		}
		merchantOrderService.updateObj(info);
		
		// 放入提示信息
		mav.addObject("tip", "更新排序成功！");
		
		mav.addObject("info", merchantOrderService.getObjById(merchant_order_id));
		mav.addAllObjects(merchantOrderService.getOrderListByPageWhere(where, page));
		mav.setViewName("/shangjia/order/orderlist");
		return mav;
	}

	/**
	 * 加载商家列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/merchant/list")
	public ModelAndView merchant(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		PageInfo page=new PageInfo();
		page.setPageSize(25);
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		StringBuffer where=new StringBuffer(" and n.state=0 ");
		String selectId=request.getParameter("selectId");
		if(selectId==null)
			selectId="";
		String select[]=request.getParameterValues("select");
		if(select!=null){
			for(String sID:select){
				selectId+=sID+",";
			}
		}
		
		// 如果传入了城市ID，添加搜索条件
		AreaInfo area = (AreaInfo) request.getSession().getAttribute("shangjiaOrderArea");
		if (area != null) {
			where.append(" and n.city.id='"+ area.getId() + "'");
		}
		
		String name=request.getParameter("name");
		if(name!=null&&name.length()>0){
			where.append(" and n.name like '%"+name+"%' ");
			mav.addObject("name", name);
		}

		String merchant_order_id = request.getParameter("merchant_order_id");
		mav.addObject("merchant_order_id", merchant_order_id);
		mav.addObject("selectId", selectId);
		mav.addAllObjects(shangJiaService.getListByPageWhere(where, page));
		mav.setViewName("/shangjia/order/shoplist");
		return mav;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/save/order")
	public ModelAndView merchantOrder(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		String saveId= request.getParameter("saveId");
		List list=new ArrayList();
		if(saveId!=null){
			String saveIds[]=saveId.split(",");
			for(String idx:saveIds){
				if(idx.length()>1){
					idx=idx.substring(1,idx.length()-1);
					list.add(shangJiaService.getObjById(idx)) ;
				}
			}
		}
		mav.addObject("list",list);
		MerchantOrder mo = (MerchantOrder)merchantOrderService.getObjById(request.getParameter("merchant_order_id"));
		mav.addObject("info", mo);
		mav.setViewName("/shangjia/order/addShop");
		return mav;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/del/order")
	public void delOrder(HttpServletRequest request,HttpServletResponse response){
		String merchant_order_id=request.getParameter("merchant_order_id");
		Object obj=merchantOrderService.getOrderObjById(merchant_order_id);
		if(obj!=null){
			merchantOrderService.delObj(obj);
		}

		ResponseUtil.printl(response, "{\"status\":0}", "json");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/addGoods/order",method=RequestMethod.PUT)
	public ModelAndView addGoodsOrder(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();

		String merchant_order_id=request.getParameter("merchant_order_id");
		MerchantOrder info=(MerchantOrder) merchantOrderService.getObjById(merchant_order_id);
		String shangjia_id[]= request.getParameterValues("shangjia_id");
		String index[]= request.getParameterValues("index");
		if(shangjia_id!=null){
			List list=new ArrayList();
			for(int i=0;i<shangjia_id.length;i++){
				MerchantOrderInfo pmg=merchantOrderService.checkMerchant(merchant_order_id, shangjia_id[i]);
				if(pmg==null){
					pmg=new MerchantOrderInfo();
					pmg.setMerchant_order_id(0);
				}
				ShangJiaInfo merchant= (ShangJiaInfo) shangJiaService.getObjById(shangjia_id[i]);
				pmg.setMerchant(merchant);
				pmg.setOrder(info);
				pmg.setIndex(Integer.parseInt(index[i]));
				if(pmg.getMerchant_order_id()==0)
					list.add(pmg);
				else
					merchantOrderService.updateObj(pmg);
			}
			info.setMoiList(list);
		}
		merchantOrderService.updateObj(info);
		mav.setViewName("/shangjia/order/close");
		return mav;
	}

}
