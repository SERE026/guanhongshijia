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

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.service.BrandOrderService;

/**
 * 获取品牌列表
 * @author 王敏
 *
 */
@Component("brand_Widget")
public class BrandWidget extends Widget {

	
	@Resource
	private BrandOrderService brandOrderService;
	
	@Override
	public void display(Map pamtr) {
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		StringBuffer where=new StringBuffer();
		if(arear!=null){
			where.append(" and n.city.id='"+arear.getId()+"' ");
		}else{
			where.append(" and n.city.id is null ");
		}
		List list=brandOrderService.getListByWhere(where);
		this.putData("data", list);
	}

}
