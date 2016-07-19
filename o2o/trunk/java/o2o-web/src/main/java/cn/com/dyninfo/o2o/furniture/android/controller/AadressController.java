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

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.service.AreaService;
import cn.com.dyninfo.o2o.old.model.AddressMember;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.AddressMemberService;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;

/**
 * android 收货地址
 * @author feng
 *
 */
@Controller
@RequestMapping("/aadress")
public class AadressController{
    

		 @Resource
		 private AddressMemberService addressMemberService;
		 
		@Resource
		private AreaService areaService;
		
		 @Resource
		 private HuiyuanService huiyuanService;
		
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		String huiYuan_id=request.getParameter("huiYuan_id");
		List list=addressMemberService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiYuan_id));
		if(list.size()>0){
			
			String json="{\"status\":0,\"data\":[";
			for(int i=0;i<list.size();i++){
				AddressMember info = (AddressMember) list.get(i);
				String province="";
				String city="";
				String county="";
				if(info.getProvince()!=null){
					province=info.getProvince().getName();
				}
				if(info.getCity()!=null){
					city=info.getCity().getName();
				}
				if(info.getCounty()!=null){
					county=info.getCounty().getName();
				}
				json+="{\"address_id\":\""+info.getAddress_id()+"\",\"receiveName\":\""+info.getReceiveName()+"\",\"receivePhone\":\""+info.getReceivePhone()+"\",\"address\":\""+info.getAddress()+"\",\"province\":\""+
				province+"\",\"city\":\""+city+"\",\"county\":\""+county+"\"},";
			}
			if(json.length()>1){
				json=json.substring(0,json.length()-1);
			}
			json+="]}";
			ResponseUtil.printl(response, json, "json");
	 	}else{
	 		ResponseUtil.printl(response, "{\"status\":1}", "json");
	 	}
	 }
	 
	 @RequestMapping("/add")
	 public void add(HttpServletRequest request,HttpServletResponse response){
		try{
		 String huiYuan_id=request.getParameter("huiYuan_id");
		 HuiyuanInfo huiyuan=(HuiyuanInfo)huiyuanService.getObjById(huiYuan_id);
			request.setCharacterEncoding("UTF-8");
		 	String province=new String(request.getParameter("province").getBytes("ISO-8859-1"),"UTF-8");
			String city=new String(request.getParameter("city").getBytes("ISO-8859-1"),"UTF-8");
			String county=new String(request.getParameter("county").getBytes("ISO-8859-1"),"UTF-8");
			String receiveName=new String(request.getParameter("receiveName").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String receivePhone=request.getParameter("receivePhone");
			String receiveTel1=request.getParameter("receiveTel1");
			String receiveTel2=request.getParameter("receiveTel2");
			String receiveTel3=request.getParameter("receiveTel3");
			String isdefault=request.getParameter("isdefault");
			if(isdefault==null||isdefault==""){
				isdefault="0";
			}else if(isdefault.equals("1")){//只能有一个默认
				List defaultList=addressMemberService.getListByWhere(new StringBuffer(" and n.isdefault=1"));
				for(int i=0;i<defaultList.size();i++){
					AddressMember addressMember01 = (AddressMember) defaultList.get(i);
					addressMember01.setIsdefault(0);
					addressMemberService.updateObj(addressMember01);
				
				}
			}
			AreaInfo provinceinfo=null;
			AreaInfo cityinfo=null;
			AreaInfo countyinfo=null;
			if(province!=null&&!province.equals("")){
				List listpro =areaService.getListByWhere(new StringBuffer(" and n.name like '"+province+"%'"));
				if(listpro.size()>0){
					provinceinfo=(AreaInfo)listpro.get(0);
				}
			}
			if(city!=null&&!city.equals("")){
				List listcity=areaService.getListByWhere(new StringBuffer(" and n.name like '"+city+"%'"));
				if(listcity.size()>0){
					 cityinfo=(AreaInfo)listcity.get(0);
				}
			}
			if(county!=null&&!county.equals("")){
				List listcountry = areaService.getListByWhere(new StringBuffer(" and n.name like '"+county+"%'"));
				if(listcountry.size()>0){
					 countyinfo=(AreaInfo)listcountry.get(0);
				}
			}
			AddressMember addressMember=new AddressMember();
			addressMember.setProvince(provinceinfo);
			addressMember.setCity(cityinfo);
			addressMember.setCounty(countyinfo);
			addressMember.setAddress(address);
			addressMember.setReceiveName(receiveName);
			addressMember.setReceivePhone(receivePhone);
			addressMember.setReceiveTel(receiveTel1+"-"+receiveTel2+"-"+receiveTel3);
			addressMember.setIsdefault(Integer.parseInt(isdefault));
			addressMember.setMember(huiyuan);
			addressMemberService.addObj(addressMember);
		 
			String json="{\"status\":0}";
			ResponseUtil.printl(response, json, "json");
		} catch (Exception e) {
			String json="{\"status\":1}";
			ResponseUtil.printl(response, json, "json");
		}
	}
	 
	 @RequestMapping("/del")
	 public void del(HttpServletRequest request,HttpServletResponse response){
			try{
			String address_id=request.getParameter("address_id");
			addressMemberService.delObjById(address_id);;
			ResponseUtil.printl(response, "{\"status\":0}", "json");
			} catch (Exception e) {
			ResponseUtil.printl(response, "{\"status\":1}", "json");
		}
		 
	 }
	 
	 @RequestMapping("/save")
	 public void save(HttpServletRequest request,HttpServletResponse response){
			try{
			String address_id=request.getParameter("address_id");
			AddressMember addressMember =(AddressMember) addressMemberService.getObjById(address_id);
			request.setCharacterEncoding("UTF-8");
		 	String province=new String(request.getParameter("province").getBytes("ISO-8859-1"),"UTF-8");
			String city=new String(request.getParameter("city").getBytes("ISO-8859-1"),"UTF-8");
			String county=new String(request.getParameter("county").getBytes("ISO-8859-1"),"UTF-8");
			String receiveName=new String(request.getParameter("receiveName").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			
			String receivePhone=request.getParameter("receivePhone");
			String receiveTel1=request.getParameter("receiveTel1");
			String receiveTel2=request.getParameter("receiveTel2");
			String receiveTel3=request.getParameter("receiveTel3");
			String isdefault=request.getParameter("isdefault");
			if(isdefault==null||isdefault==""){
				isdefault="0";
			}else if(isdefault.equals("1")){//只能有一个默认
				List defaultList=addressMemberService.getListByWhere(new StringBuffer(" and n.isdefault=1"));
				if(defaultList.size()>0){
					AddressMember addressMember01 = (AddressMember) defaultList.get(0);
					addressMember01.setIsdefault(0);
					addressMemberService.updateObj(addressMember01);
				}
			}
			AreaInfo provinceinfo=null;
			AreaInfo cityinfo=null;
			AreaInfo countyinfo=null;
			if(province!=null&&!province.equals("")){
				List listpro =areaService.getListByWhere(new StringBuffer(" and n.name like '"+province+"%'"));
				if(listpro.size()>0){
					provinceinfo=(AreaInfo)listpro.get(0);
				}
			}
			if(city!=null&&!city.equals("")){
				List listcity=areaService.getListByWhere(new StringBuffer(" and n.name like '"+city+"%'"));
				if(listcity.size()>0){
					 cityinfo=(AreaInfo)listcity.get(0);
				}
			}
			if(county!=null&&!county.equals("")){
				List listcountry = areaService.getListByWhere(new StringBuffer(" and n.name like '"+county+"%'"));
				if(listcountry.size()>0){
					 countyinfo=(AreaInfo)listcountry.get(0);
				}
			}
			
			addressMember.setProvince(provinceinfo);
			addressMember.setCity(cityinfo);
			addressMember.setCounty(countyinfo);
			addressMember.setAddress(address);
			addressMember.setReceiveName(receiveName);
			addressMember.setReceivePhone(receivePhone);
			addressMember.setReceiveTel(receiveTel1+"-"+receiveTel2+"-"+receiveTel3);
			addressMember.setIsdefault(Integer.parseInt(isdefault));
			addressMember.setMember(addressMember.getMember());
			addressMemberService.updateObj(addressMember);
			String json="{\"status\":0}";
			ResponseUtil.printl(response, json, "json");
		} catch (Exception e) {
				String json="{\"status\":1}";
				ResponseUtil.printl(response, json, "json");
		}
		 
	 }
 }