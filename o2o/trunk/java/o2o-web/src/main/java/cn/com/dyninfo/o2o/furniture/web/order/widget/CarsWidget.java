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

package cn.com.dyninfo.o2o.furniture.web.order.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.CookTool;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.old.service.GameActiveService;
import cn.com.dyninfo.o2o.old.service.GameService;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.service.ProductService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.FavoritesService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.model.CarsBox;
import cn.com.dyninfo.o2o.old.service.CarsService;

@Component("carsWidget")
@Scope("prototype")
public class CarsWidget extends Widget{

	
	@Resource
	private CarsService carsService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private FavoritesService favoritesService;
	
	@Resource
	private PagModInGoodsService pagModInGoodsService;
	
	@Resource
	private GameService gameService;
	
	@Resource
	private GameActiveService gameActiveService;
	
	 @Resource
	 private HuiyuanService huiyuanService;
	@Override
	public void display(Map pamtr) {
		String errorMsg="";
		String action=pamtr.get("action")+"";
		/**
		 * 添加到购物车
		 */
		if(action.equals("add")){
			String huiYuan_id=(String) pamtr.get("huiYuan_id");
			if(huiYuan_id!=null){
				HuiyuanInfo member=(HuiyuanInfo)huiyuanService.getObjById(huiYuan_id);
				this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER, member);
			}
			String goos_id=(String) pamtr.get("g_id");
			String num=(String) pamtr.get("n");
			Goods good=goodsService.getGoodsPrice(Integer.parseInt(goos_id));
			if(good!=null&&good.getShelves().equals("0")){
				int buyNum=1;
				if(num!=null&&num.length()>0)
					buyNum=Integer.parseInt(num);
				String specVal="";
				String specs[]=HttpRequest.getParameterValues("spec");
				if(specs!=null){
					for(String s:specs){
						specVal=s+(specVal.length()>0?"|"+specVal:"");
					}
				}
				carsService.addGoods(good.getGoodMoney(),buyNum,good.getGoods_id(),this.HttpResponse,this.HttpRequest,specVal,"",0.0);
			}else{
				errorMsg="对不起！您购买的商品没找到或已经下架！";
			}
			if(pamtr.get("dataType")!=null&&pamtr.get("dataType").equals("json")){
				String json="";
				if(errorMsg.length()>0){
					json="{\"status\":1,\"msg\":\""+errorMsg+"\"}";
				}else{
					json="{\"status\":0}";
				}
				this.putData("json", json);
				this.setPageName("carsJson.html");
			}
		}else if(action.equals("del")){
			String carInfos[]=HttpRequest.getParameterValues("carInfo");
			String huiYuan_id=(String) pamtr.get("huiYuan_id");
			if(huiYuan_id!=null){
				HuiyuanInfo member=(HuiyuanInfo)huiyuanService.getObjById(huiYuan_id);
				this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER, member);
			}
			if(carInfos!=null){
				List<HashMap> list=new ArrayList<HashMap>();
				for(String carInfo:carInfos ){
					HashMap map=new HashMap();
					String carstrs[]=carInfo.split(":");
					map.put("type", carstrs[2]);
					if(carstrs[2].equals("ck")){
						map.put("val", carstrs[0]+carstrs[1]+carstrs[3]);
					}else{
						map.put("val", carstrs[0]);
					}
					list.add(map);
				}
				carsService.delCar(list,this.HttpResponse, this.HttpRequest);
			}else{
				errorMsg="没有选择商品";
			}
			
