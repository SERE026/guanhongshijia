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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.ActiveGoods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

@Repository("discountActiveDAO")
public class DiscountActiveDAO extends BaseDAO {

	@Autowired
	public DiscountActiveDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="Active";
	}

	
	public List getActGoodsByList(StringBuffer where, PageInfo page) {
		HashMap map = new HashMap();
		List result=new ArrayList();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from ActiveGoods as n where 1=1 and n.goods.shelves=0 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			Object count=this.getSession().createQuery("select count(*) "+hsql).list().get(0);
			Query query = this.getSession().createQuery(hsql.toString());
			page.setTotalCount(Integer.parseInt(count+""));
			query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
			query.setMaxResults(page.getPageSize());
			List<ActiveGoods> datas = query.list();
			
			return datas;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int getActGoodsCount(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from ActiveGoods as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Session session=this.getSession();
		System.out.println(hsql.toString());
		Query query = session.createQuery(hsql.toString());
		int count=((Long) query.uniqueResult()).intValue();
		this.releaseSession(session);
		return count;
	}
	
	
	public void delActiveGoods(String id){
		String sql="delete from T_ACTIVE_GOODS where ACT_ID='"+id+"' ";
		try{
			Session session=this.getSessionFactory().getCurrentSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据商品获取活动
	 * @param goods
	 * @return Active
	 */
	public Active getActiveByGoods(Goods goods) {
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from Active as n left join n.goods as g where 1=1 and g.goods_id=" + goods.getGoods_id());
			Query query = this.getSession().createQuery(hsql.toString());
			List datas = query.list();
//			System.out.println(datas.size());
			if (datas.size() > 0) {
				Object[] obj = (Object[])datas.get(0); // 取第一条结果
				return (Active)obj[0]; // 取OBJ数组中的第1列，作为对象返回
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	

	public HashMap<String, ?> getGoodListByPageWhere(StringBuffer where,
			PageInfo page) {
		
		HashMap map = new HashMap();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from Active as n left join n.goods as g where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			Object count=this.getSession().createQuery("select count(g) "+hsql).list().get(0);
			Query query = this.getSession().createQuery("select g "+hsql.toString());
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
	
	public List getGoodListByWhere(StringBuffer where) {
		
		HashMap map = new HashMap();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from Active as n left join n.goods as g where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			Query query = this.getSession().createQuery("select g "+hsql.toString());
			List datas = query.list();
			return datas;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void addLink(List<Map> list) {
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			for(Map m:list){
				try{
					st.executeUpdate("insert t_active_goods (ACT_ID,GOODS_ID) values("+m.get("actID")+","+m.get("goodID")+")");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.releaseSession(session);
	}
	
	public void delLink(String actId,String goodId) {
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("delete from t_active_goods where ACT_ID="+actId+" and GOODS_ID="+goodId);
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.releaseSession(session);
	}

}
