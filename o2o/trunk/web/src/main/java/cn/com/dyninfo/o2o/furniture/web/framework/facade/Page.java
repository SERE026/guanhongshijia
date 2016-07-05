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
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.error.ErrorMsg;
import cn.com.dyninfo.o2o.furniture.util.CityTool;
import cn.com.dyninfo.o2o.furniture.util.CookTool;

import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.widget.WidgetXmlUtil;

import freemarker.template.Template;

import java.util.regex.Pattern;

public class Page implements IPage{
	private Map pamtr;
	private HttpServletRequest httpRequest;
	/**
	 * 解析页面
	 * @param request
	 * @param response
	 */
	public void parse(HttpServletRequest request,HttpServletResponse response){
		
		Object obj=request.getSession().getAttribute(Context.SESSION_AEAR);
		if(obj==null){
			String city=CookTool.getCookIEValue("city", request);
			if(city==null||!city.equals("ALL")){
				if(city==null||city.equals("")){
					String cityName=CityTool.getClientCityId(request);
					AreaService areaService=SpringContext.getBean("areaService");
					List list=areaService.getListByWhere(new StringBuffer(" and n.name='"+cityName+"' and n.isDefault=1 "));
					if(list.size()>0){
						request.getSession().setAttribute(Context.SESSION_AEAR, list.get(0));
					}
				}else{
					AreaService areaService=SpringContext.getBean("areaService");
					obj=areaService.getObjById(city);
					request.getSession().setAttribute(Context.SESSION_AEAR, obj);
				}
			}
		}
		
		
		Set<String> urlkeys=Context.regular.keySet();
		String pageName=request.getServletPath();
		pageName=pageName.substring(pageName.lastIndexOf("/"));
		if(pageName.indexOf("?")>0)
			pageName=pageName.substring(0,pageName.indexOf("?"));
		boolean isPage=false;
		for(String key:urlkeys){
			if(Pattern.matches(key, pageName)){
				pageName=Context.regular.get(key);
				isPage=true;
			}
		}
		if(!isPage)new Exception(); 
		
		pamtr=new HashMap();
		httpRequest=request;
		parsePamtr();
		String url=request.getServletPath();
		String filePath=Context.webPath+Context.tempPath+"/widget.xml";
		Map pageMap=WidgetXmlUtil.parsePage(filePath);//获取挂件
		Map data=new HashMap(Context.freeMakerData);
		
		Map widgetMap=(Map) pageMap.get("common");
		Set<String> keys=widgetMap.keySet();
		for(String key:keys){
			Map attrMap=(Map) widgetMap.get(key);
			String widgetType=(String) attrMap.get("widgetType");
			Widget widget=SpringContext.getBean(widgetType);
			
			attrMap.putAll(pamtr);
			String context=widget.parseWidget(request, response,attrMap);
			
			data.put("widget_"+key, context);
		}
		widgetMap=(Map) pageMap.get(pageName);
		if(widgetMap!=null){
			keys=widgetMap.keySet();
			for(String key:keys){
				Map attrMap=(Map) widgetMap.get(key);
				String widgetType=(String) attrMap.get("widgetType");
				Widget widget=SpringContext.getBean(widgetType);
				attrMap.putAll(pamtr);
				String context="";
				try{
					context=widget.parseWidget(request, response,attrMap);
				}catch(Exception e){
					ErrorMsg.sendMsg(e, request);
				}
				data.put("widget_"+key, context);
				if(widget.getTitle()!=null){
					data.put("title", widget.getTitle());
				}
			}
			
		}else{
			pageName="404.html";
		}
		try{
			Context.freeMakercfg.setServletContextForTemplateLoading(Context.context, Context.tempPath);
			Template t=Context.freeMakercfg.getTemplate(pageName);
			t.process(data, response.getWriter());
		}catch(Exception e){
			ErrorMsg.sendMsg(e, request);
			e.printStackTrace();
		}
	}
	public void parsePamtr(){
		Enumeration  el=httpRequest.getParameterNames();
		while(el.hasMoreElements()){
			String key=(String) el.nextElement();
			pamtr.put(key, httpRequest.getParameter(key).replace("'", "").replace("?", ""));
		}
	}
}
