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

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.error.ErrorMsg;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class Widget implements IWidget {

	public String json="{\"status\":0}";
	public String errorJson="{\"status\":1}";
	public HttpServletRequest HttpRequest;
	public HttpServletResponse HttpResponse;
	private HashMap<String,Object> result;//挂件中的
	private String pageName;
	private String pageFolder;
	private String context;
	private String pathPrefix="";//模板路径
	private String title;
	
	/**
	 * 设置页面标题
	 * @param title
	 */
	public void setTitle(String title){
		this.title=title;
	}
	
	/**
	 * 获取页面标题
	 * @return
	 */
	public String getTitle(){
		return this.title;
	}
	
	private boolean isFreeMaker=true;
	
	/**
	 * 是否使用freeMaker 解析
	 * @param is
	 */
	public void setFreeMaker(boolean is){
		isFreeMaker=is;
	}
	
	public void putData(String key,Object value){
		this.result.put(key, value);
	}
	public void setPageName(String pageName){
		this.pageName=pageName;
	}
	public void setPageFolder(String pageFolder){
		this.pageFolder=pageFolder;
	}
	public String parseWidget(HttpServletRequest request,
			HttpServletResponse response,Map pamtr) {
		pageFolder=null;
		pathPrefix="";
		isFreeMaker=true;
		pageName=this.getClass().getSimpleName()+".html";
		HttpRequest=request;
		HttpResponse=response;
		result=new HashMap<String,Object>();
		result.putAll(Context.freeMakerData);
		
		
		if(pamtr.get("custom_page")!=null)
			pageName=(String) pamtr.get("custom_page");
		if(pamtr.get("folder")!=null)
			pageFolder=(String) pamtr.get("folder");
		try {
			
			display(pamtr);
			
			if(pageFolder==null) {//默认使用挂件所在文件夹
				Context.freeMakercfg.setClassForTemplateLoading(this.getClass(), pathPrefix);
				}
			else{
				Context.freeMakercfg.setServletContextForTemplateLoading(Context.context, pageFolder);
			}
			if(isFreeMaker){
				Template t=Context.freeMakercfg.getTemplate(pageName);
				StringWriter writer=new StringWriter();
				t.process(result, writer);
				context=writer.getBuffer().toString();
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
			ErrorMsg.sendMsg(e, request);
		}
		
		return context;
	}
	


}
