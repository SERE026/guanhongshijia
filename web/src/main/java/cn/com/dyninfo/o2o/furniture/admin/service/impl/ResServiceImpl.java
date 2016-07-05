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

import cn.com.dyninfo.o2o.furniture.admin.service.ResService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.ResDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;

@Service("resService")
public class ResServiceImpl implements ResService {

	@Resource
	private ResDAO resDAO;

	
	public ResInfo addObj(Object obj) {
		return resDAO.addObj(obj);
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

	/**
	 * 根据id字符串得到名称字符串，以,分隔
	 */
	
	public String getResNamesByIds(String ids) {
		return resDAO.getResNamesByIds(ids);
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				resDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		resDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		resDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return resDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return resDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return resDAO.getListByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResInfo getObjById(String id) {
		return resDAO.getObjById(id);
	}

	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		ResInfo resInfo=(ResInfo)obj;
		resDAO.updateObj(resInfo);
		return resInfo.getId();
	}

	/**
	 * 根据角色名称集合字符串得到资源
	 */
	
	public List<ResInfo> getListByRoles(String roleNames, String where) {
		
		return resDAO.getListByRoles(roleNames, where);
	}


	
}
