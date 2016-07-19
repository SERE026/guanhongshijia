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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.old.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantOrderService;

/**
 * android 女人街
 * @author feng
 *
 */
@Controller
@RequestMapping("/anrj")
public class AnrjController{
    
		@Resource
		private MerchantOrderService merchantOrderService;
		
		@Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 	String id=request.getParameter("id");
			String pageno=request.getParameter("pageno");
		 	AreaInfo arear=(AreaInfo)areaService.getObjById(id);
		 	PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageno));
			page.setPageSize(10);
			String sql="";
			if(arear!=null){
				sql+=" and s.CITY_ID='"+arear.getId()+"' ";
			}
			List list=merchantOrderService.getMerchantPageBywhere("4", sql, page);
			if(list.size()>0){
				String json="{\"status\":0,\"data\":[";
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i);
					json+="{\"s_name\":\""+map.get("s_name").toString().replace(" ", "")+"\",\"s_id\":\""+map.get("s_id").toString()+"\",\"nrjImage\":\""+map.get("s_id").toString()+"/";
					if(map.get("nrjImage")==null){
						json+="\"},";
					}else{
						json+=map.get("nrjImage").toString()+"\"},";
					}
				}
				if(json.length()>1){
					json=json.substring(0,json.length()-1);
				}
				json+="]}";
				ResponseUtil.printl(response, json, "json");
	  		}else{
	  			ResponseUtil.printl(response, "{\"status\":1}", "json");
	  		}
	 }
 }