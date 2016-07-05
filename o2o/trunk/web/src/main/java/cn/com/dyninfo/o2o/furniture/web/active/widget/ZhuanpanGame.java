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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.furniture.web.active.model.GameParam;
import cn.com.dyninfo.o2o.furniture.web.active.service.ActiveMemberService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameParamService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;



@Component("zhuanpan")
public class ZhuanpanGame extends Widget {

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
			List list=gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动rotary' and n.objId='"+act.getActive_id()+"' "));
			if(list.size()>0){
				this.putData("ganmePame", list.get(0));
			}
			this.setPageName("zhuanpan.html");
		}else if(action.equals("updata")){
			HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
			Active act=(Active) pamtr.get("act");
			String goodId=(String) pamtr.get("goodId");
			if(member!=null&&act!=null){
				int angle[][]={{27,187,17,197},{35,220,45,235},{70,250,80,260},{95,280,110,290},{130,320,135,325},{160,335,170,350}};
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				this.setFreeMaker(false);
				List list=gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动rotary' and n.objId='"+act.getActive_id()+"' "));
				String result="";
				if(list.size()>0){
					GameParam p=(GameParam) list.get(0);
					List<ZhunaPanBean> l=sort(p);
					int x=getV(l.get(0).v);
					Random r=new Random();
					int z=r.nextInt(x);
					for(ZhunaPanBean zpb:sort(p)){
						if(z<=zpb.v*x){
							HttpSession  session=this.HttpRequest.getSession();
							ActiveMemberInfo actMember=new ActiveMemberInfo();
							actMember.setMember(member);
							actMember.setMoney(Double.parseDouble(""+zpb.price));
							actMember.setLev(zpb.des);
							actMember.setDate(time.substring(0,10));
							actMember.setTime(time);
							actMember.setAct(act);
							actMember.setGoods((Goods)goodsService.getObjById(goodId));
							activeMemberService.addObj(actMember);
							session.setAttribute("act"+act.getActive_id(),actMember );
							result="{\"status\":0,\"angle\":"+angle[zpb.des][r.nextInt(4)]+",\"des\":"+(zpb.des+1)+",\"pirce\":"+zpb.price+"}";
							break;
						}
					}
				}else{
					result="{\"status\":1}";
				}
				
				this.setFreeMaker(false);
				ResponseUtil.printl(this.HttpResponse, result, "json");
			}
		}
	}
	
	
	public int getV(float v){
		int i=1;
		while(true){
			if(v!=0&&v<1){
				v*=10;
				i*=10;
			}else{
				return i;
			}
		}
	}
	
	
	public List<ZhunaPanBean> sort(GameParam p){
		List list=new ArrayList();
		ZhunaPanBean b=new ZhunaPanBean();
		b.des=0;
		b.price=Float.parseFloat(p.getParam1());
		b.v=Float.parseFloat(p.getParam2());
		list.add(b);
		
		b=new ZhunaPanBean();
		b.des=1;
		b.price=Float.parseFloat(p.getParam3());
		b.v=Float.parseFloat(p.getParam4());
		list.add(b);
		
		b=new ZhunaPanBean();
		b.des=2;
		b.price=Float.parseFloat(p.getParam5());
		b.v=Float.parseFloat(p.getParam6());
		list.add(b);
		
		b=new ZhunaPanBean();
		b.des=3;
		b.price=Float.parseFloat(p.getParam7());
		b.v=Float.parseFloat(p.getParam8());
		list.add(b);
		
		b=new ZhunaPanBean();
		b.des=4;
		b.price=Float.parseFloat(p.getParam9());
		b.v=Float.parseFloat(p.getParam10());
		list.add(b);
		
		b=new ZhunaPanBean();
		b.des=5;
		b.price=Float.parseFloat(p.getParam11());
		b.v=Float.parseFloat(p.getParam12());
		list.add(b);
		ComparatorBean comparator=new ComparatorBean();
		Collections.sort(list, comparator);
		return list;
	}
	
	

}
