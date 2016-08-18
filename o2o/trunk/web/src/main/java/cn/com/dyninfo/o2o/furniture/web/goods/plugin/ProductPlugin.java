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

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.goods.dao.ProductDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Product;

@Component
public class ProductPlugin extends AbstractGoodsPlugin {
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private ProductDAO productDAO;
	
	@Autowired
	public ProductPlugin(GoodsPlugin goodsPlugin){
		addPlugin(goodsPlugin);
	}


	@Override
	public void addGoodsAfter(Goods goods) {
		Product p=goods.getProduct();
		copyData(goods,p);
		p.setGood(goods);
		productDAO.updateObj(p);
	}
	
	public void copyData(Object obj,Object obj2){
		Field fields[]=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			String fieldName=field.getName();
			fieldName=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			
			Object temp = null;
			
			try {
				Method m=obj.getClass().getMethod("get"+fieldName);
				//System.out.println(m.getName());
				if(m!=null){
					Method m2=obj2.getClass().getMethod("set"+fieldName, field.getType());
					if(m2!=null){
						Object val=m.invoke(obj);
						temp = val;
						m2.invoke(obj2, val);
					} else {
//						System.out.println("未找到"+m.getName());
					}
				}
//				System.out.println(fieldName+"= 字段正常，值：" + temp);
			} catch (Exception e) {
//				System.out.println(fieldName+"====================字段出错！值：" + temp);
				//e.printStackTrace();
			} 
		}
	}

	@Override
	public String getName() {
		return "货品";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}


	@Override
	public void addGoosBefor(Goods goods) {
		Product p=new Product();
		productDAO.addObj(p);
		goods.setProduct(p);
	}


	@Override
	public void editGoodsAfter(Goods goods) {
		
		Product p=(Product) productDAO.getObjById(""+goods.getProduct().getProduct_id());
		copyData(goods,p);
		p.setGood(goods);
		productDAO.updateObj(p);
	}


	@Override
	public void editGoosBefor(Goods goods) {
		Product p=(Product) productDAO.getObjById(""+goods.getProduct().getProduct_id());
//		if(p.getSalesNum()>0){
			p=new Product();
			p.setGood(goods);
			productDAO.addObj(p);
			goods.setProduct(p);
//		}
		
	}

	
}
