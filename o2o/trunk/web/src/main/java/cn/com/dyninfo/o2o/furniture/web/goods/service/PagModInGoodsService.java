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

package cn.com.dyninfo.o2o.furniture.web.goods.service;

import java.util.List;
import java.util.Map;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PagModInGoods;

public interface PagModInGoodsService extends IBaseService{

	/**
	 * 获取商品 根据模块排序
	 * @param moduleId
	 * @param arearId
	 * @param flag 0按销量排序 100 101 最近浏览排序 103只查询排序商品
	 * @param page
	 * @param map
	 * @return
	 */
	public List<Goods> getGoods(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map);
	
	/**
	 * 获取商家 根据模块排序
	 * @param moduleId
	 * @param arearId
	 * @param flag 0按销量排序 100 101 最近浏览排序
	 * @param page
	 * @param map
	 * @return
	 */
	public List<Goods> getSJGoods(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map,Integer shangjiaid);
	
	/**
	 * 获取销售商品排行 
	 * @param moduleId
	 * @param arearId
	 * @param flag 102 一周热销
	 * @param page
	 * @param map
	 * @return
	 */
	public List<Goods> getGoodsSales(Integer moduleId,String arearId,Integer flag,PageInfo page,Map<String ,String> map);
	
	/**
	 *  根据商品ID列表获取商品
	 * @param list
	 * @return
	 */
	public List<Goods> getGoods(List list);
	
	/**
	 * 根据模块ID和商品ID 获取模块商品对象
	 * @param pageModule_id
	 * @param goods_id
	 * @return
	 */
	 public PagModInGoods getModeGods(String pageModule_id,String goods_id,AreaInfo area);
	 
	 /**
	  * 根据商品类型和区域获取商品数量
	  * @param sortId
	  * @param arearId
	  * @return
	  */
	 public int getGoodSortCount(String sortId,String arearId);
	 
	 /**
	  * 根据商品类型和区域获取商品数量
	  * @param sortId
	  * @param t
	  * @param arearId
	  * @return
	  */
	 public int getGoodSortCount(String sortId,int t,String arearId);
	 
	 /**
	  * 根据商品类型获取商品数量
	  * @param sortId
	  * @param sql
	  * @return
	  */
	 public int getGoodBySlqCount(String sortId,String sql);
	 
	 /**
	  * 根据商品类型获取商品信息 
	  * @param goodSort
	  * @param sql
	  * @param page
	  * @param oderBy
	  * @param pageModule_id
	  * @return
	  */
	 public List<Map> getGoodBySlqCount(String goodSort, String sql,PageInfo page,String oderBy,String pageModule_id);
	 
	 /**
	  * 活动产品
	  * @param moduleId
	  * @param arearId
	  * @param sql
	  * @param page
	  * @param orderBy
	  * @return
	  */
	 public Map getActGood(Integer moduleId,String arearId,String sql,PageInfo page,String orderBy);

	 /**
	  * 同类型活动产品推荐
	  * @param moduleId
	  * @param arearId
	  * @param sortId
	  * @param page
	  * @return
	  */
	 public Map getActGood(Integer moduleId,String arearId,String sortId,PageInfo page);
	 
	 /**
	  * 获取购买过的该商品的用户还购买的商品
	  * @param moduleId
	  * @param arearId
	  * @param goodId
	  * @param page
	  * @return
	  */
	 public Map getBuyGood(Integer moduleId,String arearId,String goodId,PageInfo page);
	 
	 /**
	  * 根据sql 获取产品数量
	  * @param sql
	  * @return
	  */
	 public int getGoodBySlqCount(String sql);
	 
	 /**
	  * 根据sql 获取产品数量---主要是搜索里的价格区间限制
	  * @param sql
	  * @return
	  */
	 public int getGoodByWhereCount(String sql,String moneysql);
	 
	 /**
		 * 根据sql 获取产品信息
		 * @param sql
		 * @param page
		 * @param oderBy
		 * @param pageModule_id
		 * @return
		 */
		public List<Map> getGoodBySlq(String sql,
				PageInfo page,String oderBy,String pageModule_id);
		
		
		public List<Map> getGoodBywhere(String sql,String moneysql,
				PageInfo page,String oderBy,String pageModule_id);

		 /**
		 * 根据sql 获取产品信息
		 * @param sql
		 * @param page
		 * @param oderBy
		 * @param pageModule_id
		 * @return
		 */
	public int getTrysortcout(int i, String string, int j, PageInfo page,
			Map map);
	
	/**
	 * 获取随机商品
	 * @param arearId
	 * @return
	 */
	public Object getRandGoods(String arearId);
	
	
	/**
	 * 获取对价格区间进行限制
	 * @param arearId
	 * @return
	 */
	
	public int getGoodBySlqCount(String sortId,String sql,String moneysql);
	
	/**
	 *获取对价格区间进行限制
	 * @param arearId
	 * @return
	 */
	
	public List<Map> getGoodBySlqCount(String goodSort, String sql,String moneysql,
			PageInfo page,String oderBy,String pageModule_id);
	
	
}
