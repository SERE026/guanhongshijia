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

import cn.com.dyninfo.o2o.furniture.admin.model.Coupon;
import cn.com.dyninfo.o2o.furniture.admin.model.CouponMemberRel;
import cn.com.dyninfo.o2o.furniture.admin.model.CouponOrderRel;
import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponOrderRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.TradeUtil;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.active.dao.GameActiveDAO;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.dao.GoodsDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.dao.GoodsDeliveryDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsDelivery;
import cn.com.dyninfo.o2o.furniture.web.member.dao.AddressMemberDAO;
import cn.com.dyninfo.o2o.furniture.web.member.dao.HuiyuanDao;
import cn.com.dyninfo.o2o.furniture.web.member.dao.HuiyuanMoneyDAO;
import cn.com.dyninfo.o2o.furniture.web.member.model.AddressMember;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.Loginfo;
import cn.com.dyninfo.o2o.furniture.web.order.dao.CarsDAO;
import cn.com.dyninfo.o2o.furniture.web.order.dao.OrderDao;
import cn.com.dyninfo.o2o.furniture.web.order.model.CarsBox;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.MerchantMoneyDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.dao.ShangJiaDao;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.score.dao.JfaddDao;
import cn.com.dyninfo.o2o.furniture.web.score.dao.JffaDao;
import cn.com.dyninfo.o2o.furniture.web.score.model.Jfadd;
import cn.com.dyninfo.o2o.furniture.web.score.model.Jffa;
import cn.com.dyninfo.o2o.furniture.web.setting.dao.ZffsDao;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.wuliu.dao.DlytypeDao;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("orderService")
public class OrderServiceImpl extends BaseService implements OrderService{

	    @Resource
	    private OrderDao orderDao;
	    
	    @Resource
		private CarsDAO carsDAO;
	    
	    @Resource
		private GoodsDAO goodsDAO;
	    
	    @Resource
		private GameActiveDAO gameActiveDAO;
	    
	    @Resource
	    private DlytypeDao dlytypeDao;
	    
		@Resource
		private GoodsDeliveryDAO goodsDeliveryDAO;
	    
		@Resource
		private AddressMemberDAO addressMemberDAO;
		
		@Resource
		private ShangJiaDao shangJiaDao;
		
		@Resource
		private ZffsDao zffsDao;
		
		@Resource
		private JfaddDao jfaddDao;
		
		@Resource
		private JffaDao jffaDao;
		
		@Resource
		private HuiyuanDao huiyuanDao;
		
		@Resource
		private MerchantMoneyDAO merchantMoneyDAO;
		
		@Resource
		private HuiyuanMoneyDAO huiyuanMoneyDAO;

		@Resource
		private CouponMemberRelService couponMemberRelService;

		@Resource
		private CouponOrderRelService couponOrderRelService;

		@Resource
		private CouponService couponService;

	    @Override
	    public void initDao(){
	    	super.initDao();
	    	this.baseDao=orderDao;
	    }
	    
