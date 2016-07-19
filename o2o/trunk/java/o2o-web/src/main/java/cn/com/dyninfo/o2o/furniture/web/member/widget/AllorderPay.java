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

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;


import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.service.OrderService;

@Component("allorderPay")
public class AllorderPay extends Widget {

	@Resource
	private OrderService orderService;
	@Override
	public void display(Map pamtr) {
		HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member==null){
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
			return;
		}
		String tradeno="";
		String orderid=(String) pamtr.get("orderid");
		String allorderid=(String) pamtr.get("allorderid");
		if(orderid!=null){
			Order order =(Order) orderService.getObjById(orderid);
			tradeno=order.getTradeNo();
			this.putData("data", "1");
		}
		if(allorderid!=null){
			String tradeNo=UUID.randomUUID().toString().replace("-", "");
			String idlist[]=allorderid.split("/");
			for(int i=0;i<idlist.length;i++){
				Order order =(Order) orderService.getObjById(idlist[i]);
				order.setTradeNo(tradeNo);
				orderService.updateObj(order);
			}
			this.putData("data", "2");
		}
	}	
}
