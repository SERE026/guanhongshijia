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
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品列表
 * @author Administrator
 *
 */
@Component("good_group")
public class GoodGroupWidget extends Widget {


	@Resource
	private GoodsService goodsService;

	@Override
	public void display(Map pamtr) {
//		List<PageModule> reMaiList =(List<PageModule>)pageModuleService.getListByWhere(new StringBuffer(" and n.pageModule_id=2"));
//
//		PageModule goodsList=reMaiList.get(0);



//		String pageNo=(String) pamtr.get("pageNo");
//		String pageSize=(String) pamtr.get("pageSize");
//		PageInfo page2=new PageInfo();
//		page2.setPageNo(1);
//		page2.setPageSize(12);
//		HashMap<String, ?> dataa =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"),page2);
//		List<Goods> goodsList =(List<Goods>)dataa.get("DATA");
//
//		this.putData("data", goodsList);

		/*List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"));
			this.putData("data", goodsList);*/





//		String id=(String) pamtr.get("id");
		String size=(String) pamtr.get("pageSize");
		String no=(String) pamtr.get("pageNo");
		PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(no));
		page.setPageSize(Integer.parseInt(size));


		if(pamtr.get("dataType")!=null&&pamtr.get("dataType").equals("json")){
			HashMap<String, ?> datas =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"),page);
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
			String json="{\"data\":["+jsondata+"],\"page\":"+ ResponseUtil.getObjeJson(page)+"}";
			this.putData("json", json);
		}else{
			HashMap<String, ?> datas =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"),page);
			List<Goods> data =(List<Goods>)datas.get("DATA");
			this.putData("DATA",data);
			this.putData("page", page);
		}






		}
	}
	