		@Override
		public List getOrderConfirm(HttpServletRequest request) {
			
			String carInfos[]=request.getParameterValues("carInfo");
			Map  shopMap=new HashMap();
			long t=new Date().getTime()/1000;
			if(carInfos!=null){
				for(String carInfo:carInfos){
					String carstrs[]=carInfo.split(":");
					CarsBox car=(CarsBox) carsDAO.getObjById(carstrs[0]);
					car.setNum(Integer.parseInt(carstrs[4]));
					
					carsDAO.updateObj(car);
					
					String actInfo=car.getActInfo();
//					System.out.print(actInfo);
					Goods good=car.getGoods();
					if(shopMap.get(good.getMerchants().getShangjia_id())!=null){
						
						List list=(List) shopMap.get(good.getMerchants().getShangjia_id());
						if(actInfo.length()>1){
							String act[]=actInfo.split("\\|");
							Active a=(Active) gameActiveDAO.getObjById(act[0]);
							if(a.getStatus()==0&&a.getBtimel()<t&&a.getEtimel()>t){
								
								good.setAct(a);
								good.setActionId(""+a.getActive_id());
								good.setActionMoney(Double.parseDouble(act[1]));
								
								
								good.setSpec(goodsDAO.getGoodsSpec(good.getGoods_id(), carstrs[2]));
							}else{
								goodsDAO.getGoodsPrice(good);
							}
						}else{
							goodsDAO.getGoodsPrice(good);
						}
						Map  goodMap=new HashMap();
						goodMap.put("shop_id", good.getMerchants().getShangjia_id());
						goodMap.put("shop_Name", good.getMerchants().getName());
						goodMap.put("good_id", good.getGoods_id());
						goodMap.put("id",car.getCars_box_id());
						goodMap.put("num",car.getNum());
						goodMap.put("goodName",good.getName());
						goodMap.put("deliverFlag", good.getDelivery().getDeliveryFlag());
						goodMap.put("image",good.getDefaultImage());
						List<Map> speclist=goodsDAO.getGoodsSpec(good.getGoods_id(), car.getSpecVal());
						Double specPrice=0.0;
						for(Map s:speclist){
							specPrice+=(Double)s.get("v_sales");
						}
						goodMap.put("price", good.getSalesMoney());
						goodMap.put("actMoney", good.getActionMoney());
						goodMap.put("actId", good.getActionId());
						goodMap.put("act", good.getAct());
						goodMap.put("specMoney", specPrice);
						goodMap.put("spec", speclist);
						list.add(goodMap);
						shopMap.put(good.getMerchants().getShangjia_id(), list);
					}else{
						List list=new ArrayList();
						if(actInfo.length()>1){
							String act[]=actInfo.split("\\|");
							Active a=(Active) gameActiveDAO.getObjById(act[0]);
							if(a.getStatus()==0&&a.getBtimel()<t&&a.getEtimel()>t){
								good.setAct(a);
								good.setActionId(""+a.getActive_id());
								good.setActionMoney(Double.parseDouble(act[1]));
								//car.setActInfo("|");
								//carsDAO.updateObj(car);
							}else{
								goodsDAO.getGoodsPrice(good);
								
							}
						}else{
							goodsDAO.getGoodsPrice(good);
						}
						Map  goodMap=new HashMap();
						goodMap.put("shop_id", good.getMerchants().getShangjia_id());
						goodMap.put("shop_Name", good.getMerchants().getName());
						goodMap.put("good_id", good.getGoods_id());
						goodMap.put("deliverFlag", good.getDelivery().getDeliveryFlag());
						goodMap.put("id",car.getCars_box_id());
						goodMap.put("num",car.getNum());
						goodMap.put("goodName",good.getName());
						goodMap.put("image",good.getDefaultImage());
						List<Map> speclist=goodsDAO.getGoodsSpec(good.getGoods_id(), car.getSpecVal());
						Double specPrice=0.0;
						for(Map s:speclist){
							specPrice+=(Double)s.get("v_sales");
						}
						goodMap.put("price", good.getSalesMoney());
						goodMap.put("actMoney", good.getActionMoney());
						goodMap.put("actId", good.getActionId());
						goodMap.put("act", good.getAct());
						goodMap.put("specMoney", specPrice);
						goodMap.put("spec", speclist);
						list.add(goodMap);
						shopMap.put(good.getMerchants().getShangjia_id(), list);
					}
					
				}
				
			}
			List list=new ArrayList();
			Iterator it=shopMap.keySet().iterator();
			while(it.hasNext()){
				Map m=new HashMap();
				List<Map> l=(List) shopMap.get(it.next());
				m.put("shop_id", l.get(0).get("shop_id"));
				m.put("shop_Name", l.get(0).get("shop_Name"));
				m.put("list", l);
				list.add(m);
			}
			return list;
		}
		
		
		
