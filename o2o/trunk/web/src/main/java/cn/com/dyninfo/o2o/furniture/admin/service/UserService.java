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

package cn.com.dyninfo.o2o.furniture.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;

public interface UserService extends IBaseService {

	/**
	 * 用户登陆判断
	 * @param loginId 登陆账户
	 * @param password 未加密的密码
	 * @return
	 */
	public UserInfo login(String loginId,String password);
	/**
	 * 获取当前用户的主菜单
	 * @param userInfo
	 * @return
	 */
	public List<ResInfo> getMenusByUser(UserInfo userInfo);
	
	/**
	 * 分页查询
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getPageListByOgnzId(String ognzId, StringBuffer where, PageInfo page);
	
	public List<UserInfo> getListByOgnzId(String ognzId, StringBuffer where);
	
	/**
	 * 搜索人员
	 * @param where
	 * @return
	 */
	public Map search(PageInfo page,String where);
	
	//根据ID串得到人员名称字符串 使用,分隔
	public String getUserNamesByIds(String ids);
	
	//根据ID串得到人员对象集合
	public Set<UserInfo> getObjsByIds(String ids);
	
	/**
	 * 修改密码
	 * @param loginId 登录ID
	 * @param newpassword 已加密新密码
	 */
	public void changePassWord(String loginId, String newpassword);
	
	public Object getUserResByres(String userId,String resId);
	public Object getUserResByres(String resId) ;
	
	public List getUserByRole(String roleID);
	
}
