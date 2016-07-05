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

package cn.com.dyninfo.o2o.furniture.payment.huanxun;

public class HuanConfig {

	public static String pMerchantCode;//商户号
	
	public static String Version="2.1.0";//接口版本号
	
	public static String pOrderCurrency="RMB";//交易的币种代码
	
	public static String pLanguage="GB";//界面语言 如果选择了“MD5 摘要” ，此处应填写“12” 。  如果选择了 “MD5WithRSA 摘要” 此处应填写“11”
	
	
	public static String pResHashArithmetic="12";//设定环迅支付将交易结果返回时使用的防篡改策略。
	
	public static String pResType="0";//交易的币种代码
	
	public static String pSuccessReturnUrl="http://www.c-1-tech.com/Dress/hxreturn.html";//
	/**
	 * 持卡人录入/支付完成后, 环迅支付会把录入/支付结果信息发送到此参数提供的地址.
	 * 注:非延时支付返回成功交易结果非延时支付返回成功交易结果; 
	 * 		;延时延时支付返回支付返回录入录入成功成功结果结果
	 */
	public static String pFailReturnUrl="";
	/**
	 * 如果该字段不为空，录入/支付失败时直接跳转到该链接参数，如果为空，则录入/支付失败跳转到pSuccessReturnUrl字段所提供的链接参数。
	 * 注:非延时支付返回非延时支付返回交易交易失失败败结果结果;
	 *  ;延时支付返回延时支付返回录入录入失败失败结果结果。
	 */
	public static String pEnableFraudGuard="1";//0不反欺诈 1反欺诈
	
	public static String pAttach="";
	
	
	
}
