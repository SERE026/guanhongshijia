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

import cn.com.dyninfo.o2o.furniture.admin.service.BussinessFieldService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.BusinessFieldDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.BusinessFiledInfo;
@Scope("prototype")
@Service("busFieldService")
public class BussinessFieldServiceImpl implements BussinessFieldService {

	@Resource
	private BusinessFieldDAO busFieldDAO;

	
	public BusinessFiledInfo addObj(Object obj) {
		return busFieldDAO.addObj(obj);
	}

	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				busFieldDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public String delObj(Object obj) {
		busFieldDAO.delObj(obj);
		return "0";
	}

	
	public String delObjById(String id) {
		busFieldDAO.delObjById(id);
		return "0";
	}

	
	public int getCountByWhere(StringBuffer where) {
		return busFieldDAO.getCountByWhere(where);
	}

	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return busFieldDAO.getListByPageWhere(where, page);
	}

	
	public List<?> getListByWhere(StringBuffer where) {
		return busFieldDAO.getListByWhere(where);
	}

	
	public BusinessFiledInfo getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BusinessFiledInfo getObjById(String id) {
		return busFieldDAO.getObjById(id);
	}

	
	public BusinessFiledInfo getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateObj(Object obj) {
		BusinessFiledInfo bfi=(BusinessFiledInfo)obj;
		busFieldDAO.updateObj(bfi);
		return bfi.getId();
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
	
	
}
