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

import cn.com.dyninfo.o2o.old.service.LogService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.dao.LogDAO;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Resource
	private LogDAO logdao;
	
	public Object addObj(Object obj) {
		// TODO Auto-generated method stub
		logdao.addObj(obj);
		return null;
	}
	
	

	
	public String del(List<Object> objList) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String delObj(Object obj) {
		// TODO Auto-generated method stub
		logdao.delObj(obj);
		return null;
	}

	
	public String delObjById(String id) {
		// TODO Auto-generated method stub
		logdao.delObjById(id);
		return null;
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

	
	public int getCountByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		// TODO Auto-generated method stub
		return logdao.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return logdao.getListByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getObjById(String id) {
		// TODO Auto-generated method stub
		return logdao.getObjById(id);
	}

	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		// TODO Auto-generated method stub
		logdao.updateObj(obj);
		return null;
	}





	@Override
	public String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}

}
