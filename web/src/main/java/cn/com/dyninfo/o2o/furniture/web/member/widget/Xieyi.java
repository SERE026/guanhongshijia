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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.page.model.Articles;
import cn.com.dyninfo.o2o.furniture.web.page.service.ArticlesService;

/**
 * 用户协议挂件
 * @author Zebe
 * @date 2014/5/6
 *
 */
@Component("xieyi")
public class Xieyi extends Widget {

	@Resource
	private ArticlesService articlesService;

	@Override
	public void display(Map pamtr) {
		StringBuffer where = new StringBuffer();
		where.append(" and n.artices_name like '%用户协议%'");
		List<Articles> list = (List<Articles>)articlesService.getListByWhere(where);
		if (list.size() > 0) {
			Articles a = list.get(0);
			this.putData("xieyi", a.getArtices_content());
		} else {
			this.putData("xieyi", "用户协议未添加，请使用管理员账户登录后台管理系统，<br>在【页面管理】-> 【文章管理】下添加一篇名为“<b>用户协议</b>”的文章并编辑内容即可。");
		}
		this.setPageName("Xieyi.html");
	}

}
