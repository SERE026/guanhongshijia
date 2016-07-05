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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.SendDx;
import cn.com.dyninfo.o2o.furniture.util.SendMail;

@Repository("messageDAO")
public class MessageDAO extends BaseDAO {

	@Autowired
	public MessageDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="MessageInfo";
	}
	
	public void addData(String flag, String msg, String revcName,
			String revcInfo,String title){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("insert into T_MESSAGE_INFO (MSG,FLAG,REVC_NAME,REVC_INFO,TITLE) values ('"+msg+"','"+flag+"','"+revcName+"','"+revcInfo+"','"+title+"')");
			ResultSet rs=st.getGeneratedKeys();
			
			int id=0;
			if(rs.next()){
				id=rs.getInt(1);
			}
			
			rs.close();
			st.close();
			con.close();
			this.releaseSession(session);
			if(id!=0){
				int state=1;
				if(flag.equals("0")){
					state=SendDx.sendSMS(revcName,msg+"---"+title,"");
				}else{
					state=SendMail.send(title,msg,revcName);
				}
//				System.out.println("添加成功返回主键:"+id);
				if(state==0){
					updateMsgStatus(id);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void updateMsgStatus(int id){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate("update  T_MESSAGE_INFO set STATUS=1,TIME='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"' where ID="+id);
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized  void  sendMessage (){
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select FLAG ,MSG,REVC_NAME,TITLE,ID FROM T_MESSAGE_INFO WHERE STATUS=0 ORDER BY ID DESC ");
			while(rs.next()){
				String flag=rs.getString(1);
				int state=-1;
				if(flag.equals("0")){
					state=SendDx.sendSMS(rs.getString(2),rs.getString(3)+"---"+rs.getString(4),"");
				}else{
					state=SendMail.send(rs.getString(4),rs.getString(2),rs.getString(3));
				}
				if(state==0){
					updateMsgStatus(rs.getInt(5));
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

}
