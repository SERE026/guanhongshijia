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

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
/**
 * 商品列表的同类商品
 * @author Administrator
 *
 */
@Component("list_sort")
public class GoodListSortGoodWidget extends Widget {

	@Resource
	private PagModInGoodsService pagModInGoodsService;
	@Override
	public void display(Map pamtr) {
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		String modulId=(String) pamtr.get("modulId");
		String sortId=getGoodSort();
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(4);
		Map map=new HashMap();
		map.put("goodSort_id", sortId);
		
		if(modulId.equals("33")){//同类热销 4个产品
			int count=pagModInGoodsService.getGoodSortCount(sortId,arear!=null?arear.getId():null);//供销售
			List data=pagModInGoodsService.getGoods(Integer.parseInt(modulId), arear!=null?arear.getId():null, 0, page, map);
			if(count==0)
				count=1;
			this.putData("count", count);
			this.putData("data", data);
		}else if(modulId.equals("34")){
			Calendar c=Calendar.getInstance();
			c.add(Calendar.DATE, -5);
			long t=c.getTimeInMillis()/1000;
			int count=pagModInGoodsService.getGoodSortCount(sortId, (int)t, arear!=null?arear.getId():null);
			map.put("t", ""+t);
			if(count==0)
				count=1;
			List data=pagModInGoodsService.getGoodsSales(Integer.parseInt(modulId), arear!=null?arear.getId():null, 102, page, map);
			this.putData("count", count);
			this.putData("data", data);
		}
		
	}
	private String getGoodSort(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		
		return null;
	}
}
