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

package cn.com.dyninfo.o2o.furniture.web.member.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;

/**
 * 会员管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/huiyuan")
public class HuiyuanController{
    
	 @Resource
	 private HuiyuanService huiyuanService;
	 
	 @Resource
	 private AreaService areaService;
	 

	 
	 @RequestMapping("/list")
	 public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		    ModelAndView mav=new ModelAndView();
		    StringBuffer where=new StringBuffer();
		    UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
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
		    String name=request.getParameter("name");
		    String userName=request.getParameter("userName");
		    String loginData=request.getParameter("loginData");
		    if(name!=null&&!name.equals("")){
		    	where.append(" and n.name like '%").append(name).append("%'");
		    }
		    if(userName!=null&&!userName.equals("")){
		    	where.append(" and n.userName like '%").append(userName).append("%'");
		    }
		    if(loginData!=null&&!loginData.equals("")){
		    	where.append(" and n.loginData like '%").append(loginData).append("%'");
		    }
		    if(info.getIs_user().equals("1")){
		    	where.append(" and n.shangJiaInfo.name like '%").append(info.getShanfJiaInfo().getName()).append("%'");
		    }
		    where.append(" and n.status ='0'");
			mav.addAllObjects(huiyuanService.getListByPageWhere(where, page));
			mav.addObject("name",name);
			mav.addObject("userName",userName);
			mav.addObject("PAGE_INFO", page);
			mav.addObject("loginData",loginData);
			mav.addObject("info",info);
			mav.setViewName("/huiyuan/huiyuan/list");
			return mav;
	 }
	 
	 @RequestMapping("/{id}/show")
	 public ModelAndView show(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("info",huiyuanService.getObjById(id));
		 mav.setViewName("/huiyuan/huiyuan/show");
		 return mav;
	 }
	 
	 @RequestMapping("/{id}/disUpdate")
	 public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("info",huiyuanService.getObjById(id));
	     mav.addObject("province", areaService.getListByWhere(new StringBuffer(" and n.parent is null")));
		 mav.setViewName("/huiyuan/huiyuan/update");
		 return mav;
	 }
	 
	 @RequestMapping("/update")
	 public ModelAndView update(HttpServletRequest request){
		     ModelAndView mav=new ModelAndView();
		     String id=request.getParameter("huiYuan_id");
		     String birthday=request.getParameter("birthday");
		     String tel=request.getParameter("tel");
		     String postcode=request.getParameter("postcode");
		     String phone=request.getParameter("phone");
		     String sex=request.getParameter("sex");
		     String province_id=request.getParameter("province.id");
		     String city_id=request.getParameter("city.id");
		     String region_id=request.getParameter("region.id");
		     String address=request.getParameter("address");
		     String name=request.getParameter("userName");
		     AreaInfo province=(AreaInfo) areaService.getObjById(province_id);
		     AreaInfo city=(AreaInfo) areaService.getObjById(city_id);
		     AreaInfo region=(AreaInfo) areaService.getObjById(region_id);
		     HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(id);
		     String password=request.getParameter("password");
		     
		     if(info!=null){
			     info.setSex(sex);
			     info.setUserName(name);
			     info.setBirthday(birthday);
			     info.setTel(tel);
			     info.setPostcode(postcode);
			     info.setSex(sex);
			     info.setPhone(phone);
			     info.setAddress(address);
			     info.setProvince(province);
			     info.setCity(city);
			     info.setRegion(region);
			     if(password!=null&&password.length()>0){
			    	 info.setPassword(MD5Encoder.encodePassword(password,
								Context.PASSWORDY));
			     }
			     
			     huiyuanService.updateObj(info);
		     }
		     mav.setViewName("redirect:/html/manage/huiyuan/list");
		     return mav;
	 }
	 
	 /****
		 * 删除
		 * @param id
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value="/{id}/del")
		public ModelAndView del(@PathVariable String id, HttpServletRequest request,HttpServletResponse response){
			   HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(id);
			   if(info!=null){
				   info.setStatus("1");
				   info.setPhone("0");
				   huiyuanService.updateObj(info);
			   }
			return new ModelAndView("redirect:/html/manage/huiyuan/list");
		}
		
		/***
		 * 
		 * @param request
		 * @param response
		 * @return ModelAndView
		 */
		@RequestMapping(value="/delall")
		public ModelAndView del(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mav=new ModelAndView();
			try{
				String ids[]=request.getParameterValues("list");
				for(String id:ids){
					HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(id);
				    if(info!=null){
					    info.setStatus("1");
					    info.setPhone("0");
					    huiyuanService.updateObj(info);
				    }
				}
				mav.addObject("C_STATUS", 1);
			}catch(Exception e){
				e.printStackTrace();
				mav.addObject("C_STATUS", 0);
			
			}
			return new ModelAndView("redirect:/html/manage/huiyuan/list");
		}
		
		/**
		 * 添加
		 */
		@RequestMapping(value = "/disAdd")
		public ModelAndView disAdd(HttpServletRequest request,
				HttpServletResponse response, HuiyuanInfo userInfo) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/huiyuan/huiyuan/add");
			return mav;
		}
		
		/**
		 * 添加保存
		 */
		@RequestMapping("/add")
		public ModelAndView add(HttpServletRequest request,
				HttpServletResponse response, HuiyuanInfo userInfo) {
			try{
				userInfo = (HuiyuanInfo)huiyuanService.addObj(userInfo);
				return new ModelAndView("redirect:/html/manage/huiyuan/list","C_STATUS",1);
			}catch(Exception e){
				e.printStackTrace();
				return new ModelAndView("redirect:/html/manage/huiyuan/list","C_STATUS",0);
			}
			
		}
		
		@SuppressWarnings({ "unchecked", "unchecked" })
		@RequestMapping("/city")
		 public ModelAndView city(HttpServletRequest request,
		   HttpServletResponse response) {
			  String pid=request.getParameter("pid");
			  JSONObject job=new JSONObject();
			  List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(new StringBuffer(" and n.parent.id='").append(pid).append("'"));
			  int i=0;
			  for(AreaInfo v:ars){
			   try {
			    JSONObject job1=new JSONObject();
			    job1.put("id", v.getId());
			    job1.put("name", v.getName());
			    job.put("city"+i, job1);
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
		 
		@SuppressWarnings({ "unchecked", "unchecked" })
		@RequestMapping("/region")
		public ModelAndView region(HttpServletRequest request,
			   HttpServletResponse response) {
				  String pid=request.getParameter("pid");
				  JSONObject job=new JSONObject();
				  List<AreaInfo> ars=(List<AreaInfo>) areaService.getListByWhere(new StringBuffer(" and n.parent.id='").append(pid).append("'"));
				  int i=0;
				  for(AreaInfo v:ars){
				   try {
				    JSONObject job1=new JSONObject();
				    job1.put("id", v.getId());
				    job1.put("name", v.getName());
				    job.put("region"+i, job1);
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
