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

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsPostInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.model.BbsUserInfo;
import cn.com.dyninfo.o2o.furniture.web.bbs.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("bbsWidget")
public class BbsWidget extends Widget {
	
	@Resource
	private BbsPostService bbsPostService;
	
	@Override
	public void display(Map pamtr) {
		String action =(String) pamtr.get("action");
		if(action==null){
			String id=getbbsId();
			BbsPostInfo info=(BbsPostInfo) bbsPostService.getObjById(id);
			info.setSnum(info.getSnum()+1);
			bbsPostService.updateObj(info);
			this.putData("info", info);
			this.setPageName("title.html");
			
		}else if(action.equals("data")){
			String id=(String) pamtr.get("id");
			String u_d=(String) pamtr.get("u_d");
			StringBuffer where=new StringBuffer();
			if(u_d!=null){
				where.append(" and n.user.id='"+u_d+"' ");
			}
			where.append(" and  n.parent.id='"+id+"'   order by n.time asc ");
			PageInfo page=new PageInfo();
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=bbsPostService.getListByPageWhere(where, page);
			List list=(List) map.get("DATA");
			this.putData("data", list);
		}else if(action.equals("add")){
			String context=(String) pamtr.get("context");
			String b_id=(String) pamtr.get("b_id");
			try{
				HuiyuanInfo memner=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
				BbsUserInfo user=bbsPostService.getUser(""+memner.getHuiYuan_id(), Context.BBS_ROLE_MEMBER);
				BbsPostInfo parent=(BbsPostInfo) bbsPostService.getObjById(b_id);
				BbsPostInfo post=new BbsPostInfo();
				post.setUser(user);
				post.setContext(context);
				post.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				post.setStatus(1);//审核中
				post.setType(1);//回帖
				post.setParent(parent);
				bbsPostService.addObj(post);
				parent.setHnum(parent.getHnum()+1);
				parent.setHname(user);
				parent.setHtime(post.getTime());
				bbsPostService.updateObj(parent);
				int lev=0;
				int count=bbsPostService.getCountByWhere(new StringBuffer("and n.user.bbs_id='"+user.getBbs_id()+"' "));
				if(count>5){
					lev++;
				}
				if(count>50){
					lev++;
				}
				if(count>100){
					lev++;
				}
				if(count>200){
					lev++;
				}
				if(count>1000){
					lev++;
				}
				user.setLev(lev);
				bbsPostService.updateObj(user);
				ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
			}catch(Exception e){
				e.printStackTrace();
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}
			this.setFreeMaker(false);
			
		}else if(action.equals("sendadd")){
			String context=(String) pamtr.get("context");
			String title=(String) pamtr.get("title");
			try{
				HuiyuanInfo memner=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
				BbsUserInfo user=bbsPostService.getUser(""+memner.getHuiYuan_id(), Context.BBS_ROLE_MEMBER);
				BbsPostInfo post=new BbsPostInfo();
				post.setUser(user);
				post.setContext(context);
				post.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				post.setStatus(0);//审核中
				post.setType(0);//回帖
				post.setFlag(2);
				post.setTitle(title);
				post.setParent(post);
				post.setTop(0);
				bbsPostService.addObj(post);
				ResponseUtil.printl(this.HttpResponse, "{\"status\":0}", "json");
			}catch(Exception e){
				e.printStackTrace();
				ResponseUtil.printl(this.HttpResponse, "{\"status\":1}", "json");
			}
			this.setFreeMaker(false);
			
		}else if(action.equals("total")){
			String id=(String) pamtr.get("id");
			String u_d=(String) pamtr.get("u_d");
			
			StringBuffer where=new StringBuffer();
			if(u_d!=null){
				where.append(" and n.user.id='"+u_d+"' ");
			}
			where.append(" and  n.parent.id='"+id+"'  order by n.time asc ");
			int count=bbsPostService.getCountByWhere(where);
			String json="{\"total\":"+count+"}";
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, "{\"total\":"+count+"}", "json");
		}
		
	}
	
	public String getbbsId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		Pattern p=Pattern.compile("-([^\\.]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return null;
	}
	

}
