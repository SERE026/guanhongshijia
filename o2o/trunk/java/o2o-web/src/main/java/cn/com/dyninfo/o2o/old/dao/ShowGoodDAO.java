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

import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

@Repository("showGoodDAO")
public class ShowGoodDAO extends BaseDAO {

	@Autowired
	public ShowGoodDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="ShowGood";
	}
	
	
	public void addData(String clientId,int goods_id){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from T_SHOW_GOOD where CLINET_ID='"+clientId+"'  and GOOD_ID="+goods_id);
			
			if(rs.next()){
				int count=rs.getInt(1);
				if(count==0){
					String id=UUID.randomUUID().toString().replace("-", "");
					st.executeUpdate("insert into T_SHOW_GOOD (SHOW_GOOD_ID,CLINET_ID,GOOD_ID,TIME)values('"+id+"','"+clientId+"',"+goods_id+","+(new Date().getTime()/1000)+")");
				}
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 跟新客户端ID
	 * @param clientId
	 * @param member_id
	 */
	public void updateClient(String clientId,String member_id){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			//System.out.println(" delete a from T_SHOW_GOOD a, (select GOOD_ID from T_SHOW_GOOD where CLINET_ID= '"+clientId+"' ) b   where CLINET_ID='"+member_id+"' and a.GOOD_ID = b.GOOD_ID  ");
			st.executeUpdate(" delete a from T_SHOW_GOOD a, (select GOOD_ID from T_SHOW_GOOD where CLINET_ID= '"+clientId+"' ) b   where CLINET_ID='"+member_id+"' and a.GOOD_ID = b.GOOD_ID  ");
			st.executeUpdate("update T_SHOW_GOOD set CLINET_ID='"+member_id+"' where  CLINET_ID= '"+clientId+"'");
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
