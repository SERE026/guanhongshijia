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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import cn.com.dyninfo.o2o.furniture.util.StringUtil;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.Goods;
import cn.com.dyninfo.o2o.old.model.GoodsSort;
import cn.com.dyninfo.o2o.old.model.GoodsType;
import cn.com.dyninfo.o2o.old.model.PageModule;
import cn.com.dyninfo.o2o.old.service.BrandService;
import cn.com.dyninfo.o2o.old.service.GoodsService;
import cn.com.dyninfo.o2o.old.service.GoodsSortService;
import cn.com.dyninfo.o2o.old.service.GoodsTypeService;
import cn.com.dyninfo.o2o.old.service.PageModuleService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;
import cn.com.dyninfo.o2o.old.service.DlytypeService;

/**
 * 品牌
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/goods")
public class GoodsController {

	@Resource
	private DlytypeService dlytypeService;
	@Resource
	private GoodsService goodsService;

	@Resource
	private GoodsSortService goodsSortService;

	@Resource
	private GoodsTypeService goodsTypeService;

	@Resource
	private BrandService brandService;

	@Resource
	private ShangJiaService shangJiaService;
	
	@Resource
	private PageModuleService pageModuleService;
	

	@RequestMapping("/select/list")
	public ModelAndView selected(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/shangpin/goods/select");
		return mav;
	}

	@RequestMapping("/goodsJsonPage/list")
	public ModelAndView goodsJsonPage(HttpServletRequest request,
			HttpServletResponse response) {
		String shanJia = request.getParameter("shanJia");


		PageInfo page = new PageInfo();
		StringBuffer where = new StringBuffer();
		page.setPageSize(10);
		if (request.getParameter("pageNo") != null
				&& request.getParameter("pageNo").length() > 0) {
			Pattern pattern = Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if (m.matches()) {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		} else {
			page.setPageNo(1);
		}
		if (shanJia != null && !"".equals(shanJia)) {
			where.append(" and n.merchants.name like '%").append(shanJia).append("%'");
		}
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
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
			where.append(" and n.merchants.city.id in "+ids);
		}
		Map map=goodsService.getListByPageWhere(where, page);
		page=(PageInfo) map.get("PAGE_INFO");
		String json="";
		List<Goods> list=(List) map.get("DATA");
		json+="{\"pageNo\":\""+page.getPageNo()+"\",\"pageSize\":\""+page.getTotalpage();
		json+="\",\"data\":[";
		for(Goods info:list){
			json+="{\"id\":\""+info.getGoods_id()+"\",\"name\":\""+info.getName()+"\",\"shangJia\":\""+info.getMerchants().getName()+"\"},"	;
		}

		json+="]}";
		json=json.replace("},]}", "}]}");
//		System.out.print(json);
		ResponseUtil.printl(response, "["+json+"]", "text/json");
		return null;
	}


	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		StringBuffer where=new StringBuffer();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 0;
		if ((request.getParameter("pageNo") != null)) {
			no = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (no > 0) {
			page.setPageNo(no);
		} else
			page.setPageNo(1);
		where.append("and n.state='0'");
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			where.append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'");
		}
		String code=request.getParameter("code");
		if(code!=null&&!"".equals(code)){
			where.append(" and n.code like '%").append(code).append("%'");
		}
		String name=request.getParameter("name");
		if(name!=null&&!"".equals(name)){
			where.append(" and n.name like '%").append(name).append("%'");
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
			where.append(" and n.merchants.city.id in "+ids);
		}
		
		where.append(" order by indexs,code");
		HashMap<String, ?> data = goodsService.getListByPageWhere(where, page);
		// 保存商品标签名字，便于页面加载
		List<Goods> goodsList = (List<Goods>)data.get("DATA");
		List<String> bqNameList = new ArrayList<String>(); 
		
		for (int i=0; i<goodsList.size(); i++) {
			Goods g = goodsList.get(i);
			String bqTemp = g.getBiaoqian();
			// 做防空指针处理
			if (bqTemp != null && !"".equals(bqTemp.trim())) {
				//System.out.println("标签不为空===================");
				
				String[] bq = bqTemp.split(",");
				String bqName = "";
				for (int j=0; j<bq.length; j++) {
					PageModule pm = null;
					if (bq[j].trim().length() > 0) {
						pm = (PageModule)pageModuleService.getObjById(bq[j]);
						if (pm != null) {
							bqName += "√ " + pm.getName() + "  ";	
						}
					}
				}
				bqNameList.add(bqName);
				//System.out.println("添加有效标签：" + bqName);
			} else {
				//System.out.println("商品名称：" + g.getName() + "=====标签为空");
				// 当标签为空时，向集合中添加一个空串，用来占位，否则页面在加载时会出现索引不一致
				bqNameList.add("");
				//System.out.println("添加空标签：" + "______");
			}
		}
		
		mav.addObject("bqNameList", bqNameList);
		mav.addAllObjects(data);
		mav.addObject("PAGE_INFO", page);
		mav.addObject("code", code);
		mav.addObject("name", name);
		mav.setViewName("/shangpin/goods/list");
		if (daili != null) {
			mav.addObject("role", daili.getIs_user());// 保存用户角色
		} else {
			UserInfo user = (UserInfo) request.getSession().getAttribute("UserInfo");
			mav.addObject("role", user.getIs_user());// 保存用户角色
		}
		return mav;
	} 


	/**
	 * 添加
	 */
	@RequestMapping(value = "/disAdd")
	public ModelAndView disAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		mav.addObject("goodsSort", goodsSortService.getListByWhere(new StringBuffer("and n.status='0' and n.flag='0' and n.parent.goodsSort_id is null ")));
		if (merchants != null) {
			mav.addObject("customSort", goodsSortService.getListByWhere(new StringBuffer("and n.status='0' and n.flag='1' and n.parent.goodsSort_id is null ").append(" and n.merchants.shangjia_id = '").append(merchants.getShangjia_id()).append("'")));
		}
		mav.addObject("goodsType", goodsTypeService.getListByWhere(new StringBuffer("and n.status='0'")));
		StringBuffer buff=new StringBuffer();
		if (merchants != null) {
			buff.append(" and n.merchants.shangjia_id="+merchants.getShangjia_id());
		}
