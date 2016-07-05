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

package cn.com.dyninfo.o2o.furniture.web.goods.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
/**
 * 
 * @author Administrator
 *
 */
@Repository("goodsSortDAO")
public class GoodsSortDAO extends BaseDAO{
     @Autowired
	public GoodsSortDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="GoodsSort";
	}

	@Override
	public Object addObj(Object obj) {
		if(obj instanceof GoodsSort){
			GoodsSort info =(GoodsSort) obj;
			if(info.getParent()!=null){
				int count=1+this.getCountByWhere(new StringBuffer(" and n.id like '"+info.getParent().getGoodsSort_id()+"__'"));
				info.setGoodsSort_id(info.getParent().getGoodsSort_id()*100+count);
			}else{
				int count=1+this.getCountByWhere(new StringBuffer(" and n.parent is null"));
				info.setGoodsSort_id(10000+count);
			}
			return super.addObj(info);
		}else
			return super.addObj(obj);
		
	}

	@Override
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		if(where!=null)
			where.append(" order by n.index asc ");
		else{
			where=new StringBuffer();
			where.append(" order by n.index asc  ");
		}
		return super.getListByPageWhere(where, page);
	}

	@Override
	public List<?> getListByWhere(StringBuffer where) {
		
		if(where!=null)
			where.append(" order by n.index asc ");
		else{
			where=new StringBuffer();
			where.append(" order by n.index asc  ");
		}
		return super.getListByWhere(where);
	}
	
	public List getTryGoodsort(){
		List result=new ArrayList();
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String sql="select distinct n.name,n.GOODSSORT_ID from t_goodssort  n  left join t_goods g on g.GOODSSORT_ID=n.GOODSSORT_ID where g.tryuse='1' and g.state='0' and g.etime<'"+time+"00:00:00'";
//		System.out.println(sql);
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				 Map map=new HashMap();
				 map.put("name", rs.getString(1));
				 map.put("sortid", rs.getString(2));
				 result.add(map);
			}
			rs.close();
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
     
}
