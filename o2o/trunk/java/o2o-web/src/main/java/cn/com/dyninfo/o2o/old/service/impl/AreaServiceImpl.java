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

package cn.com.dyninfo.o2o.old.service.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.old.dao.AreaDao;
import org.springframework.stereotype.Service;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;


@Service("areaService")
public class AreaServiceImpl  implements AreaService {
	
	@Resource
	private AreaDao areaDao;
	
	public Object addObj(Object obj) {
		 areaDao.addObj(obj);
		return null;
	}

	public String del(List<Object> objList) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delObj(Object obj) {
		 areaDao.delObj(obj);
		return null;
	}

	public String delObjById(String id) {
		 areaDao.delObjById(id);
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

	public int getCountByWhere(StringBuffer where) {
		// TODO Auto-generated method stub
		return 0;
	}


	public HashMap<String, ?> getListByPageWhere(StringBuffer where,
			PageInfo page) {
		return  areaDao.getListByPageWhere(where, page);
	}

	public List<?> getListByWhere(StringBuffer where) {
		return areaDao.getListByWhere(where);
	}

	public Object getNextObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjById(String id) {
		return areaDao.getObjById(id);
	}

	public Object getPreviousObj(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateObj(Object obj) {
		 areaDao.updateObj(obj);
		return null;
	}

	public String getAreaNamesByIds(String selectedIds) {
		return ((AreaInfo)areaDao.getObjById(selectedIds)).getName();
	}

	@Override
	public Object getDefaultArea(HttpServletRequest request,
			HttpServletResponse reponse) {
		if(request.getSession().getAttribute(Context.SESSION_AEAR)==null)
			return null;
		else{
			return request.getSession().getAttribute(Context.SESSION_AEAR);
		}
		/*
		 * 
		 * 
		 * 
		 * 删除代码 不能判定是否还需要
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Cookie[] cookIe=request.getCookies();
		String arearId="";
		AreaInfo arear=null;
		if(cookIe!=null){
			for(Cookie ck:cookIe){
				if(ck.getName().equals(Context.COOKIE_AEAR_ID)){
					arearId=ck.getValue();
					break;
				}
			}
		}
		if(arearId==""){
			List<AreaInfo> list=(List<AreaInfo>) areaDao.getListByWhere(new StringBuffer(" and n.isDefault='1' "));
			if(list.size()>0){
				arear=list.get(0);
				Cookie ck=new Cookie(Context.COOKIE_AEAR_ID,arear.getId());
				ck.setMaxAge(365*24*60*60*1000);
				ck.setPath("/");
				reponse.addCookie(ck);
				request.getSession().setAttribute(Context.SESSION_AEAR, arear);
			}
		}else{
			arear=(AreaInfo) areaDao.getObjById(arearId);
			if(arear==null){
				List<AreaInfo> list=(List<AreaInfo>) areaDao.getListByWhere(new StringBuffer(" and n.isDefault='1' "));
				if(list.size()>0){
					arear=list.get(0);
					Cookie ck=new Cookie(Context.COOKIE_AEAR_ID,arear.getId());
					ck.setMaxAge(365*24*60*60*1000);
					ck.setPath("/");
					reponse.addCookie(ck);
					request.getSession().setAttribute(Context.SESSION_AEAR, arear);
				}
			}else{
				request.getSession().setAttribute(Context.SESSION_AEAR, arear);
			}
		}
		return arear;
		*/
		
	}

}
