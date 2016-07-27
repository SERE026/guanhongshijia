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

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.SendDx;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component("play_success")
@Scope("prototype")
public class PlaySucceed extends Widget {

	@Resource
	private OrderService orderService;
	
	@Override
	public void display(Map pamtr) {
		String tradeno=getTradeno();
		if(tradeno!=null&&tradeno.length()==16){
				List<Order> list=(List<Order>) orderService.getListByWhere(new StringBuffer(" and n.tradeNo='"+tradeno+"'  "));
				
				Order order=list.get(0);
				String phone=order.getMerchants().getContactPhone();
				try {
					SendDx.sendSMS(phone,"尊敬的【观红世家】"+order.getMerchants().getName()+"商家，您店内的订单" + order.getOrder_id() + "已经支付成功！","");
				} catch (Exception e) {
//					System.out.println("短信发送失败！");
					e.printStackTrace();
				}
				this.putData("order", list);
		}
		this.putData("result", pamtr.get("result"));
	}
	public String getTradeno(){
		Pattern p=Pattern.compile("-([\\d]+)");
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Matcher m=p.matcher(url);
		
		if(m.find()){
			System.out.println(m.group(1));
			return m.group(1);
		}
		return "";
	}

}
