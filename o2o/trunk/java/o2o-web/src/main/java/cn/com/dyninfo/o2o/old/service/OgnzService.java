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

package cn.com.dyninfo.o2o.old.service;

import java.util.List;

import cn.com.dyninfo.o2o.old.model.OgnzInfo;

public interface OgnzService extends IBaseService {
	
	//得到组织结构树XML
	public String getOgnzXMLTree(OgnzInfo ognzInfo);
	
	public String objToXML(OgnzInfo ognzInfo);
	
	
	//根据ID串得到部门名称字符串 使用,分隔
	public String getOgnzNamesByIds(String ids);
	
	//返回 ognz——id 递归迭代
	public String getognzids(OgnzInfo in);
	
	//
	public String getcompanyid(List<OgnzInfo> list);
	
}
