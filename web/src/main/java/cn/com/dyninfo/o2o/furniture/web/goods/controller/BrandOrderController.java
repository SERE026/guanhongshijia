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

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.BrandOrder;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandOrderService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.BrandService;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;

/**
 * 设置品牌排序
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/brandOrder")
public class BrandOrderController  {

	@Resource
	private BrandOrderService brandOrderService;
	@Resource
	private AreaService areaService;
	@Resource
	private ShangJiaService shangJiaService;
	

    @Resource
    private BrandService brandService;
	
	@RequestMapping("/area/list")
	public ModelAndView areaList(HttpServletRequest request) {
    	ModelAndView mav=new ModelAndView();
    	request.getSession().removeAttribute("BrandOrderArea");
		mav.setViewName("/shangpin/brandOrder/areaList");
		return mav;
	}
	 @RequestMapping("/merchant/list")
		public ModelAndView merchant(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mav=new ModelAndView();
			PageInfo page=new PageInfo();
			page.setPageSize(25);
			String pageNo=request.getParameter("pageNo");
			if(pageNo==null||pageNo.length()==0){
				pageNo="1";
			}
			page.setPageNo(Integer.parseInt(pageNo));
			StringBuffer where=new StringBuffer(" and n.state=0 ");
			AreaInfo area=(AreaInfo) request.getSession().getAttribute("BrandOrderArea");
			
			if(area!=null){
				where.append(" and n.city.id="+area.getId());
			}
			where.append(" and n.city.id is not null ");
			String name=request.getParameter("name");
			if(name!=null&&name.length()>0){
				where.append(" and n.name like '%"+name+"%' ");
				mav.addObject("name", name);
			}
			mav.addAllObjects(shangJiaService.getListByPageWhere(where, page));
			mav.setViewName("/shangpin/brandOrder/shoplist");
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
				request.getSession().setAttribute("BrandOrderArea", area);
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
		
		AreaInfo area=(AreaInfo) request.getSession().getAttribute("BrandOrderArea");
		if(area!=null){
			buff.append(" and n.city.id="+area.getId());
		}else{
			buff.append(" and n.city.id is null ");
		}
		
		
		mav.addAllObjects(brandOrderService.getListByPageWhere(buff, page));
		mav.setViewName("/shangpin/brandOrder/list");
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
		mav.addObject("brandList", brandService.getListByWhere(new StringBuffer(" and n.flag='0' and status = '0'")));
		mav.setViewName("/shangpin/brandOrder/add");
		return mav;
	}
	/**
	 * 保存
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,BrandOrder obj){
		ModelAndView mav=new ModelAndView();
		AreaInfo area=(AreaInfo) request.getSession().getAttribute("BrandOrderArea");
		obj.setCity(area);
		brandOrderService.addObj(obj);
		mav.setViewName("redirect:/html/manage/brandOrder/list");
		return mav;
		
	}
	
	/**
	 * 保存
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView edit(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String ids[]=request.getParameterValues("list");
		String indexs[]=request.getParameterValues("indexs");
		
		if(ids!=null){
			for(int i=0;i<ids.length;i++){
				String id=ids[i];
				BrandOrder order=(BrandOrder) brandOrderService.getObjById(id);
				order.setIndexs(indexs[i]);
				brandOrderService.updateObj(order);
			}
		}
		mav.setViewName("redirect:/html/manage/brandOrder/list");
		return mav;
	}
	
	/**
	 * 删除 表单 name=“list” 的对象
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/all/del",method=RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		try{
			String ids[]=request.getParameterValues("list");
			
			if(ids!=null){
				for(String id:ids){
					brandOrderService.delObjById(id);
				}
			}
			
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		
		}
		
		mav.setViewName("redirect:/html/manage/brandOrder/list");
		return mav;
	}
	
	/**
	 * 删除 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/del")
	public ModelAndView del(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
	
		brandOrderService.delObjById(id);
		mav.setViewName("redirect:/html/manage/brandOrder/list");
		return mav;
	}
	
}
