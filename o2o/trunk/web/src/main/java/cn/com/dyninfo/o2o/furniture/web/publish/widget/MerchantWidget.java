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

package cn.com.dyninfo.o2o.furniture.web.publish.widget;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

@Component("merchantWidget")
public class MerchantWidget extends Widget {
	
	@Resource
	private ShangJiaService shangJiaService;
	@Resource
	private AreaService areaService;
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
		if(arear!=null){
			this.putData("cityName", arear.getName());
		}else{
			this.putData("cityName", "成都市");
		}
		
		if(action!=null&&action.equals("getMerchant")){
			String province=(String) pamtr.get("provinceId");
			String city=(String) pamtr.get("cityId");
			String county=(String) pamtr.get("countyId");
			String cityName=(String) pamtr.get("cityName");
			String sql="";
			
			if(province==null&&city==null&&county==null&&cityName!=null){
				sql+="and n.city.name= '"+cityName+"' ";
			}
			
			if(province!=null&&province.length()>0){
				sql+=" and n.province.id='"+province+"' ";
			}
			
			if(city!=null&&city.length()>0){
				sql+=" and n.city.id='"+city+"' ";
			}
			
			if(county!=null&&county.length()>0){
				sql+=" and n.county.id='"+county+"' ";
			}
			
			String sortId=(String) pamtr.get("sortId");
			if(sortId!=null){
				sql+=" and n.type.type_id='"+sortId+"' ";
			}
			
			String name=(String) pamtr.get("name");
			if(name!=null){
				sql+=" and n.name like '%"+name+"%' ";
			}
			
			sql+=" and n.state='0'";
			System.out.println(sql);
			List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(new StringBuffer(sql));
			String json="[";
			for(ShangJiaInfo info:list){
				json+="{\"m_id\":"+info.getShangjia_id()+",\"m_n\":\""+info.getName()+"\",\"m_lo\":"+info.getLongitude()+",\"m_la\":"+
				info.getLatitude()+",\"m_a\":\""+info.getAddress()+"\"},";
			}
			if(json.length()>1){
				json=json.substring(0,json.length()-1);
			}
			json+="]";
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
			
		}else if(action.equals("area")){
			if(arear!=null){
				AreaInfo city=(AreaInfo) areaService.getObjById(arear.getId());
				this.putData("province", city.getParent());
				this.putData("city", city);
			}
			this.setPageName("mapArea.html");
		}
	}
}
