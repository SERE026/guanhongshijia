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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.model.ControlGroupInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.ControlGroupService;
import cn.com.dyninfo.o2o.furniture.admin.service.RoleService;

@Controller
@RequestMapping("/manage/role")
public class RoleController {

	@Resource
	private RoleService roleService;

	@Resource
	private ControlGroupService controlGroupService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List<RoleInfo> roles = new ArrayList<RoleInfo>();
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(15);
		int pageNo = 1;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		pageInfo.setPageNo(pageNo);
		HashMap map = roleService.getListByPageWhere(null, pageInfo);
		if (map != null) {
			roles = (List<RoleInfo>) map.get("DATA");
		}
		pageInfo = (PageInfo) map.get("PAGE_INFO");
		mav.addObject("LIST", roles);
		mav.addObject("PAGE_INFO", pageInfo);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/role/list");
		return mav;
	}
	
	

	/**
	 * 进入添加页面
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,
			HttpServletResponse response, RoleInfo roleInfo) {
		ModelAndView mav = new ModelAndView();
		List<ControlGroupInfo> list = (List<ControlGroupInfo>)controlGroupService.getListByWhere(null);
		mav.addObject("ControlGroupInfoList", list);
		mav.setViewName("/base/role/add");
		return mav;
	}

	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,RoleInfo roleInfo) {
		try{
			ControlGroupInfo cgi = (ControlGroupInfo)controlGroupService.getObjById(request.getParameter("controlsid"));
			Set<ControlGroupInfo> set = new HashSet<ControlGroupInfo>();
			set.add(cgi);
			roleInfo.setGroups(set);
			roleService.addObj(roleInfo);
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",0);
		}
	}
	
	/**
	 * 进入编辑页面
	 */
	@RequestMapping(value = "/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		RoleInfo roleInfo = (RoleInfo) roleService.getObjById(id);
		view.addObject("info", roleInfo);
		List<ControlGroupInfo> list = (List<ControlGroupInfo>)controlGroupService.getListByWhere(null);
		view.addObject("ControlGroupInfoList", list);
		view.setViewName("/base/role/disUpdate");
		return view;
	}

	/**
	 * 编辑保存操作
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView update(RoleInfo roleInfo,HttpServletRequest request) {
		try{
			String id = request.getParameter("id");
			ControlGroupInfo cgi = (ControlGroupInfo)controlGroupService.getObjById(request.getParameter("controlsid"));
			Set<ControlGroupInfo> set = new HashSet<ControlGroupInfo>();
			set.add(cgi);
			RoleInfo role = (RoleInfo)roleService.getObjById(id);
			role.setGroups(set);
			role.setIndex_order(roleInfo.getIndex_order());
			role.setIs_job(roleInfo.getIs_job());
			role.setIsSys(roleInfo.getIsSys());
			role.setRole_c_name(roleInfo.getRole_c_name());
			role.setRole_e_name(roleInfo.getRole_e_name());
			roleService.updateObj(role);
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",0);
		}
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/del/{id}")
	public ModelAndView del(@PathVariable String id, HttpServletRequest request) {
		try{
			roleService.delObjById(id);
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",0);
		}
		
	}
	
	/**
	 * 删除全部
	 */
	@RequestMapping(value = "/delall")
	public ModelAndView delAll(HttpServletRequest request) {
		try{
			if(request.getParameterValues("list")!=null){
				String []list=request.getParameterValues("list");
				for(String resId:list){
					RoleInfo roleInfo = (RoleInfo)roleService.getObjById(resId);
					roleService.delObj(roleInfo);
				}
			}
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/role/list","C_STATUS",0);
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
			String selectedNames = roleService.getRoleNamesByIds(selectedIds);
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
		mav.setViewName("/base/role/dialogSelection");
		return mav;
	}
	
	/**
	 * 返回格式
	 * @param request
	 * @return
	 */
	@RequestMapping("/getRoleList")
	public ModelAndView getRoleList(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			pw = response.getWriter();
			StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
			str.append("<root>");
			String parent_id = request.getParameter("parent_id");
			if(parent_id == null || parent_id.equals("0")){
				List<RoleInfo> list = (List<RoleInfo>)roleService.getListByWhere(null);
				//
				for(RoleInfo role : list){
					str.append("<item id='").append(role.getId()).append("' ");
					str.append("parent_id='0' ");
					str.append("state='open'>");
					str.append("<content><name>");
					str.append(role.getRole_c_name());
					str.append("</name></content>");
					str.append("</item>");
				}
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
}