//		mav.addObject("BrandList", brandService.getListByWhere(buff));
		mav.addObject("BrandList", brandService.getListByWhere(new StringBuffer()));

		// 取代理商的商家
		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		StringBuffer where1=new StringBuffer();
		if(daili!=null){
			String area[]=daili.getAreaid().split("%");
			for(int i=0;i<area.length;i++){
				if(i==0){
					where1.append(" and n.daili.areaid like '%"+area[i]+"%'");
				}else{
					where1.append(" or n.daili.areaid like '%"+area[i]+"%'");	
				}
			}
			List<ShangJiaInfo> list=(List<ShangJiaInfo>) shangJiaService.getListByWhere(where1);
			mav.addObject("shangjiaList", list);// 添加到页面，便于添加产品时输出
//			System.out.println("商家：" + list.size());
//			for (ShangJiaInfo s : list) {
//				System.out.println(s.getName());
//			}
		}
		if (daili != null) {
			mav.addObject("role", daili.getIs_user());// 保存用户角色
		} else {
			UserInfo user = (UserInfo) request.getSession().getAttribute("UserInfo");
			mav.addObject("role", user.getIs_user());// 保存用户角色
		}
		
		// 放入所有标签
		List<PageModule> biaoqianList = getAllBiaoqians();
		mav.addObject("biaoqianList", biaoqianList);
		
		// 返回视图
		mav.setViewName("/shangpin/goods/add");
		return mav;
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/{id}/{shangjia_id}/disUpdate")
	public ModelAndView disUpdate(@PathVariable String id, @PathVariable String shangjia_id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Goods goods = (Goods)goodsService.getObjById(id,shangjia_id);
		goods.setShelves("1");
		goodsService.updateGoodShelves(goods.getGoods_id(), goods.getShelves());
		mav.addObject("goodsSort", goodsSortService.getListByWhere(new StringBuffer("and n.status='0' and n.flag='0' ")));
		mav.addObject("customSort", goodsSortService.getListByWhere(new StringBuffer("and n.status='0' and n.flag='1' ").append(" and n.merchants.shangjia_id = '").append(shangjia_id).append("'")));
		mav.addObject("goodsType", goodsTypeService.getListByWhere(new StringBuffer("and n.status='0'")));
		StringBuffer buff=new StringBuffer();
		buff.append(" and n.merchants.shangjia_id="+shangjia_id);
//		mav.addObject("BrandList", brandService.getListByWhere(buff));
		mav.addObject("BrandList", brandService.getListByWhere(new StringBuffer()));
		mav.setViewName("/shangpin/goods/update");
		mav.addObject("info", goods);
		// 放入所有标签
		mav.addObject("biaoqianList", getAllBiaoqians());
		return mav;
	}
	
	public String getCode(){
		String code = "";
		code = StringUtil.getRandomString(10);//归属吗
		List<Goods> allShangjia = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.code = '"+code+"'"));
		if(allShangjia.size()!=0){
			code = getCode();
		}
		return code;
	}

	/**
	 * 添加保存
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response,Goods info) {
		try{
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			
			if(merchants!=null){
				info.setMerchants(merchants);
			}else{
				String shangjiaid=request.getParameter("shangjia_sel");
				merchants=(ShangJiaInfo) shangJiaService.getObjById(shangjiaid);
				info.setMerchants(merchants);
			}
			// 设置商品标签
			String biaoqianList = request.getParameter("biaoqianList");
//			System.out.println("设置商品标签：" + biaoqianList);
			info.setBiaoqian(biaoqianList);
			
			info.setName(info.getName().replace("\"", ""));
			if(info.getShelves().equals("0")){
				info.setSj_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			}
			goodsService.addObj(info);
//			System.out.println("添加成功！");
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println("添加出错！");
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",0);
		}

	}


	/**
	 * 更新保存 
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,Goods info) {
		
//		System.out.println("商家ID：" + request.getParameter("shangjia_id"));
		String shangjia_id = request.getParameter("shangjia_id");
		String pageNo = request.getParameter("pageNo");
		ShangJiaInfo shangjia = (ShangJiaInfo)shangJiaService.getObjById(shangjia_id);
		info.setMerchants(shangjia);// 保存关联的商家

		// 设置商品标签
		String biaoqianList = request.getParameter("biaoqianList");
		
		
		
		info.setBiaoqian(biaoqianList);
		
		try{
			info.setName(info.getName().replace("\"", ""));
			if(info.getShelves().equals("0")){
				info.setSj_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			}
			goodsService.updateObj(info);
			return new ModelAndView("redirect:/html/manage/goods/list?pageNo=" + pageNo,"C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/goods/list?pageNo" + pageNo,"C_STATUS",0);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/delall", method = RequestMethod.DELETE)
	public ModelAndView del(String ognzId, HttpServletRequest request, HttpServletResponse response) {
		try{
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			if (request.getParameterValues("list") != null) {
				String[] list = request.getParameterValues("list");
				for (String userid : list) {
					Goods info = (Goods) goodsService.getObjById(userid,""+merchants.getShangjia_id());
					info.setState("1");
					goodsService.updateObj(info);
				}
			}
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",0);
		}
	}

	/**
	 * 禁用
	 */
	@RequestMapping(value = "/{id}/del", method = RequestMethod.GET)
	public ModelAndView del(@PathVariable String id,  HttpServletRequest request) {
		try{
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			Goods info = (Goods) goodsService.getObjById(id,""+merchants.getShangjia_id());
			info.setState("1");
			info.setShelves("1");
			goodsService.updateObj(info);
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",1);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("redirect:/html/manage/goods/list","C_STATUS",0);
		}
	}

	/**
	 * 查询
	 */
	@RequestMapping(value = "/{id}/c")
	public void chaxun(@PathVariable
			String id, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		List<Goods> infoList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and n.code = '"+id+"' "));
		try {
			if (infoList.size() == 0) {
				response.getWriter().print("1");//该编号可以使用
			} else {
				response.getWriter().print("0");//该编号已经存在
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查看
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{id}/show")
	public ModelAndView show(@PathVariable String id,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		mav.addObject("info",goodsService.getObjById(id));
		mav.setViewName("/shangpin/goods/show");
		return mav;
	}
	/**
	 * 根据商品分类 获得商品类型 并且获得商品类型属性
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodType/list")
	public void goodTypeList(String id,HttpServletRequest request,HttpServletResponse response){
		try{
			GoodsSort sort=(GoodsSort) goodsSortService.getObjById(id);
//			buff.append(" and n.merchants.shangjia_id="+shangjia_id);
//			brandService.getListByWhere(buff);
			
			String json="{\"typeId\":\""+sort.getType().getGoodsType_id()+"\",\"linkBrank\":\""+sort.getType().getLinkBrank()+"\",\"spces\":"+ResponseUtil.getJson(sort.getType().getSpecList()).toString()+",\"brandList\":"+ResponseUtil.getJson(sort.getType().getBrandList()).toString()+"}";
			ResponseUtil.printl(response, json, "json");
		}catch(Exception e){
			ResponseUtil.printl(response, "{\"error\":1}", "json");
		}

	}
	/**
	 * 根据商品类型 获得商品类型属性
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/goodSpec/list")
	public void goodSpecList(String id,HttpServletRequest request,HttpServletResponse response){
		try{
			GoodsType type=(GoodsType) goodsTypeService.getObjById(id);
			String json="{\"spces\":"+ResponseUtil.getJson(type.getSpecList()).toString()+",\"linkBrank\":\""+type.getLinkBrank()+"\",\"brandList\":"+ResponseUtil.getJson(type.getBrandList()).toString()+"}";
			ResponseUtil.printl(response, json, "json");
		}catch(Exception e){
			ResponseUtil.printl(response, "{\"error\":1}", "json");
		}
	}

	@RequestMapping(value="/delivery/list")
	public void goodDeliveryList(HttpServletRequest request,HttpServletResponse response){
		try{
			ShangJiaInfo merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
			List list=dlytypeService.getListByWhere(new StringBuffer(" and n.stats='0' "));
			String json=ResponseUtil.getJson(list).toString();
			ResponseUtil.printl(response, json, "json");
		}catch(Exception e){
			ResponseUtil.printl(response, "{\"error\":1}", "json");
		}
	}

	/**
	 * 获取所有标签的方法，便于其它方法调用直接获取
	 */
	public List<PageModule> getAllBiaoqians() {
		List<PageModule> list = new ArrayList<PageModule>();
		List<PageModule> list2 = new ArrayList<PageModule>();
		StringBuffer where = new StringBuffer();
		where.append(" and n.status='0'");
		list = (List<PageModule>)pageModuleService.getListByWhere(where);
		// 只保留部分标签
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getPageModule_id() == 28) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 44) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 45) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 46) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 47) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 48) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 49) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 50) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 51) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 52) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 53) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 40) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 56) list2.add(list.get(i));
			if (list.get(i).getPageModule_id() == 57) list2.add(list.get(i));
			 
		}
		
		return list2;
	}
	
	
	
	
}
