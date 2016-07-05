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

package cn.com.dyninfo.o2o.furniture.web.order.widget;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;

@Component("orderAdv")
@Scope("prototype")
public class OrderAdv extends Widget {
	@Resource
	private PagModInGoodsService pagModInGoodsService;
	@Resource
	private OrderService orderService;
	
	@Override
	public void display(Map pamtr) {
		try {
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(5);
		String out_trade_no =getTradeno();
		List<Order>	list=orderService.getListByPage(new StringBuffer(" and n.tradeNo='"+out_trade_no+"' "));
		List<Map> datalist=null;
		if(list.get(0)!=null){
			Order order=list.get(0);
			List<OrderProduct> Productlist=order.getOrderProductList();
			if(Productlist.size()==1){
				page.setPageSize(10);
				OrderProduct orderProduct=Productlist.get(0);
					int	goodSort =orderProduct.getProduct().getGoodsSort().getGoodsSort_id();
				 datalist= pagModInGoodsService.getGoodBySlqCount(goodSort+"", "", page, "", "41" );
			}
			if(Productlist.size()>1){
				OrderProduct orderProduct0=Productlist.get(0);	
				OrderProduct orderProduct1=Productlist.get(1);	
				int	goodSort0 =orderProduct0.getProduct().getGoodsSort().getGoodsSort_id();
				int	goodSort1=orderProduct1.getProduct().getGoodsSort().getGoodsSort_id();
				datalist= pagModInGoodsService.getGoodBySlqCount(goodSort0+"", "", page, "", "41" );
				List<Map> datalist1= pagModInGoodsService.getGoodBySlqCount(goodSort1+"", "", page, "", "41" );
				datalist.addAll(datalist1);
			}
			this.putData("data", datalist);
//			System.out.println("-----datalist----------"+datalist.size());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTradeno(){
		Pattern p=Pattern.compile("-([^\\.]+)");
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0){
			url=url.substring(0,url.indexOf("?"));
		}
		Matcher m=p.matcher(url);
		if(m.find()){
			return m.group(1);
		}
		return "";
	}
}

	
