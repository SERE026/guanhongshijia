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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.setting.model.MessageSend;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;

/**
 * android 消息推送
 * @author feng
 *
 */
@Controller
@RequestMapping("/amessage")
public class AmessageController{
    

	  
		@Resource
		private MessageSendService messageSendService;
		
	 @RequestMapping("/getxpgg")
	 public void getxpgg(HttpServletRequest request,HttpServletResponse response){
		String pageno=request.getParameter("pageno");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(pageno));
		page.setPageSize(10);
		String uid = request.getParameter("uid");
		Map map=messageSendService.getListByPageWhere(new StringBuffer(" and n.uid not like '%"+uid+"%'"), page);
		List list=(List) map.get("DATA");
		if(list.size()>0){
			String json=ResponseUtil.getJson(list).toString();
			String newJson="{\"status\":0,\"data\":"+json+"}";
			ResponseUtil.printl(response, newJson, "json");
		}else{
		 ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
	 }
	 
		
	 @RequestMapping("/getdzcx")
	 public void getdzcx(HttpServletRequest request,HttpServletResponse response){
		String pageno=request.getParameter("pageno");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(pageno));
		page.setPageSize(10);
		String uid = request.getParameter("uid");
		List list=messageSendService.getmessage(uid,page);
		if(list.size()>0){
			String json=ResponseUtil.getJsonListMap(list).toString();
			String newJson="{\"status\":0,\"data\":"+json+"}";
			ResponseUtil.printl(response, newJson, "json");
		}else{
		 ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
	 }
	 
	 
		
	 @RequestMapping("/del")
	 public void del(HttpServletRequest request,HttpServletResponse response){
		 try{
			String uid = request.getParameter("uid");
			String messagesend_id = request.getParameter("messagesend_id");
			MessageSend info=(MessageSend) messageSendService.getObjById(messagesend_id);
			info.setUid(info.getUid()+","+uid);
			messageSendService.updateObj(info);
			ResponseUtil.printl(response, "{\"status\":0}", "json");
		 }catch(Exception e){
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
		
	 @RequestMapping("/send")
	 public void send(HttpServletRequest request,HttpServletResponse response){
		String data = request.getParameter("data");
		String id = request.getParameter("id");//结束id
		List list=messageSendService.getListByWhere(new StringBuffer(" and n.sys_time> '"+data+"'" +
				" and messagesend_id>"+id+" order by messagesend_id desc"));
		if(list!=null&&list.size()>0){
			String json=ResponseUtil.getJson(list).toString();
			String newJson="{\"status\":0,\"data\":"+json+"}";
			ResponseUtil.printl(response, newJson, "json");
		}else{
		 ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
	 }
}