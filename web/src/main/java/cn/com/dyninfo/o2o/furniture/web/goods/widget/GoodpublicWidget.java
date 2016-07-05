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

package cn.com.dyninfo.o2o.furniture.web.goods.widget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.CookTool;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

/**
 * 公共产品挂件
 * @author 王敏
 *
 */
@Component("pgood")
public class GoodpublicWidget extends Widget {

	@Resource
    private PagModInGoodsService pagModInGoodsService;
	
	@Override
	public void display(Map pamtr) {
		Map map=new HashMap();
		String key=(String) pamtr.get("key");
		if(key.toUpperCase().equals("CLIENTID")){//最近浏览
			String clientID="";
			HuiyuanInfo huiyuan=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(huiyuan==null){
				clientID=CookTool.getCookIEValue(Context.COOKIE_CLIENT_ID,HttpRequest);
			}else{
				clientID=""+huiyuan.getHuiYuan_id();
			}
			map.put("clientID", clientID);
		}
		if(key.toUpperCase().equals("GOODSORTID")){
			map.put("goodSort_id", pamtr.get("goodSort_id"));
		}
		String pageSize=(String) pamtr.get("pageSize");
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(Integer.parseInt(pageSize));
		String moduleId=(String) pamtr.get("moduleId");
		String flag=(String) pamtr.get("flag");
		List showList=pagModInGoodsService.getGoods(Integer.parseInt(moduleId), arear!=null?arear.getId():null, Integer.parseInt(flag), page, map);
		this.setPageName("pgood.html");
		this.putData("showList", showList);
	}

}
