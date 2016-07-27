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

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;


import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

@Component("Orderplay")
@Scope("prototype")
public class Orderplay extends Widget {

	@Resource
	private OrderService orderService;
	
	@Resource
	private HuiyuanService huiyuanService;
	@Resource
	private ZffsService zffsService;
	
	@Override
	public void display(Map pamtr) {
		HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member==null){
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
			return;
		}
		String tradeno=(String) this.HttpRequest.getSession().getAttribute(Context.SESSION_TRADENO);
		String zffsId=(String) pamtr.get("zffs");
		String accountZf=(String) pamtr.get("account");
		Zffs zf=(Zffs) zffsService.getObjById(zffsId);
		
		if(zf!=null && tradeno!=null){
			try{
				member=(HuiyuanInfo) huiyuanService.getObjById(""+member.getHuiYuan_id());
				List<Order> list=(List<Order>) orderService.getListByWhere(new StringBuffer(" and n.tradeNo='"+tradeno+"' and n.state=0 "));
				if(list.size()>0){
					Double tradeMoney=0.0;
					String ps="";
					
					Double account=member.getMoney();
					if(account==null)
						account=0d;
					int isAccount=1;//默认不使用账户支付，直接使用在线支付
					if(accountZf!=null&&accountZf.equals("0"))
						isAccount=0;
					Double orderMoney=0d;//订单金额
					Double shippingPrice=0d;//配送费用
					for(Order order:list){
						tradeMoney+=order.getOrderPrice();
						orderMoney+=order.getOrderPrice();
						shippingPrice+=order.getShippingPrice();
						ps+="订单["+order.getOrder_id()+"]:"+order.getOrderPrice()+"（元） ";
						
					}
					if(isAccount==0){//如果优先使用账户支付
						if(tradeMoney-account>0){
							tradeMoney=tradeMoney-account;
						}else{
							orderService.updateOrderPlay(tradeno);
							tradeMoney=0d;
							ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+tradeno+".html?result=success");
							this.setFreeMaker(false);
							return ;
						}
					}
					
					Trade trade=new Trade();
					trade.setTrade_id(tradeno);
					trade.setMoney(tradeMoney);
					trade.setZffs(zf);
					trade.setHuiyuan(member);
					trade.setFlag(1);
					orderService.addObj(trade);
					{
						/**
						 * 支付宝支付信息
						 * notify_url 异步通知地址
						 * return_url 同步通知地址
						 * subject 订单名称 ps：显示的文字
						 */
						pamtr.put("subject", "观红世家订单支付");//订单名称
						pamtr.put("body", ps);//订单名称
					}
					
					if(tradeMoney>0){
						Widget widtet=SpringContext.getBean(zf.getWidget_name());
						pamtr.put("zf", zf);
						pamtr.put("orderMoney", ""+orderMoney);
						pamtr.put("shippingPrice", ""+shippingPrice);
						pamtr.put("tradeno", tradeno);
						pamtr.put("total_fee", ""+tradeMoney);
						String sHtmlText=widtet.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
						this.putData("sHtmlText", sHtmlText);
					}else{
						trade.setStatus(1);
						orderService.updateTrade(trade);
						List orderlist=orderService.getListByWhere(new StringBuffer(" and n.tradeNo='"+trade.getTrade_id()+"'"));
						if(orderlist!=null&&orderlist.size()>0){
							Order order=(Order) orderlist.get(0);
							order.setState("1");
							order.setIsPay("1");
							orderService.updateObj(order);
						}
						ResponseUtil.printl(this.HttpResponse, "<script>window.location.href=\"http://" + this.HttpRequest.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+trade.getTrade_id()+".html?result=succeed\";</script>");
						return ;
					}
				}else{
					ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"index.html");
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
				ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"index.html");
				return;
		}
	}
	
	

}
