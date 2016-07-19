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


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.old.dao.GoodsSpecDAO;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.model.GoodsSpec;
import cn.com.dyninfo.o2o.old.model.GoodsSpecVal;

@Component
public class SpecGoodsPlugin extends AbstractGoodsPlugin  {

	@Resource
	private HttpServletRequest request;
	
	@Resource
	private GoodsSpecDAO goodsSpecDAO;
	
	@Autowired
	public SpecGoodsPlugin(GoodsPlugin goodsPlugin){
		addPlugin(goodsPlugin);
	}
	
	@Override
	public void addGoodsAfter(Goods goods) {
		String attrNames[]=request.getParameterValues("attrName");
		String attrTypes[]=request.getParameterValues("attrType");
		if(attrNames!=null)
		for(int i=0;i<attrNames.length;i++){
			GoodsSpec spec=new GoodsSpec();
			spec.setName(attrNames[i]);
			spec.setType(attrTypes[i]);
			spec.setGoods(goods);
			goodsSpecDAO.addObj(spec);
			
			String attrVals[]=request.getParameterValues("attrVal"+i);
			String attrValImgs[]=request.getParameterValues("attrVal"+i+"img");
			for(int j=0;j<attrVals.length;j++){
				/**
				 * 商品参数价格
				 */
				String bazaarMoneyTag=request.getParameter("bazaarMoneyTag"+i+":"+j);
				String salesMoneyTag=request.getParameter("salesMoneyTag"+i+":"+j);
				String costsMoneyTag=request.getParameter("costsMoneyTag"+i+":"+j);
				String inventoryTag=request.getParameter("inventoryTag"+i+":"+j);
				String weightTag=request.getParameter("weightTag"+i+":"+j);
				GoodsSpecVal val=new GoodsSpecVal();
				val.setImg(attrValImgs[j]);
				val.setGoods(goods);
				val.setSpec(spec);
				val.setVal(attrVals[j]);
				if(bazaarMoneyTag!=null&&bazaarMoneyTag.length()>0)
					val.setBazaar(Double.parseDouble(bazaarMoneyTag));
				if(salesMoneyTag!=null&&salesMoneyTag.length()>0)
					val.setSales(Double.parseDouble(salesMoneyTag));
				if(costsMoneyTag!=null&&costsMoneyTag.length()>0)
					val.setCost(Double.parseDouble(costsMoneyTag));
				if(inventoryTag!=null&&inventoryTag.length()>0)
					val.setInventory(Double.parseDouble(inventoryTag));
				if(weightTag!=null&&weightTag.length()>0)
					val.setWeight(Double.parseDouble(weightTag));
				goodsSpecDAO.addObj(val);
			}
		}
	}
	
	
	@Override
	public void editGoodsAfter(Goods goods) {
		goodsSpecDAO.updateSpecAndValStatus(goods.getGoods_id());
		String attrNameIds[]=request.getParameterValues("attrNameId");
		
		String attrNames[]=request.getParameterValues("attrName");
		String attrTypes[]=request.getParameterValues("attrType");
		if(attrNames!=null){
			for(int i=0;i<attrNames.length;i++){
				
				GoodsSpec spec=new GoodsSpec();
				if(attrNameIds!=null&&attrNameIds.length>i){
					spec=(GoodsSpec) goodsSpecDAO.getObjById(attrNameIds[i]);
					if(spec==null){
						spec=new GoodsSpec();
					}
				}
				spec.setName(attrNames[i]);
				spec.setType(attrTypes[i]);
				spec.setGoods(goods);
				spec.setStatus(0);
				goodsSpecDAO.addObj(spec);
				
				String attrValIds[]=request.getParameterValues("attrValId"+i);
				String attrVals[]=request.getParameterValues("attrVal"+i);
				String attrValImgs[]=request.getParameterValues("attrVal"+i+"img");
				if(attrVals!=null){
					for(int j=0;j<attrVals.length;j++){
						/**
						 * 商品参数价格
						 */
						String bazaarMoneyTag=request.getParameter("bazaarMoneyTag"+i+":"+j);
						String salesMoneyTag=request.getParameter("salesMoneyTag"+i+":"+j);
						String costsMoneyTag=request.getParameter("costsMoneyTag"+i+":"+j);
						String inventoryTag=request.getParameter("inventoryTag"+i+":"+j);
						String weightTag=request.getParameter("weightTag"+i+":"+j);
						GoodsSpecVal val=new GoodsSpecVal();
						if(attrValIds!=null&&attrValIds.length>j){
							val=(GoodsSpecVal) goodsSpecDAO.getSpecVal(attrValIds[j]);
							if(val==null){
								val=new GoodsSpecVal();
							}
						}
						val.setVal(attrVals[j]);
						val.setGoods(goods);
						val.setSpec(spec);
						val.setStatus(0);
						if(attrValImgs!=null)
							val.setImg(attrValImgs[j]);
						if(bazaarMoneyTag!=null&&bazaarMoneyTag.length()>0)
							val.setBazaar(Double.parseDouble(bazaarMoneyTag));
						if(salesMoneyTag!=null&&salesMoneyTag.length()>0)
							val.setSales(Double.parseDouble(salesMoneyTag));
						if(costsMoneyTag!=null&&costsMoneyTag.length()>0)
							val.setCost(Double.parseDouble(costsMoneyTag));
						if(inventoryTag!=null&&inventoryTag.length()>0)
							val.setInventory(Double.parseDouble(inventoryTag));
						if(weightTag!=null&&weightTag.length()>0)
							val.setWeight(Double.parseDouble(weightTag));
						if(val.getSpec_val_id()!=null)
							goodsSpecDAO.updateObj(val);
						else
							goodsSpecDAO.addObj(val);
					}
				}
			}
		}
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return "产品属性";
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void addGoosBefor(Goods goods) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editGoosBefor(Goods goods) {
		// TODO Auto-generated method stub
		
	}
	
}
