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

package cn.com.dyninfo.o2o.furniture.admin.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.RoleInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.ResService;
import cn.com.dyninfo.o2o.furniture.admin.service.UserService;

@Controller
@RequestMapping("/manage/left")
public class LeftController {

	@Resource
	private ResService resService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping
	public ModelAndView view (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		List<ResInfo> resinfolist=(List<ResInfo>) resService.getListByWhere(
				new StringBuffer("  and resInfo.is_menu='1' and resInfo.parent is null "));
		for(int i=0;i<resinfolist.size();){
			ResInfo ref=resinfolist.get(i);
			List list=new ArrayList();
			for(ResInfo c:ref.getChildren()){
				String rolestr="";
				user=(UserInfo) userService.getObjById(user.getLogin_id());
				for(RoleInfo role:user.getRoles())
					rolestr+=" '"+role.getId()+"',";
				List mr=resService.getListByRoles(rolestr.substring(0,rolestr.length()-1),
						" and d.id = '"+c.getId()+"' and resInfo.IS_MENU='0' order by resInfo.id ");
				if(mr.size()>0){
					list.add(c);
//					System.out.println(ref.getRes_name()+":"+c.getRes_name());
				}else{
					
				}
				
			}
			i++;
			if(list.size()==0){
				resinfolist.remove(ref);
				i--;
			}else{
				List set=new ArrayList();
				set.addAll(list);
				ref.setChildren(set);
				list.clear();
			}
			
		}
		mav.addObject("resinfolist",resinfolist);
		mav.setViewName("/main/left");
		return mav;
	}
}
