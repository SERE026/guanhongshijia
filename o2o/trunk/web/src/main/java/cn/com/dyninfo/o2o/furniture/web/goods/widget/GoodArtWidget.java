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

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品列表
 * @author Administrator
 *
 */
@Component("good_art")
public class GoodArtWidget extends Widget {


	@Resource
	private GoodsService goodsService;

	@Override
	public void display(Map pamtr) {
//		List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id=1"));
//		PageModule goodsList=reMaiList.get(0);
		/*List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YUN_SKU+"')>0"));
			this.putData("data", goodsList);*/
//		String pageNo=(String) pamtr.get("pageNo");
//		String pageSize=(String) pamtr.get("pageSize");
//		StringBuffer where=new StringBuffer();
//			PageInfo page=new PageInfo();
//			page.setPageNo(Integer.parseInt(pageNo));
//			page.setPageSize(Integer.parseInt(pageSize));
//			HashMap<String, ?> data =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
//			List<Goods> goodsList =(List<Goods>)data.get("DATA");
//			this.putData("data", goodsList);



//		PageInfo page=new PageInfo();
//		String action=(String) pamtr.get("action");
//		HttpSession session=HttpRequest.getSession();
//		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
//		if(action==null){
//			this.putData("huiyuan",huiyuan);
//		}else if(action.equals("getData")){
//			String pageNo=(String) pamtr.get("pageNo");
//			String pageSize=(String) pamtr.get("pageSize");
//			page.setPageNo(Integer.parseInt(pageNo));
//			page.setPageSize(Integer.parseInt(pageSize));
//			HashMap<String, ?> data =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
//			List<Goods> goodsList =(List<Goods>)data.get("DATA");
//			this.putData("data", goodsList);
////			this.putData("data", map.get("DATA"));
//			this.setPageName("Integral2.html");
//		}else if(action.equals("getTotale")){
////			page.setPageNo(1);
////			page.setPageSize(10);
//			StringBuffer where=new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0");
//			int count=goodsService.getCountByWhere(where);
//			this.putData("json","{\"total\":"+count+"}");
//			this.setPageName("json.html");
//		}

//		if(action.equals("dataTotal")){
//			StringBuffer where=new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0");
//			int count=goodsService.getCountByWhere(where);
//			this.putData("json", "{\"total\":"+count+"}");
//			this.setPageName("GoodListWidgetJson.html");
//		}else if(action.equals("data")){
//
//			PageInfo page=new PageInfo();
//			page.setPageNo(Integer.parseInt(pageNo));
//			page.setPageSize(Integer.parseInt(pageSize));
//			HashMap<String, ?> data =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
//			List<Goods> goodsList =(List<Goods>)data.get("DATA");
//			this.putData("data", goodsList);
//
//		}

//
//		String id=(String) pamtr.get("id");
//		String size=(String) pamtr.get("pageSize");
//		String no=(String) pamtr.get("pageNo");
//
//		PageInfo page=new PageInfo();
//		page.setPageNo(Integer.parseInt(no));
//		page.setPageSize(Integer.parseInt(size));
//
//		HashMap<String, ?> data =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
//		List<Goods> goodsList =(List<Goods>)data.get("DATA");
//		StringBuffer where=new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0");
//		int count=goodsService.getCountByWhere(where);
//		this.putData("DATA",goodsList);
//		this.putData("page", page);










		String id=(String) pamtr.get("id");
		String size=(String) pamtr.get("pageSize");
		String no=(String) pamtr.get("pageNo");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(no));
		page.setPageSize(Integer.parseInt(size));
//		AreaInfo arear=(AreaInfo) this.HttpRequest.getSession().getAttribute(Context.SESSION_AEAR);
//		String action_model=(String) pamtr.get("action_model");
//		if(action_model!=null&&action_model.equals("huangou")){
//
//			List<Goods> data=pagModInGoodsService.getGoods(44, arear!=null?arear.getId():null, 102, page, null);
//			this.setPageName("goodsJson.html");
//			List list=new ArrayList();
//			String jsondata="";
//			for(int i=0;i<data.size();i++){
//				Goods g=data.get(i);
//				jsondata+="{\"goods_id\":\""+g.getGoods_id()+"\",";
//				jsondata+="\"name\":\""+g.getName()+"\",";
//				jsondata+="\"salesMoney\":"+g.getSalesMoney()+",";
//				jsondata+="\"bazaarMoney\":"+g.getBazaarMoney()+",";
//				jsondata+="\"discount\":"+g.getDiscount()+",";
//				jsondata+="\"defaultImage\":\""+g.getDefaultImage()+"\"},";
//			}
//			if(jsondata.length()>0)
//				jsondata=jsondata.substring(0,jsondata.length()-1);
//			String json="{\"data\":["+jsondata+"],\"page\":"+ ResponseUtil.getObjeJson(page)+"}";
//			this.putData("json", json);
//
//		}else
		if(pamtr.get("dataType")!=null&&pamtr.get("dataType").equals("json")){
			HashMap<String, ?> datas =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
			List<Goods> data =(List<Goods>)datas.get("DATA");
			this.setPageName("goodsJson.html");
			List list=new ArrayList();
			String jsondata="";
			for(int i=0;i<data.size();i++){
				Goods g=data.get(i);
				jsondata+="{\"goods_id\":\""+g.getGoods_id()+"\",";
				jsondata+="\"name\":\""+g.getName()+"\",";
				jsondata+="\"salesMoney\":"+g.getSalesMoney()+",";
				jsondata+="\"bazaarMoney\":"+g.getBazaarMoney()+",";
				jsondata+="\"discount\":"+g.getDiscount()+",";
				jsondata+="\"defaultImage\":\""+g.getDefaultImage()+"\"},";
			}
			if(jsondata.length()>0)
				jsondata=jsondata.substring(0,jsondata.length()-1);
			String json="{\"data\":["+jsondata+"],\"page\":"+ResponseUtil.getObjeJson(page)+"}";
			this.putData("json", json);
		}else{
			HashMap<String, ?> datas =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.YISHUPING_SKU+"')>0"),page);
			List<Goods> data =(List<Goods>)datas.get("DATA");
			this.putData("DATA",data);
			this.putData("page", page);
		}
















		}
	}
	


