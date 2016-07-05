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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;

/**
 * 商品路径挂件
 * @author 王敏
 *
 */
@Component
public class GoodsPathWidget extends AbstractGoodsWidget {

	@Autowired
	public GoodsPathWidget(ItemGoodsWidget itemGoods){
		this.addWidget(itemGoods);
		
	}

	@Override
	public String getWidgetId() {
		return "goods_path";
	}

	@Override
	public void display(Map pamtr) {
		Goods goods=(Goods) pamtr.get("good");
		String path=" > <span class=\"STYLE10\">"+goods.getName()+"</span>";
		path = "" + getPath(goods.getGoodsSort())+path;
		this.putData("path", path);
	}
	
	/**
	 * 得到商品路径
	 * @param sort
	 * @return
	 */
	public String getPath(GoodsSort  sort){
		// 拼接路径
		String path = "";
		// 获取父代及它的子代
		GoodsSort parent = sort.getParent();
		if(parent!=null){
			List children = parent.getChildren();
			GoodsSort g = null;
			if (children.size() > 0) {
				g = (GoodsSort)children.get(0);
		
			
			if (parent != null & g != null) {
//				System.out.println(path);
				path = "<a href=\"http://www.c-1-tech.com/Dress/GoodList-" + g.getGoodsSort_id() + ".html\">" + parent.getName() + "</a> > ";
				path += "<a href=\"http://www.c-1-tech.com/Dress/GoodList-" + sort.getGoodsSort_id() + ".html\">" + sort.getName() + "</a>";
//				System.out.println(path);
			} else {
				// 如果没有父代
				path += "<a href=\"http://www.c-1-tech.com/Dress/GoodList-" + sort.getGoodsSort_id() + ".html\">" + sort.getName() + "</a>";
			}
			}
		}else{
			// 如果没有父代
			path += "<a href=\"http://www.c-1-tech.com/Dress/GoodList-" + sort.getGoodsSort_id() + ".html\">" + sort.getName() + "</a>";
		}
		return "<a href=\"http://www.c-1-tech.com/Dress/index.html\">首页</a> > " + path;
	} 
	

}
