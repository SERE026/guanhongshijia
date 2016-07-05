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

package cn.com.dyninfo.o2o.furniture.web.publish.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.Refundorder;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantMoney;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.Withdrawal;

@Repository("merchantMoneyDAO")
public class MerchantMoneyDAO extends BaseDAO {

	
	@Autowired
	public MerchantMoneyDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="MerchantMoney";
	}

	
	/**
	 * 添加退款流水
	 * @param rOrder
	 * @return
	 */
	public boolean addRefundOrderMoney(Refundorder rOrder) {
		// 根据订单获取商家
		ShangJiaInfo merchant=rOrder.getOrder().getMerchants();
		// 创建店铺流水对象
		MerchantMoney money=new MerchantMoney();
		money.setMerchant(merchant);
		money.setMoney(-rOrder.getRefundmoney()); // 退款金额
		money.setFlag(0);//交易类型 支出
		money.setHuiyuan(rOrder.getOrder().getHuiyuan());
		money.setPs("订单："+ rOrder.getOrder().getOrder_id() + "，退款金额："+ rOrder.getRefundmoney() +"元。");
		money.setType(0);
		money.setOrder(rOrder.getOrder());
		this.getHibernateTemplate().save(money);
		merchant.setMoney(merchant.getMoney()+money.getMoney());
		this.getHibernateTemplate().update(merchant);
		
//		if(rOrder.getHuiyuan().getShangJiaInfo()!=null&&rOrder.getMerchants().getShangjia_id()!=
//			rOrder.getHuiyuan().getShangJiaInfo().getShangjia_id()){
//			//非归属会员购买
//			
//			String shangjiaName=rOrder.getHuiyuan().getShangJiaInfo().getName();
//			money=new MerchantMoney();
//			money.setMerchant(merchant);//店铺
//			money.setMoney(-rOrder.getOrderPrice()*Context.PROPORTRION);//交易金额
//			money.setFlag(0);//交易类型 支出
//			money.setHuiyuan(rOrder.getHuiyuan());
//			money.setPs("订单："+rOrder.getOrder_id()+"，支付金额："+rOrder.getOrderPrice()+"元。会员归属于："+shangjiaName+"，向<"+shangjiaName+">支付"+money.getMoney()+"元。");
//			money.setType(2);
//			money.setShangjia(rOrder.getHuiyuan().getShangJiaInfo());//向那个商家支付前
//			this.getHibernateTemplate().save(money);
//			merchant.setMoney(merchant.getMoney()+money.getMoney());
//			this.getHibernateTemplate().update(merchant);
//			addAttribution(rOrder);
//		}
		return true;
	}
	
	
	/**
	 * 添加订单购买流水
	 * @param order
	 * @return
	 */
	public boolean addOrderMoney(Order order){
		ShangJiaInfo merchant=order.getMerchants();
		MerchantMoney money=new MerchantMoney();
		money.setMerchant(merchant);//店铺
		money.setMoney(order.getOrderPrice());//交易金额
		money.setFlag(1);//交易类型 收入
		money.setHuiyuan(order.getHuiyuan());
		money.setPs("订单："+order.getOrder_id()+"，支付金额："+order.getOrderPrice()+"元。");
		money.setType(0);
		money.setOrder(order);
		this.getHibernateTemplate().save(money);
		merchant.setMoney(merchant.getMoney()+money.getMoney());
		this.getHibernateTemplate().update(merchant);
		
		if(order.getHuiyuan().getShangJiaInfo()!=null&&order.getMerchants().getShangjia_id()!=
			order.getHuiyuan().getShangJiaInfo().getShangjia_id()){
			//非归属会员购买
			
			String shangjiaName=order.getHuiyuan().getShangJiaInfo().getName();
			money=new MerchantMoney();
			money.setMerchant(merchant);//店铺
			money.setMoney(-order.getOrderPrice()*Context.PROPORTRION);//交易金额
			money.setFlag(0);//交易类型 支出
			money.setHuiyuan(order.getHuiyuan());
			money.setPs("订单："+order.getOrder_id()+"，支付金额："+order.getOrderPrice()+"元。会员归属于："+shangjiaName+"，向<"+shangjiaName+">支付"+money.getMoney()+"元。");
			money.setType(2);
			money.setShangjia(order.getHuiyuan().getShangJiaInfo());//向那个商家支付前
			this.getHibernateTemplate().save(money);
			merchant.setMoney(merchant.getMoney()+money.getMoney());
			this.getHibernateTemplate().update(merchant);
			addAttribution(order);
		}
		return true;
	}
	
	
	/**
	 * 店铺提现
	 * @param order
	 * @return
	 */
	public boolean addTX(Withdrawal info){
		ShangJiaInfo merchant=info.getMerchants();
		MerchantMoney money=new MerchantMoney();
		money.setMerchant(merchant);//店铺
		money.setMoney(-info.getMoney());//交易金额
		money.setFlag(0);//交易类型 支出
		money.setPs("提现："+info.getMoney()+"元");
		this.getHibernateTemplate().save(money);
		merchant.setMoney(money.getMoney()+merchant.getMoney());
		this.getHibernateTemplate().update(merchant);
		return true;
	}
	/**
	 * 添加归属购买流水
	 * @param order
	 * @return
	 */
	public boolean addAttribution(Order order){
		ShangJiaInfo merchant=order.getHuiyuan().getShangJiaInfo();
		MerchantMoney money=new MerchantMoney();
		money.setMerchant(merchant);//店铺
		money.setMoney(order.getOrderPrice()*Context.PROPORTRION);//交易金额
		money.setFlag(1);//交易类型 收入
		money.setShangjia(order.getMerchants());
		money.setHuiyuan(order.getHuiyuan());
		money.setPs("归属会员在："+order.getMerchants().getName()+"消费："+order.getOrderPrice()+"元，你获得:"+money.getMoney()+"元");
		money.setType(3);
		money.setOrder(order);
		this.getHibernateTemplate().save(money);
		merchant.setMoney(money.getMoney()+merchant.getMoney());
		this.getHibernateTemplate().update(merchant);
		return true;
	}
}
