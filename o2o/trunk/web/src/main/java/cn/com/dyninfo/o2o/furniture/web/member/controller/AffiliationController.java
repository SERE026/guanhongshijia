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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

@Controller
@RequestMapping("/manage/affiliation")
public class AffiliationController{

	@Resource
	private ShangJiaService shangJiaService;

	@Resource
	private HuiyuanService huiyuanService;
	
	
	@RequestMapping("/merchant/list")
	public ModelAndView merchant(HttpServletRequest request,HttpServletResponse response){
		// 创建模型视图对象
		ModelAndView mav=new ModelAndView();
		// 根据传入的ID拿到会员
		String huiyuanId = request.getParameter("huiyuanId");
		if (huiyuanId != null) {
			HuiyuanInfo huiyuan = (HuiyuanInfo)huiyuanService.getObjById(huiyuanId);
			mav.addObject("huiyuan", huiyuan);
		}
		
		PageInfo page=new PageInfo();
		page.setPageSize(25);
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			pageNo="1";
		}
		page.setPageNo(Integer.parseInt(pageNo));
		StringBuffer where=new StringBuffer();
		String selectId=request.getParameter("selectId");
		if(selectId==null)
			selectId="";
		String select[]=request.getParameterValues("select");
		if(select!=null){
			for(String sID:select){
				selectId+=sID+",";
			}
		}
		String provinceId=request.getParameter("provinceId");
		if(provinceId!=null&&provinceId.length()>0){
			where.append(" and n.province.id='"+provinceId+"' ");
			mav.addObject("provinceId", provinceId);
		}
		String cityId=request.getParameter("cityId");
		if(cityId!=null&&cityId.length()>0){
			where.append(" and n.city.id='"+cityId+"' ");
			mav.addObject("cityId", cityId);
		}

		mav.addObject("merchant_order_id", request.getParameter("merchant_order_id"));
		mav.addObject("selectId", selectId);
		mav.addAllObjects(shangJiaService.getListByPageWhere(where, page));
		mav.setViewName("/huiyuan/affiliation/shoplist");
		return mav;
	}
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		StringBuffer where=new StringBuffer();
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
		where.append(" and n.state ='0'");
		mav.addAllObjects(shangJiaService.getListByPageWhere(where, page));
		mav.addObject("PAGE_INFO", page);
		mav.setViewName("/huiyuan/affiliation/list");
		return mav;
	}

	@RequestMapping("/selection")
	public void selection(HttpServletRequest request,HttpServletResponse response){
		StringBuffer where = new StringBuffer();
		where.append(" and n.state ='0'");
		List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(where);
		List<ShangJiaInfo> info=new ArrayList<ShangJiaInfo>();
		for(int i=0;i<list.size();i++){
			ShangJiaInfo info2=new ShangJiaInfo();
			info2.setShangjia_id(list.get(i).getShangjia_id());
			info2.setName(list.get(i).getName());
			info.add(info2);
		}
		ResponseUtil.printl(response, ResponseUtil.getJson(info).toString(), "json");
	}

	@RequestMapping("/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		// 根据ID得到会员
		HuiyuanInfo huiyuan = (HuiyuanInfo)huiyuanService.getObjById(id);
		// 设置归属商家信息（这里处于未保存状态）
		String sjID = request.getParameter("sjID");
		ShangJiaInfo shangjia = null;
		if (sjID != null) {
			shangjia = (ShangJiaInfo)shangJiaService.getObjById(sjID);
			if (huiyuan != null) {
				huiyuan.setShangJiaInfo(shangjia);
			}
		}
		
		mav.addObject("info",huiyuan);
		mav.setViewName("/huiyuan/affiliation/update");
		return mav;
	}

	/**
	 * 更新会员归属
	 * @param request
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("huiYuan_id");
		String shangId=request.getParameter("shangId");
		ShangJiaInfo info1=(ShangJiaInfo) shangJiaService.getObjById(shangId);
		HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(id);
		info.setShangJiaInfo(info1);
		huiyuanService.updateObj(info);
		mav.setViewName("redirect:/html/manage/affiliation/huiyuan");
		return mav;
	}

	
	@RequestMapping("/huiyuan")
	public ModelAndView huiyuan(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		StringBuffer where=new StringBuffer();
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
		
		if(name != null && !"".equals(name.trim())){
			where.append(" and n.name like '%").append(name).append("%'");
		}
		if(userName != null && !"".equals(userName.trim())){
			where.append(" and n.userName like '%").append(userName).append("%'");
		}
		if(loginData != null && !"".equals(loginData.trim())){
			where.append(" and n.loginData like '%").append(loginData).append("%'");
		}

//		if(name!=null&&!name.equals("")){
//			where.append(" and n.name like '%").append(name).append("%'");
//		}
//		if(userName!=null&&!userName.equals("")){
//			where.append(" and n.userName like '%").append(userName).append("%'");
//		}
//		if(loginData!=null&&!loginData.equals("")){
//			where.append(" and n.loginData like '%").append(loginData).append("%'");
//		}
		
		where.append(" and n.status ='0'");
		mav.addAllObjects(huiyuanService.getListByPageWhere(where, page));
		mav.addObject("PAGE_INFO", page);
		mav.setViewName("/huiyuan/affiliation/alist");
		return mav;
	}
}
