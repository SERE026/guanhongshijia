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

package cn.com.dyninfo.o2o.furniture.web.framework.facade;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.error.ErrorMsg;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;

public class WidgetPage implements IPage{

	private Map pamtr;
	private String dataType="html";
	/**
	 * 解析挂件信息
	 */
	@Override
	public void parse(HttpServletRequest request, HttpServletResponse response) {
		pamtr=new HashMap();
		parsePamtr(request);
		String widgetID=request.getParameter("widget");
		dataType=request.getParameter("dataType");
		Widget widget=SpringContext.getBean(widgetID);
		
		try {
			
			String context=widget.parseWidget(request, response, pamtr);
			if(context!=null)
				ResponseUtil.printl(response,context,dataType);
			
			/*if(context!=null){
				response.setCharacterEncoding("urf-8");
				response.setContentType("text/"+dataType);
				context=context.replace("\\", "");
				context=context.replaceAll("\r\n", "");
				PrintWriter out=response.getWriter();
//				System.out.print(context);
				out.write(context);
				out.flush();
				out.close();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			
			ErrorMsg.sendMsg(e, request);
			
		}
	}
	
	public void parsePamtr(HttpServletRequest request){
		Enumeration  el=request.getParameterNames();
		while(el.hasMoreElements()){
			String key=(String) el.nextElement();
			pamtr.put(key, request.getParameter(key).replace("'","").replace("?", ""));
		}
	}
}
