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
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.ControlGroupInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.GroupResRelation;

@Repository("controlGroupDAO")
public class ControlGroupDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public ControlGroupDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public List<ControlGroupInfo> getListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from ControlGroupInfo as controlInfo where 1=1 ");
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
		hsql.append(" from ControlGroupInfo as ControlInfo where 1=1 ");
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
		hsql.append("select count(*) from ControlGroupInfo as controlInfo where 1=1 ");
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
	
	public ControlGroupInfo getObjById(String id){
		List<ControlGroupInfo> list=this.getListByWhere(new StringBuffer().append(" and controlInfo.id='"+id+"'"));
		if(list.size()>0) return list.get(0);
		else return null;
	}
	/**
	 * 
	 * @param ControlGroupInfo
	 * @return
	 */
	
	public ControlGroupInfo addObj(Object obj){
		ControlGroupInfo controlInfo=(ControlGroupInfo)obj;
		String id=(String)this.getHibernateTemplate().save(controlInfo);
		controlInfo.setId(id);
		//
		Set<GroupResRelation> grrs = controlInfo.getGrr();
		if(grrs != null){
			for(GroupResRelation grr : grrs){
				grr.setCgi(controlInfo);
				id=(String)this.getHibernateTemplate().save(grr);
				grr.setId(id);
			}
		}
		//
		return controlInfo;
	}
	/**
	 * 
	 * @param ControlGroupInfo
	 */
	
	public void updateObj(Object obj){
		ControlGroupInfo controlInfo=(ControlGroupInfo)obj;
		//
		List<GroupResRelation> grrList = getGroupResRelationListByWhere(
				new StringBuffer(" and groupResRelation.cgi.id = '").append(controlInfo.getId()).append("' "));
		for(GroupResRelation grr : grrList){
			this.getHibernateTemplate().delete(grr);
		}
		//
		this.getHibernateTemplate().update(controlInfo);
		//
		Set<GroupResRelation> grrs = controlInfo.getGrr();
		if(grrs != null){
			for(GroupResRelation grr : grrs){
				grr.setCgi(controlInfo);
				String id=(String)this.getHibernateTemplate().save(grr);
				grr.setId(id);
			}
		}
	}
	/**
	 * 
	 * @param where
	 * @return
	 */
	public List<GroupResRelation> getGroupResRelationListByWhere(StringBuffer where){
		StringBuffer hsql=new StringBuffer();
		hsql.append(" from GroupResRelation as groupResRelation where 1=1 ");
		if(where!=null&&!where.toString().equals(""))
			hsql.append(where);
		return this.getHibernateTemplate().find(hsql.toString());
	}
	
	/**
	 * 根据资源模块名得到当前用户的数据访问权限
	 * @param userId 当前用户
	 * @param moduleName 资源模块名
	 * @return
	 */
	public GroupResRelation getGroupResRelationByResModuleName(String userId, String moduleName) {
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct g.ID, g.GROUP_ID, g.RC_ID, g.ACCESSTYPE, g.ACCESSOBJ from ");
		sql.append("BASE_RESCONTROL_RELATION as g, BASE_RES_INFO as a, BASE_ROLE_CONTROL as b,");
		sql.append("BASE_USER_ROLE as c where ");
		sql.append("g.RC_ID = a.ID and g.GROUP_ID = b.GROUP_ID and b.ROLE_ID = c.ROLE_ID ");
		sql.append("and c.USER_ID = '").append(userId).append("' ");
		sql.append("and a.MODULE_NAME = '").append(moduleName).append("' ");
		SQLQuery q = this.getSession().createSQLQuery(sql.toString());
		q.addEntity(GroupResRelation.class);
		List<GroupResRelation> list = (List<GroupResRelation>)q.list();
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}
	
	
	public GroupResRelation getGroupResRelationByResModuleId(String userId,
			String moduleId){
		StringBuffer sql=new StringBuffer();
		sql.append("select distinct g.ID, g.GROUP_ID, g.RC_ID, g.ACCESSTYPE, g.ACCESSOBJ from ");
		sql.append("BASE_RESCONTROL_RELATION as g, BASE_RES_INFO as a, BASE_ROLE_CONTROL as b,");
		sql.append("BASE_USER_ROLE as c where ");
		sql.append("g.RC_ID = a.ID and g.GROUP_ID = b.GROUP_ID and b.ROLE_ID = c.ROLE_ID ");
		sql.append("and c.USER_ID = '").append(userId).append("' ");
		sql.append("and a.ID = '").append(moduleId).append("' ");
		Session session=this.getSession();
		SQLQuery q = session.createSQLQuery(sql.toString());
		q.addEntity(GroupResRelation.class);
		List<GroupResRelation> list = (List<GroupResRelation>)q.list();
		this.releaseSession(session);
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
		
	}
	/**
	 * 
	 * @param ControlGroupInfo
	 */
	
	public void delObj(Object controlInfo){
		this.getHibernateTemplate().delete(controlInfo);
	}
	/**
	 * 
	 * @param id
	 */
	
	public void delObjById(String id){
		ControlGroupInfo controlInfo=this.getObjById(id);
		if(controlInfo!=null) this.delObj(controlInfo);
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
