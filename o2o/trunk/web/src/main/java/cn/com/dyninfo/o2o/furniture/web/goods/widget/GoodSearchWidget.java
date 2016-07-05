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
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;

@Component("good_search")
public class GoodSearchWidget extends Widget {

	@Resource
	private GoodsService goodsService;
	
	@Resource
	private PagModInGoodsService pagModInGoodsService;
	
	@Override
	public void display(Map pamtr) {
		
		String action=(String) pamtr.get("action");
		if(action.equals("init")){
			AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			String sql="";
			
			if(area!=null){
				sql+=" and s.CITY_ID='"+area.getId()+"' ";
				
			}
			
			String key=(String) pamtr.get("key");
			List pricelist=goodsService.getGoodPriceRange(" and g.NAME like '%"+key+"%' "+sql);//价格区间
			List brandlist=goodsService.getGoodBranNum(" and g.NAME like '%"+key+"%' "+sql);//品牌区间
			List Sortlist=goodsService.getGoodSortNum(" and g.NAME like '%"+key+"%' "+sql);//价格区间
			this.putData("pricelist", pricelist);
			this.putData("brandlist", brandlist);
			this.putData("Sortlist", Sortlist);
			this.putData("serchName", key);
			this.setPageName("GoodSearch.html");
		}else if(action.equals("dataTotal")){
			String sql="";
			String moneysql="";
			String key=(String) pamtr.get("key");
			//String price=(String) pamtr.get("priceRange");
			String price1=(String) pamtr.get("price1");
			String price2=(String) pamtr.get("price2");
			String brand=(String) pamtr.get("brand");
			String Sort=(String) pamtr.get("Sort");
			String countyId=(String) pamtr.get("countyId");//区县
			String cityId=(String) pamtr.get("cityId");//城市
			String provinceId=(String) pamtr.get("provinceId");//省
			if(provinceId!=null&&provinceId.length()>0){
				sql+=" and s.PROVINCE_ID='"+provinceId+"'";
			}
			if(cityId!=null&&cityId.length()>0){
				sql+=" and s.CITY_ID='"+cityId+"'";
			}
			if(countyId!=null&&countyId.length()>0){
				sql+=" and s.COUNT_ID='"+countyId+"'";
			}
			if(key!=null&&key.length()>0){
				sql+=" and g.NAME like '%"+key+"%'";
			}
//			if(price!=null&&price.length()>0){
//				sql+=" and g.PRICE_RANGE = '"+price+"'";
//			}
			if(price1!=null&&price1.length()>0){
				moneysql+=" and money>="+price1;
			}
			if(price2!=null&&price2.length()>0){
				moneysql+=" and money<="+price2;
			}
			if(brand!=null&&brand.length()>0){
				sql+=" and g.BRAND_ID = '"+brand+"'";
			}
			if(Sort!=null&&Sort.length()>0){
				sql+=" and g.GOODSSORT_ID = '"+Sort+"'";
			}
			if(provinceId==null&&cityId==null){
				AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
				if(area!=null){
					sql+=" and s.CITY_ID='"+area.getId()+"' ";
					
				}
			}
			
			
			int count=pagModInGoodsService.getGoodByWhereCount(sql,moneysql);
			String json="{\"total\":"+count+"}";
			ResponseUtil.printl(this.HttpResponse, json, "json");
			this.setFreeMaker(false);
		}else if(action.equals("data")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			String orderName=(String) pamtr.get("orderName");
			String by=(String) pamtr.get("by");
			String sql="";
			String moneysql="";
			String key=(String) pamtr.get("key");
			//String price=(String) pamtr.get("priceRange");
			String brand=(String) pamtr.get("brand");
			String Sort=(String) pamtr.get("Sort");
			String countyId=(String) pamtr.get("countyId");//区县
			String cityId=(String) pamtr.get("cityId");//城市
			String provinceId=(String) pamtr.get("provinceId");//省
			String price1=(String) pamtr.get("price1");
			String price2=(String) pamtr.get("price2");
			if(provinceId!=null&&provinceId.length()>0){
				sql+=" and s.PROVINCE_ID="+provinceId;
			}
			if(cityId!=null&&cityId.length()>0){
				sql+=" and s.CITY_ID="+cityId;
			}
			if(countyId!=null&&countyId.length()>0){
				sql+=" and s.COUNT_ID="+countyId;
			}
			if(key!=null&&key.length()>0){
				sql+=" and g.NAME like '%"+key+"%'";
			}
//			if(price!=null&&price.length()>0){
//				sql+=" and g.PRICE_RANGE = '"+price+"'";
//			}
			
			if(price1!=null&&price1.length()>0){
				moneysql+=" and money>="+price1;
			}
			if(price2!=null&&price2.length()>0){
				moneysql+=" and money<="+price2;
			}
			if(brand!=null&&brand.length()>0){
				sql+=" and g.BRAND_ID = '"+brand+"'";
			}
			if(Sort!=null&&Sort.length()>0){
				sql+=" and g.GOODSSORT_ID = '"+Sort+"'";
			}
			if(provinceId==null&&cityId==null){
				AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
				if(area!=null){
					sql+=" and s.CITY_ID='"+area.getId()+"' ";
					
				}
			}
			PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			String oderBy=null;
			if(orderName!=null&&orderName.length()>0&&by!=null&&by.length()>0)
				oderBy=by;
			List list=pagModInGoodsService.getGoodBywhere( sql,moneysql, page, oderBy,"40");
			this.putData("data", list);
			this.setPageName("GoodSearchList.html");
		}
	}

}
