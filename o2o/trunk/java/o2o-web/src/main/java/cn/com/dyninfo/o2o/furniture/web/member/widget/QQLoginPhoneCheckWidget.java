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

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;

/**
 * QQ登录手机号码验证挂件
 * @author Zebe
 * @date 2014/4/30
 *
 */
@Component("phoneCheck")
public class QQLoginPhoneCheckWidget extends Widget {

	@Resource
	private HuiyuanService huiyuanService;
	
	@Override
	public void display(Map pamtr) {
		String action = (String)pamtr.get("action"); // 是否已经验证的标志
		String phone = (String)pamtr.get("phone"); // 验证的手机号
		HuiyuanInfo huiyuan = (HuiyuanInfo)this.HttpRequest.getSession().getAttribute(Context.SESSION_QQUSER);
		// 如果已验证，保存用户信息
		if ("ok".equalsIgnoreCase(action)) {
			huiyuan.setPhone(phone); // 手机号
			huiyuan.setPhonestate("1"); // 手机已验证
			huiyuanService.addObj(huiyuan);
			// 保存用户session并跳转到首页
			this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER, huiyuan);
			ForwordTool.goToForword(this.HttpResponse, this.HttpRequest, "index.html");
		}
		this.putData("qquser", huiyuan);
		this.setPageName("phoneCheck.html");
	}

}
