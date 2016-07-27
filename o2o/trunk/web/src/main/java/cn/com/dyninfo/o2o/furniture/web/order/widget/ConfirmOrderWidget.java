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

package cn.com.dyninfo.o2o.furniture.web.order.widget;

import cn.com.dyninfo.o2o.furniture.admin.model.CouponMemberRel;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.admin.service.CouponService;
import cn.com.dyninfo.o2o.furniture.util.ForwordTool;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.AddressMember;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AddressMemberService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.score.model.Jffa;
import cn.com.dyninfo.o2o.furniture.web.score.service.JffaService;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("confirmOrder")
@Scope("prototype")
public class ConfirmOrderWidget extends  Widget {

	@Resource
	private OrderService orderService;
	
	@Resource
	private AddressMemberService addressMemberService;
	
	@Resource
	private AreaService areaService;
	
	@Resource
	private ZffsService zffsService;
	@Resource
	private JffaService jffaService;
	
	@Resource
	private HuiyuanService huiyuanService;

	@Resource
	private CouponMemberRelService couponMemberRelService;

	@Resource
	private CouponService couponService;
	
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		HuiyuanInfo member=(HuiyuanInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		if(member==null&&!"phone".equals(action)){
			String forword=this.HttpRequest.getHeader("Referer");
			this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, forword);
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
			return;
		}
		
