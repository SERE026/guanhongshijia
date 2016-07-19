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

package cn.com.dyninfo.o2o.old.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.dao.DiscountActiveDAO;
import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.service.DiscountActiveService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.MessageSend;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;

@Service("discountActiveService")
public class DiscountActiveServiceImpl extends BaseService implements
		DiscountActiveService {

	@Resource
	private DiscountActiveDAO discountActiveDAO;
	
	@Resource
	private DiscountActiveService discountActiveService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private FavoritesService favoritesService;
	
	
	@Resource
	private MessageSendService messageSendService;

	@Override
	public void initDao() {
		super.initDao();
		this.baseDao=discountActiveDAO;
	}

	@Override
	public void delObjStatusById(String id) {
		Active da=(Active) this.getObjById(id);
		da.setStatus(1);
		this.updateObj(da);
	}

	@Override
	public HashMap<String, ?> getGoodListByPageWhere(StringBuffer where,
			PageInfo page) {
		// TODO Auto-generated method stub
		return discountActiveDAO.getGoodListByPageWhere(where, page);
	}

	@Override
	public List getGoodListByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return discountActiveDAO.getGoodListByWhere(where);
	}

	@Override
	public void addLink(List<Map> list) {
		discountActiveDAO.addLink(list);
		
	}

	@Override
	public void delLink(String actId, String goodId) {
		discountActiveDAO.delLink(actId, goodId);
		
	}

	@Override
	public Active getActiveByGoods(Goods goods) {
		// TODO Auto-generated method stub
		return discountActiveDAO.getActiveByGoods(goods);
	}

	@Override
	public void updateActive(HttpServletRequest request, String id) {
		 Active active=(Active) discountActiveService.getObjById(id);
		 String[] goods_id=request.getParameterValues("goods_id");
		 int count=0;
		 List list=new ArrayList();
		 if(goods_id !=null){
			 for(int i=0;i<goods_id.length;i++){
				 Map map=new HashMap();
				 map.put("goodID", goods_id[i]);
				 map.put("actID", id);
	             list.add(map);
	             count++;
	             
	             Goods goods = (Goods) goodsService.getObjById(goods_id[i]);
				 MessageSend info=new MessageSend();
				 info.setGoods(goods);
				 info.setActive(active);
				 info.setTitle("打折信息");
				 info.setContext("您收藏的商品"+goods.getName()+"开始打折了优惠喽！");
				 info.setUid("");
				 List falist=favoritesService.getListByWhere(new StringBuffer(" and n.good.goods_id="+goods.getGoods_id()));
				 messageSendService.addObj(info);
				 
			 }
		 }
		 active.setCount(count);
		 discountActiveService.updateObj(active);
		 discountActiveService.addLink(list);
	}

	@Override
	public void updateActiveGoodsIndex(Active act) {
		discountActiveDAO.delActiveGoods(""+act.getActive_id());
		discountActiveDAO.updateObj(act);
	}

	@Override
	public List getActGoodsByList(StringBuffer where, PageInfo page) {
		return discountActiveDAO.getActGoodsByList(where, page);
	}

	@Override
	public int getActGoodsCount(StringBuffer where) {
		return discountActiveDAO.getActGoodsCount(where);
	}
	
}
