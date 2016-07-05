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

/**
 * 产品晒单
 * @author 王敏
 *
 */
@Component
public class GoodsShaidanWidget extends AbstractGoodsWidget {
	@Autowired
	public GoodsShaidanWidget(ItemGoodsWidget itemGoods){
		this.addWidget(itemGoods);
		
	}
	@Override
	public String getWidgetId() {
		// TODO Auto-generated method stub
		return "goods_shaidan";
	}

	@Override
	public void display(Map pamtr) {
		// TODO Auto-generated method stub

	}

}
