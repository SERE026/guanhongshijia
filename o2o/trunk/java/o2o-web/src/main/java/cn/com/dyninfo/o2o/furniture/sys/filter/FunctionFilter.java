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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.sys.filter;

import java.io.IOException;
import java.util.List;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.dyninfo.o2o.old.model.ResInfo;
import cn.com.dyninfo.o2o.old.model.RoleInfo;
import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.service.ResService;
import cn.com.dyninfo.o2o.old.service.UserService;

/**
 * 功能过滤器
 * @author 王敏
 *
 */

public class FunctionFilter  implements Filter{

	//@Resource
	//private ResService resService;
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res=(HttpServletResponse) response;
			BeanFactory beans = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
			UserService userService= (UserService)beans.getBean("userService");
			ResService resService=(ResService)beans.getBean("resService");
			String url=req.getRequestURL().toString();
			if(url.indexOf("frame")<0&&url.indexOf("selection")<0
					&&url.indexOf("tree")<0&&url.indexOf("/html/manage/main")<0
					&&url.indexOf("j_spring_security_check")<0
			){
				UserInfo user=(UserInfo) req.getSession().getAttribute("UserInfo");
				String rolestr="";
				user=(UserInfo) userService.getObjById(user.getLogin_id());
				for(RoleInfo role:user.getRoles())
					rolestr+=" '"+role.getId()+"',";
				url=url.substring(url.indexOf("/manage")+8,url.length());
				if(url.indexOf("?")>0)
					url=url.substring(0,url.indexOf("?"));
				if(url.indexOf("getOgnzList")<0&&url.indexOf("areaselect")<0&&url.indexOf("getRoleList")<0&&
						url.indexOf("left")<0&&url.indexOf("userStat")<0&&
						url.indexOf("changePW")<0&&url.indexOf("selection")<0&&
						url.indexOf("/")>-1&&!url.equals("")&&url.indexOf("search")<0&&
						url.indexOf("josn")<0&&url.indexOf("status")<0&&url.indexOf("/")>0){
					String menu=url.substring(0, url.indexOf("/"));
					List<ResInfo> list = (List<ResInfo>)resService.getListByWhere(
							new StringBuffer(" and resInfo.url like '").append(menu).append("%' "));
					if(list.size() > 0){//判断该资源是否在资源管理中
						list= resService.getListByRoles(rolestr.substring(0,rolestr.length()-1),
						" and d.url like '"+menu+"%' and resInfo.IS_MENU='0' ");//查询该角色拥有的操作资源
						
						if(list.size()>0){//判断该用户是否拥有操作权限
							boolean flag = false;//getResList selection
							if(url.indexOf("xml") > 0||url.indexOf("selection")>0||url.indexOf("getResList")>0){
								flag = true;
							}else{
								for(ResInfo fun:list){
									if(url.indexOf(fun.getModule_name()) >= 0){
										flag = true;
										break;
									}
								}
							}
							
							if(flag){
								chain.doFilter(request, response);
							}else{
								res.sendRedirect(req.getContextPath()+"/403.jsp");
							}
						}else
							res.sendRedirect(req.getContextPath()+"/403.jsp");
					}else{
						chain.doFilter(request, response);
					}
				}else
					chain.doFilter(request, response);
			}else
				chain.doFilter(request, response);

	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
