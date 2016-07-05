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

package cn.com.dyninfo.o2o.furniture.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("mainDao")
public class MainDao extends HibernateDaoSupport {

	@Autowired
	public MainDao(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public int getNum(String sql){
		Session session=this.getSession();
		int result=0;
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.first()){
				result=rs.getInt(1);
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
	
	public Double getMoney(String sql){
		Session session=this.getSession();
		Double result=0d;
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.first()){
				result=rs.getDouble(1);
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
