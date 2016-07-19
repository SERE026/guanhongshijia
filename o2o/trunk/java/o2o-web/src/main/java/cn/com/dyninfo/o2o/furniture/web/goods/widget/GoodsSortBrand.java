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

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;


import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.BrandOrder;
import cn.com.dyninfo.o2o.old.model.GoodsSort;
import cn.com.dyninfo.o2o.old.service.BrandOrderService;
import cn.com.dyninfo.o2o.old.service.BrandService;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.GoodsSortService;

@Component("goodsSortBrand")
public class GoodsSortBrand extends Widget {

	@Resource
	private GoodsSortService goodsSortService;

	@Resource
	private BrandService brandService;

	@Resource
	private GoodsService goodsService;
	

	@Resource
	private BrandOrderService brandOrderService;

	@Override
	public void display(Map pamtr) {
		if (pamtr.get("action") != null && pamtr.get("action").equals("brand")) {
			
			String pageNo=(String) pamtr.get("pageNo");
			
			PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(23);
			
			AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			StringBuffer where=new StringBuffer();
			if(arear!=null){
				where.append(" and n.city.id='"+arear.getId()+"' ");
			}else{
				where.append(" and n.city.id is null ");
			}
			
			Map map=  brandOrderService.getListByPageWhere(new StringBuffer(where),page);
			String jsondata = "";
			
			
			List<BrandOrder> brand=(List<BrandOrder>) map.get("DATA");
			for (int i = 0; i < brand.size(); i++) {
				BrandOrder g = brand.get(i);
				jsondata += "{\"brand_id\":\"" + g.getBrand().getBrand_id() + "\",";
				jsondata += "\"logo\":\"" + g.getBrand().getLogo() + "\"},";
			}
			if (jsondata.length() > 0)
				jsondata = jsondata.substring(0, jsondata.length() - 1);
			String json = "{\"data\":[" + jsondata + "]}";
			this.putData("json", json);
			this.setPageName("goodsSortBrand.html");
		}
		AreaInfo area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		if (pamtr.get("action") != null && pamtr.get("action").equals("sort")) {
			String id = (String) pamtr.get("id");
			List<GoodsSort> goods = (List<GoodsSort>) goodsSortService
					.getListByWhere(new StringBuffer(
							" and n.parent.goodsSort_id ='" + id
									+ "' and n.status=0 and n.flag=0 "));
			String jsondata = "";
			for (int i = 0; i < goods.size(); i++) {
				GoodsSort g = goods.get(i);
				StringBuffer where = new StringBuffer();
				where.append(" and a.GOODSSORT_ID like '" +g.getGoodsSort_id()+ "%'  ");
				if(area!=null){
					where.append(" and s.CITY_ID='"+area.getId()+"' ");
				} 
				HashMap map = goodsService.getGoodsBrand(where);
				List list = (List) map.get("DATA");
				jsondata += "{\"sortName\":\"" + g.getName() + "\",";
				jsondata += "\"goodsId\":\"" + g.getGoodsSort_id()+ "\",";
				if (goods.get(i).getChildren() != null) {
					String jsons="";
					for (int h = 0; h < goods.get(i).getChildren().size(); h++) {
						if (g.getChildren().get(h) != null) {
							 jsons+="{\"sort_id\":\""
									+ goods.get(i).getChildren().get(h).getGoodsSort_id()
									+ "\",";
							 jsons += "\"sname\":\""
									+ goods.get(i).getChildren().get(h).getName() + "\"},";
						}
					}
					if (jsons.length() > 0)
						jsons = jsons.substring(0, jsons.length() - 1);
					        jsondata+="\"one\":["+jsons+"],";
				}
				if (list.size() > 0) {
					String jsonm="";
					for (int k = 0; k < list.size(); k++) {
						Map maps = (Map) list.get(k);
							if (maps.get("id") != null) {
								jsonm +="{\"goods_id\":\""
										+ maps.get("gid").toString() + "\",";
							}
							if (maps.get("id") != null) {
								jsonm += "\"brand_id\":\""
										+ maps.get("id").toString() + "\",";
							}
							if (maps.get("name") != null) {
								jsonm += "\"name\":\""
										+ maps.get("name").toString() + "\"},";
							}
					  }
					if (jsonm.length() > 0)
						jsonm = jsonm.substring(0, jsonm.length() - 1);
					 jsondata+="\"two\":["+jsonm+"],";
				   }
				if (jsondata.length() > 0)
					jsondata = jsondata.substring(0, jsondata.length() - 1);
				jsondata += "},";
			}
			if (jsondata.length() > 0)
				jsondata = jsondata.substring(0, jsondata.length() - 1);
			String json = "{\"data\":[" + jsondata + "]}";
			this.putData("json", json);
			this.setPageName("goodsSortBrand.html");
		}
	}

}
