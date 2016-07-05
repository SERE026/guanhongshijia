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

package cn.com.dyninfo.o2o.furniture.web.wechat.widget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.StringUtil;

import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.page.model.Articles;
import cn.com.dyninfo.o2o.furniture.web.page.service.AdvService;
import cn.com.dyninfo.o2o.furniture.web.page.service.ArticlesService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.MessageSend;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;
/**
 * 微信
 * @author 王敏
 *
 */
@Component("weixing")
public class WeiXing extends Widget {
	
	@Resource
	private ArticlesService articlesService;
	@Resource
	private AdvService advService;
	@Resource
	private GameActiveService gameActiveService;
	@Resource
	private MessageSendService messageSendService;
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		
		if(action==null){
			String id="60";
			String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			List list=advService.getListByWhere(new StringBuffer(" and n.adv_starttime<='"+time+"' and n.adv_endtime>='"+time+"' and n.advwz.advwz_id="+id +" order by n.orderIndex asc"));
			putData("data", list);
			this.setPageName("index.html");
			return ;
		}else if(action.equals("about")){
			Articles info=(Articles) articlesService.getObjById("1");
			this.putData("context", info.getArtices_content());
			this.putData("title", "关于我们");
			this.setPageName("deatl.html");
			return ;
		}else if(action.equals("linke")){
			Articles info=(Articles) articlesService.getObjById("24");
			this.putData("context", info.getArtices_content());
			this.putData("title", "联系我们");
			this.setPageName("deatl.html");
			return ;
		}else if(action.equals("act")){
			String id=(String) pamtr.get("id");
			Active info=(Active) gameActiveService.getObjById(id);
			this.putData("context", info.getPs());
			this.putData("title", info.getName());
			this.setPageName("deatl.html");
			return ;
		}else if(action.equals("act")){
			String id=(String) pamtr.get("id");
			MessageSend info=(MessageSend) messageSendService.getObjById(id);
			this.putData("context", info.getContext());
			this.putData("title", info.getTitle());
			this.setPageName("deatl.html");
			return ;
		}else if(action.equals("actList")){
			List<Active> list=(List<Active>) gameActiveService.getListByWhere(new StringBuffer(" and n.role='ADMIN' and n.edate<'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"' "));
			List data=new ArrayList();
			for(Active act:list){
				Map<String,String> map=new HashMap<String,String>();
				map.put("title", act.getName());
				map.put("img", StringUtil.getImage(act.getPs()));
				map.put("context",StringUtil.replaceImage(act.getPs()));
				map.put("action", "act");
				map.put("time", act.getBdate());
				map.put("id", ""+act.getActive_id());
				data.add(map);
			}
			this.putData("title", "历史活动");
			this.putData("data", data);
			this.setPageName("list.html");
			return ;
		}else if(action.equals("msgList")){
			List<MessageSend> list=(List<MessageSend>) messageSendService.getListByWhere(new StringBuffer("  and n.sys_time<'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"' "));
			List data=new ArrayList();
			for(MessageSend act:list){
				Map<String,String> map=new HashMap<String,String>();
				map.put("title", act.getTitle());
				map.put("img", null);
				map.put("context",act.getContext());
				map.put("action", "msg");
				map.put("time", act.getSys_time());
				map.put("id", ""+act.getMessagesend_id());
				data.add(map);
			}
			this.putData("title", "商城公告");
			this.putData("data", data);
			this.setPageName("list.html");
			return ;
		}

		

		
	}

}
