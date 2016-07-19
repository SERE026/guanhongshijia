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

package cn.com.dyninfo.o2o.furniture.android.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.UploadImage;

import cn.com.dyninfo.o2o.old.service.ActiveMemberService;
import cn.com.dyninfo.o2o.old.service.GameActiveService;
import cn.com.dyninfo.o2o.old.service.GameParamService;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.CommentService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;

/**
 * android 会员信息
 * @author feng
 */
@Controller
@RequestMapping("/ahuiyuan")
public class AhuiyuanController{
    
	@Resource
	private CommentService commentService;
	
	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		
		@Resource
		private GameActiveService gameActiveService;
		

		@Resource
		private GameParamService gameParamService;
		
		
		@Resource
		private GoodsService goodsService;
		
		@Resource
		private ActiveMemberService activeMemberService;
		
		@Resource
		private HuiyuanService huiyuanService;
		
		/*
		 * 上传头像
		 */
	 @RequestMapping("/uploadimg")
	 public void uploadimg(HttpServletRequest request,HttpServletResponse response){
			try {
				UploadImage upload=new UploadImage();
				upload.doPost(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
	 }
	 
		/*
		 * 修改头像
		 */
	 @RequestMapping("/edittx")
	 public void edittx(HttpServletRequest request,HttpServletResponse response){
			try {
				String txImage=request.getParameter("imgname");
				String uid=request.getParameter("uid");
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(uid);
				huiyuan.setTxImage(txImage);
				huiyuanService.updateObj(huiyuan);
				ResponseUtil.printl(response,"{\"status\":0}", "json");
			}catch(Exception e){
				e.printStackTrace();
			}
			ResponseUtil.printl(response,"{\"status\":1}", "json");
	 }
	 
		/*
		 * 修改密码
		 */
	 @RequestMapping("/editpsw")
	 public void editpsw(HttpServletRequest request,HttpServletResponse response){
			try {
				String oldpsw=request.getParameter("oldpsw");
				String newpsw=request.getParameter("newpsw");
				String uid=request.getParameter("uid");
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(uid);
				if(MD5Encoder.isPasswordValid(huiyuan.getPassword(),oldpsw, Context.PASSWORDY)){//判断旧密码是否正确
					huiyuan.setPassword(MD5Encoder.encodePassword(newpsw,Context.PASSWORDY));
					huiyuanService.updateObj(huiyuan);
				}
				ResponseUtil.printl(response,"{\"status\":0}", "json");
			}catch(Exception e){
				e.printStackTrace();
			}
			ResponseUtil.printl(response,"{\"status\":1}", "json");
	 }
	 
	 
	 
		/*
		 * 修改昵称
		 */
	 @RequestMapping("/editname")
	 public void editname(HttpServletRequest request,HttpServletResponse response){
			try {
				request.setCharacterEncoding("utf-8");
				String userName=request.getParameter("userName");
			//	userName=new String(userName.getBytes("ISO-8859-1"),"utf-8"); 
				String uid=request.getParameter("uid");
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(uid);
				huiyuan.setUserName(userName);
				huiyuanService.updateObj(huiyuan);
				ResponseUtil.printl(response,"{\"status\":0}", "json");
			}catch(Exception e){
				e.printStackTrace();
			}
			ResponseUtil.printl(response,"{\"status\":1}", "json");
	 }
	 
	 
	 	/*
		 * 获取会员基本信息
		 */
	 @RequestMapping("/gethData")
	 public void gethData(HttpServletRequest request,HttpServletResponse response){
			try {
				String uid=request.getParameter("uid");
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(uid);
				String json="{\"status\":0,\"data\":[";
				json+="{\"jf\":\""+huiyuan.getJf()+"\",\"username\":\""+huiyuan.getUserName()+"\",\"imgtx\":\"http://www.c-1-tech.com/Dress/upload/"+huiyuan.getTxImage()+"\"}";
				json+="]}";
				ResponseUtil.printl(response, json, "json");
			}catch(Exception e){
				e.printStackTrace();
			}
			ResponseUtil.printl(response,"{\"status\":1}", "json");
	 }
	 
}