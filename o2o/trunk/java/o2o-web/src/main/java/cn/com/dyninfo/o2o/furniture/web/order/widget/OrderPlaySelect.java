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

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

@Component("order_play_select")
public class OrderPlaySelect extends Widget {
	@Resource
	private ZffsService zffsService;
	@Override
	public void display(Map pamtr) {
		String tradeNo=(String) pamtr.get("tradeNo");
		List zflist=zffsService.getListByWhere(new StringBuffer(" and n.status=0"));
		this.putData("zflist", zflist);
		this.putData("tradeNo", tradeNo);
	}

}
