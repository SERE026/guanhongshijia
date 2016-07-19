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

package cn.com.dyninfo.o2o.furniture.web.active.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.service.ActiveMemberService;
import cn.com.dyninfo.o2o.old.service.GameActiveService;
import cn.com.dyninfo.o2o.old.service.GameService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.context.SpringContext;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("gameWidget")
public class GameWidget extends Widget {

	@Resource
	private GameService gameService;
	
	@Resource
	private GameActiveService gameActiveService;
	
	@Resource
	private ActiveMemberService activeMemberService;
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action==null){
			String gameId=getGameId();
			String goodId=getGoodId();
			Active act=(Active) gameActiveService.getObjById(gameId);
			Widget widget=SpringContext.getBean(act.getGame().getPlugin());
			pamtr.put("act", act);
			String context=widget.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
			this.putData("game", act.getGame());
			this.putData("context",context);
			this.setPageName("game.html");
			this.putData("actId", gameId);
			this.putData("goodId", goodId);
		}else if(action.equals("checkLogin")){
			this.setFreeMaker(false);
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(member==null){
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}else{
				ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
			}
		}else if(action.equals("checkAct")){
			this.setFreeMaker(false);
			String data=(String) pamtr.get("data");
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			List list=activeMemberService.getListByWhere(new StringBuffer(" and n.date='"+date+"' and n.member.huiYuan_id="+member.getHuiYuan_id()+" and n.act.active_id="+data.split("-")[0]));
//			if(list.size()!=0){
//				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
//			}else{
				ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
//			}
		}else if(action.equals("updata")){
			String data=(String) pamtr.get("data");
			Active act=(Active) gameActiveService.getObjById(data.split("-")[0]);
			pamtr.put("act", act);
			pamtr.put("goodId", data.split("-")[1]);
			Widget widget=SpringContext.getBean(act.getGame().getPlugin());
			String context=widget.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
			this.setFreeMaker(false);
		}else if(action.equals("buy")){
			String data=(String) pamtr.get("data");
			Active act=(Active) gameActiveService.getObjById(data.split("-")[0]);
			pamtr.put("act", act);
			Widget widget=SpringContext.getBean(act.getGame().getPlugin());
			String context=widget.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
			this.setFreeMaker(false);
			
		}
	}
	
	public String getGameId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Pattern  p=Pattern.compile("-([\\d]+)-([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return null;
	}

	public String getGoodId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Pattern  p=Pattern.compile("-([\\d]+)-([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(2);
		}
		return null;
	}
}
