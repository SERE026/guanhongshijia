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

package cn.com.dyninfo.o2o.furniture.admin.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.old.service.LogService;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.RequestWhere;

public class BaseController {

	@Resource
	public LogService logService;

	public boolean del=true;
	public String table="";
	public String business="";
	public Object baseService;
	public String currentTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	public void initService(){
		
	}
	
	/**
	 * 列表
	 * @param request
	 * @return
	 */
	public ModelAndView list(HttpServletRequest request,StringBuffer where){
		initService();
		ModelAndView mav=new ModelAndView();
		PageInfo page = new PageInfo();
		where.append(RequestWhere.getWhere(request));
		if(request.getAttribute("pageSize")!=null){
			page.setPageSize((Integer)request.getAttribute("pageSize"));
		}else{
			page.setPageSize(25);
		}
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0){
			Pattern pattern =Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if(m.matches()){
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		}else
			page.setPageNo(1);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		Class cl[]={StringBuffer.class,PageInfo.class};
		try{
			Method m=baseService.getClass().getMethod("getListByPageWhere",cl);
			mav.addAllObjects((HashMap)m.invoke(baseService, where,page));
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("/"+business+"/"+table+"/list");
		return mav;
	}
	/**
	 * 添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/"+business+"/"+table+"/add");
		return mav;
	}
	/**
	 * 保存
	 * @param request
	 * @return
	 */
	
	public ModelAndView add(HttpServletRequest request,Object obj){
		ModelAndView mav=new ModelAndView();
		initService();
		try{
			Class cla[]={Object.class};
			Method m=baseService.getClass().getMethod("addObj", cla);
			m.invoke(baseService, obj);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
	}
	/**
	 * 修改
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		initService();
		try{
			Class cla[]={String.class};
			Method m=baseService.getClass().getMethod("getObjById", cla);
			mav.addObject("info",m.invoke(baseService, id));
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("/"+business+"/"+table+"/update");
		return mav;
	}
	/**
	 * 查看
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/show")
	public ModelAndView show(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		initService();
		try{
			Class cla[]={String.class};
			Method m=baseService.getClass().getMethod("getObjById", cla);
			mav.addObject("info",m.invoke(baseService, id));
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("/"+business+"/"+table+"/show");
		return mav;
	}
	
	/**
	 * 更新
	 * @param id
	 * @param request
	 * @return
	 */
	public ModelAndView endit(HttpServletRequest request,Object obj){
		ModelAndView mav=new ModelAndView();
		initService();
		try{
			Class cla[]={Object.class};
			Method m=baseService.getClass().getMethod("updateObj", cla);
			m.invoke(baseService, obj);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
		
			mav.addObject("C_STATUS", 0);
		}
		
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
	}
	/**
	 * 删除 表单 name=“list” 的对象
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/all/del",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		initService();
		ModelAndView mav=new ModelAndView();
		try{
			Class cla[]={String.class};
			Method m=baseService.getClass().getMethod("delObjById", cla);
			if(!del){
				m=baseService.getClass().getMethod("delObjStatusById", cla);
			}
			String ids[]=request.getParameterValues("list");
			
			if(ids!=null){
				for(String id:ids){
					m.invoke(baseService, id);
				}
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
	}
	
	/**
	 * 删除 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/del")
	public ModelAndView del(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		initService();
		try{
			Class cla[]={String.class};
			Method m=baseService.getClass().getMethod("delObjById", cla);
			if(!del){
				m=baseService.getClass().getMethod("delObjStatusById", cla);
			}
			m.invoke(baseService, id);
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
	}
}
