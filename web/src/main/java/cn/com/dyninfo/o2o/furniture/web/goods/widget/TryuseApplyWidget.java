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

package cn.com.dyninfo.o2o.furniture.web.goods.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.model.TryuseApply;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.TryuseApplyService;
import cn.com.dyninfo.o2o.furniture.web.member.dao.AddressMemberDAO;
import cn.com.dyninfo.o2o.furniture.web.member.model.AddressMember;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AddressMemberService;
import cn.com.dyninfo.o2o.furniture.web.member.widget.AbstractMemberWidget;

@Component("tryuseApply")
public class TryuseApplyWidget extends  AbstractMemberWidget {
	@Resource
	private GoodsService goodsService;
	@Resource
	private AreaService areaService;
	
	@Resource
	private AddressMemberDAO addressMemberDAO;
	
	@Resource
	private AddressMemberService addressMemberService;
	
	   @Resource
	     private TryuseApplyService tryuseApplyService;

	@Override
	public void execute(Map pamtr) {
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		String action=(String) pamtr.get("action");
		String goodsid=(String) pamtr.get("goodsid");
		if(action==null){
			List addrList=addressMemberService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+huiyuan.getHuiYuan_id()));
			this.putData("addressList", addrList);
			this.putData("goodsid", goodsid);
		}else if(action.equals("addAddress")){//添加地址
			addAddress();
		}else if(action.equals("getArea")){
			String parentId=(String) pamtr.get("parentId");
			if(parentId!=null&&parentId.length()>0){
				List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id='"+parentId+"' "));
				//this.putData("json", ResponseUtil.getJson(list).toString());
				ResponseUtil.printl(this.HttpResponse, ResponseUtil.getJson(list).toString(), "json");
			}else{
				List list=areaService.getListByWhere(new StringBuffer(" and n.parent.id is null "));
				//this.putData("json", ResponseUtil.getJson(list).toString());
				ResponseUtil.printl(this.HttpResponse, ResponseUtil.getJson(list).toString(), "json");
			}
			this.setFreeMaker(false);
		}else if(action.equals("create")){
			String goodid=(String) pamtr.get("goodsid");
			String reason=(String) pamtr.get("reason");
			String receiveId=(String) pamtr.get("receiveId");
			AddressMember	address=(AddressMember) addressMemberDAO.getObjById(receiveId);
			TryuseApply apply=new TryuseApply();
			apply.setProvince(address.getProvince());//省
			apply.setCity(address.getCity());//市 
			apply.setCounty(address.getCounty());//区县
			apply.setAddress(address.getAddress());//地址
			apply.setCode(address.getCode());//邮编
			apply.setReceiveName(address.getReceiveName());//收货人
			apply.setReceivePhone(address.getReceivePhone());//收货手机
			apply.setReceiveTel(address.getReceiveTel());//收货电话
			apply.setEmail(address.getEmail());//收货人邮箱
			apply.setReason(reason);
			apply.setApplyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			Goods goods=(Goods) goodsService.getObjById(goodid);
			apply.setGoods(goods);
			apply.setHuiyuan(huiyuan);
			tryuseApplyService.addObj(apply);
			goods.setPepoleno(goods.getPepoleno()+1);
			goodsService.updateObj(goods);
			this.putData("data", "1");
			this.setPageName("register.html");
		}
	}

	/**
	 * 添加新地址
	 */
	public void addAddress(){
		HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		AddressMember am=new AddressMember();
		am.setMember(member);
		am.setAddress(this.HttpRequest.getParameter("address"));
		AreaInfo city=(AreaInfo) areaService.getObjById(this.HttpRequest.getParameter("cityId"));
		
		AreaInfo county=(AreaInfo) areaService.getObjById(this.HttpRequest.getParameter("countyId"));
		
		AreaInfo province=(AreaInfo) areaService.getObjById(this.HttpRequest.getParameter("provinceId"));
		
		
		am.setCity(city);
		am.setCode(this.HttpRequest.getParameter("code"));
		am.setCounty(county);
		am.setEmail(this.HttpRequest.getParameter("email"));
		am.setIsdefault(Integer.parseInt(this.HttpRequest.getParameter("Isdefault")));
		am.setProvince(province);
		am.setReceiveName(this.HttpRequest.getParameter("receiveName"));
		am.setReceivePhone(this.HttpRequest.getParameter("receivePhone"));
		am.setReceiveTel(this.HttpRequest.getParameter("receiveTel"));
		am.setStatus(0);
		//am.setReceiveDate(this.HttpRequest.getParameter("receiveDate"));
		if(city!=null&&county!=null&&province!=null)
		{
			addressMemberService.addObj(am);
		}
		String json="{\"status\":0,\"id\":\""+am.getAddress_id()+"\"}";
		this.putData("json", json);
		this.putData("ad", am);
		this.setPageName("addAddressResult.html");
		
	}
}