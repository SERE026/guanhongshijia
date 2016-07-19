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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.old.service.ActiveMemberService;
import cn.com.dyninfo.o2o.old.service.GameActiveService;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.model.CarsBox;
import cn.com.dyninfo.o2o.old.service.CarsService;

/**
 * android	购物车
 * @author feng
 *
 */
@Controller
@RequestMapping("/acar")
public class AcarController{
    
	
	@Resource
	private ActiveMemberService activeMemberService;
	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		
		@Resource
		private CarsService carsService;
		
		@Resource
		private GoodsService goodsService;
		
		@Resource
		private GameActiveService gameActiveService;
		
		
		 @Resource
		 private HuiyuanService huiyuanService;
		
	 @RequestMapping("/goodlist")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 String huiYuan_id=request.getParameter("huiYuan_id");
		 HuiyuanInfo huiyuan=(HuiyuanInfo)huiyuanService.getObjById(huiYuan_id);
		 List list=carsService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiYuan_id));
		if(list != null && list.size()>0){
			
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				CarsBox carinfo = (CarsBox) list.get(i);
				Double actMoney=0d;
				String actInfo=carinfo.getActInfo();
				if(actInfo.split("\\|").length==4){
					actMoney=Double.parseDouble(actInfo.split("\\|")[1]);
				}
				
				json+="{\"goodsname\":\""+carinfo.getGoods().getName().replace(" ", "")+"\",\"cars_box_id\":\""
				+carinfo.getCars_box_id()+"\",\"image\":\"http://www.c-1-tech.com/Dress/upload/goods/"
						+carinfo.getGoods().getDefaultImage()+"\",\"money\":"+carinfo.getPrice()+",\"num\":"+
				carinfo.getNum()+",\"shopid\":\""+carinfo.getGoods().getMerchants().getShangjia_id()
				+"\",\"shopname\":\""+carinfo.getGoods().getMerchants().getName()+"\",\"good_id\":\""
				+carinfo.getGoods().getGoods_id()+"\",\"specVal\":\""+carinfo.getSpecVal()+"\",\"actInfo\":\""
				+carinfo.getActInfo()+"\",\"type\":\"sl\"},";
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

	 
	 @RequestMapping("/modify")
	 public void modify(HttpServletRequest request,HttpServletResponse response){
		 String cars_box_id=request.getParameter("cars_box_id");
		 String num=request.getParameter("num");
		try{
			 CarsBox info=(CarsBox) carsService.getObjById(cars_box_id);
			 info.setNum(Integer.parseInt(num));
			 carsService.updateObj(info);
		   	ResponseUtil.printl(response, "{\"status\":0}", "json");
	 	}catch(Exception e){
	 		ResponseUtil.printl(response, "{\"status\":1}", "json");
	 	}
	 } 
	 
	 /*
	  * 游戏商品添加到购物车
	  */
	 @RequestMapping("/actadd")
	 public void actadd(HttpServletRequest request,HttpServletResponse response){
		 try{
			Map map =new HashMap();
			String agmId=(String) request.getParameter("agmId");
		 	String g_id=(String) request.getParameter("g_id");
			String a_id=(String) request.getParameter("a_id");
			String huiYuan_id=(String) request.getParameter("huiYuan_id");
			HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(huiYuan_id);
			request.getSession().setAttribute(Context.SESSION_MEMBER, huiyuan);
			Active a=(Active) gameActiveService.getObjById(a_id);
			Double m=0.0;
			Goods good=(Goods) goodsService.getObjById(g_id);
			if(a.getFlag()==0){
				if(a.getType().equals("1")){
					m=a.getVal();
				}else if(a.getType().equals("2")){
					m=good.getSalesMoney()/a.getVal()*10;
				}
			}
			String sepcVal=carsService.checkGoodSpecVal(g_id, "");
			String num=(String) request.getParameter("num");
			if(num==null||num.length()==0)
				num="1";
			if(!agmId.equals("0")){
				ActiveMemberInfo actMember=(ActiveMemberInfo) activeMemberService.getObjById(agmId);
				if(actMember!=null){///游戏商品
					m=actMember.getMoney();
					good=(Goods) goodsService.getObjById(g_id);
					sepcVal=carsService.checkGoodSpecVal(g_id, "");
					num="1";
					map=carsService.addGoods(good.getGoodMoney(),
							Integer.parseInt(num),good.getGoods_id(),
							response,request,sepcVal,
							a_id+"|"+m+"|"+actMember.getAct_meb_id(),m);
				}
			}else{
				 map=carsService.addGoods(good.getGoodMoney(),
						 Integer.parseInt(num),good.getGoods_id(),
						 response,request,sepcVal,a_id+"|"+m,m);
			}
			if(map!=null){
				String json="{\"status\":0,\"data\":[";
				json+="{\"cars_box_id\":\""+map.get("CARS_BOX_ID")+"\",\"money\":"+map.get("Money")+"}]}";
				ResponseUtil.printl(response, json, "json");
			}else{
				ResponseUtil.printl(response, "{\"status\":0}", "json");
			}
		 }catch(Exception e){
			 e.printStackTrace();
				ResponseUtil.printl(response, "{\"status\":1}", "json");
			 
		 } 
	 }
}