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

package cn.com.dyninfo.o2o.furniture.web.active.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.web.active.model.Game;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameService;

@Controller
@RequestMapping("/manage/game")
public class GameController extends BaseController {

	@Resource
	private GameService gameService;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, Game obj) {
		return super.add(request, obj);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request, Game obj) {
		
		return super.endit(request, obj);
	}

	@Override
	public void initService() {
		super.initService();
		this.baseService=gameService;
		this.table="game";
		this.business="active";
		del=false;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		StringBuffer where=new StringBuffer(" and n.status=0");
		return super.list(request, where);
	}
	
	
}
