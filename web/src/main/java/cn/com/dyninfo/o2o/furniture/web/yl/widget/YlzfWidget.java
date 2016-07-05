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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.payment.yl.QuickPayConf;
import cn.com.dyninfo.o2o.furniture.payment.yl.QuickPayUtils;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

@Component("ylzf_widget")
@Scope("prototype")
public class YlzfWidget extends Widget {

	@Override
	public void display(Map pamtr) {
		
		String tradeno=(String) pamtr.get("tradeno");
		String ps=(String) pamtr.get("subject");
		String tradeMoney=(String) pamtr.get("total_fee");
		String orderMoney=(String) pamtr.get("orderMoney");
		String shippingPrice=(String) pamtr.get("shippingPrice");
		System.out.println(ps);
		//商户需要组装如下对象的数据
		String[] valueVo = new String[]{
				QuickPayConf.version,//协议版本
				QuickPayConf.charset,//字符编码
	            "01",//交易类型
	            "",//原始交易流水号
	            QuickPayConf.merCode,//商户代码
	            QuickPayConf.merName,//商户简称
	            "",//收单机构代码（仅收单机构接入需要填写）
	            "",//商户类别（收单机构接入需要填写）
	            "http://218.80.192.2231/shop1/payment/quickpay/quickpay_result.php?payid=123456&dd=123",//商品URL
	            ps,//商品名称
	            ""+Math.round(Double.parseDouble(orderMoney)*100),//商品单价 单位：分
	            "1",//商品数量
	            "0",//折扣 单位：分
	            ""+Math.round(Double.parseDouble(shippingPrice)*100),//运费 单位：分
	            tradeno,//订单号（需要商户自己生成）
	            ""+Math.round(Double.parseDouble(tradeMoney)*100),//交易金额 单位：分
	            "156",//交易币种
	            new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),//交易时间
	            "127.0.0.1",//用户IP
	            "张三",//用户真实姓名
	            "",//默认支付方式
	            "",//默认银行编号
	            "120000",//交易超时时间
	            QuickPayConf.merFrontEndUrl,// 前台回调商户URL
	            QuickPayConf.merBackEndUrl,// 后台回调商户URL
	            ""//商户保留域
		};
		
		/*
		 * 说明：以下代码直接返回跳转到银联在线支付页面字符串
		 *       new QuickPayUtils().createPayHtml(valueVo)
		 */
		String html = new QuickPayUtils().createPayHtml(valueVo);//跳转到银联页面支付
		System.out.println("当前html："+html);
		this.putData("sHtmlText", html);
	}

}
