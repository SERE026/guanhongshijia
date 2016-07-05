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

package cn.com.dyninfo.o2o.furniture.web.bbs.widget;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.bbs.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

/**
 * 论坛
 * @author 王敏
 *
 */
@Component("bbsPostWidget")
public class BbsPostWidget extends Widget {

	@Resource
	private BbsPostService bbsPostService;
	
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		if(action.equals("data")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			String order=(String) pamtr.get("order");
			String by=(String) pamtr.get("by");
			StringBuffer where=new StringBuffer("  ");
			where.append(" and n.type=0 and n.status=1 ");
			if(order!=null){
				where.append(" order by n.top desc , n."+order+" "+by);
			}else{
				where.append(" order by n.top desc , n.time desc ");
			}
			PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=bbsPostService.getListByPageWhere(where, page);
			List list=(List) map.get("DATA");
			this.putData("data", list);
			
		}else if(action.equals("total")){
			StringBuffer where=new StringBuffer("  ");
			where.append(" and n.type=0 and n.status=1 ");
			
			int count=bbsPostService.getCountByWhere(where);
			String json="{\"total\":"+count+"}";
			this.setFreeMaker(false);
			ResponseUtil.printl(this.HttpResponse, "{\"total\":"+count+"}", "json");
		}
	}

}
