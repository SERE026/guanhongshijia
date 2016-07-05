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

package cn.com.dyninfo.o2o.furniture.web.goods.widget;

import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;

@Component("tryuseSaidan")
public class TryuseSaidan extends Widget {
	@Resource
	private GoodsService goodsService;
	 @Resource
     private BrandService brandService;
     @Resource
     private CommentService commentService;
	@Override
	public void display(Map pamtr) {
		   PageInfo page=new PageInfo();
			HttpSession session=HttpRequest.getSession();
			String action=(String) pamtr.get("action");
			String goodsid=(String) pamtr.get("goodsid");
			if(goodsid!=null){
				session.setAttribute("goodsid", goodsid);
			}
			HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
			if(action==null){
				
			}else if(action.equals("getData")){
				String pageNo=(String) pamtr.get("pageNo");
				String pageSize=(String) pamtr.get("pageSize");
				page.setPageNo(Integer.parseInt(pageNo));
				page.setPageSize(Integer.parseInt(pageSize));
				goodsid=(String) session.getAttribute("goodsid");
				Map map=commentService.getListByPageWhere(new StringBuffer(" and n.status='0' and n.ginfo.goods_id="+goodsid), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("TryuseSaidan2.html");
			}else if(action.equals("getTotale")){
				page.setPageNo(1);
				page.setPageSize(10);
				goodsid=(String) session.getAttribute("goodsid");
				StringBuffer where=new StringBuffer(" and n.status='0' and n.ginfo.goods_id="+goodsid);
				int count=commentService.getCountByWhere(where);
				this.putData("json","{\"total\":"+count+"}");
				this.setPageName("json.html");
			}else if(action.equals("del")){
				String id=(String) pamtr.get("id");
				brandService.delObjById(id);
				this.putData("data", "1");
				this.setPageName("register.html");
			}
	}
}