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

package cn.com.dyninfo.o2o.furniture.web.address.widget;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.CookTool;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;



@Component("ArearWidget")
public class ArearWidget extends Widget {

	@Resource
	private AreaService areaService;
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action!=null&&action.equals("switch")){
			String id=(String) pamtr.get("id");
			if(id.equals("ALL")){
				this.HttpRequest.getSession().removeAttribute(Context.SESSION_AEAR);
				this.putData("json", "{\"status\":1}");
				CookTool.addCookValue("city", "ALL", this.HttpResponse);
			}else{
				AreaInfo area=(AreaInfo) areaService.getObjById(id);
				CookTool.addCookValue("city", area.getId(), this.HttpResponse);
				if(area!=null&&area.getIsDefault().equals("1")){
					Cookie ck=new Cookie(Context.COOKIE_AEAR_ID,area.getId());
					ck.setPath("/");
					ck.setMaxAge(365*24*60*60*1000);
					this.HttpResponse.addCookie(ck);
					this.HttpRequest.getSession().setAttribute(Context.SESSION_AEAR, area);
					this.putData("json", "{\"status\":1}");
				}else{
					this.putData("json", "{\"status\":0}");
				}
			}
			this.setPageName("json.html");
		}else if(action!=null&&action.equals("getArea")){
			String parentId=(String) pamtr.get("parentId");
			if(parentId!=null&&parentId.length()>0){
				List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
				this.putData("json", ResponseUtil.getJson(list).toString());
			}else{
				List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id is null "));
				this.putData("json", ResponseUtil.getJson(list).toString());
			}
			this.setPageName("json.html");
		}else{
			Object arear=areaService.getDefaultArea(this.HttpRequest, this.HttpResponse);
			if(arear!=null){
				this.putData("area", arear);
			}else{
				this.putData("areaName", "全国");
			}
			List list=areaService.getListByWhere(new StringBuffer(" and n.isDefault='1' "));
			this.putData("data", list);
		}
	}

}