			String json="";
			if(errorMsg.length()>0){
				json="{\"status\":1,\"msg\":\""+errorMsg+"\"}";
			}else{
				json="{\"status\":0}";
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else if(action.equals("addFavorites")){
			String json="";
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(member==null){
				String forword=this.HttpRequest.getHeader("Referer");
				this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, forword);
				json="{\"status\":1,\"msg\":\""+errorMsg+"\",\"toPage\":\"login.html\"}";
			}else{
				String carInfos[]=HttpRequest.getParameterValues("carInfo");
				List<Map> favoriteslist=new ArrayList();
				if(carInfos!=null){
					List<HashMap> list=new ArrayList<HashMap>();
					for(String carInfo:carInfos ){
						HashMap map=new HashMap();
						String carstrs[]=carInfo.split(":");
						map.put("type", carstrs[2]);
						if(carstrs[2].equals("ck")){
							map.put("val", carstrs[0]+carstrs[1]+carstrs[3]);
						}else{
							map.put("val", carstrs[0]);
						}
						list.add(map);
						map.put("memberId", member.getHuiYuan_id());
						map.put("good_id",carstrs[4]);
						favoriteslist.add(map);
					}
					
					carsService.delCar(list,this.HttpResponse, this.HttpRequest);
				}
				favoritesService.addGoods(favoriteslist);
				json="{\"status\":0}";
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else if(action.equals("Shopadd")){
			String g_id=(String) pamtr.get("g_id");
			Goods good=(Goods) goodsService.getObjById(g_id);
			String sepcVal=carsService.checkGoodSpecVal(g_id, "");
			String num=(String) pamtr.get("num");
			if(num==null||num.length()==0)
				num="1";
			
			carsService.addGoods(good.getGoodMoney(),Integer.parseInt(num),good.getGoods_id(),this.HttpResponse,this.HttpRequest,sepcVal,"",0.0);
			String json="";
			if(errorMsg.length()>0){
				json="{\"status\":1,\"msg\":\""+errorMsg+"\"}";
			}else{
				json="{\"status\":0}";
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else if(action.equals("Actadd")){
			
			String g_id=(String) pamtr.get("g_id");
			String a_id=(String) pamtr.get("a_id");
			Active a=(Active) gameActiveService.getObjById(a_id);
			Double m=0.0;
			Goods good=(Goods) goodsService.getObjById(g_id);
			
			if(a.getType().equals("1")){
				m=a.getVal();
			}else if(a.getType().equals("2")){
				m=good.getSalesMoney()*(10-a.getVal())/10;
			}
			
			String sepcVal=carsService.checkGoodSpecVal(g_id, "");
			String num=(String) pamtr.get("num");
			if(num==null||num.length()==0)
				num="1";
			carsService.addGoods(good.getGoodMoney(),Integer.parseInt(num),good.getGoods_id(),this.HttpResponse,this.HttpRequest,sepcVal,a_id+"|"+m,0.0);
			String json="";
			if(errorMsg.length()>0){
				json="{\"status\":1,\"msg\":\""+errorMsg+"\"}";
			}else{
				json="{\"status\":0}";
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else if(action.equals("gameadd")){
			String data=(String) pamtr.get("data");
			String g_id=data.split("-")[1];
			String a_id=data.split("-")[0];
			ActiveMemberInfo actMember=(ActiveMemberInfo) this.HttpRequest.getSession().getAttribute("act"+a_id);
			if(actMember!=null){
				Double m=actMember.getMoney();
				Goods good=(Goods) goodsService.getObjById(g_id);
				String sepcVal=carsService.checkGoodSpecVal(g_id, "");
				String num=(String) pamtr.get("num");
				if(num==null||num.length()==0)
					num="1";
				carsService.addGoods(good.getGoodMoney(),Integer.parseInt(num),good.getGoods_id(),this.HttpResponse,this.HttpRequest,sepcVal,a_id+"|"+m+"|"+actMember.getAct_meb_id(),m);
			}else{
				errorMsg="未找到游戏信息！";
			}
			if(errorMsg.length()>0){
				json="{\"status\":1,\"msg\":\""+errorMsg+"\"}";
			}else{
				json="{\"status\":0}";
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else if(action.equals("Buyadd")){
			json="{\"status\":0}";
			String goos_id=(String) pamtr.get("g_id");
			String num=(String) pamtr.get("n");
			Goods good=goodsService.getGoodsPrice(Integer.parseInt(goos_id));
			if(good!=null&&good.getShelves().equals("0")){
				int buyNum=1;
				if(num!=null&&num.length()>0)
					buyNum=Integer.parseInt(num);
				String specVal="";
				String specs[]=HttpRequest.getParameterValues("spec");
				if(specs!=null){
					for(String s:specs){
						specVal=s+(specVal.length()>0?"|"+specVal:"");
					}
//					System.out.println("specVal" + specVal);
				}
				
				String buyid=carsService.BuyGoods(good.getGoodMoney(),1,good.getGoods_id(),this.HttpResponse,this.HttpRequest,specVal,"",0.0);
				CarsBox info=(CarsBox) carsService.getObjById(buyid);
				String json="{";
						 json+="\"dataId\":\""+info.getCars_box_id()+"\",";
						 json+="\"dataType\":\"sl\",";
						 json+="\"specVal\":\""+info.getSpecVal()+"\",";
						 json+="\"actInfo\":\""+info.getActInfo()+"\",";
						 json+="\"g_id\":\""+info.getGoods().getGoods_id()+"\",";
						 json+="\"num\":\""+info.getNum()+"\",";
						 json+="\"status\":1}";
						 this.putData("json", json);
						 this.setPageName("carsJson.html");
				return ;
			}
			this.putData("json", json);
			this.setPageName("carsJson.html");
		}else{
			carsService.checkCarGoodSpec(this.HttpResponse,this.HttpRequest);
			//检查购物车元素
			
			List list=this.carsService.getGoods(this.HttpRequest);
			AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String clientID="";
			Map map=new HashMap();
			HuiyuanInfo huiyuan=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(huiyuan==null){
				clientID=CookTool.getCookIEValue(Context.COOKIE_CLIENT_ID,HttpRequest);
			}else{
				clientID=""+huiyuan.getHuiYuan_id();
			}
			map.put("clientID", clientID);
			List<Goods> showList=pagModInGoodsService.getGoods(32, arear!=null?arear.getId():null, 101, page, map);
			this.putData("data", list);
			this.putData("showList", showList);
			if(showList.size()>0){
				Goods info=showList.get(0);
//				System.out.println(info.getName());
				map.put("goodSort_id", ""+showList.get(0).getGoodsSort().getGoodsSort_id());
				List<Goods> Sortlist=pagModInGoodsService.getGoods(31, arear!=null?arear.getId():null, 0, page, map);
				this.putData("recommendList", Sortlist);
			}
			
			
			
		}
		
	}

	
}
