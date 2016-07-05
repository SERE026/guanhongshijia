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

package cn.com.dyninfo.o2o.furniture.web.goods.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;

@Repository("goodsSpecDAO")
public class GoodsSpecDAO extends BaseDAO {

	@Autowired
	public GoodsSpecDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="GoodsSpec";
	}
	
	public Object getSpecVal(String id){
		List list=this.getHibernateTemplate().find(" from GoodsSpecVal as n where n.spec_val_id='"+id+"' ");
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public void updateSpecAndValStatus(int goods_id){
		Session session=this.getSession();
		try{
			Connection con=session.connection();
			Statement st=con.createStatement();
			st.executeUpdate(" update T_GOOD_SPEC set status=1 where GOODS_ID="+goods_id);
			st.executeUpdate(" update T_GOODS_SPEC_VAL set status=1 where GOODS_ID="+goods_id);
			st.close();
			con.close();
			this.releaseSession(session);
		}catch(Exception e){
			
		}
	}
}
