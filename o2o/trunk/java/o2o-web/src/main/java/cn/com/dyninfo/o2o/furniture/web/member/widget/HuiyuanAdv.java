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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.model.Order;
import cn.com.dyninfo.o2o.old.model.OrderProduct;
import cn.com.dyninfo.o2o.old.service.OrderService;

@Component("huiyuanAdv")
public class HuiyuanAdv extends AbstractMemberWidget {
	@Resource
	private PagModInGoodsService pagModInGoodsService;
	@Resource
	private OrderService orderService;
	
	@Override
	public void execute(Map pamtr) {
		PageInfo page=new PageInfo();
		String left=(String)pamtr.get("left");
		String right=(String)pamtr.get("right");
	
		if(left!=null){
			page.setPageNo(Integer.parseInt(left));
		}else if(right!=null){
			page.setPageNo(Integer.parseInt(right));
		}else{
			page.setPageNo(1);
		}
		page.setPageSize(4);
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		List list=orderService.getListByWhere(new StringBuffer("and n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+"order by creatTime desc"));
		if(list.size()>0){
			Order  order  =(Order)list.get(0);;
			OrderProduct orderproductlist=(OrderProduct) order.getOrderProductList().get(0);
			int	goodSort =orderproductlist.getProduct().getGoodsSort().getGoodsSort_id();
			List<Map> datalist= pagModInGoodsService.getGoodBySlqCount(goodSort+"", "", page, "", "41" );
			this.putData("data", datalist);
		}else{
			this.putData("data", new ArrayList());
		}
	}

	
}
