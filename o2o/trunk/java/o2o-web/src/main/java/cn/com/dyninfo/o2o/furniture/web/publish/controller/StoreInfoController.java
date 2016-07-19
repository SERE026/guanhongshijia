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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.old.service.UserService;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 店铺信息维护
 * @author 王敏
 *
 */
@Controller
@RequestMapping("/manage/storeInfo")
public class StoreInfoController {

	@Resource
	private ShangJiaService shangJiaService;
	
	@Resource
	private UserService userService;
	@Resource
	private AreaService areaService;
	
	/**
	 * 显示
	 */
	@RequestMapping(value = "/show")
	public ModelAndView show( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String stats=request.getParameter("C_STATUS");
		if(stats==null){
			mav.addObject("stats", "0");
		}else{
			mav.addObject("stats", "1");
		}
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
//		System.out.println("店招图片：" + merchants.getDzImage());
//		System.out.println("店招外链：" + merchants.getDzUrl());
		if(merchants.getDzImage()!=null){
			// 保存店招图片
			String img[] = merchants.getDzImage().split(",");
			List imgList = new ArrayList();
			for (int i=0; i<img.length; i++) {
				imgList.add(img[i]);
			}
			mav.addObject("imgList", imgList);
			// 保存店招外链（和图片一一对应）
			String url[] = merchants.getDzUrl().split(",");
			List urlList = new ArrayList();
			for (int i=0; i<url.length; i++) {
				urlList.add(url[i]);
			}
			mav.addObject("urlList", urlList);
		}
		// 取女人街图片
		if(merchants.getNrjImage() != null){
			String img[] = merchants.getNrjImage().split(",");
			List nrj_imgList = new ArrayList();
			for (int i=0; i<img.length; i++) {
				nrj_imgList.add(img[i]);
			}
			mav.addObject("nrj_imgList", nrj_imgList);
		}
		mav.addObject("info", shangJiaService.getObjById(""+merchants.getShangjia_id()));
		mav.setViewName("/shangjia/info/info");
		return mav;
	}
	
	/**
	 * 编辑
	 */
	@RequestMapping(value = "/disUpdate")
	public ModelAndView disUpdate(HttpServletRequest request, HttpServletResponse response,ShangJiaInfo info) {
		ShangJiaInfo shangJiaInfo	=(ShangJiaInfo) shangJiaService.getObjById(info.getShangjia_id()+"");
		shangJiaInfo.setName(info.getName());
		shangJiaInfo.setContactName(info.getContactName());
		shangJiaInfo.setContactPhone(info.getContactPhone());
		shangJiaInfo.setAddress(info.getAddress());
		shangJiaInfo.setLatitude(info.getLatitude());
		shangJiaInfo.setLongitude(info.getLongitude());
		shangJiaInfo.setProvince(info.getProvince());
		shangJiaInfo.setCity(info.getCity());
		shangJiaInfo.setCounty(info.getCounty());
		shangJiaInfo.setFlag(info.getFlag());
		shangJiaInfo.setImage(request.getParameter("iamge"));
		// 取店招、女人街图片和外链
		String dz = request.getParameter("dzList");
		String nrj_dzList = request.getParameter("nrj_dzList");
		String url = request.getParameter("urlList");
		shangJiaInfo.setDzImage(dz);
		shangJiaInfo.setNrjImage(nrj_dzList);
		shangJiaInfo.setDzUrl(url);
		shangJiaInfo.setIntro(request.getParameter("intro"));
		shangJiaInfo.setDesc(request.getParameter("desc"));
		shangJiaService.updateObj(shangJiaInfo);
		return new ModelAndView("redirect:/html/manage/storeInfo/show","C_STATUS","1");
	}
	/**
	 * 编辑
	 */
	@RequestMapping(value = "/file")
	public ModelAndView file(HttpServletRequest request, HttpServletResponse response) {
		ShangJiaInfo info=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		List list=new ArrayList();
		if(info!=null){
			 String filePath=request.getRealPath("/")+"/merchants/"+info.getShangjia_id();
			File f=new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			File files[]=f.listFiles();
			for(File file:files){
				list.add(file.getName());
			}
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("data", list);
		mav.addObject("info", info);
		mav.setViewName("/shangjia/info/file");
		return mav;
	}
	
	/**
	 * 编辑
	 */
	@RequestMapping(value = "/colseFile")
	public void colseFile(HttpServletRequest request, HttpServletResponse response) {
		ShangJiaInfo info=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		String fileName=request.getParameter("fileName");
		String filePath=request.getRealPath("/")+"/merchants/"+info.getShangjia_id()+"/"+fileName;
		File f=new File(filePath);
		if(f.exists())
			f.delete();
		try{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			response.getWriter().print("{\"status\":0}");
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
