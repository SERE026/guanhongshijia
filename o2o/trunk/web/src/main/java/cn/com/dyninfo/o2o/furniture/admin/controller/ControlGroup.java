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
import cn.com.dyninfo.o2o.furniture.admin.model.GroupResRelation;
import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.ControlGroupService;
import cn.com.dyninfo.o2o.furniture.admin.service.OgnzService;
import cn.com.dyninfo.o2o.furniture.admin.service.ResService;
/**
 * 权限组管理
 * @author jettang
 * Feb 17, 2011
 */
@Controller
@RequestMapping("/manage/controlGroup")
public class ControlGroup {

	@Resource
	private ControlGroupService controlGroupService;
	
	@Resource
	private ResService resService;
	
	@Resource
	private OgnzService ognzService;
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		List<ControlGroupInfo> controlGroups=new ArrayList<ControlGroupInfo>();
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(18);
		int pageNo = 0;
		int totalpage = 0;
		if((request.getParameter("pageNo") != null)
				&& (request.getParameter("totalpage") != null)) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			totalpage = Integer.parseInt(request.getParameter("totalpage"));
		}
		if(pageNo > 0 && pageNo <= totalpage) {
			pageInfo.setPageNo(pageNo);
		}else{
			pageInfo.setPageNo(1);
		}
		HashMap map=controlGroupService.getListByPageWhere(null, pageInfo);
		if(map!=null){
			controlGroups=(List<ControlGroupInfo>) map.get("DATA");
		}
		pageInfo=(PageInfo) map.get("PAGE_INFO");
		mav.addObject("LIST",controlGroups);
		mav.addObject("PAGE_INFO",pageInfo);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/base/controlGroup/list");
		return mav;
	}
	
	/**
	 * 进入添加
	 */
	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,HttpServletResponse response,ControlGroupInfo controlGroupInfo){
		ModelAndView mdv=new ModelAndView();
		//资源访问列表+数据访问权限
		String html=getreshtml((List<ResInfo>)resService.getListByWhere(
				new StringBuffer(" and resInfo.parent is null ")),null, request);
		mdv.addObject("reslist",html);
		mdv.setViewName("/base/controlGroup/add");
		return mdv;
	}
	
	/**
	 * 显示
	 */
	@RequestMapping(value="/{id}")
	public ModelAndView show(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		ControlGroupInfo controlGroupInfo =(ControlGroupInfo)controlGroupService.getObjById(id);
		return new ModelAndView("/base/controlGroup/show","controlGroupInfo",controlGroupInfo);
	}
	
	/**
	 * 进入编辑
	 */
	@RequestMapping(value="/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav=new ModelAndView();
		ControlGroupInfo controlGroupInfo =(ControlGroupInfo)controlGroupService.getObjById(id);
		mav.addObject("info", controlGroupInfo);
		//资源访问列表+数据访问权限
		String html=getreshtml((List<ResInfo>)resService.getListByWhere(
				new StringBuffer(" and resInfo.parent is null ")),controlGroupInfo.getGrr(), request);
		mav.addObject("reslist",html );
		mav.setViewName("/base/controlGroup/disUpdate");
		return mav;
	
	}
	
	/**
	 * 添加保存
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,ControlGroupInfo controlInfo){
		try{
			String resids[]=request.getParameterValues("checkbox");
			String ids="";
			if(resids!=null){
				for(String resid:resids)
					ids+="'"+resid+"' ,";
				List<ResInfo> reslist=(List<ResInfo>) resService.getListByWhere(new StringBuffer(" and resInfo.id in ("+ids.substring(0,ids.length()-1)+")"));
				Set set=new HashSet();
				for(ResInfo res:reslist){
					GroupResRelation grr = new GroupResRelation();
					grr.setAccessObj(request.getParameter(res.getId()+"_acceeObj"));
					grr.setAccessType(request.getParameter(res.getId()+"_rescontrol"));
					grr.setRes(res);
					set.add(grr);
				}
				controlInfo.setGrr(set);
			}
			//
			controlInfo = (ControlGroupInfo)controlGroupService.addObj(controlInfo);
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",0);
		}
		
	}
	
	/**
	 * 更新保存
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView update(ControlGroupInfo controlGroupInfo, HttpServletRequest request,HttpServletResponse response,String id){
		try{
			ControlGroupInfo controlGroupInfo2 =(ControlGroupInfo)controlGroupService.getObjById(id);
			controlGroupInfo2.setGroupName(controlGroupInfo.getGroupName());
			controlGroupInfo2.setPs(controlGroupInfo.getPs());
			controlGroupInfo2.setIsDefault(controlGroupInfo.getIsDefault());
			String resids[]=request.getParameterValues("checkbox");
			String ids="";
			if(resids!=null){
				for(String resid:resids)
					ids+="'"+resid+"' ,";
				List<ResInfo> reslist=(List<ResInfo>) resService.getListByWhere(new StringBuffer(" and resInfo.id in ("+ids.substring(0,ids.length()-1)+")"));
				Set set=new HashSet();
				for(ResInfo res:reslist){
					GroupResRelation grr = new GroupResRelation();
					grr.setAccessObj(request.getParameter(res.getId()+"_acceeObj"));
					grr.setAccessType(request.getParameter(res.getId()+"_rescontrol"));
					grr.setRes(res);
					set.add(grr);
				}
				controlGroupInfo2.setGrr(set);
			}
			
			controlGroupService.updateObj(controlGroupInfo2);
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",0);
		}
		
	}

	/**
	 * 删除
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ModelAndView del(@PathVariable String id, HttpServletRequest request,HttpServletResponse response){
		try{
			if(request.getParameterValues("list")!=null){
				String []list=request.getParameterValues("list");
				for(String controlGroupId:list){
					controlGroupService.delObjById(controlGroupId);
				}
			}
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",0);
		}
		
	}
	/**
	 * 删除单个对象
	 */
	@RequestMapping(value="/del/{id}")
	public ModelAndView delObject(@PathVariable String id, HttpServletRequest request,HttpServletResponse response){
		try{
			controlGroupService.delObjById(id);
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/controlGroup/list","C_STATUS",0);
		}
		
	}
	
	/**
	 * 资源权限
	 * @param res
	 * @return
	 */
	public String getreshtml(List<ResInfo> res, Set<GroupResRelation> resy, HttpServletRequest request){
		String html="";
		Map<String, GroupResRelation> map = new HashMap<String, GroupResRelation>();
		if(resy!=null)
			for(GroupResRelation grr : resy){
					map.put(grr.getRes().getId(), grr);
			}
		html += "<table cellspacing=\"0\" cellpadding=\"0\" class=\"table4_da\">";
		html += "<thead><tr><td>应用模块</td><td>子模块</td><td style='width:220px;'>数据访问权限</td><td>操作权限</td></tr></thead>";
		for(ResInfo topRes:res){//1级
			if(topRes.getParent()==null){
				html += "<tr>";
				html += "<td>" + topRes.getRes_name() + "</td>";
				html += "<td colspan ='3'>&nbsp;</td>";
				html += "</tr>";
				for(ResInfo parentRes : topRes.getChildren()){//2级
					GroupResRelation grr = null;
					if(map.get(parentRes.getId()) != null){
						grr = (GroupResRelation)map.get(parentRes.getId());
					}
					html += "<tr>";
					html += "<td>&nbsp;</td>";
					html += "<td>";
					html += "<input type=\"checkbox\" name=\"checkbox\" id=\"p" + parentRes.getId()+"\""+
						"value=\""+parentRes.getId()+"\" onclick =\"javascript:allclick(this);\"";
					if(grr != null)
						html += "checked";
					html += "/>";
					html += parentRes.getRes_name() + "</td>";
					html += "<td><div>";
					html += "<div style='float:left;'><select name='"+parentRes.getId()+"_rescontrol' onchange='javascript:showChoose(this);'>";
					html += "<option value='0' "+(grr!=null&&"0".equals(grr.getAccessType()) ? "selected" : "")+">全部</option>";
					html += "<option value='1' "+(grr!=null&&"1".equals(grr.getAccessType()) ? "selected" : "")+">指定部门（多个）及其下属部门</option>";
					html += "<option value='2' "+(grr!=null&&"2".equals(grr.getAccessType()) ? "selected" : "")+">人员所在部门及其下属部门</option>";
					html += "<option value='3' "+(grr!=null&&"3".equals(grr.getAccessType()) ? "selected" : "")+">个人</option>";
  					html += "</select></div>";
  					//
  					if(grr == null ||grr.getAccessType()==null|| !grr.getAccessType().equals("1")){//对于已选择的判断其值
  						html += "<div id='"+parentRes.getId()+"_div' style='display:none;float:left;'>";
  						html += "&nbsp;<a href=\"#\" onclick=\"openDialog('"+parentRes.getId()+"')\"";
  	  					html += ">选择&gt;&gt;</a>";
  	  					html += "&nbsp;<input type=text readOnly id='"+parentRes.getId()+"_div1'/>" +
  	  							"<input type=hidden id='"+parentRes.getId()+"_acceeObj' name='"+parentRes.getId()+"_acceeObj' " +
  	  									"value=''/>";
  	  					html += "</div>";
  					}else{//如果已有选择的组织对象
  						html += "<div id='"+parentRes.getId()+"_div' style='display:block;float:left;'>";
  						html += "&nbsp;<a href=\"#\" onclick=\"openDialog('"+parentRes.getId()+"')\"";
	  					html += ">选择&gt;&gt;</a>";
  	  					html += "&nbsp;<input type=text readOnly id='"+parentRes.getId()+"_div1' ";
  	  					html += "value='"+ognzService.getOgnzNamesByIds(grr.getAccessObj())+"'";
  	  					html += "/>";
  	  					html += "<input type=hidden id='"+parentRes.getId()+"_acceeObj' name='"+parentRes.getId()+"_acceeObj' " +
  	  								"value='"+grr.getAccessObj()+"'/>";
  	  					html += "</div>";
  					}
  					//
  					html += "</div></td>";
  					html += "<td>";
  					int i=0;
  					for(ResInfo childRes : parentRes.getChildren()){//3级
  						html += "<input type=\"checkbox\" name=\"checkbox\" id=\"c" + parentRes.getId()+"\""+
  								"value=\""+childRes.getId()+"\" onclick =\"javascript:allunclick(this);\"";
  						if(map.get(childRes.getId()) != null){
  							html += "checked";
  						}
  						html += "/>";
  						html += childRes.getRes_name();
  						i++;
  						if(i==5){
  							html += "<br/>";
  							i=0;
  						}
  					}
  					html += "</td>";
					html += "</tr>";
				}
			}
		}
		html += "</table>";
		return html;
	}
	
}