		@Override
		public List getOrderConfirm(String memberId,String carId[]) {
			StringBuffer ids=new StringBuffer();
			if(carId!=null){
				for(String id:carId){
					ids.append(" '"+id+"' ,");
				}
				
				if(carId.length>0){
					ids.deleteCharAt(ids.length()-1);
					
				}
			}
			
			
			List<CarsBox> carsData=(List<CarsBox>) carsDAO.getListByWhere(
					new StringBuffer(" and n.member.id="+memberId +
							" and n.cars_box_id in ("+ids+")"));
			Map  shopMap=new HashMap();
			long t=new Date().getTime()/1000;
			if(carsData.size()>0){
				for(CarsBox carInfo:carsData){
					CarsBox car=carInfo;
					
					carsDAO.updateObj(car);
					
					String actInfo=car.getActInfo();
					Goods good=car.getGoods();
					if(shopMap.get(good.getMerchants().getShangjia_id())!=null){
						
						List list=(List) shopMap.get(good.getMerchants().getShangjia_id());
						if(actInfo.length()>1){
							String act[]=actInfo.split("\\|");
							Active a=(Active) gameActiveDAO.getObjById(act[0]);
							if(a.getStatus()==0&&a.getBtimel()<t&&a.getEtimel()>t){
								
								good.setAct(a);
								good.setActionId(""+a.getActive_id());
								good.setActionMoney(Double.parseDouble(act[1]));
								
								
								good.setSpec(goodsDAO.getGoodsSpec(good.getGoods_id(), carInfo.getSpecVal()));
							}else{
								goodsDAO.getGoodsPrice(good);
							}
						}else{
							goodsDAO.getGoodsPrice(good);
						}
						Map  goodMap=new HashMap();
						goodMap.put("shop_id", good.getMerchants().getShangjia_id());
						goodMap.put("shop_Name", good.getMerchants().getName());
						goodMap.put("good_id", good.getGoods_id());
						goodMap.put("id",car.getCars_box_id());
						goodMap.put("num",car.getNum());
						goodMap.put("goodName",good.getName());
						goodMap.put("deliverFlag", good.getDelivery().getDeliveryFlag());
						goodMap.put("image",good.getDefaultImage());
						List<Map> speclist=goodsDAO.getGoodsSpec(good.getGoods_id(), car.getSpecVal());
						Double specPrice=0.0;
						for(Map s:speclist){
							specPrice+=(Double)s.get("v_sales");
						}
						goodMap.put("price", good.getSalesMoney());
						goodMap.put("actMoney", good.getActionMoney());
						goodMap.put("actId", good.getActionId());
						goodMap.put("act", good.getAct());
						goodMap.put("specMoney", specPrice);
						goodMap.put("spec", speclist);
						list.add(goodMap);
						shopMap.put(good.getMerchants().getShangjia_id(), list);
					}else{
						List list=new ArrayList();
						if(actInfo.length()>1){
							String act[]=actInfo.split("\\|");
							Active a=(Active) gameActiveDAO.getObjById(act[0]);
							if(a.getStatus()==0&&a.getBtimel()<t&&a.getEtimel()>t){
								good.setAct(a);
								good.setActionId(""+a.getActive_id());
								good.setActionMoney(Double.parseDouble(act[1]));
								//car.setActInfo("|");
								//carsDAO.updateObj(car);
							}else{
								goodsDAO.getGoodsPrice(good);
								
							}
						}else{
							goodsDAO.getGoodsPrice(good);
						}
						Map  goodMap=new HashMap();
						goodMap.put("shop_id", good.getMerchants().getShangjia_id());
						goodMap.put("shop_Name", good.getMerchants().getName());
						goodMap.put("good_id", good.getGoods_id());
						goodMap.put("deliverFlag", good.getDelivery().getDeliveryFlag());
						goodMap.put("id",car.getCars_box_id());
						goodMap.put("num",car.getNum());
						goodMap.put("goodName",good.getName());
						goodMap.put("image",good.getDefaultImage());
						List<Map> speclist=goodsDAO.getGoodsSpec(good.getGoods_id(), car.getSpecVal());
						Double specPrice=0.0;
						for(Map s:speclist){
							specPrice+=(Double)s.get("v_sales");
						}
						goodMap.put("price", good.getSalesMoney());
						goodMap.put("actMoney", good.getActionMoney());
						goodMap.put("actId", good.getActionId());
						goodMap.put("act", good.getAct());
						goodMap.put("specMoney", specPrice);
						goodMap.put("spec", speclist);
						list.add(goodMap);
						shopMap.put(good.getMerchants().getShangjia_id(), list);
					}
					
				}
				
			}
			List list=new ArrayList();
			Iterator it=shopMap.keySet().iterator();
			while(it.hasNext()){
				Map m=new HashMap();
				List<Map> l=(List) shopMap.get(it.next());
				m.put("shop_id", l.get(0).get("shop_id"));
				m.put("shop_Name", l.get(0).get("shop_Name"));
				m.put("list", l);
				list.add(m);
			}
			return list;
		}

		@Override
		public Map getDistribution(HttpServletRequest request) {
			Map data=new HashMap();
			List result=new ArrayList();
			Double money=0.0;
			String area_id=request.getParameter("area_id");
			AddressMember address=(AddressMember) addressMemberDAO.getObjById(area_id);
			if(address!=null){
				area_id=address.getCounty().getId();
			}
			
			
			String s_ds[]=request.getParameterValues("s_d");
			String shopId=s_ds[0].split(":")[1];
			boolean error=false;
			for(String s_d:s_ds){
				if(!s_d.split(":")[1].equals(shopId)){
					error=true;
				}
			}
			if(!error){
				Double widget=0.0;
				
				for(String s_d:s_ds){
					String d[]=s_d.split(":");
					if(d[1].equals(shopId)){
						CarsBox car=(CarsBox) carsDAO.getObjById(d[4]);
						int num=car.getNum();
						Goods good=car.getGoods();
						GoodsDelivery gd=good.getDelivery();
						if(gd.getDeliveryFlag()==null||gd.getDeliveryFlag().equals("2")||gd.getDeliveryFlag().equals("3")){
							widget+=good.getWeight()*num;
						}else if(gd.getDeliveryFlag().equals("1")){
							money+=gd.getDeliveryMoney();
						}
					}
				}
				
				if(widget>0){
					result=goodsDeliveryDAO.getDly(area_id,widget, shopId);
					data.put("status", "0");//支持配送
					data.put("data", result);
					if(result.size()==0){
						data.put("status", "1");//不支持配送
					}else{
						String dlyId=((Dlytype)result.get(0)).getDlytype_id()+"";
						Double price=goodsDeliveryDAO.getDeliveryMoney(widget, area_id, dlyId);
						data.put("dlyId", dlyId);
						data.put("money", price);
						money = price;
					}
				}else if(money!=null&&money==0){
					data.put("status", "2");//包邮
				}else if(money!=null&&money!=0){
					data.put("status", "3");//配送费
					data.put("money", money);//
				}else{
					data.put("status", "1");//不支持配送
				}
				data.put("money", money);//
			}
			return data;
		}
		
