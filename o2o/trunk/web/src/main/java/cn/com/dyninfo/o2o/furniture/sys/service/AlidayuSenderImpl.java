/*
 *
 * Copyright (c) 2009-2014 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
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
package cn.com.dyninfo.o2o.furniture.sys.service;

import cn.com.dyninfo.o2o.furniture.util.SystemConfig;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Description：
 * 
 * 
 * 
 * @Author : abel.lin
 * @Date   : 2014年12月30日 下午2:58:16
 * @Version: 1.0.0-SNAPSHOT
 */
@Service("alidayuSender")
public class AlidayuSenderImpl implements SmsSender,InitializingBean {
	
	private static Logger logger= LoggerFactory.getLogger(AlidayuSenderImpl.class);
 
	private String appKey;
	private String appSecret;
    private String sign;
    private String url;

	@Override
	public boolean sendSms(String to, String content) {
	 
		return false;
	}

	 
	@Override
	public boolean sendSmsWithTemplate(String to, String smsType,String params[]) {
		String templateId = "";
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		if(StringUtils.equals("VCODE", smsType)){
			templateId= SystemConfig.getInfo("alidayu.sms.template.code");
			req.setSmsParamString("{\"code\":\"" + params[0] + "\"}");
		}else if(StringUtils.equals("PWD", smsType)){
			templateId= SystemConfig.getInfo("alidayu.sms.template.pwd");
			req.setSmsParamString("{\"name\":\"" + params[0] + "\", \"carrier\":\"" + params[1] + "\",\"battery\":\"" + params[2] + "\"}");
		}
 
		if(StringUtils.isNotBlank(templateId)){
            TaobaoClient client = new DefaultTaobaoClient(url, appKey, appSecret);
//            req.setExtend("123456");
            req.setSmsType("normal");
            req.setSmsFreeSignName(sign);
            req.setRecNum(to);
            req.setSmsTemplateCode(templateId);
            AlibabaAliqinFcSmsNumSendResponse rsp = null;
            try {
                rsp = client.execute(req);
            } catch (ApiException e) {
                logger.error("Send message failed", e);
            }
            logger.debug("Alidayu return message:" + rsp.getBody());
            if (rsp.getResult() != null) {
                return "0".equals(rsp.getResult().getErrCode());
            }
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
	 
		appKey = SystemConfig.getInfo("aliyun.app.key");
		appSecret =SystemConfig.getInfo("aliyun.app.secret");
        sign = SystemConfig.getInfo("alidayu.sms.sign.name");
        url = SystemConfig.getInfo("alidayu.sms.url");

	}

}
