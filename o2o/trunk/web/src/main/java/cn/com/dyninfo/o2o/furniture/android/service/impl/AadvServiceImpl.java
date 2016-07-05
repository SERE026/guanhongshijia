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

package cn.com.dyninfo.o2o.furniture.android.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.android.dao.AadvDao;
import cn.com.dyninfo.o2o.furniture.android.model.AadvInfo;
import cn.com.dyninfo.o2o.furniture.android.model.AdvGoods;
import cn.com.dyninfo.o2o.furniture.android.service.AadvService;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;


@Service("aimgtogoodsService")
public class AadvServiceImpl extends BaseService implements AadvService{

	    @Resource
	    private AadvDao aadvDao;
	    
	    @Resource
	    private GoodsService goodsService;
	    @Resource
	    private HttpServletRequest request;
	    
	    @Override
	    public void initDao(){
		    	super.initDao();
		    	this.baseDao=aadvDao;
	    }

		@Override
		public List getGoodsByadv(String advId, String city, PageInfo page) {
			return aadvDao.getGoodsByadv(advId, city, page);
		}
		
		@Override
		public List getGoodsByadv(String advId, String city) {
			return aadvDao.getGoodsByadv(advId, city);
		}
		
		@Override
		public String updateObj(Object obj) {
			AadvInfo info=(AadvInfo) obj;
			aadvDao.delGoods(""+info.getAadv_id());
		  	String[] goods_id=request.getParameterValues("goods_id");
		  	String[] orderIndex=request.getParameterValues("orderIndex");
		  	AreaInfo area=(AreaInfo) request.getSession().getAttribute("advOrderArea");
	    	    info.setCity(area);
	    	    List<AdvGoods> list=new ArrayList();
	    	    AdvGoods advGoods=null;
	    	    if(goods_id!=null){
		    	    for(int i=0;i<goods_id.length;i++){
		    	    	advGoods=new AdvGoods();
		    	    	advGoods.setAdv(info);
		    	    	advGoods.setCity(area);
		    	    	advGoods.setOrderIndex(Integer.parseInt(orderIndex[i]));
		    	    	advGoods.setGoods((Goods)goodsService.getObjById(goods_id[i]));
		    	    	list.add(advGoods);
		    	    }
	    	    }
	    	    info.setGoods(list);
	    	    aadvDao.updateObj(info);
				
	    	    return "";
		}
}
