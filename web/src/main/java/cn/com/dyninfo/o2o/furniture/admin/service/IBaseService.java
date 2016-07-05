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
 * @author jettang
 * Jul 15, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.service;

import java.util.HashMap;
import java.util.List;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

/**
 * @author jettang
 * Jul 15, 2010
 */
public interface IBaseService {
	
	/**
	 * 条件查询
	 * @param where
	 * @return
	 */
	public List<?> getListByWhere(StringBuffer where);
	/**
	 * 分页查询
	 * @param where
	 * @param page
	 * @return
	 */
	public HashMap<String,?> getListByPageWhere(StringBuffer where,PageInfo page);
	
	/**
	 * 根据当前对象查询排序中的下一个对象
	 * @param obj
	 * @return
	 */
	public Object getNextObj(Object obj);
	
	/**
	 * 根据当前对象查询排序中的前一个对象
	 * @param obj
	 * @return
	 */
	public Object getPreviousObj(Object obj);
	/**
	 * 总数
	 * @param where
	 * @return
	 */
	public int getCountByWhere(StringBuffer where);
	/**
	 * 得到单个具体对象
	 * @param id
	 * @return
	 */
	public Object getObjById(String id);
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public Object addObj(Object obj);
	/**
	 * 修改
	 * @param obj
	 */
	public String updateObj(Object obj);
	/**
	 * 删除
	 * @param obj
	 */
	public String delObj(Object obj);
	/**
	 * 删除
	 * @param id
	 */
	public String delObjById(String id);
	
	/**
	 * 批量删除
	 * @param objList
	 */
	public String del(List<Object> objList);
	
	/**
	 * 假删除
	 * @param obj
	 */
	public void delObjStatus(Object obj);
	//假删除
	public void delObjStatusById(String id);
	//假删除
	public void delStatus(List<Object> objList);
}
