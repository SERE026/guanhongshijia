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

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanMoneyService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;

/**
 * 会员账户
 * @author Zebe
 * @date 2014/4/15
 *
 */

@Component("huiyuan_account")
public class HuiyuanAccount extends AbstractMemberWidget{
	@Resource
	private HuiyuanService huiyuanService;
	
	@Resource
	private HuiyuanMoneyService huiyuanMoneyService;
	
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
			this.putData("huiyuan",huiyuan);
		}
		// 自动更正会员尾数金额（只保留两位数，这是防止自动转化时末尾显示的尾数问题）
		String money = String.valueOf(huiyuan.getMoney());
//		String money = "9000.020000000005";//测试金额
		if (money.indexOf(".") > 0) {
			String pre = money.substring(0, money.indexOf("."));
			String suf = money.substring(money.indexOf(".") + 1);
			if (suf.length() > 2) {
				suf = suf.substring(0, 2);
			}
			money = pre + "." + suf;
			huiyuan.setMoney(Double.parseDouble(money));
			huiyuanService.updateObj(huiyuan);
		}
		System.out.println("当前登录会员昵称：" + huiyuan.getNickname());
		System.out.println("当前登录会员余额：" + huiyuan.getMoney());
		
		// 取操作（action为空时默认显示第1页数据）
		if(action==null){
			page.setPageNo(1);
			page.setPageSize(10);
			Map map=huiyuanMoneyService.getListByPageWhere(new StringBuffer(" and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"' order by n.date desc"), page);
			this.putData("liushui", map.get("DATA"));
			this.setPageName("HuiyuanAccount.html");
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=huiyuanMoneyService.getListByPageWhere(new StringBuffer(" and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"' order by n.date desc"), page);
			this.putData("liushui", map.get("DATA"));
			this.putData("liushui2", 22222);
			this.setPageName("HuiyuanAccount2.html");
		}else if(action.equals("getTotale")){
			int count=0;
			StringBuffer where=new StringBuffer("  and n.huiyuan.huiYuan_id='"+huiyuan.getHuiYuan_id()+"'  order by n.date desc");
			count=huiyuanMoneyService.getCountByWhere(where);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
	}
}
