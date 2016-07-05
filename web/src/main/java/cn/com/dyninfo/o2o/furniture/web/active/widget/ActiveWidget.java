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

package cn.com.dyninfo.o2o.furniture.web.active.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Advwz;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvService;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvwzService;

@Component("active")
public class ActiveWidget extends Widget {

	@Resource
    private PagModInGoodsService pagModInGoodsService;
	@Resource
	private AdvService advService;
	
	@Resource
	private AreaService areaService;
	
	@Resource
	private AdvwzService advwzService;
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		PageInfo page=new PageInfo();
		
		if(action==null){
			
			String id=(String) pamtr.get("id");
			String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			List list=advService.getListByWhere(new StringBuffer(" and n.adv_starttime<='"+time+"' and n.adv_endtime>='"+time+"' and n.advwz.advwz_id=61" +(arear!=null?" and n.area.id='"+arear.getId()+"' order by n.orderIndex asc":" and n.area.id is null order by n.orderIndex asc")));
			putData("data", list);
			
			Advwz info=(Advwz) advwzService.getObjById("61");
			this.putData("info", info);
			
			page.setPageNo(1);
			page.setPageSize(3);
			
			Map map=pagModInGoodsService.getActGood(36, (arear!=null?arear.getId():null), null, page, null);
			this.putData("topList", map.get("data"));
			
		}else if(action.equals("actdata")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=pagModInGoodsService.getActGood(37, (arear!=null?arear.getId():null), null, page, null);
			List list=(List) map.get("data");
			for(int i=0;i<list.size();i++){
				Map m=(Map) list.get(i);
				m.remove("description2");
				m.remove("description");
			}
			String json=json=ResponseUtil.getJsonListMap(list).toString();
			this.putData("json", json);
			this.setPageName("json.html");
		}else if(action.equals("acttotal")){
			page.setPageNo(1);
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=pagModInGoodsService.getActGood(37, (arear!=null?arear.getId():null), null, page, null);
			int num=(Integer) map.get("num");
			String json="{\"total\":"+num+"}";
			this.putData("json", json);
			this.setPageName("json.html");
		}
	}

}
