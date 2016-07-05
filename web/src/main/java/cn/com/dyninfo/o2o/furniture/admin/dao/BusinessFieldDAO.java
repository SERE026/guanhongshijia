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

import cn.com.dyninfo.o2o.furniture.admin.model.BusinessFiledInfo;

@Repository("busFieldDAO")
public class BusinessFieldDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public BusinessFieldDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public List<BusinessFiledInfo> getListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from BusinessFiledInfo as businessFiledInfo where 1=1 ");
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
		hsql.append(" from BusinessFiledInfo as businessFiledInfo where 1=1 ");
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
		hsql.append("select count(*) from BusinessFiledInfo as businessFiledInfo where 1=1 ");
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
	
	public BusinessFiledInfo getObjById(String id){
		List<BusinessFiledInfo> list=this.getListByWhere(new StringBuffer().append(" and businessFiledInfo.id='"+id+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}
	/**
	 * 
	 * @param BusinessFiledInfo
	 * @return
	 */
	
	public BusinessFiledInfo addObj(Object obj){
		BusinessFiledInfo busField = (BusinessFiledInfo)obj;
		String id=(String)this.getHibernateTemplate().save(busField);
		busField.setId(id);
		return busField;
	}
	/**
	 * 
	 * @param BusinessFiledInfo
	 */
	
	public void updateObj(Object busField){
		this.getHibernateTemplate().update(busField);
	}
	/**
	 * 
	 * @param BusinessFiledInfo
	 */
	
	public void delObj(Object busField){
		this.getHibernateTemplate().delete(busField);
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delObjById(String id){
		BusinessFiledInfo busField=this.getObjById(id);
		if(busField!=null) this.delObj(busField);
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
