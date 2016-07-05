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

package cn.com.dyninfo.o2o.furniture.web.goods.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.dao.PagModInGoodsDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PagModInGoods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;

@Service("pagModInGoodsService")
public class PagModInGoodsServiceImpl extends BaseService implements PagModInGoodsService{

	   @Resource
	   private PagModInGoodsDAO pagModInGoodsDAO;
	   
	       
       @Override
       public void initDao(){
    	   super.initDao();
    	   this.baseDao=pagModInGoodsDAO;
       }
		@Override
		public List<Goods> getGoods(Integer moduleId, String arearId,
				Integer flag, PageInfo page,Map<String ,String> map) {
			return pagModInGoodsDAO.getGoods(moduleId, arearId, flag, page,map);
		}
		@Override
		public List<Goods> getGoods(List list) {
			return pagModInGoodsDAO.getGoods(list);
		}
		@Override
		public PagModInGoods getModeGods(String pageModule_id, String goods_id,AreaInfo area) {
			return pagModInGoodsDAO.getModeGods(pageModule_id, goods_id,area);
		}
		
		@Override
		public int getGoodSortCount(String sortId,String arearId) {
			return pagModInGoodsDAO.getGoodSortCount(sortId,arearId);
		}
		@Override
		public int getGoodSortCount(String sortId, int t,String arearId) {
			return pagModInGoodsDAO.getGoodSortCount(sortId, t,arearId);
		}
		@Override
		public List<Goods> getGoodsSales(Integer moduleId, String arearId,
				Integer flag, PageInfo page, Map<String, String> map) {
			return pagModInGoodsDAO.getGoodsSales(moduleId, arearId, flag, page, map);
		}
		@Override
		public int getGoodBySlqCount(String sortId,String sql) {
			// TODO Auto-generated method stub
			return pagModInGoodsDAO.getGoodBySlqCount(sortId,sql);
		}
		@Override
		public List<Map> getGoodBySlqCount(String goodSort, String sql,
				PageInfo page,String oderBy,String pageModule_id) {
			// TODO Auto-generated method stub
			return pagModInGoodsDAO.getGoodBySlqCount(goodSort, sql, page,oderBy,pageModule_id);
		}
		@Override
		public Map getActGood(Integer moduleId, String arearId, String sql,
				PageInfo page, String orderBy) {
			return pagModInGoodsDAO.getActGood(moduleId, arearId, sql, page, orderBy);
		}
		@Override
		public Map getActGood(Integer moduleId, String arearId, String sortId,
				PageInfo page) {
			return pagModInGoodsDAO.getActGood(moduleId, arearId, sortId, page);
		}
		@Override
		public Map getBuyGood(Integer moduleId, String arearId, String goodId,
				PageInfo page) {
			// TODO Auto-generated method stub
			return pagModInGoodsDAO.getBuyGood(moduleId, arearId, goodId, page);
		}
		@Override
		public List<Map> getGoodBySlq(String sql, PageInfo page, String oderBy,
				String pageModule_id) {
			// TODO Auto-generated method stub
			return pagModInGoodsDAO.getGoodBySlq(sql, page, oderBy, pageModule_id);
		}
		@Override
		public int getGoodBySlqCount(String sql) {
			// TODO Auto-generated method stub
			return pagModInGoodsDAO.getGoodBySlqCount(sql);
		}
		
		@Override
		public List<Goods> getSJGoods(Integer moduleId, String arearId,
				Integer flag, PageInfo page,Map<String ,String> map,Integer shangjiaid) {
			return pagModInGoodsDAO.getSJGoods(moduleId, arearId, flag, page,map,shangjiaid);
		}
		@Override
		public int getTrysortcout(int i, String string, int j, PageInfo page,
				Map map) {
			return pagModInGoodsDAO.getTrysortcout(i,string,j,page,map);
		}
		@Override
		public Object getRandGoods(String arearId) {
			return pagModInGoodsDAO.getRandGoods(arearId);
		}
		@Override
		public int getGoodByWhereCount(String sql,String moneysql) {
			return pagModInGoodsDAO.getGoodByWhereCount(sql,moneysql);
		}
		@Override
		public List<Map> getGoodBywhere(String sql, String moneysql,
				PageInfo page, String oderBy, String pageModule_id) {
		
			return pagModInGoodsDAO.getGoodBywhere(sql,moneysql,page,oderBy,pageModule_id);
		}
		@Override
		public int getGoodBySlqCount(String sortId, String sql, String moneysql) {
			
			return pagModInGoodsDAO.getGoodBySlqCount(sortId,sql,moneysql);
		}
		@Override
		public List<Map> getGoodBySlqCount(String goodSort, String sql,
				String moneysql, PageInfo page, String oderBy,
				String pageModule_id) {
			return pagModInGoodsDAO.getGoodBySlqCount(goodSort,sql,moneysql,page,oderBy,pageModule_id);
		}
}
