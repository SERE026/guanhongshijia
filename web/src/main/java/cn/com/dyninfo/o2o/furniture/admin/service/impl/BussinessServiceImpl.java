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

import cn.com.dyninfo.o2o.furniture.admin.service.BussinessService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.BussinessDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.BusinessInfo;

/**
 * 业务表
 * @author Administrator
 *
 */
@Scope("prototype")
@Service("bussinessService")
public class BussinessServiceImpl implements BussinessService {

	@Resource
	private BussinessDAO bussinessDAO;

	
	public BusinessInfo addObj(Object obj) {
		return bussinessDAO.addObj(obj);
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

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				bussinessDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		bussinessDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		bussinessDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return bussinessDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return bussinessDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return bussinessDAO.getListByWhere(where);
	}

	
	public BusinessInfo getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BusinessInfo getObjById(String id) {
		return bussinessDAO.getObjById(id);
	}

	
	public BusinessInfo getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		BusinessInfo businessInfo=(BusinessInfo)obj;
		bussinessDAO.updateObj(businessInfo);
		return businessInfo.getId();
	}
	
	
}
