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

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSpec;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSpecVal;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;

/**
 * android 商品
 * @author feng
 *
 */
@Controller
@RequestMapping("/agoods")
public class AgoodsController{
    

	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
	
		@Resource
		private GoodsService goodsService;
		/*
		 * 会员换购
		 */
	 @RequestMapping("/hotlist")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		AreaInfo arear=(AreaInfo)areaService.getObjById(id);
		String pageno=request.getParameter("pageno");
	 	PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(pageno));
		page.setPageSize(10);
		List<Goods> list=pagModInGoodsService.getGoods(44, arear!=null?arear.getId():null, 102, page, null);
		if(list.size()>0){
		StringBuffer jsons=new StringBuffer("[");
		 String json="";
		 for(int i=0;i<list.size();i++){
			 Goods good=list.get(i);
			//计算出折扣
				String xmoney =  good.getSalesMoney().toString();
				Float xm = Float.valueOf(xmoney);
				String money =  good.getBazaarMoney().toString();
				Float m = Float.valueOf(money);
				float discount= (float)(Math.round(xm/m*100))/10;
				
				json+="{\"goodId\":\""+good.getGoods_id()+"\",\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+good.getDefaultImage()+"\",\"goodName\":\""+good.getName().replace(" ", "")+"\",\"bazaarMoney\":"+
				good.getBazaarMoney()+",\"shopid\":"+good.getMerchants().getShangjia_id()+",\"shopname\":"+good.getMerchants().getShangjia_id()+",\"salesMoney\":"+good.getSalesMoney()+",\"discount\":"+discount+"},";
		 }
		 if(json.length()>0&&json.charAt(json.length()-1)==','){
			   json=json.substring(0, json.length()-1);
		   }
			 jsons.append(json);
			 jsons.append("]");
			 String newJson="{\"status\":0,\"data\":"+jsons.toString()+"}";
			ResponseUtil.printl(response, newJson, "json");
			
		} else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
	 }
	 
	 
		/*
		 * 产品搜索
		 */
	 
	 @RequestMapping("/search")
	 public void search(HttpServletRequest request,HttpServletResponse response,
			 String key){
		String pageno=request.getParameter("pageno");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(pageno));
		page.setPageSize(10);
		 String city=request.getParameter("id");
		 String serchType=request.getParameter("serchType");
		 String sql="";
		 String oderBy="";
		 
		 if(city!=null&&city.length()>0){
				sql+=" and s.CITY_ID="+city;
			}
		 if(key!=null&&key.length()>0){
			 	try {
					key = new String(key.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				sql+=" and g.NAME like '%"+key+"%'";
			}
//		 System.out.println(key);
		 if(serchType!=null){
			 if(serchType.equals("0")){
				 oderBy+="0";
			 }else if(serchType.equals("1")){
				 oderBy+="1";
			 }else if(serchType.equals("2")){
				 oderBy+="2";
			 }else if(serchType.equals("3")){
				 oderBy+="3";
			 }
		 }
		
		 List list=pagModInGoodsService.getGoodBySlq(sql, page, oderBy,"40");
		 if(list.size()>0){
				String json="{\"status\":0,\"data\":[";
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i);
					//计算出折扣
					String xmoney =  map.get("money").toString();
					Float xm = Float.valueOf(xmoney);
					String money =  map.get("bmoney").toString();
					Float m = Float.valueOf(money);
					float discount= (float)(Math.round(xm/m*100))/10;
					
					json+="{\"goodId\":\""+map.get("GOODS_ID").toString()+"\",\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+map.get("IAMGE").toString()+"\",\"goodName\":\""+map.get("GOOD_NAME").toString().replace(" ", "")+"\",\"bazaarMoney\":"+
					map.get("bmoney").toString()
					+",\"shopid\":\""+map.get("shopid").toString()+"\""
					+",\"shopname\":\""+map.get("S_NAME").toString()+"\""
					+",\"salesMoney\":"+map.get("money").toString()
					+",\"discount\":"+discount+"},";
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
		 * 推荐的商品
		 */
	 
	 @RequestMapping("/recommend")
	 public void recommend(HttpServletRequest request,HttpServletResponse response){
		 	String id=request.getParameter("id");
			AreaInfo arear=(AreaInfo)areaService.getObjById(id);
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(5);
			String clientID="";
			Map map=new HashMap();
			List<Goods> list=pagModInGoodsService.getGoods(33, arear!=null?arear.getId():null, 0, page, null);
			 if(list.size()>0){
			StringBuffer jsons=new StringBuffer("[");
			 String json="";
			 for(int i=0;i<list.size();i++){
				 Goods good=list.get(i);
					//计算出折扣
					String xmoney =  good.getSalesMoney().toString();
					Float xm = Float.valueOf(xmoney);
					String money =  good.getBazaarMoney().toString();
					Float m = Float.valueOf(money);
					float discount= (float)(Math.round(xm/m*100))/10;
					
				 json+="{\"name\":\""+good.getName()+"\",\"imgUrl\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+good.getDefaultImage();
				 json+="\",\"discount\":"+discount+",\"shopid\":\""+good.getMerchants().getShangjia_id()+"\",\"shopname\":\""+good.getMerchants().getName()+"\",\"goods_id\":\""+good.getGoods_id()+"\",\"salesMoney\":"+good.getSalesMoney()+",\"bazaarMoney\":"+good.getBazaarMoney();
				   json+="},";
				}
			 if(json.length()>0&&json.charAt(json.length()-1)==','){
				   json=json.substring(0, json.length()-1);
			   }
			 jsons.append(json);
			 jsons.append("]");
			 String newJson="{\"status\":0,\"data\":"+jsons.toString()+"}";
				ResponseUtil.printl(response, newJson, "json");
				
		 } else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
	 }
	 
	 	/*
		 * 大家还买了
		 */
	 
	 @RequestMapping("/otherbuy")
	 public void otherbuy(HttpServletRequest request,HttpServletResponse response){
			String id=request.getParameter("id");
			AreaInfo arear=(AreaInfo)areaService.getObjById(id);
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(2);
			String clientID="";
			Map map=new HashMap();
			List<Goods> list=pagModInGoodsService.getGoods(42, arear!=null?arear.getId():null, 0, page, null);
			if(list.size()>0){ 
			StringBuffer jsons=new StringBuffer("[");
			 String json="";
			 for(int i=0;i<list.size();i++){
				 Goods good=list.get(i);
				 json+="{\"name\":\""+good.getName()+"\",\"imgUrl\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+good.getDefaultImage();
				 json+="\",\"shopname\":\""+good.getMerchants().getName()+"\",\"shopid\":\""+good.getMerchants().getShangjia_id()+"\",\"salesMoney\":\""+good.getSalesMoney()+"\",\"goods_id\":"+good.getGoods_id()+",\"bazaarMoney\":"+good.getBazaarMoney();
				   json+="},";
				}
			 if(json.length()>0&&json.charAt(json.length()-1)==','){
				   json=json.substring(0, json.length()-1);
			   }
			 jsons.append(json);
			 jsons.append("]");
			 String newJson="{\"status\":0,\"data\":"+jsons.toString()+"}";
				ResponseUtil.printl(response, newJson, "json");
				
	 } else{
		 ResponseUtil.printl(response, "{\"status\":1}", "json");
	 }
	 }
	 
	 	/*
		 * 商品参数 
		 */
	 
	 @RequestMapping("/spec")
	 public void spec(HttpServletRequest request,HttpServletResponse response){
		 String id=request.getParameter("id");
		 Goods goods =(Goods) goodsService.getObjById(id);
		 List<GoodsSpec> specList = goods.getSpecList();
		 int type=0;
		 if(goods!=null&&specList.size()>0){
			 String json="{\"status\":0,\"data\":[";
				 for(int i=0;i<specList.size();i++){
					 GoodsSpec goodsSpec=  specList.get(i);
						if( goodsSpec.getStatus()==0){
						type=1;//当所选的属性全部被删除的时候
						 json+="{\"name\":\""+goodsSpec.getName()+"\",\"specval\":[";
						 	List<GoodsSpecVal> valList=goodsSpec.getValList();
						 	for(int j=0;j<valList.size();j++){
						 		GoodsSpecVal val =  valList.get(j);
						 		 json+="{\"val\":\""+val.getVal()+"\",\"sales\":\""+(val.getSales()+goods.getSalesMoney())+"\",\"weight\":\""+val.getWeight();
						 		 json+="\",\"spec_val_id\":\""+val.getSpec_val_id()+"\"";
						 		 if(goodsSpec.getType().equals("1")){
						 			json+=",\"img\":\""+val.getImg();
						 		 }
						 		 json+="},";;
						 	}
							if(json.length()>1){
								json=json.substring(0,json.length()-1);
							}
							json+="]},";
						}
					}
					if(json.length()>1&&type==1){
						json=json.substring(0,json.length()-1);
					}
					json+="]}";
					ResponseUtil.printl(response, json, "json");	
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
 }