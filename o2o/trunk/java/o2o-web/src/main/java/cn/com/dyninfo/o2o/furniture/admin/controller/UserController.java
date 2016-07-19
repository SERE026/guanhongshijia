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
 * May 24, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.OgnzInfo;
import cn.com.dyninfo.o2o.old.model.RoleInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.OgnzService;
import cn.com.dyninfo.o2o.old.service.RoleService;
import cn.com.dyninfo.o2o.old.service.UserService;

/**
 * 用户管理
 * @author jettang May 24, 2010
 */
@Controller
@RequestMapping("/manage/user")
public class UserController {
	@Resource
	private UserService userService;

	@Resource
	private OgnzService ognzService;

	@Resource
	private RoleService roleService;
	 
	/**
	 * 框架页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/frame")
	public ModelAndView frame(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/user/frame");
		return mav;
	}
	
	/**
	 * 树形页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/tree")
	public ModelAndView tree(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String parent_id = request.getParameter("parent_id");
		//
		StringBuffer where = new StringBuffer();
		if(parent_id == null || parent_id.equals("0")){
			where.append(" and ognzInfo.parent.id is null ");
		}else{
			where.append(" and ognzInfo.id ='").append(parent_id).append("' ");
		}
		List<OgnzInfo> list = (List<OgnzInfo>)ognzService.getListByWhere(where);
		if(list != null && list.size() > 0){
			mav.addObject("ognzId",list.get(0).getId());
			mav.addObject("ognzName",list.get(0).getOgnz_name());
		}
		mav.setViewName("/base/user/tree");
		return mav;
	}
	
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
		//
		String ognzId = request.getParameter("ognzId");
		if(ognzId!=null&&ognzId.length()==0){
			ognzId=null;
		}
		
		//
		StringBuffer where = new StringBuffer();
		String username = request.getParameter("username");
		String login = request.getParameter("login");
		if(username != null){
			where.append(" and userInfo.USER_NAME like '%").append(username).append("%'");
			mav.addObject("username", username);
		}
		if(login != null){
			where.append(" and userInfo.LOGIN_ID like '%").append(login).append("%'");
			mav.addObject("login", login);
		}
		where.append(" and userInfo.IS_USER = '0' ");
		HashMap<String, ?> mapp = userService.getPageListByOgnzId(ognzId, where, page);
		List<UserInfo> users = (List<UserInfo>)mapp.get("DATA");
		page = (PageInfo) mapp.get("PAGE_INFO");
		mav.addObject("LIST", users);
		mav.addObject("ognzId", ognzId);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/user/list");
		return mav;
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,
			HttpServletResponse response, UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		//
		String ognzId = request.getParameter("ognzId");
		mav.addObject("ognzId", ognzId);
		//
		mav.setViewName("/base/user/add");
		OgnzInfo ognzInfo = (OgnzInfo)ognzService.getObjById(ognzId);
		mav.addObject("ognzInfo", ognzInfo);
		return mav;
	}

	/**
	 * 显示
	 */
	@RequestMapping(value = "/{id}/show")
	public ModelAndView show(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		//
		String ognzId = request.getParameter("ognzId");
		mav.addObject("ognzId", ognzId);
		UserInfo userInfo = (UserInfo)userService.getObjById(id);
		mav.addObject("userInfo", userInfo);
		mav.setViewName("/base/user/show");
		return mav;
	}

