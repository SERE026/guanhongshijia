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

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.old.service.BbsPostService;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

/**
 * 美丽宣言公告
 * @author lxf
 *
 */
@Component("bbsGongao")
public class BbsGongao extends Widget {

	@Resource
	private BbsPostService bbsPostService;
	
	
	@Override
	public void display(Map pamtr) {
		String action=(String) pamtr.get("action");
		PageInfo page=new PageInfo();
		if(action==null){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			if(pageNo==null){
				pageNo="1";
				
			}
			pageSize="10";
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			Map map=bbsPostService.getListByPageWhere(new StringBuffer(" and n.flag=0 and n.status=1"),page);
			this.putData("data", map.get("DATA"));
		}else if(action.equals("getTotale")){
			page.setPageNo(1);
			page.setPageSize(10);
			StringBuffer where=new StringBuffer(" and n.flag=0 and n.status=1 ");
			int count=bbsPostService.getCountByWhere(where);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}
		
	}
}