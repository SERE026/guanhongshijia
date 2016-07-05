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

package cn.com.dyninfo.o2o.furniture.sys.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.furniture.util.SystemConfig;

public class ErrorMsg {
	
	public static void sendMsg(Exception e,HttpServletRequest request){
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
		ErrorMsg.sendMsg("serverName:"+request.getServerName()+"\r\nprojectName:"+request.getContextPath()+"\r\n"+request.getServletPath(), e.getMessage(),stringWriter.getBuffer().toString() );
		
	}
	
	public static void sendMsg(String projectName,String message,String address){
//		  System.out.println("错误sendMsg1");
		try{
			Properties  props=new Properties ();
			props.setProperty("mail.transport.protocol", SystemConfig.getInfo("mail.transport.protocol"));    
	        props.setProperty("mail.host", SystemConfig.getInfo("mail.host"));  
			 //建立会话
	        Session session = Session.getInstance(props);
	        Message msg = new MimeMessage(session); //建立信息
	        msg.setFrom(new InternetAddress(SystemConfig.getInfo("email.sendaddress")));//发件人
	        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(SystemConfig.getInfo("Error.email"))); //收件人
	        msg.setSentDate(new Date()); // 发送日期
	        msg.setSubject(SystemConfig.getInfo("applicationName")); // 主题
	        msg.setContent(projectName+"</br>"+message+"</br>"+address, "text/html;charset=utf-8");//内容
	        Transport tran = session.getTransport(SystemConfig.getInfo("mail.transport.protocol"));
	        tran.connect(SystemConfig.getInfo("mail.smtp.host"), SystemConfig.getInfo("email.name"), SystemConfig.getInfo("email.password"));
	        tran.sendMessage(msg, msg.getAllRecipients()); // 发送
//	        System.out.println("错误sendMsg2");
		}catch(Exception e){
			System.out.println("上报错误邮件发送失败！");
			e.printStackTrace();
		}
	}
}
