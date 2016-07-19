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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.service.DiscountActiveService;
import cn.com.dyninfo.o2o.old.service.GameService;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component("actDetail")
public class ActDetailWidget extends Widget {

	@Resource
	private GameService gameService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private DiscountActiveService discountActiveService;
	
	@Resource
    private PagModInGoodsService pagModInGoodsService;
	@Override
	public void display(Map pamtr) {
		String actId=getActId();
		String goodId=getGoodId();
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		int t=(int)(new Date().getTime()/1000);
		if(gameService.checkActGood(actId, goodId)>0){
				Goods good=(Goods) goodsService.getObjById(goodId);
				PageInfo page=new PageInfo();
				page.setPageNo(1);
				page.setPageSize(5);
				Map map=pagModInGoodsService.getActGood(0,  (arear!=null?arear.getId():null), " and a.ACTIVE_ID="+actId+" and g.GOODS_ID="+goodId, page, null);
				
				Map sortMap=pagModInGoodsService.getActGood(38, (arear!=null?arear.getId():null), ""+good.getGoodsSort().getGoodsSort_id(), page);
				
				Map buymap=pagModInGoodsService.getBuyGood(39, (arear!=null?arear.getId():null), goodId, page);
				List data=(List) map.get("data");
				if(data.size()==0){
					this.setPageName("discountError.html");
					return ;
				}
				
				// 根据商品取得活动信息
				Active active = discountActiveService.getActiveByGoods(good);
				if (active != null) {
//					System.out.println(active.getPs());
					this.putData("active", active);
				}
				
				this.putData("sortList", sortMap.get("data"));
				this.putData("actGood", data.get(0));
				this.putData("buyList", buymap.get("data"));
				this.setPageName("discount.html");
		}else{
			this.setPageName("discountError.html");
		}
		
	}
	private String getTime(int t){
		int h=t/3600;
		int m=t%3600/60;
		int s=t%3600%60;
		String time=""+(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		return time;
	}
	
	private String getActId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0)
			url=url.substring(0,url.indexOf("?"));
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
//			System.out.println(m.group(1));
			return m.group(1);
		}
		return null;
	}
	
	private String getGoodId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0)
			url=url.substring(0,url.indexOf("?"));
		Pattern p=Pattern.compile("-([\\d]+)-([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find(1)){
			return m.group(2);
		}
		return null;
	}
}
