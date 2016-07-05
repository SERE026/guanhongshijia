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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;

@Component("comment")
public class CommentGoods extends AbstractGoodsWidget {

	@Resource
	private CommentService commentService;

	@Autowired
	public CommentGoods(ItemGoodsWidget itemGoods){
		this.addWidget(itemGoods);
		
	}
	@Override
	public String getWidgetId() {
		return "comment";
	}

	@Override
	public void display(Map pamtr) {
		
		Goods good=(Goods) pamtr.get("good");
		if(good!=null){
			PageInfo page=new PageInfo();
			page.setPageSize(5);
			page.setPageNo(1);
			Map map=commentService.getListByPageWhere(new StringBuffer(" and n.ginfo.goods_id="+good.getGoods_id()+" and n.status=0 and n.isShow=1 "),page);
			this.putData("DATA", map.get("DATA"));
			this.putData("PAGE_INFO",map.get("PAGE_INFO"));
			this.putData("good",good);
		}else{
			String goods_id=(String) pamtr.get("g_id");
			String pageNo=(String) pamtr.get("pageNo");
			PageInfo page=new PageInfo();
			page.setPageSize(5);
			page.setPageNo(Integer.parseInt(pageNo));
			Map map=commentService.getListByPageWhere(new StringBuffer(" and n.ginfo.goods_id="+goods_id+" and n.status=0 and n.isShow=1 "),page);
			this.putData("DATA", map.get("DATA"));
			this.putData("PAGE_INFO",map.get("PAGE_INFO"));
			this.putData("good",good);
			this.setPageName("CommentAjax.html");
		}
	}

}
