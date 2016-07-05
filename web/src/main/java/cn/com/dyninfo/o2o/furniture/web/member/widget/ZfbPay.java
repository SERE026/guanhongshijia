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

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.TradeUtil;


import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.TradeService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 支付宝会员充值挂件
 * @author Zebe
 * @date 2014/4/17
 *
 */
@Component("zfbpay")
public class ZfbPay extends Widget {

	@Resource
	private HuiyuanService huiyuanService;

	@Resource
	private ZffsService zffsService;
	
	@Resource
	private TradeService tradeService;

	@Override
	public void display(Map pamtr) {

		
		// 检查是否登录
		HuiyuanInfo huiyuan=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		if (huiyuan == null) {
			ForwordTool.goToForword(this.HttpResponse, this.HttpRequest, "login.html");
		} else {
			// System.out.println(huiyuan.getName() + "已登录。");
		}
		
		
		// 交易信息设置（防止中文乱码请在返回页面加<meta http-equiv="content-type" content="text/html; charset=UTF-8">）
		String subject = "炫品妆成支付";
		String total_fee = (String)pamtr.get("total_fee");
		String out_trade_no = TradeUtil.createTradeNumber();
		
		// 保存交易
		Trade trade = new Trade();
		trade.setMoney(Double.parseDouble(total_fee));
		trade.setTrade_id(out_trade_no);
		trade.setStatus(0);
		trade.setHuiyuan(huiyuan);
		trade.setFlag(0);
		
		String zfId=(String) pamtr.get("czType");
		trade.setZffs((Zffs)zffsService.getObjById(zfId));
		zffsService.addObj(trade);
		
		/**
		 * 支付宝支付信息
		 * notify_url 异步通知地址
		 * return_url 同步通知地址
		 * subject 订单名称 ps：显示的文字
		 */
		pamtr.put("subject", subject);//订单名称
		pamtr.put("body", "充值金额："+total_fee+"元");//订单名称
		
		pamtr.put("zf", trade.getZffs());
		pamtr.put("orderMoney", ""+total_fee);
		pamtr.put("shippingPrice", "0");
		pamtr.put("tradeno", out_trade_no);
		pamtr.put("tradeMoney", ""+total_fee);
		pamtr.put("total_fee", ""+total_fee);
		
		Widget widtet=SpringContext.getBean(trade.getZffs().getWidget_name());
		String sHtmlText=widtet.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
		this.putData("sHtmlText", sHtmlText);
	}

}
