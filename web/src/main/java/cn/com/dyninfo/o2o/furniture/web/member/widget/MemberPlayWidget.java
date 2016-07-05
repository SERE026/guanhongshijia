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

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.TradeUtil;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
@Component("memberPlay")
public class MemberPlayWidget extends Widget {

	@Resource
	private OrderService orderService;
	
	@Override
	public void display(Map pamtr) {
		String dataType1=(String) pamtr.get("dataType1");
		String data=(String) pamtr.get("order");
		if(dataType1!=null){
			Order info1=(Order) orderService.getObjById(data);
			info1.setStatus("0");
			orderService.updateObj(info1);
			this.putData("data", "1");
			this.setPageName("register.html");
		}else{
			String tradeNo = TradeUtil.createTradeNumber();
			String order[]=this.HttpRequest.getParameterValues("order");
			String isPlay="1";
			if(order!=null){
				for(String id:order){
					Order info=(Order) orderService.getObjById(id);
					if(info.getPayType().equals("0")){
						info.setTradeNo(tradeNo);
						orderService.updateObj(info);
						isPlay="0";
					}
				}
			}
			this.HttpRequest.getSession().setAttribute(Context.SESSION_TRADENO, tradeNo);
			this.setFreeMaker(false);
			long m=Math.round(Math.random()*10000);
			ResponseUtil.printl(this.HttpResponse, "{\"play\":"+isPlay+",\"tradeNo\":\""+tradeNo+"\"}", "json");
			
		}
	}

}
