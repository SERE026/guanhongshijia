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

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.OgnzInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.OgnzService;
import cn.com.dyninfo.o2o.old.service.UserService;
/**
 * 组织机构管理
 * @author jettang
 * Jan 27, 2011
 */
@Controller
@RequestMapping("/manage/ognz")
public class OgnzContronller {

	@Resource
	private OgnzService ognzService;
	

	@Resource
	private UserService userService;
	
	/**
	 * 框架页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/frame")
	public ModelAndView frame(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/ognz/frame");
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
			where.append(" and ognzInfo.parent.id is null  ");
		}else{
			where.append(" and ognzInfo.id ='").append(parent_id).append("' ");
		}
		where.append(" and isUsed = '1' ");
		List<OgnzInfo> list = (List<OgnzInfo>)ognzService.getListByWhere(where);
		if(list != null && list.size() > 0){
			mav.addObject("ognzId",list.get(0).getId());
			mav.addObject("ognzName",list.get(0).getOgnz_name());
		}
		mav.setViewName("/base/ognz/tree");
		return mav;
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
			String selectedNames = ognzService.getOgnzNamesByIds(selectedIds);
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
		mav.setViewName("/base/ognz/dialogSelection");
		return mav;
	}
	
	/**
	 * 返回格式
	 * @param request
	 * @return
	 */
	@RequestMapping("/getOgnzList")
	public ModelAndView getOgnzList(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			pw = response.getWriter();
			String parent_id = request.getParameter("parent_id");
			StringBuffer where = new StringBuffer();
			if(parent_id == null || parent_id.equals("0")){
				UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
				user=(UserInfo) userService.getObjById(user.getLogin_id());
				OgnzInfo ognz=null;
				if(user.getOgnzs().size()>0)
					ognz=user.getOgnzs().get(0);
				if(ognz==null)
					where.append(" and ognzInfo.parent.id is null  ");
				else
					where.append(" and ognzInfo.parent.id ='"+ognz.getId()+"'  ");
			}else{
				where.append(" and ognzInfo.parent.id ='").append(parent_id).append("' ");
			}
			where.append(" and isUsed = '1' ");
			List<OgnzInfo> list = (List<OgnzInfo>)ognzService.getListByWhere(where);
			//
			StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
			str.append("<root>");
			for(OgnzInfo ognz:list){
				str.append("<item id='").append(ognz.getId()).append("' ");
				str.append("parent_id='");
				str.append(ognz.getParent() == null ? "0" : ognz.getParent().getId()).append("' ");
				str.append("state='closed'>");
				str.append("<content><name>");
				str.append(ognz.getOgnz_name());
				str.append("</name></content>");
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
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 1;
		if ((request.getParameter("pageNo") != null)) {
			no = Integer.parseInt(request.getParameter("pageNo"));
		}
		page.setPageNo(no);
		//
		String parent_id = request.getParameter("parent_id");
		StringBuffer where = new StringBuffer();
		if(parent_id == null || parent_id.equals("0") || parent_id.equals("")){
			UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
			user=(UserInfo) userService.getObjById(user.getLogin_id());
			OgnzInfo ognz=null;
			if(user.getOgnzs().size()>0)
				ognz=user.getOgnzs().get(0);
			if(ognz==null)
				where.append(" and ognzInfo.parent.id is null  ");
			else
				where.append(" and ognzInfo.parent.id ='"+ognz.getId()+"'  ");
		}else{
			where.append(" and (ognzInfo.parent.id ='").append(parent_id).append("'  or ognzInfo.id='"+parent_id+"' ) ");
		}
		where.append(" and isUsed = '1' ");
		String ognzname = request.getParameter("ognzname");
		if(ognzname != null){
			where.append(" and ognzInfo.ognz_name like '%").append(ognzname).append("%'");
			mav.addObject("ognzname", ognzname);
		}
		
		//
		HashMap<String, List<OgnzInfo>> mapp = (HashMap<String, List<OgnzInfo>>) ognzService.getListByPageWhere(where, page);
		List<OgnzInfo> list = mapp.get("DATA");
		page = (PageInfo) mapp.get("PAGE_INFO");
		mav.setViewName("/base/ognz/list");
		mav.addObject("LIST", list);
		mav.addObject("parent_id", parent_id);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		return mav;
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request) {
		String parent_id = request.getParameter("parent_id");
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/base/ognz/add");
		OgnzInfo ognz = (OgnzInfo)ognzService.getObjById(parent_id);
		mdv.addObject("ognz", ognz);
		mdv.addObject("parent_id", parent_id);
		return mdv;
	}

	/**
	 * 显示
	 */
	@RequestMapping(value = "/{id}/show")
	public ModelAndView show(@PathVariable String id, String parent_id) {
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("/base/ognz/show");
		OgnzInfo ognzInfo = (OgnzInfo)ognzService.getObjById(id);
		mdv.addObject("ognzInfo", ognzInfo);
		mdv.addObject("parent_id", parent_id);
		return mdv;
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable
	String id, String parent_id, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/ognz/disUpdate");
		OgnzInfo ognzInfo = (OgnzInfo)ognzService.getObjById(id);
		mav.addObject("info", ognzInfo);
		mav.addObject("parent_id", parent_id);
		return mav;
	}

	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, OgnzInfo ognzInfo) {
		try{
			if (ognzService.getObjById(request.getParameter("parent1")) != null) {
				ognzInfo.setParent((OgnzInfo)ognzService.getObjById(request
						.getParameter("parent1")));
			}
			ognzInfo = (OgnzInfo)ognzService.addObj(ognzInfo);
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}

	/**
	 * 更新保存
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(OgnzInfo ognzInfo, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			OgnzInfo ognz=(OgnzInfo)ognzService.getObjById(request
					.getParameter("parent1"));
			ognzInfo.setParent(ognz);
			ognzInfo.setId(id);
			ognzService.updateObj(ognzInfo);
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(value = "/delall", method = RequestMethod.DELETE)
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response) {
		try{
			if (request.getParameterValues("list") != null) {
				String[] list = request.getParameterValues("list");
				for (String ognzid : list) {
					OgnzInfo ognz = (OgnzInfo) ognzService.getObjById(ognzid);
					for(UserInfo user:ognz.getUsers()){
						user.setIsUsed("0");
						userService.updateObj(user);
					}
					ognzService.delObjById(ognzid);
				}
			}
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}
	/**
	 * 删除
	 */
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public ModelAndView delobj(@PathVariable String id, HttpServletRequest request) {
		try{
			OgnzInfo ognz = (OgnzInfo) ognzService.getObjById(id);
			for(UserInfo user:ognz.getUsers()){
				user.setIsUsed("0");
				userService.updateObj(user);
			}
			
			ognzService.delObjById(id);
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/ognz/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}
}
