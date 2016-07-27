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

package cn.com.dyninfo.o2o.furniture.web.framework.listener;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.dyninfo.o2o.furniture.payment.yl.QuickPayConf;
import cn.com.dyninfo.o2o.furniture.payment.zfb.AlipayConfig;

import cn.com.dyninfo.o2o.furniture.admin.service.SendMessageService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.LoginUser;
import cn.com.dyninfo.o2o.furniture.web.framework.dao.PagePathDAO;
import cn.com.dyninfo.o2o.furniture.web.framework.handler.MyTemplateExceptionHandler;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.dao.ZffsDao;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Web;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.WebService;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;


public class ContextListener implements ServletContextListener {
	SendMessageService msg=null;
	OrderService orderService=null;
	HuiyuanInfo huiyuan=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try{
			System.out.println("观红世家项目启动！");
			InputStream  in=this.getClass().getResourceAsStream("/config.properties");
			Properties p=new Properties();
			p.load(in);
			Context.tempPath=p.getProperty("templates");
			Context.webPath=arg0.getServletContext().getRealPath("/");
			Context.freeMakercfg=new Configuration();
			Context.freeMakercfg.setServletContextForTemplateLoading(arg0.getServletContext(),p.getProperty("templates"));

			 
			 Context.freeMakercfg.setObjectWrapper(new DefaultObjectWrapper());
			 Context.freeMakercfg.setDefaultEncoding("UTF-8");
			 Context.freeMakercfg.setLocale(java.util.Locale.CHINA);
			 Context.freeMakercfg.setEncoding(java.util.Locale.CHINA, "UTF-8");
			 Context.freeMakercfg.setNumberFormat("#.##");
			 Context.freeMakercfg.setClassicCompatible(true);
			 Context.freeMakercfg.setTemplateExceptionHandler(new MyTemplateExceptionHandler());
			Context.freeMakercfg.setLocalizedLookup(false);
			ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
			
			ZffsDao z=(ZffsDao) ac2.getBean("zffsDao");
			List<Zffs> zfb=(List<Zffs>) z.getListByWhere(new StringBuffer(" and n.type='0' and n.status='0' "));//支付宝
			List<Zffs> wlzf=(List<Zffs>) z.getListByWhere(new StringBuffer(" and n.type='1' and n.status='0' "));//网银
			if(zfb.size()>0){
				AlipayConfig.zfbNo=zfb.get(0).getZfb_zhanghao();
				AlipayConfig.partner=zfb.get(0).getZfb_id();
				AlipayConfig.key=zfb.get(0).getZfb_code();
			}
			if(wlzf.size()>0){
				QuickPayConf.merCode=wlzf.get(0).getZfb_code();//商城代码
				QuickPayConf.merName=wlzf.get(0).getJianChen();
				QuickPayConf.securityKey=wlzf.get(0).getZfb_zhanghao();//key
			}
			PagePathDAO pagePath=(PagePathDAO) ac2.getBean("pagePathDAO");
			Map<String,String> regular=pagePath.getPath();
			Context.regular=regular;
			Context.context=arg0.getServletContext();
			Map<String,Object> data=new HashMap<String,Object>();
			WebService service=(WebService) ac2.getBean("webService");
			Web web=(Web) service.getObjById("1");
			data.put("title", web.getTitle());
			data.put("description", web.getDescription());
			data.put("keyword", web.getKeyWord());
			data.put("applicationPath", arg0.getServletContext().getContextPath());
			
			 if(web.getBgColor()!=null&&web.getBgColor().length()>0)
				 data.put("bgColor", web.getBgColor());
			 
			 if(web.getBgImage()!=null&&web.getBgImage().length()>0)
				 data.put("bgImage", web.getBgImage());
			
			Context.freeMakerData=data;
			msg=(SendMessageService) ac2.getBean("sendMessageService");
			Timer timer=new Timer();
			timer.schedule(new TimerTask(){
				@Override
				public void run() {
					try{
						LoginUser.checkTimeout();
					
						msg.sendMessage();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				
			}, 1*60*1000,1*60*1000);
			
	
			ApplicationContext ac1 = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
			orderService=(OrderService) ac1.getBean("orderService");
			Timer timer1=new Timer();
			timer1.schedule(new TimerTask(){
				@Override
				public void run() {
					try{
						List list=orderService.getorderlist(new StringBuffer(" and n.status='0' and (n.state='1' or n.state='2')"));
						for(int i=0;i<list.size();i++){
							Order order = (Order) list.get(i);
							String sendtime=order.getSendtime();
							 String 	time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
							  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								  if(sendtime!=null){ 
									long sendt = df.parse(sendtime).getTime();
									long nowt = df.parse(time).getTime();
								    long data=(nowt - sendt) / (1000 * 60 * 60 * 24);
								    if(data>=15){
								    	order.setSuretime(time);
								    	order.setState("3");
								    	orderService.updateObj(order);
								    }
								  }
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				
			},0,24*60*60*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