		@Override
		public Map getDistribution(String area_id,String s_ds[]) {
			Map data=new HashMap();
			List result=new ArrayList();
			Double money= 0.0;
			AddressMember address=(AddressMember) addressMemberDAO.getObjById(area_id);
			if(address!=null){
				area_id=address.getCounty().getId();
			}
			
			
			String shopId=s_ds[0].split(":")[1];
			data.put("shopId", shopId);
			boolean error=false;
			for(String s_d:s_ds){
				if(!s_d.split(":")[1].equals(shopId)){
					error=true;
				}
			}
			if(!error){
				Double widget=0.0;
				
				for(String s_d:s_ds){
					String d[]=s_d.split(":");
					if(d[1].equals(shopId)){
						CarsBox car=(CarsBox) carsDAO.getObjById(d[4]);
						int num=car.getNum();
						Goods good=car.getGoods();
						GoodsDelivery gd=good.getDelivery();
						if(gd.getDeliveryFlag()==null||gd.getDeliveryFlag().equals("2")||
								gd.getDeliveryFlag().equals("3")){
							widget+=good.getWeight()*num;
						}else if(gd.getDeliveryFlag().equals("1")){
							money+=gd.getDeliveryMoney();
						}
					}
				}
				
				if(widget>0){
					result=goodsDeliveryDAO.getDly(area_id,widget, shopId);
					data.put("status", "0");//支持配送
					data.put("data", result);
					data.put("money", money);//
					
					if(result.size()==0){
						data.put("status", "1");//不支持配送
					}else{
						String dlyId=((Dlytype)result.get(0)).getDlytype_id()+"";
						Double price=goodsDeliveryDAO.getDeliveryMoney(widget, area_id, dlyId);
						data.put("dlyId", dlyId);
						data.put("money", price);
						money = price;
					}
				}else if(money!=null&&money==0){
					data.put("status", "2");//包邮
				}else if(money!=null&&money!=0){
					data.put("status", "3");//配送费
					data.put("money", money);//
				}else{
					data.put("status", "1");//不支持配送
				}
				data.put("money", money);
			}
			return data;
		}
		
		@Override
		public Double getDistributionMoney(HttpServletRequest request) {
			List result=new ArrayList();
			Double price=0.0;
			String area_id=request.getParameter("area_id");
			AddressMember address=(AddressMember) addressMemberDAO.getObjById(area_id);
			if(address!=null){
				area_id=address.getCounty().getId();
			}
			String dly_id=request.getParameter("dly_id");
			String s_ds[]=request.getParameterValues("s_d");
			String shopId=s_ds[0].split(":")[1];
			boolean error=false;
			for(String s_d:s_ds){
				if(!s_d.split(":")[1].equals(shopId)){
					error=true;
				}
			}
			if(!error){
				
				Double widget=0.0;
				for(String s_d:s_ds){
					String d[]=s_d.split(":");
					if(d[1].equals(shopId)){
						CarsBox car=(CarsBox) carsDAO.getObjById(d[4]);
						int num=car.getNum();
						Goods good=car.getGoods();
						GoodsDelivery gd=good.getDelivery();
						if(gd.getDeliveryFlag()==null||gd.getDeliveryFlag().equals("2")){
							widget+=good.getWeight()*num;
						}else if(gd.getDeliveryFlag().equals("1")){
							price+=gd.getDeliveryMoney()*num;
						}
					}
				}
				if(widget>0){
					price+=goodsDeliveryDAO.getDeliveryMoney(widget, area_id, dly_id);
				}
			}
			return price;
		}

