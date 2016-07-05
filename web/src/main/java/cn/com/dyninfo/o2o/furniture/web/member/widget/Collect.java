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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.member.service.LoginfoService;
/*
 * 会员中心的收藏
 * @lxf
 */
@Component("collect")
public class Collect extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;
	 @Resource
	 private FavoritesService favoritesService;
	 @Resource
		private LoginfoService loginfoService;
	 
	    @Resource
	     private GoodsService goodsService;
		
	@Override
	public void execute(Map pamtr) {
	
		PageInfo page=new PageInfo();
		String action=(String) pamtr.get("action");
		String type=(String) pamtr.get("type");
		String favoritid=(String) pamtr.get("favoritid");
		String strid=(String) pamtr.get("strid");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(action==null){
			this.putData("huiyuan",huiyuan);
				int  count1 =favoritesService.getCountByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0' and n.good.shelves='0'"));
				int  count2 =favoritesService.getCountByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='1'"));
				int  count3= favoritesService.getCountByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0' and n.good.shelves='1'"));
				this.putData("goodssize", count1);
				this.putData("shangpinsize", count2);
				this.putData("shelvessize",count3);
				this.putData("hdgoodssize", favoritesService.getGoodsActiveCount(huiyuan.getHuiYuan_id()));
			
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			if(type.equals("1")){//收藏的商家查看
				Map map=favoritesService.getListByPageWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='1'"+"order by time desc"), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("Collect3.html");
			}else if(type.equals("2")){//活动
				List  hdgoods= favoritesService.getGoodsactive(huiyuan.getHuiYuan_id(),page);
				this.putData("data", hdgoods);
				this.setPageName("Collect4.html");
			}else if(type.equals("3")){//已下架
				
				Map map=favoritesService.getListByPageWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0' and n.good.shelves='1'"), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("Collect5.html");
			}else{//收藏的宝贝查看
				Map map=favoritesService.getListByPageWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0' and n.good.shelves='0'"+"order by time desc"), page);
				this.putData("data", map.get("DATA"));
				this.setPageName("Collect2.html");
			}
			
			
		}else if(action.equals("getTotale")){
			int count=0;
			if(type.equals("1")){//收藏的商家查看
				StringBuffer where=new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='1'"+"order by time desc");
				count=favoritesService.getCountByWhere(where);
			}else if(type.equals("2")){//收藏的商家查看
				count=favoritesService.getGoodsActiveCount(huiyuan.getHuiYuan_id());
			}else if(type.equals("3")){//收藏的商家查看
				StringBuffer where=new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0' and n.good.shelves='1'");
				count=favoritesService.getCountByWhere(where);
			}else{//收藏的商家查看
				StringBuffer where=new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.type='0'"+"order by time desc");
				count=favoritesService.getCountByWhere(where);
			}
			
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
		if(favoritid!=null){
			favoritesService.delObjById(favoritid);
		}
		if(strid!=null&&strid!=""){
			String str[]=strid.split("/");
			for(int i=0;i<str.length;i++){
				favoritesService.delObjById(str[i]);
			}
		}
	}
}
	