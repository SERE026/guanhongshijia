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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;

/**
 * 列表页面显示产品分类
 * @author 王敏
 *
 */
@Component("good_sort")
public class GoodSortWidget extends Widget {

	@Resource
	private GoodsSortService goodsSortService;
	@Override
	public void display(Map pamtr) {
		String sortId=getGoodSort();
		GoodsSort sort=(GoodsSort) goodsSortService.getObjById(""+sortId);
		GoodsSort sortTop=getSortTop(sort);//顶级商品类型
		this.putData("sortPrantId", sort.getParent().getGoodsSort_id());
		this.putData("sortTop", sortTop);
		this.putData("sort_id", Integer.parseInt(sortId));
	}
	private GoodsSort getSortTop(GoodsSort sort){
		GoodsSort result=sort;
		if(sort.getParent()!=null){
			result=getSortTop(sort.getParent());
		}
		return result;
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
