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

package cn.com.dyninfo.o2o.furniture.web.bbs.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.MD5Encoder;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.UserNoCheck;

import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsUserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;

@Component("bbsSendWidget")
public class BbsSendWidget extends Widget {
	
	@Resource
	private HuiyuanService huiyuanService;
	

	@Resource
	private BbsPostService bbsPostService;
	@Override
	public void display(Map pamtr) {
		HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		String action=(String) pamtr.get("action");
		if(action==null){
			if(member==null)
				this.setPageName("login.html");
			else{
				this.setPageName("send.html");
			}
		}else if(action.equals("login")){
			String u_n=(String) pamtr.get("u_n");
			String u_p=(String) pamtr.get("u_p");
			StringBuffer where=new StringBuffer();
			if(UserNoCheck.isPhone(u_n)){
				where.append(" and n.phone='").append(u_n).append("'");
			}else if(UserNoCheck.isEmail(u_n)){
				where.append(" and n.email='").append(u_n).append("'");
			}else{
				where.append(" and n.name='").append(u_n).append("'");
			}
			
			u_p=MD5Encoder.encodePassword(u_p,Context.PASSWORDY);
			where.append(" and n.password='"+u_p+"' ");
			
			List list=huiyuanService.getListByWhere(where);
			this.setFreeMaker(false);
			if(list.size()>0){
				HuiyuanInfo huiyuan=(HuiyuanInfo) list.get(0);
				huiyuan.setEnterData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				huiyuan.setCount(huiyuan.getCount()+1);
				huiyuanService.updateObj(huiyuan);
				HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER,list.get(0));
				ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
			}else{
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}
		}else if(action.equals("sendAdd")){
			if(member!=null){
				BbsUserInfo info=bbsPostService.getUser(""+member.getHuiYuan_id(), Context.BBS_ROLE_MEMBER);
				this.putData("info", info);
			}
			this.setPageName("sendAdd.html");
			
		}
	}

}
