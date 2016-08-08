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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.android.model.AadvInfo;
import cn.com.dyninfo.o2o.furniture.android.model.AdvGoods;
import cn.com.dyninfo.o2o.furniture.android.service.AadvService;
import cn.com.dyninfo.o2o.furniture.android.service.AadvwzService;
import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;

/**
 * 广告管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/aadv")
public class AadvController extends BaseController{

	   @Resource
	   private AadvService aadvService;
	   
	   @Resource
	   private AadvwzService aadvwzService;
	   
	   @Resource
	   private AreaService areaService;
	   
	   @Resource
	   private GoodsService goodsService;
	   
	   @Override
		 public void initService(){
			 super.initService();
			 this.baseService=aadvService;
			 this.business="android";
			 this.table="aadv";
		 }
	   /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/area/list")
	     public ModelAndView area(HttpServletRequest request){
	    	
	    	ModelAndView mav= new ModelAndView();
	    	request.getSession().removeAttribute("advOrderArea");
	 		mav.setViewName("/android/aadv/areaList");
	 		return mav;
	     }
	    /**
	      * 列表
	      * @param request
	      * @return
	      */
	     @RequestMapping("/list")
	     public ModelAndView list(HttpServletRequest request){
		    	 StringBuffer where=new StringBuffer();
		    	 String name=request.getParameter("name");
		    	 if(name!=""&&name!=null){
		    	   	 where.append("and n.name like'%").append(name).append("%'");
		    	 }
		    	 String cityId=request.getParameter("cityId");
		    	 AreaInfo area=(AreaInfo) areaService.getObjById(cityId);
		    	 if(area!=null){
			    	 request.getSession().setAttribute("advOrderArea", area);
			    	 where.append(" and n.city.id='"+area.getId()+"' ");
		    	 }
		    	 where.append(" order by n.aadvwz.aadvwz_id,n.orderIndex");
		    	 ModelAndView mva= super.list(request, where);
		    	 mva.addObject("name", name);
	         return mva;
	     }
	     
	 	/**
	 	 * 添加
	 	 * @param request
	 	 * @return
	 	 */
	 	@RequestMapping(value="/disAdd")
	 	public ModelAndView disAdd(HttpServletRequest request){
	 		ModelAndView mav=new ModelAndView();
	 		List list=aadvwzService.getListByWhere(new StringBuffer());
	 		mav.addObject("advwz", list);
	 		mav.setViewName("/android/aadv/add");
	 		return mav;
	 	}
	 	
	     /**
			 * 添加
			 * 
			 * @param request
			 * @param info
			 * @return
			 */
	      @RequestMapping(method=RequestMethod.POST)
	      public ModelAndView add(HttpServletRequest request,AadvInfo info){
	    	    ModelAndView mav=new ModelAndView();
	    	    String[] goods_id=request.getParameterValues("goods_id");
	    	    String[] orderIndex=request.getParameterValues("orderIndex");
	    	    AreaInfo area=(AreaInfo) request.getSession().getAttribute("advOrderArea");
	    	    info.setCity(area);
	    	    if(area!=null){
	    	    	mav.addObject("cityId", area.getId());
	    	    }
	    	    List<AdvGoods> list=new ArrayList();
	    	    AdvGoods advGoods=null;
	    	    if(goods_id!=null){
		    	    for(int i=0;i<goods_id.length;i++){
		    	    	advGoods=new AdvGoods();
		    	    	advGoods.setAdv(info);
		    	    	advGoods.setCity(area);
		    	    	advGoods.setOrderIndex(Integer.parseInt(orderIndex[i]));
		    	    	advGoods.setGoods((Goods)goodsService.getObjById(goods_id[i]));
		    	    	list.add(advGoods);
		    	    }
	    	    }
	    	    info.setGoods(list);
	    	    aadvService.addObj(info);
	    		mav.setViewName("redirect:/html/manage/aadv/list");
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
	  		AadvInfo adv=(AadvInfo) aadvService.getObjById(id);
	  		List list=aadvwzService.getListByWhere(new StringBuffer());
	 		mav.addObject("advwz", list);
	 		mav.addObject("info", adv);
	 		String city="";
	 		AreaInfo area=(AreaInfo) request.getSession().getAttribute("advOrderArea");
		    	if(area!=null){
		    		city=area.getId();
		    	}
	 		if(adv.getAadvwz().getAadvwz_id()>1){
	 			List<AdvGoods> Goodlist=aadvService.getGoodsByadv(id, city);
	 			mav.addObject("Goodlist", Goodlist);
	 			mav.addObject("isGD", true);
	 		}
	 		
	  		mav.setViewName("/android/aadv/update");
	  		return mav;
	  	}
	  	
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,AadvInfo info){
			  ModelAndView mav=new ModelAndView();
			  aadvService.updateObj(info);
			  AreaInfo area=(AreaInfo) request.getSession().getAttribute("advOrderArea");
			  if(area!=null){
	    	    	mav.addObject("cityId", area.getId());
	    	  }
			  mav.setViewName("redirect:/html/manage/aadv/list");
			  return mav;
		  }
		  
		  
		  @RequestMapping("/goods/list")
			public ModelAndView Goodslist(HttpServletRequest request) {
				ModelAndView mav=new ModelAndView();
				StringBuffer where =new StringBuffer(" and n.shelves=0  and n.state=0 ");
				String code=request.getParameter("code");
				String name=request.getParameter("name");
				String aadv_id=request.getParameter("aadv_id");
				mav.addObject("aadv_id", aadv_id);
				AreaInfo area=(AreaInfo) request.getSession().getAttribute("advOrderArea");
				if(area!=null){
					where.append(" and n.merchants.city.id='"+area.getId()+"' ");
				}
				if(aadv_id.equals("2")||aadv_id.equals("3")||aadv_id.equals("4")||
						aadv_id.equals("5")||aadv_id.equals("6")
						){
					where.append(" and n.biaoqian like '%,android_adv_"+aadv_id+",%'");
				}
				
				//ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute(Constants.SESSION_MERCHANTS);
				if(code!=null&&!code.equals("")){
					where.append(" and n.code="+code);
				}
				if(name!=null&&!name.equals("")){
					where.append(" and n.name like '%"+name+"%'");
				}
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
				mav.addObject("name", name);
				mav.addObject("code", code);
				mav.setViewName("/android/aadv/goodList");
				return mav;
			}
	  
}
