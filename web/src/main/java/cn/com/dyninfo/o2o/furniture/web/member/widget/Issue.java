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

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderProductServeice;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
/*
 * 会员中心的发表晒单
 * @lxf
 */
@Component("issue")
public class Issue extends AbstractMemberWidget{
	 @Resource
	 private HuiyuanService huiyuanService;

     @Resource
     private CommentService commentService;
     
 	@Resource
	private OrderService orderService;
     
 	@Resource
	private OrderProductServeice orderProductServeice;
 	
    @Resource
    private GoodsService goodsService;
 	
	@Override
	public void execute(Map pamtr) {
		String photo_url=(String) pamtr.get("photo_url");
		String orderproduct=(String) pamtr.get("orderproduct");
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		if(orderproduct!=null){
			List list=orderProductServeice.getListByWhere(new StringBuffer(" and n.order.huiyuan.huiYuan_id="+huiyuan.getHuiYuan_id()+"and n.order.isPay='1'"));
			this.putData("data", list);
			this.putData("orderproduct", orderproduct);
		}
		 if(photo_url!=null){
			 String imageSrc="";
			 String pinfeng=(String) pamtr.get("pinfeng");
			 String phototitle=(String) pamtr.get("photoTitle");
			 String productid=(String) pamtr.get("product_id");
			 String photoIntro=(String) pamtr.get("photoIntro");
			 String saycontent=(String) pamtr.get("saycontent");
			 OrderProduct orderproduct1=(OrderProduct) orderProductServeice.getObjById(productid);
			 	orderproduct1.setShowstats("1");
			 	orderProductServeice.updateObj(orderproduct1);
			 String issue_flies[]=this.HttpRequest.getParameterValues("issue_flie");
			 if(issue_flies!=null){
				 for(String img:issue_flies){
					 imageSrc+=img+";";
				 }
			 }
			 CommentInfo newinfo=new CommentInfo();
			 newinfo.setInfo(huiyuan);
			 newinfo.setSinfo(orderproduct1.getOrder().getMerchants());
			 newinfo.setContent(photoIntro);
			 newinfo.setImageSrc(imageSrc);
			 newinfo.setLeve(Double.parseDouble(pinfeng));
			 newinfo.setPhototitle(phototitle);
			 Goods good=orderproduct1.getProduct().getGood();
			 newinfo.setGinfo(good);
			 newinfo.setStatus("0");
			 newinfo.setIsShow("1");
			 newinfo.setOrderProduct(orderproduct1);
			 newinfo.setSaycontent(saycontent);
			 commentService.addObj(newinfo);
			 try {
				this.HttpResponse.sendRedirect(this.HttpRequest.getContextPath()+"/"+"huiyuan_showorder.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}