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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.ActiveGoods;
import cn.com.dyninfo.o2o.old.service.DiscountActiveService;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;

@Component("active_deat")
public class ActiveDeat extends Widget {

	@Resource
    private PagModInGoodsService pagModInGoodsService;
	
	@Resource
	private DiscountActiveService discountActiveService;
	
	@Override
	public void display(Map pamtr) {
		int actId=getActId();
		Active info=(Active) discountActiveService.getObjById(""+actId);
		String action=(String) pamtr.get("action");
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		PageInfo page=new PageInfo();
		
		if(action==null){
			this.putData("info", info);
			
		}else if(action.equals("actdata")){
			
			String mactId=(String) pamtr.get("actId");
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=pagModInGoodsService.getActGood(37, (arear!=null?arear.getId():null), " and a.active_id='"+mactId+"' ", page, null);
			List<ActiveGoods> list=discountActiveService.getActGoodsByList(new StringBuffer(" and n.act.id="+mactId), page);
			StringBuffer json=new StringBuffer("[");
			
			for(ActiveGoods ag:list){
				Goods goods=ag.getGoods();
				json.append("{");
				json.append("\"actId\":\""+ag.getAct().getActive_id()+"\",");
				json.append("\"lev\":\"\",");
				json.append("\"orderIndex\":\""+ag.getIdnex()+"\",");
				json.append("\"image\":\""+ag.getGoods().getDefaultImage()+"\",");
				json.append("\"goodId\":\""+ag.getGoods().getGoods_id()+"\",");
				json.append("\"actFlag\":\""+ag.getAct().getFlag()+"\",");
				json.append("\"goodId\":\""+ag.getGoods().getGoods_id()+"\",");
				json.append("\"g_index\":\""+ag.getGoods().getIndexs()+"\",");
				json.append("\"actType\":\""+ag.getAct().getType()+"\",");
				json.append("\"xmoney\":\""+ag.getGoods().getBazaarMoney()+"\",");
				
				
				if(ag.getAct().getFlag()==0){
					if(ag.getAct().getType().equals("1")){
						goods.setSalesMoney(goods.getSalesMoney()-ag.getAct().getVal());
					}else if(ag.getAct().getType().equals("2")){
						goods.setSalesMoney(goods.getSalesMoney()*ag.getAct().getVal()/10);
					}
				}
				
				json.append("\"money\":\""+Math.round(ag.getGoods().getSalesMoney()*100)*1.0/100+"\",");
				json.append("\"cnum\":\""+ag.getGoods().getNum()+"\",");
				json.append("\"goodName\":\""+ag.getGoods().getName()+"\",");
				json.append("\"xiaoliang\":\""+ag.getGoods().getNum()+"\",");
				json.append("\"acttime\":\""+ag.getAct().getEtimel()+"\",");
				json.append("\"ctime\":\""+getTime(ag.getAct().getEtimel())+"\"},");
				
			}
			if(list.size()>0){
				json.deleteCharAt(json.length()-1);
			}
			json.append("]");
			
			this.putData("json", json.toString());
			this.setPageName("json.html");
		}else if(action.equals("acttotal")){
			String mactId=(String) pamtr.get("actId");
			page.setPageNo(1);
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=pagModInGoodsService.getActGood(37, (arear!=null?arear.getId():null), " and a.active_id='"+mactId+"' ", page, null);
			int num=discountActiveService.getActGoodsCount(new StringBuffer(" and n.act.id="+mactId));
			String json="{\"total\":"+num+"}";
			this.putData("json", json);
			this.setPageName("json.html");
		}
	}
	
	private String getTime(int t2){
		int t=t2-(int)(new Date().getTime()/1000);
		int h=t/3600;
		int m=t%3600/60;
		int s=t%3600%60;
		String time=""+(h>9?h:"0"+h)+":"+(m>9?m:"0"+m)+":"+(s>9?s:"0"+s);
		return time;
	}
	
	public int getActId(){
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
