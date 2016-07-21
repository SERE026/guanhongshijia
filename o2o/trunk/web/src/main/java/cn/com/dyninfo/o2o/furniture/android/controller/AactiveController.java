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

package cn.com.dyninfo.o2o.furniture.android.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.sys.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.active.model.ActiveMemberInfo;
import cn.com.dyninfo.o2o.furniture.web.active.model.Game;
import cn.com.dyninfo.o2o.furniture.web.active.model.GameParam;
import cn.com.dyninfo.o2o.furniture.web.active.service.ActiveMemberService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameActiveService;
import cn.com.dyninfo.o2o.furniture.web.active.service.GameParamService;
import cn.com.dyninfo.o2o.furniture.web.active.widget.ComparatorBean;
import cn.com.dyninfo.o2o.furniture.web.active.widget.ZhunaPanBean;
import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.address.service.AreaService;
import cn.com.dyninfo.o2o.furniture.web.goods.model.Goods;
import cn.com.dyninfo.o2o.furniture.web.goods.service.GoodsService;
import cn.com.dyninfo.o2o.furniture.web.goods.service.PagModInGoodsService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;

/**
 * android 活动
 * @author feng
 *
 */
@Controller
@RequestMapping("/aactive")
public class AactiveController{
    
	@Resource
	private CommentService commentService;
	
	  @Resource
	   private PagModInGoodsService pagModInGoodsService;
	  
		@Resource
		private AreaService areaService;
		
		@Resource
		private GameActiveService gameActiveService;
		

		@Resource
		private GameParamService gameParamService;
		
		
		@Resource
		private GoodsService goodsService;
		
		@Resource
		private ActiveMemberService activeMemberService;
		
