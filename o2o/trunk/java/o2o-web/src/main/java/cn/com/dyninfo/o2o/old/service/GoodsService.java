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

package cn.com.dyninfo.o2o.old.service;

import java.util.HashMap;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Goods;

public interface GoodsService extends IBaseService{

	public void updateGoodShelves(int id,String status);
	
	/**
	 * 根据产品 获取产品销售价格
	 * @param good
	 * @return
	 */
	public String getGoodsPrice(Goods good);
	
	public Goods getGoodsPrice(int goods_id);
	
	public Double getCouriter(String arearId,int goods_id);
	
	public List getGoodsSpec(int goods_id,String specVal);
	
	/**
	 * 根据sql 获取商品品牌的数量
	 * @param sql
	 * @return
	 */
	public List getGoodBranNum(String sql);
	
	
	/**
	 * 获取商品价格区间
	 * @param sql
	 * @return
	 */
	public List getGoodPriceRange(String sql);
	
	
	/**
	 * 根据商品分类 获取商品属性
	 * @param typeId
	 * @param sql
	 * @return
	 */
	public List getGoodSpecNum(String typeId,String sql);
	
	/**
	 * 根据sql 获取商品分类数量
	 * @param sql
	 * @return
	 */
	public List getGoodSortNum(String sql);
	
	/**
	 * 根据商品条件 获取商品的品牌
	 * @param goodsId
	 * @return where
	 */
	public HashMap<String,?> getGoodsBrand(StringBuffer where);
	
	/**
	 * 获取商家
	 * @param goods_id
	 * @param merchant_id
	 * @return
	 */
	public Object getObjById(String goods_id,String merchant_id);
	
	/**
	 * 获取活动商品
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap getListActGoodsByPage(StringBuffer where,PageInfo page);
}
