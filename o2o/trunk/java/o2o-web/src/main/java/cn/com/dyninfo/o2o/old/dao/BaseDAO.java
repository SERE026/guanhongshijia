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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

public class BaseDAO extends HibernateDaoSupport implements IBaseDAO {

	public String table="";

	@Autowired
	public  BaseDAO(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	
	public Object addObj(Object obj) {
		this.getHibernateTemplate().save(obj);
		return null;
	}

	
	public void delObj(Object obj) {
		this.getHibernateTemplate().delete(obj);

	}

	
	public void delObjById(String id) {
		Object obj = this.getObjById(id);
		if(obj != null)
			delObj(obj);

	}

	
	public int getCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from "+table+" as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Session session=this.getSession();
		Query query = session.createQuery(hsql.toString());
		int count=((Long) query.uniqueResult()).intValue();
		this.releaseSession(session);
		return count;
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		HashMap map = new HashMap();
		try{
			StringBuffer hsql = new StringBuffer();
			hsql.append(" from "+table+" as n where 1=1 ");
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

	
	public List<?> getListByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from "+table+" as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		return this.getHibernateTemplate().find(hsql.toString());
	}

	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getObjById(String id) {
		List list = this.getListByWhere(new StringBuffer()
		.append(" and n.id='" + id + "'"));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);

	}
	
	public void closeSession(Session session){
		releaseSession(session);
	}
	public void updateOrder() {
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			int c=24*60*60;
			int ctime=(int) (new Date().getTime()/1000);
			st.executeUpdate("update  t_order_info set state='5' where state='4' and SEND_LONG < "+(ctime-c));
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