		@Resource
		private HuiyuanService huiyuanService;
		/*
		 * 活动商品列表
		 */
	 @RequestMapping("/list")
	 public void login(HttpServletRequest request,HttpServletResponse response){
		 	String id=request.getParameter("id");
		 	AreaInfo arear=(AreaInfo)areaService.getObjById(id);
			String pageno=request.getParameter("pageno");
		 	PageInfo page=new PageInfo();
			page.setPageNo(Integer.parseInt(pageno));
			page.setPageSize(10);
			Map mapdata=pagModInGoodsService.getActGood(37, (arear!=null?arear.getId():null), null, page, null);
			List list=(List) mapdata.get("data");
			if(list.size()>0){
				String json="{\"status\":0,\"data\":[";
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i);
					//计算出折扣
					String xmoney =  map.get("money").toString();
					Float xm = Float.valueOf(xmoney);
					String money =  map.get("xmoney").toString();
					Float m = Float.valueOf(money);
					float discount= (float)(Math.round(xm/m*100))/10;
					
					json+="{\"goodId\":\""+map.get("goodId").toString()
							+"\",\"actId\":\""+map.get("actId").toString()
							+"\",\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"
							+map.get("image").toString()+"\",\"goodName\":\""
							+map.get("goodName").toString().replace(" ", "")
							+"\",\"xmoney\":"+
					map.get("xmoney").toString()+",\"money\":"
							+map.get("money").toString()+",\"shopid\":"
					+map.get("shopid")+",\"shopname\":\""+map.get("shopname")
					+"\",\"discount\":\""+discount+"\"," +
							"\"etimel\":\""+map.get("etimel")+"\"},";
				}
				if(json.length()>1){
					json=json.substring(0,json.length()-1);
				}
				json+="]}";
				ResponseUtil.printl(response, json, "json");
				
			}else{
				 ResponseUtil.printl(response, "{\"status\":1}", "json");
			 }
	 }
	 
		/*
		 * 活动商品详情
		 */
	 @RequestMapping("/detail")
	 public void detail(HttpServletRequest request,HttpServletResponse response){
		 	String actid=request.getParameter("actid");
			String goodId=request.getParameter("goodId");
			String memberId=request.getParameter("memberId");
		 	Active act=null;
		 	if(!actid.equals("0")){
		 		act=(Active)gameActiveService.getObjById(actid);
		 	}
		 	Goods goods=(Goods) goodsService.getObjById(goodId);
		 	StringBuffer json=new StringBuffer("{\"status\":0,");
		 	String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		 	int count=activeMemberService.getCountByWhere(new StringBuffer(" and n.date='"+time.substring(0,10)+"' and n.act.id='"+actid+"' and n.member.huiYuan_id='"+memberId+"' "));
		 	if(act!=null&&goods!=null){
		 		
				 Double money=0.0;
				 Double val=act.getVal();
				 if(act.getType()!=null&&act.getType().equals("2")){
					 money=goods.getSalesMoney()*val/10;
				 }else if(act.getType()!=null&&act.getType().equals("1")){
					 money=goods.getSalesMoney()-val;
				 }else{
					 json.append("\"gameName\":\""+act.getGame().getPlugin()+"\",");
				 }
				Double xmoney= goods.getBazaarMoney();
				float discount=(float)(Math.round(xmoney/money*100))/10;
				json.append("\"goodId\":\""+goods.getGoods_id()+"\",");
				json.append("\"actId\":\""+act.getActive_id()+"\",");
				json.append("\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+goods.getDefaultImage()+"\",");
				json.append("\"goodName\":\""+goods.getName().replace(" ", "")+"\",");
				json.append("\"xmoney\":"+goods.getBazaarMoney()+",");
				json.append("\"money\":"+money+",");
				json.append("\"ps\":\""+act.getPs()+"\",");
				json.append("\"discount\":\""+discount+"\",");
				json.append("\"shopid\":\""+goods.getMerchants().getShangjia_id()+"\",");
				json.append("\"shopname\":\""+goods.getMerchants().getName()+"\",");
				json.append("\"ganmeCount\":"+count+"}");//游戏次数
				 ResponseUtil.printl(response, json.toString(), "json");
			 }else if(goods!=null){
				 
				 Double money=goods.getSalesMoney();
				Double xmoney= goods.getBazaarMoney();
				float discount=(float)(Math.round(xmoney/money*100))/10;
				json.append("\"goodId\":\""+goods.getGoods_id()+"\",");
				json.append("\"actId\":\"0\",");
				json.append("\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+goods.getDefaultImage()+"\",");
				json.append("\"goodName\":\""+goods.getName().replace(" ", "")+"\",");
				json.append("\"xmoney\":"+goods.getBazaarMoney()+",");
				json.append("\"money\":"+money+",");
				json.append("\"ps\":\"\",");
				json.append("\"discount\":\""+discount+"\",");
				json.append("\"ganmeCount\":0}");//游戏次数
				 ResponseUtil.printl(response, json.toString(), "json");
				 
			 }else{
				 ResponseUtil.printl(response, "{\"status\":1}", "json");
			 }
	 }
	 
	 /**
	  * 获取游戏规则
	  * @param request
	  * @param response
	  */
	 @RequestMapping("/addgameInfo")
	 public void addGameInfo(HttpServletRequest request,HttpServletResponse response){
		 String goodId= request.getParameter("goodId");
		 String actId=request.getParameter("actid");
		 String memberId= request.getParameter("memberId");
		 
		 HuiyuanInfo memeber=(HuiyuanInfo) huiyuanService.getObjById(memberId);
		 Active act=(Active)gameActiveService.getObjById(actId);
		 if(memeber!=null&&act!=null){
			String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			List list=gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动diandian' and n.objId='"+act.getActive_id()+"' "));
			String result="";
			if(list.size()>0){
				GameParam p=(GameParam) list.get(0);
				int count=Integer.parseInt(request.getParameter("count"));
				double max=Double.parseDouble(p.getParam13());
				double click=Double.parseDouble(p.getParam12());
				
				ActiveMemberInfo actMember=new ActiveMemberInfo();
				actMember.setMember(memeber);
				actMember.setMoney(click*count>max?max:click*count);
				actMember.setLev(0);
				actMember.setDate(time.substring(0,10));
				actMember.setTime(time);
				actMember.setAct(act);
				actMember.setGoods((Goods)goodsService.getObjById(goodId));
				activeMemberService.addObj(actMember);
				result="{\"status\":0,\"agmId\":"+actMember.getAct_meb_id()+"}";
				
			}else{
				result="{\"status\":1}";
			}
			ResponseUtil.printl(response,result, "json");
	 }}
	 /**
	  * 获取游戏规则
	  * @param request
	  * @param response
	  */
	 @RequestMapping("/gameParam")
	 public void getGameParam(HttpServletRequest request,HttpServletResponse response){
		 String goodId=request.getParameter("goodId");//产品ID
		 String memberId=request.getParameter("memberId");//会员Id
		 String actid=request.getParameter("actid");//活动ID
		 StringBuffer json=new StringBuffer("{\"status\":0,");
		 HuiyuanInfo memeber=(HuiyuanInfo) huiyuanService.getObjById(memberId);
		 Active act=(Active)gameActiveService.getObjById(actid);
		 String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		 String gameName=act.getGame().getPlugin();
		 Goods good= (Goods) goodsService.getObjById(goodId);
		 json.append("\"lat\":"+good.getMerchants().getLatitude()+",");
		 json.append("\"lng\":"+good.getMerchants().getLongitude()+",");
		 if(gameName.equals("zhuanpan")){
			 List<GameParam> list=(List<GameParam>) gameParamService.getListByWhere(new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动rotary' and n.objId='"+act.getActive_id()+"' "));
			 if(list.size()>0){
			 	json.append("\"ganmeName\":\""+act.getGame().getPlugin()+"\",");
				List<ZhunaPanBean> l= sort(list.get(0));
				int x=getV(l.get(0).v);
				Random r=new Random();
				int z=r.nextInt(x);
				for(ZhunaPanBean zpb:sort(list.get(0))){
					if(z<=zpb.v*x){
						ActiveMemberInfo actMember=new ActiveMemberInfo();
						actMember.setMember(memeber);
						actMember.setMoney(Double.parseDouble(""+zpb.price));
						actMember.setLev(zpb.des);
						actMember.setDate(time.substring(0,10));
						actMember.setTime(time);
						actMember.setAct(act);
						actMember.setGoods(good);
						activeMemberService.addObj(actMember);
						json.append("\"money\":"+zpb.price+",");//转盘名次
						json.append("\"lev\":"+zpb.des+",");//转盘名次
						json.append("\"agmId\":"+actMember.getAct_meb_id()+"}");//游戏ID
						ResponseUtil.printl(response, json.toString(), "json");
						break;
					}
				}
			}else{
				ResponseUtil.printl(response, "{\"status\":1}", "json");
			}
		 }else if(gameName.equals("diandian")){
			 List<GameParam> list=(List<GameParam>) gameParamService.getListByWhere(
					 new StringBuffer(" and n.game.game_id="+act.getGame().getGame_id()+" and n.obj='游戏活动diandian' and n.objId='"+act.getActive_id()+"' "));
			 if(list.size()>0){
				 GameParam p=list.get(0);
				 json.append("\"ganmeName\":\""+act.getGame().getPlugin()+"\",");
				 json.append("\"click\":");
				 json.append(p.getParam12());
				 json.append(",\"max\":");
				 json.append(p.getParam13());
				 json.append("}");
				 ResponseUtil.printl(response, json.toString(), "json");
			 }else{
				ResponseUtil.printl(response, "{\"status\":1}", "json");
			}
		 }
			
			 
			 
		 
	 }
	 
	 public int getV(float v){
			int i=1;
			while(true){
				if(v!=0&&v<1){
					v*=10;
					i*=10;
				}else{
					return i;
				}
			}
		}
	 
	 public List<ZhunaPanBean> sort(GameParam p){
			List list=new ArrayList();
			ZhunaPanBean b=new ZhunaPanBean();
			b.des=0;
			b.price=Float.parseFloat(p.getParam1());
			b.v=Float.parseFloat(p.getParam2());
			list.add(b);
			
			b=new ZhunaPanBean();
			b.des=1;
			b.price=Float.parseFloat(p.getParam3());
			b.v=Float.parseFloat(p.getParam4());
			list.add(b);
			
			b=new ZhunaPanBean();
			b.des=2;
			b.price=Float.parseFloat(p.getParam5());
			b.v=Float.parseFloat(p.getParam6());
			list.add(b);
			
			b=new ZhunaPanBean();
			b.des=3;
			b.price=Float.parseFloat(p.getParam7());
			b.v=Float.parseFloat(p.getParam8());
			list.add(b);
			
			b=new ZhunaPanBean();
			b.des=4;
			b.price=Float.parseFloat(p.getParam9());
			b.v=Float.parseFloat(p.getParam10());
			list.add(b);
			
			b=new ZhunaPanBean();
			b.des=5;
			b.price=Float.parseFloat(p.getParam11());
			b.v=Float.parseFloat(p.getParam12());
			list.add(b);
			ComparatorBean comparator=new ComparatorBean();
			Collections.sort(list, comparator);
			return list;
		}
	 /*
	  * 游戏
	  */
	 @RequestMapping("/game")
	 public void game(HttpServletRequest request,HttpServletResponse response){
		 String actid=request.getParameter("actid");
		 Active act=(Active)gameActiveService.getObjById(actid);
		 Game game = act.getGame();
		 if(game!=null){
			 String json="{\"status\":0,\"data\":[";
			 json+="{\"gamename\":\""+ game.getPlugin()+"\"}";
			 json+="]}";
			 ResponseUtil.printl(response, json, "json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 /*
	  * 摇一遥
	  */
	 @RequestMapping("/yaoyiyao")
	 public void yaoyiyao(HttpServletRequest request,HttpServletResponse response){
		 String id=request.getParameter("id");
		 PageInfo page=new PageInfo();
		 page.setPageNo(1);
		 page.setPageSize(100);
		 AreaInfo arear=(AreaInfo)areaService.getObjById(id);
		 Goods goods=(Goods) pagModInGoodsService.getRandGoods(arear!=null?arear.getId():"");
		 if(goods!=null){
				 String json = "{\"status\":0,\"lng\":"+goods.getMerchants().getLongitude()+",\"goodsid\":\""+goods.getGoods_id()+"\",\"xmoney\":"+goods.getSalesMoney()+",\"lat\":"+goods.getMerchants().getLatitude()+",\"money\":"+goods.getBazaarMoney()+",\"image\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+goods.getDefaultImage()+"\",\"shopid\":\""+goods.getMerchants().getShangjia_id()+"\",\"shopname\":\""+goods.getMerchants().getName()+"\",\"goodName\":\""+goods.getName().replace(" ", "");
				 json+="\"}";
				 ResponseUtil.printl(response, json, "json");
		
		 }else{
			 	ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 /*
	  * 爆品
	  */
	 @RequestMapping("/baoping")
	 public void baoping(HttpServletRequest request,HttpServletResponse response){
		 String id=request.getParameter("id");
		 String pageno=request.getParameter("pageno");
		 PageInfo page=new PageInfo();
		 page.setPageNo(Integer.parseInt(pageno));
		 page.setPageSize(10);
		 AreaInfo arear=(AreaInfo)areaService.getObjById(id);
		 List<Goods> data=pagModInGoodsService.getGoods(45, arear!=null?arear.getId():null, 102, page, null);
		 if(data.size()>0){
			List list=new ArrayList();
			String jsondata="{\"status\":0,\"data\":[";
			for(int i=0;i<data.size();i++){
				Goods g=data.get(i);
				jsondata+="{\"goods_id\":\""+g.getGoods_id()+"\",";
				jsondata+="\"name\":\""+g.getName().replace(" ", "")+"\",";
				jsondata+="\"salesMoney\":"+g.getSalesMoney()+",";
				jsondata+="\"bazaarMoney\":"+g.getBazaarMoney()+",";
				jsondata+="\"discount\":"+g.getDiscount()+",";
				jsondata+="\"shopid\":"+g.getMerchants().getShangjia_id()+",";
				jsondata+="\"shopname\":\""+g.getMerchants().getName()+"\",";
				jsondata+="\"defaultImage\":\"http://" + request.getServerName() + "/" + Constants.ADMIN_ADDRESS + "/upload/goods/"+g.getDefaultImage()+"\"},";
			}
			if(jsondata.length()>0)
				jsondata=jsondata.substring(0,jsondata.length()-1);
			jsondata+="]}";
			ResponseUtil.printl(response,jsondata,"json");
		 }else{
			 ResponseUtil.printl(response, "{\"status\":1}", "json");
		 }
	 }
	 
	 /*
	  * 商品详情  
	  */
	 @RequestMapping("/goodstuwen")
	 public ModelAndView goodstuwen(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		String goodId=request.getParameter("goodId");
		Goods goods = (Goods) goodsService.getObjById(goodId);
		mav.addObject("goods", goods);
		mav.setViewName("/android/aactive/goodstuwen");
		return mav;
	 }
	 
	 /*
	  * 晒单详情  
	  */
	 @RequestMapping("/saidantuwen")
	 public ModelAndView saidantuwen(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		String pageno=request.getParameter("pageno");
	 	PageInfo page=new PageInfo();
	 	if(pageno == null)
	 		pageno = "1";
		page.setPageNo(Integer.parseInt(pageno));
		page.setPageSize(10);
		String goodId=request.getParameter("goodId");
		Goods good = (Goods) goodsService.getObjById(goodId);
		Map map=commentService.getListByPageWhere(
				new StringBuffer(" and n.ginfo.goods_id="
		+good.getGoods_id()+" and n.status=0 and n.isShow=1 "),page);
//		System.out.println(((List)map.get("DATA")).size());
//		System.out.println(((List)map.get("DATA")).get(0));
		mav.addObject("DATA", map.get("DATA"));
		mav.setViewName("/android/aactive/saidantuwen");
		return mav;
	 }
}