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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


import cn.com.dyninfo.o2o.furniture.util.PageInfo;

public class BaseService implements IBaseService{

	public Object baseDao;
	
	public void initDao(){
		
	}
	

	public Object addObj(Object obj) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={Object.class};
		try{
			Method m=baseDao.getClass().getMethod("addObj", cla);
			m.invoke(baseDao, obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String del(List<Object> objList) {
		// TODO Auto-generated method stub
		initDao();
		return null;
	}



	public int getCountByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={StringBuffer.class};
		try{
			Method m=baseDao.getClass().getMethod("getCountByWhere", cla);
			return (Integer)m.invoke(baseDao, where);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={StringBuffer.class,PageInfo.class};
		try{
			Method m=baseDao.getClass().getMethod("getListByPageWhere", cla);
			return (HashMap)m.invoke(baseDao, where,page);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public List<?> getListByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={StringBuffer.class};
		try{
			Method m=baseDao.getClass().getMethod("getListByWhere", cla);
			return (List)m.invoke(baseDao, where);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjById(String id) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={String.class};
		try{
			Method m=baseDao.getClass().getMethod("getObjById", cla);
			return m.invoke(baseDao, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
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


	public String delObj(Object obj) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={Object.class};
		try{
			Method m=baseDao.getClass().getMethod("delObj", cla);
			m.invoke(baseDao, obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	public String delObjById(String id) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={String.class};
		try{
			Method m=baseDao.getClass().getMethod("delObjById", cla);
			m.invoke(baseDao, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public String updateObj(Object obj) {
		// TODO Auto-generated method stub
		initDao();
		Class cla[]={Object.class};
		try{
			Method m=baseDao.getClass().getMethod("updateObj", cla);
			m.invoke(baseDao, obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
}
