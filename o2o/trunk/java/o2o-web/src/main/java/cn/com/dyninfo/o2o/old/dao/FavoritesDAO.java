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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;

@Repository
public class FavoritesDAO extends BaseDAO {

	@Autowired
	public FavoritesDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="Favorites";
	}
	/**
	 * 批量添加到收藏夹
	 * @param list
	 */
	public void addGoods(List<Map> list) {
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			long t=new Date().getTime()/1000;
			for(Map m:list){
				ResultSet rs=st.executeQuery("select count(*) from T_FAORITES where GOODS_ID="+m.get("good_id")+" and MEMBER_ID="+m.get("memberId"));
				int count=0;
				if(rs.next()){
					count=rs.getInt(1);
				}
				rs.close();
				if(count==0)
					st.executeUpdate("insert into T_FAORITES (MEMBER_ID,GOODS_ID,TIME,TYPE) values("+m.get("memberId")+","+m.get("good_id")+","+t+",'0')");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getGoodsActiveCount(int memberId){
		int count=0;
		int t=(int)(new Date().getTime()/1000);
		try{
			String sql=" select count(distinct a.GOODS_ID) ";
			sql+=" from  t_faorites b left join t_goods a  on a.GOODS_ID=b.GOODS_ID  ";
			sql+="left join t_active_goods c on b.GOODS_ID=c.GOODS_ID left join t_active d on c.ACT_ID=d.ACTIVE_ID ";
			sql+="where btimel<"+t+" and etimel>"+t;
			sql+=" and b.GOODS_ID='0' and b.MEMBER_ID="+memberId;
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				
				count=rs.getInt(1);
			}
			
			rs.close();
			st.close();
			con.close();
			
			this.releaseSession(session);
			return count;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public List getGoodsactive(int memberId,PageInfo page){
		List result=new ArrayList();
		int t=(int)(new Date().getTime()/1000);
		try{
			String sql=" select a.name as name,a.DEFAULT_IAMAGE as img,d.name as activename ,a.GOODS_ID as goodsid ,b.FAVORITES_ID as favorit_id ,d.ACTIVE_ID as actid";
			
			sql+=" from  t_faorites b left join t_goods a  on a.GOODS_ID=b.GOODS_ID  ";
			sql+="left join t_active_goods c on b.GOODS_ID=c.GOODS_ID left join t_active d on c.ACT_ID=d.ACTIVE_ID ";
			sql+="where btimel<"+t+" and etimel>"+t;
			sql+=" and a.shelves='0' and b.MEMBER_ID="+memberId;
			sql+=" group by a.GOODS_ID desc LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ";
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Map map=new HashMap();
				map.put("name", rs.getString(1));
				map.put("defaultImage", rs.getString(2));
				map.put("activename", rs.getString(3));
				map.put("goodsid", rs.getString(4));
				map.put("favorit_id", rs.getString(5));
				map.put("actid", rs.getString(6));
				result.add(map);
			}
			rs.close();
			st.close();
			con.close();
		this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
