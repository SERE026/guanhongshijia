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

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.old.dao.BaseDAO;
import cn.com.dyninfo.o2o.old.model.GoodsDelivery;

/**
 *  
 * @author lxf
 *
 */
@Repository("dlytypeDao")
public class DlytypeDao extends BaseDAO{
	@Autowired
	public DlytypeDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.setSessionFactory(sessionFactory);
		this.table="Dlytype";
	}
	
	public GoodsDelivery getDeliveryByGoodsId(String goods_id){
		List<GoodsDelivery> list=(List<GoodsDelivery>) this.getListByWhere(new StringBuffer(" and n.goods.goods_id="+goods_id));
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	
	

}
