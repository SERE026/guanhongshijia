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

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * 会员账户
 * @author Zebe
 *
 */

@Component("account")
public class Account extends AbstractMemberWidget{
	@Resource
	private HuiyuanService huiyuanService;
	
	@Resource
	private HuiyuanMoneyService huiyuanMoneyService;
	
	@Resource
	private ZffsService zffsService;
	
	@Override
	public void execute(Map pamtr) {
		
		// 取会员信息和参数
		PageInfo page=new PageInfo();
		String action=(String) pamtr.get("action");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		// 如果未登录则跳转到登录页面
		if(huiyuan==null){
//			System.out.println("未登录，跳转到登录！");
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
			return;
		} else {
			huiyuan=(HuiyuanInfo) huiyuanService.getObjById(""+huiyuan.getHuiYuan_id());
			this.putData("huiyuan",huiyuan);
		}
		
		// 取操作（action为空时默认显示第1页数据）
		if(action==null){
			page.setPageNo(1);
			page.setPageSize(10);
			Map map=huiyuanMoneyService.getListByPageWhere(new StringBuffer(" and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"' order by n.date desc"), page);
			this.putData("liushui", map.get("DATA"));
			// 读取所有支付方式
			List zflist=zffsService.getListByWhere(new StringBuffer(" and n.status=0"));
//			System.out.println("共有 " + zflist.size() + "种支付方式");
			this.putData("zflist", zflist);
			this.setPageName("Account.html");
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=huiyuanMoneyService.getListByPageWhere(new StringBuffer(" and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"' order by n.date desc"), page);
			this.putData("liushui", map.get("DATA"));
			this.putData("liushui2", 22222);
			this.setPageName("Account2.html");
		}else if(action.equals("getTotale")){
			int count=0;
			StringBuffer where=new StringBuffer("  and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"'  order by n.date desc");
			count=huiyuanMoneyService.getCountByWhere(where);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
	}
}
