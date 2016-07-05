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

import java.util.List;

import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;

public interface ResService extends IBaseService {
	
	public List<ResInfo> getListByRoles(String roleNames, String where);
	
	//根据ID串得到名称字符串 使用,分隔
	public String getResNamesByIds(String ids);
}
