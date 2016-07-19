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

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.CommentService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.service.OrderProductServeice;
import cn.com.dyninfo.o2o.old.service.OrderService;
/*
 * 会员中心的晒单
 * @lxf
 */
@Component("showorder")
public class Showorder extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;

     @Resource
     private CommentService commentService;
     
 	@Resource
	private OrderService orderService;
     
 	@Resource
	private OrderProductServeice orderProductServeice;
		
	@Override
	public void execute(Map pamtr) {
		PageInfo page=new PageInfo();
		String action=(String) pamtr.get("action");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(action==null){
			
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=orderProductServeice.getListByPageWhere(new StringBuffer(" and n.order.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+" and n.order.state='3'"), page);
			this.putData("data", map.get("DATA"));
			this.setPageName("Showorder2.html");
		}else if(action.equals("getTotale")){
			page.setPageNo(1);
			page.setPageSize(10);
			StringBuffer where=new StringBuffer(" and n.order.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.order.state='3'");
			int count=orderProductServeice.getCountByWhere(where);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
	
	}
}
	