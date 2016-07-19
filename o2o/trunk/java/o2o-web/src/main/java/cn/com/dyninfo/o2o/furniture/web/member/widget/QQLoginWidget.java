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

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;
import cn.com.dyninfo.o2o.furniture.util.DownImage;
import cn.com.dyninfo.o2o.furniture.util.ForwordTool;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;

@Component("qqLogin")
public class QQLoginWidget extends Widget {

	@Resource
	private HuiyuanService huiyuanService;
	
	@Override
	public void display(Map pamtr) {
		HttpServletRequest request=this.HttpRequest;
		String access_token=request.getParameter("access_token");
		String openid=request.getParameter("openid");
		List<HuiyuanInfo>  list=(List<HuiyuanInfo>) huiyuanService.getListByWhere(new StringBuffer(" and n.qqid='"+openid+"' "));
		String sss="";
		if(list.size()==0){
			try {
				URL url=new URL("https://graph.qq.com/user/get_user_info?oauth_consumer_key=101058688&openid="+openid+"&access_token="+access_token+"");
				URLConnection  ucon=url.openConnection();
				ucon.connect();
				InputStream in= ucon.getInputStream();
				int length=ucon.getContentLength();
				byte b[]=new byte[length];
				in.read(b,0,length);
				in.close();
				
				String jsonstr=new String(b,"utf-8");
				JSONObject jsonObject = JSONObject.fromObject(jsonstr);
				HuiyuanInfo ruser=new HuiyuanInfo();
				ruser.setUserName(jsonObject.getString("nickname"));
				ruser.setQqid(openid);
				//ruser.setEmail(openid+"@qq.com");
				ruser.setName(openid);
				String filePath=jsonObject.getString("figureurl");
				String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
				String savePath="d:/status/upload/"+fileName;
				DownImage.downImage(filePath,savePath);
				ruser.setTxImage(fileName);
				ruser.setLoginData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				ruser.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				ruser.setCount(1);
				
				//huiyuanService.addObj(ruser);
				request.getSession().setAttribute(Context.SESSION_QQUSER, ruser);
				ForwordTool.goToForword(this.HttpResponse, request, "phoneCheck.html");
				return;
			} catch (Exception e) {
				e.printStackTrace();
				sss="MalformedURLException出错了";
			} 
		}else{
			HuiyuanInfo info= list.get(0);
			info.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			info.setCount(info.getCount()+1);
			huiyuanService.updateObj(info);
			request.getSession().setAttribute(Context.SESSION_MEMBER, info);
			sss+=""+info.getName();
		}
		String forWord=request.getContextPath()+"/index.html";
//		String f=(String) request.getSession(false).getAttribute(Context.SESSION_FORWORD);
//		if(f!=null){
//			forWord=f;
//			request.getSession().removeAttribute(Context.SESSION_FORWORD);
//		}
		String js="<script>window.location.href='"+forWord+"';</script>";
		this.putData("html", js);
		this.setPageName("qqLogin.html");
	}

}
