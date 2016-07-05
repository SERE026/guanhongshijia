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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentSay;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentSayService;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;

/**
 * 美丽宣言晒单
 * @author lxf
 *
 */
@Component("bbssahidan")
public class Bbssahidan extends Widget {

	@Resource
	  private CommentService commentService;
	
	@Resource
	  private CommentSayService commentSayService;
	
	@Override
	public void display(Map pamtr) {
		PageInfo page=new PageInfo();
		HttpSession session=HttpRequest.getSession();
		HuiyuanInfo huiyuan = (HuiyuanInfo) session.getAttribute(Context.SESSION_MEMBER);
		String action=(String) pamtr.get("action");
		String bbsid=(String) pamtr.get("bbsid");
		if(bbsid!=null){
			session.setAttribute("bbsid", bbsid);
		}
		if(action==null){
			
			
		}else if(action.equals("getData")){
			String pageNo=(String) pamtr.get("pageNo");
			String pageSize=(String) pamtr.get("pageSize");
			page.setPageNo(Integer.parseInt(pageNo));
			page.setPageSize(Integer.parseInt(pageSize));
			bbsid=(String) session.getAttribute("bbsid");
			Map map=commentSayService.getListByPageWhere(new StringBuffer(" and n.comment.comment_id="+bbsid), page);
		
			
			this.putData("data", map.get("DATA"));
			this.setPageName("Bbssahidan2.html");
		}else if(action.equals("getTotale")){
			page.setPageNo(1);
			page.setPageSize(10);
			bbsid=(String) session.getAttribute("bbsid");
			StringBuffer where=new StringBuffer("and n.comment.comment_id="+bbsid);
			int count=commentSayService.getCountByWhere(where);
			this.putData("json","{\"total\":"+count+"}");
			this.setPageName("json.html");
		}else if(action.equals("getmen")){
			CommentInfo comment = (CommentInfo) commentService.getObjById(bbsid);
			List list=commentService.getListByWhere(new StringBuffer(" and n.info.huiYuan_id="+comment.getInfo().getHuiYuan_id()+" order by n.time"));
			//找出上一篇和下一篇
			CommentInfo last=null;
			CommentInfo next=null;
			for(int j=0;j<list.size();j++){
				CommentInfo loops=(CommentInfo) list.get(j);
				if(loops.getComment_id()==comment.getComment_id()){
					if(j-1>=0){
					last=(CommentInfo) list.get(j-1);
						if(j+1<=list.size()-1){
							next=(CommentInfo) list.get(j+1);
						}
					}
				}
			}
			
			this.setPageName("shaidanmen.html");
			String src =comment.getImageSrc();
			String imgsrc[]=src.split(";");
			List imagesrc=new ArrayList();
			for(int i=0;i<imgsrc.length;i++){
				imagesrc.add(imgsrc[i]);
			}
			this.putData("comment", comment);
			this.putData("sdlist", list);
			this.putData("last", last);
			this.putData("next", next);
			this.putData("imagesrc", imagesrc);
		}else if(action.equals("say")){
			this.setPageName("shaidanSay.html");
		}else if(action.equals("submit")){
			String saycontent=(String) pamtr.get("saycontent");
			bbsid=(String) session.getAttribute("bbsid");
			CommentInfo comment=	(CommentInfo) commentService.getObjById(bbsid);
			CommentSay say=new CommentSay();
			say.setInfo(huiyuan);
			say.setComment(comment);
			say.setContent(saycontent);
			commentSayService.addObj(say);
			this.putData("data", 0);
			this.setPageName("register.html");
		}
	}
}