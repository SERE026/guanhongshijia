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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;

@Component("tryuseWidget")
public class TryuseWidget extends Widget {
	@Resource
	private GoodsService goodsService;
	
	@Resource
    private PagModInGoodsService pagModInGoodsService;
	
	@Override
	public void display(Map pamtr) {
		String type=(String) pamtr.get("type");
		AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		PageInfo page=new PageInfo();
		
		if(type.equals("1")){
			Map map=new HashMap();
			map.put("sytime", "1");
			page.setPageNo(1);
			page.setPageSize(10);
			List<Goods> trylist=pagModInGoodsService.getGoods(53, area!=null?area.getId():null, 102, page, map);
			
			List<Map> list=new ArrayList();
			for(int i=0;i<trylist.size();i++){//设置倒记时间
				Map map1=new HashMap();
				Goods goods=trylist.get(i);
				String date=goods.getEtime()+" 00:00:00";;
				int t=(int)(new Date().getTime()/1000);
				String ctime=getTime(Context.parseTime(date)-t);
				map1.put("ctime", ctime);
				map1.put("goods", goods);
				list.add(map1);
			}
			this.putData("trylist", list);
		}else if(type.equals("2")){
			Map map=new HashMap();
			page.setPageNo(1);
			page.setPageSize(10);
			map.put("sytime", "2");
			List<Goods> trylist=pagModInGoodsService.getGoods(53, area!=null?area.getId():null, 102, page, map);
			this.putData("trylist", trylist);
			this.setPageName("Tryuseready.html");
		}
	}
	private String getTime(int t){
		int h=t/3600;
		int m=t%3600/60;
		int s=t%3600%60;
		String time=""+(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		return time;
	}
}