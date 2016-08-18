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

package cn.com.dyninfo.o2o.furniture.web.zfb.widget;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.payment.zfb.AlipayNotify;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 支付宝同步通知
 * @author Administrator
 *
 */
@Component("return")
@Scope("prototype")
public class Return extends Widget {

	@Resource
	OrderService orderService;
	
	@Resource
	HuiyuanMoneyService huiyuanMoneyService;
	
	@Resource
	ZffsService zffsService;
	
	@Resource
	private HuiyuanService huiyuanService;
	@Override
	public void display(Map pamtr) {
		this.setPageName("Return.html");
		try {
			HttpServletRequest  request=this.HttpRequest;
			HttpServletResponse  reqponse=this.HttpResponse;
			//获取支付宝GET过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	
			//支付宝交易号
	
			//String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			String total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
	
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			//计算得出通知验证结果
			Trade trade=orderService.getTrade(out_trade_no);
			System.out.println(trade.getFlag());
			System.out.println(trade.getStatus());
//			if(AlipayNotify.verify(params)|| cn.com.dyninfo.o2o.furniture.payment.zfb.mobile.AlipayNotify.verify(params)){//验证成功
				if(AlipayNotify.verify(params)|| cn.com.dyninfo.o2o.furniture.payment.zfb.mobile.AlipayNotify.verify(params)){//验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				//请在这里加上商户的业务逻辑程序代码
	
				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					//判断该笔订单是否在商户网站中已经做过处理
//						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//						//如果有做过处理，不执行商户的业务程序
//				}
				
				//该页面可做页面美工编辑
				this.putData("result", "success");
				this.putData("order", orderService.getListByPage(new StringBuffer(" and n.tradeNo='"+out_trade_no+"' ")));
				
				
//				if(trade.getStatus()==0){
//					this.HttpRequest.setAttribute(Context.SESSION_MEMBER, trade.getHuiyuan());
//					huiyuanMoneyService.addTopup(trade.getMoney(), trade.getZffs(), trade.getHuiyuan());
//					trade.setStatus(1);
//					orderService.updateTrade(trade);
//					this.putData("money", trade.getMoney());
//					if(trade.getFlag()==1){//订单支付
//						Double d=orderService.getTradeMoney(out_trade_no);
//						if(d<=trade.getHuiyuan().getMoney()){
//							orderService.updateOrderPlay(out_trade_no);
//							this.putData("html", "<script>window.location.href=\"http://" + www.guanhongshijia.com + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+out_trade_no+".html?result=succeed\";</script>");
//
//							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,);
//						}else{
//							this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+out_trade_no+".html?result=fail\";</script>");
//
//							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+out_trade_no+".html?result=fail");
//						}
//					}else{
//						this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/chong_succeed-"+out_trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
//						//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+out_trade_no+".html?result=succeed&money="+trade.getMoney());
//
//					}
					
					
//				}else{
					if(trade.getFlag()==1){//订单支付
//						trade.setStatus(1);
//						orderService.updateTrade(trade);
//						List orderlist=orderService.getListByWhere(new StringBuffer(" and n.tradeNo='"+trade.getTrade_id()+"'"));
//						if(orderlist!=null&&orderlist.size()>0){
//							Order order=(Order) orderlist.get(0);
//							//支付总额小于20000（系统定义）的金额
//							//状态为7-已付定金。
//							if (order.getDepositAmount()==Constants.DEPOSIT_AMOUNT){
//								order.setState("7");
//								order.setIsPay("0");
//							}else {
//								order.setState("1");
//								order.setIsPay("1");
//							}
//							orderService.updateObj(order);
//						}
						this.putData("html", "<script>window.location.href=\"http://www.guanhongshijia.com/play_succeed-"+out_trade_no+".html?result=succeed\";</script>");
					}else{
						this.putData("html", "<script>window.location.href=\"http://www.guanhongshijia.com/chong_succeed-"+out_trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
					}
					
//				}
				//////////////////////////////////////////////////////////////////////////////////////////
			}else{
				//该页面可做页面美工编辑
				//out.println("验证失败");
				this.putData("result", "fail");
				if(trade.getFlag()==1){//订单支付
					this.putData("html", "<script>window.location.href=\"http://www.guanhongshijia.com/play_succeed-"+out_trade_no+".html?result=fail\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+out_trade_no+".html?result=fail");
				}else{
					this.putData("html", "<script>window.location.href=\"http://www.guanhongshijia.com/chong_succeed-"+out_trade_no+".html?result=fail&money="+trade.getMoney()+"\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+out_trade_no+".html?result=fail&money="+trade.getMoney());
				}
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
