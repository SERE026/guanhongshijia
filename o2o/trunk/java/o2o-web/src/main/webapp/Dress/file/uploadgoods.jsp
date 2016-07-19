<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="cn.com.dyninfo.o2o.furniture.util.SystemConfig" %>
<%@ page import="cn.com.dyninfo.o2o.old.model.AttachmentInfo" %>
<%@ page import="cn.com.dyninfo.o2o.old.service.AttachmentService" %>


<%@ page import="java.io.OutputStream" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="javax.imageio.ImageReader" %>
<%@ page import="javax.imageio.stream.ImageInputStream" %>
<%@ page import="javax.imageio.IIOException" %>
<%@ page import="cn.com.dyninfo.o2o.furniture.util.ImageOperate" %>

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
DiskFileUpload fileUpload = new DiskFileUpload();
fileUpload.setSizeMax(1024*1024*Integer.parseInt(SystemConfig.getInfo("upload.file.max")));
String dir = "goods/";
fileUpload.setSizeThreshold(1024*1024);
fileUpload.setRepositoryPath(url);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
AttachmentService attachmentService = (AttachmentService)ac.getBean("attachmentService");
FileItem fileItem=null;
try{
	List fileItems = fileUpload.parseRequest(request);
	Iterator iterator = fileItems.iterator();
	AttachmentInfo attachmentInfo = new AttachmentInfo();
	//
	while(iterator.hasNext()) {
		FileItem item = (FileItem)iterator.next();
		if (item.isFormField()) {//字段
			//获得该字段名称
			String name = item.getFieldName();
			//获得该字段值
			String value = item.getString("UTF-8");
			//if(name.equals("upload_type")) dir = SystemConfig.getInfo("upload.dir."+value);//设置其他目录
			if(name.equals("realName")) attachmentInfo.setRealName(value);
			if(name.equals("userid")) attachmentInfo.setUserID(value);
			if(name.equals("fileName")) attachmentInfo.setFileName(value);
		}else{//文件
			long size=item.getSize();
			fileItem=item;
			attachmentInfo.setFileSize(size);
		}
	}
	//
	attachmentInfo.setUploadTime(sdf.format(new Date()));
	attachmentService.addObj(attachmentInfo);
	

	  String maxFileName="";
	  if(attachmentInfo.getFileName().lastIndexOf(".")>0){
		  maxFileName=attachmentInfo.getFileName().substring(0,attachmentInfo.getFileName().lastIndexOf("."))+"max";
		  maxFileName+=attachmentInfo.getFileName().substring(attachmentInfo.getFileName().lastIndexOf("."));
	  }
	  if(fileItem!=null){
			fileItem.write(new File(url + "/" + dir + maxFileName));
		}
	   ImageOperate io=new ImageOperate();
	   io.alterSize(url + "/" + dir + maxFileName,url + "/" + dir+attachmentInfo.getFileName(),320,320);
	   io.alterSize(url + "/" + dir+attachmentInfo.getFileName(),url + "/" + dir+"min"+attachmentInfo.getFileName(),320,320);
    
}catch(Exception e){
	e.printStackTrace();
}
%>