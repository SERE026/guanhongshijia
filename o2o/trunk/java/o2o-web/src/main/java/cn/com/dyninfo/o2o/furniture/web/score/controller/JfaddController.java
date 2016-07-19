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

package cn.com.dyninfo.o2o.furniture.web.score.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.old.service.SendMessageService;
import cn.com.dyninfo.o2o.old.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.old.service.HuiyuanService;
import cn.com.dyninfo.o2o.old.model.Jfadd;
import cn.com.dyninfo.o2o.old.model.Jffa;
import cn.com.dyninfo.o2o.old.service.JfaddService;
import cn.com.dyninfo.o2o.old.service.JffaService;

/**
 * 积分增加管理
 * @author lxf
 *
 */
@Controller
@RequestMapping("/manage/jfadd")
public class JfaddController extends BaseController{

	@Resource
	private JfaddService jfaddService;

	@Resource
	private JffaService jffaService;

	@Resource
	private HuiyuanService huiyuanService;
	
	 @Resource
	 private SendMessageService sendMessageService;

	@Override
	public void initService(){
		super.initService();
		this.baseService=jfaddService;
		this.business="pageInfo";
		this.table="jf";
	}

	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		StringBuffer where=new StringBuffer();
		String jf=request.getParameter("jf");
		String jfs=request.getParameter("jfs");
		if(jfs!=""&&jfs!=null&&jf!=""&&jf!=null){
			where.append("and n.jf >'").append(jf).append("'and n.jf<'").append(jfs).append("'");
		}
		ModelAndView mav= new ModelAndView();
		mav.addObject("info",jfaddService.getListByWhere(new StringBuffer("")));
		mav.addObject("Info",jffaService.getObjById("1"));
		
		PageInfo page = new PageInfo();
		if(request.getAttribute("pageSize")!=null){
			page.setPageSize((Integer)request.getAttribute("pageSize"));
		}else{
			page.setPageSize(25);
		}
		if(request.getParameter("pageNo")!=null&&request.getParameter("pageNo").length()>0){
			Pattern pattern =Pattern.compile("^[0-9]+$");
			Matcher m = pattern.matcher(request.getParameter("pageNo"));
			if(m.matches()){
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			}
		}else
			page.setPageNo(1);
		String memberName=request.getParameter("memberName");
		String shangjiaName=request.getParameter("shangjiaName");
		if(memberName!=null&&!memberName.equals("")){
			where.append(" and n.nickname like '%"+memberName+"%' ");
			mav.addObject("memberName", memberName);
		}
		
		if(shangjiaName!=null&&!shangjiaName.equals("")){
			where.append(" and n.shangJiaInfo.name like '%"+shangjiaName+"%' ");
			mav.addObject("shangjiaName", shangjiaName);
		}
		mav.addAllObjects(huiyuanService.getListByPageWhere(where, page));
		mav.addObject("jf", jf);
		mav.addObject("jfs", jfs);
		mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
		mav.setViewName("/pageInfo/jf/list");
		return mav;
	}
	/**
	 * 积分增加方案启用
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ok", method=RequestMethod.POST)
	public ModelAndView ok(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String[] id=request.getParameterValues("id");
		String[] jf=request.getParameterValues("zjjf");
		try{
			for(int i=0;i<id.length;i++){
				Jfadd info=(Jfadd) jfaddService.getObjById(id[i]);
				for(int j=0;j<jf.length;j++){
					if(info!=null&&jf!=null&&i==j){
						info.setJfadd_zjjf(Double.parseDouble(jf[i]));
						jfaddService.updateObj(info);
					}
				}
			}
			mav.addObject("C_STATUS", 1);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);

		}
		mav.setViewName("redirect:/html/manage/jfadd/list");
		return mav;
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request,Jfadd info){
		ModelAndView mav=new ModelAndView();
		jfaddService.addObj(info);
		mav.setViewName("redirect:/html/manage/jfadd/list");
		return mav;
	}

	/**
	 * 更改
	 * @param request
	 * @param info
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public ModelAndView endit(HttpServletRequest request,Jffa info){
		ModelAndView mav=new ModelAndView();
		try {
			info.setJffa_xfjf(0);
			jffaService.updateObj(info);
			mav.addObject("C_STATUS",1);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("C_STATUS", 0);
		}
		mav.setViewName("redirect:/html/manage/jfadd/list");
		return mav;
	}
	
	
	/**
	 * 会员积分增加跳转
	 */
	 @RequestMapping("/{id}/jfUpdate")
	 public ModelAndView jfUpdate(@PathVariable String id,HttpServletRequest request){
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("info",huiyuanService.getObjById(id));
		 mav.setViewName("/pageInfo/jf/jfadd");
		 return mav;
	 }
	 

		/**
		 * 会员积分增加
		 */
		@RequestMapping("/jfUpdate")
		public ModelAndView hyjfUpdate(HttpServletRequest request,
				HttpServletResponse response, HuiyuanInfo userInfo) {
			
				String id=request.getParameter("huiYuan_id");
				String jf=request.getParameter("jf");
				int add_jf=Integer.parseInt(jf);
				HuiyuanInfo info=(HuiyuanInfo)huiyuanService.getObjById(id);
				info.setJf(info.getJf()+add_jf);
				info.setJfData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				huiyuanService.updateObj(info);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("redirect:/html/manage/jfadd/list");
				
				String isPhone=request.getParameter("isPhone");
				String isEmail=request.getParameter("isEmail");
				String phoneContext=request.getParameter("phoneContext");
				String emialContext=request.getParameter("emialContext");
				if(isPhone.equals("1")){
					if(phoneContext.length()>0){
						sendMessageService.addData("0", phoneContext, info.getPhone(), 
								"会员："+info.getUserName()+"，账号:"+info.getName()+",编号:"+
								info.getHuiYuan_id(),"送礼啦");
					}else{
						sendMessageService.addData("0", info.getUserName()+" 你好，炫品妆成向你的账号中赠送了"+add_jf+"积分，请尽快登陆使用！", info.getPhone(), 
								"会员："+info.getUserName()+"，账号:"+info.getName()+",编号:"+
								info.getHuiYuan_id(),"送礼啦");
					}
				}
				if(isEmail.equals("1")){
					if(emialContext.length()>0){
						sendMessageService.addData("1", emialContext, info.getEmail(), 
								"会员："+info.getUserName()+"，账号:"+info.getName()+",编号:"+
								info.getHuiYuan_id(),"送礼啦");
					}else{
						sendMessageService.addData("1", info.getUserName()+" 你好，炫品妆成向你的账号中赠送了"+add_jf+"积分，请尽快登陆使用！", info.getEmail(), 
								"会员："+info.getUserName()+"，账号:"+info.getName()+",编号:"+
								info.getHuiYuan_id(),"送礼啦");
					}
				}
	    	return mav;
		}

}
