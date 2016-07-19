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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;

@Repository("carsDAO")
public class CarsDAO extends BaseDAO {

	@Autowired
	public CarsDAO(SessionFactory sessionFactory){
		super(sessionFactory);
		this.table="CarsBox";
	}
	public Object getCarByMemberId(String memberId) {
		List list=this.getHibernateTemplate().find(" from Cars as n where n.member.huiYuan_id='"+memberId+"' ");
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	public void delCar(int id){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("delete from T_CARS_BOX where CARS_BOX_ID="+id);
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delCar(String id){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("delete from T_CARS_BOX where CARS_BOX_ID='"+id+"'");
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List getCar(int member_id){
		List list=new ArrayList();
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select GOOD_ID,PRICE,NUM,SPEC_VAL,CARS_BOX_ID,ACT_INFO from T_CARS_BOX where HUIYUAN_ID="+member_id);
			while(rs.next()){
				Map map=new HashMap();
				map.put("good_id", rs.getInt(1));
				map.put("price", rs.getDouble(2));
				map.put("num", rs.getInt(3));
				map.put("specVal", rs.getString(4));
				map.put("CARS_BOX_ID", rs.getString(5));
				map.put("actInfo", rs.getString(6));
				list.add(map);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 直接购买
	 * @param Money
	 * @param num
	 * @param good_id
	 * @param specVal
	 * @param member_id
	 * @param actInfo
	 * return  购物编号
	 */
	public String BuyGoods(Double Money,int num,int good_id,String specVal,int member_id,String actInfo) 
		{
			String no=null;
			Session session=this.getSession();
			try{
				Connection con=session.connection();
				Statement st=con.createStatement();
				String CarId=UUID.randomUUID().toString().replace("-", "");
				st.executeUpdate(" insert into T_CARS_BOX (CARS_BOX_ID,GOOD_ID,NUM,PRICE,HUIYUAN_ID,SPEC_VAL,ACT_INFO) values('"+CarId+"',"+good_id+","+num+","+Money+","+member_id+",'"+specVal+"','"+actInfo+"') ");
				st.close();
				con.close();
				this.releaseSession(session);
				no=CarId;
			}catch(Exception e){
				e.printStackTrace();
			}
			return no;
		}
	/**
	 * 添加购物车
	 * @param Money
	 * @param num
	 * @param product_id
	 * @param specVal
	 * @param member_id
	 */
	public Map addGoods(Double Money,int num,int good_id,String specVal,
			int member_id,String actInfo) {
		Session session=this.getSession();
		Map map=new HashMap	();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select NUM,PRICE,CARS_BOX_ID from T_CARS_BOX where GOOD_ID="+good_id+" and SPEC_VAL='"+specVal+"' and HUIYUAN_ID="+member_id+" and ACT_INFO='"+actInfo+"' ");
			if(rs.next()){
				int rnum=rs.getInt(1);
				Double rprice=rs.getDouble(2);
				String CARS_BOX_ID=rs.getString(3);
				if(rprice<Money){
					st.executeUpdate("update T_CARS_BOX set NUM="+(rnum+num)+" where CARS_BOX_ID='"+CARS_BOX_ID+"' ");
				}else{
					st.executeUpdate("update T_CARS_BOX set NUM="+(rnum+num)+",PRICE="+Money+" where CARS_BOX_ID='"+CARS_BOX_ID+"' ");
				}
				map.put("CARS_BOX_ID", CARS_BOX_ID);
				map.put("Money", Money);
				rs.close();
			}else{
				String CarId=UUID.randomUUID().toString().replace("-", "");
				if(actInfo.split("\\|").length < 2){
					st.executeUpdate(" insert into T_CARS_BOX (CARS_BOX_ID,GOOD_ID,NUM,PRICE,HUIYUAN_ID,SPEC_VAL,ACT_INFO) " +
							"values('"+CarId+"',"+good_id+","+num+","
							+Money+","
							+member_id+",'"+specVal+"','"+actInfo+"') ");
				}else{
					st.executeUpdate(" insert into T_CARS_BOX (CARS_BOX_ID,GOOD_ID,NUM,PRICE,HUIYUAN_ID,SPEC_VAL,ACT_INFO) " +
							"values('"+CarId+"',"+good_id+","+num+","
							+(Money-Double.parseDouble(actInfo.split("\\|")[1]))+","
							+member_id+",'"+specVal+"','"+actInfo+"') ");
				}
				
				ResultSet rs01=st.executeQuery("select NUM,PRICE,CARS_BOX_ID from T_CARS_BOX where GOOD_ID="+good_id+" and SPEC_VAL='"
						+specVal+"' and HUIYUAN_ID="+member_id+" and ACT_INFO='"+actInfo+"' ");
				if(rs01.next()&&!actInfo.equals("|")){
					int rnum=rs01.getInt(1);
					Double rprice=rs01.getDouble(2);
					String CARS_BOX_ID=rs01.getString(3);
					map.put("CARS_BOX_ID", CARS_BOX_ID);
					map.put("Money", Money-Double.parseDouble(actInfo.split("\\|")[1]));
				}
			}
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	public List getGoods(String carId){
		List list=this.getHibernateTemplate().find(" from CarsBox as n where n.car.cars_id='"+carId+"' ");
		return list;
	}
	
	
	public void DelGoods(String  boxId,String carId){
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("delete from T_CARS_BOX where CAR_ID='"+carId+"' and CARS_BOX_ID='"+boxId+"'  ");
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
