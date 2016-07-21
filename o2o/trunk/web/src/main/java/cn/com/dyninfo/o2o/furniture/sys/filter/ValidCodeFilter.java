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
 * Nov 8, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.web.framework.context.LoginUser;

/** 
 * 验证码专用
 * @author jettang
 * Nov 8, 2010
 */
public class ValidCodeFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		String code = request.getParameter("j_valid");
		HttpSession session = request.getSession();
		String s_code = (String)session.getAttribute("J_CODE");
//		System.out.println(request.getHeader("Referer"));
		if(request.getHeader("Referer").contains("/html/ssologin")||
				code.equalsIgnoreCase(s_code)){
			String j_username=request.getParameter("j_username");
			if(LoginUser.checkUser(j_username))
				filterChain.doFilter(req, rep);
			else
				response.sendRedirect(request.getContextPath() + "/" + Constants.ADMIN_ADDRESS + "/index.jsp?login_error=5");
		}else{
			response.sendRedirect(request.getContextPath() + "/" + Constants.ADMIN_ADDRESS + "/index.jsp?login_error=2");
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
