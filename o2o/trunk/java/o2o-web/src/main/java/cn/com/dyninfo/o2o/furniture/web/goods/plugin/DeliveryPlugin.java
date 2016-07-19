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

package cn.com.dyninfo.o2o.furniture.web.goods.plugin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.model.GoodsDelivery;
import cn.com.dyninfo.o2o.old.service.GoodsDeliveryService;
import cn.com.dyninfo.o2o.old.model.Dlytype;
import cn.com.dyninfo.o2o.old.service.DlytypeService;

@Component
public class DeliveryPlugin extends AbstractGoodsPlugin {
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private DlytypeService dlytypeService;
	@Resource
	private GoodsDeliveryService goodsDeliveryService;
	@Autowired
	public DeliveryPlugin(GoodsPlugin goodsPlugin){
		addPlugin(goodsPlugin);
	}
	@Override
	public void addGoodsAfter(Goods goods) {
		GoodsDelivery gd=new GoodsDelivery();
		gd.setDelivery(request.getParameter("delivery_x"));
		gd.setDeliveryFlag(request.getParameter("deliveryFlag"));
		gd.setDeliveryMoney(Double.parseDouble(request.getParameter("deliveryMoney")));
		String dlyIds[]=request.getParameterValues("dlyIds");
		if(dlyIds!=null){
			List list=new ArrayList();
			for(String dlyId:dlyIds){
				if(dlyId.length()>0){
					Dlytype dt=(Dlytype) dlytypeService.getObjById(dlyId);
					if(dt!=null)
						list.add(dt);
				}
			}
			gd.setDlyList(list);
		}
		gd.setGoods(goods);
		goodsDeliveryService.addObj(gd);
	}

	@Override
	public void addGoosBefor(Goods goods) {
		
	}

	@Override
	public void editGoodsAfter(Goods goods) {
		List DeliveryList=goodsDeliveryService.getListByWhere(new StringBuffer (" and n.goods.goods_id="+goods.getGoods_id()));
		GoodsDelivery gd=new GoodsDelivery();
		if(DeliveryList.size()>0)
			gd=(GoodsDelivery) DeliveryList.get(0);
		gd.setDelivery(request.getParameter("delivery_x"));
		gd.setDeliveryFlag(request.getParameter("deliveryFlag"));
		if(request.getParameter("deliveryMoney") != null)
			gd.setDeliveryMoney(Double.parseDouble(request.getParameter("deliveryMoney")));
		else
			gd.setDeliveryMoney(0.0);
		String dlyIds[]=request.getParameterValues("dlyIds");
		if(dlyIds!=null){
			List list=new ArrayList();
			for(String dlyId:dlyIds){
				if(dlyId.length()>0){
					Dlytype dt=(Dlytype) dlytypeService.getObjById(dlyId);
					if(dt!=null)
						list.add(dt);
				}
			}
			gd.setDlyList(list);
		}
		gd.setGoods(goods);
		if(DeliveryList.size()>0)
			goodsDeliveryService.updateObj(gd);
		else
			goodsDeliveryService.addObj(gd);
	}

	@Override
	public void editGoosBefor(Goods goods) {

	}

	@Override
	public String getName() {
		return "产品配送方式插件";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

}
