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


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.old.dao.GoodsDAO;
import cn.com.dyninfo.o2o.old.model.Goods;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.BaseService;
import cn.com.dyninfo.o2o.old.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl extends BaseService implements GoodsService{

	  @Resource
	  private GoodsDAO goodsDAO;
	       
	  @Override
	  public void initDao(){
	      super.initDao();
	      this.baseDao=goodsDAO;
	   }

		@Override
		public void updateGoodShelves(int id,String status) {
			goodsDAO.updateGoodShelves(id, status);
			
		}

		@Override
		public String getGoodsPrice(Goods good) {
			return goodsDAO.getGoodsPrice(good);
		}

		@Override
		public Goods getGoodsPrice(int goods_id) {
			Goods goods=(Goods) goodsDAO.getObjById(""+goods_id);
			if(goods!=null)
				goodsDAO.getGoodsPrice(goods);
			return goods;
		}

		@Override
		public Double getCouriter(String arearId, int goods_id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List getGoodsSpec(int goods_id, String specVal) {
			return goodsDAO.getGoodsSpec(goods_id, specVal);
		}

		@Override
		public List getGoodBranNum(String sql) {
			// TODO Auto-generated method stub
			return goodsDAO.getGoodBranNum(sql);
		}

		@Override
		public List getGoodPriceRange(String sql) {
			// TODO Auto-generated method stub
			return goodsDAO.getGoodPriceRange(sql);
		}

		@Override
		public List getGoodSpecNum(String typeId, String sql) {
			// TODO Auto-generated method stub
			return goodsDAO.getGoodSpecNum(typeId, sql);
		}

		@Override
		public List getGoodSortNum(String sql) {
			return goodsDAO.getGoodSortNum(sql);
		}

		@Override
		public HashMap<String,?> getGoodsBrand(StringBuffer where) {
			return goodsDAO.getGoodsBrand(where);
		}

		@Override
		public Object getObjById(String goods_id, String merchant_id) {
			// TODO Auto-generated method stub
			return goodsDAO.getObjById(goods_id, merchant_id);
		}

		@Override
		public HashMap getListActGoodsByPage(StringBuffer where, PageInfo page) {
			return goodsDAO.getListActGoodsByPage(where, page);
		}
}
