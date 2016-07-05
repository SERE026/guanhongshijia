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

package cn.com.dyninfo.o2o.furniture.web.hx.widget;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 环迅支付返回处理挂件
 * @author Zebe
 * @date 2014/4/22
 *
 */
@Component("hx_return")
@Scope("prototype")
public class HxReturn extends Widget {

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
		//System.out.println("环迅已返回，等待挂件处理！");
		HttpServletRequest  request=this.HttpRequest;
		HttpServletResponse response=this.HttpResponse;
//		String[] resArr = new String[QuickPayConf.notifyVo.length]; 
//		for(int i=0;i<QuickPayConf.notifyVo.length;i++){
//		resArr[i] = request.getParameter(QuickPayConf.notifyVo[i]);
//		}
//		String signature = request.getParameter(QuickPayConf.signature);
//		String signMethod = request.getParameter(QuickPayConf.signMethod);

//		response.setContentType("text/html;charset="+QuickPayConf.charset);
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding(QuickPayConf.charset);
		response.setCharacterEncoding("utf-8");
		HuiyuanInfo huiyuan=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);

		try {
			String trade_no=request.getParameter("billno");
			Trade trade=orderService.getTrade(trade_no);
//			Boolean signatureCheck = new QuickPayUtils().checkSign(resArr, signMethod, signature);
			// 如果支付成功
			String payStatus = request.getParameter("succ");
			if("Y".equalsIgnoreCase(payStatus)){
				if(trade.getStatus()==0){
					huiyuan=trade.getHuiyuan();
					huiyuanMoneyService.addTopup(trade.getMoney(), trade.getZffs(), huiyuan);
					trade.setStatus(1);
					orderService.updateTrade(trade);
					// 如果是订单
					if(trade.getFlag()==1){
						Double d=orderService.getTradeMoney(trade_no);
						if(d<=huiyuan.getMoney()){
							orderService.updateOrderPlay(trade_no);
							this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/play_succeed-"+trade_no+".html?result=succeed\";</script>");
							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=success");
							return ;
						}else{
							this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/play_succeed-"+trade_no+".html?result=fail\";</script>");
							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=fail");
							return ;
						}
					}else{
						// 如果是充值
						this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
						//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney());
						return ;
					}
				}else{
					if(trade.getFlag()==1){//订单支付
						this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/play_succeed-"+trade_no+".html?result=succeed\";</script>");
					}else{
						this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
					}

				}
			}else{
//				response.getWriter()
//				.append("建议前台通知和后台通知用两个类实现，后台通知进行商户的数据库等处理,前台通知实现客户浏览器跳转<br>")
//				.append("签名是否正确："+ signatureCheck)
//				.append("<br>交易是否成功："+"00".equals(resArr[10]));
//				if(!"00".equals(resArr[10])){
//					response.getWriter().append("<br>失败原因:"+resArr[11]);
//				}
				if(trade.getFlag()==1){
					this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/play_succeed-"+trade_no+".html?result=fail\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=fail");
					//response.setStatus(HttpServletResponse.SC_OK);
				}else{
					this.putData("html", "<script>window.location.href=\"http://www.c-1-tech.com/Dress/chong_succeed-"+trade_no+".html?result=fail\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+trade_no+".html?result=fail&money="+trade.getMoney());
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
