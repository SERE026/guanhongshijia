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
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;

@Repository("resDAO")
public class ResDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public ResDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	
	public List<ResInfo> getListByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from ResInfo as resInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by resInfo.parent asc, resInfo.is_default asc, resInfo.index_order asc, resInfo.is_menu asc ");
		return this.getHibernateTemplate().find(hsql.toString());
	}
	
	public List<ResInfo> getListByWhere(String sql) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from ResInfo as resInfo ");
		if (sql != null && !sql.equals(""))
			hsql.append(sql);
		hsql.append(" order by resInfo.parent asc, resInfo.is_default asc, resInfo.index_order asc, resInfo.is_menu asc ");
		return this.getHibernateTemplate().find(hsql.toString());
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where, PageInfo page) {
		HashMap map = new HashMap();
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from ResInfo as resInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by resInfo.parent asc, resInfo.is_default asc, resInfo.index_order asc, resInfo.is_menu asc ");
		Query query = this.getSession().createQuery(hsql.toString());
		page.setTotalCount(query.list().size());
		query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List datas = query.list();
		map.put("PAGE_INFO", page);
		map.put("DATA", datas);
		return map;
	}
	
	/**
	 * 根据角色名称集合字符串得到资源
	 */
	public List<ResInfo> getListByRoles(String roleNames, String where) {
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct resInfo.ID, resInfo.RES_NAME, resInfo.IS_MENU, resInfo.URL,");
		sql.append("resInfo.PARENT_ID, resInfo.IS_DEFAULT, resInfo.INDEX_ORDER, resInfo.PS,");
		sql.append("resInfo.IMG_URL, resInfo.MODULE_NAME,resInfo.res_role from BASE_RES_INFO as resInfo, BASE_RESCONTROL_RELATION as a,");
		sql.append("BASE_ROLE_CONTROL as b, BASE_ROLE_INFO as c, BASE_RES_INFO as d ");
		sql.append("where resInfo.ID = a.RC_ID and a.GROUP_ID = b.GROUP_ID and b.ROLE_ID = c.ID ");
		sql.append("and resInfo.PARENT_ID = d.ID ");
		sql.append("and c.id in ("+roleNames+") ");
		if(where != null)
			sql.append(where);
		SQLQuery q = this.getSession().createSQLQuery(sql.toString());
		q.addEntity(ResInfo.class);
		return q.list();
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
	 * 
	 * @param where
	 * @return
	 */
	
	public int getCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from ResInfo as resInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Query query = this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public ResInfo getObjById(String id) {
		List<ResInfo> list = this.getListByWhere(new StringBuffer()
				.append(" and resInfo.id='" + id + "'"));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	
	
	public ResInfo addObj(Object obj) {
		ResInfo resInfo=(ResInfo)obj;
		String id = (String) this.getHibernateTemplate().save(resInfo);
		resInfo.setId(id);
		return resInfo;
	}

	/**
	 * 
	 * @param ResInfo
	 */
	
	public void updateObj(Object resInfo) {
		this.getHibernateTemplate().update(resInfo);
	}

	/**
	 * 
	 * @param ResInfo
	 */
	
	public void delObj(Object resInfo) {
		this.getHibernateTemplate().delete(resInfo);
	}

	/**
	 * 
	 * @param id
	 */
	public void delObjById(String id) {
		ResInfo resInfo = this.getObjById(id);
		if (resInfo != null)
			this.delObj(resInfo);
	}
	
	/**
	 * 根据id字符串得到资源名称串，以,分隔
	 * @param ids
	 * @return
	 */
	public String getResNamesByIds(String ids){
		StringBuffer where = new StringBuffer();
		if(ids != null && ids.indexOf(",") == -1){
			where.append(" and resInfo.id = '").append(ids).append("' ");
		}else if(ids != null){
			ids = "'"+ ids + "'";
			ids = ids.replaceAll(",", "','");
			where.append(" and resInfo.id in (").append(ids).append(") ");
		}
		List<ResInfo> list = this.getListByWhere(where);
		String result = "";
		for(int i=0; i<list.size(); i++){
			ResInfo res = list.get(i);
			result += res.getRes_name();
			if(i+1 < list.size())
				result += ",";
		}
		return result;
	}

}
