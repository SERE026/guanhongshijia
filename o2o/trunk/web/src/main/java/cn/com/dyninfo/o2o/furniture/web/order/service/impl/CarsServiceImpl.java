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

package cn.com.dyninfo.o2o.furniture.web.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.CookTool;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.active.dao.GameActiveDAO;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.dao.GoodsDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.order.dao.CarsDAO;
import cn.com.dyninfo.o2o.furniture.web.order.model.Cars;
import cn.com.dyninfo.o2o.furniture.web.order.model.CarsBox;
import cn.com.dyninfo.o2o.furniture.web.order.service.CarsService;

@Service("carsService")
public class CarsServiceImpl extends BaseService implements CarsService {

	@Resource
	private CarsDAO carsDAO;
	
	@Resource
	private GoodsDAO goodsDAO;
	
	@Resource
	private GameActiveDAO gameActiveDAO;
	

	@Override
	public void initDao() {
		this.baseDao=carsDAO;
	}

	@Override
	public Map addGoods(Double Money,int num,int good_id,
			HttpServletResponse response,HttpServletRequest request,
			String specVal,String actId,Double actMoney) {
		Cars car=null;
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member==null){//如果当前没有用户登录 
			String data="";
			data=CookTool.getCookIEValue(Context.COOKIE_CARS_DATA,request);
//			System.out.println(data);
			data+=(data.length()>0?(":"):"")+good_id+"_"+Money+"_"+num+"_"
					+specVal+"_"+(actId.length()>0?actId+"|"+actMoney:"|");
			Map<String,Map> map=new HashMap<String,Map>();
			String data_values[]=data.split(":");
			for(String data_value:data_values){
				String d[]=data_value.split("_");
				if(d.length==5){
					if(d[4].length()>1&&!ischeckAct(d[4].split("\\|")[0])){
						d[4]="|";
					}
					if(map.get(d[0]+d[3]+d[4])!=null){
						Map rmap=(Map) map.get(d[0]+d[3]+d[4]);
						Double rprice=(Double) rmap.get("price");
						int rnum=(Integer)rmap.get("num");
						Double xprice=Double.parseDouble(d[1]);
						int xnum=Integer.parseInt(d[2]);
						Map<String,Object> val=new HashMap<String,Object>();
						val.put("good_id", d[0]);
						val.put("num", rnum+xnum);
						val.put("specVal",d[3]);
						if(xprice<rprice){
							val.put("price", xprice);
						}else{
							val.put("price", rprice);
						}
						val.put("act", d[4]);
						map.put(d[0]+d[3]+d[4], val);
					}else{
						Double xprice=Double.parseDouble(d[1]);
						int xnum=Integer.parseInt(d[2]);
						Map<String,Object> val=new HashMap<String,Object>();
						val.put("good_id", d[0]);
						val.put("num", xnum);
						val.put("specVal",d[3]);
						val.put("price", xprice);
						val.put("act", d[4]);
						map.put(d[0]+d[3]+d[4], val);
					}
				}
			}
			data="";
			for(Map m:map.values()){
				data+=(data.length()>0?(":"):"")+m.get("good_id")+"_"
			+m.get("price")+"_"+m.get("num")+"_"+m.get("specVal")+"_"
						+m.get("act");;
			}
			CookTool.addCookValue(Context.COOKIE_CARS_DATA, data, response);
			return null;
		}else{//如果当前有用户登录
			return carsDAO.addGoods(Money, num, good_id, specVal, member.getHuiYuan_id(),(actId.length()>0?actId+"|"+actMoney:"|"));
			 
		}
	}
	@Override
	public Map addGoodsApp(Double Money,int num,int good_id,String specVal,int huiYuan_id,String actInfo) {
			return carsDAO.addGoodsApp(Money, num, good_id, specVal,huiYuan_id,actInfo);
	}
	/**
	 * 检查活动有效性
	 * @param act_id
	 * @return
	 */
	public boolean  ischeckAct(String act_id){
		Active act=(Active) gameActiveDAO.getObjById(act_id);
		long t=new Date().getTime()/1000;
		if(act.getStatus()==0&&act.getBtimel()<t&&act.getEtimel()>t){
			return true;
		}
		return false;
	}
	
	
	@Override
	public List getGoods(HttpServletRequest request) {
		Cars car=null;
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		Map shopMap=new HashMap();
		if(member==null){//如果当前没有用户登录 
			String data="";
			data=CookTool.getCookIEValue(Context.COOKIE_CARS_DATA,request);
			String data_values[]=data.split(":");
			int item=0;
			for(String data_value:data_values){
				String d[]=data_value.split("_");
				if(d.length==5){
					//货品ID;货品价格;货品数量;规则[规则使用|分隔]:货品ID;货品价格;货品数量;库存;规则;活动
					Map map=getGoodsMap(Integer.parseInt(d[0]),Double.parseDouble(d[1]),Integer.parseInt(d[2]),d[3],d[4]);
					if(map!=null){
						map.put("type", "ck");
						map.put("specVal",d[3]);
						map.put("actInfo",d[4]);
						if(shopMap.get(map.get("shop_id"))!=null){
							List goodlist=(List) shopMap.get("shop_id");
							goodlist.add(map);
							shopMap.put(map.get("shop_id"), goodlist);
						}else{
							List goodlist=new ArrayList();
							goodlist.add(map);
							shopMap.put(map.get("shop_id"), goodlist);
						}
					}
				}
				item++;
			}
		}else{
			List<Map> carlist=this.carsDAO.getCar(member.getHuiYuan_id());
			for(Map map:carlist){
				//货品ID;货品价格;货品数量;规则[规则使用|分隔]:货品ID;货品价格;货品数量;库存;规则
				Map goodmap=getGoodsMap((Integer)map.get("good_id"),(Double)map.get("price"),(Integer)map.get("num"),(String)map.get("specVal"),(String)map.get("actInfo"));
				if(goodmap!=null){
					goodmap.put("id", map.get("CARS_BOX_ID"));
					goodmap.put("type", "sl");
					goodmap.put("specVal", map.get("specVal"));
					goodmap.put("actInfo",map.get("actInfo"));
					if(shopMap.get(goodmap.get("shop_id"))!=null){
						List goodlist=(List) shopMap.get(goodmap.get("shop_id"));
						goodlist.add(goodmap);
						shopMap.put(goodmap.get("shop_id"), goodlist);
					}else{
						List goodlist=new ArrayList();
						goodlist.add(goodmap);
						shopMap.put(goodmap.get("shop_id"), goodlist);
					}
				}
			}
		}
		List list=new ArrayList();
		Iterator it=shopMap.keySet().iterator();
		while(it.hasNext()){
			Map m=new HashMap();
			List<Map> l=(List) shopMap.get(it.next());
			
			m.put("shopName",  l.get(0).get("shop_Name"));
			m.put("shopId", l.get(0).get("shop_id"));
			m.put("list", l);
			list.add(m);
		}
		return list;
	}

	private Map getGoodsMap(int goods_id,Double price,int num,String specVal,String actInfo){
		//货品ID;货品价格;货品数量;规则[规则使用|分隔]:货品ID;货品价格;货品数量;规则
		Goods good=(Goods) goodsDAO.getObjById(""+goods_id);
		if(good!=null){
			if(actInfo!=null&&actInfo.split("\\|").length>1&&this.ischeckAct(actInfo.split("\\|")[0])){
				
				good.setActionId(actInfo.split("\\|")[0]);
				System.out.println();
				good.setActionMoney(Double.parseDouble(actInfo.split("\\|")[1]));
				if(actInfo.split("\\|").length>2)
					good.setActFlag(1);
				else
					good.setActFlag(0);
			}else{
				//goodsDAO.getGoodsPrice(good);
			}
			if(good.getShelves().equals("0")){
				Map goodMap=new HashMap();
				
				goodMap.put("shop_id", good.getMerchants().getShangjia_id());
				goodMap.put("shop_Name", good.getMerchants().getName());
				goodMap.put("good_id", goods_id);
				goodMap.put("id", goods_id);
				goodMap.put("yprice",price);
				goodMap.put("num",num);
				goodMap.put("inventory",good.getInventory());
				goodMap.put("goodName",good.getName());
				goodMap.put("image",good.getDefaultImage());
				List<Map> speclist=goodsDAO.getGoodsSpec(goods_id, specVal);
				Double specPrice=0.0;
				for(Map s:speclist){
					specPrice+=(Double)s.get("v_sales");
				}
				goodMap.put("price", good.getSalesMoney());
				goodMap.put("actMoney", good.getActionMoney());
				goodMap.put("actId", good.getActionId());
				goodMap.put("specMoney", specPrice);
				goodMap.put("spec", speclist);
				goodMap.put("actFlag", good.getActFlag());
				return goodMap;
			}
		}
		return null;
	}

	@Override
	public void delCar(List<HashMap> delVal,HttpServletResponse response,
			HttpServletRequest request) {
		
			String data="";
			
			data=CookTool.getCookIEValue(Context.COOKIE_CARS_DATA,request);
			Map<String,Map> map=new HashMap<String,Map>();
			String data_values[]=data.split(":");
			for(String data_value:data_values){
				
				String d[]=data_value.split("_");
				if(d.length==5){
					if(map.get(d[0]+d[3]+d[4])!=null){
						Map rmap=(Map) map.get(d[0]+d[3]+d[4]);
						Double rprice=(Double) rmap.get("price");
						int rnum=(Integer)rmap.get("num");
						Double xprice=Double.parseDouble(d[1]);
						int xnum=Integer.parseInt(d[2]);
						
						Map<String,Object> val=new HashMap<String,Object>();
						val.put("good_id", d[0]);
						val.put("num", rnum+xnum);
						val.put("specVal",d[3]);
						val.put("act",d[4]);
						if(xprice<rprice){
							val.put("price", xprice);
						}else{
							val.put("price", rprice);
						}
						map.put(d[0]+d[3], val);
					}else{
						Double xprice=Double.parseDouble(d[1]);
						int xnum=Integer.parseInt(d[2]);
						Map<String,Object> val=new HashMap<String,Object>();
						val.put("good_id", d[0]);
						val.put("num", xnum);
						val.put("specVal",d[3]);
						val.put("price", xprice);
						val.put("act", d[4]);
						map.put(d[0]+d[3]+d[4], val);
					}
				}
			}
			data="";
			for(HashMap m:delVal){
				if(m.get("type").equals("ck")){
					map.remove(m.get("val"));
				}else{
					this.carsDAO.delCar((String)m.get("val"));
				}
			}
			for(Map m:map.values()){
				data+=(data.length()>0?(":"):"")+m.get("good_id")+"_"+m.get("price")+"_"+m.get("num")+"_"+m.get("specVal")+"_"+m.get("act");
			}
			CookTool.addCookValue(Context.COOKIE_CARS_DATA, data, response);
		
	}

	@Override
	public void checkCar(HttpServletResponse response,HttpServletRequest request) {
		String data="";
		
		data=CookTool.getCookIEValue(Context.COOKIE_CARS_DATA,request);
		Map<String,Map> map=new HashMap<String,Map>();
		String data_values[]=data.split(":");
		for(String data_value:data_values){
			String d[]=data_value.split("_");
			if(d.length==5){
				if(map.get(d[0]+d[3]+d[4])!=null){
					Map rmap=(Map) map.get(d[0]+d[3]+d[4]);
					Double rprice=(Double) rmap.get("price");
					int rnum=(Integer)rmap.get("num");
					Double xprice=Double.parseDouble(d[1]);
					int xnum=Integer.parseInt(d[2]);
					
					Map<String,Object> val=new HashMap<String,Object>();
					val.put("good_id", d[0]);
					val.put("num", rnum+xnum);
					val.put("specVal",d[3]);
					val.put("act",d[4]);
					if(xprice<rprice){
						val.put("price", xprice);
					}else{
						val.put("price", rprice);
					}
					map.put(d[0]+d[3], val);
				}else{
					Double xprice=Double.parseDouble(d[1]);
					int xnum=Integer.parseInt(d[2]);
					Map<String,Object> val=new HashMap<String,Object>();
					val.put("good_id", d[0]);
					val.put("num", xnum);
					val.put("specVal",d[3]);
					val.put("price", xprice);
					val.put("act", d[4]);
					map.put(d[0]+d[3]+d[4], val);
				}
			}
		}
		data="";
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		for(Map m:map.values()){
			carsDAO.addGoods(Double.parseDouble(m.get("price").toString()), Integer.parseInt(m.get("num").toString()),
					Integer.parseInt(m.get("good_id").toString()), m.get("specVal").toString(),member.getHuiYuan_id(),m.get("act").toString());
		}
		CookTool.addCookValue(Context.COOKIE_CARS_DATA, data, response);
		
	}

	@Override
	public void checkCarGoodSpec(HttpServletResponse response,
			HttpServletRequest request) {
		
		String data="";
		data=CookTool.getCookIEValue(Context.COOKIE_CARS_DATA,request);
		Map<String,Map> map=new HashMap<String,Map>();
		String data_values[]=data.split(":");
		for(String data_value:data_values){
			String d[]=data_value.split("_");
			if(d.length==5){
				if(map.get(d[0]+d[3]+d[4])!=null){
					Map rmap=(Map) map.get(d[0]+d[3]+d[4]);
					Double rprice=(Double) rmap.get("price");
					int rnum=(Integer)rmap.get("num");
					Double xprice=Double.parseDouble(d[1]);
					int xnum=Integer.parseInt(d[2]);
					
					Map<String,Object> val=new HashMap<String,Object>();
					val.put("good_id", d[0]);
					val.put("num", rnum+xnum);
					val.put("specVal",d[3]);
					val.put("act",d[4]);
					if(xprice<rprice){
						val.put("price", xprice);
					}else{
						val.put("price", rprice);
					}
					map.put(d[0]+d[3], val);
				}else{
					Double xprice=Double.parseDouble(d[1]);
					int xnum=Integer.parseInt(d[2]);
					Map<String,Object> val=new HashMap<String,Object>();
					val.put("good_id", d[0]);
					val.put("num", xnum);
					val.put("specVal",d[3]);
					val.put("price", xprice);
					val.put("act", d[4]);
					map.put(d[0]+d[3]+d[4], val);
				}
			}
		}
		data="";
		
		for(Map m:map.values()){
			data+=(data.length()>0?(":"):"")+m.get("good_id")+"_"+m.get("price")+"_"+m.get("num")+"_"+checkGoodSpecVal((String)m.get("good_id"),(String)m.get("specVal"))+"_"+m.get("act");;
		}
		CookTool.addCookValue(Context.COOKIE_CARS_DATA, data, response);
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member!=null){
			List<Map> carlist=this.carsDAO.getCar(member.getHuiYuan_id());
			for(Map m:carlist){
				String specVal=(String)m.get("specVal");
				Integer good_id=(Integer)m.get("good_id");
				String specValx=checkGoodSpecVal(""+good_id,specVal);
				if(!specVal.equals(specValx)){
					String id=(String) m.get("CARS_BOX_ID");
					CarsBox car=(CarsBox) carsDAO.getObjById(id);
					carsDAO.updateObj(car);
				}
			}	
		}
	}

	public String checkGoodSpecVal(String goodID,String specVal){
		return goodsDAO.checkGoodSpecVal(goodID,specVal);
	}

	@Override
	public String BuyGoods(Double Money, int num, int good_id,
			HttpServletResponse response, HttpServletRequest request,
			String specVal, String actId, Double actMoney) {
		HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
		return carsDAO.BuyGoods(Money, num, good_id, specVal, member.getHuiYuan_id(),(actId.length()>0?actId+"|"+actMoney:"|"));
	}
}
