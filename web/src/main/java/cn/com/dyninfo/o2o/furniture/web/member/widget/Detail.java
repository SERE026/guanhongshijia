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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderProductServeice;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
/*
 * 会员中心的晒单详细
 * @lxf
 */
@Component("detail")
public class Detail extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;

     @Resource
     private CommentService commentService;
     
 	@Resource
	private OrderService orderService;
     
 	@Resource
	private OrderProductServeice orderProductServeice;
		
	@Override
	public void execute(Map pamtr) {
		String orderproduct=(String) pamtr.get("orderproduct");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(orderproduct!=null){
			List list=commentService.getListByWhere(new StringBuffer(" and n.orderProduct.order_product_id="+orderproduct));
			if(list.size()>0){
				CommentInfo commentInfo=(CommentInfo)list.get(0);
				String image=commentInfo.getImageSrc();
				String image1[]=image.split(";");
				List imagelist=new ArrayList();
				for(int i=0;i<image1.length;i++){
					imagelist.add(image1[i]);
				}
				
//				System.out.println("--------------"+commentInfo.getOrderProduct().getProduct().getGood().getName());
				this.putData("data", commentInfo);
				this.putData("imagefirst", imagelist.get(0));
				this.putData("imagelist", imagelist);
				this.putData("huiyuan", huiyuan);
			}
		}
		
		
	}
	}