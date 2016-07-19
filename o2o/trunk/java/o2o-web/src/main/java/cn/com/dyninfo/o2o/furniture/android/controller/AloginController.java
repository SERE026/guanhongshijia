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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.SendDx;
import cn.com.dyninfo.o2o.furniture.util.UserNoCheck;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.SMSLog;
import cn.com.dyninfo.o2o.furniture.web.setting.service.SMSLogService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * android 会员登录
 * @author feng
 *
 */
@Controller
@RequestMapping("/huiyuanlog")
public class AloginController{
    
	 @Resource
	 private HuiyuanService huiyuanService;
	 
	@Resource
	private ShangJiaService shangJiaService;
	
	@Resource
	private SMSLogService smsLogService;
	
	 
	 @RequestMapping("/login")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		String un= request.getParameter("name");
		String up= request.getParameter("psw");
		 StringBuffer where=new StringBuffer();
			if(UserNoCheck.isPhone(un)){
				where.append(" and n.phone='").append(un).append("'");
			}else if(UserNoCheck.isEmail(un)){
				where.append(" and n.email='").append(un).append("'");
			}else{
				where.append(" and n.name='").append(un).append("'");
			}
			where.append(" and n.status = '0' ");
			up=MD5Encoder.encodePassword(up,Context.PASSWORDY);
			where.append(" and n.password='"+up+"' ");
			List list=huiyuanService.getListByWhere(where);
			if(list.size()>0){
				HuiyuanInfo huiyuan=(HuiyuanInfo) list.get(0);
				huiyuan.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				huiyuan.setCount(huiyuan.getCount()+1);
				huiyuanService.updateObj(huiyuan);
				String name=huiyuan.getUserName();
				if(name==null||name.equals("")){
					name=huiyuan.getNickname();
				}
				if(name==null||name.equals("")){
					name=huiyuan.getName();
				}
				request.getSession().setAttribute(Context.SESSION_MEMBER,list.get(0));
				String json="{\"accout\":\""+huiyuan.getName()+"\",\"uid\":\""+huiyuan.getHuiYuan_id()+"\",\"name\":\""
				+name+"\",\"txImage\":\"http://www.c-1-tech.com/Dress/upload/"+huiyuan.getTxImage()
				+"\",\"jf\":"+huiyuan.getJf()+"}";
				String newJson="{\"status\":0,\"data\":"+json+"}";
				ResponseUtil.printl(response, newJson, "json");
			}else{
				ResponseUtil.printl(response, "{\"status\":1}", "json");
			}
	 }
	 
	 /**
	  * 手机号验证码发送
	  * @param request
	  * @param response
	  * @param phone
	  */
	 @RequestMapping("/validPhone")
	 public void validPhone(HttpServletRequest request,HttpServletResponse response,
			 String phone){
		 try{
			 //验证手机号是否已注册
			 StringBuffer where=new StringBuffer();
			 where.append(" and n.phone='" + phone + "' and n.phonestate='1' ");
			 List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
			 // 大于0，表示手机号已存在
			 if(huiyuan.size() > 0){
				 ResponseUtil.printl(response, "{\"status\":1}", "json"); 
			 }else{
				 Map pamtr = new HashMap();
				 pamtr.put("phone", phone);
				 if (sendCode(pamtr)) {
					 ResponseUtil.printl(response, "{\"status\":0}", "json");
				 } else {
					 ResponseUtil.printl(response, "{\"status\":-1}", "json");
				 }
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 ResponseUtil.printl(response, "{\"status\":-1}", "json");
		 }
	 }
	 
	 /**
	  * 验证码是否正确判断
	  * @param phone
	  * @param code
	  * @return
	  */
	 public boolean validphoneCode(String phone, String code){
		// 判断验证码是否超时
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer where = new StringBuffer();
		long l = new Date().getTime() - 3*60*1000;//当前时间-3分钟
		String time3Ago = sdf.format(new Date(l));
		String timeNow = sdf.format(new Date());
		//System.out.println("3分钟前的时间是：" + time3Ago);  
		where.append(" and n.phone='" + phone + "'");
		where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
		where.append(" order n.time desc ");
		//System.out.println("查询语句：" + where);
		List logList = smsLogService.getListByWhere(where);
		// 如果未超时，允许验证
		if (logList.size() == 0) {
			return false;
		}else{// 判断验证码是否正确
			SMSLog log = (SMSLog)logList.get(0);
			if(code.length() == 6 && log.getPs().contains(code)){
				return true;
			}else{
				return false;
			}
		}
	 }
	 
	 
	 /**
	  * 注册
	  * @param request
	  * @param response
	  */
	 @RequestMapping("/reg")
	 public void reg(HttpServletRequest request,HttpServletResponse response){
			String un= request.getParameter("name");
			String up= request.getParameter("psw");
			String affiliation= request.getParameter("gsm");
			String phone= request.getParameter("phone");
			String code = request.getParameter("code");
			List listphone=	huiyuanService.getListByWhere(new StringBuffer(" and n.phone='"+phone+"'"));
			List listname =	huiyuanService.getListByWhere(new StringBuffer(" and n.name='"+un+"'"));
			if(listphone.size()!=0){
				ResponseUtil.printl(response, "{\"status\":1}", "json");//手机存在
				return;
			}
			if(listname.size()!=0){
				ResponseUtil.printl(response, "{\"status\":2}", "json");//帐户名已存在
				return;
			}
			//
			if(!validphoneCode(phone, code)){
				ResponseUtil.printl(response, "{\"status\":3}", "json");//短信验证码错误
				return;
			}
			//
			try{
				HuiyuanInfo newinfo=new HuiyuanInfo();
				newinfo.setPassword(MD5Encoder.encodePassword(up,
						Context.PASSWORDY));
				newinfo.setName(un);
				newinfo.setPhone(phone); // 设置注册的手机号码
				newinfo.setPhonestate("1"); // 设置为手机验证通过
				newinfo.setUserName("");
				newinfo.setLoginData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				newinfo.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				newinfo.setCount(1);
				newinfo.setUserName(un);
				newinfo.setNickname(un);
				if(affiliation!=null&&!affiliation.equals("")){
					List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(" and n.affiliation='"+affiliation+"'"));
					if(list.size()>0){
						newinfo.setShangJiaInfo(list.get(0));
					}
				}
				huiyuanService.addObj(newinfo);
				ResponseUtil.printl(response, "{\"status\":0}", "json");//注册成功
			}catch(Exception e){
				e.printStackTrace();
				ResponseUtil.printl(response, "{\"status\":-1}", "json");//注册成功
			}
	 }
	 
	 /**
		 * 发送手机注册验证码
		 */
		public boolean sendCode(Map pamtr) {
			String phone = (String)pamtr.get("phone");
			// 首先检查该号码在3分钟内是否发送过
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuffer where = new StringBuffer();
			long l = new Date().getTime() - 3*60*1000;//当前时间-3分钟
			String time3Ago = sdf.format(new Date(l));
			String timeNow = sdf.format(new Date());
			System.out.println("3分钟前的时间是：" + time3Ago);  
			where.append(" and n.phone='" + phone + "'");
			where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
			System.out.println("查询语句：" + where);
			List logList = smsLogService.getListByWhere(where);
			if (logList.size() > 0) {
				System.out.println(phone + "该号码3分钟内已经发送过验证码！");
				return false;
			} else {
				System.out.println(phone + "可以发送验证码！");
			}

			// 生成验证码并发送短信
			String regCode = String.valueOf(new Random().nextInt(999999));
			System.out.println("验证码是："+regCode);
			int success = -1;
			try {
				success = SendDx.sendSMS(phone,"您正在进行【炫品妆成】手机验证，验证码是" + regCode + "，若非本人操作，请忽略【炫品妆成】","");
			} catch (Exception e) {
				System.out.println("短信发送失败！");
				e.printStackTrace();
			}

			// 判断是否发送成功，并写入日志记录
			if (success == 0 || success == 1) {
				where = new StringBuffer();
				where.append(" and n.phone='" + phone + "' order by n.time");
				List list = smsLogService.getListByWhere(where);
				if (list.size() > 0) {
					SMSLog sms = (SMSLog)list.get(0);
					sms.setPhone(phone);
					sms.setType(0);
					sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					sms.setPs(phone + "请求手机验证，验证码是" + regCode);
					smsLogService.updateObj(sms);
				} else {
					//System.out.println("写入新纪录==================");
					SMSLog sms = new SMSLog();
					sms.setPhone(phone);
					sms.setType(0);
					sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					sms.setPs(phone + "请求手机验证，验证码是" + regCode);
					smsLogService.addObj(sms);
				}
				return true;
			}
			return false;
		}
}
