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
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;

/**
 *  DAO
 * @author Administrator
 *
 */
@Repository("aadvDao")
public class AadvDao extends BaseDAO{
	@Autowired
	public AadvDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="AadvInfo";
	}
	
	public List getGoodsByadv(String advId, String city, PageInfo page){
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from AdvGoods as n where 1=1 ");
		StringBuffer where = new StringBuffer();
		where.append(" and " +
				"n.adv.id='"+advId+"' "+(city.length()==0?" " +
						"and n.city.id is null ":"and n.city.id='"+city+"'")+
						"  order by n.orderIndex asc");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Object count=this.getSession().createQuery("select count(*) "+hsql).list().get(0);
		Query query = this.getSession().createQuery(hsql.toString());
		page.setTotalCount(Integer.parseInt(count+""));
		query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List datas = query.list();
		return datas;
		
	}
	
	public List getGoodsByadv(String advId, String city){
		
		return this.getHibernateTemplate().find(" from AdvGoods as n where " +
				"n.adv.id='"+advId+"' "+(city.length()==0?" " +
						"and n.city.id is null ":"and n.city.id='"+city+"'")+
						"  order by n.orderIndex asc " );
	}
	
	public void delGoods(String id){
		String sql="delete from T_ADV_GOODS where ADV_ID='"+id+"' ";
		try{
			Session session=this.getSession();
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/* (non-Javadoc)
	 * @see BaseDAO#delObj(java.lang.Object)
	 */
	@Override
	public void delObj(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

	/* (non-Javadoc)
	 * @see BaseDAO#delObjById(java.lang.String)
	 */
	@Override
	public void delObjById(String id) {
		Object obj = this.getObjById(id);
		this.delObj(obj);
	}

	/* (non-Javadoc)
	 * @see BaseDAO#getObjById(java.lang.String)
	 */
	@Override
	public Object getObjById(String id) {
		List list = this.getListByWhere(new StringBuffer(" and n.aadv_id = ").append(id));
		if(list != null && list.size() == 1)
			return list.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see BaseDAO#getListByWhere(java.lang.StringBuffer)
	 */
	@Override
	public List<?> getListByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from AadvInfo as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by n.orderIndex asc");
		return this.getHibernateTemplate().find(hsql.toString());
	};
	

}
