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

package cn.com.dyninfo.o2o.furniture.payment.yl;

import cn.com.dyninfo.o2o.furniture.sys.Constants;

/**
 * 名称：支付配置类
 * 功能：配置类
 * 类属性：公共类
 * 版本：1.0
 * 日期：2011-03-11
 * 作者：中国银联UPOP团队
 * 版权：中国银联
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。该代码仅供参考。
 * */

public class QuickPayConf {
	
	//版本号
	public final static String version="1.0.0";
	
	//编码方式
	public final static String charset="UTF-8";
	
	//支付网址
	public  static String gateWay="http://www.epay.lxdns.com/UpopWeb/api/Pay.action";
	
	//后续交易网址
	public  static String backStagegateWay="http://www.epay.lxdns.com/UpopWeb/api/BSPay.action";
	
	//查询网址
	public final static String queryUrl="http://www.epay.lxdns.com/UpopWeb/api/Query.action";
	
	//商户代码
	public  static String merCode="105550149170027";
	
	//商户名称
	public  static String merName="炫品妆成";
	//前台通知
	public  static String merFrontEndUrl =Constants.DOMAIN_NAME + "/" + Constants.ADMIN_ADDRESS + "/ylreturn.html";
	//后台通知
	public  static String merBackEndUrl =Constants.DOMAIN_NAME + "/" + Constants.ADMIN_ADDRESS + "/ylnotify.html";
	
	//加密方式
	public final static String signType="MD5";
	
	//商城密匙，需要和银联商户网站上配置的一样
	public  static String securityKey="DFJI3TKSDG934KWSD8GKW93KLD90L";
	
	//签名
	public final static String signature="signature";
	public final static String signMethod="signMethod";
	
	//组装消费请求包
	public final static String[] reqVo = new String[]{
			"version",
            "charset",
            "transType",
            "origQid",
            "merId",
            "merAbbr",
            "acqCode",
            "merCode",
            "commodityUrl",
            "commodityName",
            "commodityUnitPrice",
            "commodityQuantity",
            "commodityDiscount",
            "transferFee",
            "orderNumber",
            "orderAmount",
            "orderCurrency",
            "orderTime",
            "customerIp",
            "customerName",
            "defaultPayType",
            "defaultBankNumber",
            "transTimeout",
            "frontEndUrl",
            "backEndUrl",
            "merReserved"
	};
	
	public final static String[] notifyVo = new String[]{
            "charset",
            "cupReserved",
            "exchangeDate",
            "exchangeRate",
            "merAbbr",
            "merId",
            "orderAmount",
            "orderCurrency",
            "orderNumber",
            "qid",
            "respCode",
            "respMsg",
            "respTime",
            "settleAmount",
            "settleCurrency",
           // "settleCurrencyIndex",
            "settleDate",
            "traceNumber",
            "traceTime",
            "transType",
            "version"
	};
	
	public final static String[] queryVo = new String[]{
		"version",
		"charset",
		"transType",
		"merId",
		"orderNumber",
		"orderTime",
		"merReserved"
	};
	
	
}
