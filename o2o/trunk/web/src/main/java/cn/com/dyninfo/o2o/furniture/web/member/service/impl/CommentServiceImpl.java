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

package cn.com.dyninfo.o2o.furniture.web.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.BaseService;
import cn.com.dyninfo.o2o.furniture.web.member.dao.CommentDao;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.order.dao.OrderProductDao;

@Service("commentService")
public class CommentServiceImpl  extends BaseService implements CommentService{

	    @Resource
	    private CommentDao commentDao;
	    @Resource
	    private OrderProductDao orderProductDao;
	    @Override
	    public void initDao(){
	    	super.initDao();
	    	this.baseDao=commentDao;
	    }
	    public boolean addObj(Object obj1,Object obj2){
	    	Session session = commentDao.getSessionFactory().openSession();
	    	Transaction tx = session.getTransaction();
	    	tx.begin();
	    	try {
	           commentDao.addObj(obj1);
	           orderProductDao.addObj(obj2);
	            tx.commit();
	            return true;
	        } catch (Exception e) {
	            tx.rollback();
	        } finally{
	        }
	    	return false;
	    }
		@Override
		public List getListLeftByWhere(StringBuffer where,PageInfo page) {
			return commentDao.getListLeftByWhere(where, page);
		}
	    
		@Override
		public int getListLeftCount(StringBuffer where,PageInfo page) {
			return commentDao.getListLeftCount(where, page);
		}
}
