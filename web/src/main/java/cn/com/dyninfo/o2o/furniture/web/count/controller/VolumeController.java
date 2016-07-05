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

package cn.com.dyninfo.o2o.furniture.web.count.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 成交量统计
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/volume")
public class VolumeController extends BaseController{

	@Resource
	private OrderService orderService;
	   
	@Resource
	private ShangJiaService shangjiaService;
	   
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
	    	 StringBuffer where=new StringBuffer();
	    	 ModelAndView mva= new ModelAndView() ;
	    	String date= new SimpleDateFormat("yyyy").format(new Date());
	    	String date1= new SimpleDateFormat("MM").format(new Date());
	    	int year=Integer.parseInt(date);
	    	int month=Integer.parseInt(date1);
	    	mva.addObject("year", year);
	    	mva.addObject("month", month);
	    	 mva.setViewName("/count/volume/list");
	           return mva;
	     }
	     
	     /**
	 	 * 列表
	 	 * 
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping("/order")
	 	public ModelAndView order(HttpServletRequest request) {
	 		StringBuffer where = new StringBuffer();
	 		StringBuffer where2=new StringBuffer();
	 		ModelAndView mva=new ModelAndView();
	 		String btime = request.getParameter("btime");
	 		String etime = request.getParameter("etime");
	 		String year=request.getParameter("year");
	 		String month=request.getParameter("month");
	 		PageInfo page = new PageInfo();
			page.setPageSize(25);
			int no = 0;
			if (request.getParameter("pageNo") != null&&!request.getParameter("pageNo").equals("")) {
				no = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (no > 0) {
				page.setPageNo(no);
			} else
				page.setPageNo(1);
			if (btime != "" && btime != null) {
	 			where.append(" and SURETIME >='" + btime + "24:00:00'");

	 		}
	 		if (etime != "" && etime != null) {
	 			where.append(" and SURETIME <='" + etime + " 24:00:00'");
	 		}
	 		if(month!=null&&!"".equals(month)){
	 			where.append(" and SURETIME>='"+year+"-"+month+"-"+"01"+" 24:00:00'");
	 		}
	 		
	 		if(year!=null&&!"".equals(year)){
	 			where.append(" and SURETIME <'"+year+"-0"+(Integer.parseInt(month)+1)+"-"+"01"+" 24:00:00'");
	 		}
	 		UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
	 		if(info.getIs_user().equals("1")){
	 			where2.append(" and s.shangjia_id ='").append(info.getShanfJiaInfo().getShangjia_id()).append("'");
	 		}
	 		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
			if(daili!=null){
				String area[]=daili.getAreaid().split(",");
				String ids="(";
				for(int i=0;i<area.length;i++){
					ids+="'"+area[i].replace("|", "").replace("%", "")+"',";
				}
				if(ids.length()>1){
					ids=ids.substring(0,ids.length()-1);
				}
				ids+=")";
				where2.append(" and s.CITY_ID in "+ids+"");
			}
			where.append(" and a.STATE='3' and a.STATUS='0'");
	 		HashMap<String, ?> mapp = orderService.getByPageWhere(where, page,where2);
			List users = (List)mapp.get("DATA");
			page = (PageInfo) mapp.get("PAGE_INFO");
			mva.addObject("LIST", users);
			mva.addObject("PAGE_INFO", page);
			mva.addObject("btime",btime);
			mva.addObject("etime",etime);
	 		mva.setViewName("/count/volume/order");
	 		return mva;
	 	}
}
