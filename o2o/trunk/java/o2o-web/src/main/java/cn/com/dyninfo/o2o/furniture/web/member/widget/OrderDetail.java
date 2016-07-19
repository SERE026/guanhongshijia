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

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.Logistics;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.goods.widget.GoodpublicWidget;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.service.OrderService;
/*
 * 会员中心的订单详细和物流详细
 * @lxf
 */
@Component("orderDetail")
public class OrderDetail extends AbstractMemberWidget {
	 @Resource
	 private HuiyuanService huiyuanService;
	 
		@Resource
		private OrderService orderService;
		
	@Override
	public void execute(Map pamtr) {
		String orderid=(String) pamtr.get("orderid");
		String logisticid=(String) pamtr.get("logisticid");
		String delorderid=(String) pamtr.get("delorderid");
		String delbyid=(String) pamtr.get("delbyid");
		String sureorderid=(String) pamtr.get("sureorderid");
		String allid=(String) pamtr.get("allid");
		String baobei=(String) pamtr.get("baobei");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(delbyid!=null){
			Order delorder =(Order)orderService.getObjById(delbyid);
			delorder.setHuistat("1");
			orderService.updateObj(delorder);
			try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/"+"huiyuan_order.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(allid!=null){//批量收货
			String idlist[]=allid.split("/");
			for(int i=0;i<idlist.length;i++){
				Order order =(Order) orderService.getObjById(idlist[i]);
				order.setState("3");
				order.setSuretime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				int t=(int)(new Date().getTime()/1000);
				order.setIsuretime(t);
				orderService.updateObj(order);
			}
			
		}
		if(orderid!=null){//订单详细
			Order order =(Order) orderService.getObjById(orderid);
			Logistics logist=new Logistics();
			this.putData("data", Logistics.getWuliu("yuantong", "5314232466"));
			this.putData("order", order);
			int GoodsSort_id=order.getOrderProductList().get(0).getProduct().getGood().getGoodsSort().getGoodsSort_id();
			GoodpublicWidget widget=SpringContext.getBean("pgood");
			Map map=new HashMap();
			map.put("key", "GOODSORTID");
			map.put("moduleId", "42");
			map.put("flag", "0");
			map.put("pageSize", "5");
			map.put("goodSort_id", ""+GoodsSort_id);
			String tuijian=widget.parseWidget(this.HttpRequest, this.HttpResponse, map);
			
			
			map.put("key", "CLIENTID");
			map.put("moduleId", "43");
			map.put("pageSize", "5");
			map.put("flag", "100");
			String zuijin=widget.parseWidget(this.HttpRequest, this.HttpResponse, map);
			this.putData("tuijian", tuijian);
			this.putData("zuijin", zuijin);
		}
		
		if(logisticid!=null){//物流详细
			Order order =(Order) orderService.getObjById(logisticid);
			Logistics logist=new Logistics();
			this.putData("order", order);
			if(order.getWlcompany()!=null&&order.getDlyCode()!=null){
			List 	wuliu =	Logistics.getWuliu(order.getWlcompany().getEnglishName(),order.getDlyCode() );
			this.putData("data",wuliu );
			}
			this.setPageName("logistic.html");
			int GoodsSort_id=order.getOrderProductList().get(0).getProduct().getGood().getGoodsSort().getGoodsSort_id();
			GoodpublicWidget widget=SpringContext.getBean("pgood");
			Map map=new HashMap();
			map.put("key", "GOODSORTID");
			map.put("moduleId", "42");
			map.put("flag", "0");
			map.put("pageSize", "5");
			map.put("goodSort_id", ""+GoodsSort_id);
			String tuijian=widget.parseWidget(this.HttpRequest, this.HttpResponse, map);
			
			
			map.put("key", "CLIENTID");
			map.put("moduleId", "43");
			map.put("pageSize", "5");
			map.put("flag", "100");
			String zuijin=widget.parseWidget(this.HttpRequest, this.HttpResponse, map);
			this.putData("tuijian", tuijian);
			this.putData("zuijin", zuijin);
		}
		if(delorderid!=null){//放入订单回收站
			Order order =(Order) orderService.getObjById(delorderid);
			order.setStatus("1");
			orderService.updateObj(order);
			try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/"+"huiyuan_order.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(sureorderid!=null){//订单收货
			Order order =(Order) orderService.getObjById(sureorderid);
			order.setState("3");
			order.setSuretime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			int t=(int)(new Date().getTime()/1000);
			order.setIsuretime(t);
			orderService.updateObj(order);
			try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/"+"huiyuan_order.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
	
}
