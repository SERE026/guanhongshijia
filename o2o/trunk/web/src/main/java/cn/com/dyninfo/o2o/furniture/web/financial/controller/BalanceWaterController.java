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

package cn.com.dyninfo.o2o.furniture.web.financial.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantMoneyService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

@Controller
@RequestMapping("/manage/balanceWater")
public class BalanceWaterController {

	@Resource
	private MerchantMoneyService merchantMoneyService;
	
	@Resource
	private ShangJiaService shangJiaService;
	
	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		PageInfo page = new PageInfo();
		StringBuffer where= new StringBuffer();
		ShangJiaInfo info=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(info!=null && info.getShangjia_id() != Constants.DEFAULT_SHANGJIA_ID){
			info=(ShangJiaInfo) shangJiaService.getObjById(""+info.getShangjia_id());
			mav.addObject("m", info);
			where.append(" and n.merchant.shangjia_id="+info.getShangjia_id());
		}
		if(request.getAttribute("pageSize")!=null){
			page.setPageSize((Integer)request.getAttribute("pageSize"));
		}else{
			page.setPageSize(25);
		}
		
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0){
			Pattern pattern =Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if(m.matches()){
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		}else
			page.setPageNo(1);
		
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		where.append(" order by n.time desc ");
		mav.addAllObjects(merchantMoneyService.getListByPageWhere(where, page));
		mav.setViewName("/financial/balanceWater/list");
		return mav;
	}
}
