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

import cn.com.dyninfo.o2o.old.model.GoodsType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Administrator
 *
 */
@Repository("goodsTypeDAO")
public class GoodsTypeDAO extends BaseDAO{
     @Autowired
	public GoodsTypeDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="GoodsType";
	}

	@Override
	public void updateObj(Object obj) {
		if(obj instanceof GoodsType){
			GoodsType type=(GoodsType) obj;
			List list=this.getHibernateTemplate().find("from GoodsTypeSpec as n where n.type.goodsType_id='"+type.getGoodsType_id()+"' ");
			for(Object spec:list){
				this.getHibernateTemplate().delete(spec);
			}
		}
		super.updateObj(obj);
	}

}
