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

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.payment.zfb.AlipayNotify;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 支付宝异步通知
 * @author Administrator
 *
 */
@Component("notify")
@Scope("prototype")
public class Notify extends Widget {
	
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
		try {
		HttpServletRequest  request=this.HttpRequest;
		HttpServletResponse  reqponse=this.HttpResponse;
		//获取支付宝POST过来反馈信息
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
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)
		//商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
		
		
		
		
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		try {
			FileWriter fileWriter=new FileWriter("c:\\Result.txt", true);
			fileWriter.write("\r\nAlipayNotify.verify(params):"+AlipayNotify.verify(params));
			fileWriter.write("\r\ncn.com.dyninfo.o2o.furniture.payment.zfb.mobile.AlipayNotify.verify(params):"+ cn.com.dyninfo.o2o.furniture.payment.zfb.mobile.AlipayNotify.verify(params));
			fileWriter.write("\r\nout_trade_no:"+out_trade_no);
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		if(AlipayNotify.verify(params)|| cn.com.dyninfo.o2o.furniture.payment.zfb.mobile.AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				
				//注意：
				//该种交易状态只在两种情况下出现
				//1、开通了普通即时到账，买家付款成功后。
				//2、开通了高级即时到账，从该笔交易成功时间算起，过了签约时的可退款时限（如：三个月以内可退款、一年以内可退款等）后。
			} else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				//注意：
				//该种交易状态只在一种情况下出现——开通了高级即时到账，买家付款成功后。
			}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			this.putData("result", "success");
			this.putData("order", orderService.getListByPage(new StringBuffer(" and n.tradeNo='"+out_trade_no+"' ")));
			Trade trade=orderService.getTrade(out_trade_no);
			if(trade.getStatus()==0){
					
					huiyuanMoneyService.addTopup(trade.getMoney(), trade.getZffs(), trade.getHuiyuan());
					trade.setStatus(1);
					orderService.updateTrade(trade);
					
					this.putData("money", trade.getMoney());
					if(trade.getFlag()==1){//订单支付
						Double d=orderService.getTradeMoney(out_trade_no);
						if(d<=trade.getHuiyuan().getMoney()){
							orderService.updateOrderPlay(out_trade_no);
						}else{
							this.putData("result", "fail");
						}
					}else{
						this.setPageName("HuiyuanChongzhiReturn.html");
						
					}
			}
			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			this.putData("str", "fail");
		}
			this.setPageName("notify.html");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
