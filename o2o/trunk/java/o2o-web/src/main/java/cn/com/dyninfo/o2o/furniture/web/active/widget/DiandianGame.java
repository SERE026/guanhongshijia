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

package cn.com.dyninfo.o2o.furniture.web.active.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.old.model.GameParam;
import cn.com.dyninfo.o2o.old.service.ActiveMemberService;
import cn.com.dyninfo.o2o.old.service.GameActiveService;
import cn.com.dyninfo.o2o.old.service.GameParamService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;

@Component("diandian")
public class DiandianGame extends Widget {

	@Resource
	private GameParamService gameParamService;
	@Resource
	private GameActiveService gameActiveService;
	@Resource
	private ActiveMemberService activeMemberService;
	
	@Resource
	private GoodsService goodsService;
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action==null){
			Active act=(Active) pamtr.get("act");
			List list=gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动diandian' and n.objId='"+act.getActive_id()+"' "));
			if(list.size()>0){
				this.putData("ganmePame", list.get(0));
			}
			this.setPageName("diandian.html");
		}else if(action.equals("updata")){
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			Active act=(Active) pamtr.get("act");
			String goodId=(String) pamtr.get("goodId");
			if(member!=null&&act!=null){
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				this.setFreeMaker(false);
				List list=gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动diandian' and n.objId='"+act.getActive_id()+"' "));
				String result="";
				if(list.size()>0){
					GameParam p=(GameParam) list.get(0);
					int count=Integer.parseInt((String) pamtr.get("count"));
					Double price=0.0;
					int lev=0;
					if(count>=Integer.parseInt(p.getParam5())){
						price=Double.parseDouble(p.getParam11());
						lev=1;
					}
					else if(count>=Integer.parseInt(p.getParam4())){
						price=Double.parseDouble(p.getParam10());
						lev=2;
					}
					else if(count>=Integer.parseInt(p.getParam3())){
						price=Double.parseDouble(p.getParam9());
						lev=3;
					}
					else if(count>=Integer.parseInt(p.getParam2())){
						price=Double.parseDouble(p.getParam8());
						lev=4;
					}
					else if(count>=Integer.parseInt(p.getParam1())){
						price=Double.parseDouble(p.getParam7());
						lev=5;
					}
					else{
						price=Double.parseDouble(p.getParam6());
						lev=6;
					}
					
					HttpSession  session=this.HttpRequest.getSession();
					ActiveMemberInfo actMember=new ActiveMemberInfo();
					actMember.setMember(member);
					actMember.setMoney(price);
					actMember.setLev(lev);
					actMember.setDate(time.substring(0,10));
					actMember.setTime(time);
					actMember.setAct(act);
					actMember.setGoods((Goods)goodsService.getObjById(goodId));
					activeMemberService.addObj(actMember);
					session.setAttribute("act"+act.getActive_id(),actMember );
					result="{\"status\":0,\"pirce\":"+price+"}";
				}else{
					result="{\"status\":1}";
				}
				this.setFreeMaker(false);
				ResponseUtil.printl(this.HttpResponse, result, "json");
			}
		}
	}
	
	

}
