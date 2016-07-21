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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * android 商家
 * @author feng
 *
 */
@Controller
@RequestMapping("/ashop")
public class AshopsController{
    

	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		@Resource
		private ShangJiaService shangJiaService;
		@Resource
		private GoodsService goodsService;
		
		
		/*
		 * 实体商家
		 */	
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 String city=request.getParameter("id");
		 String sql="";
		 if(city!=null&&city.length()>0){
				sql+=" and n.city.id='"+city+"' ";
			}
		 List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(sql));
		 if(list.size()>0){
				String json="{\"status\":0,\"data\":[";
				for(ShangJiaInfo info:list){
					json+="{\"shangjia_id\":"+info.getShangjia_id()+",\"name\":\""+info.getName()+"\",\"longitude\":"+info.getLongitude()+",\"latitude\":"+
					info.getLatitude()+",\"address\":\""+info.getAddress()+"\"},";
				}
				if(json.length()>1){
					json=json.substring(0,json.length()-1);
				}
				json+="]}";
				ResponseUtil.printl(response, json, "json");
			
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 

	 /*
		 * 商家详细
		 */	
	 @RequestMapping("/detail")
	 public void detail(HttpServletRequest request,HttpServletResponse response){
		 String id=request.getParameter("id");
		 ShangJiaInfo info = (ShangJiaInfo)shangJiaService.getObjById(id);
		 if(info!=null){
			 String json=ResponseUtil.getObjeJson(info).toString();
  			 ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 	/*
		 * 女人街商家商品列表
		 */	
	 @RequestMapping("/nrjgoods")
	 public void nrjgoods(HttpServletRequest request,HttpServletResponse response){
		 String id=request.getParameter("id");
		 ShangJiaInfo shop = (ShangJiaInfo)shangJiaService.getObjById(id);
		 if(shop!=null){
			 String pageno=request.getParameter("pageno");
			 PageInfo page=new PageInfo();
			 page.setPageNo(Integer.parseInt(pageno));
			 page.setPageSize(10);
			 String orderBy="  g_index asc";
			 String sql="";
			 Map map = shangJiaService.getGoodsByAct(sql, ""+shop.getShangjia_id(), page,orderBy);
			 List list= (List) map.get("data");
			 String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
	 					Map  goods = (Map) list.get(i);
	 					//计算出折扣
	 					String xmoney =  goods.get("money").toString();
	 					Float xm = Float.valueOf(xmoney);
	 					String money =   goods.get("xmoney").toString();
	 					Float m = Float.valueOf(money);
	 					float discount= (float)(Math.round(xm/m*100))/10;
	 					
	 					json+="{\"goodId\":\""+goods.get("goodId")+"\",\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+goods.get("image")+"\",\"goodName\":\""+goods.get("goodName").toString().replace(" ", "")+"\",\"bazaarMoney\":"+
	 					money+",\"salesMoney\":"+xmoney+",\"discount\":"+discount+"},";
	 				}
	 				if(json.length()>1){
	 					json=json.substring(0,json.length()-1);
	 				}
	 				json+="]}";
	 				ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 
		/*
		 * 身边美容院
		 */
	 @RequestMapping("/nearshop")
	 public void nearshop(HttpServletRequest request,HttpServletResponse response){
		 String lon=request.getParameter("lon");
		 String lat=request.getParameter("lat");
		 Double lon1=Double.parseDouble(lon);
		 Double lat1=Double.parseDouble(lat);
		 String pageno=request.getParameter("pageno");
		 PageInfo page=new PageInfo();
		 page.setPageNo(Integer.parseInt(pageno));
		 page.setPageSize(10);
		 List list= shangJiaService.getNearshop(lon1, lat1,page);
		 if(list.size()>0){
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				Map map = (Map) list.get(i);
				String str=map.get("distance").toString();
				String juli = str.substring(0, str.indexOf('.'));
				int jl = Integer.parseInt(juli)/1000;
//				System.out.println(Integer.parseInt(juli) +"_"+jl);
				if(jl<50){
					json+="{\"name\":\""+map.get("NAME").toString()+"\",\"shangjiaid\":\""+map.get("SHANGJIA_ID").toString()+"\",\"discount\":"+jl+",\"address\":\""+map.get("ADDRESS").toString()+"\",\"image\":\""+
					map.get("DZ_IAMGE").toString()+"\",\"contactPhone\":\""+map.get("CONTACTPHONE").toString()+"\"},";
				}
			}
			if(json.length()>20){
				json=json.substring(0,json.length()-1);
			}
			json+="]}";
			ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 /*
		 * 身边美容院详情
		 */
	 @RequestMapping("/shoplist") 
	 public void shoplist(HttpServletRequest request,HttpServletResponse response){
		 String pageno=request.getParameter("pageno");
		 PageInfo page=new PageInfo();
		 page.setPageNo(Integer.parseInt(pageno));
		 page.setPageSize(10);
		 String id = request.getParameter("id");

		 Map map	=  goodsService.getListByPageWhere(new StringBuffer(" and n.merchants.shangjia_id='"+id+"' "), page);
		 List<Goods> list =(List<Goods>) map.get("DATA");
		 if(list.size()>0){
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				//计算出折扣
				Double xm = list.get(i).getSalesMoney();
				Double m = list.get(i).getBazaarMoney();
				float discount= (float)(Math.round(xm/m*100))/10;
					json+="{\"goods_id\":\""+list.get(i).getGoods_id()+"\",\"address\":\""+list.get(i).getMerchants().getAddress()+"\",\"discount\":"+discount+",\"name\":\""+list.get(i).getName()+"\",\"defaultImage\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+
					list.get(i).getDefaultImage()+"\",\"bazaarMoney\":\""+list.get(i).getBazaarMoney()+"\",\"salesMoney\":\""+list.get(i).getSalesMoney()+"\"},";
				}
			if(json.length()>20){
				json=json.substring(0,json.length()-1);
			}
			json+="]}";
			ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 

		/*
		 * 附近宝贝
		 */
	 @RequestMapping("/neargoods") 
	 public void neargoods(HttpServletRequest request,HttpServletResponse response){
		 String lon=request.getParameter("lon");
		 String lat=request.getParameter("lat");
		 Double lon1=Double.parseDouble(lon);
		 Double lat1=Double.parseDouble(lat);
		 String pageno=request.getParameter("pageno");
		 PageInfo page=new PageInfo();
		 page.setPageNo(Integer.parseInt(pageno));
		 page.setPageSize(10);
		 try{
			
			 List list= shangJiaService.getNeargoods(lon1, lat1,56,page,"");
			 String json="{\"status\":0,\"data\":[";
			 if(list.size()>0){
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i);
					//计算出折扣
					String xmoney =  map.get("SALESMONEY").toString();
					Float xm = Float.valueOf(xmoney);
					String money =  map.get("BAZAARMONEY").toString();
					Float m = Float.valueOf(money);
					float discount= (float)(Math.round(xm/m*100))/10;
					String str=map.get("distance").toString();
					String juli = str.substring(0, str.indexOf('.'));
					int jl = Integer.parseInt(juli)/1000;
//					System.out.println(Integer.parseInt(juli) +"_"+jl);
					if(jl<50){
					json+="{\"goods_id\":"+map.get("GOODS_ID").toString()+",\"distance\":\""+jl+"\",\"address\":\""+map.get("ADDRESS").toString()+"\",\"discount\":"+discount+",\"name\":\""+map.get("NAME").toString()+"\",\"defaultImage\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+
					map.get("DEFAULT_IAMAGE").toString()+"\",\"bazaarMoney\":\""+map.get("BAZAARMONEY").toString()+"\",\"salesMoney\":\""+map.get("SALESMONEY").toString()+"\"},";
					}
					}
				if(json.length()>20){
					json=json.substring(0,json.length()-1);
				}
			 }
				json+="]}";
				ResponseUtil.printl(response, json, "json");
		 }catch(Exception e){
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 

		/*
		 * 附近美容项目
		 */
	 @RequestMapping("/nearmrxm")
	 public void nearmrxm(HttpServletRequest request,HttpServletResponse response,
			 String cityid){
//		 String lon=request.getParameter("lon");
//		 String lat=request.getParameter("lat");
//		 Double lon1=Double.parseDouble(lon);
//		 Double lat1=Double.parseDouble(lat);
		 String pageno=request.getParameter("pageno");
		 PageInfo page=new PageInfo();
		 page.setPageNo(Integer.parseInt(pageno));
		 page.setPageSize(10);
//		 List list= shangJiaService.getNearmrxm(lon1, lat1,page);
		 List list = shangJiaService.getByCityId(cityid, page);
		 if(list.size()>0){
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				Map map = (Map) list.get(i);
				//计算出折扣
				String xmoney =  map.get("SALESMONEY").toString();
				Float xm = Float.valueOf(xmoney);
				String money =  map.get("bazaarMoney").toString();
				Float m = Float.valueOf(money);
				float discount= (float)(Math.round(xm/m*100))/10;
//				String str=map.get("distance").toString();
//				String juli = str.substring(0, str.indexOf('.'));
//				int jl = Integer.parseInt(juli)/1000;
//				System.out.println(Integer.parseInt(juli) +"_"+jl);
//				if(jl<50){
						json+="{\"goods_id\":"+map.get("GOODS_ID").toString()+
								",\"discount\":"+
				discount+",\"shopname\":\""
								+map.get("shopname").toString()+"\",\"goodsname\":\""
				+map.get("goodsname").toString()+
				"\",\"defaultImage\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+
						map.get("DEFAULT_IAMAGE").toString()+"\",\"bazaarMoney\":"
				+map.get("bazaarMoney").toString()+",\"salesMoney\":"
						+map.get("SALESMONEY").toString()+"},";
					}
//				}
			if(json.length()>20){
				json=json.substring(0,json.length()-1);
			}
			json+="]}";
			ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 
		/*
		 * 身边店家
		 */
	 @RequestMapping("/mapshop")
	 public void mapshop(HttpServletRequest request,HttpServletResponse response){
	try{
		 String id=request.getParameter("id");
		 String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		 StringBuffer  where =new StringBuffer();
		
		 if(id==null||id.equals("")){
			 where.append(" and n.city.name like '"+name+"%'");
		 }else{
			 where.append(" and n.city.id='"+id+"'");
		 }
		 where.append(" and state='0'");
		 List list= shangJiaService.getListByWhere(where);
		 if(list.size()>0){
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				ShangJiaInfo info = (ShangJiaInfo) list.get(i);
				if(info!=null){
					json+="{\"name\":\""+info.getName()+"\",\"shangjiaid\":\""+info.getShangjia_id()+"\",\"lat\":\""+
					info.getLatitude()+"\",\"lon\":\""+info.getLongitude()+"\"},";
				}
			}
			if(json.length()>20){
				json=json.substring(0,json.length()-1);
			}
			json+="]}";
			ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	}catch(Exception e){
		 ResponseUtil.printl(response, "{\"status\":1}", "json");
	 }
	 }
	 
		/*
		 * 根据商品取得店铺信息
		 */
	 @RequestMapping("/getshop")
	 public void getshop(HttpServletRequest request,HttpServletResponse response){
	try{
		 String id=request.getParameter("id");
		 Goods  goods=(Goods) goodsService.getObjById(id);
		 if(goods!=null){
			 String json="{\"status\":0,\"data\":[";
			 json+="{\"shopid\":\""+goods.getMerchants().getShangjia_id()+"\"" +
			 		",\"shopename\":\""+goods.getMerchants().getName()+"\"" +
			 				",\"num\":\""+goods.getNum()+"\"},";
			 json+="]}";
			 ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");			 
		 }
		}catch(Exception e){
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
 }