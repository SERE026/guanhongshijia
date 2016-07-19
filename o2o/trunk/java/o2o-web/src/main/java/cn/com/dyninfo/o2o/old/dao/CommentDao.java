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

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
@Repository("commentDao")
public class CommentDao extends BaseDAO{
     @Autowired
	public CommentDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="CommentInfo";
	}

     public List getListLeftByWhere(StringBuffer where,PageInfo page) {
    	 
    		StringBuffer hsql = new StringBuffer();
			hsql.append(" select n from HuiyuanInfo h left join h.comment as n where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			hsql.append(" order by n.time desc, n.indexs asc ");
			Query query = this.getSession().createQuery(hsql.toString());
			query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
			query.setMaxResults(page.getPageSize());
			List datas = query.list();
			return datas;
     }
     
     public int getListLeftCount(StringBuffer where,PageInfo page) {
 		StringBuffer hsql = new StringBuffer();
			hsql.append(" from HuiyuanInfo h left join h.comment as n where 1=1 ");
			if (where != null && !where.toString().equals(""))
				hsql.append(where);
			hsql.append(" order by n.time desc, n.indexs asc ");
			Object count=this.getSession().createQuery("select count(*) "+hsql).list().get(0);
			return Integer.parseInt(count+"");
  }
}
