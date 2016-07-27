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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.SendDx;
import cn.com.dyninfo.o2o.furniture.util.UserNoCheck;

import cn.com.dyninfo.o2o.furniture.admin.service.SendMessageService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.ShowGoodService;
import cn.com.dyninfo.o2o.furniture.web.member.model.Findpassword;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.FindpasswordService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.service.CarsService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.SMSLog;
import cn.com.dyninfo.o2o.furniture.web.setting.service.SMSLogService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 登录BAR
 * @author Zebe
 *
 */
@Component("loginBar")
public class LoginBar extends Widget{

	@Resource
	private HuiyuanService huiyuanService;
	@Resource
	private FindpasswordService findpasswordService;
	@Resource
	private CarsService carsService;
	@Resource
	private ShowGoodService showGoodService;
	@Resource
	private ShangJiaService shangJiaService;
	@Resource
	private SendMessageService sendMessageService;
	@Resource
	private SMSLogService smsLogService;

	@Override
	public void display(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
		String action=(String) pamtr.get("action");
		if(action!=null&&action.equals("merchants")){//归属码
			merchant(pamtr);
		}
		if(pamtr.get("changePassSendCode")!=null){//修改密码发送短信
			boolean b=sendPassCode(pamtr);
			ResponseUtil.printl(this.HttpResponse, "{\"status\":"+(b?"1":"0")+"}", "json");
			this.setFreeMaker(false);
			return ;
		}
		
		if(pamtr.get("changePass")!=null){//修改密码
			try {
				String phone=(String) pamtr.get("phone");
				String valide=(String) pamtr.get("valide");
				String newpwd=(String) pamtr.get("newpwd");//新的密码
				this.setFreeMaker(false);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				StringBuffer where = new StringBuffer();
				long l = new Date().getTime() - 180*1000;//当前时间3分钟
				String time3Ago = sdf.format(new Date(l));
				String timeNow = sdf.format(new Date());
//				System.out.println("3分钟前的时间是：" + time3Ago);  
				where.append(" and n.phone='" + phone + "' and n.type='1' ");
				where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
				List logList = smsLogService.getListByWhere(where);
				if (logList.size() > 0) {
					SMSLog log=(SMSLog) logList.get(0);
					if(log.getPs()!=null&&log.getPs().equals(valide)){
						List list =	huiyuanService.getListByWhere(new StringBuffer(" and n.phone='"+phone+"'"));
						if(list.size()>0){
							HuiyuanInfo info=(HuiyuanInfo) list.get(0);
							info.setPassword(MD5Encoder.encodePassword(newpwd,Context.PASSWORDY));
							huiyuanService.updateObj(info);
							ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
						}else{
							ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
						}
					}else{
						ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
					}
				}
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}catch(Exception e){
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}
		}
		
		if(pamtr.get("submittype")!=null){//登录
			login(pamtr);
		}

		if(pamtr.get("newpassword")!=null){//修改密码
			editpassword(pamtr);
		}

		if(pamtr.get("adress")!=null){//找回密码
			findpassword(pamtr);
		}

		if(pamtr.get("temp")!=null){//判断找回密码输入的邮箱是否注册有效
			emailyz(pamtr);
		}

		if(pamtr.get("exitdl")!=null){//会员退出
			session.removeAttribute(Context.SESSION_MEMBER);
			this.putData("data","1");
		}

		if(pamtr.get("id")!=null){//会员登陆后显示会员的名称
			loginin(pamtr);
		}

		if(pamtr.get("accout")!=null){//判断账户是否存在
			accoutyz(pamtr);
		}
		
		if(pamtr.get("phone")!=null){//判断手机是否存在
			phoneyz(pamtr);
		}

		if(pamtr.get("validinput")!=null){//判断验证码
			codeyz(pamtr);
		}

		if(action!=null&&action.equals("tx")){
			HuiyuanInfo info=(HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
			this.putData("info", info);
			this.setPageName("tx.html");
		}

		// 如果是发送验证码
		if(action != null && "sendCode".equalsIgnoreCase(action)){
			if (sendCode(pamtr) == true) {
				this.putData("data","1");
			} else {
				this.putData("data","0");
			}
			this.setPageName("register.html");
		}

		// 如果是核对验证码
		if(action != null && "checkCode".equalsIgnoreCase(action)){
			if (checkCode(pamtr) == true) {
				this.putData("data","1");
			} else {
				this.putData("data","0");
			}
			this.setPageName("register.html");
		}

	}

	/**
	 * 会员登录
	 * @param pamtr
	 */
	public void login(Map pamtr){
		String accoutname=(String)pamtr.get("accoutname");
		StringBuffer where=new StringBuffer();
		String data;
		if(UserNoCheck.isPhone(accoutname)){
			where.append(" and n.phone='").append(accoutname).append("'");
		}else if(UserNoCheck.isEmail(accoutname)){
			where.append(" and n.email='").append(accoutname).append("'");
		}else{
			where.append(" and n.name='").append(accoutname).append("'");
		}
		where.append(" and n.status = '0' ");
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
		if(huiyuan.size()>0){
			HuiyuanInfo info=(HuiyuanInfo) huiyuan.get(0);
			String password= (String) pamtr.get("password");
			String validts=(String) pamtr.get("validts");
			String   J_CODE =  (String) this.HttpRequest.getSession().getAttribute("J_CODE");
			J_CODE	=  J_CODE.toLowerCase();
			validts= validts.toLowerCase();
			this.setFreeMaker(false);
			if(validts.equals(J_CODE)){//验证验证码是否正确
				this.setPageName("login.html");
				if(MD5Encoder.isPasswordValid(info.getPassword(),password, Context.PASSWORDY)){//判断旧密码是否正确
					this.putData("logdata","1");
					info.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					info.setCount(info.getCount()+1);
					huiyuanService.updateObj(info);
					this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER,info);
					carsService.checkCar(this.HttpResponse, this.HttpRequest);
					showGoodService.checkShowGoods(HttpResponse, HttpRequest);
					showGoodService.checkShowGoods(HttpResponse, HttpRequest);

					ForwordTool.checkeForword(this.HttpResponse, this.HttpRequest);
					String forWord=(String) this.HttpRequest.getSession().getAttribute(Context.SESSION_FORWORD);
					if(forWord==null){
						forWord="index.html";
						ResponseUtil.printl(this.HttpResponse, "{\"status\":0,\"goUrl\":\""+forWord+"\"}", "json");
					}else{
						this.HttpRequest.removeAttribute(Context.SESSION_FORWORD);
						ResponseUtil.printl(this.HttpResponse, "{\"status\":1,\"goUrl\":\""+forWord+"\"}", "json");
					}

				}else{
					ResponseUtil.printl(this.HttpResponse, "{\"status\":2}", "json");
				}
			}else{
				ResponseUtil.printl(this.HttpResponse, "{\"status\":3}", "json");
			}
		}else{
			ResponseUtil.printl(this.HttpResponse, "{\"status\":4}", "json");
		}
	}

