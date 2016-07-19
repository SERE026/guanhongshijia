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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.CommentService;

@Component("bbskoubei")
public class Bbskoubei extends Widget {
	@Resource
	private GoodsService goodsService;
	@Resource
	  private CommentService commentService;
	
	@Override
	public void display(Map pamtr) {
		 PageInfo page=new PageInfo();
			HttpSession session=HttpRequest.getSession();
			String action=(String) pamtr.get("action");
			HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
			if(action==null){
				
			}else if(action.equals("getData")){
				String pageNo=(String) pamtr.get("pageNo");
				String pageSize=(String) pamtr.get("pageSize");
				String type=(String) pamtr.get("type");
				StringBuffer where = new StringBuffer(" and n.status='0'  ");
				if(type.equals("1")){
					type="彩妆";
				}else if(type.equals("2")){
					type="护肤";
				}else if(type.equals("3")){
					type="美容";
				}else if(type.equals("4")){
					type="服务";
				}else if(type.equals("5")){
					where.append("and n.ginfo.goodsSort.name not like '%彩妆%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%护肤%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%美容%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%服务%'  ");
				}
				if(!type.equals("5")&&!type.equals("0")){
					where.append("and n.ginfo.goodsSort.name like '%"+type+"%'");
				}
				page.setPageNo(Integer.parseInt(pageNo));
				page.setPageSize(Integer.parseInt(pageSize));
				List  list=commentService.getListLeftByWhere(where, page);
				this.putData("data",list );
				this.setPageName("Bbskoubei2.html");
			}else if(action.equals("getTotale")){
				String type=(String) pamtr.get("type");
				StringBuffer where = new StringBuffer(" and n.status='0 '");
				if(type.equals("1")){
					type="彩妆";
				}else if(type.equals("2")){
					type="护肤";
				}else if(type.equals("3")){
					type="美容";
				}else if(type.equals("4")){
					type="服务";
				}else if(type.equals("5")){
					where.append("and n.ginfo.goodsSort.name not like '%彩妆%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%护肤%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%美容%'  ");
					where.append("and n.ginfo.goodsSort.name not like '%服务%'  ");
				}
				if(!type.equals("5")&&!type.equals("0")){
					where.append("and n.ginfo.goodsSort.name like '%"+type+"%'");
				}
				page.setPageNo(1);
				page.setPageSize(10);
				int count=commentService.getListLeftCount(where, page);
				this.putData("json","{\"total\":"+count+"}");
				this.setPageName("json.html");
			}
		}
	}