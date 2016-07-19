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

package cn.com.dyninfo.o2o.furniture.web.address.controller;

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
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.OgnzInfo;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
/**
 *地区管理
 * @author 
 * Jan 27, 2011
 */
@Controller
@RequestMapping("/manage/area")
public class AreaContronller {

	@Resource
	private AreaService areaService;
	
	/**
	 * 框架页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/frame")
	public ModelAndView frame(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/area/frame");
		return mav;
	}
	
	@RequestMapping("/json/selection")
	public void selection(HttpServletRequest request,HttpServletResponse response,String parentId) {
		if(parentId!=null&&parentId.length()>0){
			List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
			ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
		}else{
			List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id is null "));
			ResponseUtil.printl(response, ResponseUtil.getJson(list).toString(), "json");
		}
	}
	@RequestMapping("/elId/selection")
	public void selectionEl(HttpServletRequest request,HttpServletResponse response,String parentId,String elId) {
		List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
		String jsoin="{\"elId\":\""+elId+"\",\"data\":"+ResponseUtil.getJson(list).toString()+"}";
		ResponseUtil.printl(response,jsoin , "json");
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
		StringBuffer where = new StringBuffer();
		if(parent_id == null || parent_id.equals("0")){
			where.append(" and parent.id= ").append("01").append("'");
		}else{
			where.append(" and parent.id ='").append(parent_id).append("' ");
		}
		List<AreaInfo> list = (List<AreaInfo>)areaService.getListByWhere(where);
		if(list != null && list.size() > 0){
			mav.addObject("ognzId",list.get(0).getId());
			mav.addObject("ognzName",list.get(0).getName());
		}
		mav.setViewName("/base/area/tree");
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
			String selectedNames = areaService.getAreaNamesByIds(selectedIds);
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
		mav.setViewName("/base/area/dialogSelection");
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
				where.append(" and parent.id is null  ");
			}else{
				where.append(" and parent.id ='").append(parent_id).append("' ");
			}
			List<AreaInfo> list = (List<AreaInfo>)areaService.getListByWhere(where);
			//
			StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
			str.append("<root>");
			for(AreaInfo ognz:list){
				str.append("<item id='").append(ognz.getId()).append("' ");
				str.append("parent_id='");
				str.append(ognz.getParent() == null ? "0" : ognz.getParent().getId()).append("' ");
				str.append("state='closed'>");
				str.append("<content><name>");
				str.append(ognz.getName());
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
		String ognzname = request.getParameter("ognzname");
		String tname = request.getParameter("tname");
		String isDefault = request.getParameter("isDefault");
		if(ognzname != null){
			where.append(" and name like '%").append(ognzname).append("%'");
			mav.addObject("ognzname", ognzname);
		}
		if(tname != null){
			where.append(" and parent.name like '%").append(tname).append("%'");
			mav.addObject("tname", tname);
		}
		//
		if(isDefault!=null&&isDefault.equals("0")){
				where.append(" ");
		}else{
			where.append("order by isDefault desc");
		}
		HashMap<String, List<AreaInfo>> mapp = (HashMap<String, List<AreaInfo>>) areaService.getListByPageWhere(where, page);
		List<AreaInfo> list = mapp.get("DATA");
		page = (PageInfo) mapp.get("PAGE_INFO");
		mav.setViewName("/base/area/list");
		mav.addObject("LIST", list);
		mav.addObject("parent_id", parent_id);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("isDefault", isDefault);
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
		mdv.setViewName("/base/area/add");
		OgnzInfo ognz = (OgnzInfo)areaService.getObjById(parent_id);
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
		AreaInfo ognzInfo = (AreaInfo)areaService.getObjById(id);
		mdv.addObject("ognzInfo", ognzInfo);
		mdv.addObject("parent_id", parent_id);
		mdv.setViewName("/base/area/show");
		return mdv;
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable
	String id, String parent_id, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/base/area/disUpdate");
		AreaInfo Info = (AreaInfo)areaService.getObjById(id);
		mav.addObject("info", Info);
		mav.addObject("parent_id", parent_id);
		return mav;
	}

	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, AreaInfo areInfo) {
		try{
			if (areaService.getObjById(request.getParameter("parent.id")) != null) {
				areInfo.setParent((AreaInfo)areaService.getObjById(request
						.getParameter("parent.id")));
				areInfo = (AreaInfo)areaService.addObj(areInfo);
			}else{
				areInfo.setParent(null);
				areInfo = (AreaInfo)areaService.addObj(areInfo);
			}
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}

	/**
	 * 更新保存
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(AreaInfo ognzInfo, HttpServletRequest request,
			HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			AreaInfo ognz=(AreaInfo)areaService.getObjById(request
					.getParameter("parent.id"));
			ognzInfo.setParent(ognz);
			ognzInfo.setId(id);
			areaService.updateObj(ognzInfo);
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
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
					areaService.delObjById(ognzid);
				}
			}
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}
	/**
	 * 删除
	 */
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public ModelAndView delobj(@PathVariable String id, HttpServletRequest request) {
		try{
			areaService.delObjById(id);
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/area/list?parent_id="+request.getParameter("parent_id"),"C_STATUS",0);
		}
		
	}
}
