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
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
		String pageNo=(String) pamtr.get("pageNo");
		String pageSize=(String) pamtr.get("pageSize");
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(30);
		HashMap<String, ?> data =goodsService.getListByPageWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"),page);
		List<Goods> goodsList =(List<Goods>)data.get("DATA");
		this.putData("data", goodsList);

		/*List<Goods> goodsList = (List<Goods>) goodsService.getListByWhere(new StringBuffer(" and instr(n.biaoqian,'"+ Constants.GROUP_SKU+"')>0"));
			this.putData("data", goodsList);*/
		}
	}
	


