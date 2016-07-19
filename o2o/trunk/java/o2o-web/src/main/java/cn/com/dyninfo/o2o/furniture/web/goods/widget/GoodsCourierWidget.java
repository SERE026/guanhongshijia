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

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsDeliveryService;

import cn.com.dyninfo.o2o.furniture.util.CityTool;
@Component
public class GoodsCourierWidget extends AbstractGoodsWidget {

	@Resource
	private AreaService areaService;
	
	@Resource
	private GoodsDeliveryService goodsDeliveryService;
//	@Autowired
//	public GoodsCourierWidget(ItemGoodsWidget itemGoods){
//		this.addWidget(itemGoods);
//		
//	}
	@Override
	public String getWidgetId() {
		return "courier";
	}
	
	@Override
	public void display(Map pamtr) {
		double courierMoney=999999.0;
		String cityId=CityTool.getClientCityId(this.HttpRequest);
		AreaInfo area=null;
		if(cityId==null||cityId.length()==0){
			area=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			if(area!=null)
				area=(AreaInfo) areaService.getObjById(area.getId());
		}else{
			area=(AreaInfo) areaService.getObjById(cityId);
		}
		if(area!=null){
			Goods good=(Goods) pamtr.get("good");
			this.putData("good", good);
			Double money=goodsDeliveryService.getGoodsDeliveryMoney(good.getGoods_id(), area.getId());
			this.putData("area", area);
			this.putData("areaName", getareaName(area));
			if(money!=null){
				this.putData("money", money);
			}else{
				this.setPageName("GoodsCourierWidgetNo.html");
			}
			if(good.getMerchants().getCity()!=null)
				this.putData("mjareaName", getareaName(good.getMerchants().getCity()));
			else
				this.putData("mjareaName", "");
		}else{
			this.setPageName("nullarea.html");
		}
	}

	public String getareaName(AreaInfo area){
		String result=area.getName();
		if(area.getParent()!=null){
			result=getareaName(area.getParent())+result;
		}
		return result;
	}
}
