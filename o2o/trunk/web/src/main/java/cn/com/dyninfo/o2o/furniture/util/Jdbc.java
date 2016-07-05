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

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc {

	public static List<Map<String ,?>> getData(String sql,Statement st){
		List list=new ArrayList();
		try{
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
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
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
