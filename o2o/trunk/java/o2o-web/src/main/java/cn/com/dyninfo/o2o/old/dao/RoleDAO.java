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

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;

@Repository("roleDAO")
public class RoleDAO extends HibernateDaoSupport implements IBaseDAO,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public RoleDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	public List<RoleInfo> getListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from RoleInfo as rif where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by rif.index_order asc");
		return this.getHibernateTemplate().find(hsql.toString());
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	public int getCountByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append("select count(*) from RoleInfo as rif where 1=1 ");
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
	public RoleInfo getObjById(String id){
		List<RoleInfo> list=this.getListByWhere(new StringBuffer().append(" and rif.id='"+id+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}
	/**
	 * 
	 * @param RoleInfo
	 * @return
	 */
	
	public RoleInfo addObj(Object obj){
		RoleInfo roleinfo=(RoleInfo)obj;
		String id=(String)this.getHibernateTemplate().save(roleinfo);
		roleinfo.setId(id);
		return roleinfo;
	}
	/**
	 * 
	 * @param RoleInfo
	 */
	
	public void updateObj(Object obj){
		this.getHibernateTemplate().update(obj);
	}
	/**
	 * 
	 * @param id
	 */
	public void delObjById(String id){
		RoleInfo roleinfo=this.getObjById(id);
		if(roleinfo!=null) this.delObj(roleinfo);
	}
	
	
	public void delObj(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}
	
	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where, PageInfo page) {
		HashMap map=new HashMap();
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from RoleInfo as rif where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by rif.index_order asc");
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
	
	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 根据id字符串得到资源名称串，以,分隔
	 * @param ids
	 * @return
	 */
	public String getRoleNamesByIds(String ids){
		StringBuffer where = new StringBuffer();
		if(ids != null && ids.indexOf(",") == -1){
			where.append(" and rif.id = '").append(ids).append("' ");
		}else if(ids != null){
			ids = "'"+ ids + "'";
			ids = ids.replaceAll(",", "','");
			where.append(" and rif.id in (").append(ids).append(") ");
		}
		List<RoleInfo> list = this.getListByWhere(where);
		String result = "";
		for(int i=0; i<list.size(); i++){
			RoleInfo role = list.get(i);
			result += role.getRole_c_name();
			if(i+1 < list.size())
				result += ",";
		}
		return result;
	}
}
