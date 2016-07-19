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

/**
 * 
 */
package cn.com.dyninfo.o2o.old.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.old.service.MessageService;
import cn.com.dyninfo.o2o.old.dao.UserMessageDAO;
import cn.com.dyninfo.o2o.old.model.AccaptMessageInfo;
import cn.com.dyninfo.o2o.old.model.UserMessageInfo;

import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

/**
 * @author Administrator
 *
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private UserMessageDAO userMessageDAO;

	public Object addObj(Object obj) {
		// TODO Auto-generated method stub
		userMessageDAO.addObj(obj);
		return null;
	}

	public String del(List<Object> objList) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delObj(Object obj) {
		// TODO Auto-generated method stub
		userMessageDAO.delObj(obj);
		return null;
	}

	public String delObjById(String id) {
		// TODO Auto-generated method stub
		userMessageDAO.delObjById(id);
		return null;
	}

	public int getCountByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return userMessageDAO.getCountByWhere(where);
	}

	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		// TODO Auto-generated method stub
		return userMessageDAO.getListByPageWhere(where, page);
	}

	public List<?> getListByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return userMessageDAO.getListByWhere(where);
	}

	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjById(String id) {
		// TODO Auto-generated method stub
		return userMessageDAO.getObjById(id);
	}

	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateObj(Object obj) {
		// TODO Auto-generated method stub
		userMessageDAO.updateObj(obj);
		return null;
	}

	public List getUserMessageList(int i, String where) {
		// TODO Auto-generated method stub
		return userMessageDAO.getUserMessageList(i,where);
	}

	
	public Object getAccaptById(String id) {
		// TODO Auto-generated method stub
		return userMessageDAO.getAccaptById(id);
	}

	
	public HashMap<String, ?> getListAccaptByPageWhere(StringBuffer where,
			PageInfo page) {
		// TODO Auto-generated method stub
		return userMessageDAO.getListAccaptByPageWhere(where, page);
	}

	
	public List getListAccaptByPageWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return userMessageDAO.getListAccaptByPageWhere(where);
	}
	
	public void addMessage(AccaptMessageInfo info, String ognzName) {
		// TODO Auto-generated method stub
		userMessageDAO.addMessage(info,ognzName);
	}
	public void delObjStatus(Object obj) {
		AccaptMessageInfo user = (AccaptMessageInfo)obj;
		user.setStatus("0");
		userMessageDAO.updateObj(user);//假删除
	}
	
	
	public void delObjStatusById(String id) {
		UserMessageInfo user = (UserMessageInfo) userMessageDAO.getObjById(id);
		for(int i=0;i<user.getAccaptList().size();i++){
			user.getAccaptList().get(i).setStatus("1");
		}
		userMessageDAO.updateObj(user);//假删除
	}
	
	
	public void delStatus(List<Object> objList) {
		try{
			for(Object obj:objList){
				delObjStatus(obj);//假删除
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
