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

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.model.HuiyuanMoney;
import cn.com.dyninfo.o2o.old.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.model.Refundorder;
import cn.com.dyninfo.o2o.old.service.OrderService;
import cn.com.dyninfo.o2o.old.service.RefundorderService;
import cn.com.dyninfo.o2o.old.model.Yqlj;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantMoneyService;

/**
 * 退款单管理
 * @author Zebe
 * @date 2014/4/28
 *
 */
@Controller
@RequestMapping("/manage/refundorder")
public class RefundorderController extends BaseController{

	@Resource
	private OrderService orderService;

	@Resource
	private RefundorderService refundorderService;

	@Resource
	private HuiyuanMoneyService huiyuanMoneyService;
	
	@Resource
	private MerchantMoneyService merchantMoneyService;

	@Override
	public void initService(){
		super.initService();
		this.baseService=orderService;
		this.business="orderInfo";
		this.table="refundorder";
	}

	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){

		// 创建模型视图
		ModelAndView mav = new ModelAndView();

		// 取传入的订单号参数
		String ddh=request.getParameter("ddh");

		// 设置分页信息，并创建查询语句
		StringBuffer where=new StringBuffer();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 0;
		if ((request.getParameter("pageNo") != null)) {
			no = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (no > 0) {
			page.setPageNo(no);
		} else {
			page.setPageNo(1);
		}

		// 获取当前登录的用户信息，如果登录角色是商家
		UserInfo user = (UserInfo) request.getSession().getAttribute("UserInfo");
		if(user.getIs_user().equals("1")) {
//			System.out.println("商家登录进入退款单列表，商家：" + user.getShanfJiaInfo().getName());
			where.append(" and n.order.merchants.shangjia_id=" + user.getShanfJiaInfo().getShangjia_id() + " order by n.date desc");
		} else if (user.getIs_user().equals("2")){
//			System.out.println("代理商登录进入退款单列表");
		}


		// 取当前登录的商家
		//ShangJiaInfo shangjia=(ShangJiaInfo) request.getSession().getAttribute("merchants");

		// 在退款单中取出所有当前商家的退款单数据


//		if(ddh!=""&&ddh!=null){
//		where.append("and n.order_id like'%").append(ddh).append("%'");
//		}
//		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
//		if(merchants!=null){
//		where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
//		}
//		where.append("and n.status='0'");
//		where.append(" and n.is_refund >'0' ");
//		ModelAndView mva= super.list(request, where);
//		mva.addObject("ddh", ddh);
//		return mva;
		mav.addObject("user", user);
		mav.addAllObjects(refundorderService.getListByPageWhere(where, page));
		mav.setViewName("/orderInfo/refundorder/list");
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
	public ModelAndView add(HttpServletRequest request,Yqlj info){
		ModelAndView mav=new ModelAndView();
		orderService.addObj(info);
		mav.setViewName("/html/manage/yqlj/list");
		return mav;
	}

	/**
	 * 更改
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request,Refundorder info){
		ModelAndView mav=new ModelAndView();
		Refundorder refundorder=(Refundorder) orderService.getObjById(info.getRefundorder_id());
		refundorder.setRefundmoney(info.getRefundmoney());
		try {
			orderService.updateObj(refundorder);
			mav.addObject("C_STATUS",1);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/refundorder/list");
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
		Refundorder refundorder=(Refundorder)orderService.getObjById(id);
		refundorder.setStatus("1");
		orderService.updateObj(refundorder);

		return mav;
	}

	/**
	 * 商家同意退款，两种情况：退款金额和订单金额相同，直接退，否则要交由平台审核（保存金额并设置状态为1）
	 * @param id
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value="/{id}/{money}/goupdate")
	public ModelAndView goupdate(@PathVariable String id, @PathVariable String money, HttpServletRequest request){

		ModelAndView mav=new ModelAndView();
		// 根据ID拿到退款单对象、订单对象
		Refundorder rOrder = (Refundorder)refundorderService.getObjById(id);
		Order order = null;

		if (rOrder != null) {
			order = rOrder.getOrder();
			/** 如果传入的金额和订单金额相同，表示由商家直接退款 **/
			if (order.getOrderPrice() - Double.parseDouble(money) == 0) {
				rOrder.setState(2); // 直接设置状态为申请通过
				refundorderService.updateObj(rOrder);
			} else {
				rOrder.setState(1); // 设置状态为：等待平台审核
				rOrder.setRefundmoney(Double.parseDouble(money)); // 保存申请金额
				refundorderService.updateObj(rOrder);
				mav.setViewName("redirect:/html/manage/refundorder/list");
				return mav; // 直接返回，不做生成流水的操作
			}
		}
		// 添加会员流水信息
		if (rOrder != null & order != null) {
			HuiyuanInfo huiyuan = order.getHuiyuan();
			if (huiyuan != null) {
				huiyuan.setMoney(huiyuan.getMoney() + rOrder.getRefundmoney()); // 返回退款金额至会员账户
				HuiyuanMoney hm = new HuiyuanMoney();
				hm.setDate(new Date());
				hm.setFlag(1);
				hm.setHuiyuan(huiyuan);
				hm.setMoney(rOrder.getRefundmoney());
				hm.setOrder(order);
				hm.setPs("订单：" + order.getOrder_id() + "，退款：" + rOrder.getRefundmoney());
				huiyuanMoneyService.addObj(hm);
//				System.out.println("会员流水已生成");
			}
		}
		// 添加店铺流水信息
//		System.out.println("店铺流水已生成，请查看数据库。");
		merchantMoneyService.addRefundOrderMoney(rOrder);
//		Order info=(Order) orderService.getObjById(id);
//		info.setState("6");
//		info.setIs_refund("2");
//		orderService.updateObj(info);

		mav.setViewName("redirect:/html/manage/refundorder/list");
		return mav;
	}

	/**
	 * 平台管理人员同意退款，根据自定义金额来退款
	 * @param id
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value="/{id}/{money}/goupdate2")
	public ModelAndView goupdate2(@PathVariable String id, @PathVariable String money, HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		// 根据ID拿到退款单对象、订单对象
		Refundorder rOrder = (Refundorder)refundorderService.getObjById(id);
		Order order = null;
		if (rOrder != null) {
			order = rOrder.getOrder();
			rOrder.setState(2); // 设置状态为申请通过
			rOrder.setRefundmoney(Double.parseDouble(money)); // 这里是保存自定义退款金额，是由平台管理人员输入的（商家只能全额退）
			refundorderService.updateObj(rOrder);
		}
		// 生成会员流水信息
		if (rOrder != null & order != null) {
			HuiyuanInfo huiyuan = order.getHuiyuan();
			if (huiyuan != null) {
				huiyuan.setMoney(huiyuan.getMoney() + rOrder.getRefundmoney()); // 返回退款金额至会员账户
				HuiyuanMoney hm = new HuiyuanMoney();
				hm.setDate(new Date());
				hm.setFlag(1);
				hm.setHuiyuan(huiyuan);
				hm.setMoney(rOrder.getRefundmoney());
				hm.setOrder(order);
				hm.setPs("订单：" + order.getOrder_id() + "，退款：" + rOrder.getRefundmoney());
				huiyuanMoneyService.addObj(hm);
//				System.out.println("店铺流水已生成");
			}
		}

		// 生成店铺流水信息
//		System.out.println("店铺流水未生成，请编写代码");

//		Order info=(Order) orderService.getObjById(id);
//		info.setState("6");
//		info.setIs_refund("2");
//		orderService.updateObj(info);
		mav.setViewName("redirect:/html/manage/refundorder/list");
		return mav;
	}



}
