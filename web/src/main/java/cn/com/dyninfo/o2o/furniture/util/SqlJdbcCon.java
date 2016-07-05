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

package cn.com.dyninfo.o2o.furniture.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlJdbcCon {

	
	
	public static Connection  getJDBCCon(String ip){
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con=DriverManager.getConnection("jdbc:mysql://"+ip+":3306/Dress?characterEncoding=utf-8","root","user");
			return con;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			//LogUtil.addLog("连接客户数据库出错，客户服务器IP地址："+ip);
		} catch (SQLException e) {
			//e.printStackTrace();
			
		}
		return null;
	}
	
	public static Statement  getJDBCSt(Connection con){
		
		try {
			Statement st= con.createStatement();
			return st;
		}catch (SQLException e) {
			//e.printStackTrace();
		}
		return null;
	}
	public static void main(String args[]){
		Statement st=SqlJdbcCon.getJDBCSt(getJDBCCon("192.168.1.95"));
		try {
			for(int i=0;i<4000000;i++){
				
					st.executeUpdate("insert into t_goods (name,NUM)values('测试产品',"+i+")");
				
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
