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

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.DownImage;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;

/**
 * android QQ登录
 * @author feng
 *
 */
@Controller
@RequestMapping("/aqqlogin")
public class AqqloginController{
    

	@Resource
	private HuiyuanService huiyuanService;
	
		
	 @RequestMapping("/login")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 String openid=request.getParameter("openid");
			List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
					new StringBuffer(" and n.qqid='"+openid+"' "));
			String sss="";
			if(list.size()>0){
				HuiyuanInfo info= list.get(0);
				System.out.println(info.getName());
				String json=ResponseUtil.getObjeJson(info).toString();
				String newJson="{\"status\":0,\"data\":"+json+"}";
				
				ResponseUtil.printl(response, newJson, "json");
			}else{
				
				HuiyuanInfo ruser=new HuiyuanInfo();
				try {
					ruser.setUserName(new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ruser.setQqid(openid);
				//ruser.setEmail(openid+"@qq.com");
				ruser.setName(openid);
				String filePath=request.getParameter("img");
				String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
				String savePath="d:/status/upload/head/"+ruser.getName()+fileName;
				DownImage.downImage(filePath,savePath);
				ruser.setTxImage("head/"+ruser.getName()+fileName);
				ruser.setLoginData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				ruser.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				ruser.setCount(1);
				huiyuanService.addObj(ruser);
				String json=ResponseUtil.getObjeJson(ruser).toString();
				String newJson="{\"status\":0,\"data\":"+json+"}";
				ResponseUtil.printl(response, newJson, "json");
			}
	 }
 }