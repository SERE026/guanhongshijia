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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.android.model.AadvInfo;
import cn.com.dyninfo.o2o.furniture.android.model.AdvGoods;
import cn.com.dyninfo.o2o.furniture.android.model.AmenuInfo;
import cn.com.dyninfo.o2o.furniture.android.service.AadvService;
import cn.com.dyninfo.o2o.furniture.android.service.AadvwzService;
import cn.com.dyninfo.o2o.furniture.android.service.AmenuService;
import cn.com.dyninfo.o2o.furniture.android.service.AmenuwzService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

/**
 * android 首页
 * @author feng
 *
 */
@Controller
@RequestMapping("/aindex")
public class AindexController{
    


	   @Resource
	   private AadvService aadvService;
	  
	   @Resource
	   private AadvwzService aadvwzService;
	   
	   @Resource
	   private AmenuService amenuService;
	   
	   @Resource
	   private AmenuwzService amenuwzService;
		
	   /**
	  	 * 广告
	  	 * @param id
	  	 * @param request
	  	 * @return
	  	 */
	  	@RequestMapping(value="/adv")
	  	public void adv(HttpServletRequest request,HttpServletResponse response){
	  		String wzid=request.getParameter("wzid");
	  		String quyu=request.getParameter("quyu");
	  		ModelAndView mav=new ModelAndView();
	  		List<AadvInfo> list=(List<AadvInfo>) aadvService.getListByWhere(new StringBuffer(" and n.aadvwz.aadvwz_id="+wzid+(quyu!=null&&!quyu.equals("")?" and n.city.id='"+quyu+"' ":" and n.city.id is null  order by orderIndex")));
	  		if(list !=null && list.size()>0){
	  			String js ="[";
	  			for(int i=0;i<list.size();i++){
	  				
	  			AadvInfo info=list.get(i);
	  				js+="{\"aadv_id\":\""+info.getAadv_id()+"\",\"name\":\""+info.getName()+"\",\"img\":\"http://www.c-1-tech.com/Dress/upload/adv/"+info.getImg()+"\"},";
	  			}
	  			js=js.substring(0,js.lastIndexOf(","));
	  			js+="]";
	  			String json="{\"status\":\"0\",\"data\":"+js+"}";
	  			ResponseUtil.printl(response, json, "json");
	  		}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
	  	}
	  	
	  	/**
	  	 * menu
	  	 * @param id
	  	 * @param request
	  	 * @return
	  	 */
	  	@RequestMapping(value="/menu")
	  	public void menu(HttpServletRequest request,HttpServletResponse response){
	  		String wzid=request.getParameter("wzid");
	  		ModelAndView mav=new ModelAndView();
	  		
	  		List<AmenuInfo> list=(List<AmenuInfo>) amenuService.getListByWhere(new StringBuffer(" and n.amenuwz.menuwz_id='"+wzid+"'"));
	  		if(list.size()>0){
	  			String js ="[";
	  			for(int i=0;i<list.size();i++){
	  			AmenuInfo info=list.get(i);
	  				js+="{\"amenu_id\":\""+info.getAmenu_id()+"\",\"name\":\""+info.getAmenu_name()+"\",\"img\":\"http://www.c-1-tech.com/Dress/upload/adv/"+info.getImg()+"\"},";
	  			}
	  			
	  			js=js.substring(0,js.lastIndexOf(","));
	  			js+="]";
	  			String json="{\"status\":\"0\",\"data\":"+js+"}";
	  			ResponseUtil.printl(response, json, "json");
	  		}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
	  	}
	  	
	    /**
	  	 * 广告产品列表 
	  	 * @param id
	  	 * @param request
	  	 * @return
	  	 */
	  	@RequestMapping(value="goodslist")
	  	public void goodslist(HttpServletRequest request,HttpServletResponse response){
	  		ModelAndView mav=new ModelAndView();
	  		String id=request.getParameter("id");
	  		String city=request.getParameter("city");
	  		String p = request.getParameter("p");
	  		PageInfo page = new PageInfo();
	  		if( p ==null || p.equals("")){
	  			page.setPageNo(1);
	  			page.setPageSize(10);
	  		}else{
	  			page.setPageNo(Integer.parseInt(p));
	  			page.setPageSize(10);
	  		}
	  		
	  		AadvInfo adv=(AadvInfo)aadvService.getObjById(id);
	  		List<AdvGoods> list=aadvService.getGoodsByadv(id, city, page);
//	  		System.out.println("------------"+list.size());
			 if(adv!=null){
				 
	  			 if(list.size()>0){
	 				String json="{\"status\":0,\"data\":[";
	 				for(int i=0;i<list.size();i++){
	 					AdvGoods advGoods = (AdvGoods) list.get(i);
	 					Goods goods=advGoods.getGoods();
	 					//计算出折扣
	 					String xmoney =  goods.getSalesMoney().toString();
	 					Float xm = Float.valueOf(xmoney);
	 					String money =  goods.getBazaarMoney().toString();
	 					Float m = Float.valueOf(money);
	 					float discount= (float)(Math.round(xm/m*100))/10;
	 					
	 					json+="{\"goodId\":\""+goods.getGoods_id()+"\",\"image\":\"http://www.c-1-tech.com/Dress/upload/goods/"+goods.getDefaultImage()+"\",\"goodName\":\""+goods.getName().replace(" ", "")+"\",\"bazaarMoney\":"+
	 					money+",\"shopid\":"+goods.getMerchants().getShangjia_id()+",\"shopname\":\""+goods.getMerchants().getName()+"\",\"salesMoney\":"+xmoney+",\"discount\":"+discount+"},";
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
	  	}
 }