		if(action==null){//生成订单确认信息
			
			List list=orderService.getOrderConfirm(this.HttpRequest);
			this.putData("data", list);
			List addrList=addressMemberService.getListByWhere(new StringBuffer(" and n.member.huiYuan_id="+member.getHuiYuan_id()));
			this.putData("addressList", addrList);
			List zflist=zffsService.getListByWhere(new StringBuffer(" and n.status=0"));
			this.putData("zflist", zflist);
			Jffa j_x=(Jffa) jffaService.getObjById("1");
			this.putData("j_x", j_x.getJffa_jfdk());
			member =(HuiyuanInfo) huiyuanService.getObjById(""+member.getHuiYuan_id());
			this.putData("h_x", member.getJf());
			List<CouponMemberRel> couponMemberRelList=(List<CouponMemberRel>)couponMemberRelService.getListByWhere(new StringBuffer(" and  n.huiyuan="+member.getHuiYuan_id()));
			this.putData("couponMemberRelList",couponMemberRelList);

			
		}else if(action.equals("phone")){//生成订单确认信息
			
			String event=(String) pamtr.get("event");//事件
			if(event.equals("getShopGoods")){
				String carId[]=this.HttpRequest.getParameterValues("carId");
				
				String memberId=(String) pamtr.get("memberId");
				List<AddressMember> addressList=(List<AddressMember>) addressMemberService.getListByWhere(new StringBuffer(" and n.member.id='"+memberId+"' order by n.isdefault desc  "));
				Jffa jf=(Jffa) jffaService.getObjById("1");
				List<Map<String,Object>> list=orderService.getOrderConfirm(memberId,carId);
				StringBuffer json=new StringBuffer("{");
				HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(memberId);
				json.append("\"jf\":\""+huiyuan.getJf()+"\",");
				json.append("\"jf_money\":\""+jf.getJffa_jfdk()+"\",");
				json.append("\"account\":\""+huiyuan.getMoney()+"\",");
				json.append("\"address\":[");
				for(AddressMember am:addressList){
					json.append("{\"id\":\""+am.getAddress_id()+"\",");
					json.append("\"name\":\""+am.getReceiveName()+"\",");
					json.append("\"phone\":\""+am.getReceivePhone()+"\",");
					json.append("\"address\":\""+am.getProvince().getName()+am.getCity().getName()
							+am.getCounty().getName()+am.getAddress()+"\"},");
					
				}
				if(addressList.size()>0){
					json.deleteCharAt(json.length()-1);
				}
				json.append("],\"shopGoods\":[");
				
				for(Map<String,Object> data:list){
					json.append("{");
					json.append("\"shopId\":\""+data.get("shop_id")+"\",");
					json.append("\"shopName\":\""+data.get("shop_Name")+"\",");
					json.append("\"goods\":[");
					List<Map<String,Object>> goodsList=(List<Map<String, Object>>) data.get("list");
					for(Map<String,Object> goods:goodsList){
						json.append("{");
						json.append("\"goodsId\":\""+goods.get("good_id")+"\",");
						json.append("\"goodsName\":\""+goods.get("goodName")+"\",");
						json.append("\"actMoney\":\""+goods.get("actMoney")+"\",");
						json.append("\"specMoney\":\""+goods.get("specMoney")+"\",");
						json.append("\"price\":\""+goods.get("price")+"\",");
						json.append("\"num\":\""+goods.get("num")+"\",");
						json.append("\"actId\":\""+goods.get("actId")+"\",");
						json.append("\"id\":\""+goods.get("id")+"\"");
						json.append("},");
					}
					if(goodsList.size()>0){
						json.deleteCharAt(json.length()-1);
					}
					json.append("]");
					json.append("},");
				}
				if(list.size()>0){
					json.deleteCharAt(json.length()-1);
				}
				json.append("]}");
				ResponseUtil.printl(this.HttpResponse,json.toString(), "json");
				
			}else if(event.equals("queryYF")){
				String receiveId=this.HttpRequest.getParameter("receiveId");
				String g_ds[]=this.HttpRequest.getParameter("p").split("=");
				StringBuffer json=new StringBuffer();
				for(String gd:g_ds){
					if(gd.length()>0){
						Map map=orderService.getDistribution(receiveId, gd.split("@"));
						json.append("{\"shopId\":\""+map.get("shopId")+"\",");
						json.append("\"status\":\""+map.get("status")+"\",");
						json.append("\"dlyId\":\""+map.get("dlyId")+"\",");
						json.append("\"money\":\""+map.get("money")+"\"},");
					}
				}
				if(json.length()>0){
					json.deleteCharAt(json.length()-1);
				}
				ResponseUtil.printl(this.HttpResponse,"["+ json.toString()+"]", "json");
			}else if(event.equals("create")){
				String memberId=this.HttpRequest.getParameter("memberId");
				this.HttpRequest.getSession().setAttribute(Context.SESSION_MEMBER, huiyuanService.getObjById(memberId));
				HttpRequest.setAttribute("isPhone", true);
				boolean create=orderService.create(this.HttpRequest);
				String tradeNo=(String) this.HttpRequest.getSession().getAttribute(Context.SESSION_TRADENO);
				
				List<Order> data=orderService.getListByPage(new StringBuffer(" and n.tradeNo='"+tradeNo+"' "));
				Double totale=0d;
				Double orderMoney=0d;
				Double dlyMoney=0d;
				for(Order order:data){
					totale+=order.getOrderPrice();
					orderMoney+=order.getOrderPrice();
					dlyMoney+=order.getShippingPrice();
				}
				
				
				json="{\"create\":"+create+",\"tradeNo\":\""+tradeNo+"\",\"totale\":"
				+totale+",\"orderMoney\":"+orderMoney+",\"dlyMoney\":"+dlyMoney+"}";
				ResponseUtil.printl(this.HttpResponse,json, "json");
			}
			
			
			this.setFreeMaker(false);
		}else if(action.equals("distribution")){//获取配送方式
			this.setFreeMaker(false);
			Map map=orderService.getDistribution(this.HttpRequest);
			List list=(List) map.get("data");
			String status=(String) map.get("status");
			json="{\"status\":\""+status+"\", \"money\":\""+map.get("money")+"\",\"data\":";
			if(list!=null)
				json+=ResponseUtil.getJson(list).toString();
			else
				json+="[]";
			json+="}";
//			System.out.println(json);
			ResponseUtil.printl(this.HttpResponse, json, "json");
		}else if(action.equals("distributionMeony")){//获取配送费用
			Double money=orderService.getDistributionMoney(HttpRequest);
			
			//this.putData("json", "{\"money\":"+money+"}");
			//this.setPageName("ConfirmJson.html");
			ResponseUtil.printl(this.HttpResponse, "{\"money\":"+money+"}", "json");
			this.setFreeMaker(false);
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
			//this.setPageName("ConfirmJson.html");
		}else if(action.equals("getShopPrice")){
			Map map=orderService.getShopPrice(this.HttpRequest);
			json="{\"dlyprice\":\""+map.get("dlyprice")+"\",\"goodPrice\":"+map.get("goodPrice")+",\"actPrice\":"+map.get("actPrice")+"}";
			this.putData("json", json);
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
			//this.setPageName("ConfirmJson.html");
		}else if(action.equals("create")){
			boolean create=orderService.create(this.HttpRequest);
			String tradeNo=(String) this.HttpRequest.getSession().getAttribute(Context.SESSION_TRADENO);
			json="{\"create\":"+create+",\"tradeNo\":\""+tradeNo+"\"}";
			//this.putData("json", "{\"create\":"+create+",\"tradeNo\":\""+tradeNo+"\"}");
			//this.setPageName("ConfirmJson.html");
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
		}else if(action.equals("checkPoint")){
			member =(HuiyuanInfo) huiyuanService.getObjById(""+member.getHuiYuan_id());
			String point=(String) pamtr.get("point");
			int p=Integer.parseInt(point);
			json="{\"status\":"+(member.getJf()>=p?"0":"1")+",\"m_j\":"+member.getJf()+"}";
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, json, "json");
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
