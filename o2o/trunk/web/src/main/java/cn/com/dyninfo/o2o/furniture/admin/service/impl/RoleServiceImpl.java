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

package cn.com.dyninfo.o2o.furniture.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.furniture.admin.service.RoleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.RoleDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;
@Scope("prototype")
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDAO roleDAO;
	
	
	public RoleInfo addObj(Object roleInfo) {
		return roleDAO.addObj(roleInfo);
	}

	
	public String delObj(Object roleInfo) {
		roleDAO.delObj(roleInfo);
		return "0";
	}

	public void delObjStatus(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void delObjStatusById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void delStatus(List<Object> objList) {
		// TODO Auto-generated method stub
		
	}

	
	public String delObjById(String id) {
		roleDAO.delObjById(id);
		return "0";
	}

	
	public RoleInfo getObjById(String id){
		return roleDAO.getObjById(id);
	}

	
	public List<RoleInfo> getListByWhere(StringBuffer where) {
		return roleDAO.getListByWhere(where);
	}

	
	public HashMap<String,?> getListByPageWhere(StringBuffer where,
			PageInfo pageInfo) {
		return roleDAO.getListByPageWhere(where, pageInfo);
	}

	
	public String updateObj(Object obj) {
		RoleInfo roleInfo=(RoleInfo)obj;
		roleDAO.updateObj(roleInfo);
		return roleInfo.getId();
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				roleDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public int getCountByWhere(StringBuffer where) {
		return roleDAO.getCountByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getRoleNamesByIds(String ids) {
		return roleDAO.getRoleNamesByIds(ids);
	}
	
	
}
