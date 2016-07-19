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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.AddressMemberService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.service.LoginfoService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.MessageSend;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;
/*
 * 会员中心的消息
 * @lxf
 */
@Component("message")
public class Message extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;
	 @Resource
	 private AddressMemberService addressMemberService;
	 @Resource
		private LoginfoService loginfoService;
	 
		@Resource
		private MessageSendService messageSendService;
		
	@Override
	public void execute(Map pamtr) {
		PageInfo page=new PageInfo();
		String messageid=(String) pamtr.get("messageid");
		String action=(String) pamtr.get("action");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(action==null){
			this.putData("huiyuan",huiyuan);
		}else if(action.equals("getData")){
			String tag=(String) pamtr.get("tag");
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			if(tag.equals("xpgg")){
				Map map=messageSendService.getListByPageWhere(new StringBuffer(" and n.uid not like '%"+huiyuan.getHuiYuan_id()+"%'"), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("Message2.html");
			}else{
				List list=messageSendService.getmessage(huiyuan.getHuiYuan_id()+"",page);
				this.putData("data",list);
				this.setPageName("Message1.html");
			}
		}else if(action.equals("getTotale")){
			page.setPageNo(1);
			page.setPageSize(10);
			int count=messageSendService.getmesBySlqCount(huiyuan.getHuiYuan_id()+"");
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
		if(messageid!=null){
			MessageSend info=(MessageSend) messageSendService.getObjById(messageid);
			info.setUid(info.getUid()+","+huiyuan.getHuiYuan_id());
			messageSendService.updateObj(info);
		}
	
	
	}
}
	