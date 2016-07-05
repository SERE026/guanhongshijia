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

package cn.com.dyninfo.o2o.furniture.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/url")
public class UrlController extends BaseController{

	      @RequestMapping("/list")
	      public ModelAndView list(@PathVariable String url,HttpServletRequest request){
	    	  ModelAndView mav=new ModelAndView();
	    	  int count=url.indexOf("html");
	    	  url=url.substring(17, url.length());
	    	  HttpSession session=request.getSession();
	    	  session.setAttribute("url",url);
	    	  mav.setViewName("redirect:/web/jsp/login.jsp");
	    	  return mav;
	      }
}
