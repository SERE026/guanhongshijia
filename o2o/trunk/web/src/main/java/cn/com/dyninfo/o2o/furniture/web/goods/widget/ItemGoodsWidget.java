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

import cn.com.dyninfo.o2o.furniture.util.CookTool;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.ProductService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.ShowGoodService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderProductServeice;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("itemGoods")
public class ItemGoodsWidget extends AbstractGoodsWidget{

	@Resource
	private ProductService productService;
	
	@Resource
	private GoodsService goodsService;
	private Goods good;
	
	@Resource
	private FavoritesService favoritesService;
	@Resource
    private PagModInGoodsService pagModInGoodsService;
	@Resource
	private ShowGoodService showGoodService;
	@Resource
	private CommentService commentService;
	@Resource
	private OrderProductServeice orderProductServeice;
	@Override
	public String getWidgetId() {
		return "item";
	}

	@Override
	public void display(Map pamtr) {
		
		int good_id=getGoodId();
		
		good=goodsService.getGoodsPrice(good_id);
		if(good!=null&&good.getShelves().equals("0")){
			PageInfo page2=new PageInfo();
			page2.setPageSize(10);
			Map map2=orderProductServeice.getListByPageWhere(new StringBuffer("and n.product="+good.getGoods_id()),page2);//

			int num=commentService.getCountByWhere(new StringBuffer("and n.ginfo="+good.getGoods_id() ));
			Double a=good.getActionMoney();
			showGoodService.addShowLog(good_id, this.HttpRequest);
			int favoritesNum=favoritesService.getCountByWhere(new StringBuffer(" and n.good.goods_id="+good.getGoods_id()));
			
			pamtr.put("good", good);
			if(this.getList()!=null){
				for(IGoodsWidget widget:this.getList()){
					AbstractGoodsWidget gw=(AbstractGoodsWidget) widget;
					String context=gw.parseWidget(this.HttpRequest, this.HttpResponse, pamtr);
					this.putData("widget_"+widget.getWidgetId(), context);
				}
			}
			PageInfo page=new PageInfo();
			page.setPageNo(1);
			page.setPageSize(4);
			AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
			Map map=new HashMap();
			map.put("goodSort_id", ""+good.getGoodsSort().getGoodsSort_id());
			List<Goods> Sortlist=pagModInGoodsService.getSJGoods(30, arear!=null?arear.getId():null, 0, page, map,good.getMerchants().getShangjia_id());
			String clientID="";
			HuiyuanInfo huiyuan=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			if(huiyuan==null){
				clientID=CookTool.getCookIEValue(Context.COOKIE_CLIENT_ID,HttpRequest);
			}else{
				clientID=""+huiyuan.getHuiYuan_id();
			}
			map.put("clientID", clientID);
			map.remove("goodSort_id");
			List<Goods> showList=pagModInGoodsService.getGoods(30, arear!=null?arear.getId():null, 100, page, map);
			
			this.putData("favoritesNum", favoritesNum);
			this.putData("title", good.getName());
			this.putData("showList",showList);
			this.putData("Sortlist",Sortlist);
			int t=(int)(new Date().getTime()/1000);
			int showCount=showGoodService.getCountByWhere(new StringBuffer(" and n.good.goods_id="+good_id+" and n.time>"+t));
			this.putData("showCount",showCount);
			good.setActionMoney(a);
//			System.out.println(good.getGoodMoney());
			this.putData("good",good);
			this.putData("num",num);
			this.putData("orderList", map2.get("DATA"));
			this.setTitle(good.getName());
		}else{
			
		}
	}
	
	public int getGoodId(){
		String url=this.HttpRequest.getServletPath();
		url=url.substring(url.lastIndexOf("/")+1);
		if(url.indexOf("?")>0)
			url=url.substring(0,url.indexOf("?"));
		Pattern p=Pattern.compile("([\\d]+)");
		Matcher m=p.matcher(url);
		if(m.find()){
			return Integer.parseInt(m.group(1));
		}
		return 0;
	}

	

}
