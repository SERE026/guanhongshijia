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

package cn.com.dyninfo.o2o.furniture.web.league.widget;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.league.model.BusinessType;
import cn.com.dyninfo.o2o.furniture.web.league.model.MerchantsApply;
import cn.com.dyninfo.o2o.furniture.web.league.service.BusinessTypeService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantType;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantTypeService;

@Component("applyWidget")
public class ApplyWidget extends Widget {
	
	@Resource
	private BusinessTypeService businessTypeService;
	
	@Resource
	private MerchantTypeService merchantTypeService;
	
	
	@Resource
	private AreaService areaService;

	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action.equals("busType")){
			List list=businessTypeService.getListByWhere(new StringBuffer("  and n.status=0 order by n.orderIndex asc "));
			this.putData("data", list);
			this.setPageName("busType.html");
		}else if(action.equals("mhType")){
			List list=merchantTypeService.getListByWhere(new StringBuffer("  and n.status=0 order by n.orderIndex asc "));
			this.putData("data", list);
			this.setPageName("mhType.html");
		}else if(action.equals("saveApply")){
			String name=(String) pamtr.get("name");
			String contactMan=(String) pamtr.get("contactMan");
			String contactTel=(String) pamtr.get("contactTel");
			String contactPhone=(String) pamtr.get("contactPhone");
			String contactEmail=(String) pamtr.get("contactEmail");
			String companyName=(String) pamtr.get("companyName");
			String provinceId=(String) pamtr.get("provinceId");
			String cityId=(String) pamtr.get("cityId");
			String countyId=(String) pamtr.get("countyId");
			String address=(String) pamtr.get("address");
			String busType=(String) pamtr.get("busType");
			String mhType=(String) pamtr.get("mhType");
			MerchantsApply info=new MerchantsApply();
			info.setName(name);
			info.setCompanyName(companyName);
			info.setContactMan(contactMan);
			info.setContactPhone(contactPhone);
			info.setContactEmail(contactEmail);
			info.setContactTel(contactTel);
			info.setState("0");
			info.setAddress(address);
			AreaInfo province=(AreaInfo) areaService.getObjById(provinceId);
			AreaInfo city=(AreaInfo) areaService.getObjById(cityId);
			AreaInfo county=(AreaInfo) areaService.getObjById(countyId);
			BusinessType bus=(BusinessType) businessTypeService.getObjById(busType);
			MerchantType  mh=(MerchantType) merchantTypeService.getObjById(mhType);
			if(province!=null&&city!=null&&county!=null&&bus!=null&&mh!=null){
				info.setProvince(province);
				info.setCity(city);
				info.setCounty(county);
				info.setBusType(bus);
				info.setStoreType(mh);
				merchantTypeService.addObj(info);
				json="{\"status\":0}";
			}else{
				json="{\"status\":1}";
			}
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
		}

	}

}
