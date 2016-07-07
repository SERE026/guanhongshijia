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

import cn.com.dyninfo.o2o.furniture.admin.model.AgentGrade;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dyninfo on 2016/7/6.
 */
@Repository("agentGradeDAO")
public class AgentGradeDAO extends HibernateDaoSupport implements IBaseDAO {

    @Autowired
    public AgentGradeDAO(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public List<AgentGrade> getListByWhere(StringBuffer where) {
        StringBuffer hsql=new StringBuffer();
        hsql.append(" from AgentGrade as ag where 1=1 ");
        if(where!=null&&!where.toString().equals(""))
            hsql.append(where);
        hsql.append(" order by ag.id asc");
        return this.getHibernateTemplate().find(hsql.toString());
    }

    @Override
    public HashMap<String, AgentGrade> getListByPageWhere(StringBuffer where, PageInfo page) {
        HashMap map=new HashMap();
        StringBuffer hsql=new StringBuffer();
        hsql.append(" from AgentGrade as ag where 1=1 ");
        if(where!=null&&!where.toString().equals(""))
            hsql.append(where);
        hsql.append(" order by ag.id asc");
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

    @Override
    public int getCountByWhere(StringBuffer where) {
        StringBuffer hsql=new StringBuffer();
        hsql.append("select count(*) from AgentGrade as ag where 1=1 ");
        if(where!=null&&!where.toString().equals(""))
            hsql.append(where);
        Query query =this.getSession().createQuery(hsql.toString());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public AgentGrade getObjById(String id) {
        List<AgentGrade> list=this.getListByWhere(new StringBuffer().append(" and ag.id='"+id+"'"));
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Object getNextObj(Object obj) {
        return null;
    }

    @Override
    public Object getPreviousObj(Object obj) {
        return null;
    }

    @Override
    public Object addObj(Object obj) {
        AgentGrade agentGrade = (AgentGrade)obj;
        Integer id=(Integer)this.getHibernateTemplate().save(agentGrade);
        agentGrade.setId(id);
        return agentGrade;
    }

    @Override
    public void updateObj(Object obj) {
        this.getHibernateTemplate().update(obj);
    }

    @Override
    public void delObj(Object obj) {
        this.getHibernateTemplate().delete(obj);
    }

    @Override
    public void delObjById(String id) {
        AgentGrade agentGrade=this.getObjById(id);
        if(agentGrade!=null) this.delObj(agentGrade);
    }
}
