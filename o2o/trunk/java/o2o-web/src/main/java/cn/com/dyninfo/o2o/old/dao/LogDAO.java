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

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

@Repository("logDAO")
public class LogDAO extends HibernateDaoSupport implements IBaseDAO {
	
	@Autowired
	public LogDAO(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public Object addObj(Object obj) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().save(obj);
	}

	public void delObj(Object obj) {
		this.getHibernateTemplate().delete(obj);

	}

	public void delObjById(String id) {
		// TODO Auto-generated method stub
		this.delObj(this.getObjById(id));
	}

	public int getCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from Log as n where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Query query = this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}

	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		StringBuffer sql=new StringBuffer(" from Log as n where 1=1 ");
		if(where!=null)
			sql.append(where);
		sql.append(" order by n.time desc ");
		Query query=this.getSession().createQuery(sql.toString());
		page.setTotalCount(query.list().size());
		query.setMaxResults(page.getPageSize());
		query.setFirstResult((page.getPageNo()-1)*page.getPageSize());
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("DATA", query.list());
		map.put("PAGE_INFO", page);
		return map;
	}

	public List<?> getListByWhere(StringBuffer where) {
		StringBuffer sql=new StringBuffer(" from Log as n where 1=1 ");
		if(where!=null)
			sql.append(where);
		sql.append(" order by n.time desc ");
		return this.getHibernateTemplate().find(sql.toString());
	}

	public Object getNextObj(Object obj) {
		
		return null;
	}

	public Object getObjById(String id) {
		List list=getListByWhere(new StringBuffer(" and n.id='"+id+"'" ));
		if(list.size()>0)return list.get(0);
		return null;
	}

	public Object getPreviousObj(Object obj) {
		
		return null;
	}

	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);

	}

	public List getObjlist(String where){
		return this.getHibernateTemplate().find(where);
	}

}
