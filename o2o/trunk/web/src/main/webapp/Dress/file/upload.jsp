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
<%@ page import="cn.com.dyninfo.o2o.furniture.admin.model.AttachmentInfo" %>
<%@ page import="cn.com.dyninfo.o2o.furniture.admin.service.AttachmentService" %>


<%@ page import="java.io.OutputStream" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="javax.imageio.ImageReader" %>
<%@ page import="javax.imageio.stream.ImageInputStream" %>
<%@ page import="javax.imageio.IIOException" %>
<%@ page import="cn.com.dyninfo.o2o.furniture.util.FileUtil" %>

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
String url=SystemConfig.getInfo("upload");//
DiskFileUpload fileUpload = new DiskFileUpload();
fileUpload.setSizeMax(1024*1024*Integer.parseInt(SystemConfig.getInfo("upload.file.max")));
String dir = "";
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
	String fileName=url + "/" + dir + attachmentInfo.getFileName();
	if(fileItem!=null){
		fileItem.write(new File(fileName));
	}
	if(fileName.toUpperCase().endsWith("JPG")||fileName.toUpperCase().endsWith("JPEG")){
		 // 找一个reader   
	    Iterator readers = ImageIO.getImageReadersByFormatName("JPEG");  
	    ImageReader reader = null;  
	     while (readers.hasNext()) {  
	        reader = (ImageReader) readers.next();  
	        if (reader.canReadRaster()) {  
	           break;  
	    		}  
	 		}  
	  // 设置input.   
	   ImageInputStream input = ImageIO.createImageInputStream(new File(fileName));
	    reader.setInput(input);  
	   // 创建图片.   
	   BufferedImage image;  
	    try {
	  	  image = reader.read(0); 
	  	  response.getWriter().write("OK");
	  	response.getWriter().close();
	  	  
	    }catch (Exception ex1) {
	    	response.getWriter().write("NO");
	    	response.getWriter().close();
	    }
	    input.close();
		FileUtil.setPermission(fileName);
    }
}catch(Exception e){
	e.printStackTrace();
}
%>