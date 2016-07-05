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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.SendMail;

import cn.com.dyninfo.o2o.furniture.admin.model.PhoneCode;
import cn.com.dyninfo.o2o.furniture.admin.service.PhoneCodeService;
import cn.com.dyninfo.o2o.furniture.admin.service.SendMessageService;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsUserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
/*
 * 会员中心的个人详细资料
 * @lxf
 */
@Component("personal")
public class Personal extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;
	 
	@Resource
	private PhoneCodeService phoneCodeService;
	
	 
	@Resource
	private AreaService areaService;
	 	
	 	
	@Resource
	private BbsPostService bbsPostService;
	
	 @Resource
	 private SendMessageService sendMessageService;
	
	@Override
	public void execute(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		this.putData("huiyuan",huiyuan);
		
		if(pamtr.get("txImage")!=null){//修改头像保存
				String txImage=(String)pamtr.get("txImage");
				huiyuan.setTxImage(txImage);
				huiyuanService.updateObj(huiyuan);
				this.setPageName("register.html");
				this.putData("data","1");
				BbsUserInfo info=bbsPostService.getUser(""+huiyuan.getHuiYuan_id(), Context.BBS_ROLE_MEMBER);
				info.setImage(txImage);
				bbsPostService.updateObj(info);
		}
		
		if(pamtr.get("phoneno")!=null){//验证电话是不是唯一
			this.setPageName("register.html");
			String phoneno=(String) pamtr.get("phoneno");
			int count=huiyuanService.validate(" and PHONE='"+phoneno+"' ");
			if(count==0||(count==1&&phoneno.equals(huiyuan.getPhone()))){//唯一
				this.putData("data","0");
			}else{
				this.putData("data","1");
			}
		}
		
		if(pamtr.get("mailno")!=null){//验证Email是不是唯一
			this.setPageName("register.html");
			String mailno=(String) pamtr.get("mailno");
			int count=huiyuanService.validate(" and EMAIL='"+mailno+"' ");
			if(count==0||(count==1&&mailno.equals(huiyuan.getEmail()))){//唯一
				this.putData("data","0");
			}else{
				this.putData("data","1");
			}
		}
		if(pamtr.get("qq")!=null){//验证Email是不是唯一
			this.setPageName("register.html");
			String qq=(String) pamtr.get("qq");
			int count=huiyuanService.validate(" and QQ='"+qq+"' ");
			if(count==0||(count==1&&qq.equals(huiyuan.getQq()))){//唯一
				this.putData("data","0");
			}else{
				this.putData("data","1");
			}
		}
		
		if(pamtr.get("url")!=null){//邮箱验证成功
			huiyuan.setEmlstate("1");
			huiyuanService.updateObj(huiyuan);
		}
		
		if(pamtr.get("msgcode")!=null){//对比用户输入的验证码是否正确
			String msgcode=((String) pamtr.get("msgcode")).toLowerCase();
			String 	PHONE_CODE=((String) session.getAttribute("PHONE_CODE")).toLowerCase();
			if(msgcode.equals(PHONE_CODE)){
				huiyuan.setPhonestate("1");
				huiyuanService.updateObj(huiyuan);
			};
		}
		if(pamtr.get("phone")!=null){//短信验证
			String phone=(String) pamtr.get("phone");
			this.setPageName("register.html");
			//判断是否超过3分钟
			List list = phoneCodeService.getListByWhere(new StringBuffer(" and n.phone ='").append(phone).append("' order by n.time desc"));
			if(list != null && list.size() > 0){
		    	PhoneCode pc = (PhoneCode)list.get(0);
		    	if((System.currentTimeMillis() - pc.getTime().getTime())/1000/60 < 3){//3分钟内不得重复发送
		    		this.putData("data","0");
		    	}else{
		    			Random random = new Random();
					    String randChar = "yp9s1k5vb4NB6KH7GFDA8Ef";
					    String temp="" ;
					    for(int i=0;i<4;i++)
					    {
					       temp =temp+randChar.charAt(random.nextInt(23));
					    }
//					    System.out.println("temp========="+temp);
					    //写入日志文件
				        PhoneCode pc1 = new PhoneCode();
				        pc1.setCode(temp);
				        pc1.setPhone(phone);
				        pc1.setTime(new Date());
					    phoneCodeService.addObj(pc1);
					    this.putData("data","1");
					   
					    //将认证码存入SESSION
					    session.setAttribute("PHONE_CODE", temp);
					    sendMessageService.addData("0", "您正在进行炫品妆成手机号验证："+temp, phone, "手机号验证", "手机号验证");
		    	}
			}else{
				    Random random = new Random();
				    String randChar = "yp9s1k5vb4NB6KH7GFDA8Ef";
				    String temp="" ;
				    for(int i=0;i<4;i++)
				    {
				       temp =temp+randChar.charAt(random.nextInt(23));
				    }
//				    System.out.println("temp========="+temp);
				    //写入日志文件
			        PhoneCode pc1 = new PhoneCode();
			        pc1.setCode(temp);
			        pc1.setPhone(phone);
			        pc1.setTime(new Date());
				    phoneCodeService.addObj(pc1);
				    this.putData("data","1");
				   
				    //将认证码存入SESSION
				    session.setAttribute("PHONE_CODE", temp);
				    sendMessageService.addData("0", "您正在进行炫品妆成手机号验证："+temp, phone, "手机号验证", "手机号验证");
			  
			    }
		 }
		
		if(pamtr.get("nc")!=null){//保存修改
			String nickname=(String) pamtr.get("nc");
			String sex=(String) pamtr.get("sex");
			String phone=(String) pamtr.get("phonenumber");
			String email=(String) pamtr.get("emiladres");
			String userName=(String) pamtr.get("userName");
			String idcard=(String) pamtr.get("idcards");
			String provinceid=(String) pamtr.get("province.id");
			String cityid=(String) pamtr.get("city.id");
			String countyid=(String) pamtr.get("county.id");
			String address=(String) pamtr.get("adresszh");
			String qq=(String) pamtr.get("qq");
			
			if(!phone.equals(huiyuan.getPhone())){
				huiyuan.setPhonestate("0");//如果对电话和email地址进行了修改，把电话是否验证改为否
			}
			if(!email.equals(huiyuan.getEmail())){
				huiyuan.setEmlstate("0");
			}
			
			AreaInfo province=(AreaInfo)areaService.getObjById(provinceid);
			AreaInfo city=(AreaInfo)areaService.getObjById(cityid);
			AreaInfo county=(AreaInfo)areaService.getObjById(countyid);
			huiyuan.setProvince(province);
			huiyuan.setCity(city);
			huiyuan.setRegion(county);
			huiyuan.setNickname(nickname);
			huiyuan.setSex(sex);
			huiyuan.setPhone(phone);
			huiyuan.setQq(qq);
			huiyuan.setEmail(email);
			huiyuan.setUserName(userName);
			huiyuan.setIdcard(idcard);
			huiyuan.setAddress(address);
			huiyuanService.updateObj(huiyuan);
			this.setPageName("Personal.html");
			BbsUserInfo info=bbsPostService.getUser(""+huiyuan.getHuiYuan_id(), Context.BBS_ROLE_MEMBER);
			info.setName(userName);
			bbsPostService.updateObj(info);
		}
		if(pamtr.get("accout")!=null){
			this.setPageName("register.html");
			this.putData("data","1");
			}
		
		if(pamtr.get("eladress")!=null){
			String email=(String)pamtr.get("eladress");
//			System.out.println("------"+email);
			if(huiyuan!=null){
				UUID uuid=UUID.randomUUID();
				String url = "http://www.c-1-tech.com/Dress/emil_success.html?data=1&uuid="+uuid;
				SendMail.send("炫品妆城-邮箱验证","<div><p>尊敬的"+huiyuan.getName()+"，您好！</p><p>请点击进入这个地址进行邮箱验证，谢谢！：</p><span>"+ url + 
						"</span><p>如果上面的链接无法点击，您也可以复制链接，粘贴到您浏览器的地址栏内，然后按“回车”打开邮箱验证页面。</p>" +
						"<br><br>" +
						"<p style='color:red;'>您收到这封邮件是因为您正在进行炫品妆成邮箱验证，如果不是您本人操作，请忽略此邮件。给您带来的不便请谅解！</p></div>",email);
			}
			this.setPageName("register.html");
			this.putData("data","goemil");
			}

		}
	
	}	

