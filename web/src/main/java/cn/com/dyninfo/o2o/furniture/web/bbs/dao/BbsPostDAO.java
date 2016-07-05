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

package cn.com.dyninfo.o2o.furniture.web.bbs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.dyninfo.o2o.furniture.admin.dao.BaseDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsUserInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

@Repository("bbsPostDAO")
public class BbsPostDAO extends BaseDAO {

	@Autowired
	public BbsPostDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.table="BbsPostInfo";
	}

	/**
	 * 
	 * @param id
	 * @param role管理人员 admin 会员member
	 * @return
	 */
	public BbsUserInfo getUser(String id,String role){
		List<BbsUserInfo> list=this.getHibernateTemplate().find(" from BbsUserInfo as n where n.bbs_id='"+role+id+"' ");
		if(list.size()>0){
			return list.get(0);
		}else{
			BbsUserInfo bu=new BbsUserInfo();
			bu.setLev(0);
			bu.setBbs_id(role+id);
			if(role.equals("admin")){
				UserInfo user=this.getHibernateTemplate().load(UserInfo.class, id);
				bu.setName(user.getUser_name());
				bu.setLev(5);
			}else{
				HuiyuanInfo user=this.getHibernateTemplate().load(HuiyuanInfo.class, Integer.parseInt(id));
				bu.setName(user.getUserName());
				bu.setImage(user.getTxImage());
			}
			this.getHibernateTemplate().save(bu);
			return bu;
		}
	}
}
