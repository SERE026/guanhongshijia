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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
@Repository("huiyuanDao")
public class HuiyuanDao extends BaseDAO{
    
	 @Autowired
	public HuiyuanDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="HuiyuanInfo";
	}
	 
	 /**
	  * 
	  * @param sql
	  * @return
	  */
	 public int validate(String sql){
		 Session session=this.getSession();
		 int count=0;
		 try{
			 Connection con= session.connection();
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("select count(*) from T_HUIYUAN_INFO n where 1=1 "+sql);
			 if(rs.next()){
				 count=rs.getInt(1);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 }catch(Exception e){
			 e.printStackTrace();
			 count=1;
		 }
		 return count;
	 }
}
