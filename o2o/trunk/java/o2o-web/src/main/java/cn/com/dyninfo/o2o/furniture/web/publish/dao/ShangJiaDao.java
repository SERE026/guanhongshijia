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

package cn.com.dyninfo.o2o.furniture.web.publish.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
/**
 * 商家资料
 * @author Administrator
 *
 */
@Repository("shangJiaDao")
public class ShangJiaDao extends BaseDAO{
	@Autowired
	public ShangJiaDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="ShangJiaInfo";
	}
	
	
	@Override
	public Object addObj(Object obj) {
		if(obj instanceof ShangJiaInfo){
			ShangJiaInfo ino=(ShangJiaInfo) obj;
			Query query =this.getSession().createQuery("from ShangJiaInfo as n order by n.affiliation desc ");
			query.setMaxResults(1);
			List<ShangJiaInfo> list=query.list();
			String inviteCode="0e0efe";
			if(list.size()>0){
				inviteCode=""+list.get(0).getAffiliation();
			}
			int hexv=Integer.parseInt(inviteCode, 16)+5;
			inviteCode=Integer.toHexString(hexv);
			ino.setAffiliation(inviteCode.toUpperCase());
			return super.addObj(ino);
		}else{
			return super.addObj(obj);
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public List<ShangJiaInfo> getWhere(StringBuffer where){
		 StringBuffer hsql = new StringBuffer();
			hsql.append(" from ShangJiaInfo as n where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			return this.getHibernateTemplate().find(hsql.toString());
	 }
	 
	 
	   /**
		 * 根据sql获取商品数据
		 * T_GOODS g,T_GoodsSort ts,T_SHANGJIA_INFO s
		 * @param sql
		 * @return List
		 */
		public Map getGoodsByAct(String sql,String shopId,PageInfo page,String orderBy){
			Map result=new HashMap();
			try{
				List list=new ArrayList();
				long t=new Date().getTime()/1000;
		 		String tmpTable="a"+Math.round(Math.random()*1000000);
		 		String selectSql=" select  g.GOODS_ID as goodId,";
		 		selectSql+=" g.BAZAARMONEY as xmoney ,";
		 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
		 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,";
		 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index,g.CODE";
		 		selectSql+=" from T_GOODS g  ";
		 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
		 		selectSql+=" left join t_active a on  (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+" and a.FLAG=0 and a.STATUS=0)   ";
		 		selectSql+=" where 1=1  and g.STATE='0'  and g.SHELVES=0   and g.MARCHANTS_ID="+shopId;
		 		

		 		selectSql+=sql;
		 		selectSql+=" group by g.GOODS_ID";
	 			Session session=this.getSession();
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			System.out.println(selectSql);
//	 			System.out.println("swq--------------"+"  select distinct * from "+tmpTable+"  order by "+(orderBy==null?"g_index asc":orderBy)+"   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageNo()*page.getPageSize()+"  ");
	 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
	 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by "+(orderBy==null?"g_index asc,code":orderBy)+"   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 			rs.close();
	 			rs=st.executeQuery("select count(*) from "+tmpTable);
	 			if(rs.next())
	 				page.setTotalCount(rs.getInt(1));
	 			rs.close();
	 			result.put("num", page.getTotalCount());
	 			result.put("data", list);
	 			result.put("page", page);
	 			st.executeUpdate(" drop table "+tmpTable);
	 			st.close();
	 			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}

	   /**
		 * 根据sql获取商品数据
		 * T_GOODS g,T_SHANGJIA_INFO s,T_ACTIVE a
		 * @param sql
		 * @return List
		 */
		public Map getGoodsBySort(String sql,String shopId,PageInfo page,String orderBy){
			Map result=new HashMap();
			long t=new Date().getTime()/1000;
			try{
				List list=new ArrayList();
		 		String tmpTable="a"+Math.round(Math.random()*1000000);
		 		String selectSql=" select  g.GOODS_ID as goodId,";
		 		selectSql+=" g.BAZAARMONEY as xmoney ,";
		 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
		 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,";
		 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index";
		 		selectSql+=" from T_GOODS g  ";
		 		selectSql+=" left join T_ACTIVE_GOODS ag on ag.GOODS_ID=g.GOODS_ID   ";
		 		selectSql+=" left join t_active a on  (a.ACTIVE_ID=ag.ACT_ID and a.btimel<"+t+" and a.etimel>"+t+")   ";
		 		selectSql+=" left join T_GoodsSort gs on gs.GOODSSORT_ID=g.CUSTOM_SORT_ID   ";
		 		selectSql+=" where 1=1   and g.STATE='0' and g.SHELVES=0   and g.MARCHANTS_ID="+shopId;
		 		selectSql+=sql;
	 			Session session=this.getSession();
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
	 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by "+(orderBy==null?"g_index asc":orderBy)+"   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 			rs.close();
	 			rs=st.executeQuery("select count(*) from "+tmpTable);
	 			if(rs.next())
	 				page.setTotalCount(rs.getInt(1));
	 			rs.close();
	 			result.put("num", page.getTotalCount());
	 			result.put("data", list);
	 			result.put("page", page);
	 			st.executeUpdate(" drop table "+tmpTable);
	 			st.close();
	 			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}
			
		/**
		 * 根据sql 获取商家 活动
		 * @param sql
		 * @return
		 */
		public Map getActGood(String sql,String shopId,PageInfo page,String orderBy){
			Map result=new HashMap();
			long t=new Date().getTime()/1000;
			try{
				List list=new ArrayList();
		 		String tmpTable="a"+Math.round(Math.random()*1000000);
		 		String selectSql=" select  g.GOODS_ID as goodId,";
		 		selectSql+=" g.BAZAARMONEY as xmoney ,";
		 		selectSql+="  case  when a.TYPE=2 then g.salesMoney*val/10 when a.TYPE=1 then g.salesMoney-a.VAL ELSE g.salesMoney END as money,";
		 		selectSql+=" g.NAME as goodName ,g.NUM as xiaoliang,";
		 		selectSql+=" g.DEFAULT_IAMAGE as image ,g.INDEXS as g_index";
		 		selectSql+=" from t_active  a";
		 		selectSql+=" left join T_ACTIVE_GOODS ag on a.ACTIVE_ID=ag.ACT_ID   ";
		 		selectSql+=" left join T_GOODS  g on  ag.GOODS_ID=g.GOODS_ID   ";
		 		selectSql+=" left join T_GoodsSort gs on gs.GOODSSORT_ID=g.CUSTOM_SORT_ID   ";
		 		selectSql+=" where 1=1   and g.STATE='0'  and g.SHELVES=0   and g.MARCHANTS_ID="+shopId+" and a.btimel<"+t+" and a.etimel>"+t+"";
		 		selectSql+=sql;
	 			Session session=this.getSession();
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			st.executeUpdate(" create temporary table "+tmpTable +selectSql);
	 			ResultSet rs=st.executeQuery(" select distinct * from "+tmpTable+"  order by "+(orderBy==null?"g_index asc":orderBy)+"   LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 			rs.close();
	 			rs=st.executeQuery("select count(*) from "+tmpTable);
	 			if(rs.next())
	 				page.setTotalCount(rs.getInt(1));
	 			rs.close();
	 			result.put("num", page.getTotalCount());
	 			result.put("data", list);
	 			result.put("page", page);
	 			st.executeUpdate(" drop table "+tmpTable);
	 			st.close();
	 			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}
		
		public void updateShangpin(int Id){
			try{
				String Sql="UPDATE T_GOODS SET SHELVES='1' WHERE MARCHANTS_ID ='"+Id+"'";
				Session session=this.getSession();
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			st.executeUpdate(Sql);
	 			st.close();
	 			con.close();
	 			this.releaseSession(session);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		/**
	 	 * 根据 中心点 和半径 获取附近的美容院
	 	 * @param lng
	 	 * @param lat
	 	 * @param r
	 	 * @param cityName
	 	 * @return
	 	 */
	 	public List getNearshop(double lon,double lat,PageInfo page){
	 		Session  session=this.getSession();
	 		List list=new ArrayList();
	 		try{
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			String sql="select ";
	 			sql+="6378137*2*asin(Sqrt(power(sin(("+lat+"-LATITUDE)*pi()/360),2)+Cos("+lat+"*pi()/180)*Cos(LATITUDE*pi()/180)*power(sin(("+lon+"-LONGITUDE)*pi()/360),2))) ";
	 			sql+="as distance,A.* from t_shangjia_info as A where  TYPE_ID='2' and STATE='0' order by distance";
	 			sql+="  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
	 			ResultSet rs=st.executeQuery(sql);
//	 			System.out.println(sql);
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		return list;
	 	}
	 	
	 	
	 	/**
	 	 * 根据 中心点 和半径 获取附近的商品
	 	 * @param lng
	 	 * @param lat
	 	 * @param r
	 	 * @param cityName
	 	 * @return
	 	 */
	 	public List getNeargoods(double lon,double lat,int moduleId,PageInfo page,String where){
	 		Session  session=this.getSession();
	 		List list=new ArrayList();
	 		try{
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 			String sql="select *,case when pg.indexs is null then 99999 ELSE pg.indexs  END   as orderIndex  ";  
	 				  sql+=" from (select 6378137*2*asin(Sqrt(power(sin(("+lat+"-LATITUDE)*pi()/360),2)+Cos("+lat+"*pi()/180)*Cos(LATITUDE*pi()/180)*power(sin(("+lon+"-LONGITUDE)*pi()/360),2))) as distance,SHANGJIA_ID,ADDRESS";
	 				  sql+=" from t_shangjia_info  )";
	 				  sql+=" m left join   t_goods g on ";
	 				  sql+=" g.MARCHANTS_ID=m.SHANGJIA_ID";
	 				  sql+=" left join T_PAGEMODULE_IN_GOODS pg on  pg.GOOD_ID=g.GOODS_ID  ";
	 				  sql+=" where g.SHELVES='0' and g.STATE='0' and m.distance<50000";
	 				  sql+=" and pg.PAGEMODULE_ID="+moduleId+" ";
	 				  sql+=where;
	 				  sql+=" order by m.distance asc,orderIndex asc  ";
	 			      sql+="  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
	 			ResultSet rs=st.executeQuery(sql);
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		return list;
	 	}
	 	/**
	 	 * 根据 中心点 和半径 获取附近的美容项目
	 	 * @param lng
	 	 * @param lat
	 	 * @param r
	 	 * @param cityName
	 	 * @return
	 	 */
	 	public List getNearmrxm(double lon,double lat,PageInfo page){
	 		Session  session=this.getSession();
	 		List list=new ArrayList();
	 		try{
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 				  
	 				String sql="select distinct GOODS_ID,g.NAME as goodsname,m.NAME AS shopname,m.distance,g.DEFAULT_IAMAGE,g.SALESMONEY,g.bazaarMoney from ";
	 					sql+="(select 6378137*2*asin(Sqrt(power(sin(("+lat+"-LATITUDE)*pi()/360),2)+Cos(31.133*pi()/180)*Cos("+lat+"*pi()/180)*power(sin(("+lon+"-LONGITUDE)*pi()/360),2))) as distance,SHANGJIA_ID,NAME ";
	 					sql+="from t_shangjia_info where TYPE_ID='2' )m left join  t_goods g on g.MARCHANTS_ID=m.SHANGJIA_ID ";
	 					sql+="left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID)";
	 					sql+="where pg.PAGEMODULE_ID=49 and m.distance<50000 order by m.distance asc";
	 			        sql+="  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
	 			
//	 			System.out.println("sql---------------------"+sql);
	 			ResultSet rs=st.executeQuery(sql);
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		return list;
	 	}
	 	
	 	public List getByCityId(String cityid, PageInfo page){
	 		Session  session=this.getSession();
	 		List list=new ArrayList();
	 		try{
	 			Connection con=session.connection();
	 			Statement st=con.createStatement();
	 				  
	 				String sql="select distinct GOODS_ID,g.NAME as goodsname,m.NAME AS shopname,g.DEFAULT_IAMAGE,g.SALESMONEY,g.bazaarMoney from ";
	 					sql+="(select SHANGJIA_ID,NAME ";
	 					sql+="from t_shangjia_info where TYPE_ID='2' and CITY_ID = "+cityid+")m left join  t_goods g on g.MARCHANTS_ID=m.SHANGJIA_ID ";
	 					sql+="left join T_PAGEMODULE_IN_GOODS pg on ( pg.GOOD_ID=g.GOODS_ID)";
	 					sql+="where pg.PAGEMODULE_ID=49 ";
	 			        sql+="  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
	 			
//	 			System.out.println("sql---------------------"+sql);
	 			ResultSet rs=st.executeQuery(sql);
	 			ResultSetMetaData rsmd=rs.getMetaData();//rs为查询结果集
	 			int count=rsmd.getColumnCount();
	 			while(rs.next()){
		 			Map map=new HashMap();
	 				for(int i=1;i<=count;i++){
	 					map.put(rsmd.getColumnName(i), rs.getObject(i));
		 			}
	 				list.add(map);
	 			}
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		return list;
	 	}
}
