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

import cn.com.dyninfo.o2o.furniture.admin.service.DictionaryService;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.DictionaryDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.DictionaryInfo;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

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
	private DictionaryDAO dictionaryDAO;

	
	public DictionaryInfo addObj(Object obj) {
		return dictionaryDAO.addObj(obj);
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				dictionaryDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		dictionaryDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		dictionaryDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return dictionaryDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return dictionaryDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return dictionaryDAO.getListByWhere(where);
	}

	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DictionaryInfo getObjById(String id) {
		return dictionaryDAO.getObjById(id);
	}

	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		DictionaryInfo dictionaryInfo=(DictionaryInfo)obj;
		dictionaryDAO.updateObj(dictionaryInfo);
		return dictionaryInfo.getId();
	}

	
}
