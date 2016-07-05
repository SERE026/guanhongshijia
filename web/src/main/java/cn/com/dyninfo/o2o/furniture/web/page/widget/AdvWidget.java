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

package cn.com.dyninfo.o2o.furniture.web.page.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvService;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;

@Component("adv")
@Scope("prototype")
public class AdvWidget extends Widget {

	@Resource
	private AdvService advService;
	
	@Resource
	private AreaService areaService;
	
	@Resource
	private AdvwzService advwzService;
	@Override
	public void display(Map pamtr) {
		AreaInfo area=(AreaInfo) areaService.getDefaultArea(this.HttpRequest, this.HttpResponse);
		String id=(String) pamtr.get("id");
		String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		List list=advService.getListByWhere(new StringBuffer(" and n.adv_starttime<='"+time+"' and n.adv_endtime>='"+time+"' and n.advwz.advwz_id="+id +(area!=null?" and n.area.id='"+area.getId()+"' order by n.orderIndex asc":" and n.area.id is null order by n.orderIndex asc")));
	//	System.out.println(" and n.adv_starttime<='"+time+"' and n.adv_endtime>='"+time+"' and n.advwz.advwz_id="+id +(area!=null?" and n.area.id='"+area.getId()+"' order by n.orderIndex asc":"and n.area.id is null order by n.orderIndex asc"));
		putData("data", list);
		
		Advwz info=(Advwz) advwzService.getObjById(id);
//		System.out.println("广告！:"+id);
		this.putData("info", info);
		if(info!=null){
		if(info.getAdvwz_type().equals("2")){
			this.putData("isBtn", pamtr.get("isBtn"));
			this.setPageName("slide.html");
		}else if(info.getAdvwz_type().equals("1")){
			this.setPageName("pic.html");
		}else if(info.getAdvwz_type().equals("0")){
			this.setPageName("flash.html");
		}
		
	}}

}
