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

import cn.com.dyninfo.o2o.furniture.web.member.model.CommentInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentSay;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentSayService;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;

/**
 * android 美丽宣言
 * @author feng
 *
 */
@Controller
@RequestMapping("/abbs")
public class AbbsController{
    
		@Resource
		private CommentService commentService;
		
		@Resource
	   private HuiyuanService huiyuanService;
	  
		@Resource
		private CommentSayService commentSayService;
	
		
		/*
		 * 晒单列表
		 */
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 try{
			 
			String pageno=request.getParameter("pageno");
		 	PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageno));
			page.setPageSize(10);
			List<CommentInfo> list=commentService.getListLeftByWhere(new StringBuffer(" and n.status='0' "), page);
			if(list.size()>0){
				 StringBuffer jsons=new StringBuffer("{\"status\":0,\"data\":[");
				 String json="";
				 for(int i=0;i<list.size();i++){
					 CommentInfo info=list.get(i);
					 int num=0;
					 if(info.getInfo()!=null&&info.getInfo().getComment()!=null){
						 num=info.getInfo().getComment().size();
						 json+="{\"goodsname\":\""+(info.getGinfo() == null ? "": info.getGinfo().getName())+
								 "\",\"imgUrl\":\"http://www.c-1-tech.com/Dress/upload/goods/"
								 +(info.getGinfo() == null ? "" : info.getGinfo().getDefaultImage());
						 json+="\",\"bbsid\":\""+info.getComment_id()+"\",\"huiyuanname\":\""
								 +(info.getInfo() == null ? "" : info.getInfo().getName())+"\",\"txImage\":\"http://www.c-1-tech.com/Dress/upload/"
								 +(info.getInfo() == null ? "" : info.getInfo().getTxImage())+
						 	"\",\"bbsnum\":"+num+"},";
					 }
				 }
				 if(json.length()>0&&json.charAt(json.length()-1)==','){
					   json=json.substring(0, json.length()-1);
				   }
				 jsons.append(json);
				 jsons.append("]}");
				ResponseUtil.printl(response, jsons.toString(), "json");
	  		}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
		 }catch(Exception e){
			 e.printStackTrace();
			 ResponseUtil.printl(response, "{\"status\":0}", "json");
		 }
	 }
	 
	 	/*
		 * 晒单详细
		 */
		
	 @RequestMapping("/detail")
	 public void detail(HttpServletRequest request,HttpServletResponse response){
			String bbsid=request.getParameter("bbsid");
			CommentInfo info = (CommentInfo)commentService.getObjById(bbsid);
			if(info!=null){
				 int num=0;
				 if(info.getInfo()!=null&&info.getInfo().getComment()!=null){
					 num=info.getInfo().getComment().size();
				 }
				String json = "{\"status\":0,\"data\":[{\"huiyuanname\":\""+info.getInfo().getName()+"\",\"content\":\""+info.getContent()+"\",\"txImage\":\"http://www.c-1-tech.com/Dress/upload/"+info.getInfo().getTxImage()+"\",\"bbsnum\":"+num+",\"time\":\""+info.getTime()+"\",\"imageSrc\":\""+info.getImageSrc()+"\"}]}";
				ResponseUtil.printl(response, json, "json");
			}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
	 }
	 
		/*
		 * 晒单评论
		 */
		
	 @RequestMapping("/pinglun")
	 public void pinglun(HttpServletRequest request,HttpServletResponse response){
			String bbsid=request.getParameter("bbsid");
			String pageno=request.getParameter("pageno");
		 	PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageno));
			page.setPageSize(10);
			Map map=commentSayService.getListByPageWhere(new StringBuffer(" and n.comment.comment_id="+bbsid), page);
			List<CommentSay> list=(List<CommentSay>) map.get("DATA");
			if(list.size()>0){
				 StringBuffer jsons=new StringBuffer("{\"status\":0,\"data\":[");
				 String json="";
				 for(int i=0;i<list.size();i++){
					 CommentSay info=list.get(i);
					 String txImage="";
					 if(info.getInfo()!=null){
						 txImage=info.getInfo().getTxImage();
					 }
					 json += "{\"txImage\":\""+txImage+"\",\"content\":\""+info.getContent()+"\"},";
				 }
				 if(json.length()>0&&json.charAt(json.length()-1)==','){
					   json=json.substring(0, json.length()-1);
				   }
				 jsons.append(json);
				 jsons.append("]}");
				ResponseUtil.printl(response, jsons.toString(), "json");
			}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
	 }
	 
		/*
		 * 晒单评论
		 */
		
	 @RequestMapping("/submit")
	 public void submit(HttpServletRequest request,HttpServletResponse response){
		 try {
			 	response.setContentType("text/html");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				String bbsid=request.getParameter("bbsid");
				String huiyuanid=request.getParameter("huiyuanid");
				String content=request.getParameter("content");
				
				String strContent=new String(content.getBytes("ISO-8859-1"),"utf-8"); 
				CommentInfo commet=(CommentInfo) commentService.getObjById(bbsid);
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
				CommentSay info=new CommentSay();
				info.setComment(commet);
				info.setInfo(huiyuan);
				info.setContent(strContent);
				commentSayService.addObj(info);
				ResponseUtil.printl(response, "{\"status\":0}", "json");
			} catch (Exception e) {
				e.printStackTrace();
				ResponseUtil.printl(response, "{\"status\":1}", "json");
			}
	  		
	 }
 }