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

package cn.com.dyninfo.o2o.furniture.web.member.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanMoney;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;

@Repository("huiyuanMoneyDAO")
public class HuiyuanMoneyDAO extends BaseDAO {

	@Autowired
	public HuiyuanMoneyDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="HuiyuanMoney";
	}
	
	/**
	 * 订单支付
	 * @param order
	 * @return
	 */
	public boolean addOder(Order order){
		HuiyuanMoney money=new HuiyuanMoney();
		money.setFlag(0);
		money.setMoney(-order.getOrderPrice());
		money.setOrder(order);
		money.setPs("订单："+order.getOrder_id()+"，支付："+order.getOrderPrice());
		money.setHuiyuan(order.getHuiyuan());
		money.setDate(new Date());
		this.getHibernateTemplate().save(money);
		HuiyuanInfo  huiyuan=order.getHuiyuan();
		huiyuan.setMoney(huiyuan.getMoney()+money.getMoney());
		this.getHibernateTemplate().update(huiyuan);
		return true;
	}
	
	/**
	 * 账户充值
	 * @param money
	 * @param zffs
	 * @return
	 */
	public boolean addTopup(double money,Zffs zffs,HuiyuanInfo huiyuan){
		HuiyuanMoney huiyuanmoney=new HuiyuanMoney();
		huiyuanmoney.setFlag(1);
		huiyuanmoney.setMoney(money);
		huiyuanmoney.setDate(new Date());
		huiyuanmoney.setPs("通过"+zffs.getName()+"充值"+money);
		huiyuanmoney.setHuiyuan(huiyuan);
		
		
		huiyuan=this.getHibernateTemplate().load(HuiyuanInfo.class, huiyuan.getHuiYuan_id());
		huiyuan.setMoney(huiyuan.getMoney()+money);
		this.getHibernateTemplate().update(huiyuan);
		
		this.getHibernateTemplate().save(huiyuanmoney);
		return true;
	}

}
