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
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
/**
 * 
 * @author Administrator
 *
 */
@Repository("pageModuleDAO")
public class PageModuleDAO extends BaseDAO{
     @Autowired
	public PageModuleDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="PageModule";
	}
     
    public void delPagModInGoodsByPagModID(int id){
    	Query query=this.getSession().createSQLQuery("delete from t_pagemodule_in_goods where PAGEMODULE_ID = "+id);
    	query.executeUpdate();
    }
    
    
    public HashMap<String, ?> getGoodsOrder(StringBuffer where,
			PageInfo page) {
    	HashMap map = new HashMap();
    	Query query0=this.getSession().createQuery("select count(*) coun "+
    			"from " +
				"t_shangjia_info sj, t_pagemodule_in_goods gd, t_pagemodule pag ," +
			    "t_goods goods" 
			+"where " +
        	"gd.PAGEMODULE_ID =pag.PAGEMODULE_ID and gd.GOOD_ID=goods.GOODS_ID AND " +
        	"sj.SHANGJIA_ID=goods.SHANGJIAINFO_ID"+where);
    	Map mapcout=(Map) query0.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list().get(0);
    	String count=(String) mapcout.get("coun");
		Query query = this.getSession().createSQLQuery("select gd.INDEXS,pag.NAME " +
				"MOD_NAME,sj.NAME SJ_NAME,goods.NAME g_name ,gd.EXPIRE_TIME EXPIRE_TIME " +
				"from " +
				"t_shangjia_info sj, t_pagemodule_in_goods gd, t_pagemodule pag ," +
				    "t_goods goods" 
				+"where " +
            	"gd.PAGEMODULE_ID =pag.PAGEMODULE_ID and gd.GOOD_ID=goods.GOODS_ID AND " +
            	"sj.SHANGJIA_ID=goods.SHANGJIAINFO_ID "+where);
		page.setTotalCount(Integer.parseInt(count+""));
		query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
		query.setMaxResults(page.getPageSize());
		map.put("PAGE_INFO", page);
		map.put("DATA", query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
		return map;
	}
}