		@Override
		public Map getShopPrice(HttpServletRequest request) {
			List result=new ArrayList();
			Double dlyprice=0.0;//运费
			Double goodPrice=0.0;//商品费用
			Double actPrice=0.0;//活动优惠
			long t=new Date().getTime()/1000;
			String area_id=request.getParameter("area_id");
			AddressMember address=(AddressMember) addressMemberDAO.getObjById(area_id);
			if(address!=null){
				area_id=address.getCounty().getId();
			}
			String dly_id=request.getParameter("dly_id");
			String s_ds[]=request.getParameterValues("s_d");
			String shopId=s_ds[0].split(":")[1];
			boolean error=false;
			for(String s_d:s_ds){
				if(!s_d.split(":")[1].equals(shopId)){
					error=true;
				}
			}
			if(!error){
				
				Double widget=0.0;
				for(String s_d:s_ds){
					String d[]=s_d.split(":");
					if(d[1].equals(shopId)){
						CarsBox car=(CarsBox) carsDAO.getObjById(d[4]);
						int num=car.getNum();
						Goods good=car.getGoods();
						GoodsDelivery gd=good.getDelivery();
						if(gd.getDeliveryFlag()==null||gd.getDeliveryFlag().equals("2")){
							widget+=good.getWeight()*num;
						}else if(gd.getDeliveryFlag().equals("1")){
							dlyprice+=gd.getDeliveryMoney()*num;
						}
						/**
						 * 商品费用根据选择的属性值价格计算
						 */
						Double goodSales=good.getSalesMoney();
						String SpecVal[]=car.getSpecVal().split("\\|");
						for(String sv:SpecVal){
							goodSales+=goodsDAO.getGoodSpevMoney(sv);
						}
//						Double goodSales=car.getPrice();
						goodPrice+=goodSales*num;
						if(car.getActInfo().length()>1){
							Active act=(Active) gameActiveDAO.getObjById(car.getActInfo().split("\\|")[0]);
							if(t>act.getBtimel()&&t<act.getEtimel()){
								actPrice+=Double.parseDouble(car.getActInfo().split("\\|")[1]);
//								System.out.println("进来了了");
							}else{
								//goodsDAO.getGoodsPrice(good);
								actPrice+=good.getActionMoney();
							}
						}else{
						//	goodsDAO.getGoodsPrice(good);
						//	actPrice+=good.getActionMoney();
						}
					}
				}
				if(widget>0){
					Double dl=goodsDeliveryDAO.getDeliveryMoney(widget, area_id, dly_id);
					if(dl!=null){
						dlyprice+=dl;
					}
				}
			}
			Map map=new HashMap();
			map.put("dlyprice", dlyprice);
			map.put("goodPrice", goodPrice);
			map.put("actPrice", actPrice);
			return map;
		}

