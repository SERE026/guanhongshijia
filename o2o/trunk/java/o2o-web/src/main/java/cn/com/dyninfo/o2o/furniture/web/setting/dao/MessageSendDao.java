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

package cn.com.dyninfo.o2o.furniture.web.setting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
/**
 * 消息推送
 * @author Administrator
 *
 */
@Repository("messageSendDao")
public class MessageSendDao extends BaseDAO{
	@Autowired
	public MessageSendDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="MessageSend";
	}
	
	
	public List getmessage(String uid, PageInfo page) {
		String sql="select a.* from t_messagesend  as a  left join t_faorites as b on a.GOODS_ID=b.GOODS_ID where b.GOODS_ID=a.GOODS_ID ";
			   sql+="and uid not like '%"+uid+"%'";
		List list=new ArrayList();
		try{
 			Session session=this.getSession();
 			Connection con=session.connection();
 			Statement st=con.createStatement();
 			ResultSet rs=st.executeQuery(sql+"  LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize() + " ");
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
 			st.close();
 			con.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 		}
 		return list;
	}


public int getmesBySlqCount(String uid) {
	int count=0;
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			String sql="select count(*) from t_messagesend  as a  left join t_faorites as b on a.GOODS_ID=b.GOODS_ID where b.GOODS_ID=a.GOODS_ID ";
			   sql+="and uid not like '%"+uid+"%'";
		    ResultSet rs=st.executeQuery(sql);
		    while(rs.next()){
		    	count=rs.getInt(1);
		    }
		    rs.close();
		    st.close();
		    con.close();
		    this.releaseSession(session);
		}catch(Exception e){
			
		}
		return count;
	}
}

