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

import cn.com.dyninfo.o2o.furniture.admin.model.OgnzInfo;

@Repository("ognzDAO")
public class OgnzDAO extends HibernateDaoSupport implements IBaseDAO {
	@Autowired
	public OgnzDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	
	public List<OgnzInfo> getListByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from OgnzInfo as ognzInfo where 1=1 and ognzInfo.isUsed='1' ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by ognzInfo.index_order asc");
		return this.getHibernateTemplate().find(hsql.toString());
	}

	/**
	 * 
	 * @param where
	 * @param page
	 * @return
	 */
	
	public HashMap getListByPageWhere(StringBuffer where, PageInfo page) {
		HashMap map = new HashMap();
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from OgnzInfo as ognzInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" and ognzInfo.isUsed='1'");
		hsql.append(" order by ognzInfo.index_order asc");
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
	 * 根据ID串得到部门名称字符串
	 * 使用,分隔
	 * @param ids
	 * @return
	 */
	public String getOgnzNamesByIds(String ids){
		StringBuffer where = new StringBuffer();
		if(ids != null && ids.indexOf(",") == -1){
			where.append(" and ognzInfo.id = '").append(ids).append("' ");
		}else if(ids != null){
			ids = "'"+ ids + "'";
			ids = ids.replaceAll(",", "','");
			where.append(" and ognzInfo.id in (").append(ids).append(") ");
		}
		where.append("  and ognzInfo.isUsed='1' ");
		
		List<OgnzInfo> list = getListByWhere(where);
		String result = "";
		for(int i=0; i<list.size(); i++){
			OgnzInfo ognz = list.get(i);
			result += ognz.getOgnz_name();
			if(i+1 < list.size())
				result += ",";
		}
		return result;
	}

	/**
	 * 
	 * @param where
	 * @return
	 */
	
	public int getCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from OgnzInfo as ognzInfo where 1=1  and ognzInfo.isUsed='1' ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		hsql.append(" order by ognzInfo.index_order asc");
		Query query = this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public OgnzInfo getObjById(String id) {
		List<OgnzInfo> list = this.getListByWhere(new StringBuffer(" and ognzInfo.id='" + id + "'"));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * 
	 * @param ognzInfo
	 * @return
	 */
	
	public OgnzInfo addObj(Object obj) {
		OgnzInfo ognzInfo=(OgnzInfo)obj;
		String id="";
		if(ognzInfo.getParent()!=null){
			List list=this.getHibernateTemplate().find(" from OgnzInfo as n where n.parent.id='"+ognzInfo.getParent().getId()+"' ");
			id=(list.size()+1)+"";
			if(id.length()==1)
				id="00"+id;
			else if(id.length()==2){
				id="0"+id;
			}
			ognzInfo.setId(ognzInfo.getParent().getId()+id);
			}
		else{
			List list=this.getHibernateTemplate().find(" from OgnzInfo as n where n.parent is null ");
			id=('a'+list.size())+"";
			ognzInfo.setId(id);
		}
		this.getHibernateTemplate().save(ognzInfo);
		return ognzInfo;
	}

	/**
	 * 
	 * @param ognzInfo
	 */
	
	public void updateObj(Object ognzInfo) {
		this.getHibernateTemplate().update(ognzInfo);
	}

	/**
	 * 
	 * @param ognzInfo
	 */
	
	public void delObj(Object ognzInfo) {
		this.getHibernateTemplate().delete(ognzInfo);
	}

	/**
	 * 
	 * @param id
	 */
	
	public void delObjById(String id) {
		OgnzInfo ognzInfo = this.getObjById(id);
		if (ognzInfo != null){
			ognzInfo.setIsUsed("0");
			this.updateObj(ognzInfo);
		}
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
