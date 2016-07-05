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

package cn.com.dyninfo.o2o.furniture.web.framework.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.error.ErrorMsg;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.IPage;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.PageFactory;

public class PageFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("销毁页面过滤器！");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		try{
			response.setCharacterEncoding("UTF-8");
			checkClientId(httpRequest,httpResponse);
			String url=httpRequest.getServletPath();
			if(url.toLowerCase().endsWith("xml")){
				return ;
			}
			if(url.lastIndexOf("/")>1){
				chain.doFilter(request, response);
				return;
			}
			String xml=url.substring(url.lastIndexOf("/")+1);
			if(xml.indexOf("?")>0){
				xml=xml.substring(0,xml.indexOf("?"));
			}
			IPage page=PageFactory.newProcessorInstance(url,httpRequest);
			page.parse(httpRequest, httpResponse);
		}catch(Exception e){
			e.printStackTrace();
			ErrorMsg.sendMsg(e, httpRequest);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("开启页面过滤器！");
		
	}
	
	/**
	 * 获取客户ID 如果客户从未来过本网站 则在COOKIE中存入一个随机不重复的ID
	 * @param request
	 * @return
	 */
	public void checkClientId(HttpServletRequest request,HttpServletResponse reponse){
		String CookId=UUID.randomUUID().toString().replace("-", "");
		boolean isCId=true;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie ck:cookies){
				if(ck.getName().equals(Context.COOKIE_CLIENT_ID)){
					if(ck.getValue().length()!=0){
						isCId=false;
					}
				}
			}
		}
		if(isCId){
			Cookie ck=new Cookie(Context.COOKIE_CLIENT_ID,CookId);
			ck.setPath("/");
			ck.setMaxAge(365*24*60*60);
			reponse.addCookie(ck);
		}
	}

}
