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

package cn.com.dyninfo.o2o.old.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.old.service.ControlGroupService;
import cn.com.dyninfo.o2o.old.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.dao.ControlGroupDAO;
import cn.com.dyninfo.o2o.old.model.ControlGroupInfo;
import cn.com.dyninfo.o2o.old.model.GroupResRelation;
import cn.com.dyninfo.o2o.old.model.OgnzInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;

@Scope("prototype")
@Service("controlGroupService")
public class ControlGroupServiceImpl implements ControlGroupService {
	
	public void delObjStatus(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void delObjStatusById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void delStatus(List<Object> objList) {
		// TODO Auto-generated method stub
		
	}

	@Resource
	private ControlGroupDAO controlGroupDAO;
	
	@Resource
	private UserService userService;
	
	
	public ControlGroupInfo addObj(Object obj) {
		return controlGroupDAO.addObj(obj);
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				controlGroupDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		controlGroupDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		controlGroupDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return controlGroupDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return controlGroupDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return controlGroupDAO.getListByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ControlGroupInfo getObjById(String id) {
		return controlGroupDAO.getObjById(id);
	}

	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		ControlGroupInfo cgi=(ControlGroupInfo)obj;
		controlGroupDAO.updateObj(cgi);
		return cgi.getId();
	}

	/**
	 * 根据资源模块名得到当前用户的数据访问权限
	 */
	
	public GroupResRelation getGroupResRelationByResModuleName(String userId, String moduleName) {
		return controlGroupDAO.getGroupResRelationByResModuleName(userId, moduleName);
	}
	
	
	public String getsql(HttpServletRequest request, String moduleName){
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		return getsql(user.getLogin_id(), moduleName);
	}

	
	public String getsql(String userId, String moduleName) {
		String sql=" and ognzInfo.parent is null ";
		GroupResRelation gr = getGroupResRelationByResModuleName(userId, moduleName);
		UserInfo user = (UserInfo)userService.getObjById(userId);
		if(gr!=null){
			if(gr.getAccessType().equals("1")){
				String ids=gr.getAccessObj();
				sql=" and ognzInfo.id in('"+ids.replace(",", "','")+"')";
			}else if(gr.getAccessType().equals("2")){
				String ids="";
				for(OgnzInfo info:user.getOgnzs()){
					ids+="'"+info.getId()+"',";
				}
				sql=" and ognzInfo.id in('"+ids.substring(0,ids.length()-1)+"')";
			}
		}
		return sql;
	}

	@Override
	public GroupResRelation getGroupResRelationByResModuleId(String userId,
			String moduleId) {
		// TODO Auto-generated method stub
		return controlGroupDAO.getGroupResRelationByResModuleId(userId, moduleId);
	}

}
