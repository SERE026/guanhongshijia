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

import java.util.ArrayList;
import java.util.HashMap;
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
import cn.com.dyninfo.o2o.furniture.web.active.model.GameParam;
import cn.com.dyninfo.o2o.furniture.web.active.plugin.ActivePlugin;
import cn.com.dyninfo.o2o.furniture.web.active.service.ActiveGoodsService;
import cn.com.dyninfo.o2o.furniture.web.active.service.DiscountActiveService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameParamService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

@Controller
@RequestMapping("/manage/gameActive")
public class GameActiveController extends BaseController {

	@Resource
	private GameActiveService gameActiveService;
	@Resource
	private DiscountActiveService discountActiveService;

	@Resource
	private GameService gameService;

	@Resource
	private ActivePlugin activePlugin;

	@Resource
	private GameParamService gameParamService;

	@Resource
	private GoodsService goodsService;

	@Resource
	private ActiveGoodsService activeGoodsService;


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

		obj.setEtimel(Context.parseTime(date));
		obj.setFlag(1);
		String imagesrc=request.getParameter("imagesrc");
		obj.setImg(imagesrc);
		GameParam gameParam=new GameParam();
		gameActiveService.addObj(gameParam);
		return super.add(request, obj);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Active obj,GameParam gameParam) {
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
		obj.setFlag(1);
		return super.endit(request, obj);
	}

	@Override
	public void initService() {
		super.initService();
		this.baseService=gameActiveService;
		this.business="active";
		this.table="gameActive";
		del=false;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer(" and n.status=0 and n.flag=1");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		if(merchants!=null){
			where.append(" and ( n.role='ADMIN' or n.merchants.shangjia_id="+merchants.getShangjia_id()+") ");
		}else{
			where.append(" and n.role='ADMIN' ");
		}
		return super.list(request, where);
	}

	@RequestMapping("/list/{id}/orderIndex")
	public ModelAndView orderIndex(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("info",discountActiveService.getObjById(id));
		mav.setViewName("/active/gameActive/orderIndex");
		return mav;
	}
	@RequestMapping(value="/list/{id}/orderIndex",method=RequestMethod.PUT)
	public ModelAndView orderIndexPut(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		Active act=(Active) discountActiveService.getObjById(id);
		String goods_ids[]=request.getParameterValues("goods_id");
		String orderIndexs[]=request.getParameterValues("orderIndex");
		String activegoods_id[]=request.getParameterValues("activegoods_id");
		if(goods_ids!=null){
			for(int i=0;i<goods_ids.length;i++){
				ActiveGoods ag=(ActiveGoods) activeGoodsService.getObjById(activegoods_id[i]);
				ag.setAct(act);
				ag.setIdnex(Integer.parseInt(orderIndexs[i]));
				ag.setGoods((Goods)goodsService.getObjById(goods_ids[i]));
				activeGoodsService.updateObj(ag);
			}
		}
		mav.setViewName("redirect:/html/manage/gameActive/list");
		return mav;
	}
	/**
	 * 添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/disAdd")
	public ModelAndView disAdd(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("gameList",gameService.getListByWhere(new StringBuffer(" and n.status=0")));
		mav.setViewName("/"+business+"/"+table+"/add");
		return mav;
	}

	/**
	 * 修改
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		Active active=(Active) gameActiveService.getObjById(id);
		mav.addObject("info", active);
		mav.addAllObjects(activePlugin.getGameParam(active));
		mav.addObject("gameList",gameService.getListByWhere(new StringBuffer(" and n.status=0")));
		mav.setViewName("/"+business+"/"+table+"/update");
		return mav;
	}
	@RequestMapping("/goods/list")
	public ModelAndView Goodslist(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		StringBuffer where =new StringBuffer(" and n.shelves=0  and n.state=0 ");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		where.append(" and n.merchants.shangjia_id="+merchants.getShangjia_id());
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
		Map map=goodsService.getListByPageWhere(where, page);
		mav.addAllObjects(map);
		mav.setViewName("/"+business+"/"+table+"/goodList");
		return mav;
	}
	@RequestMapping("/list/{id}/Goods")
	public ModelAndView count(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("info",discountActiveService.getObjById(id));
		StringBuffer where=new StringBuffer();
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
		where.append(" and g.merchants.shangjia_id="+merchants.getShangjia_id()+" and n.active_id="+id);
		List list=discountActiveService.getGoodListByWhere(where);
		mav.addObject("DATA", list);
		mav.setViewName("/"+business+"/"+table+"/discount");
		return mav;
	}
	@RequestMapping(value="/del/Goods",method=RequestMethod.DELETE)
	public void delGoods(HttpServletRequest request,HttpServletResponse response){
		String actId=request.getParameter("actId");
		String goodId=request.getParameter("goodId");
		discountActiveService.delLink(actId, goodId);
		Active active=(Active) discountActiveService.getObjById(actId);
		active.setCount(active.getCount()-1);
		discountActiveService.updateObj(active);
		ResponseUtil.printl(response, "{\"status\":0}", "json");
	}

	@RequestMapping("/add/{id}/Goods")
	public ModelAndView disCount(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		Active active=(Active) discountActiveService.getObjById(id);
		String[] goods_id=request.getParameterValues("goods_id");
		int count=0;
		List list=new ArrayList();
		for(int i=0;i<goods_id.length;i++){
			Map map=new HashMap();
			map.put("goodID", goods_id[i]);
			map.put("actID", id);
			list.add(map);
			count++;
		}
		active.setCount(active.getCount()+count);
		discountActiveService.updateObj(active);
		discountActiveService.addLink(list);
		mav.setViewName("redirect:/html/manage/"+table+"/list");
		return mav;
	}
}
