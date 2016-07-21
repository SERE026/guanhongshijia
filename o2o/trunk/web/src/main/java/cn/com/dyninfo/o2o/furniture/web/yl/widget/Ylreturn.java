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

package cn.com.dyninfo.o2o.furniture.web.yl.widget;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.payment.yl.QuickPayConf;
import cn.com.dyninfo.o2o.furniture.payment.yl.QuickPayUtils;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 银联前台通知
 * @author 王敏
 *
 */
@Component("ylreturn")
@Scope("prototype")
public class Ylreturn extends Widget {
	
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
		HttpServletRequest  request=this.HttpRequest;
		HttpServletResponse response=this.HttpResponse;
		String[] resArr = new String[QuickPayConf.notifyVo.length]; 
		for(int i=0;i<QuickPayConf.notifyVo.length;i++){
			resArr[i] = request.getParameter(QuickPayConf.notifyVo[i]);
		}
		String signature = request.getParameter(QuickPayConf.signature);
		String signMethod = request.getParameter(QuickPayConf.signMethod);
		
		response.setContentType("text/html;charset="+QuickPayConf.charset);   
		response.setCharacterEncoding(QuickPayConf.charset);
		HuiyuanInfo huiyuan=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		
		try {
			String trade_no=resArr[8];
			Trade trade=orderService.getTrade(trade_no);
			Boolean signatureCheck = new QuickPayUtils().checkSign(resArr, signMethod, signature);
			if(signatureCheck&&"00".equals(resArr[10])){
				if(trade.getStatus()==0){
					huiyuan=trade.getHuiyuan();
					huiyuanMoneyService.addTopup(trade.getMoney(), trade.getZffs(), huiyuan);
					trade.setStatus(1);
					orderService.updateTrade(trade);
					
					if(trade.getFlag()==1){
						Double d=orderService.getTradeMoney(trade_no);
						if(d<=huiyuan.getMoney()){
							orderService.updateOrderPlay(trade_no);
							this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+trade_no+".html?result=succeed\";</script>");
							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=success");
							return ;
						}else{
							this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+trade_no+".html?result=fail\";</script>");
							//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=fail");
							return ;
						}
					}else{
						this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
						//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney());
						return ;
					}
				}else{
					if(trade.getFlag()==1){//订单支付
						this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+trade_no+".html?result=succeed\";</script>");
					}else{
						this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/chong_succeed-"+trade_no+".html?result=succeed&money="+trade.getMoney()+"\";</script>");
					}
					
				}
			}else{
				response.getWriter()
				.append("建议前台通知和后台通知用两个类实现，后台通知进行商户的数据库等处理,前台通知实现客户浏览器跳转<br>")
				.append("签名是否正确："+ signatureCheck)
				.append("<br>交易是否成功："+"00".equals(resArr[10]));
				if(!"00".equals(resArr[10])){
					response.getWriter().append("<br>失败原因:"+resArr[11]);
				}
				if(trade.getFlag()==1){
					this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/play_succeed-"+trade_no+".html?result=fail\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"play_succeed-"+trade_no+".html?result=fail");
					//response.setStatus(HttpServletResponse.SC_OK);
				}else{
					this.putData("html", "<script>window.location.href=\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/chong_succeed-"+trade_no+".html?result=fail\";</script>");
					//ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"chong_succeed-"+trade_no+".html?result=fail&money="+trade.getMoney());
				}
			}
			
			
		} catch (IOException e) {
			
		}

	}

}
