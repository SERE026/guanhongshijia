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

package cn.com.dyninfo.o2o.furniture.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class OutXml {
	
	PrintWriter out;
	StringBuffer context=new StringBuffer("<list>");
	
	public  OutXml(HttpServletResponse response){
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	}
	
	public void addContext(String context){
		this.context.append(context);
	}
	public void send(){
		context.append("</list>");
		out.write(context.toString());
		out.flush();
		out.close();
	}
	
	
}