	/**
	 * 注册会员
	 * @param pamtr
	 */
	public void register(Map pamtr){
		try{
			this.setPageName("register.html");
			String type=(String) pamtr.get("type");
			String name=(String) pamtr.get("name");
			String phone = (String) pamtr.get("phone");
			String password=(String) pamtr.get("password");
			String code=(String) pamtr.get("validinput");
			String email = (String) pamtr.get("email");
			String   J_CODE =  (String) this.HttpRequest.getSession().getAttribute("J_CODE");
			J_CODE	=  J_CODE.toLowerCase();
			code=code.toLowerCase();
			if(code.equals(J_CODE)){
				HuiyuanInfo newinfo=new HuiyuanInfo();
				String p=(String) pamtr.get("p");
				if(p!=null){
					List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(" and n.affiliation='"+p+"'"));
					if(list.size()>0){
						newinfo.setShangJiaInfo(list.get(0));
					}
				}
				if(UserNoCheck.isPhone(name)){
					newinfo.setPhone(name);
				}else if(UserNoCheck.isEmail(name)){
					newinfo.setEmail(name);
				}
				newinfo.setName(name);
				newinfo.setEmail(email);
				newinfo.setPhone(phone); // 设置注册的手机号码
				newinfo.setPhonestate("1"); // 设置为手机验证通过
				newinfo.setUserName("");
				newinfo.setPassword(MD5Encoder.encodePassword(password,
						Context.PASSWORDY));
				newinfo.setLoginData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				newinfo.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				newinfo.setCount(1);
				newinfo.setUserName(name);
				newinfo.setNickname(name);
				huiyuanService.addObj(newinfo);
				this.putData("data","1");
				this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER,newinfo);
				carsService.checkCar(this.HttpResponse, this.HttpRequest);
				ForwordTool.checkeForword(this.HttpResponse, this.HttpRequest);
				showGoodService.checkShowGoods(HttpResponse, HttpRequest);
			}else{
				this.putData("data","2");
			}
		}catch (Exception e){
			this.putData("data",e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 密码修改
	 * @param pamtr
	 */
	public void editpassword(Map pamtr){
		String newpassword=(String) pamtr.get("newpassword");
		String uuid=(String) pamtr.get("uuid");
		List<Findpassword> Findpassword=(List<Findpassword>) findpasswordService.getListByWhere(new StringBuffer(" and n.uuid='").append(pamtr.get("uuid")).append("'"));
		Findpassword info=(Findpassword)Findpassword.get(0);
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(new StringBuffer(" and n.email='").append(info.getEmail()).append("'"));
		HuiyuanInfo huiyuan01=(HuiyuanInfo)huiyuan.get(0);
		String time=info.getFindtime();//查看发送找回密码邮件的时间，不是当天的就不能进行修改
		time=time.substring(0, 10);
		String newtime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(time.equals(newtime)&&info.getEditstat().equals("0")){
			huiyuan01.setPassword(MD5Encoder.encodePassword(newpassword,
					Context.PASSWORDY));
			info.setEditstat("1");
			huiyuanService.updateObj(huiyuan01);
			findpasswordService.updateObj(info);
			this.putData("data","1");
		}else{
			this.putData("data","0");
		}
		this.setPageName("register.html");


	}

	/**
	 * 找回密码
	 * @param pamtr
	 */
	public void findpassword(Map pamtr){
		this.setPageName("register.html");
		UUID uuid=UUID.randomUUID();
		String email= (String) pamtr.get("adress");
		Findpassword info=new Findpassword();
		info.setUuid(uuid.toString());
		info.setEmail(email);
		info.setEditstat("0");
		info.setFindtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		findpasswordService.addObj(info);
		String msg="<div><p>尊敬的观红世家用户您好！</p><p>请点击进入这个地址进行密码修改，谢谢！：</p><span>http://" + this.HttpRequest.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/modify_password.html?uuid="+uuid
		+"</span><p>如果上面的链接无法点击，您也可以复制链接，粘贴到您浏览器的地址栏内，然后按“回车”打开密码修改页面。</p></div>";
		sendMessageService.addData("1", msg, email,"","找回密码");
		this.putData("data",email);
	}

	/**
	 * 断找回密码输入的邮箱是否注册有效
	 * @param pamtr
	 */
	public void emailyz(Map pamtr){
		this.setPageName("register.html");
		String temp=(String) pamtr.get("temp");
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(
				new StringBuffer(" and n.email='").append(pamtr.get("temp")).append("'"));
		if(huiyuan != null && huiyuan.size() == 1){
			HuiyuanInfo info=(HuiyuanInfo)huiyuan.get(0);
			if(info.getEmlstate().equals("1")){
				this.putData("data","1");
			}else{
				this.putData("data","0");
			}
		}
	}

	/**
	 * 账户是否存在
	 * @param pamtr
	 */
	public void accoutyz(Map pamtr){
		String accout=(String) pamtr.get("accout");
		this.setPageName("register.html");
		StringBuffer where=new StringBuffer();
		String data;
		if(UserNoCheck.isPhone(accout)){//当为手机号注册时判断是否已被注册
			where.append(" and n.phone='").append(pamtr.get("accout")).append("'");
		}else if(UserNoCheck.isEmail(accout)){//当为邮箱注册时判断是否已被注册
			where.append(" and n.email='").append(pamtr.get("accout")).append("'");
		}else{//当为账号注册时判断是否已被注册
			where.append(" and n.name='").append(pamtr.get("accout")).append("'");
		}
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
		if(huiyuan.size()>0){
			data="0";
		}else{
			data="1";
		}
		this.putData("data",data);
//		System.out.println(data);

	}
	
	/**
	 * 手机号是否存在（已经验证过则表示已存在）
	 * @param pamtr
	 */
	public void phoneyz(Map pamtr){
		String phone = (String) pamtr.get("phone");
		this.setPageName("register.html");
		StringBuffer where=new StringBuffer();
		String data;
		where.append(" and n.phone='" + phone + "' and n.phonestate='1'");
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
		// 大于0，表示手机号已存在
		if(huiyuan.size() > 0){
			data="0";
		}else{
			data="1";
		}
		this.putData("data",data);
	}


	/**
	 * 判断验证码
	 * @param pamtr
	 */
	public void codeyz(Map pamtr){
		HttpSession session=HttpRequest.getSession();
		this.setPageName("register.html");
		String   J_CODE =  (String) session.getAttribute("J_CODE");
		J_CODE	=  J_CODE.toLowerCase();
		String v_code= ((String) pamtr.get("validinput")).toLowerCase();
		String data;
		if(J_CODE.equals(v_code)){
			data="0";
			String name=(String) pamtr.get("name");
			if(name!=null){
				register(pamtr);
			}
		}else{
			data="1";

		}
		this.putData("data",data);

	}

	/**
	 * 会员登陆后显示会员的名称
	 * @param pamtr
	 */
	public void loginin(Map pamtr){
		HttpSession session=HttpRequest.getSession();
		this.setPageName("LoginBar.html");
		HuiyuanInfo huiyuan = (HuiyuanInfo)  session.getAttribute(Context.SESSION_MEMBER);
		if(huiyuan==null){
			String forword=this.HttpRequest.getHeader("Referer");
			this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, forword);
			this.putData("cout","1");
		}else{
			this.putData("cout","2");
			this.putData("huiyuan",huiyuan);
		}
	}
	/**
	 * 归属码
	 * @param pamtr
	 */
	public void merchant(Map pamtr){
		String p=(String) pamtr.get("p");
		if(p!=null){
			List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(" and n.affiliation='"+p+"'"));
			if(list.size()>0){
				this.putData("m", list.get(0));
			}
		}
		this.setPageName("merchants.html");
	}
	
	public boolean sendPassCode(Map pamtr){
		HttpSession session=HttpRequest.getSession();
		String phone = (String)pamtr.get("phone");
		//验证手机号
		StringBuffer where=new StringBuffer();
		where.append(" and n.phone='" + phone + "' and n.phonestate='1'");
		List<HuiyuanInfo> huiyuan=(List<HuiyuanInfo>) huiyuanService.getListByWhere(where);
		// 大于0，表示手机号已存在
		if(huiyuan.size() > 0){
			
		}else{
			return false;
		}
		// 首先检查该号码在3分钟内是否发送过
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		where = new StringBuffer();
		long l = new Date().getTime() - 180*1000;//当前时间-3分钟
		String time3Ago = sdf.format(new Date(l));
		String timeNow = sdf.format(new Date());
//		System.out.println("3分钟前的时间是：" + time3Ago);  
		where.append(" and n.phone='" + phone + "' and n.type='1' ");
		where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
		List logList = smsLogService.getListByWhere(where);
		if (logList.size() > 0) {
			return false;
		} 
		// 生成验证码并发送短信
		List huiyuanlist =	huiyuanService.getListByWhere(new StringBuffer(" and n.phone='"+phone+"'"));
		if(huiyuanlist.size()>0){
			String regCode = String.valueOf(new Random().nextInt(999999));
//			System.out.println("验证码是："+regCode);
			int success = -1;
			try {
				success = SendDx.sendSMS(phone,"您正在进行【观红世家】修改密码操作，验证码是" + regCode + "，若非本人操作，请忽略【观红世家】","");
			} catch (Exception e) {
				System.out.println("短信发送失败！");
				e.printStackTrace();
			}
		
		// 判断是否发送成功，并写入日志记录
		if (success == 0 || success == 1) {
			session.setAttribute("regCode", regCode);
			where = new StringBuffer();
			where.append(" and n.phone='" + phone + "' order by n.time");
			List list = smsLogService.getListByWhere(where);
			if (list.size() > 0) {
				SMSLog sms = (SMSLog)list.get(0);
				sms.setPhone(phone);
				sms.setType(1);
				sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				sms.setPs(regCode);
				smsLogService.updateObj(sms);
			} else {
				//System.out.println("写入新纪录==================");
				SMSLog sms = new SMSLog();
				sms.setPhone(phone);
				sms.setType(1);
				sms.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				sms.setPs(regCode);
				smsLogService.addObj(sms);
			}
			return true;
			}
		}
		session.removeAttribute("regCode");
		return false;
	}

	/**
	 * 发送手机注册验证码
	 */
	public boolean sendCode(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
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
			success = SendDx.sendSMS(phone,"您正在进行【观红世家】手机验证，验证码是" + regCode + "，若非本人操作，请忽略【观红世家】","");
		} catch (Exception e) {
			System.out.println("短信发送失败！");
			e.printStackTrace();
		}

		// 判断是否发送成功，并写入日志记录
		if (success == 0 || success == 1) {
			session.setAttribute("regCode", regCode);
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
		session.removeAttribute("regCode");
		return false;
	}

	/**
	 * 验证手机注册验证码
	 */
	public boolean checkCode(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
		String phone = (String)pamtr.get("phone");
		String regCode = (String)pamtr.get("regCode");
		String realCode = (String)session.getAttribute("regCode");
		// 判断验证码是否超时
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer where = new StringBuffer();
		long l = new Date().getTime() - 3*60*1000;//当前时间-3分钟
		String time3Ago = sdf.format(new Date(l));
		String timeNow = sdf.format(new Date());
		//System.out.println("3分钟前的时间是：" + time3Ago);  
		where.append(" and n.phone='" + phone + "'");
		where.append(" and n.time>='" + time3Ago + "' and n.time<='" + timeNow + "'");
		//System.out.println("查询语句：" + where);
		List logList = smsLogService.getListByWhere(where);
		// 如果未超时，允许验证
		if (logList.size() == 0) {
			return false;
		}
		// 判断验证码是否正确
		if (regCode != null & realCode != null) {
			if (regCode.equalsIgnoreCase(realCode)) {
				return true;
			}
		}
		return false;
	}

}

