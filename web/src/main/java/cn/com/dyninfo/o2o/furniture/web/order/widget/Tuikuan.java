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

package cn.com.dyninfo.o2o.furniture.web.order.widget;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.member.widget.AbstractMemberWidget;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Refundorder;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.order.service.RefundorderService;

/**
 * 会员退款挂件
 * @author Zebe
 * @date 2014/4/25
 *
 */

@Component("tuikuan")
public class Tuikuan extends AbstractMemberWidget{
	
	@Resource
	private HuiyuanService huiyuanService;
	
	@Resource
	private HuiyuanMoneyService huiyuanMoneyService;
	
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private RefundorderService refundorderService;
	
	@Override
	public void execute(Map pamtr) {
		
//		System.out.println("进入退款挂件！！！！！！！！");
		
		// 判断会员是否登录
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(huiyuan==null) {
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
			return;
		} else {
			huiyuan=(HuiyuanInfo) huiyuanService.getObjById(""+huiyuan.getHuiYuan_id());
			this.putData("huiyuan",huiyuan);
		}
		
		// 如果 action 没有值，表示直接跳转到申请退款页面
		String action = (String)pamtr.get("action");
		if (action == null) {
			String orderId = (String)pamtr.get("orderId");
			Order orderInfo = (Order)orderService.getObjById(orderId);
			this.putData("orderInfo", orderInfo);
			this.setPageName("Tuikuan.html");
			return;
		}
		
		// 如果 action 是 apply，保存申请退款的相关信息，此时状态是用户申请退款
		if ("apply".equalsIgnoreCase(action)) {
			// 取退款参数
			String reasonType = (String)pamtr.get("reasonType");
			String ps = (String)pamtr.get("ps");
			String orderId = (String)pamtr.get("orderId");
			// 更新订单状态
			Order order = (Order)orderService.getObjById(orderId);
			order.setState("4");
			orderService.updateObj(order);
			// 创建退款单
			Refundorder rOrder = new Refundorder();
			rOrder.setOrder(order);
			rOrder.setDate(new Date().toString());
			rOrder.setPs(ps);
			rOrder.setReasonType(reasonType);
			rOrder.setState(0);
			rOrder.setRefundmoney(order.getOrderPrice());
			refundorderService.addObj(rOrder);
			// 更新关联
			order.setRefundorder(rOrder);
			orderService.updateObj(order);
			
			System.out.println(rOrder.getOrder().getHuiyuan().getName());
			// 跳转到订单列表页面
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"huiyuan_order.html");
			return;
		}
		
	}
}
