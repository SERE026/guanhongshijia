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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;

@Component("xuangoodsWidget")
@Scope("prototype")
public class XuanGoodWidget extends Widget {
	@Resource
    private PagModInGoodsService pagModInGoodsService;
	@Override
	public void display(Map pamtr) {
		this.setPageName("goodsJson.html");
		String id=(String) pamtr.get("id");
		String size=(String) pamtr.get("pageSize");
		String no=(String) pamtr.get("pageNo");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(no));
		page.setPageSize(Integer.parseInt(size));
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
//		System.out.println(id);
		
		List<Goods> data=pagModInGoodsService.getGoods(Integer.parseInt(id), arear!=null?arear.getId():null, 102, page, null);
		
		List list=new ArrayList();
		String jsondata="";
		for(int i=0;i<data.size();i++){
			Goods g=data.get(i);
			jsondata+="{\"goods_id\":\""+g.getGoods_id()+"\",";
			jsondata+="\"name\":\""+g.getName()+"\",";
			jsondata+="\"salesMoney\":"+g.getSalesMoney()+",";
			jsondata+="\"bazaarMoney\":"+g.getBazaarMoney()+",";
			jsondata+="\"discount\":"+g.getDiscount()+",";
			jsondata+="\"defaultImage\":\""+g.getDefaultImage()+"\"},";
		}
		if(jsondata.length()>0)
			jsondata=jsondata.substring(0,jsondata.length()-1);
		String json="{\"data\":["+jsondata+"],\"page\":"+ResponseUtil.getObjeJson(page)+"}";
		this.setFreeMaker(false);
		ResponseUtil.printl(this.HttpResponse,json,"json");
		
	}

}
