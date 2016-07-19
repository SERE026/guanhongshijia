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
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("pagePathDAO")
public class PagePathDAO extends HibernateDaoSupport {

	@Autowired
	public PagePathDAO(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public Map<String,String> getPath(){
		Map map=new HashMap();
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select page,path from t_page_path ");
			while(rs.next()){
				map.put(rs.getString(1),rs.getString(2));
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
