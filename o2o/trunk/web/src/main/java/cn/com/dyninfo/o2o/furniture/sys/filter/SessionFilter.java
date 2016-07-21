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
 * @author jettang
 * Dec 22, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.sys.filter;

import cn.com.dyninfo.o2o.furniture.sys.Constants;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session时效过滤器
 * @author jettang
 * Dec 22, 2010
 */
public class SessionFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
//		System.out.println(request.getRequestURI());
		if(session.getAttribute("UserInfo") == null&&//session失效时
				!request.getRequestURI().contains("/j_spring_security_check")&&
				!request.getRequestURI().contains("/html/manage/main")){
			response.setCharacterEncoding("UTF-8");
			try{
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>");
				out.print("if(window.parent) window.parent.location='"+request.getContextPath()+"/" + Constants.ADMIN_ADDRESS + "/index.jsp?login_error=3';");//重定向到登录页面
				out.print("else window.location='"+request.getContextPath()+"/" + Constants.ADMIN_ADDRESS + "/index.jsp?login_error=3';");
				out.print("</script>");
				return;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		filterChain.doFilter(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
