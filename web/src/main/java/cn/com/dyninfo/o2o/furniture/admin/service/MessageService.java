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

import cn.com.dyninfo.o2o.furniture.admin.model.AccaptMessageInfo;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;


public interface MessageService extends IBaseService {

	public List getUserMessageList(int i,String where);
	
	public Object getAccaptById(String id);
	public HashMap<String, ?> getListAccaptByPageWhere(StringBuffer where,
			PageInfo page);
	
	public List getListAccaptByPageWhere(StringBuffer where);//获取未读消息
	public void addMessage(AccaptMessageInfo info,String ognzName);
}
