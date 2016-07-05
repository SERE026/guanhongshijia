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

import cn.com.dyninfo.o2o.furniture.admin.service.OgnzService;
import org.springframework.context.annotation.Scope;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.OgnzDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.OgnzInfo;

@RemotingDestination("ognzService")
@Scope("prototype")
@Service("ognzService")
public class OgnzServiceImpl implements OgnzService {
	
	@Resource
	private OgnzDAO ognzDAO;

	
	
	public OgnzInfo addObj(Object obj) {
		return ognzDAO.addObj(obj);
	}
	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				ognzDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String delObj(Object obj) {
		ognzDAO.delObj(obj);
		return "0";
	}
	
	public String delObjById(String id) {
		ognzDAO.delObjById(id);
		return "0";
	}
	
	public int getCountByWhere(StringBuffer where) {
		return ognzDAO.getCountByWhere(where);
	}
	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return ognzDAO.getListByPageWhere(where, page);
	}
	
	public List<?> getListByWhere(StringBuffer where) {
		return ognzDAO.getListByWhere(where);
	}
	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OgnzInfo getObjById(String id) {
		return ognzDAO.getObjById(id);
	}
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String updateObj(Object obj) {
		OgnzInfo ognz=(OgnzInfo)obj;
		ognzDAO.updateObj(ognz);
		return ognz.getId();
	}
	
	public String getOgnzXMLTree(OgnzInfo ognzInfo) {
		String xml="";
		OgnzInfo parentOgnz=null;
		if(ognzInfo==null){
			List<OgnzInfo> ognzList=ognzDAO.getListByWhere(new StringBuffer(" and ognzInfo.parent is null "));
			if(ognzList!=null) parentOgnz=ognzList.get(0);
		}else parentOgnz=ognzDAO.getObjById(ognzInfo.getId());
		if(parentOgnz!=null){
			xml+="<?xml version='1.0' encoding='UTF-8'?>";
			xml+=objToXML(parentOgnz);
		}
		return xml;
	}
	/**
	 * 递归方法
	 * @param ognzInfo
	 * @return
	 */
	
	public String objToXML(OgnzInfo ognzInfo){
		String xml="";
		xml+="<ognz id='"+ognzInfo.getId()+"' ognz_name='"+ognzInfo.getOgnz_name()+"' isUsed='"+ognzInfo.getIsUsed()+"' ";
		xml+="isognz='"+ognzInfo.getIsognz()+"' index_order='"+ognzInfo.getIndex_order()+"' ps='"+ognzInfo.getPs()+"'>";
		if(ognzInfo.getChildren()!=null){
			for(OgnzInfo childrenOgnz:ognzInfo.getChildren()){
				xml+=objToXML(childrenOgnz);
			}
		}
		xml+="</ognz>";
		return xml;
	}
	/**
	 * 根据ID串得到部门名称字符串 使用,分隔
	 */
	
	public String getOgnzNamesByIds(String ids) {
		return ognzDAO.getOgnzNamesByIds(ids);
	}
	
	
	public String getognzids(OgnzInfo in) {
		String result = "'"+in.getId()+"',";
		for(OgnzInfo info:in.getChildren()){
			result += getognzids(info)+",";
		}
		if(result.length()>0 && result.endsWith(","))
			return result.substring(0,result.length()-1);
		else
			return result;
	}
	
	
	public String getcompanyid(List<OgnzInfo> list) {
		String result = "";
		for(OgnzInfo info:list){
			result += getognzids(info)+",";
		}
		if(result.length()>0 && result.endsWith(","))
			return result.substring(0,result.length()-1);
		else
			return result;
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
