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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.payment.huanxun.HuixuanParse;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 环迅挂件
 * @author Zebe
 * @date 2014/4/22
 *
 */
@Component("hx_widget")
@Scope("prototype")
public class HxWidget extends Widget {

	@Resource
	ZffsService zffsService;

	@Override
	public void display(Map pamtr) {

		// 获取支付方式
		Zffs zf = (Zffs)pamtr.get("zf");

		// 设置环迅支付信息
		//System.out.println("调用了环迅请求挂件！");
		//String Mer_code = "000015"; // 测试商户号
		//String Mer_key = "GDgLwwdK270Qj1w4xho8lyTpRQZV9Jm5x4NwWOTThUa4fMhEBK9jOXFrKRT6xhlJuU2FEa89ov0ryyjfJuuPkcGzO5CeVx5ZIrkkt1aBlZV36ySvHOMcNv8rncRiy3DQ";
		//炫品商户号 String Mer_key = "xM9TCokZ3XHqJ8waDa5FM5OUyZeRuggbEwTmxpHt1fVONH3rFQBLGx1syeUd8HfNrfaNfAcOJCEfaz6gVoBTULLHuboHKdkj07XhggB4no24jMGyYo7L5BtVLJT4ML4e";
		//炫品商户证书 String Mer_code = "027153";
		String Mer_code = zf.getZfb_id(); // 通过支付方式获取的商户号
		String Mer_key = zf.getZfb_code(); // 通过支付方式获取的商户证书：登陆http://merchant.ips.com.cn/商户后台下载的商户证书内容

		String Billno = (String)pamtr.get("tradeno"); // 商户订单编号
		DecimalFormat currentNumberFormat=new DecimalFormat("#0.00"); // 订单金额(保留2位小数) 
		String Amount = currentNumberFormat.format(Double.parseDouble((String)pamtr.get("total_fee")));
		String Date = new SimpleDateFormat("yyyyMMdd").format(new Date()); // 订单日期
		String Currency_Type = "RMB" ; // 币种 RMB 人民币
		String Gateway_Type = "01"; // 支付卡种  01 借记卡  04 IPS账户支付  08 IB支付  16 电话支付  64 储值卡支付
		String Lang = "GB"; //语言
		String Merchanturl = "http://www.c-1-tech.com/Dress/hx_return.html"; // 支付结果成功返回的商户URL
		String FailUrl = "http://www.c-1-tech.com/Dress/hx_return.html"; // 支付结果失败返回的商户URL
		String ErrorUrl = "" ; // 支付结果错误返回的商户URL  建议传空
		String Attach = ""; // 商户数据包
		String OrderEncodeType = "5"; // 订单支付接口加密方式  5 md5摘要
		String RetEncodeType = "17"; // 交易返回接口加密方式 16 md5withRsa   17 md5摘要
		String Rettype = "0"; // 返回方式  0 无Server to Server   1 有Server to Server
		String ServerUrl = "http://www.c-1-tech.com/Dress"; // Server to Server 返回页面URL
//		cryptix.jce.provider.MD5 b = new cryptix.jce.provider.MD5(); // 订单支付接口的Md5摘要，原文=订单号+金额+日期+支付币种+商户证书
		//订单加密的明文 billno+【订单编号】+ currencytype +【币种】+ amount +【订单金额】+ date +【订单日期】+ orderencodetype +【订单支付接口加密方式】+【商户内部证书字符串】 
//		String SignMD5 = Md5Util.toMD5("billno"+Billno +"currencytype"+Currency_Type+"amount"+ Amount + "date" +Date +"orderencodetype"+OrderEncodeType + Mer_key).toLowerCase();

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("Mer_code", Mer_code);
		sParaTemp.put("Billno", Billno);
		sParaTemp.put("Amount", Amount);
		sParaTemp.put("Date", Date);
		sParaTemp.put("Currency_Type", Currency_Type);
		sParaTemp.put("Gateway_Type", Gateway_Type);
		sParaTemp.put("Lang", Lang);
		sParaTemp.put("Merchanturl", Merchanturl);
		sParaTemp.put("FailUrl", FailUrl);
		sParaTemp.put("ErrorUrl", ErrorUrl);
		sParaTemp.put("Attach", Attach);
		sParaTemp.put("OrderEncodeType", OrderEncodeType);
		sParaTemp.put("RetEncodeType", RetEncodeType);
		sParaTemp.put("Rettype", Rettype);
		sParaTemp.put("ServerUrl", ServerUrl);
		sParaTemp.put("SignMD5", "");

		// 调用 HuixuanParse 建立请求
		String sHtmlText = HuixuanParse.buildRequest(sParaTemp, "post");
		this.putData("sHtmlText", sHtmlText);

	}

}
