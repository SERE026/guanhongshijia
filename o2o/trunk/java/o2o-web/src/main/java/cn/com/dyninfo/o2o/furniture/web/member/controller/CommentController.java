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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.CommentInfo;
import cn.com.dyninfo.o2o.old.service.CommentSayService;
import cn.com.dyninfo.o2o.old.service.CommentService;

/**
 * 评论
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/comment")
public class CommentController{

	       @Resource
	       private CommentService commentService;
	       
	       @Resource
	       private CommentSayService commentSayService;
	       
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
				UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
			    String name=request.getParameter("name");
			    String userName=request.getParameter("userName");
			    //评论人
			    if(name!=null&&!name.equals("")){
			    	where.append(" and n.info.userName like '%").append(name).append("%'");
			    }
			    //商铺
			    if(userName!=null&&!userName.equals("")){
			    	where.append(" and n.ginfo.name like '%").append(userName).append("%'");
			    }
			    if(info.getIs_user().equals("1")){
			    	where.append(" and n.sinfo.name like '%").append(info.getShanfJiaInfo().getName()).append("%'");
			    }
			    where.append(" and n.status ='0'");
			    where.append(" order by indexs ");
			    mav.addAllObjects(commentService.getListByPageWhere(where, page));
				mav.addObject("name",name);
				mav.addObject("userName",userName);
				mav.addObject("PAGE_INFO", page);
				mav.setViewName("/huiyuan/comment/list");
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
			CommentInfo info=(CommentInfo) commentService.getObjById(id);
			   if(info!=null){
			   info.setStatus("1");
			   commentService.updateObj(info);
			   }
			return new ModelAndView("redirect:/html/manage/comment/list");
		}
		
		@RequestMapping(value="/{id}/{sayid}/delsay")
		public ModelAndView delsay(@PathVariable String id,@PathVariable String sayid, HttpServletRequest request,HttpServletResponse response){
			commentSayService.delObjById(sayid);
			return new ModelAndView("redirect:/html/manage/comment/"+id+"/disUpdate");
		}
			
			/***
			 * 删除列表
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
							CommentInfo info=(CommentInfo) commentService.getObjById(id);
						    if(info!=null){
						    info.setStatus("1");
						    commentService.updateObj(info);
						    }
						}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				return new ModelAndView("redirect:/html/manage/comment/list");
			}
			
			   @RequestMapping("/indexs")
		       public ModelAndView indexs(HttpServletRequest request){
				 ModelAndView mav=new ModelAndView();
				 String id[]=request.getParameterValues("id");
				 String count[]=request.getParameterValues("count");
				 if(id!=null){
					 for(int i=0;i<id.length;i++){
						 	CommentInfo info= (CommentInfo) commentService.getObjById(id[i]);
							info.setIndexs(count[i]);
						 	commentService.updateObj(info);
					 }
				 }
				 mav.setViewName("redirect:/html/manage/comment/list");
				 return mav;
			 }
			
			 @RequestMapping("/{id}/disUpdate")
			 public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
				 ModelAndView mav=new ModelAndView();
				 mav.addObject("info",commentService.getObjById(id));
				 mav.setViewName("/huiyuan/comment/update");
				 return mav;
			 }
			 
			 @RequestMapping("/update")
			 public ModelAndView update(HttpServletRequest request){
				     ModelAndView mav=new ModelAndView();
				     String id=request.getParameter("comment_id");
				     CommentInfo info=(CommentInfo) commentService.getObjById(id);
				     UserInfo info2=(UserInfo) request.getSession().getAttribute("UserInfo");
				     String replyContent=request.getParameter("replyContent");
				     if(info2!=null){
				    	 info.setUinfo(info2);
				     }
				     info.setReplyContent(replyContent);
				     commentService.updateObj(info);
				     mav.setViewName("redirect:/html/manage/comment/list");
				     return mav;
			 }
}
