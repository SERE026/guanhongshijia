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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.service.OrderService;
import cn.com.dyninfo.o2o.old.model.Yqlj;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/**
 * 订单管理
 * 
 * @author lxf
 * 
 */
@Controller
@RequestMapping("/manage/order")
public class OrderController extends BaseController {

	@Resource
	private OrderService orderService;

	@Resource
	private AreaService areaService;

	@Override
	public void initService() {
		super.initService();
		this.baseService = orderService;
		this.business = "orderInfo";
		this.table = "order";
	}

	/**
	 * 列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where = new StringBuffer();
		String xdr = request.getParameter("xdr");
		String btime = request.getParameter("btime");
		String etime = request.getParameter("etime");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String state = request.getParameter("state");
		String wlfs = request.getParameter("wlfs");
		String province = request.getParameter("province");// 省
		String city = request.getParameter("city");// 市
		String dianjia = request.getParameter("dianjia");// 店家名称
		UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
		
		// 保存全部订单中的不重复省份、城市和商家，以便组成下拉框选项
		List orderAll = orderService.getListByWhere(new StringBuffer().append("and n.status='0'"));
		List<String> provinceList = new ArrayList<String>();
		List<String> cityList = new ArrayList<String>();
		List<String> dianjiaList = new ArrayList<String>();
		String p = "";
		String c = "";
		String dj = "";
		for (int i=0 ;i<orderAll.size(); i++) {
			Order o = (Order)orderAll.get(i);
			if (o.getProvince() != null) {
				p = o.getProvince().getName();
				if (!provinceList.contains(p)) {
					provinceList.add(p);
				}
			}
			if (o.getCity() != null) {
				c = o.getCity().getName();
				if (!cityList.contains(c)) {
					cityList.add(c);
				}
			}
			if (o.getMerchants() != null) {
				dj = o.getMerchants().getName();
				if (!dianjiaList.contains(dj)) {
					dianjiaList.add(dj);
				}
			}
		}
		
		// 查询省
		if (province != "" && province != null) {
			where.append(" and n.province.name like '%" + province + "%'");
		}
		// 查询市
		if (city != "" && city != null) {
			where.append(" and n.city.name like '%" + city + "%'");
		}
		// 查询所属商家
		if (dianjia != "" && dianjia != null) {
			where.append(" and n.merchants.name like '%" + dianjia + "%'");
		}
		// 查询开始时间
		if (btime != "" && btime != null) {
			where.append(" and n.time >='" + btime + "'");
		}
		// 查询结束时间
		if (etime != "" && etime != null) {
			where.append(" and n.time <='" + etime + " 24:00:00'");
		}
		if (xdr != "" && xdr != null) {
			where.append(" and n.huiyuan.name like'%").append(xdr).append("%'");
		}
		if (state != null && !"".equals(state)) {
			where.append(" and n.state = '").append(state).append("'");
		}
		if (wlfs != null && !"".equals(wlfs)) {
			where.append(" and n.sendType = '").append(wlfs).append("'");
		}
		if(month!=null&&!"".equals(month)){
			where.append(" and n.time>='"+year+"-"+month+"-"+"01"+" 24:00:00'");
		}
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
		}
		
		if(year!=null&&!"".equals(year)){
			where.append(" and n.time <'"+year+"-0"+(Integer.parseInt(month)+1)+"-"+"01"+" 24:00:00'");
		}
		where.append(" and n.status='0'");
		where.append(" order by creatTime DESC");
		ModelAndView mav = super.list(request, where);
		mav.addObject("xdr", xdr);
		mav.addObject("btime", btime);
		mav.addObject("etime", etime);
		mav.addObject("state", state);
		mav.addObject("wlfs", wlfs);
		mav.addObject("role", info.getIs_user());// 加入用户角色信息
		mav.addObject("province", province);// 省
		mav.addObject("city", city);// 市
		mav.addObject("dianjia", dianjia);// 店
		mav.addObject("provinceList", provinceList);// 全部省
		mav.addObject("cityList", cityList);// 全部市
		mav.addObject("dianjiaList", dianjiaList);// 全部店家
		return mav;
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, Yqlj info) {
		ModelAndView mav = new ModelAndView();
		orderService.addObj(info);
		mav.setViewName("redirect:/html/manage/yqlj/list");
		return mav;
	}

	/**
	 * 更改
	 * 
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Order info) {
		ModelAndView mav = new ModelAndView();
		Order order = (Order) orderService.getObjById(info.getOrder_id());
		order.setState(info.getState());
		order.setReceiveName(info.getReceiveName());
		order.setReceivePhone(info.getReceivePhone());
		order.setReceiveTel(info.getReceiveTel());
		order.setCode(info.getCode());
		order.setProvince(info.getProvince());
		order.setCity(info.getCity());
		order.setCounty(info.getCounty());
		order.setAddress(info.getAddress());
		if(info.getDiscountPrice()!=null){
		order.setDiscountPrice(info.getDiscountPrice());
		order.setOrderPrice(order.getGoodsPrice()+order.getShippingPrice()+order.getProtectPrice()-info.getDiscountPrice());
		}
		try {
			orderService.updateObj(order);
			mav.addObject("C_STATUS", 1);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/order/list");
		return mav;
	}

	/**
	 * 假删除
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/godel")
	public ModelAndView godel(@PathVariable
	String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Order order = (Order) orderService.getObjById(id);
		order.setStatus("1");
		orderService.updateObj(order);
		mav.setViewName("redirect:/html/manage/order/list");
		return mav;
	}

	/**
	 * 修改跳转
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{id}/goupdate")
	public ModelAndView goupdate(@PathVariable
	String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Order order = (Order) orderService.getObjById(id);
		mav.addObject("info",order);
		mav.addObject("province", areaService.getListByWhere(new StringBuffer(
				" and n.parent is null")));
		mav.setViewName("/orderInfo/order/update");
		return mav;
	}
}
