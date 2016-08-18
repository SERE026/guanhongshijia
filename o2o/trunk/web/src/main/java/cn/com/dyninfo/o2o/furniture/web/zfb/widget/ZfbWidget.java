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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.CityTool;

import cn.com.dyninfo.o2o.furniture.payment.zfb.AlipayConfig;
import cn.com.dyninfo.o2o.furniture.payment.zfb.AlipaySubmit;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 支付宝挂件
 * @author Zebe
 * @date 2014/4/15
 *
 */
@Component("zfb_widget")
@Scope("prototype")
public class ZfbWidget extends Widget {

	@Resource
	ZffsService zffsService;
	
	@Override
	public void display(Map pamtr) {
		
		// 设置支付宝基础信息
		System.out.println("调用了支付宝请求挂件！");
		AlipayConfig.input_charset = "utf-8";
		
		// 配置基础交易数据
		Zffs zf = (Zffs)pamtr.get("zf");
//		AlipayConfig.key=
				//zf.getZfb_code();
		String tradeno=(String) pamtr.get("tradeno");
//		AlipayConfig.partner=
				//zf.getZfb_id();
//		AlipayConfig.zfbNo=
				//zf.getZfb_zhanghao();
		String exter_invoke_ip = CityTool.getClientIp(this.HttpRequest); // 客户端的IP地址
		String total_fee = (String)pamtr.get("total_fee");
		
		// 根据交易类型配置其它数据
		String subject=(String) pamtr.get("subject");
		String body=(String) pamtr.get("body");
		
		System.out.println(tradeno);
		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user"); // 这个参数是指通过用户创建直接交易
		sParaTemp.put("partner",AlipayConfig.partner); // 合作者（商家）的身份ID，以2088开头由16位纯数字组成的字符串
		sParaTemp.put("_input_charset", AlipayConfig.input_charset); // 表单提交时编码类型
		sParaTemp.put("payment_type", "1"); // 支付类型（1：代表？？）
		sParaTemp.put("notify_url", "http://www.guanhongshijia.com/notify_url.html"); // 需http://格式的完整路径，不能加?id=123这类自定义参数。服务器异步通知页面路径（这是为了防止用户在充值后立即关闭页面，这样的说法是否正确？？？）
		sParaTemp.put("return_url", "http://www.guanhongshijia.com/return_url.html"); // 需http://格式的完整路径，不能加?id=123这类自定义参数。服务器同步通知页面路径（支付宝付款成功/失败时，会传入一系列参数到这个页面）
		sParaTemp.put("seller_email", AlipayConfig.zfbNo); // 商家（卖家）支付宝账号（这个账号必须是申请过即时到账交易的）
		sParaTemp.put("body", body); // 交易内容描述
		sParaTemp.put("out_trade_no", tradeno);
		sParaTemp.put("subject", subject); // 主题，显示在支付宝充值界面
		
		
		sParaTemp.put("total_fee", "0.01"); // 交易金额
		
		sParaTemp.put("show_url", "http://www.guanhongshijia.com/" ); // 商品展示地址，具体指的是？？？？
		sParaTemp.put("anti_phishing_key", ""); // 防钓鱼时间戳
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip); // 客户端的IP地址
		
		// 调用 AlipaySubmit 建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "post", "确认");
		this.putData("sHtmlText", sHtmlText);
		
	}

}
