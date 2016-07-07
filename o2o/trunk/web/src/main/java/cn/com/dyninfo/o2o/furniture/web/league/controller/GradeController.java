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

package cn.com.dyninfo.o2o.furniture.web.league.controller;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.admin.model.AgentGrade;
import cn.com.dyninfo.o2o.furniture.admin.service.AgentGradeService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Dlytype;
import cn.com.dyninfo.o2o.furniture.web.wuliu.model.Psarea;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.PsareaService;
import cn.com.dyninfo.o2o.furniture.web.wuliu.service.WlcompanyService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * 配送方式 
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/grade")
public class GradeController extends BaseController{

	   @Resource
	   private AgentGradeService agentGradeService;

	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService= agentGradeService;
			 this.business="shangjia";
			 this.table="grade";
		 }
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 String psfsmc=request.getParameter("psfsmc");
	    	 if(psfsmc!=""&&psfsmc!=null){
	    		 where.append("and ag.name like'%").append(psfsmc).append("%'");
	    	 }
	    	 ModelAndView mva= super.list(request, where);
	    	 mva.addObject("psfsmc", psfsmc);
	           return mva;
	     }
//
//	     /**
//	 	 * 添加跳转
//	 	 * @param request
//	 	 * @return
//	 	 */
//	 	@RequestMapping(value="/toAdd")
//	 	public ModelAndView toAdd(HttpServletRequest request){
//	 		ModelAndView mav=new ModelAndView();
//	 		mav.setViewName("/shangjia/grade/add");
//	 		return mav;
//	 	}
//
	     /**
			 * 添加
			 *
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,AgentGrade info){
	    	    ModelAndView mav=new ModelAndView();
	    	    agentGradeService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/grade/list");
	    		return mav;
	      }

	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,AgentGrade info){
			  ModelAndView mav=new ModelAndView();
	    	    agentGradeService.updateObj(info);
	    		mav.setViewName("redirect:/html/manage/grade/list");
				return mav;
		  }
//
//			/**
//			 * 删除
//			 * @param id
//			 * @param request
//			 * @return
//			 */
//			@RequestMapping(value="/{id}/todel")
//			public ModelAndView todel(@PathVariable String id,HttpServletRequest request){
//				ModelAndView mav=new ModelAndView();
//				agentGradeService.delObjById(id);
//				mav.setViewName("redirect:/html/manage/grade/list");
//				return mav;
//			}
}
