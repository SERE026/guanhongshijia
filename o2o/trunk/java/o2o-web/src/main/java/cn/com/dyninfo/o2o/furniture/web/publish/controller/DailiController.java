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

package cn.com.dyninfo.o2o.furniture.web.publish.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.RoleInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.RoleService;
import cn.com.dyninfo.o2o.old.service.UserService;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;

@Controller
@RequestMapping("/manage/daili")
public class DailiController {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private AreaService areaService;
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 0;
		if ((request.getParameter("pageNo") != null)) {
			no = Integer.parseInt(request.getParameter("pageNo"));

		}
		if (no > 0) {
			page.setPageNo(no);
		} else
			page.setPageNo(1);
		
		StringBuffer where = new StringBuffer();
		String name = request.getParameter("name");
		String login_id = request.getParameter("login_id");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		if(name!=null&&name.length()>0){
			where.append(" and userInfo.user_name like '%"+name+"%'");
			mav.addObject("name", name);
		}
		if(login_id!=null&&login_id.length()>0){
			where.append(" and userInfo.login_id like '%"+login_id+"%'");
			mav.addObject("login_id", login_id);
		}
		if(contactName!=null&&contactName.length()>0){
			where.append(" and userInfo.ps.contactName like '%"+contactName+"%'");
			mav.addObject("contactName", contactName);
		}
		if(contactPhone!=null&&contactPhone.length()>0){
			where.append(" and userInfo.mobile like '%"+contactPhone+"%'");
			mav.addObject("contactPhone", contactPhone);
		}
		
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("UserInfo");
		where.append(" and userInfo.is_user = '2' and userInfo.isUsed='1' ");
		HashMap<String, ?> mapp = userService.getListByPageWhere(where, page);
		List<UserInfo> users = (List<UserInfo>)mapp.get("DATA");
		page = (PageInfo) mapp.get("PAGE_INFO");
		mav.addObject("DATA", users);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/shangjia/daili/list");
		return mav;
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/shangjia/daili/add");
		return mav;
	}
	
	/**
	 * 显示
	 */
	@RequestMapping(value = "/{id}/show")
	public ModelAndView show(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		UserInfo userInfo = (UserInfo)userService.getObjById(id);
		mav.addObject("info", userInfo);
		mav.setViewName("/shangjia/daili/show");
		return mav;
	}
	
	
	/**
	 * 编辑
	 */
	@RequestMapping(value = "/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		UserInfo userInfo = (UserInfo)userService.getObjById(id);
		mav.setViewName("/shangjia/daili/update");
		mav.addObject("info", userInfo);
		return mav;
	}
	
	
	
	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			
			String user_name=request.getParameter("user_name");
			String contactName=request.getParameter("contactName");
			String mobile=request.getParameter("mobile");
			String login_id = request.getParameter("login_id");
			String passwd = request.getParameter("passwd");
			String areaid=request.getParameter("areaid");
	    	String areaname=request.getParameter("areaname");
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById("3");
			roles.add(roleInfo);
			
			UserInfo userInfo = new UserInfo();
			userInfo.setUser_name(user_name);
			userInfo.setMobile(mobile);
			userInfo.setPs(contactName);
			userInfo.setAreaid(areaid);
			userInfo.setAreaname(areaname);
			userInfo.setRoles(roles);
			userInfo.setIsUsed("1");
			userInfo.setIs_user("2");
			userInfo.setLogin_id(login_id);
			userInfo.setPasswd(passwd);
			userInfo = (UserInfo)userService.addObj(userInfo);
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",0);
		}
		
	}
	/**
	 * 更新保存
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String user_name=request.getParameter("user_name");
			String contactName=request.getParameter("contactName");
			String mobile=request.getParameter("mobile");
		    String areaid=request.getParameter("areaid");
	    	String areaname=request.getParameter("areaname");
			
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById("3");
			roles.add(roleInfo);
			/*
			 * 当修改的是当前登录用户的话，会出现（hibernate a different object with the same identifier value was already associated with the session）异常
			 * 所以先查询再赋值最后修改
			 */
			UserInfo user = (UserInfo)userService.getObjById(id);
			user.setUser_name(user_name);
			user.setMobile(mobile);
			user.setPs(contactName);
			user.setAreaid(areaid);
			user.setAreaname(areaname);
			user.setRoles(roles);
			if(passwd!=null&&passwd.length()>0)
			user.setPasswd(MD5Encoder.encodePassword(passwd,
					user.getLogin_id()));
			
			userService.updateObj(user);
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",0);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delall", method = RequestMethod.DELETE)
	public ModelAndView del(String ognzId, HttpServletRequest request, HttpServletResponse response) {
		try{
			if (request.getParameterValues("list") != null) {
				String[] list = request.getParameterValues("list");
				for (String userid : list) {
					UserInfo user = (UserInfo) userService.getObjById(userid);
					userService.delObjStatusById(userid);
				}
			}
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",0);
		}
	}
	
	/**
	 * 禁用
	 */
	@RequestMapping(value = "/{id}/del")
	public ModelAndView del(@PathVariable
	String id, String ognzId, HttpServletRequest request, HttpServletResponse response) {
		try{
			UserInfo user = (UserInfo) userService.getObjById(id);
			userService.delObjStatusById(id);
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/daili/list","C_STATUS",0);
		}
	}
	
	@RequestMapping(value="/areaselect")
	public ModelAndView areaselect(HttpServletRequest request, HttpServletResponse response){
		String regionid=request.getParameter("regionid");
    StringBuffer where=new StringBuffer();
    JSONObject job=new JSONObject();
    if(regionid.equals("0")){
    	where.append(" and n.parent is null");
    }else{
    	where.append("  and n.parent.id='").append(regionid).append("'");
    }
    		 List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(where);

    int i=0;
    for(AreaInfo v:ars){
     try {
      JSONObject job1=new JSONObject();
      job1.put("id", v.getId());
      job1.put("name", v.getName());
      job.put("city"+i, job1);
      job1.put("childnum", v.getChildren().size());
      i++;
     } catch (Exception e) {
      e.printStackTrace();
     }
    }
    try {
     response.setCharacterEncoding("UTF-8");
     response.setContentType("json/text");
     Writer writer;
     writer=response.getWriter();
     writer.write(job.toString());
     writer.flush();
     writer.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
    return null;
  }

	@RequestMapping(value="/{id}/areaselect")
	public ModelAndView areaselect1(@PathVariable String id,HttpServletRequest request, HttpServletResponse response){
	String regionid=request.getParameter("regionid");
    StringBuffer where=new StringBuffer();
    JSONObject job=new JSONObject();
    if(regionid.equals("0")){
    	where.append(" and n.parent is null");
    }else{
    	where.append("  and n.parent.id='").append(regionid).append("'");
    }
    		 List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(where);

    int i=0;
    for(AreaInfo v:ars){
     try {
      JSONObject job1=new JSONObject();
      job1.put("id", v.getId());
      job1.put("name", v.getName());
      job.put("city"+i, job1);
      job1.put("childnum", v.getChildren().size());
      i++;
     } catch (Exception e) {
      e.printStackTrace();
     }
    }
    try {
     response.setCharacterEncoding("UTF-8");
     response.setContentType("json/text");
     Writer writer;
     writer=response.getWriter();
     writer.write(job.toString());
     writer.flush();
     writer.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
    return null;
  }
}