		@Override
		public boolean create(HttpServletRequest request) {
			try{
				
				List result=new ArrayList();
				Double total=0d;
				String tradeNo=TradeUtil.createTradeNumber();
				request.getSession().setAttribute(Context.SESSION_TRADENO, tradeNo);
				String receiveDate=request.getParameter("receiveDate");
				String dlyType=request.getParameter("dlyType");
				String accountStr=request.getParameter("account");
				String playType=request.getParameter("playType");
				Jfadd g_j=(Jfadd) jfaddDao.getObjById("1");//在归属商店购物时获得积分
				Jfadd p_j=(Jfadd) jfaddDao.getObjById("2");//在平台购物时获得积分
				Jffa  j_x=(Jffa) jffaDao.getObjById("1");
				String point=null;
						//request.getParameter("p");
				if(point==null||point.length()==0){
					point="0";
				}
				int curentPoint=Integer.parseInt(point);

				if(dlyType==null){
					return false;
				}

				if(dlyType==null){
					return false;
				}
				Zffs zfInfo=(Zffs) zffsDao.getObjById(playType);
				if(zfInfo==null){
					return false;
				}
				HuiyuanInfo member=(HuiyuanInfo) request.getSession().getAttribute(Context.SESSION_MEMBER);
				member=(HuiyuanInfo) huiyuanDao.getObjById(""+member.getHuiYuan_id());
				String area_id=request.getParameter("receiveId");//获取收货地址
				AddressMember address=null;
				if(dlyType.equals("1")){
					address=(AddressMember) addressMemberDAO.getObjById(area_id);
					if(address!=null){
						area_id=address.getCounty().getId();
					}
				}
				String shops[]=request.getParameterValues("shop");
				if(shops!=null&&member!=null){
					member=(HuiyuanInfo) huiyuanDao.getObjById(""+member.getHuiYuan_id());
					Double pointPrice=0.0;
					//
					System.out.println("shops number = "+shops.length+"--------");
					for(String shop:shops){
						
						long t=new Date().getTime()/1000;
						Double dlyprice=0.0;//运费
						Double goodPrice=0.0;//商品费用
						Double actPrice=0.0;//活动优惠
						Double protectPrice=0.0;//保价费用
						String p[]=shop.split("=");
						for(String ps : p){
							System.out.println("ps = "+ps+"--------");
						}
						String shopId=p[0];
						String dly_id=p[1];
						boolean error=false;
						Double widget=0.0;
						Order order=new Order();
						/**
						 * 判断是否存在商家
						 * shopId商家ID
						 * 
						 */
						ShangJiaInfo shopInfo=(ShangJiaInfo) shangJiaDao.getObjById(shopId);
						order.setHuiyuan(member);
						if(shopInfo!=null){//
							order.setMerchants(shopInfo);
							List opList=new ArrayList();
							int begin=2;//物流方式
							if(dlyType.equals("0"))//上门提货
								begin=1;
							for(int i=p.length-1;i>=0&&p[i].contains(":");i--){
								if(p[i].split(":").length <=1 || !p[i].split(":")[1].equals(shopId)){
									error=true;
								}
								if(!error){
									String d[]=p[i].split(":");
									if(d[1].equals(shopId)){
										CarsBox car=(CarsBox) carsDAO.getObjById(d[4]);
										if(car == null) return false;
										if(car.getMember().getHuiYuan_id()==member.getHuiYuan_id()){
											OrderProduct op=new OrderProduct();
											
											op.setOrder(order);
											int num=car.getNum();
											Goods good=car.getGoods();
											if(good.getInventory()<num)//如果产品库存数量小于购买数量，则购买失败
												return false;
											op.setNum(num);
											op.setProduct(good.getProduct());
											op.setWidget(good.getWeight()*num);
											GoodsDelivery gd=good.getDelivery();
											if(gd.getDeliveryFlag()==null||gd.getDeliveryFlag().equals("2")){
												widget+=good.getWeight()*num;
											}else if(gd.getDeliveryFlag().equals("1")){
												dlyprice+=gd.getDeliveryMoney()*num;
											}
											
											
											Double goodSales=good.getSalesMoney();
											if(car.getSpecVal() != null){
												String SpecVal[]=car.getSpecVal().split("\\|");
												for(String sv:SpecVal){
													goodSales+=goodsDAO.getGoodSpevMoney(sv);
												}
											}
											goodPrice+=goodSales*num;
											
											if(car.getActInfo().length()>1){
												Active act=(Active) gameActiveDAO.getObjById(car.getActInfo().split("\\|")[0]);
												if(t>act.getBtimel()&&t<act.getEtimel()){
													actPrice+=Double.parseDouble(car.getActInfo().split("\\|")[1]);
													if(car.getActInfo().split("\\|").length>2){
														ActiveMemberInfo ami=new ActiveMemberInfo ();
														ami.setAct_meb_id(Integer.parseInt(car.getActInfo().split("\\|")[2]));
														op.setAmi(ami);
													}
													op.setActMoney(actPrice);
													op.setAct(act);
												}else{
													//goodsDAO.getGoodsPrice(good);
													op.setActMoney(good.getActionMoney());
													op.setAct(good.getAct());
												}
											}else{
												//goodsDAO.getGoodsPrice(good);
												op.setActMoney(good.getActionMoney());
											}
											op.setGoodMoney(goodSales);
											opList.add(op);
											carsDAO.delObj(car);
										}
									}
								}else{
									continue;
								}
		
							}
							
							if(goodPrice == 0){//没有得到商品信息
								continue;
							}
							
							if(widget>0&&dlyType.equals("1")){
								Double dl=goodsDeliveryDAO.getDeliveryMoney(widget, area_id, dly_id);
								if(dl!=null){
									dlyprice=dl;
								}
							}
							
							if(dlyType.equals("0")){
								dlyprice=0.0;
							}

							order.setTradeNo(tradeNo);
							order.setPlayType(zfInfo);
							order.setDly(dlyType);
							order.setOrderProductList(opList);
							order.setCreatTime((int)t);
							if(dlyType.equals("1")){
								order.setProvince(address.getProvince());//省
								order.setCity(address.getCity());//市 
								order.setCounty(address.getCounty());//区县
								order.setAddress(address.getAddress());//地址
								order.setCode(address.getCode());//邮编
								order.setReceiveName(address.getReceiveName());//收货人
								order.setReceiveDate(receiveDate);//派送时间
								order.setReceivePhone(address.getReceivePhone());//收货手机
								order.setReceiveTel(address.getReceiveTel());//收货电话
								order.setEmail(address.getEmail());//收货人邮箱
							}
							//如果优先使用账户支付不为空，则优先使用账户支付
							if(accountStr!=null){
								order.setAccount(0);
							}

							//生成订单ID 生成规则  6位日期+3位当天会员订单数+6位会员id
							String date= new SimpleDateFormat("yyyyMMdd").format(new Date());
							String date1= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
							String ordercount=orderDao.getCountByWhere(new StringBuffer( "and n.time like '"+date1+"%' and n.huiyuan.huiYuan_id="+member.getHuiYuan_id()))+"";
							String huiyuanid=member.getHuiYuan_id()+"";
							if(ordercount.length()>=3){
								ordercount=ordercount.substring(0, 3);
							}else if(ordercount.length()==2){
								ordercount="0"+ordercount;
							}else if(ordercount.length()==1){
								ordercount="00"+ordercount;
							}

							int huiyuanint=huiyuanid.length();
							if(huiyuanint>=6){
								huiyuanid=huiyuanid.substring(0, 6);
							}else {
								for(int i=0;i<6-huiyuanint;i++){
									huiyuanid="0"+huiyuanid;
								}
							}
							String order_id =date+ordercount +huiyuanid;
							order.setOrder_id(order_id);
							//优惠卷使用
							boolean flag=false;
							String coupons=request.getParameter("coupons");
							//获取优惠卷ID    1=满立减  2=折扣
							String[] arr=coupons.split(",");
							Double constraintPrice=0.0;//优惠卷达到该金额才可使用
							Double maxAmouontPrice=0.0;//最大抵扣金额
							Double reducePrice=0.0;//满减使用，抵扣金额
							Double reducePrice2=0.0;//折扣使用，抵扣金额
							//	1.是否达到使用金额
							//	2.优惠券是否过期
							//	3.优惠券是否已经使用
							//	4.优惠券剩余数量是否大于使用数量
							List<CouponOrderRel> couponOrderRelList=new ArrayList<CouponOrderRel>();
							if (arr.length>0 && !ValidationUtil.isEmpty(coupons)){
								flag=true;
								for (int i = 0; i <arr.length; i++) { //
									List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and n.coupon.endTime > now() and  n.huiyuan="+ member.getHuiYuan_id()+" and  n.coupon.id="+ arr[i]));
									CouponMemberRel coupon1 =couponMemberRelList.get(0);
									if (arr.length>1){
										if (1==coupon1.getCoupon().getSameUse()){
										}else {
											return false;
										}
									}
									//计算出 优惠卷各金额
									if(coupon1.getCount()>0){  // && dates1.compareTo(dates2)<0
										constraintPrice+=coupon1.getCoupon().getConstraintValue();
										maxAmouontPrice+=coupon1.getCoupon().getMaxAmouont();
										if(1==coupon1.getCoupon().getType()){
											reducePrice+=coupon1.getCoupon().getReduceValue();//优惠金额
										}
										if(2==coupon1.getCoupon().getType() ){
											reducePrice2+=coupon1.getCoupon().getDiscountValue();//折扣率
										}
										//修改优惠券用户关联表
										coupon1.setCount(coupon1.getCount()-1);
										coupon1.setUsedCount(coupon1.getUsedCount()+1);
										couponMemberRelService.updateObj(coupon1);
										//新增订单优惠券使用记录
										CouponOrderRel couponOrderRel=	new CouponOrderRel();
										couponOrderRel.setCoupon(coupon1.getCoupon());
										couponOrderRel.setOrder(order);
										couponOrderRel.setCount(1);
										couponOrderRelList.add(couponOrderRel);
									}else{
										return false;
									}
								}
							}
							//添加订单 优惠券关联表
							order.setCouponOrderRel(couponOrderRelList);
							//扣减优惠金额  满立减
							if (constraintPrice<=goodPrice && maxAmouontPrice<=goodPrice && flag){
								goodPrice=goodPrice-reducePrice;   //先使用满立减
								goodPrice=goodPrice-goodPrice*reducePrice2; //再使用折扣券
							}else if (constraintPrice>goodPrice || maxAmouontPrice>goodPrice){
								return false;
							}
							order.setShippingPrice(dlyprice);
							order.setStatus("0");
							order.setOriginalPrice(goodPrice+dlyprice+protectPrice);
							order.setWeight(widget);
							order.setOrderPrice(order.getOriginalPrice() - actPrice);
							//减去游戏/活动的优惠
							order.setDiscountPrice(actPrice);
//							System.out.println("*-------"+order.getOriginalPrice());
//							System.out.println("*-------"+order.getOrderPrice());
//							System.out.println("0------"+pointPrice);
							//积分抵扣
							if(point!=null&&curentPoint>0){
								int h_p=curentPoint;//当前需要抵扣的积分
//								System.out.println("1------"+h_p);
								if(h_p>0 && member.getJf()>=h_p){
									pointPrice=h_p/j_x.getJffa_jfdk();//积分转换为钱
//									System.out.println("2------"+pointPrice);
//									System.out.println("3------"+order.getOrderPrice());
									if(pointPrice>order.getOriginalPrice()){//如果可以进行支付
										h_p=(int) Math.round(order.getOriginalPrice()*j_x.getJffa_jfdk());
									}
									pointPrice=h_p/j_x.getJffa_jfdk();
//									System.out.println("4------"+pointPrice);
									member.setJf(member.getJf()-h_p);
									huiyuanDao.updateObj(member);
									Loginfo log=new Loginfo();
									log.setHuiyuan(member);
									log.setJf(-h_p);
									log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
									log.setType("0");
									log.setExplain("购物消费积分："+h_p);
									huiyuanDao.addObj(log);
									curentPoint-=h_p;
								}
							}
//							System.out.println("5------"+pointPrice);
							//设置抵扣积分
							order.setPointPrice(pointPrice);
							order.setOrderPrice(order.getOrderPrice() - pointPrice);
							if(order.getOrderPrice() <= 0){//如果积分抵扣全额,则直接变更为已支付
								order.setIsPay("1");
								order.setState("1");
								//order.setOrderPrice(0.0);
								for(OrderProduct op : order.getOrderProductList()){
									Goods good = op.getProduct().getGood();
									good = (Goods)goodsDAO.getObjById(good.getGoods_id()+"");
									good.setNum(good.getNum()+op.getNum());
									goodsDAO.updateObj(good);
								}
							}
							
							order.setGoodsPrice(goodPrice-actPrice);
							order.setDlyType((Dlytype)dlytypeDao.getObjById(dly_id));
							total+=order.getOrderPrice();
							int g_j_add=0;//会员归属商家获得积分
							if(member.getShangJiaInfo()!=null&&order.getMerchants().getShangjia_id()==member.getShangJiaInfo().getShangjia_id()){
								g_j_add=(int)Math.round(order.getOrderPrice()*g_j.getJfadd_zjjf());
							}
							int p_j_add=(int)Math.round(order.getOrderPrice()*p_j.getJfadd_zjjf());//平台购物获得积分
							order.setPoint(g_j_add+p_j_add);
							


							this.addObj(order);
							pointPrice=0d;
						}
					}
				}else{
					return false;
				}
				if(request.getAttribute("isPhone")!=null){
					Trade trade=new Trade();
					trade.setHuiyuan(member);
					trade.setZffs(zfInfo);
					trade.setTrade_id(tradeNo);
					trade.setMoney(total);
					trade.setFlag(1);
					trade.setStatus(0);
					this.addObj(trade);
				}
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Override
		public List getordershow(int id,PageInfo page) {
			return  orderDao.getordershow(id,page);
		}

		@Override
		public HashMap<String, ?> getByPageWhere(StringBuffer where,PageInfo page,StringBuffer where2) {
			return orderDao.getByPageWhere(where, page,where2);
		}

		@Override
		public HashMap<String, ?> getBySqlSjhy(StringBuffer where, PageInfo page) {
			return orderDao.getBySqlSjhy(where, page);
		}
		
		@Override
		public HashMap<String, ?> getBySqlhyxfjl(StringBuffer where, PageInfo page) {
			return orderDao.getBySqlhyxfjl(where, page);
		}

		@Override
		public List getbaobei(int id, String name,PageInfo page) {
			return orderDao.getbaobei(id, name,page);
		}

		@Override
		public List getListByPage(StringBuffer where) {
			return orderDao.getListByPage(where);
		}

		//付款成功
		@Override
		public void updateOrderPlay(String tradeNo) {
			List<Order> list=this.getListByPage(new StringBuffer(" and n.tradeNo='"+tradeNo+"' "));
			String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			int t=(int)(new Date().getTime()/1000);
			for(Order info:list){
				if(info.getIsPay().equals("0")&&info.getStatus().equals("0")){
					info.setState("1");
					for(OrderProduct op : info.getOrderProductList()){
						Goods good = op.getProduct().getGood();
						good = (Goods)goodsDAO.getObjById(good.getGoods_id()+"");
						good.setNum(good.getNum()+op.getNum());
						goodsDAO.updateObj(good);
					}
					info.setIsPay("1");
					info.setPaytime(time);
					info.setIpaytime(t);
					HuiyuanInfo h=info.getHuiyuan();
					h.setJf(h.getJf()+info.getPoint());
					Loginfo log=new Loginfo();
					log.setHuiyuan(h);
					log.setJf(info.getPoint());
					log.setTime(time);
					log.setType("0");
					log.setExplain("购物赠送积分："+info.getPoint());
					this.huiyuanDao.addObj(log);
					this.huiyuanDao.updateObj(h);
					this.updateObj(info);
					
					//添加店铺流水信息
					merchantMoneyDAO.addOrderMoney(info);
					huiyuanMoneyDAO.addOder(info);
					orderDao.updateGoodsnum(info);
					
				}
			}
		}

		@Override
		public int getOrderShowCount(int id) {
			return orderDao.getOrderShowCount(id);
		}

		@Override
		public int getbaobeiCount(int id, String name) {
			return orderDao.getbaobeiCount(id, name);
		}

		@Override
		public void addTrade(Trade trade) {
			orderDao.addObj(trade);
			
		}

		@Override
		public Trade getTrade(String tradeNo) {
			// TODO Auto-generated method stub
			return orderDao.getTrade(tradeNo);
		}

		@Override
		public void updateTrade(Trade trade) {
			// TODO Auto-generated method stub
			orderDao.updateObj(trade);
		}

		@Override
		public Double getTradeMoney(String tradeNo) {
			// TODO Auto-generated method stub
			return orderDao.getTradeMoney(tradeNo);
		}

		@Override
		public List<?> getorderlist(StringBuffer where) {
			
			return orderDao.getorderlist(where);
		}

		}
