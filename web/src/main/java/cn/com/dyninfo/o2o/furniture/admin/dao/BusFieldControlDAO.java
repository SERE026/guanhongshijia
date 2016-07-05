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

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.BusFieldControlInfo;

@Repository("busFieldControlDAO")
public class BusFieldControlDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public BusFieldControlDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public List<BusFieldControlInfo> getListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from BusFieldControlInfo as busFieldControlInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		return this.getHibernateTemplate().find(hsql.toString());
	}
	/**
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	
	public HashMap getListByPageWhere(StringBuffer where,PageInfo page){
		HashMap map=new HashMap();
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from BusFieldControlInfo as busFieldControlInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		Query query =this.getSession().createQuery(hsql.toString());
		page.setTotalCount(query.list().size());
		query.setFirstResult((page.getPageNo() - 1)
				* page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List datas =query.list();
		map.put("PAGE_INFO", page);
		map.put("DATA", datas);
		return map;
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public int getCountByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append("select count(*) from BusFieldControlInfo as busFieldControlInfo where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		Query query =this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public BusFieldControlInfo getObjById(String id){
		List<BusFieldControlInfo> list=this.getListByWhere(new StringBuffer().append(" and busFieldControlInfo.id='"+id+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}
	/**
	 * 
	 * @param BusFieldControlInfo
	 * @return
	 */
	
	public BusFieldControlInfo addObj(Object obj){
		BusFieldControlInfo busfieldcon = (BusFieldControlInfo)obj;
		String id=(String)this.getHibernateTemplate().save(busfieldcon);
		busfieldcon.setId(id);
		return busfieldcon;
	}
	/**
	 * 
	 * @param BusFieldControlInfo
	 */
	
	public void updateObj(Object busfieldcon){
		this.getHibernateTemplate().update(busfieldcon);
	}
	/**
	 * 
	 * @param BusFieldControlInfo
	 */
	
	public void delObj(Object busfieldcon){
		this.getHibernateTemplate().delete(busfieldcon);
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delObjById(String id){
		BusFieldControlInfo busfieldcon=this.getObjById(id);
		if(busfieldcon!=null) this.delObj(busfieldcon);
	}
	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
