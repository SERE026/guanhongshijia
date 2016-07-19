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

package cn.com.dyninfo.o2o.old.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.Jdbc;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.furniture.web.error.GoodsPriceError;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.model.GoodsSpec;
import cn.com.dyninfo.o2o.old.model.GoodsSpecVal;
import cn.com.dyninfo.o2o.furniture.web.goods.plugin.GoodsPlugin;
/**
 * 
 * @author Administrator
 *
 */
@Repository("goodsDAO")
public class GoodsDAO extends BaseDAO{
	@Resource
	private GoodsPlugin goodsPlugin;
     @Autowired
	public GoodsDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="Goods";
	}
     public Object getObjById(String goods_id, String merchant_id) {
    	 List list = this.getListByWhere(new StringBuffer().append(" and n.goods_id=" + goods_id+"  and n.merchants.shangjia_id="+merchant_id ));
  		if (list.size() > 0)
  			return list.get(0);
  		else
  			return null;
     }
     public Object getObjById(String id) {
 		List list = this.getListByWhere(new StringBuffer()
 		.append(" and n.goods_id=" + id ));
 		if (list.size() > 0)
 			return list.get(0);
 		else
 			return null;
 	}

	@Override
	public Object addObj(Object obj) {
		if(obj instanceof Goods){
			Goods goods=(Goods) obj;
			goodsPlugin.addGoosBefor(goods);
			obj=super.addObj(obj);
			goodsPlugin.addGoodsAfter(goods);
//			System.out.println("插件调用结束");
		}else{
			super.addObj(obj);
		}
		return null;
	}
	
	
	@Override
	public void updateObj(Object obj) {
		if(obj instanceof Goods){
			Goods goods=(Goods) obj;
			goodsPlugin.editGoosBefor(goods);
			super.updateObj(obj);
			goodsPlugin.editGoodsAfter(goods);
		}else{
			super.addObj(obj);
		}
	}
	
	public HashMap getListActGoodsByPage(StringBuffer where,PageInfo page){
		HashMap map = new HashMap();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append("select n from Active a left join a.goods  as n where 1=1 ");
			long ct=new Date().getTime()/1000;
			hsql.append(" and a.etimel>  "+ct);
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			
			Object count=this.getSession().createQuery("select count(n) "+hsql.substring(9)).list().get(0);
			Query query = this.getSession().createQuery(hsql.toString());
			page.setTotalCount(Integer.parseInt(count+""));
			query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
			query.setMaxResults(page.getPageSize());
			List datas = query.list();
			map.put("PAGE_INFO", page);
			map.put("DATA", datas);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
		
	}
	
	public void updateGoodShelves(int id,String status) {
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("update  t_goods set shelves="+status+" where GOODS_ID="+id);
			st.executeUpdate("update  T_PRODUCT set shelves="+status+" where GOODS_ID="+id);
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 挂件获取商品
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String, ?> getListByPageWhereWidget(StringBuffer where,
			PageInfo page) {
		HashMap<String, Object> map=(HashMap<String, Object>) super.getListByPageWhere(where, page);
		List<Goods> list=(List<Goods>) map.get("DATA");
		for(Goods good:list){
			getGoodsPrice(good);
		}
		map.put("DATA", list);
		return map;
	}
	
	
	
	/**
	 * 根据商品ID 获取商品当前的销售金额
	 * 如果商品处于活动中 就是商品的活动价格
	 * @param goodsId
	 * @return 活动ID
	 */
	public String getGoodsPrice(Goods good){
		String actId="";
		Session session=this.getSession();
		Double price=0.0;
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			int time=Context.getCurrentTime();
			String slq="select a.TYPE,a.VAL,a.ACTIVE_ID ";
				   slq+=" from t_active a ";
				   slq+=" left join T_ACTIVE_GOODS ag on a.ACTIVE_ID=ag.ACT_ID ";
				   slq+=" where 1=1 ";
				   slq+=" and a.btimel <"+time;//活动已经开始
				   slq+=" and a.etimel >"+time;//活动还未结束
				   slq+=" and a.FLAG=0 ";
				   slq+=" and a.STATUS=0 ";
				   slq+=" and ag.GOODS_ID="+good.getGoods_id();
		    ResultSet rs=st.executeQuery(slq);
		    while(rs.next()){
		    	String type=rs.getString(1);
		    	Double val=rs.getDouble(2);
		    	if(type.equals("1")){
		    		//if(price>val){
		    			price=val;
		    			actId=""+rs.getInt(3);
		    		//}
		    	}else if(type.equals("2")){
		    		//if(price>good.getSalesMoney()*val/10){
		    			price=good.getSalesMoney()*val/10;
		    			actId=""+rs.getInt(3);
		    		//}
		    	}
		    }
		    rs.close();
		    st.close();
		    con.close();
		    good.setActionMoney(price);
		    good.setActionId(actId);
		    good.setActFlag(0);
		    if(actId.length()>0)
		    	good.setAct(this.getHibernateTemplate().load(Active.class, Integer.parseInt(actId)));
		    this.releaseSession(session);
		}catch(Exception e){
			new GoodsPriceError().printStackTrace();
		}
		return actId;
	}
	

	
	/**
	 * 获取产品属性
	 * @param goods_id
	 * @param specVal
	 * @return
	 */
	public List getGoodsSpec(int goods_id, String specVal){
		List result=new ArrayList();
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			String specValIds[]=specVal.split("\\|");
			String valIdstr="";
			for(String id:specValIds){
				valIdstr+=(valIdstr.length()>0?",":"")+"'"+id+"'";
			}
			ResultSet rs=st.executeQuery("select s.NAME,v.VAL,v.SPEC_SALES,s.TYPE,s.STATUS,v.STATUS from T_GOODS_SPEC_VAL v left join T_GOOD_SPEC s on s.GOODS_SPEC_ID=v.GOODS_SPEC_ID where v.GOODS_ID="+goods_id+" and v.SPEC_VAL_ID in("+valIdstr+")");
			while(rs.next()){
				Map map=new HashMap();
				map.put("s_name", rs.getString(1));
				map.put("v_val", rs.getString(2));
				map.put("v_sales", rs.getDouble(3));
				map.put("s_type",rs.getString(4));
				map.put("s_status", rs.getInt(5));
				map.put("v_status", rs.getInt(6));
				result.add(map);
			}
			rs.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public Double getGoodSpevMoney(String id){
		List<GoodsSpecVal> list=this.getHibernateTemplate().find(" from GoodsSpecVal as n where n.spec_val_id='"+id+"' ");
		if(list.size()>0)
			return list.get(0).getSales();
			
		return 0d;
	}
	
	public String checkGoodSpecVal(String goodID,String specVal){
			String result="";
			Map map=new HashMap();
			List<GoodsSpec> list=this.getHibernateTemplate().find(" from GoodsSpec as n where n.goods.goods_id="+goodID+" and n.status=0 ");
			for(GoodsSpec spec:list){
				
				String id="";
				for(int i=0;i<spec.getValList().size();i++){
					GoodsSpecVal gsv= spec.getValList().get(i);
					if(gsv.getStatus()==0&&(i==0||specVal.indexOf(gsv.getSpec_val_id())>0)){
						id=gsv.getSpec_val_id();
					}
				}
				result+=(result.length()>0?"|":"")+id;
//				System.out.println("sss");
			}
			return result;
		
	}
	
	/**
	 * 根据商品品牌 获取商品
	 * @param sql
	 * @return
	 */
	public List getGoodBranNum(String sql){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			String creatsql=" select b.BRAND_ID as brandId ,b.NAME as name,count(*) as num ";
			creatsql+=" from  T_GOODS g ";
			creatsql+=" left join T_BRAND b  on b.BRAND_ID=g.BRAND_ID ";
			creatsql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID  ";
			creatsql+="  where 1=1 and g.SHELVES=0 ";
			 
			
			if(sql!=null){
				creatsql+=sql;
			}
			creatsql+=" group by  b.BRAND_ID ";
			List list=Jdbc.getData(creatsql,st);
			st.close();
			con.close();
			this.releaseSession(session);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取商品价格区间
	 * @param sql
	 * @return
	 */
	public List getGoodPriceRange(String sql){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			String creatsql=" select g.PRICE_RANGE as name ,count(*) as num ";
			creatsql+=" from   T_GOODS g  ";
			creatsql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID  ";
			creatsql+="  where 1=1 and g.SHELVES=0 ";
			
			if(sql!=null){
				creatsql+=sql;
			}
			creatsql+=" group by  g.PRICE_RANGE ";
			System.out.println();
			List list=Jdbc.getData(creatsql,st);
			st.close();
			con.close();
			this.releaseSession(session);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据商品分类 获取商品属性
	 * @param typeId
	 * @param sql
	 * @return
	 */
	public List getGoodSpecNum(String typeId,String sql){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			
			String sepecSql="select NAME as name  from T_GOOS_TYPE_SPEC where GOODS_TYPE_ID="+typeId+" order by goods_type_spec_id ";
			List<Map<String, ?>> list=Jdbc.getData(sepecSql,st);
			int item=0;
			for(Map m:list){
				
				String creatsql=" select g.SPEC_VALUE_"+item+" as name,count(*) as num ";
				
				creatsql+=" from   T_GOODS g  ";
				creatsql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID  ";
				creatsql+="  where 1=1 and g.SHELVES=0 and GOODSTYPE_ID="+typeId;
				
				if(sql!=null){
					creatsql+=sql;
				}
				creatsql+=" group by g.SPEC_VALUE_"+item+" ";
//				System.out.println(creatsql);
				List v=Jdbc.getData(creatsql,st);
				m.put("data", v);
				m.put("item", item);
				item++;
			}
			st.close();
			con.close();
			this.releaseSession(session);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据sql 获取商品分类数量
	 * @param sql
	 * @return
	 */
	public List getGoodSortNum(String sql){
		List list=new ArrayList();
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			
		
				String creatsql=" select gs.GOODSSORT_ID as sortId,gs.NAME as name,count(*) as num  ";
				creatsql+=" from   T_GOODS g  ";
				creatsql+=" left join T_GoodsSort  gs  on  gs.GOODSSORT_ID=g.GOODSSORT_ID  ";
				creatsql+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=g.MARCHANTS_ID  ";
				creatsql+="  where 1=1 and g.SHELVES=0 ";
				if(sql!=null){
					creatsql+=sql;
				}
				creatsql+=" group by gs.GOODSSORT_ID ";
				list=Jdbc.getData(creatsql,st);
			st.close();
			con.close();
			this.releaseSession(session);
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据商品条件 获取商品的品牌
	 * @param goodsId
	 * @return where
	 */
	public HashMap<String,?> getGoodsBrand(StringBuffer where){
		HashMap map=new HashMap();
		 List list=new ArrayList();
		Session session=this.getSession();
			try {
				Connection con = session.connection();
				Statement st = con.createStatement();
				String slq = "select a.GOODSSORT_ID,b.brand_id,b.name from T_GOODS a ";
				slq+=" left join T_SHANGJIA_INFO s on s.SHANGJIA_ID=a.MARCHANTS_ID ";
				slq += "left join T_BRAND b on b.BRAND_ID=a.BRAND_ID where 1=1 "+ where;
				slq += " group by b.name";
				ResultSet rs = st.executeQuery(slq);
				while (rs.next()) {
					HashMap map1 = new HashMap();
					map1.put("gid", rs.getString(1));
					map1.put("id", rs.getString(2));
					map1.put("name", rs.getString(3));
					list.add(map1);
				}
				rs.close();
				st.close();
				con.close();
				map.put("DATA",list);
			} catch (Exception e) {
			}
		return map;
	}
	
	
	
}
