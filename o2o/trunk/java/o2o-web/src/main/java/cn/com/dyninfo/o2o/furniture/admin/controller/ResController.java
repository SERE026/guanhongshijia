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

import cn.com.dyninfo.o2o.old.model.ResInfo;
import cn.com.dyninfo.o2o.old.service.ResService;


@Controller
@RequestMapping("/manage/res")
public class ResController{

	@Resource
	private ResService resService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		StringBuffer where=new StringBuffer();
		List<ResInfo> list=new ArrayList<ResInfo>();
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageSize(12);
		int pageNo = 0;
		if((request.getParameter("pageNo") != null)) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if(pageNo > 0){
			pageInfo.setPageNo(pageNo);
		}else{
			pageInfo.setPageNo(1);
		}
		String name=request.getParameter("name");
		if(name !=null && !name.equals("")){
			where.append(" and (resInfo.res_name like '%"+name+"%' or resInfo.parent.res_name like '%"+name+"%') ");
			mav.addObject("name", name);
		}
		
		HashMap map=resService.getListByPageWhere(where,pageInfo);
		if(map!=null){
			list=(List<ResInfo>) map.get("DATA");
		}
		pageInfo=(PageInfo) map.get("PAGE_INFO");
		mav.addObject("LIST",list);
		mav.addObject("PAGE_INFO",pageInfo);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/res/list");
		return mav;
	}
	/**
	 * 添加
	 */
	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mdv=new ModelAndView();
		mdv.setViewName("/base/res/addres");
		return mdv;
	}
	
	/**
	 * 显示
	 */
	@RequestMapping(value="/{id}")
	public ModelAndView show(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		ResInfo resInfo = (ResInfo)resService.getObjById(id);
		return new ModelAndView("/base/res/show","resInfo",resInfo);
	}
	
	/**
	 * 编辑
	 */
	@RequestMapping(value="/disUpdate/{id}")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		ResInfo resInfo =(ResInfo)resService.getObjById(id);
		mav.setViewName("/base/res/disUpdate");
		mav.addObject("info", resInfo);
		return mav;
	
	}
	
	/**
	 * 添加保存
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,ResInfo resInfo){
		try{
			ResInfo parent= (ResInfo)resService.getObjById(request.getParameter("parent1"));
			resInfo.setParent(parent);
			String childs[]=request.getParameterValues("childList");
			List childList=new ArrayList();
			if(childs!=null){
				for(String child:childs){
					ResInfo res=new ResInfo();
					res.setIs_menu("0");
					res.setIs_default("0");
					res.setIndex_order(1);
					res.setParent(resInfo);
					res.setModule_name(child.split("::")[0]);
					res.setRes_name(child.split("::")[1]);
					childList.add(res);
				}
				
			}
			resInfo.setChildren(childList);
			resInfo = (ResInfo)resService.addObj(resInfo);
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",0);
		}
		
	}

	/**
	 * 更新保存
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView update(ResInfo resInfo, HttpServletRequest request,HttpServletResponse response){
		try{
			String id = request.getParameter("id");
			ResInfo resInfo2 = (ResInfo)resService.getObjById(id);
			resInfo2.setIs_menu(resInfo.getIs_menu());
			resInfo2.setImg_url(resInfo.getImg_url());
			resInfo2.setIndex_order(resInfo.getIndex_order());
			resInfo2.setIs_default(resInfo.getIs_default());
			resInfo2.setRes_name(resInfo.getRes_name());
			resInfo2.setModule_name(resInfo.getModule_name());
			resInfo2.setUrl(resInfo.getUrl());
			resInfo2.setParent((ResInfo)resService.getObjById(request.getParameter("parent1")));
			resInfo2.setPs(resInfo.getPs());
			resService.updateObj(resInfo2);
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",0);
		}
		
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delall",method=RequestMethod.DELETE)
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response){
		try{
			String ids[]=request.getParameterValues("list");
			for(String id1:ids)
				resService.delObjById(id1);
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",0);
		}
		
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public ModelAndView delobject(@PathVariable String id, HttpServletRequest request,HttpServletResponse response){
		try{
			resService.delObjById(id);
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/res/list","C_STATUS",0);
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
			String selectedNames = resService.getResNamesByIds(selectedIds);
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
		mav.setViewName("/base/res/dialogSelection");
		return mav;
	}
	
	/**
	 * 返回格式
	 * @param request
	 * @return
	 */
	@RequestMapping("/getResList")
	public ModelAndView getResList(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			pw = response.getWriter();
			String parent_id = request.getParameter("parent_id");
			StringBuffer where = new StringBuffer();
			if(parent_id == null || parent_id.equals("0")){
				where.append(" and resInfo.parent.id is null ");
			}else{
				where.append(" and resInfo.parent.id ='").append(parent_id).append("' ");
			}
			List<ResInfo> list = (List<ResInfo>)resService.getListByWhere(where);
			//
			StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
			str.append("<root>");
			for(ResInfo res : list){
				str.append("<item id='").append(res.getId()).append("' ");
				str.append("parent_id='");
				str.append(res.getParent() == null ? "0" : res.getParent().getId()).append("' ");
				str.append("state='closed'>");
				str.append("<content><name>");
				str.append(res.getRes_name());
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
			
}
