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


import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandOrderService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
@Component("goodsSortWidget")
public class GoodsSortWidget extends Widget {

	@Resource
	private GoodsSortService goodsSortService;
	@Resource
	private BrandOrderService brandOrderService;
	@Override
	public void display(Map pamtr) {
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		List list=goodsSortService.getListByWhere(new StringBuffer(" and n.parent.goodsSort_id is null and n.status=0 and n.flag=0"));
		this.putData("data", list);
		StringBuffer where=new StringBuffer();
		if(arear!=null){
			where.append(" and n.city.id='"+arear.getId()+"' ");
		}else{
			where.append(" and n.city.id is null ");
		}
		List brand=brandOrderService.getListByWhere(where);
		this.putData("brand", brand);
		if(pamtr.get("type").equals("index")){
			this.setPageName("indexType.html");
		}
	}

}
