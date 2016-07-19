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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.GoodsSortService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;

@Component("tryuseAgo")
public class TryuseAgo extends Widget {
	@Resource
	private GoodsService goodsService;
	 @Resource
     private GoodsSortService goodsSortService;
	@Resource
	 private PagModInGoodsService pagModInGoodsService;
	
	@Override
	public void display(Map pamtr) {
		   PageInfo page=new PageInfo();
		   AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			String action=(String) pamtr.get("action");
			HttpSession session=HttpRequest.getSession();
			HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(action==null){
			
		}else if(action.equals("page")){
			List list=goodsSortService.getTryGoodsort();
			this.putData("sortlist", list);
			this.setPageName("TryuseagoTou.html");
		}else if(action.equals("getData")){
			Map map=new HashMap();
			String goodssort=(String) pamtr.get("goodssort");
			map.put("sytime", "3");
			map.put("goodssort", goodssort);
			page.setPageNo(1);
			page.setPageSize(30);
			List<Goods> trylist=pagModInGoodsService.getGoods(53, area!=null?area.getId():null, 102, page, map);
			this.putData("data",trylist);
			this.setPageName("TryuseAgo2.html");
		}else if(action.equals("getTotale")){
			Map map=new HashMap();
			String goodssort=(String) pamtr.get("goodssort");
			map.put("sytime", "3");
			map.put("goodssort", goodssort);
			int count=pagModInGoodsService.getTrysortcout(53, area!=null?area.getId():null, 102, page, map);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}else if(action.equals("del")){
			String id=(String) pamtr.get("id");
			goodsService.delObjById(id);
			this.putData("data", "1");
			this.setPageName("register.html");
		}
	}
	}