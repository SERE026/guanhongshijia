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

package cn.com.dyninfo.o2o.furniture.payment.zfb.mobile;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088311579535283";
	// 商户的私钥
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKhr6ae+55BMU1dwIq0Eqh/UzWD5tiWOKt6WH6GizRpe/HnP9IMricV7HWgCL7MFHo6aUV2Qbf5s5VX3EMPmMLuEt0J7heGhZyiF8w6p5M9JulOSMN7QA1IMeVByxTCXt2xPcbILWUY56vPegFtCYE0KjOKY9sHAYa0K5z22FsHZAgMBAAECgYAVRqSau0QXd3zjw9etkbRIFyLmyETZU69YtRBD5AQS+8LbRIj39Q0PdHEPjY8nB1OH4ji7IB61EF6cUHy+spqfMS6cypA/scFw9Bx1GDxmf7JPWeucBjpGH+lmZ6+U+gaKlJXucp+BdNt0G53wf3KBQmYMABNfQm+8Bspi9mfmfQJBANjv36f9fE2DxKd8WF0Bv8A8/zcRtb/NoBTy5EjY+2yXrX2TPw9b/Gl3PGvlZnc75C9KsUZ65JyWU76MYz8R5bMCQQDGv6Ajbti6HGM7xb3K+E/hxtQl2FIZ8NpQWL3TOAm0bkxn6movea76ghih0jWntLrVKFRyAyqauBIB+cRkr8xDAkEAxQvdEzHkHmR508fWW2SjT3IYP2UOuVGE/oJBaQnuFg0PwOhmdwUOmJ19fGO6VsNH2Mz3iRVHYhQJrSLHYxpWkQJAZUe/nm7dSLIwq4QQPL+fTYnaEFMVO5zuU6V1To6u+2B91TKy2/Chh40GamhJ6WWDFB7SMauFaYTFwHX8a+beKwJAB1edNaIMptV1p/VX74n9seR6bkHAQGQMo/w3VRZmSpFDynLh1/Xe896RYEvQBExbY1/KrReRSCAcLkArsmaDcw==";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
