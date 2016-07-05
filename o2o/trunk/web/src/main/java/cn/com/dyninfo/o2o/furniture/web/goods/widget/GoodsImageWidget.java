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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;

/**
 * 商品图片挂件
 * @author 王敏
 *
 */
@Component
public class GoodsImageWidget extends AbstractGoodsWidget {


	@Autowired
	public GoodsImageWidget(ItemGoodsWidget itemGoods){
		this.addWidget(itemGoods);
		
	}
	@Override
	public String getWidgetId() {
		return "goods_image";
	}

	@Override
	public void display(Map pamtr) {
		Goods good=(Goods) pamtr.get("good");
		String images=good.getImages();
		List list=new ArrayList();
		if(images!=null){
			for(String img:images.split(";")){
				list.add("upload/goods/"+img);
			}
		}
		this.putData("images", list);
		this.putData("defaultImage", "upload/goods/"+good.getDefaultImage());
	}

}
