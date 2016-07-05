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

package cn.com.dyninfo.o2o.furniture.web.league.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 商家连锁页面显示
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/shangJiaLeague")
public class ShangJiaLeagueController {

	@Resource
	private ShangJiaService shangJiaService;
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		PageInfo  page=new PageInfo();
		StringBuffer where=	new StringBuffer();
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.length()==0){
			page.setPageNo(1);
		}else{
			page.setPageNo(Integer.parseInt(pageNo));
		}
		page.setPageSize(25);
		String order=request.getParameter("order");
		if(order==null||order.length()==0){
			mav.addObject("order", 2);//列表排序
			where.append(" order by n.orderIndex asc ");
		}else{
			mav.addObject("order", order);
			if(order.equals("2")){
				where.append(" order by n.orderIndex asc ");
			}else{
				where.append(" order by n.recommendedIndex asc ");
			}
		}
		mav.addAllObjects(shangJiaService.getListByPageWhere(where, page));
		mav.setViewName("/jiameng/shangJiaLeague/list");
		return mav;
	}
	
	/**
	 * 设置连锁店铺排序
	 * @param request
	 * @return
	 */
	@RequestMapping("/setOderIndex")
	public ModelAndView setTop(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String shangjia_ids[]=request.getParameterValues("list");
		for(String shangjia_id:shangjia_ids){
			ShangJiaInfo info=(ShangJiaInfo) shangJiaService.getObjById(shangjia_id);
			if(info!=null){
				String orderIndex=request.getParameter(shangjia_id+"orderIndex");
				info.setOrderIndex(orderIndex);
				String recommendedIndex=request.getParameter(shangjia_id+"recommendedIndex");
				info.setRecommendedIndex(recommendedIndex);
				shangJiaService.updateObj(info);
			}
		}
		mav.setViewName("redirect:/html/manage/shangJiaLeague/list");
		return mav;
	}
	
}
