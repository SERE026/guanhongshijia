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

import javax.servlet.http.HttpServletRequest;


public class PageFactory {

	/**
	 * 
	 * @param uri
	 */
	public static IPage newProcessorInstance(String uri,HttpServletRequest httpRequest){
		IPage page =null;
		
		String htmlName=uri.substring(uri.lastIndexOf("/")+1);
		if(uri.indexOf("?")>0){
			htmlName=htmlName.substring(0,htmlName.indexOf("?")+1);
		}
		if(htmlName.startsWith("widget.html")){
			page=new WidgetPage();
		}else{
			page=new Page();
		}
		
		return page;
	}
}
