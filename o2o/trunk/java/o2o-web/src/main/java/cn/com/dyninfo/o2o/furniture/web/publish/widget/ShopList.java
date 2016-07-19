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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantOrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantTypeService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("shopList")
public class ShopList extends Widget {

	@Resource
	private MerchantOrderService merchantOrderService;
	@Resource
	private ShangJiaService shangJiaService;
	@Resource
	private AreaService areaService;
	
	@Resource
	private MerchantTypeService merchantTypeService;
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		
		if(action.equals("nvrenjie")){//女人街
			PageInfo page=new PageInfo();
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			if(pageNo==null){
				page.setPageNo(1);
			}else{
				page.setPageNo(Integer.parseInt(pageNo));
			}
			page.setPageSize(10);
			String sql="";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("4", sql, page);
			this.putData("shopList", list);
			this.setPageName("nvrenjie.html");
		}else if(action.equals("maptuijian")){//地图店铺推荐
			PageInfo page=new PageInfo();
			String pageNo=(String) pamtr.get("pageNo");
			pamtr.put("pageNo", 1);
			if(pageNo==null){
				page.setPageNo(1);
			}else{
				page.setPageNo(Integer.parseInt(pageNo));
			}
			page.setPageSize(5);
			String sql="";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("3", sql, page);
			if (list.size() == 0) {
				page.setPageNo(1);
				list = merchantOrderService.getMerchantPageBywhere("3", sql, page);
				//System.out.println("由于结果为空，自动将页设为1, 结果数量：" + list.size());
				// 在页面中放入超页标志
				this.putData("pageIndexOut", "1");
			} else {
				this.putData("pageIndexOut", "0");
			}
			
			this.putData("shopList", list);
			this.setPageName("maptuijian.html");
		}else if(action.equals("shopSortName")){
			String sort=getSort();
			MerchantType info=(MerchantType) merchantTypeService.getObjById(sort);
			this.putData("name", info.getName());
			this.putData("sortId", info.getType_id());
			this.setPageName("shopSortName.html");
		}else if(action.equals("shoparea")){
			if(arear!=null){
				AreaInfo city=(AreaInfo) areaService.getObjById(arear.getId());
				this.putData("province", city.getParent());
				this.putData("city", city);
			}
			this.setPageName("area.html");
		}else if(action.equals("tuijian")){
			String sort=getSort();
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String sql="";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			if(sort!=null){
				sql+=" and s.TYPE_ID='"+sort+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("2", sql, page);
			this.putData("shopList", list);
			this.setPageName("tuijian.html");
		}else if(action.equals("data")){
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String sql="";
			String province=(String) pamtr.get("provinceId");
			String city=(String) pamtr.get("cityId");
			String county=(String) pamtr.get("countyId");
			
			if(province!=null){
				sql+=" and s.PROVINCE_ID='"+province+"' ";
			}
			
			/*****************************************************************************
			 * 城市搜索条件（当没有通过传参数时，自动加上当前所在区域的城市ID）
			 ****************************************************************************/
			if(city!=null){
				sql+=" and s.CITY_ID='"+city+"' ";
			} else {
				// 如果是全国，arear必定为空，此时则不加城市ID
				// 如果是其他城市则要加（没有通过下拉框传递参数时才会加上这一句）
				if (arear != null) {
					sql+=" and s.CITY_ID='"+arear.getId()+"' ";
				}
			}
			
			if(county!=null){
				sql+=" and s.COUNT_ID='"+county+"' ";
			}
			String sortId=(String) pamtr.get("sortId");
			if(sortId!=null){
				sql+=" and s.TYPE_ID='"+sortId+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("1", sql, page);
			this.putData("shopList", list);
			this.setPageName("shop.html");
			
		}else if(action.equals("dataTotal")){
			String sql=" and n.state='0' ";
			String province=(String) pamtr.get("provinceId");
			String city=(String) pamtr.get("cityId");
			String county=(String) pamtr.get("countyId");
			
			if(province!=null){
				sql+=" and n.province.id='"+province+"' ";
			}
			
			/*****************************************************************************
			 * 城市搜索条件（当没有通过传参数时，自动加上当前所在区域的城市ID）
			 ****************************************************************************/
			if(city!=null){
				sql+=" and n.city.id='"+city+"' ";
			} else {
				// 如果是全国，arear必定为空，此时则不加城市ID
				// 如果是其他城市则要加（没有通过下拉框传递参数时才会加上这一句）
				if (arear != null) {
					sql+=" and n.city.id='"+arear.getId()+"' ";
				}
			}
			
			if(county!=null){
				sql+=" and n.county.id='"+county+"' ";
			}
			String sortId=(String) pamtr.get("sortId");
			if(sortId!=null){
				sql+=" and n.type.type_id='"+sortId+"' ";
			}
			int count=shangJiaService.getCountByWhere(new StringBuffer(sql));
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, "{\"total\":"+count+"}", "json");
		}else if(action.equals("chain_top")){
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(3);
			String sql=" and s.SORT=0 ";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("5", sql, page);
			this.putData("shopList", list);
			this.setPageName("chain_top.html");
		}else if(action.equals("chain_tuijian")){
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String sql=" and s.SORT=0 ";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("6", sql, page);
			this.putData("shopList", list);
			this.setPageName("chain_tuijian.html");
		}else if(action.equals("chain_data")){
			PageInfo page=new PageInfo();
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			String sql=" and s.SORT=0 ";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("7", sql, page);
			this.putData("shopList", list);
			this.setPageName("chain_data.html");
		}else if(action.equals("chain_count")){
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String sql=" and n.sort=0 ";
			if(arear!=null){
				sql+=" and n.city.id='"+arear.getId()+"' ";
			}
			int count=shangJiaService.getCountByWhere(new StringBuffer(sql));
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, "{\"total\":"+count+"}", "json");
		}
		
		
		
		
	}
	
	
	private String getSort(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0)
			url=url.substring(url.indexOf("?"));
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return null;
	}

}
