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

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import cn.com.dyninfo.o2o.furniture.admin.service.CouponMemberRelService;
import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ValidationUtil;
import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.AddressMemberService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.member.service.LoginfoService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/*
 * 会员中心  我的优惠券
 * @lxf
 */
@Component("agency")
public class Agency extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;
	 @Resource
	 private AddressMemberService addressMemberService;
	 @Resource
	 private LoginfoService loginfoService;
	 @Resource
	 private OrderService orderService;

	@Override
	public void execute(Map pamtr) {
		PageInfo page=new PageInfo();
		String action=(String) pamtr.get("action");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(action==null){
			this.putData("huiyuan",huiyuan);
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			if (!ValidationUtil.isEmpty(huiyuan.getShangJiaInfo().getShangjia_id())){
				Map map=orderService.getListByPageWhere(new StringBuffer(" and n.agencyPay='1' and  n.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()), page);
				this.putData("data", map.get("DATA"));
			}
			this.setPageName("Agency2.html");
		}else if(action.equals("getTotale")){
			page.setPageNo(1);
			page.setPageSize(10);
			if (!ValidationUtil.isEmpty(huiyuan.getShangJiaInfo().getShangjia_id())) {
				StringBuffer where = new StringBuffer("and n.agencyPay='1'  and  n.huiyuan.huiYuan_id=" + huiyuan.getHuiYuan_id());
				int count = orderService.getCountByWhere(where);
				this.putData("json", "{\"total\":" + count + "}");
			}
			this.setPageName("json.html");
		}
	}
}
	