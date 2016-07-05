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

package cn.com.dyninfo.o2o.furniture.web.active.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;

@Repository("gameDAO")
public class GameDAO extends BaseDAO {

	@Autowired
	public GameDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="Game";
	}
	
	public int checkActGood(String actId,String goodId){
		int count=0;
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet  rs=st.executeQuery(" select count(*) from  T_ACTIVE_GOODS ag where ag.ACT_ID="+actId+" and ag.GOODS_ID= "+goodId);
			if(rs.next()){
				count= rs.getInt(1);
			}
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
