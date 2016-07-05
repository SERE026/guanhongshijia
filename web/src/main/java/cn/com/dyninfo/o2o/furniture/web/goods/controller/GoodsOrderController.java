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

package cn.com.dyninfo.o2o.furniture.web.goods.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PagModInGoods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.PageModule;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PageModuleService;

/***
 * 商品排序
 * @author 008
 *
 */
@Controller
@RequestMapping("/manage/goodsOrder")
public class GoodsOrderController {


	@Resource
	private PageModuleService pageModuleService;

	@Resource
	private PagModInGoodsService pagModInGoodsService;
	@Resource
	private AreaService areaService;

	@Resource
	private GoodsService goodsService;
	@RequestMapping("/area/list")
	public ModelAndView areaList(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		request.getSession().removeAttribute("goodOrderArea");
		mav.setViewName("/shangpin/goodsOrder/areaList");
		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer buff=null;
		PageInfo page = new PageInfo();
		String cityId=request.getParameter("cityId");
		if(cityId!=null&&cityId.length()>0){
			AreaInfo area=(AreaInfo) areaService.getObjById(cityId);
			if(area!=null){
				request.getSession().setAttribute("goodOrderArea", area);
			}
		}
		// 分页
		ModelAndView mav=new ModelAndView();
		page.setPageSize(25);
		if (request.getParameter("pageNo") != null&& request.getParameter("pageNo").length() > 0) {
			Pattern pattern = Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if (m.matches()) {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		} else{
			page.setPageNo(1);
		}
		buff=new StringBuffer();

		mav.addAllObjects(pageModuleService.getListByPageWhere(buff, page));
		mav.setViewName("/shangpin/goodsOrder/list");
		return mav;
	}

	@RequestMapping("/goods/list")
	public ModelAndView GoodsList(HttpServletRequest request) {
		StringBuffer buff=null;
		PageInfo page = new PageInfo();
		String pageModule_id=request.getParameter("pageModule_id");
		// 分页
		ModelAndView mav=new ModelAndView();
		page.setPageSize(25);
		if (request.getParameter("pageNo") != null&& request.getParameter("pageNo").length() > 0) {
			Pattern pattern = Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if (m.matches()) {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		} else{
			page.setPageNo(1);
		}
		buff=new StringBuffer();
		String selectId=request.getParameter("selectId");
		if(selectId==null)
			selectId="";
		String select[]=request.getParameterValues("select");
		if(select!=null){
			for(String sID:select){
				if(selectId.indexOf(sID)<0){
					selectId+=sID+",";
				}
			}
		}
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		String shopName=request.getParameter("shopName");
		if(code!=null&&code.length()>0){
			buff.append(" and n.goods_id="+code);
			mav.addObject("code", code);
		}
		if(name!=null&&name.length()>0){
			buff.append(" and n.name like '%"+name+"%'");
			mav.addObject("name", name);
		}
		if(shopName!=null&&shopName.length()>0){
			buff.append(" and n.merchants.name like '%"+shopName+"%'");
			mav.addObject("shopName", shopName);
		}
		AreaInfo area=(AreaInfo) request.getSession().getAttribute("goodOrderArea");
		if(area!=null){
			buff.append(" and n.merchants.city.id='"+area.getId()+"' ");
		}
		if(pageModule_id.equals("44")){//会员换购产品
			buff.append(" and n.ishg=0 ");
		}
		if(pageModule_id.equals("37")){//会员换购产品
			buff.append(" and n.shelves=0 ");
			mav.addAllObjects(goodsService.getListActGoodsByPage(buff, page));
		}else if(pageModule_id.equals("36")){//会员换购产品
			buff.append(" and n.shelves=0 ");
			mav.addAllObjects(goodsService.getListActGoodsByPage(buff, page));
		}else{
			buff.append(" and n.shelves=0 ");
			pageModule_id = "," + pageModule_id + ",";
//			buff.append(" and n.biaoqian like '%" + pageModule_id + "%'"); // 只查找属于该模块下的商品，而非全部商品
			buff.append(" and n.biaoqian like '%"+pageModule_id+"%'");
			mav.addAllObjects(goodsService.getListByPageWhere(buff, page));
		}
		
			
		mav.addObject("selectId", selectId);
		mav.addObject("pageModule_id", request.getParameter("pageModule_id"));
		
	
		
		mav.setViewName("/shangpin/goodsOrder/GoodsList");
		return mav;
	}
	
	@RequestMapping(value="/{id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			try{
				StringBuffer where=new StringBuffer(" and n.pageModule.pageModule_id="+id);
				PageInfo page = new PageInfo();
				page.setPageSize(25);
				if (request.getParameter("pageNo") != null&& request.getParameter("pageNo").length() > 0) {
					Pattern pattern = Pattern.compile("^[0-9]+$");
					Matcher m = pattern.matcher(request.getParameter("pageNo"));
					if (m.matches()) {
						page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
					}
				} else{
					page.setPageNo(1);
				}
				AreaInfo area=(AreaInfo) request.getSession().getAttribute("goodOrderArea");
				if(area!=null){
					where.append(" and n.city.id='"+area.getId()+"' ");
				}else{
					where.append(" and n.city.id is null ");
				}
				mav.addObject("info", pageModuleService.getObjById(id));
				where.append(" order by n.indexs asc ");
				Map map=pagModInGoodsService.getListByPageWhere(where, page);
				mav.addAllObjects(map);
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.addObject("pxid", id);
			mav.setViewName("/shangpin/goodsOrder/update");
			return mav;
		}
	@RequestMapping(value="/save/{id}/disUpdate",method=RequestMethod.PUT)
	public ModelAndView save(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String saveId= request.getParameter("saveId");
		List list=new ArrayList();
		if(saveId!=null){
			String saveIds[]=saveId.split(",");
			for(String idx:saveIds){
				if(idx.indexOf("|")>=0){
					idx=idx.substring(1,idx.length()-1);
				}
				list.add(idx);
			}
		}
		mav.addObject("info", pageModuleService.getObjById(id));
		mav.addObject("GoodsList", pagModInGoodsService.getGoods(list));
		mav.setViewName("/shangpin/goodsOrder/addGoods");
		return mav;
	}
	@RequestMapping(value="/addGoods/{id}/disUpdate",method=RequestMethod.PUT)
	public ModelAndView addGoodsdisUpdate(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		AreaInfo area=(AreaInfo) request.getSession().getAttribute("goodOrderArea");
		PageModule info=(PageModule) pageModuleService.getObjById(id);
		String goods_id[]= request.getParameterValues("goods_id");
		String goods_index[]= request.getParameterValues("goods_index");
		if(goods_id!=null){
			List list=new ArrayList();
			for(int i=0;i<goods_id.length;i++){
				PagModInGoods pmg=pagModInGoodsService.getModeGods(id, goods_id[i],area);
				if(pmg==null){
					pmg=new PagModInGoods();
					pmg.setPagModInGoods_id(0);
				}
				Goods goods= (Goods) goodsService.getObjById(goods_id[i]);
				pmg.setGoods(goods);
				pmg.setShangJiaInfo(goods.getMerchants());
				pmg.setIndexs(Integer.parseInt(goods_index[i]));
				pmg.setPageModule(info);

				if(area!=null){
					pmg.setCity(area);
				}
				if(pmg.getPagModInGoods_id()==0)
					list.add(pmg);
				else
					pagModInGoodsService.updateObj(pmg);
			}
			info.setGoodsList(list);
		}
		this.pageModuleService.updateObj(info);
		mav.setViewName("/shangpin/goodsOrder/close");
		return mav;
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request,PageModule info){
		ModelAndView mav=new ModelAndView();
		try {
			AreaInfo area=(AreaInfo) request.getSession().getAttribute("goodOrderArea");
			info=(PageModule) pageModuleService.getObjById(""+info.getPageModule_id());
			String goods_id[]= request.getParameterValues("goods_id");
			String goods_index[]= request.getParameterValues("goods_index");
			if(goods_id!=null){
				List list=new ArrayList();
				for(int i=0;i<goods_id.length;i++){
					PagModInGoods pmg=pagModInGoodsService.getModeGods(""+info.getPageModule_id(), goods_id[i],area);
					if(pmg!=null){
						Goods goods= (Goods) goodsService.getObjById(goods_id[i]);
						pmg.setGoods(goods);
						pmg.setShangJiaInfo(goods.getMerchants());
						pmg.setIndexs(Integer.parseInt(goods_index[i]));
						pmg.setPageModule(info);
						pagModInGoodsService.updateObj(pmg);
					}
				}
			}

			this.pageModuleService.updateObj(info);
			mav.addObject("C_STATUS",1);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/goodsOrder/list");
		return mav;
	}

	/**
	 * 删除
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/{id}/del",method=RequestMethod.POST)
	public void del(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		String json="{\"status\":1}";
		PagModInGoods info=null;
		try {


			info=(PagModInGoods) pagModInGoodsService.getObjById(id);
			pagModInGoodsService.delObj(info);
		}catch(Exception e){
			e.printStackTrace();
			json="{\"status\":0}";
		}
		ResponseUtil.printl(response, json, "json");
	}

	@RequestMapping(value="/all/del",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			String ids[]=request.getParameterValues("list");
			if(ids!=null){
				for(String id:ids){
					PagModInGoods	 info=(PagModInGoods) pageModuleService.getObjById(id);
					pageModuleService.delObj(info);
				}
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);

		}

		mav.setViewName("redirect:/html/manage/goodsOrder/list");
		return mav;
	}
}
