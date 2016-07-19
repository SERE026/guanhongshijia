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

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.model.Brand;
import cn.com.dyninfo.o2o.old.model.GoodsType;
import cn.com.dyninfo.o2o.old.model.GoodsTypeSpec;
import cn.com.dyninfo.o2o.old.service.BrandService;
import cn.com.dyninfo.o2o.old.service.GoodsTypeService;

/**
 * 商品类型
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/goodsType")
public class GoodsTypeController extends BaseController{
	 @Resource
	 private BrandService brandService;
	 
     @Resource
     private GoodsTypeService goodsTypeService;
       
     @Override
	 public void initService(){
		 super.initService();
		 this.baseService=goodsTypeService;
		 this.business="shangpin";
		 this.table="goodsType";
	 }
	      /**
			 * 鍒楄〃
			 * 
			 * @param request
			 * @return
			 */
		@RequestMapping("/list")
		public ModelAndView list(HttpServletRequest request) {
			StringBuffer buff=null;
			 ModelAndView mav=new ModelAndView();
			PageInfo page = new PageInfo();
			// 鍒嗛〉
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
			buff.append("and status ='0'");
			buff.append("  order by n.goodsType_id desc ");
			mav.addAllObjects(this.goodsTypeService.getListByPageWhere(buff, page));
			mav.setViewName("/shangpin/goodsType/list");
			return mav;
		}
		
		@Override
		@RequestMapping(value="/disAdd")
		public ModelAndView disAdd(HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			mav.addObject("brandList", brandService.getListByWhere(new StringBuffer(" and n.status='0' and n.flag='0' ")));
			mav.setViewName("/shangpin/goodsType/add");
			return mav;
		}
		
		/**
		 * 修改
		 * @param id
		 * @param request
		 * @return
		 */
		 @Override
		@RequestMapping(value="/{id}/disUpdate")
		public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			initService();
			try{
				mav.addObject("info",goodsTypeService.getObjById(id));
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.addObject("brandList", brandService.getListByWhere(new StringBuffer(" and n.status='0' and n.flag='0' ")));
			mav.setViewName("/shangpin/goodsType/update");
			return mav;
		}
	      /**
			 * 娣诲姞
			 * 
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,GoodsType info){
	    	    ModelAndView mav=new ModelAndView();
	    	    try {
	    	    	if(info.getLinkBrank().equals("1")){
		    	    	String ids[]=request.getParameterValues("brands");
		    	    	List brandList=new ArrayList();
		    	    	//关联品牌
		    	    	if(ids!=null){
		    	    		for(String id:ids){
		    	    			Brand b=(Brand) brandService.getObjById(id);
		    	    			brandList.add(b);
		    	    			info.setBrandList(brandList);
		    	    		}
		    	    	}
	    	    	}
	    	    	if(info.getOwnSpec().equals("1")){
	    	    		List specList=new ArrayList();
	    	    		String specNames[]=request.getParameterValues("specName");
	    	    		String specFlags[]=request.getParameterValues("specFlag");
	    	    		String specVals[]=request.getParameterValues("specVal");
	    	    		if(specNames!=null){
	    	    			for(int i=0;i<specNames.length;i++){
	    	    				GoodsTypeSpec spec=new GoodsTypeSpec();
	    	    				spec.setFlag(specFlags[i]);
	    	    				spec.setSpec_name(specNames[i]);
	    	    				spec.setValStr(specVals[i]);
	    	    				spec.setType(info);
	    	    				specList.add(spec);
	    	    			}
	    	    		}
	    	    		info.setSpecList(specList);
	    	    	}
	    	    	goodsTypeService.addObj(info);
					mav.addObject("C_STATUS",1);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    			mav.addObject("C_STATUS", 0);
	    		}
	    		mav.setViewName("redirect:/html/manage/goodsType/list");
	    		return mav;
	      }
	      
	      /**
		   * 鏇存敼
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,GoodsType info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  if(info.getLinkBrank().equals("1")){
		    	    	String ids[]=request.getParameterValues("brands");
		    	    	List brandList=new ArrayList();
		    	    	//关联品牌
		    	    	if(ids!=null){
		    	    		for(String id:ids){
		    	    			Brand b=(Brand) brandService.getObjById(id);
		    	    			brandList.add(b);
		    	    			info.setBrandList(brandList);
		    	    		}
		    	    	}
	    	    	}
	    	    	if(info.getOwnSpec().equals("1")){
	    	    		List specList=new ArrayList();
	    	    		String specNames[]=request.getParameterValues("specName");
	    	    		String specFlags[]=request.getParameterValues("specFlag");
	    	    		String specVals[]=request.getParameterValues("specVal");
	    	    		if(specNames!=null){
	    	    			for(int i=0;i<specNames.length;i++){
	    	    				GoodsTypeSpec spec=new GoodsTypeSpec();
	    	    				spec.setFlag(specFlags[i]);
	    	    				spec.setSpec_name(specNames[i]);
	    	    				spec.setValStr(specVals[i]);
	    	    				spec.setType(info);
	    	    				specList.add(spec);
	    	    			}
	    	    		}
	    	    		info.setSpecList(specList);
	    	    	}
				  goodsTypeService.updateObj(info);
				mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				mav.setViewName("redirect:/html/manage/goodsType/list");
				return mav;
		  }
		  
		  /**
		   * 鍒犻櫎
		   * @param id
		   * @param request
		   * @param response
		   * @return
		   */
		  @RequestMapping(value="/{id}/del",method=RequestMethod.GET)
		  public ModelAndView del(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
			  GoodsType info=null;
			  ModelAndView mav=new ModelAndView();
			    try {
				    info=(GoodsType) goodsTypeService.getObjById(id);
				    info.setStatus("1");
				    goodsTypeService.updateObj(info);
				}catch(Exception e){
					e.printStackTrace();
				}
				mav.setViewName("redirect:/html/manage/goodsType/list");
				return mav;
		  }
		  
		  @RequestMapping(value="/all/del",method=RequestMethod.DELETE)
			public ModelAndView delete(HttpServletRequest request){
				initService();
				ModelAndView mav=new ModelAndView();
				try{
					String ids[]=request.getParameterValues("list");
					if(ids!=null){
						for(String id:ids){
							GoodsType	 info=(GoodsType) goodsTypeService.getObjById(id);
							    info.setStatus("1");
							    goodsTypeService.updateObj(info);
						}
					}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				
				mav.setViewName("redirect:/html/manage/goodsType/list");
				return mav;
			}
}
