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

package cn.com.dyninfo.o2o.furniture.web.active.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.old.dao.GameParamDAO;
import cn.com.dyninfo.o2o.old.model.Active;
import cn.com.dyninfo.o2o.old.model.GameParam;

@Component
public class RotaryGamePlugin extends AbstractActivePlugin {

	@Resource
	private GameParamDAO gameParamDAO;
	@Resource
	private HttpServletRequest request;
	
	@Autowired
	public RotaryGamePlugin(ActivePlugin activePlugin){
		this.addPlugin(activePlugin);
	}
	@Override
	public void addActiveAfter(Active active) {
		String zp_param1=request.getParameter("zp_param1");
		String zp_param2=request.getParameter("zp_param2");
		String zp_param3=request.getParameter("zp_param3");
		String zp_param4=request.getParameter("zp_param4");
		String zp_param5=request.getParameter("zp_param5");
		String zp_param6=request.getParameter("zp_param6");
		String zp_param7=request.getParameter("zp_param7");
		String zp_param8=request.getParameter("zp_param8");
		String zp_param9=request.getParameter("zp_param9");
		String zp_param10=request.getParameter("zp_param10");
		String zp_param11=request.getParameter("zp_param11");
		String zp_param12=request.getParameter("zp_param12");
		String gameType=request.getParameter("gameTYpe");
		if(zp_param1!=null&&zp_param2!=null&&zp_param3!=null&&
				zp_param4!=null&&zp_param5!=null&&zp_param6!=null&&
				zp_param7!=null&&zp_param8!=null&&zp_param9!=null&&
				zp_param10!=null&&zp_param11!=null&&zp_param12!=null&&gameType.equals("rotary")){
			GameParam gp=new GameParam();
			gp.setParam1(zp_param1);
			gp.setParam2(zp_param2);
			gp.setParam3(zp_param3);
			gp.setParam4(zp_param4);
			gp.setParam5(zp_param5);
			gp.setParam6(zp_param6);
			gp.setParam7(zp_param7);
			gp.setParam8(zp_param8);
			gp.setParam9(zp_param9);
			gp.setParam10(zp_param10);
			gp.setParam11(zp_param11);
			gp.setParam12(zp_param12);
			gp.setGame(active.getGame());
			gp.setObj("游戏活动rotary");
			gp.setObjId(active.getActive_id());
			gameParamDAO.addObj(gp);
		}
	}

	@Override
	public Map<String, String> getGameParam(Active active) {
		Map<String, String> map=new HashMap<String, String>();
		List list=gameParamDAO.getListByWhere(new StringBuffer(" and n.obj='游戏活动rotary' and n.game.game_id="+active.getGame().getGame_id()+" and n.objId="+active.getActive_id()));
		
		if(list.size()>0){
			GameParam param=(GameParam) list.get(0);
			map.put("game_param_id", ""+param.getGame_param_id());
			map.put("zp_param1", param.getParam1());
			map.put("zp_param2", param.getParam2());
			map.put("zp_param3", param.getParam3());
			map.put("zp_param4", param.getParam4());
			map.put("zp_param5", param.getParam5());
			map.put("zp_param6", param.getParam6());
			map.put("zp_param7", param.getParam7());
			map.put("zp_param8", param.getParam8());
			map.put("zp_param9", param.getParam9());
			map.put("zp_param10", param.getParam10());
			map.put("zp_param11", param.getParam11());
			map.put("zp_param12", param.getParam12());
		}
		return map;
	}

	@Override
	public String getName() {
		return "转盘游戏插件";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	@Override
	public void editActiveAfter(Active active) {
		List pramList=gameParamDAO.getListByWhere(new StringBuffer(" and n.obj='游戏活动rotary'  and n.objId='"+active.getActive_id()+"' "));
		
		String zp_param1=request.getParameter("zp_param1");
		String zp_param2=request.getParameter("zp_param2");
		String zp_param3=request.getParameter("zp_param3");
		String zp_param4=request.getParameter("zp_param4");
		String zp_param5=request.getParameter("zp_param5");
		String zp_param6=request.getParameter("zp_param6");
		String zp_param7=request.getParameter("zp_param7");
		String zp_param8=request.getParameter("zp_param8");
		String zp_param9=request.getParameter("zp_param9");
		String zp_param10=request.getParameter("zp_param10");
		String zp_param11=request.getParameter("zp_param11");
		String zp_param12=request.getParameter("zp_param12");
		String gameType=request.getParameter("gameTYpe");
		if(zp_param1!=null&&zp_param2!=null&&zp_param3!=null&&
				zp_param4!=null&&zp_param5!=null&&zp_param6!=null&&
				zp_param7!=null&&zp_param8!=null&&zp_param9!=null&&
				zp_param10!=null&&zp_param11!=null&&zp_param12!=null&&gameType.equals("rotary")){
		if(pramList.size()>0){
			GameParam gp=(GameParam) pramList.get(0);
			gp.setParam1(zp_param1);
			gp.setParam2(zp_param2);
			gp.setParam3(zp_param3);
			gp.setParam4(zp_param4);
			gp.setParam5(zp_param5);
			gp.setParam6(zp_param6);
			gp.setParam7(zp_param7);
			gp.setParam8(zp_param8);
			gp.setParam9(zp_param9);
			gp.setParam10(zp_param10);
			gp.setParam11(zp_param11);
			gp.setParam12(zp_param12);
			gp.setGame(active.getGame());
			gp.setObj("游戏活动rotary");
			gp.setObjId(active.getActive_id());
			gameParamDAO.updateObj(gp);
		}
		
	}
	}

}
