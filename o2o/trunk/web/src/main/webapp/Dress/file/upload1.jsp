<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.InputStream" %>

<%@ page import="java.io.File" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="cn.com.dyninfo.o2o.furniture.util.SystemConfig" %>





<%--
  ~ Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~ All rights reserved.
  ~
  ~ This file contains valuable properties of  SHENZHEN Eternal Dynasty
  ~ Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
  ~ confidential information, ideas and expressions.    No part of this
  ~ file may be reproduced or distributed in any form or by  any  means,
  ~ or stored in a data base or a retrieval system,  without  the prior
  ~ written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~
  --%>

<%
String url=request.getSession().getServletContext().getRealPath("/upload");//
InputStream in= request.getInputStream();
int e=request.getContentLength();
int s=0;
int z=0;
String context="";
byte b[]=new byte[e];
while(z>-1){
	z=in.read(b,s,e);
	s+=z;
}
context+=new String (b,"iso-8859-1");
String fileName="";
if(context.lastIndexOf("\r\n\r\n")>0){
	fileName=context.substring(context.lastIndexOf("\r\n\r\n")+4);
	context=context.substring(0,context.lastIndexOf("\r\n\r\n"));
	b=context.getBytes("iso-8859-1");
	try{
		File file=new File(url+"/"+fileName);
		FileOutputStream fileout=new FileOutputStream(file);
		fileout.write(b);
		fileout.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
%>
