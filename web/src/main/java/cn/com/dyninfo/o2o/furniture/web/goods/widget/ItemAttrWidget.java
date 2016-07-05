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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

/**
 * 商品参数挂件
 * @author 王敏
 *
 */
@Component("goodsAttr")
public class ItemAttrWidget extends AbstractGoodsWidget {


	@Autowired
	public ItemAttrWidget(ItemGoodsWidget itemGoods){
		this.addWidget(itemGoods);
		
	}
	

	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action==null){
			Goods good=(Goods) pamtr.get("good");
			this.putData("specList", good.getSpecList());
		}
	}


	@Override
	public String getWidgetId() {
		return "goods_attr";
	}

}
