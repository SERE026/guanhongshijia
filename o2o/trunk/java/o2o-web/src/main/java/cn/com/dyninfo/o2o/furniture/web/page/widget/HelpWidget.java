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

package cn.com.dyninfo.o2o.furniture.web.page.widget;

import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.service.ArticlesService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

@Component("help")
public class HelpWidget extends Widget {

	@Resource
	private ArticlesService articlesService;
	@Override
	public void display(Map pamtr) {
		String helpId=getHelpId();
		Object info=articlesService.getObjById(helpId);
		this.putData("info", info);
		this.setPageName("help.html");
	}

	
	public String getHelpId(){
		String url=this.HttpRequest.getServletPath();
		url.substring(url.lastIndexOf("/"));
		if(url.indexOf("?")>0){
			url.substring(0, url.indexOf("?"));
		}
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return null;
		
	}
}
