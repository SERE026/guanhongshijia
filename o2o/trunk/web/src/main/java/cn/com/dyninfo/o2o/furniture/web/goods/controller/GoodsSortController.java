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

import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.util.PinYinUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.goods.model.GoodsSort;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsSortService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsTypeService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/**
 * 商品分类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/goodsSort")
public class GoodsSortController extends BaseController{

     @Resource
     private GoodsSortService goodsSortService;
     @Resource
     private GoodsTypeService goodsTypeService;
     @Override
	 public void initService(){
		 super.initService();
		 this.baseService=goodsSortService;
		 this.business="shangpin";
		 this.table="goodsSort";
	 }
     
     @RequestMapping("/main/list")
     public ModelAndView main(HttpServletRequest request) {
    	 ModelAndView mav=new ModelAndView();
    	 mav.setViewName("/shangpin/goodsSort/mainFrams");
    	 return mav;
     }
     /**
	 * 树列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/tree")
	public void Treelist(HttpServletRequest request,HttpServletResponse response) {
		StringBuffer where=new StringBuffer(" and n.status=0 ");
		String json="[";
		String parentId=request.getParameter("parentId");
		if(parentId!=null&&parentId.length()>1){
			where.append(" and n.parent.goodsSort_id='"+parentId+"' ");
		}else{
			where.append(" and n.parent.goodsSort_id is null ");
		}
		String flag=request.getParameter("flag");
		if("xy".equals(flag)){
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			if(merchants!=null){
				where.append(" and n.flag='1'  and n.merchants.shangjia_id='"+merchants.getShangjia_id()+"' ");
			}else{
				where.append(" and n.flag='0' ");
			}
		}else{
			where.append(" and n.flag='0' ");
		}
		List<GoodsSort> list=(List<GoodsSort>) goodsSortService.getListByWhere(where);
		//
		for(GoodsSort sort : list){
			json+="{\"id\":\""+sort.getGoodsSort_id()+"\",\"name\":\""+sort.getName()+"\"},";
		}
		if(json.charAt(json.length()-1)==','){
			json=json.substring(0,json.length()-1);
		}
		json+="]";
		ResponseUtil.printl(response,json, "json");
	}
	      /**
			 * 列表
			 * 
			 * @param request
			 * @return
			 */
		@RequestMapping("/list")
		public ModelAndView list(HttpServletRequest request) {
			StringBuffer buff=null;
			PageInfo page = new PageInfo();
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
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			if(merchants!=null){
				buff.append(" and n.flag='1'  and n.merchants.shangjia_id="+merchants.getShangjia_id());
			}else{
				buff.append(" and n.flag='0' ");
			}
			String parent=request.getParameter("parent");
			if(parent!=null&&parent.length()>0){
				buff.append("and status ='0' and n.parent.goodsSort_id = '"+parent+"'");
				mav.addObject("parent", parent);
			}else{
				buff.append("and status ='0' and n.parent.goodsSort_id is null ");
			}
			mav.addAllObjects(this.goodsSortService.getListByPageWhere(buff, page));
			mav.setViewName("/shangpin/goodsSort/list");
			return mav;
		}
		
		@Override
		@RequestMapping(value="/disAdd")
		public ModelAndView disAdd(HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			StringBuffer buff=new StringBuffer(" and n.status='0'");
			mav.addObject("typeList", goodsTypeService.getListByWhere(buff));
			String parent=request.getParameter("parent");
			mav.addObject("parent", goodsSortService.getObjById(parent));
			mav.setViewName("/shangpin/goodsSort/add");
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
				mav.addObject("info",goodsSortService.getObjById(id));
			}catch(Exception e){
				e.printStackTrace();
			}
			String parent=request.getParameter("parent");
			mav.addObject("parent", parent);
			StringBuffer buff=new StringBuffer(" and n.status='0'");
			mav.addObject("typeList", goodsTypeService.getListByWhere(buff));
			mav.addObject("parent", goodsSortService.getObjById(parent));
			mav.setViewName("/shangpin/goodsSort/update");
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
	      public ModelAndView add(HttpServletRequest request,GoodsSort info){
	    	    ModelAndView mav=new ModelAndView();
	    	    try {
	    	    	ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
	    			if(merchants!=null){
	    				info.setMerchants(merchants);
	    				info.setFlag("1");
	    			}else{
	    				info.setFlag("0");
	    			}
	    	    	if(request.getParameter("parentGoodsSort_id").length()==0){
	    	    		info.setParent(null);
	    	    	}else{
	    	    		GoodsSort parent=new GoodsSort();
	    	    		parent.setGoodsSort_id(Integer.parseInt(request.getParameter("parentGoodsSort_id")));
	    	    		info.setParent(parent);
	    	    	}
	    	    	if(info.getParent()!=null)
	    	    		mav.addObject("parent", info.getParent().getGoodsSort_id());
					info.setPinyinName(PinYinUtils.getFirstSpell(info.getName()));
	    	    	goodsSortService.addObj(info);
					mav.addObject("C_STATUS",1);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    			mav.addObject("C_STATUS", 0);
	    		}
	    		
	    		mav.setViewName("redirect:/html/manage/goodsSort/list");
	    		return mav;
	      }
	      
	      /**
		   * 更改
		   * @param request
		   * @param info
		   * @return
		   */
		  @RequestMapping(method=RequestMethod.PUT)
		  public ModelAndView endit(HttpServletRequest request,GoodsSort info){
			  ModelAndView mav=new ModelAndView();
			  try {
				  ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
	    		  if(merchants!=null){
	    				info.setMerchants(merchants);
	    				info.setFlag("1");
	    		  }else{
	    				info.setFlag("0");
	    			}
				  if(request.getParameter("parentGoodsSort_id").length()==0){
	    	    		info.setParent(null);
	    	    	}else{
	    	    		GoodsSort parent=new GoodsSort();
	    	    		parent.setGoodsSort_id(Integer.parseInt(request.getParameter("parentGoodsSort_id")));
	    	    		info.setParent(parent);
	    	    	}
				  if(info.getParent()!=null)
					mav.addObject("parent", info.getParent().getGoodsSort_id());
				  info.setPinyinName(PinYinUtils.getFirstSpell(info.getName()));
				  goodsSortService.updateObj(info);
				mav.addObject("C_STATUS",1);
				} catch (Exception e) {
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				mav.setViewName("redirect:/html/manage/goodsSort/list");
				return mav;
		  }
		  
		  /**
		   * 删除
		   * @param id
		   * @param request
		   * @param response
		   * @return
		   */
		  @RequestMapping(value="/{id}/del",method=RequestMethod.GET)
		  public ModelAndView del(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
			  GoodsSort info=null;
			  ModelAndView mav=new ModelAndView();
			    try {
				    info=(GoodsSort) goodsSortService.getObjById(id);
				    info.setStatus("1");
				    if(info.getParent()!=null)
				    	mav.addObject("parent", info.getParent().getGoodsSort_id());
				    goodsSortService.updateObj(info);
				}catch(Exception e){
					e.printStackTrace();
				}
				mav.setViewName("redirect:/html/manage/goodsSort/list");
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
							GoodsSort	 info=(GoodsSort) goodsSortService.getObjById(id);
							info.setStatus("1");
						    goodsSortService.updateObj(info);
							mav.addObject("parent", info.getParent().getGoodsSort_id());
						}
					}
					mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				
				}
				
				mav.setViewName("redirect:/html/manage/goodsSort/list");
				return mav;
			}
		  
		  
		  @RequestMapping("/xml/selection")
			public void jsonselection(HttpServletRequest request,HttpServletResponse response) {
				String goodsSort_id=request.getParameter("goodsSort_id");
				StringBuffer buff=new StringBuffer((goodsSort_id.length()>0?" and n.parent.goodsSort_id='"+goodsSort_id+"'":"and n.parent.goodsSort_id is null ")+" and n.status='0' ");
				ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
				if(merchants!=null)
					buff.append(" and n.flag='1' and n.merchants.shangjia_id="+merchants.getShangjia_id());
				else{
					buff.append(" and n.flag='0' ");
				}
				List<GoodsSort> list=(List<GoodsSort>) goodsSortService.getListByWhere(buff);
				PrintWriter pw = null;
				try{
					response.setCharacterEncoding("utf-8");
					response.setContentType("text/xml");
					pw = response.getWriter();
					StringBuffer str = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
					str.append("<root>");
					for(GoodsSort sort : list){
						str.append("<item id='").append(sort.getGoodsSort_id()).append("' ");
						str.append("parent_id='");
						str.append(goodsSort_id).append("' ");
						if(sort.getChildren().size()>0){
							str.append("state='closed'>");
						}else{
							str.append(" visible='false' rel='leaf' >");
						}
						str.append("<content><name>");
						str.append(sort.getName());
						str.append("</name><rel>leaf</rel></content>");
						str.append("</item>");
					}
					str.append("</root>");
					pw.write(str.toString());
					pw.flush();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pw != null){
						try{
							pw.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}
		  /**
			 * 弹出选择框
			 * @param request
			 * @return
			 */
			@RequestMapping("/selection")
			public ModelAndView selection(HttpServletRequest request) {
				ModelAndView mav = new ModelAndView();
				String fieldId = request.getParameter("fieldId");//ID存放组件ID(必须)
				String fieldName = request.getParameter("fieldName");//名称存放组件ID(必须)
				mav.addObject("fieldId", fieldId);
				mav.addObject("fieldName", fieldName);
				String single = request.getParameter("single");//是否单选(默认为否)
				if(single == null || single.equals(""))
					single = "false";
				mav.addObject("single", single);
				String maxSelect = request.getParameter("maxSelect");//最多选择数量（可选）
				if(maxSelect != null && !maxSelect.equals(""))
					mav.addObject("maxSelect", maxSelect);
				mav.setViewName("/shangpin/goodsSort/dialogSelection");
				return mav;
			}
}
