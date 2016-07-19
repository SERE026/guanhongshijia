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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuixuanParse {

	
	/**
     * 环迅提供给商户的服务接入网关URL
     */
    private static final String HUANXUN_GATEWAY = "https://pay.ips.com.cn/ipayment.aspx?"; // 正式提交地址
   // private static final String HUANXUN_GATEWAY = "http://pay.ips.net.cn/ipayment.aspx?"; // 测试提交地址
    
	/**
     * 生成要请求给环迅的参数数组
     * @param sParaTemp 请求前的参数数组
     * @return 要请求的参数数组
     */
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        //除去数组中的空值
        Map<String, String> sPara = paraFilter(sParaTemp);
        return sPara;
    }
	
	/**
     * 建立请求，以表单HTML形式构造（默认）
     * @param sParaTemp 请求参数数组
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod) {
        //待请求参数数组
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
        sbHtml.append("<form id=\"huanxunsubmit\" name=\"huanxunsubmit\" action=\"" + HUANXUN_GATEWAY
                      + "_input_charset=utf-8" + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit按钮控件请不要含有name属性
        sbHtml.append("</form>");
        sbHtml.append("<script>document.forms['huanxunsubmit'].submit();</script>");

        return sbHtml.toString();
    }
	
    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
	
	

	/**
	 * 解析XML
	 * @param trade_no
	 * @param total_fee
	 * @param pSuccessReturnUrl
	 * @return
	 */
	public String getpICPayReqXml(String trade_no,String total_fee,String pSuccessReturnUrl){
		StringBuffer xml=new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xml.append("<IPSReqRoot>");
		xml.append("<ICPay>");
		xml.append("<Version><![CDATA["+HuanConfig.Version+"]]></Version>");
		xml.append("<StandardPaymentReq>");
		xml.append("<pMerchantOrderNum><![CDATA["+trade_no+"]]></pMerchantOrderNum>");
		xml.append("<pOrderAmount><![CDATA["+total_fee+"]]></pOrderAmount>");
		xml.append("<pDisplayAmount><![CDATA["+total_fee+"]]></pDisplayAmount>");
		xml.append("<pMerchantTransactionTime><![CDATA["+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"]]></pMerchantTransactionTime>");
		xml.append("<pOrderCurrency><![CDATA[RMB]]></pOrderCurrency>");
		xml.append("<pLanguage><![CDATA[GB]]></pLanguage>");
		xml.append("<pSuccessReturnUrl><![CDATA["+HuanConfig.pSuccessReturnUrl+"]]></pSuccessReturnUrl>");
		xml.append("<pFailReturnUrl><![CDATA["+HuanConfig.pSuccessReturnUrl+"]]></pFailReturnUrl>");
		xml.append("<pErrorReturnUrl><![CDATA[]]></pErrorReturnUrl>");
		xml.append("<pS2SReturnUrl><![CDATA[http://192.168.2.234:8001/TradeResult_SVR.aspx]]></pS2SReturnUrl>");
		xml.append("<pResType><![CDATA["+HuanConfig.pResType+"]]></pResType>");
		xml.append("<pResHashArithmetic><![CDATA["+HuanConfig.pResHashArithmetic+"]]></pResHashArithmetic>");
		xml.append("<pProductName><![CDATA[]]></pProductName>");
		xml.append("<pProductDescription><![CDATA[]]></pProductDescription>");
		xml.append("<pAttach><![CDATA[]]></pAttach>");
		xml.append("<pEnableFraudGuard><![CDATA[0]]></pEnableFraudGuard>");
		xml.append("</StandardPaymentReq>");
		xml.append("</ICPay>");
		xml.append("</IPSReqRoot>");
		return xml.toString();
	}
}
