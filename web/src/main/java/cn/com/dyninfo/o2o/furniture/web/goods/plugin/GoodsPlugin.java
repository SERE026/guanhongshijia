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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


import cn.com.dyninfo.o2o.furniture.web.framework.plugin.IPlugin;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Brand;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

@Component("goodsPlugin")
public class GoodsPlugin extends AbstractGoodsPlugin {

	@Resource
	private HttpServletRequest request;
	
	
	public void addGoosBefor(Goods goods){
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			goods.setMerchants(merchants);
		}
		String customSortId=request.getParameter("customSortId");
		if(customSortId!=null&&customSortId.length()>0){
			GoodsSort customSort=new GoodsSort();
			customSort.setGoodsSort_id(Integer.parseInt(customSortId));
			goods.setCustomSort(customSort);
		}
		String brand_id=request.getParameter("brand_id");
		if(brand_id!=null&&brand_id.length()>0){
			Brand b=new Brand();
			b.setBrand_id(Integer.parseInt(brand_id));
			goods.setBrand(b);
			
		}
		String begin_price=request.getParameter("begin_price");
		String end_price=request.getParameter("end_price");
		String priceqj=request.getParameter("priceqj");
//		goods.setPriceRange(begin_price+"-"+end_price);
		goods.setPriceRange(priceqj);
		
		String specValues[]=request.getParameterValues("specValue");
		if(specValues!=null){
			for(int i=0;i<specValues.length;i++){
				try {
					Method m=goods.getClass().getMethod("setSpecValue"+i,new Class[]{String.class});
					m.invoke(goods, specValues[i]);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		String goodsImages[]=request.getParameterValues("goodsImage");
		if(goodsImages!=null){
			String images="";
			for(int i=0;i<goodsImages.length;i++){
				images+=goodsImages[i]+";";
			}
			goods.setImages(images);
		}
		
		for(IPlugin plugin:this.plugins){
			if(plugin instanceof IGoodsPlugin){
				IGoodsPlugin p=(IGoodsPlugin) plugin;
				p.addGoosBefor(goods);
			}
		}
	}
	
	public void addGoodsAfter(Goods goods){
		for(IPlugin plugin:this.plugins){
			if(plugin instanceof IGoodsPlugin){
				IGoodsPlugin p=(IGoodsPlugin) plugin;
				p.addGoodsAfter(goods);
			}
		}
	}
	
	public void editGoodsAfter(Goods goods){
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			goods.setMerchants(merchants);
		}
		for(IPlugin plugin:this.plugins){
			if(plugin instanceof IGoodsPlugin){
				IGoodsPlugin p=(IGoodsPlugin) plugin;
				p.editGoodsAfter(goods);
			}
		}
		
	}
	
	public void editGoosBefor(Goods goods){
		String customSortId=request.getParameter("customSortId");
		if(customSortId!=null&&customSortId.length()>0){
			GoodsSort customSort=new GoodsSort();
			customSort.setGoodsSort_id(Integer.parseInt(customSortId));
			goods.setCustomSort(customSort);
		}
		String brand_id=request.getParameter("brand_id");
		if(brand_id!=null&&brand_id.length()>0){
			Brand b=new Brand();
			b.setBrand_id(Integer.parseInt(brand_id));
			goods.setBrand(b);
			
		}
		String begin_price=request.getParameter("begin_price");
		String end_price=request.getParameter("end_price");
		String priceqj=request.getParameter("priceqj");
//		goods.setPriceRange(begin_price+"-"+end_price);
		goods.setPriceRange(priceqj);
		String specValues[]=request.getParameterValues("specValue");
		if(specValues!=null){
			for(int i=0;i<specValues.length;i++){
				try {
					Method m=goods.getClass().getMethod("setSpecValue"+i,new Class[]{String.class});
					m.invoke(goods, specValues[i]);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		String goodsImages[]=request.getParameterValues("goodsImage");
		if(goodsImages!=null){
			String images="";
			for(int i=0;i<goodsImages.length;i++){
				images+=goodsImages[i]+";";
			}
			goods.setImages(images);
		}
		
		for(IPlugin plugin:this.plugins){
			if(plugin instanceof IGoodsPlugin){
				IGoodsPlugin p=(IGoodsPlugin) plugin;
				p.editGoosBefor(goods);
			}
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return "产品";
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return "1.0";
	}
	
}
