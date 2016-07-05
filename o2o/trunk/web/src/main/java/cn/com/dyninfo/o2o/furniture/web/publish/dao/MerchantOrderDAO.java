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

package cn.com.dyninfo.o2o.furniture.web.publish.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantOrderInfo;

@Repository("merchantOrderDAO")
public class MerchantOrderDAO extends BaseDAO {

	@Autowired
	public MerchantOrderDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="MerchantOrder";
	}
	
	
	public int getOrderCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from MerchantOrderInfo as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Query query = this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}

	
	public HashMap<String, ?> getOrderListByPageWhere(StringBuffer where,
			PageInfo page) {
		HashMap map = new HashMap();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from MerchantOrderInfo as n where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			Object count=this.getSession().createQuery("select count(*) "+hsql).list().get(0);
			Query query = this.getSession().createQuery(hsql.toString());
			page.setTotalCount(Integer.parseInt(count+""));
			query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
			query.setMaxResults(page.getPageSize());
			List datas = query.list();
			map.put("PAGE_INFO", page);
			map.put("DATA", datas);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	public MerchantOrderInfo checkMerchant(String o_id,String m_id){
		List<MerchantOrderInfo> list=this.getHibernateTemplate().find(" from MerchantOrderInfo as n  where n.merchant.shangjia_id="+m_id+" and n.order.merchant_order_id="+o_id);
		if(list.size()>0)
			return list.get(0);
		else return null;
	}


	public Object getOrderObjById(String id) {
		List list=this.getHibernateTemplate().find(" from MerchantOrderInfo as n  where n.merchant_order_id="+id);
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	
	public List getMerchantPageBywhere(String orderId,String sql,PageInfo page){
		List list=new ArrayList();
		try{
			String whereSql="select * from (select s.SHANGJIA_ID as s_id,s.NAME as s_name ,s.IMAGE as image,s.DZ_IAMGE as dzImage,s.NRJ_IAMGE as nrjImage ,s.intro as intro,  case when o.T_INDEX is null then 99999 ELSE o.T_INDEX  END   as tindex  from T_SHANGJIA_INFO s left join T_MERCHANT_ORDER_INFO o on  (o.MERCHANT_ID=s.SHANGJIA_ID and o.ORDER_ID="+orderId+")  where 1=1 and s.state=0   ";
			if(sql!=null){
				whereSql+=sql;
			}
			whereSql+=" ) a  order by tindex asc  ";
			whereSql+=" LIMIT "+(page.getPageNo()-1)*page.getPageSize()+","+page.getPageSize()+"  ";
			
			Session session=this.getSession();
 			Connection con=session.connection();
// 			System.out.println(whereSql);
 			Statement st=con.createStatement();
 			ResultSet rs=st.executeQuery(whereSql);
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
 			this.releaseSession(session);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	

}
