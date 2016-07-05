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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;

/**
 * 列表页面显示类别属性
 * @author 王敏
 *
 */
@Component("good_spec")
public class GoodListSpecWidget extends Widget {

	@Resource
	private GoodsSortService goodsSortService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private BrandService brandService;
	@Override
	public void display(Map pamtr) {
		String sortId=getGoodSort(); 
		String brandId=this.HttpRequest.getParameter("brandId");
		GoodsSort sort=(GoodsSort) goodsSortService.getObjById(sortId);
		if(brandId!=null){
			Brand brand=(Brand) brandService.getObjById(brandId);
			this.putData("brand",brand);
		}
		AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		String sql="";
		
		if(area!=null){
			sql+=" and s.CITY_ID='"+area.getId()+"' ";
			
			
		} 
		sql+=" and g.GOODSSORT_ID like '"+sort.getGoodsSort_id()+"%' ";
		if(sort.getType()!=null){
			this.putData("data", goodsService.getGoodSpecNum(""+sort.getType().getGoodsType_id(), sql));
		}else{
			this.putData("data", new ArrayList());
		}
		
		
		this.putData("brandList", goodsService.getGoodBranNum(sql ));
		
		
//		this.putData("priceList", goodsService.getGoodPriceRange(sql ));
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
