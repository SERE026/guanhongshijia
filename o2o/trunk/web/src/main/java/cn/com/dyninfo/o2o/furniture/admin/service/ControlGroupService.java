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

import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.furniture.admin.model.GroupResRelation;

/**
 * 权限组接口
 * @author jettang
 * Mar 23, 2011
 */
public interface ControlGroupService extends IBaseService {
	
	//根据资源模块名得到当前用户的数据访问权限
	public GroupResRelation getGroupResRelationByResModuleName(String userId, String moduleName);
	
	public String getsql(HttpServletRequest request, String moduleName);
	
	public String getsql(String userId, String moduleName);
	
	//根据资源模块名得到当前用户的数据访问权限
	public GroupResRelation getGroupResRelationByResModuleId(String userId, String moduleId);
}
