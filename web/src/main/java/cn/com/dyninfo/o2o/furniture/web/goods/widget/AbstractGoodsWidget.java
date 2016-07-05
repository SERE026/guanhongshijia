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

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

public abstract class AbstractGoodsWidget extends Widget implements IGoodsWidget {
	private List<IGoodsWidget> widgetList;
	
	@Override
	public void addWidget(IGoodsWidget widget) {
		if(widgetList==null)
			widgetList=new ArrayList();
		widgetList.add(widget);

	}

	@Override
	public List<IGoodsWidget> getList() {
		// TODO Auto-generated method stub
		return widgetList;
	}

	

}
