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

package cn.com.dyninfo.o2o.furniture.web.goods.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsDelivery;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Psarea;

@Repository("goodsDeliveryDAO")
public class GoodsDeliveryDAO extends BaseDAO {

	@Autowired
	public GoodsDeliveryDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="GoodsDelivery";
	}
	
	/**
	 * 根据产品ID和地区获取最低物流费用
	 * @param goods_id
	 * @param area_id
	 * @return
	 */
	public Double getGoodsDeliveryMoney(int goods_id, String area_id){
		Double result=0.0;
		Goods good=this.getHibernateTemplate().load(Goods.class, goods_id);
		GoodsDelivery  gd=good.getDelivery();
		if(gd.getDeliveryFlag() != null){
			if(gd.getDeliveryFlag().equals("0")){
				return 0.0;
			}else if(gd.getDeliveryFlag().equals("1")){
				return gd.getDeliveryMoney();
			}else if(gd.getDeliveryFlag().equals("2")){
				List<Dlytype> list=this.getHibernateTemplate().find(" from Dlytype n where n.stat=0 and n.stats=0 and n.merchants.shangjia_id="+good.getMerchants().getShangjia_id());
				return getDelivery(list,good.getWeight(),area_id);
			}else if(gd.getDeliveryFlag().equals("3")){
				return getDelivery(gd.getDlyList(),good.getWeight(),area_id);
			}
		}
		return result;
	}
	
	/**
	 * 对物流进行排序
	 * @param widget
	 * @param area_id
	 * @param shop_id
	 * @return
	 */
	public Double getDeliveryMoney(Double widget,String area_id,String dlyId){
		List<Dlytype> dlyList=this.getHibernateTemplate().find(" from Dlytype n where n.stat=0 and n.stats=0 and n.dlytype_id="+dlyId);
	
		return getDelivery(dlyList,widget,area_id);
	}
	
	/**
	 * 对物流进行排序
	 * @param widget
	 * @param area_id
	 * @param shop_id
	 * @return
	 */
	public List getDelivery(Double widget,String area_id,String shop_id){
		List<Dlytype> dlyList=this.getHibernateTemplate().find(" from Dlytype n where n.stat=0 and n.stats=0 and n.merchants.SHANGJIA_ID="+shop_id);
		List list=new ArrayList();
		for(int i=0;i<dlyList.size();){
			Dlytype dt=getDeliveryObj(dlyList,widget,area_id);
			if(dt!=null){
				list.add(dt);
				dlyList.remove(dt);
			}else{
				break;
			}
			
		}
		return list;
	}
	
	public List getDly(String areaId,Double widget,String shopId){
		String sql="from Dlytype as n where n.stat='0' and  n.merchants.shangjia_id="+shopId;
		List<Dlytype> list=this.getHibernateTemplate().find(sql);
		List result=new ArrayList();
		for(Dlytype dly:list){
			boolean isKy=false;
			for(Psarea p:dly.getPsarea()){
				if(p.getAreaid().indexOf(areaId)>=0){
					isKy=true;
				}
			}
			if(!isKy&&dly.getMrfr().equals("1")){
				isKy=true;
			}
			if(isKy){
				result.add(dly);
			}
		}
		//差价格排序
		
		
		return result;
	}
	/**
	 * 根据配送方式 获取产品的最小配送费用
	 * @param list
	 * @param 
	 * @param areaID
	 * @return
	 */
	private Dlytype getDeliveryObj(List<Dlytype> list,Double widget,String areaID){
		Double d=null;
		Dlytype result=null;
		for(Dlytype dt:list){
			if(dt.getValuetype().equals("0")){//统一配置
				Double money=getMoney(dt.getFirstmoney(),dt.getFirstwt(),dt.getAddwtmoney(),dt.getAddwt(),widget);
				if(d==null||d>money){
					d=money;
					result=dt;
				}
			}else if(dt.getValuetype().equals("1")){//单独配置
				Double firstmoney=0.0;
				Double firstwt=0.0;
				Double addwt=0.0;
				Double addwtmoney=0.0;
				List<Psarea> PList=this.getHibernateTemplate().find(" from Psarea n where n.dlytype.dlytype_id='"+dt.getDlytype_id()+"' and n.areaid like '%"+areaID+"%' ");
				for(Psarea p:PList){
					firstmoney=p.getMrscfr();
					firstwt=dt.getFirstwt();
					addwt=dt.getAddwt();
					addwtmoney=p.getMrxzfr();
					Double money=getMoney(firstmoney,firstwt,addwtmoney,addwt,widget);
					if(d==null||d>money){
						d=money;
						result=dt;
					}
				}
				if(PList.size()==0&&dt.getMrfr().equals("1")){//如果启用了默认设置、并且在区域中没有找到合适区域
					firstmoney=dt.getMrscfr();
					firstwt=dt.getFirstwt();
					addwt=dt.getAddwt();
					addwtmoney=dt.getMrxzfr();
					Double money=getMoney(firstmoney,firstwt,addwtmoney,addwt,widget);
					if(d==null||d>money){
						d=money;
						result=dt;
					}
				}
				
			}
			
		}
		return result;
	}
	
	
	
	/**
	 * 根result获取产品的最小配送费用
	 * @param list
	 * @param widget
	 * @param areaID
	 * @return
	 */
	private Double getDelivery(List<Dlytype> list,Double widget,String areaID){
		Double d=null;
		for(Dlytype dt:list){
			if(dt.getValuetype().equals("0")){//统一配置
				Double money=getMoney(dt.getFirstmoney(),dt.getFirstwt(),dt.getAddwtmoney(),dt.getAddwt(),widget);
				if(d==null||d>money){
					d=money;
				}
			}else if(dt.getValuetype().equals("1")){//单独配置
				Double firstmoney=0.0;
				Double firstwt=0.0;
				Double addwt=0.0;
				Double addwtmoney=0.0;
				List<Psarea> PList=this.getHibernateTemplate().find(" from Psarea n where n.dlytype.dlytype_id='"+dt.getDlytype_id()+"' and n.areaid like '%"+areaID+"%' ");
				for(Psarea p:PList){
					firstmoney=p.getMrscfr();
					firstwt=dt.getFirstwt();
					addwt=dt.getAddwt();
					addwtmoney=p.getMrxzfr();
					Double money=getMoney(firstmoney,firstwt,addwtmoney,addwt,widget);
					if(d==null||d>money){
						d=money;
					}
				}
				if(PList.size()==0&&dt.getMrfr().equals("1")){//如果启用了默认设置、并且在区域中没有找到合适区域
					firstmoney=dt.getMrscfr();
					firstwt=dt.getFirstwt();
					addwt=dt.getAddwt();
					addwtmoney=dt.getMrxzfr();
					Double money=getMoney(firstmoney,firstwt,addwtmoney,addwt,widget);
					if(d==null||d>money){
						d=money;
					}
				}
				
			}
		}
		if(d==null)
			d=0d;
		return d;
	}
	
	/**
	 * 计算物流费用
	 * @param firstmoney 首重费用
	 * @param firstwt 首重重量
	 * @param addwtmoney 续重费用
	 * @param addwt 续重重量
	 * @param widget 重量
	 * @return
	 */
	private Double getMoney(Double firstmoney,Double firstwt,Double addwtmoney, Double addwt,Double widget){
		Double money=firstmoney;//首重费用
		//begin
		if(widget!=null&&firstwt!=null&&widget>firstwt){//计算续重费用
			long addNum=Math.round((widget-firstwt)/addwt);
			if((widget-firstwt)%addwt<0.5&&(widget-firstwt)%addwt>0){
				addNum++;
			}
			money+=addNum*addwtmoney;
		}
		//end
		return money;
	}
	
}
