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

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.Favorites;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
@Component("favorites")
public class FavoritesWidget extends Widget {
	@Resource
	private FavoritesService favoritesService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private ShangJiaService shangJiaService;
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action==null)
			action="";
		if(action.equals("add")){
			String goodId=(String) pamtr.get("goodId");
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(member==null){
				this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, "item-"+goodId+".html");
				json="{\"status\":1,\"msg\":\"\",\"toPage\":\"login.html\"}";
			}else{
				int coutn=favoritesService.getCountByWhere(new StringBuffer(" and n.type=0 and n.member.huiYuan_id="+member.getHuiYuan_id()+" and n.good.goods_id="+goodId));
				if(coutn==0){
					Favorites f=new Favorites();
					Goods  good=(Goods) goodsService.getObjById(goodId);
					f.setGood(good);
					f.setType("0");
					f.setMember(member);
					f.setTime((int)(new Date().getTime()/1000));
					favoritesService.addObj(f);
				}
				json="{\"status\":0,\"msg\":\"\",\"toPage\":\"login.html\"}";
			}
			this.putData("json", json);
		}else if(action.equals("add_m")){
			String merchantId=(String) pamtr.get("merchantId");
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(member==null){
				String url=this.HttpRequest.getServletPath();
				url=url.substring(url.lastIndexOf("/")+1);
				this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, url);
				json="{\"status\":1,\"msg\":\"\",\"toPage\":\"login.html\"}";
			}else{
				int coutn=favoritesService.getCountByWhere(new StringBuffer(" and n.type=1 and n.member.huiYuan_id="+member.getHuiYuan_id()+" and n.merchant.shangjia_id="+merchantId));
				if(coutn==0){
					Favorites f=new Favorites();
					ShangJiaInfo  merchant=(ShangJiaInfo) shangJiaService.getObjById(merchantId);
					f.setMember(member);
					f.setType("1");
					f.setShangJiaInfo(merchant);
					f.setMerchant(merchant);
					f.setTime((int)new Date().getTime()/1000);
					favoritesService.addObj(f);
				}
				json="{\"status\":0,\"msg\":\"\",\"toPage\":\"login.html\"}";
			}
			this.putData("json", json);
		}

	}

}
