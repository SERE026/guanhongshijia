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

/**
 * 
 */
package cn.com.dyninfo.o2o.furniture.util;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author 王敏
 *
 */
public class SendMail {
	
	/**
	 * 
	 * @param title 主题
	 * @param context 内容
	 * @param revaddress 收件人地址
	 */
	public static int send(String title,String context,String revaddress){
		try{
			InputStream is = SendMail.class.getResourceAsStream("/base.properties");
			Properties p=new Properties();
			p.load(is);
			 //建立会话
            Session session = Session.getInstance(p);
            Message msg = new MimeMessage(session); //建立信息
            if(p.getProperty("email.sendaddress")!=null)
            	msg.setFrom(new InternetAddress(p.getProperty("email.sendaddress")));//发件人
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(revaddress)); //收件人
            msg.setSentDate(new Date()); // 发送日期
            msg.setSubject(title); // 主题
            msg.setContent(context, "text/html;charset=utf-8");//内容
            Transport tran = session.getTransport(p.getProperty("mail.transport.protocol"));
            tran.connect(p.getProperty("mail.smtp.host"), p.getProperty("email.name"), p.getProperty("email.password"));
            tran.sendMessage(msg, msg.getAllRecipients()); // 发送
            tran.close(); 
            return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 1;
		}
	}
	
}
