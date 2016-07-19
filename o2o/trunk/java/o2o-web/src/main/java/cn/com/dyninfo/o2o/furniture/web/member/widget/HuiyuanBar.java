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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.service.OrderService;

@Component("huiyuanBar")
public class HuiyuanBar extends AbstractMemberWidget{
	 
 	@Resource
	private OrderService orderService;



	 	
	@Override
	public void execute(Map pamtr) {
		String menuid=(String) pamtr.get("id");
		if(menuid!=null&&menuid.equals("1")){
			this.setPageName("HuiyuanMenu.html");
		}else if(menuid==null){
			
				
				PageInfo page=new PageInfo();
				String action=(String) pamtr.get("action");
				HttpSession session=HttpRequest.getSession();
				HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
				if(action==null){
					int countPlay=orderService.getCountByWhere(new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and n.state='0'"));
					int revcCount=orderService.getCountByWhere(new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and (n.state='1' or n.state='2')"));
					int showCount=orderService.getOrderShowCount(huiyuan.getHuiYuan_id());
					this.putData("orderpay", countPlay);
					this.putData("orderwait", revcCount);
					this.putData("ordershow", showCount);
					List list=orderService.getListByWhere(new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and (n.state='1' or n.state='2')"));
					for(int i=0;i<list.size();i++){
						Order order = (Order) list.get(i);
						String sendtime=order.getSendtime();
						 String 	time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
						  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						  try {
							  if(sendtime!=null){ 
								long sendt = df.parse(sendtime).getTime();
								long nowt = df.parse(time).getTime();
							    long data=(nowt - sendt) / (1000 * 60 * 60 * 24);
							    if(data>=15){
							    	order.setSuretime(time);
							    	order.setState("3");
							    	orderService.updateObj(order);
							    }
							  }
							} catch (ParseException e) {
								e.printStackTrace();
							}
					}
				}else if(action.equals("getData")){
					String tag=(String) pamtr.get("tag");
					String pageNo=(String) pamtr.get("pageNo");
					String pageSize=(String) pamtr.get("pageSize");
					page.setPageNo(Integer.parseInt(pageNo));
					page.setPageSize(Integer.parseInt(pageSize));
					page.setPageSize(10);
					if(tag.equals("play")){//待付款
						StringBuffer where =new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and n.state='0'");
						where.append("order by n.time desc ");
						Map map=orderService.getListByPageWhere(where, page);
						
						this.putData("data",map.get("DATA"));	
					}else if(tag.equals("revc")){//待收货
						StringBuffer where =new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and (n.state='1' or n.state='2')");
						where.append("order by n.time desc ");
						Map map=orderService.getListByPageWhere(where, page);
						this.putData("data",map.get("DATA"));	
					}else if(tag.equals("shai")){//待晒单
						List ordershow=orderService.getordershow(huiyuan.getHuiYuan_id(),page);
						List newList=new ArrayList();
						String idlist="";
						for(int i=0;i<ordershow.size();i++){
								Map map = (Map) ordershow.get(i);
								String id =	(String) map.get("order_id");
							if(idlist.indexOf(id)>0){
								continue;
							}else{
								idlist+=id;
								Order order =	(Order) orderService.getObjById(id);
								newList.add(order);
							}
							
						}
						this.putData("data",newList);	
						
					}else if(tag.equals("shou")){//回收站
						StringBuffer where=new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='1' and n.huistat='0' ");
						where.append("order by n.time desc ");
						Map map=orderService.getListByPageWhere(where, page);
						this.putData("tag", tag);
						this.putData("data",map.get("DATA"));	
					}else if(tag.equals("state")){//选择订单状态查看 
						String state=(String) pamtr.get("state");
						StringBuffer where=new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' "+(state.length()>0?"and n.state='"+state+"'":""));
						where.append("order by n.time desc ");
						Map map=orderService.getListByPageWhere(where, page);
						
						this.putData("data",map.get("DATA"));	
						
					}else if(tag.equals("search")){//搜索宝贝
						String baobei=(String) pamtr.get("baobei");
						if(baobei!=null){
							List ordershow= orderService.getbaobei(huiyuan.getHuiYuan_id(),baobei,page);
							List newList=new ArrayList();
							String idlist="";
							for(int i=0;i<ordershow.size();i++){
									Map map = (Map) ordershow.get(i);
									String id =	(String) map.get("order_id");
								if(idlist.indexOf(id)>0){
									continue;
								}else{
									idlist+=id;
									Order order =	(Order) orderService.getObjById(id);
									newList.add(order);
								}
							}
							this.putData("data",newList);	
						}else{
							try {
								this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/huiyuan_order.html");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
					else{
						Map map=orderService.getListByPageWhere(new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' order by creatTime desc"), page);
						this.putData("data", map.get("DATA"));
					}
					if(tag.equals("4")){
						this.setPageName("HuiyuanBar2.html");
					}else{
						this.setPageName("HuiyuanBar1.html");
					}
				}else if(action.equals("getTotale")){
					page.setPageNo(1);
					page.setPageSize(10);
					String tag=(String) pamtr.get("tag");
					int count=0;
					if(tag.equals("play")){
						StringBuffer where =new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and n.state='0'");
						count=orderService.getCountByWhere(where);
					}else if(tag.equals("revc")){
						StringBuffer where =new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and (n.state='1' or n.state='2')");
						count=orderService.getCountByWhere(where);
					}else if(tag.equals("shai")){
						count=orderService.getOrderShowCount(huiyuan.getHuiYuan_id());
					}else if(tag.equals("shou")){
						
						StringBuffer where=new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='1' ");
						count=orderService.getCountByWhere(where);
					}else if(tag.equals("state")){
						String state=(String) pamtr.get("state");
						StringBuffer where=new StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' and n.state='"+state+"'");
						count=orderService.getCountByWhere(where);
					}else if(tag.equals("search")){
						String baobei=(String) pamtr.get("baobei");
						orderService.getbaobeiCount(huiyuan.getHuiYuan_id(),baobei);
					}else if(tag.equals("ALL")){
						StringBuffer where=new  StringBuffer(" and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.status='0' order by creatTime desc");
						count=orderService.getCountByWhere(where);
					}
					this.putData("json","{\"total\":"+count+"}");
					this.setPageName("json.html");
				}
		
		}
		}
		
	}	