	/**
	 * 查询
	 */
	@RequestMapping(value = "/{id}/c")
	public void chaxun(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("utf-8");
		UserInfo userInfo = (UserInfo)userService.getObjById(id);
		try {
			if (userInfo == null) {
				response.getWriter().print("1");//该账号可以使用
			} else {
				response.getWriter().print("0");//该账号已经存在
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable
	String id, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		UserInfo userInfo = (UserInfo)userService.getObjById(id);
		mav.setViewName("/base/user/disUpdate");
		mav.addObject("userInfo", userInfo);
		//
		String ognzId = request.getParameter("ognzId");
		mav.addObject("ognzId", ognzId);
		return mav;
	}

	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, UserInfo userInfo) {
		try{
			List<OgnzInfo> ognzs = new ArrayList<OgnzInfo>();
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			OgnzInfo ognzInfo = (OgnzInfo)ognzService.getObjById(request
					.getParameter("ognz"));
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById(request
					.getParameter("role"));
			ognzs.add(ognzInfo);
			roles.add(roleInfo);
			userInfo.setOgnzs(ognzs);
			userInfo.setRoles(roles);
			userInfo = (UserInfo)userService.addObj(userInfo);
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+request.getParameter("ognz"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+request.getParameter("ognz"),"C_STATUS",0);
		}
		
	}

	/**
	 * 更新保存
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(UserInfo userInfo, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			List<OgnzInfo> ognzs = new ArrayList<OgnzInfo>();
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			OgnzInfo ognzInfo = (OgnzInfo)ognzService.getObjById(request.getParameter("ognz"));
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById(request.getParameter("role"));
			ognzs.add(ognzInfo);
			roles.add(roleInfo);
			/*
			 * 当修改的是当前登录用户的话，会出现（hibernate a different object with the same identifier value was already associated with the session）异常
			 * 所以先查询再赋值最后修改
			 */
			UserInfo user = (UserInfo)userService.getObjById(id);
			user.setOgnzs(ognzs);
			user.setRoles(roles);
			user.setEmail(userInfo.getEmail());
			user.setImg(userInfo.getImg());
			user.setIndex_order(userInfo.getIndex_order());
			user.setIsDefault(userInfo.getIsDefault());
			user.setIsUsed(userInfo.getIsUsed());
			user.setLogin_id(userInfo.getLogin_id());
			user.setMobile(userInfo.getMobile());
			user.setOffTel(userInfo.getOffTel());
			user.setPs(userInfo.getPs());
			user.setUser_name(userInfo.getUser_name());
			if(userInfo.getPasswd()!=null&&userInfo.getPasswd().length()>0)
			user.setPasswd(MD5Encoder.encodePassword(userInfo.getPasswd(),
					user.getLogin_id()));
			
			userService.updateObj(user);
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+request.getParameter("ognz"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+request.getParameter("ognz"),"C_STATUS",0);
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
					userService.delObjStatusById(userid);
				}
			}
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId,"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId,"C_STATUS",0);
		}
	}
	
	/**
	 * 禁用
	 */
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public ModelAndView del(@PathVariable
	String id, String ognzId, HttpServletRequest request, HttpServletResponse response) {
		try{
			userService.delObjStatusById(id);
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId,"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId,"C_STATUS",0);
		}
	}
	
	/**
	 * 弹出选择框
	 * @param request
	 * @return
	 */
	@RequestMapping("/selection")
	public ModelAndView selection(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String fieldId = request.getParameter("fieldId");//ID存放组件ID(必须)
		String fieldName = request.getParameter("fieldName");//名称存放组件ID(必须)
		mav.addObject("fieldId", fieldId);
		mav.addObject("fieldName", fieldName);
		//
		String selectedIds = request.getParameter("selectedIds");//已选择的部分ids（可选）
		if(selectedIds != null && !selectedIds.equals("")){
			String selectedNames = userService.getUserNamesByIds(selectedIds);
			String[] ids = selectedIds.split(",");
			String[] names = selectedNames.split(",");
			List selectedList = new ArrayList();
			for(int i=0;i<ids.length;i++){
				Map map = new HashMap();
				map.put("id", ids[i]);
				map.put("name", names[i]);
				selectedList.add(map);
			}
			mav.addObject("selectedList", selectedList);
			mav.addObject("selectedIds", selectedIds);
			mav.addObject("selectedNames", selectedNames);
		}
		//
		String single = request.getParameter("single");//是否单选(默认为否)
		if(single == null || single.equals(""))
			single = "false";
		mav.addObject("single", single);
		//
		String maxSelect = request.getParameter("maxSelect");//最多选择数量（可选）
		if(maxSelect != null && !maxSelect.equals(""))
			mav.addObject("maxSelect", maxSelect);
		//
		mav.setViewName("/base/user/dialogSelection");
		return mav;
	}
	
	/**
	 * 返回格式
	 * @param request
	 * @return
	 */
	@RequestMapping("/getOgnzUserList")
	public ModelAndView getOgnzUserList(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			pw = response.getWriter();
			String parent_id = request.getParameter("parent_id");
			StringBuffer where = new StringBuffer();
			if(parent_id == null || parent_id.equals("0")){
				where.append(" and ognzInfo.parent.id is null ");
			}else{
				parent_id = parent_id.substring(1);
				where.append(" and ognzInfo.parent.id ='").append(parent_id).append("' ");
			}
			where.append(" and ognzInfo.isUsed = '1' ");
			List<OgnzInfo> list = (List<OgnzInfo>)ognzService.getListByWhere(where);
			//
			StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
			str.append("<root>");
			for(OgnzInfo ognz:list){
				//组织
				str.append("<item id='O").append(ognz.getId()).append("' ");
				str.append("parent_id='");
				str.append(ognz.getParent() == null ? "0" : "O" + ognz.getParent().getId()).append("' ");
				str.append("state='closed'>");
				str.append("<content><name>");
				str.append(ognz.getOgnz_name());
				str.append("</name></content>");
				str.append("</item>");
			}
			//
			List<UserInfo> uList = userService.getListByOgnzId(parent_id,
					new StringBuffer(" and userInfo.ISUSED = '1' "));
			for(UserInfo user : uList){
				str.append("<item id='U").append(user.getLogin_id()).append("' ");
				str.append("parent_id='O");
				str.append(parent_id).append("' ");
				str.append(" visible='false' rel='leaf' >");
				str.append("<content><name>");
				str.append(user.getUser_name());
				str.append("</name><rel>leaf</rel></content>");
				str.append("</item>");
			}
			str.append("</root>");
			pw.write(str.toString());
			pw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw != null){
				try{
					pw.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 弹出选择框
	 * @param request
	 * @return
	 */
	@RequestMapping("/json/selection")
	public void jsonselection(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String ognzId=request.getParameter("ognzId");
		String w="";
		if(ognzId!=null&&ognzId.length()>0){
			OgnzInfo ognz=(OgnzInfo) ognzService.getObjById(ognzId);
			w+=" and userInfo.ognzs.id in('"+ognz.getId()+"')";
		}
		List list=userService.getListByWhere(new StringBuffer(" and userInfo.is_user = '0'  and userInfo.isUsed='1' and userInfo.user_name like '%"+name+"%' and userInfo.login_id!='admin' "+w));
		ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
	}
	
	/**
	 * 启用
	 */
	@RequestMapping(value = "/start/{id}", method = RequestMethod.GET)
	public ModelAndView start(@PathVariable String id, String ognzId, HttpServletRequest request, HttpServletResponse response) {
		try{
			 UserInfo info=(UserInfo) userService.getObjById(id);
			 info.setIsUsed("1");
			 userService.updateObj(info);
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/user/list?ognzId="+ognzId);
		}
	}
	
	/**
	 * 查询
	 */
	@RequestMapping(value = "/{id}/address")
	public void address(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("utf-8");
		StringBuffer where=new StringBuffer();
		where.append(" and n.areaid like '%").append(id).append("%'");
       List<UserInfo> list=(List<UserInfo>) userService.getListByWhere(where);
		try {
			if (list.size()==0) {
				response.getWriter().print("1");//该地区没有代理商
			} else {
				response.getWriter().print("0");//该地区已有代理商
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
