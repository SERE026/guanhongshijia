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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.admin.model.AgentGrade;
import cn.com.dyninfo.o2o.furniture.admin.service.AgentGradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.StringUtil;

import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.RoleService;
import cn.com.dyninfo.o2o.furniture.admin.service.UserService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantTypeService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
/**
 * 商家资料添加
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/shangJiaInfo")
public class ShangJiaController {
	@Resource
	private ShangJiaService shangJiaService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private MerchantTypeService merchantTypeService;

	@Resource
	private AgentGradeService agentGradeService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 0;
		if ((request.getParameter("pageNo") != null)) {
			no = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (no > 0) {
			page.setPageNo(no);
		} else {
			page.setPageNo(1);
		}
		
		// 保存全部商家中的不重复省份、城市，以便组成下拉框选项
		List<ShangJiaInfo> shangjiaAll = (List<ShangJiaInfo>)shangJiaService.getListByWhere(new StringBuffer().append("and n.state='0'"));
		List<String> provinceList = new ArrayList<String>();
		List<String> cityList = new ArrayList<String>();
		String p = "";
		String c = "";
		for (int i=0 ;i<shangjiaAll.size(); i++) {
			ShangJiaInfo sj = shangjiaAll.get(i);
			if (sj.getProvince() != null) {
				p = sj.getProvince().getName();
				if (!provinceList.contains(p)) {
					provinceList.add(p);
				}
			}
			if (sj.getCity() != null) {
				c = sj.getCity().getName();
				if (!cityList.contains(c)) {
					cityList.add(c);
				}
			}
		}
		
		// 取查找参数
		StringBuffer where = new StringBuffer();
		String name = request.getParameter("name");
		String login_id = request.getParameter("login_id");
		String contactName = request.getParameter("contactName");
		String contactPhone = request.getParameter("contactPhone");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		if(name!=null&&name.length()>0){
			where.append(" and userInfo.shanfJiaInfo.name like '%"+name+"%'");
			mav.addObject("name", name);
		}
		if(login_id!=null&&login_id.length()>0){
			where.append(" and userInfo.login_id like '%"+login_id+"%'");
			mav.addObject("login_id", login_id);
		}
		if(contactName!=null&&contactName.length()>0){
			where.append(" and userInfo.shanfJiaInfo.contactName like '%"+contactName+"%'");
			mav.addObject("contactName", contactName);
		}
		if(contactPhone!=null&&contactPhone.length()>0){
			where.append(" and userInfo.shanfJiaInfo.contactPhone like '%"+contactPhone+"%'");
			mav.addObject("contactPhone", contactPhone);
		}
		if (province != null && province.length() > 0) {
			where.append(" and userInfo.shanfJiaInfo.province.name like '%"+province+"%'");
			mav.addObject("province", province);
		}
		if (city != null && city.length() > 0) {
			where.append(" and userInfo.shanfJiaInfo.city.name like '%"+city+"%'");
			mav.addObject("city", city);
		}
		
		
		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		if(daili!=null){
			String area[]=daili.getAreaid().split(",");
			String ids="(";
			for(int i=0;i<area.length;i++){
				ids+="'"+area[i].replace("|", "").replace("%", "")+"',";
			}
			if(ids.length()>1){
				ids=ids.substring(0,ids.length()-1);
			}
			ids+=")";
			where.append(" and userInfo.shanfJiaInfo.city.id in "+ids);
		}
		where.append(" and userInfo.is_user = '1' and userInfo.isUsed='1' ");
		HashMap<String, ?> mapp = userService.getListByPageWhere(where, page);
		List<UserInfo> users = (List<UserInfo>)mapp.get("DATA");
		page = (PageInfo) mapp.get("PAGE_INFO");
		mav.addObject("provinceList", provinceList);// 全部省
		mav.addObject("cityList", cityList);// 全部市
		mav.addObject("DATA", users);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/shangjia/shangJiaInfo/list");
		return mav;
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("merchantTypeList", merchantTypeService.getListByWhere(new StringBuffer(" and n.status=0")));
		mav.addObject("agentGradeList", agentGradeService.getListByWhere(new StringBuffer()));
		mav.setViewName("/shangjia/shangJiaInfo/add");
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
		mav.setViewName("/shangjia/shangJiaInfo/show");
		return mav;
	}
	
	/**
	 * 查询电话是否被占用
	 */
	@RequestMapping(value = "/ch/list")
	public void chlist(HttpServletRequest request,HttpServletResponse response) {
		
		String id=request.getParameter("id");
		String phone=request.getParameter("phone");
		StringBuffer where=new StringBuffer();
		if(phone!=null&&phone.length()>0){
			where.append(" and n.contactPhone='"+phone+"' ");
			if(id!=null&&id.length()>0){
				where.append(" and n.shangjia_id ='"+id+"' ");
			}
			List list=shangJiaService.getListByWhere(where);
			if(list!=null&&list.size()==0){
				ResponseUtil.printl(response, "{\"status\":0}","json");
			}else{
				ResponseUtil.printl(response, "{\"status\":1}","json");
			}
		}else{
			ResponseUtil.printl(response, "{\"status\":2}","json");
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
		mav.addObject("merchantTypeList", merchantTypeService.getListByWhere(new StringBuffer(" and n.status=0")));
		mav.addObject("agentGradeList", agentGradeService.getListByWhere(new StringBuffer()));
		mav.setViewName("/shangjia/shangJiaInfo/update");
		mav.addObject("info", userInfo);
		return mav;
	}
	
	
	
	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {

		int agentGradeId = 0;
		int sort = 9999;
		try {
			agentGradeId = Integer.parseInt(request.getParameter("agent_grade_id"));
			sort = Integer.parseInt(request.getParameter("sort"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			String login_id = request.getParameter("login_id");
			String passwd = request.getParameter("passwd");
			String qq = request.getParameter("qq");
			String shangjiaName = request.getParameter("shangjiaName");
			String contactPhone = request.getParameter("contactPhone");
			String contactName = request.getParameter("contactName");
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById("2");
			roles.add(roleInfo);
			UserInfo userInfo = new UserInfo();
			userInfo.setUser_name(contactName);
			userInfo.setRoles(roles);
			userInfo.setIsUsed("1");
			userInfo.setIs_user("1");
			userInfo.setLogin_id(login_id);
			userInfo.setPasswd(passwd);
			UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
			userInfo.setDaili(daili);
			AgentGrade agentGrade = new AgentGrade();
			agentGrade.setId(agentGradeId);
			userInfo.setAgentGrade(agentGrade);
			userInfo = (UserInfo)userService.addObj(userInfo);
			
			
			
			ShangJiaInfo shangjiaInfo = new ShangJiaInfo();
			MerchantType  type=(MerchantType) merchantTypeService.getObjById(request.getParameter("type_id"));
			String affiliation = getAffiliation();//归属吗
			shangjiaInfo.setAffiliation(affiliation);
			shangjiaInfo.setName(shangjiaName);
			shangjiaInfo.setContactName(contactName);
			shangjiaInfo.setContactPhone(contactPhone);
			shangjiaInfo.setSort(sort);
			shangjiaInfo.setUser(userInfo);
			shangjiaInfo.setType(type);
			shangjiaInfo.setQq(qq);
			shangjiaInfo.setDaili(daili);
			shangjiaInfo.setMoney(0.0);
			shangJiaService.addObj(shangjiaInfo);
			
			
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",0);
		}
		
	}

	public String getAffiliation(){
		String affiliation = "";
		affiliation = StringUtil.getRandomString(4);//归属吗
		List<ShangJiaInfo> allShangjia = (List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(" and n.affiliation = '"+affiliation+"'"));
		if(allShangjia.size()!=0){
			affiliation = getAffiliation();
		}
		return affiliation;
	}
	/**
	 * 更新保存
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) {
		int agentGradeId = 0;
		int sort = 9999;
		try {
			agentGradeId = Integer.parseInt(request.getParameter("agent_grade_id"));
			sort = Integer.parseInt(request.getParameter("sort"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			String id = request.getParameter("id");
			String login_id = request.getParameter("login_id");
			String passwd = request.getParameter("passwd");
			String qq = request.getParameter("qq");
			String shangjiaName = request.getParameter("shangjiaName");
			String contactPhone = request.getParameter("contactPhone");
			String contactName = request.getParameter("contactName");
			
			List<RoleInfo> roles = new ArrayList<RoleInfo>();
			RoleInfo roleInfo = (RoleInfo)roleService.getObjById("2");
			roles.add(roleInfo);
			/*
			 * 当修改的是当前登录用户的话，会出现（hibernate a different object with the same identifier value was already associated with the session）异常
			 * 所以先查询再赋值最后修改
			 */
			UserInfo user = (UserInfo)userService.getObjById(id);
			user.setRoles(roles);
			if(passwd!=null&&passwd.length()>0)
			user.setPasswd(MD5Encoder.encodePassword(passwd,
					user.getLogin_id()));
			user.setUser_name(contactName);
			AgentGrade agentGrade = new AgentGrade();
			agentGrade.setId(agentGradeId);
			user.setAgentGrade(agentGrade);
			userService.updateObj(user);
			MerchantType  type=(MerchantType) merchantTypeService.getObjById(request.getParameter("type_id"));
			ShangJiaInfo shangjiaInfo = (ShangJiaInfo) shangJiaService.getObjById(user.getShanfJiaInfo().getShangjia_id()+"");
			shangjiaInfo.setName(shangjiaName);
			shangjiaInfo.setType(type);
			shangjiaInfo.setQq(qq);
			shangjiaInfo.setSort(sort);
			shangjiaInfo.setContactName(contactName);
			shangjiaInfo.setContactPhone(contactPhone);
			shangJiaService.updateObj(shangjiaInfo);
			
			
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",0);
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
					shangJiaService.delObjStatusById(user.getShanfJiaInfo().getShangjia_id()+"");
					userService.delObjStatusById(userid);
					shangJiaService.updateShangpin(user.getShanfJiaInfo().getShangjia_id());
				}
			}
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",0);
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
			shangJiaService.delObjStatusById(user.getShanfJiaInfo().getShangjia_id()+"");
			shangJiaService.updateShangpin(user.getShanfJiaInfo().getShangjia_id());
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/shangJiaInfo/list","C_STATUS",0);
		}
	}
	
}
