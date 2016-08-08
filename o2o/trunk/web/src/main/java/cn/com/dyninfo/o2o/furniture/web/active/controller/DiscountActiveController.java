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

package cn.com.dyninfo.o2o.furniture.web.active.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.model.ActiveGoods;
import cn.com.dyninfo.o2o.furniture.web.active.service.ActiveGoodsService;
import cn.com.dyninfo.o2o.furniture.web.active.service.DiscountActiveService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.service.FavoritesService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.MessageSend;
import cn.com.dyninfo.o2o.furniture.web.setting.service.MessageSendService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;


/**
 * 打折活动
 * @author jettang
 *
 */
@Controller
@RequestMapping("/manage/discountActive")
public class DiscountActiveController extends BaseController {

	@Resource
	private DiscountActiveService discountActiveService;
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private FavoritesService favoritesService;
	
	@Resource
	private ActiveGoodsService activeGoodsService;
	
	@Resource
	private MessageSendService messageSendService;
	
	/**
	 * 添加折扣活动
	 * @param request
	 * @param obj
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, Active obj) {
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(merchants!=null){
			obj.setMerchants(merchants);
			obj.setRole("MERCHANTS");
		}else{
			obj.setRole("ADMIN");
		}
		String date=obj.getBdate();
		String time=obj.getBtime();
		if(time!=null&&time.length()>0){
			if(Pattern.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}", time)){
				date+=" "+time;
			}else{
				obj.setBtime("");
				date+=" 00:00:00";
			}
		}
		obj.setBtimel(Context.parseTime(date));
		
		
		date=obj.getEdate();
		time=obj.getEtime();
		if(time!=null&&time.length()>0){
			if(Pattern.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}", time)){
				date+=" "+time;
			}else{
				obj.setBtime("");
				date+=" 00:00:00";
			}
		}
		String imagesrc=request.getParameter("imagesrc");
		obj.setImg(imagesrc);
		obj.setEtimel(Context.parseTime(date));
		obj.setFlag(0);
		return super.add(request, obj);
	}
	
	/**
	 * 修改折扣活动
	 * @param request
	 * @param obj
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Active obj) {
		Active act=(Active) discountActiveService.getObjById(obj.getActive_id()+"");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(merchants!=null){
			act.setMerchants(merchants);
			act.setRole("MERCHANTS");
		}else{
			act.setRole("ADMIN");
		}
		String date=obj.getBdate();
		act.setBdate(date);
		String time=obj.getBtime();
		act.setBtime(time);
		if(time!=null&&time.length()>0){
			if(Pattern.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}", time)){
				date+=" "+time;
			}else{
				act.setBtime("");
				date+=" 00:00:00";
			}
		}
		act.setBtimel(Context.parseTime(date));
		
		date=obj.getEdate();
		act.setEdate(date);
		time=obj.getEtime();
		act.setEtime(time);
		if(time!=null&&time.length()>0){
			if(Pattern.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}", time)){
				date+=" "+time;
			}else{
				act.setEtime("");
				date+=" 00:00:00";
			}
		}
		String imagesrc=request.getParameter("imagesrc");
		act.setImg(imagesrc);
		act.setEtimel(Context.parseTime(date));
		act.setFlag(0);
		act.setName(obj.getName());
		act.setType(obj.getType());
		act.setVal(obj.getVal());
		act.setPs(obj.getPs());
		return super.endit(request, act);
	}

	@Override
	public void initService() {
		super.initService();
		this.baseService=discountActiveService;
		this.business="active";
		this.table="discountActive";
		del=false;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where =new StringBuffer(" and n.status=0 and n.flag=0");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(merchants!=null){
			where.append(" and ( n.role='ADMIN' or n.merchants.shangjia_id="+merchants.getShangjia_id()+" or g.merchants.shangjia_id=" + Constants.DEFAULT_SHANGJIA_ID + ") ");
		}else{
			where.append(" and n.role='ADMIN' ");
		}
		
		return super.list(request, where);
	}
	
	
	@RequestMapping("/goods/list")
	public ModelAndView Goodslist(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		StringBuffer where =new StringBuffer(" and n.shelves=0  and n.state=0 ");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		where.append(" and (n.merchants.shangjia_id="+merchants.getShangjia_id()+" or g.merchants.shangjia_id=" + Constants.DEFAULT_SHANGJIA_ID + ")");
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(25);
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		if(pageNo!=null&&pageNo.length()>0){
			page.setPageNo(Integer.parseInt(pageNo));
		}
		if(pageSize!=null&&pageSize.length()>0){
			page.setPageSize(Integer.parseInt(pageSize));
		}
		mav.addObject("active_id", request.getParameter("active_id"));
		
		Map map=goodsService.getListByPageWhere(where, page);
		mav.addAllObjects(map);
		mav.setViewName("/active/discountActive/goodList");
		return mav;
	}
	
	
	
	@RequestMapping("/list/{id}/orderIndex")
	public ModelAndView orderIndex(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("info",discountActiveService.getObjById(id));
		 mav.setViewName("/active/discountActive/orderIndex");
		 return mav;
	}
	
	
	@RequestMapping(value="/list/{id}/orderIndex",method=RequestMethod.PUT)
	public ModelAndView orderIndexPut(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 Active act=(Active) discountActiveService.getObjById(id);
		 String goods_ids[]=request.getParameterValues("goods_id");
		 String orderIndexs[]=request.getParameterValues("orderIndex");
		 if(goods_ids!=null){
			 for(ActiveGoods ag : act.getDeatList()){
				 for(int i=0;i<goods_ids.length;i++){
					 if(ag.getGoods().getGoods_id() == Integer.parseInt(goods_ids[i])){
						 ag.setIdnex(Integer.parseInt(orderIndexs[i]));
						 activeGoodsService.updateObj(ag);
					 }
				 }
			 }
		 }
		 mav.setViewName("redirect:/html/manage/discountActive/list");
		 return mav;
	}
	
	/**
	 * 添加活动商品列表
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/list/{id}/Goods")
	public ModelAndView count(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 Active act=(Active) discountActiveService.getObjById(id);
		 mav.addObject("info",act);
		 StringBuffer where=new StringBuffer();
		 ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		 where.append(" and (g.merchants.shangjia_id="+merchants.getShangjia_id()+" or g.merchants.shangjia_id=" + Constants.DEFAULT_SHANGJIA_ID + ") and n.active_id="+id);
		 List list=discountActiveService.getGoodListByWhere(where);
		 mav.addObject("DATA", list);
		 mav.setViewName("/"+business+"/"+table+"/discount");
		 return mav;
	}
	
	/**
	 * 删除商品
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/del/Goods",method=RequestMethod.DELETE)
	public void delGoods(HttpServletRequest request,HttpServletResponse response){
		String actId=request.getParameter("actId");
		String goodId=request.getParameter("goodId");
		discountActiveService.delLink(actId, goodId);
		Active active=(Active) discountActiveService.getObjById(actId);
		active.setCount(active.getCount()-1);
		discountActiveService.updateObj(active);
		List list=messageSendService.getListByWhere(new StringBuffer(" and n.goods.goods_id="+goodId+" and n.active.active_id="+actId));
		if(list.size()>0){
			MessageSend mes=(MessageSend) list.get(0);
			messageSendService.delObjById(mes.getMessagesend_id()+"");
		}
		ResponseUtil.printl(response, "{\"status\":0}", "json");
	}
	
	/**
	 * 添加商品
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/add/{id}/Goods")
	public ModelAndView disCount(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 Active act=(Active) discountActiveService.getObjById(id);
		 if(act.getDeatList() != null){
			 for(ActiveGoods ag : act.getDeatList()){
				 activeGoodsService.delObj(ag);
			 }
		 }
		 discountActiveService.updateActive(request, id);
		 mav.setViewName("redirect:/html/manage/"+table+"/list");
		 return mav;
	}
}
