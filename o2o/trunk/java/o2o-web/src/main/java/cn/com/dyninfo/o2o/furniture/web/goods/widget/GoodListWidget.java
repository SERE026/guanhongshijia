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

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;

/**
 * 商品列表
 * @author Administrator
 *
 */
@Component("good_list")
public class GoodListWidget extends Widget {

	@Resource
	private PagModInGoodsService pagModInGoodsService;
	
	
	@Override
	public void display(Map pamtr) {
		
		String action=(String) pamtr.get("action");
		String goodSort=(String) pamtr.get("goodSort");//商品类型
		String countyId=(String) pamtr.get("countyId");//区县
		String cityId=(String) pamtr.get("cityId");//城市
		String provinceId=(String) pamtr.get("provinceId");//省
		String brand=(String) pamtr.get("brand");// 品牌
		String orderName=(String) pamtr.get("orderName");//排序
		String by=(String) pamtr.get("by");//排序
		String parameters[]=this.HttpRequest.getParameterValues("parameter");
		String priceRange=(String) pamtr.get("priceRange");// 价格区间
		String pageNo=(String) pamtr.get("pageNo");
		String pageSize=(String) pamtr.get("pageSize");
		String slq="";
		String moneysql="";
		if(brand!=null&&brand.length()>0){
			slq+=" and g.BRAND_ID="+brand;
		}
//		if(priceRange!=null&&priceRange.length()>0){
//			slq+=" and g.PRICE_RANGE='"+priceRange+"' ";
//		}
		String price1=(String) pamtr.get("price1");
		String price2=(String) pamtr.get("price2");
		if(provinceId!=null&&provinceId.length()>0){
			slq+=" and s.PROVINCE_ID="+provinceId;
		}
		if(cityId!=null&&cityId.length()>0){
			slq+=" and s.CITY_ID="+cityId;
		}
		if(countyId!=null&&countyId.length()>0){
			slq+=" and s.COUNT_ID="+countyId;
		}
		
		if(price1!=null&&price1.length()>0){
			moneysql+=" and money>="+price1;
		}
		if(price2!=null&&price2.length()>0){
			moneysql+=" and money<="+price2;
		}
		if(parameters!=null){
			for(String parameter:parameters){
				String ps[]=parameter.split(":");
				slq+=" and g.SPEC_VALUE_"+ps[0]+"='"+ps[1]+"' ";
				
			}
		}
		if(orderName!=null&&orderName.length()>0){
			
		}
		if(action.equals("dataTotal")){
			
			int count=pagModInGoodsService.getGoodBySlqCount(goodSort, slq,moneysql);
			this.putData("json", "{\"total\":"+count+"}");
			this.setPageName("GoodListWidgetJson.html");
		}else if(action.equals("data")){
			
			PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			String oderBy=null;
			if(orderName!=null&&orderName.length()>0&&by!=null&&by.length()>0)
				oderBy=by;
			List list=pagModInGoodsService.getGoodBySlqCount(goodSort, slq,moneysql, page, oderBy,"35");
			this.putData("data", list);
			
		}
		
		
	}
	

}
