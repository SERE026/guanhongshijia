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

package cn.com.dyninfo.o2o.furniture.web.goods.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.CookTool;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.dao.ShowGoodDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.service.ShowGoodService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

@Service("showGoodService")
public class ShowGoodServiceImpl extends BaseService implements ShowGoodService {

	@Resource
	private ShowGoodDAO showGoodDAO;

	@Override
	public void initDao() {
		this.baseDao=showGoodDAO;
	}

	@Override
	public void addShowLog(int good_id, HttpServletRequest request) {
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member!=null){
			showGoodDAO.addData(""+member.getHuiYuan_id(), good_id);
		}else{
			String cookieId=CookTool.getCookIEValue(Context.COOKIE_CLIENT_ID,request);
			showGoodDAO.addData(cookieId, good_id);
		}
	}

	@Override
	public void checkShowGoods(HttpServletResponse response,
			HttpServletRequest request) {
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		String cookIe_id=CookTool.getCookIEValue(Context.COOKIE_CLIENT_ID, request);
		
		showGoodDAO.updateClient(cookIe_id, ""+member.getHuiYuan_id());
	}
}
