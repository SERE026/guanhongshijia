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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;

/**
 * 路径
 * @author 王敏
 *
 */
@Component("list_path")
public class GoodListPath extends Widget {
	@Resource
	private GoodsSortService goodsSortService;
	@Override
	public void display(Map pamtr) {
		String sortId=getGoodSort();
		GoodsSort sort=(GoodsSort) goodsSortService.getObjById(""+sortId);
		String path = "";
		// 判断父代
		if (sort.getParent() != null) {
			path=getSortName(sort.getParent())+" ><span class=\"STYLE10\">"+sort.getName()+"</span>";//页面路径
		}
		this.putData("path", path);
//		this.setTitle(getSortName(sort.getParent())+" > "+sort.getName());
		this.setTitle(sort.getName());
	}
	
	
	private String getSortName(GoodsSort sort){
		String sortName=sort.getName();
		// 如果有父代
		if(sort.getParent() != null){
			List children = sort.getParent().getChildren();
			GoodsSort g = (GoodsSort)children.get(0);
			if (sort.getParent().getParent() != null) {
//				System.out.println("父代的父代不为空，=" + sort.getParent().getParent().getName());
				sortName=" <a href=\"http://www.c-1-tech.com/Dress/GoodList-" + g.getGoodsSort_id() + ".html\">" + sort.getParent().getParent().getName() + "</a>";
			} else {
//				System.out.println("只是父代不为空，=" + sort.getParent().getName());
				sortName=" <a href=\"http://www.c-1-tech.com/Dress/GoodList-" + g.getGoodsSort_id() + ".html\">" + sort.getParent().getName() + "</a>";
			}
		} else {
			// 如果没有父代
			List children = sort.getChildren();
			GoodsSort g = (GoodsSort)children.get(0);
			sortName=" <a href=\"http://www.c-1-tech.com/Dress/GoodList-" + g.getGoodsSort_id() + ".html\">" + sort.getName() + "</a>";
		}
		return sortName;
	}
	
	private String getGoodSort(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		
		return null;
	}
}
