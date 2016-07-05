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

/**
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

import cn.com.dyninfo.o2o.furniture.admin.model.AttachmentInfo;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

/**
 * 附件访问类
 * @author jettang
 * Mar 28, 2011
 */
@Repository("attachmentDAO")
public class AttachmentDAO extends HibernateDaoSupport implements IBaseDAO {
	
	@Autowired
	public AttachmentDAO(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	
	public Object addObj(Object obj) {
		AttachmentInfo attachmentInfo=(AttachmentInfo)obj;
		String id = (String) this.getHibernateTemplate().save(attachmentInfo);
		attachmentInfo.setId(id);
		return attachmentInfo;
	}

	
	public void delObj(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

	
	public void delObjById(String id) {
		AttachmentInfo attachmentInfo = (AttachmentInfo)this.getObjById(id);
		if (attachmentInfo != null)
			this.delObj(attachmentInfo);
	}

	
	public int getCountByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append("select count(*) from AttachmentInfo as attachmentInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Query query = this.getSession().createQuery(hsql.toString());
		return ((Long) query.uniqueResult()).intValue();
	}
	
	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		HashMap map = new HashMap();
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from AttachmentInfo as attachmentInfo where 1=1 ");
		if (where != null && !where.toString().equals(""))
			hsql.append(where);
		Query query = this.getSession().createQuery(hsql.toString());
		page.setTotalCount(query.list().size());
		query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List datas = query.list();
		map.put("PAGE_INFO", page);
		map.put("DATA", datas);
		return map;
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		StringBuffer hsql = new StringBuffer();
		hsql.append(" from AttachmentInfo as attachmentInfo where 1=1 ");
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
			.append(" and attachmentInfo.id='" + id + "'"));
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	/**
	 * 
	 * @param docID
	 * @return
	 */
	public List getObjsByDocID(String docID){
		return this.getListByWhere(new StringBuffer()
			.append(" and attachmentInfo.docID='" + docID + "'"));
	}
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);
	}
	
	public void deleteByDocID(String docID) {
		List list = this.getObjsByDocID(docID);
		this.getHibernateTemplate().deleteAll(list);
	}
	
	public void deleteByFileName(String fileName) {
		List list = this.getListByWhere(new StringBuffer(" and attachmentInfo.fileName = '").append(fileName).append("' "));
		this.getHibernateTemplate().deleteAll(list);
	}

}
