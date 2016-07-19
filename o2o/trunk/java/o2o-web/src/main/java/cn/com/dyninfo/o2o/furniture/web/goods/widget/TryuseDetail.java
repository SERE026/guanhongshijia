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

import java.util.Date;
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
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.service.TryuseApplyService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;

@Component("tryuseDetail")
public class TryuseDetail extends Widget {
	@Resource
	private GoodsService goodsService;
	  @Resource
	     private TryuseApplyService tryuseApplyService;
		@Resource
	    private PagModInGoodsService pagModInGoodsService;
	@Override
	public void display(Map pamtr) {
		PageInfo page=new PageInfo();
		String action=(String) pamtr.get("action");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		String type=(String) pamtr.get("type");
		String goodsid=(String) pamtr.get("goodsid");
		if(goodsid!=null){
			session.setAttribute("goodsid", goodsid);
		}
		if(type==null){
			if(action==null){
					Goods goods=(Goods) goodsService.getObjById(goodsid);
					String date=goods.getEtime()+" 00:00:00";;
					int t=(int)(new Date().getTime()/1000);
					String etime=getTime(Context.parseTime(date)-t);
					date=goods.getBtime()+" 00:00:00";;
					String btime=getTime(Context.parseTime(date)-t);
					this.putData("btime", btime);
					this.putData("etime", etime);
					this.putData("goods", goods);
					this.putData("goodsid", goodsid);
		
			}else if(action.equals("getData")){
				String pageNo=(String) pamtr.get("pageNo");
				String pageSize=(String) pamtr.get("pageSize");
				page.setPageNo(Integer.parseInt(pageNo));
				page.setPageSize(Integer.parseInt(pageSize));
				goodsid=(String) session.getAttribute("goodsid");
				Map map=tryuseApplyService.getListByPageWhere(new StringBuffer(" and n.applytype='1' and n.goods.goods_id="+goodsid), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("Tryusesay2.html");
			}else if(action.equals("getTotale")){
				page.setPageNo(1);
				page.setPageSize(10);
				StringBuffer where = new StringBuffer();
				goodsid=(String) session.getAttribute("goodsid");
				where=new StringBuffer(" and n.applytype='1' and n.goods.goods_id="+goodsid);
				int count=tryuseApplyService.getCountByWhere(where);
				this.putData("json","{\"total\":"+count+"}");
				this.setPageName("json.html");
			}
			
		}else if(type.equals("1")){
			Map map=new HashMap();
			map.put("sytime", "1");
			page.setPageNo(1);
			page.setPageSize(5);
			List<Goods> trylist=pagModInGoodsService.getGoods(53, area!=null?area.getId():null, 102, page, map);
			this.putData("newtryuse", trylist);
			this.setPageName("Newtryuse.html");
		}else if(type.equals("2")){
			this.setPageName("Tryusesay.html");
		}
		
	}
	private String getTime(int t){
		int h=t/3600;
		int m=t%3600/60;
		int s=t%3600%60;
		String time=""+(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		if(h<0){
			time="0";
		}
		return time;
	}
}