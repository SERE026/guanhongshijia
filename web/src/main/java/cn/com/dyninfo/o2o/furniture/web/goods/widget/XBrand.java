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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.BrandOrder;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandOrderService;

@Component("xbrand")
public class XBrand extends Widget {
	
	@Resource
	private BrandOrderService brandOrderService;
    
	@Override
	public void display(Map pamtr) {
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		PageInfo page=new PageInfo();
		String pageNo=(String) pamtr.get("pageNo");
		String pageSize=(String) pamtr.get("pageSize");
		if(pageNo==null||pageNo.length()==0){
			pageNo="1";
		}
		if(pageSize==null||pageSize.length()==0){
			pageSize="20";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(Integer.parseInt(pageSize));
		
		StringBuffer where=new StringBuffer();
		if(arear!=null){
			where.append(" and n.city.id='"+arear.getId()+"' ");
		}else{
			where.append(" and n.city.id is null ");
		}
		Map map=brandOrderService.getListByPageWhere(where, page);
		List<BrandOrder> data=(List) map.get("DATA");
		String json="{\"data\":[";
		for(BrandOrder info:data ){
			json+="{\"iamge\":\""+info.getBrand().getLogo()+"\",\"sid\":\""+info.getBrandMerchants().getShangjia_id()+"\"},";
		}
		if(json.charAt(json.length()-1)==','){
			json=json.substring(0,json.length()-1);
		}
		json+="],";
		json+="\"page\":{\"pageNo\":"+page.getPageNo()+",\"totalpage\":"+page.getTotalpage()+"}}";
		this.setFreeMaker(false);
		ResponseUtil.printl(this.HttpResponse,json,"json");
	}

}
