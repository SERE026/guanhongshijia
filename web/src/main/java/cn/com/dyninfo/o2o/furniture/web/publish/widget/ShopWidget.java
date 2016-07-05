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

package cn.com.dyninfo.o2o.furniture.web.publish.widget;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.active.service.DiscountActiveService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.widget.ShopWidgetUtil;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.page.model.Ckhdsp;
import cn.com.dyninfo.o2o.furniture.web.page.service.CkhdspService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

@Component("shopWidte")
@Scope("prototype")
public class ShopWidget extends Widget {

	@Resource
	private ShangJiaService shangJiaService;
	
	@Resource
	private GoodsSortService goodsSortService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private DiscountActiveService discountActiveService;
	
	   @Resource
	   private CkhdspService ckhdspService;
	
	private String json="";
	
	@Override
	public void display(Map pamtr) {
		
		
		
		String action=(String) pamtr.get("action");
		if(action==null&&!getShopAbout()){
			
			String shopId=getShopId();
			ShangJiaInfo shop= (ShangJiaInfo) shangJiaService.getObjById(shopId);
			this.putData("shopPath", this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/");
			
			this.setTitle(shop.getName());
			this.putData("shop", shop);
			if(shop.getState().equals("1")){
				this.setPageName("noShop.html");
				return ;
			}
			
			if(shop.getFlag()==0){//默认商店
				defaultShop(shop,pamtr);
			}else if(shop.getFlag()==1){//自定义商店
				String widgetPath=this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/widget.xml";
				File file=new File(widgetPath);
				if(file.exists()){
					customShop(shop,pamtr);
				}else{
					defaultShop(shop,pamtr);
				}
			}
			
			this.putData("dzImage", shop.getDzImage());// 店招图片
			this.putData("urlList", shop.getDzUrl());// 店招外链
			
			this.putData("spId", shopId);
		}else if(action==null&&getShopAbout()){
			String shopId=getShopId();
			ShangJiaInfo shop= (ShangJiaInfo) shangJiaService.getObjById(shopId);
			this.putData("shopPath", this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/");
			if(shop.getState().equals("1")){
				this.setPageName("noShop.html");
				return ;
			}
			this.setTitle(shop.getName());
			this.putData("shop", shop);
			if(shop.getFlag()==0){//默认商店
				defaultShop(shop,pamtr);
				this.putData("activimg", ckhdspService.getObjById("1"));
				this.setPageName("shopAbout.html");
			}else if(shop.getFlag()==1){//自定义商店
				String widgetPath=this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/widget.xml";
				File file=new File(widgetPath);
				if(file.exists()){
					customShop(shop,pamtr);
					this.setPageName(this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/shop_about.html");
				}else{
					defaultShop(shop,pamtr);
					this.putData("activimg", ckhdspService.getObjById("1"));
					this.setPageName("shopAbout.html");
				}
				
			}
			this.putData("spId", shopId);
			this.putData("dzImage", shop.getDzImage());// 店招图片
			this.putData("nrjImage", shop.getNrjImage());// 女人街店招图片
			this.putData("urlList", shop.getDzUrl());// 店招外链
			
			
		}else{
			String shopId=(String) pamtr.get("spId");
			ShangJiaInfo shop= (ShangJiaInfo) shangJiaService.getObjById(shopId);
			this.putData("shopPath", this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/");
			defaultJsonShop(shop,pamtr);
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
			
			//this.putData("json",json);
			//this.setPageName("json.html");
		}
	}
	/**
	 * 获取商店ID
	 * @return
	 */
	private boolean getShopAbout(){
		String url=this.HttpRequest.getServletPath();
		return url.indexOf("about")>0;
	}
	
	/**
	 * 获取商店ID
	 * @return
	 */
	private String getShopId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0)
			url=url.substring(0,url.indexOf("?"));
		
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher  m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return null;
	}
	private void defaultJsonShop(ShangJiaInfo shop,Map pamtr){
			Map p=new HashMap();
			p.putAll(pamtr);
			String Object=(String) p.get("Object");//widget type
			if(Object==null)
				Object="";
			if(Object.equals("GOOD")){
				Map data=(Map) getGoods(p,shop);
				if(p.get("result").equals("data")){
					List list=(List) data.get("data");
					json=ResponseUtil.getJsonListMap(list).toString();
				}else if(p.get("result").equals("NUM")){
					int num=(Integer)data.get("num");
					json="{\"total\":"+num+"}";
				}else{
					
				}
			}else if(Object.equals("SORT")){
				
			}else if(Object.equals("ACTGOOD")){
				Map data=(Map) getActGoods(p,shop);
				if(p.get("result").equals("data")){
					List list=(List) data.get("data");
					json=ResponseUtil.getJsonListMap(list).toString();
					
				}else if(p.get("result").equals("NUM")){
					int num=(Integer)data.get("num");
					json="{\"total\":"+num+"}";
				}
			}
			
	}
	private void defaultShop(ShangJiaInfo shop,Map pamtr){
		Map<String,?> map=ShopWidgetUtil.parseShopWidget(this.getClass().getResourceAsStream("widget.xml"));
		for(String widgetName:map.keySet()){
			Map<String,String> widget=(Map<String, String>) map.get(widgetName);
			String Object=widget.get("Object");//widget type
			if(Object==null)
				Object="";
			Map p=new HashMap();
			p.putAll(pamtr);
			p.putAll(widget);
			if(Object.equals("GOOD")){
				Map data=(Map) getGoods(p,shop);
				if(widget.get("result").equals("data")){
					List list=(List) data.get("data");
					this.putData(widgetName, list);
					json=ResponseUtil.getJsonListMap(list).toString();
					
				}else if(widget.get("result").equals("num")){
					int num=(Integer)data.get("num");
					json="{\"total\":"+num+"}";
					this.putData(widgetName, num);
				}
				this.putData("Object", "GOOD");
			}else if(Object.equals("SORT")){
				this.putData(widgetName,getSort(p,shop));
			}else if(Object.equals("ACTGOOD")){
				this.putData(widgetName,getActGoods(p,shop));
				
				
			}
			
		}
		String dzImage=shop.getDzImage();
		this.putData("shopName", shop.getName());
		this.putData("shopId",shop.getShangjia_id());
		this.putData("shop",shop);
		this.putData("cityName",shop.getCity()!=null?shop.getCity().getName():"");
		Widget adv=SpringContext.getBean("adv");
		pamtr.put("id", "16");
		String context=adv.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
		this.putData("gg", context);
		Ckhdsp info=(Ckhdsp) ckhdspService.getObjById("1");
		this.putData("activimg", info);
		this.setPageName("shoptml.html");
	}
	
	/**
	 *  widget id="Name"
	 *  	type
	 * 		object
	 * 		flag
	 * 		pageSize
	 * @param shop
	 * @param pamtr
	 */
	private void customShop(ShangJiaInfo shop,Map pamtr){
		String widgetPath=this.HttpRequest.getRealPath("/")+"/merchants/"+shop.getShangjia_id()+"/widget.xml";
		
		Map<String,?> map=ShopWidgetUtil.parseShopWidget(widgetPath);
		for(String widgetName:map.keySet()){
			Map<String,String> widget=(Map<String, String>) map.get(widgetName);
			String Object=widget.get("Object");//widget type
			if(Object==null)
				Object="";
			Map p=new HashMap();
			p.putAll(pamtr);
			p.putAll(widget);
			if(Object.equals("GOOD")){
				Map data=(Map) getGoods(p,shop);
				if(widget.get("result").equals("data")){
					List list=(List) data.get("data");
					this.putData(widgetName, list);
					json=ResponseUtil.getJsonListMap(list).toString();
				}else if(widget.get("result").equals("num")){
					int num=(Integer)data.get("num");
					json="{\"total\":"+num+"}";
					this.putData(widgetName, num);
				}
				this.putData("Object", "GOOD");
			}else if(Object.equals("SORT")){
				this.putData(widgetName,getSort(p,shop));
			}else if(Object.equals("ACTGOOD")){
				this.putData(widgetName,getActGoods(p,shop));
			}
		}
		
		this.setPageFolder("merchants/"+shop.getShangjia_id()+"/");
		this.setPageName("shop.html");
	}
	/**
	 * 查询产品
	 * @param pamtr
	 * @return
	 */
	private Object getGoods(Map pamtr,ShangJiaInfo shop){
		String pageSize=(String) pamtr.get("pageSize");
		if(pageSize==null)
			pageSize="1";
		String pageNo=(String) pamtr.get("pageNo");
		if(pageNo==null)
			pageNo="1";
		String orderBy=(String) pamtr.get("orderBy");
		PageInfo page=new PageInfo();
		page.setPageSize(Integer.parseInt(pageSize));
		page.setPageNo(Integer.parseInt(pageNo));
		String SortId=(String) pamtr.get("SortId");
		String sql="";
		if(SortId!=null){
			sql+=" and g.CUSTOM_SORT_ID like '"+SortId+"%' ";
		}
		return shangJiaService.getGoodsByAct(sql, ""+shop.getShangjia_id(), page,orderBy);
	}
	/**
	 * 查询活动产品
	 * @param pamtr
	 * @return
	 */
	private Object getActGoods(Map pamtr,ShangJiaInfo shop){
		String pageSize=(String) pamtr.get("pageSize");
		String pageNo=(String) pamtr.get("pageNo");
		String SortId=(String) pamtr.get("SortId");
		String orderBy=(String) pamtr.get("orderBy");
		PageInfo page=new PageInfo();
		if(pageSize==null)
			pageSize="1";
		page.setPageSize(Integer.parseInt(pageSize));
		if(pageNo==null)
			pageNo="1";
		page.setPageNo(Integer.parseInt(pageNo));
		String sql="";
		if(SortId!=null){
			sql+=" and g.CUSTOM_SORT_ID="+SortId;
		}
		return shangJiaService.getGoodsByAct(sql, ""+shop.getShangjia_id(), page,orderBy);
	}
	/**
	 * 查询活动
	 * @param pamtr
	 * @return
	 */
	private Object getAct(Map pamtr,ShangJiaInfo shop){
		
		return discountActiveService.getListByWhere(new StringBuffer(" and n.merchants.shangjia_id="+shop.getShangjia_id()));
	}
	/**
	 *  查询产品分类
	 * @param pamtr
	 * @return
	 */
	private Object getSort(Map pamtr,ShangJiaInfo shop){
		return goodsSortService.getListByWhere(new StringBuffer(" and n.parent is null and n.status=0 and n.flag=1 and n.merchants.shangjia_id="+shop.getShangjia_id()));
	}
}
