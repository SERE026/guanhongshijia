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
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import cn.com.dyninfo.o2o.furniture.admin.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.dao.UserDAO;
import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;


@RemotingDestination("userService")
@Scope("prototype")
@Service("userService")
public class UserServiceImpl implements UserService,UserDetailsService {
	@Resource
	private UserDAO userDAO;
	
	
	public String delObj(Object userInfo) {
		userDAO.delObj(userInfo);
		return "0";
	}
	
	public String delObjById(String id) {
		userDAO.delObjById(id);
		return "0";
	}
	
	public List<UserInfo> getListByWhere(StringBuffer where) {
		return userDAO.getListByWhere(where);
	}
	
	public UserInfo getObjById(String id) {
		return userDAO.getObjById(id);
	}
	
	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo pageInfo) {
		return userDAO.getListByPageWhere(where, pageInfo);
	}
	
	
	public UserInfo addObj(Object obj) {
		UserInfo userInfo=(UserInfo)obj;
		userInfo.setPasswd(MD5Encoder.encodePassword(userInfo.getPasswd(),
				userInfo.getLogin_id()));
		return userDAO.addObj(userInfo);
	}

	
	public HashMap<String, ?> getPageListByOgnzId(String ognzId, StringBuffer where, PageInfo page) {
		return userDAO.getPageListByOgnzId(ognzId, where, page);
	}
	
	
	public String del(List<Object> objList) {
		String result="";
		try{
			for(Object obj:objList){
				userDAO.delObj(obj);
			}
			result="0";
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String updateObj(Object obj) {
		String result="";
		try{
			UserInfo userInfo=(UserInfo)obj;
			userDAO.updateObj(userInfo);
			result=userInfo.getLogin_id();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Spring Security 3 的用户信息验证实现方法
		UserInfo userInfo=userDAO.getUserByLoginId(loginId);
		return userInfo;
	}

	
	
	public UserInfo login(String loginId, String password) {
		// TODO 登陆判断
		password=MD5Encoder.encodePassword(password, loginId);
		return userDAO.login(loginId, password);
	}
	
	
	public List<ResInfo> getMenusByUser(UserInfo userInfo) {
		return null;
	}
	
	public int getCountByWhere(StringBuffer where) {
		return userDAO.getCountByWhere(where);
	}
	
	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Map search(PageInfo page,String where) {
		
		return userDAO.search(page,where);
	}
	
	/**
	 * 根据ID串得到人员名称字符串 使用,分隔
	 */
	
	public String getUserNamesByIds(String ids) {
		return userDAO.getUserNamesByIds(ids);
	}
	
	
	public List<UserInfo> getListByOgnzId(String ognzId, StringBuffer where) {
		return userDAO.getListByOgnzId(ognzId, where);
	}


	/**
	 * 根据ID串得到人员对象集合
	 */
	
	public Set<UserInfo> getObjsByIds(String ids) {
		return userDAO.getObjsByIds(ids);
	}
	/**
	 * 修改密码
	 * @param loginId 登录ID
	 * @param newpassword 已加密新密码
	 */
	
	public void changePassWord(String loginId, String newpassword) {
		userDAO.changePassWord(loginId, newpassword);
	}
	
	
	public void delObjStatus(Object obj) {
		UserInfo user = (UserInfo)obj;
		user.setIsUsed("0");
		userDAO.updateObj(user);//假删除
	}
	
	
	public void delObjStatusById(String id) {
		UserInfo user = userDAO.getObjById(id);
		user.setIsUsed("0");
		userDAO.updateObj(user);//假删除
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

	@Override
	public Object getUserResByres(String userId, String resId) {
		// TODO Auto-generated method stub
		return userDAO.getUserResByres(userId,resId);
	}

	@Override
	public Object getUserResByres(String resId) {
		// TODO Auto-generated method stub
		return userDAO.getUserResByres(resId);
	}

	@Override
	public List getUserByRole(String roleID) {
		// TODO Auto-generated method stub
		return userDAO.getUserByRole(roleID);
	}
	
}
