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

package cn.com.dyninfo.o2o.furniture.web.count.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.controller.BaseController;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.MerchantMoney;
import cn.com.dyninfo.o2o.furniture.web.publish.service.MerchantMoneyService;

/**
 * 店铺流水信息
 * @author Zebe
 * @date 2014/4/28
 *
 */
@Controller
@RequestMapping("/manage/sjhy")
public class SjhyController extends BaseController{

	@Resource
	private OrderService orderService;
	
	@Resource
	private MerchantMoneyService merchantMoneyService;

	/**
	 * 流水列表
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping("/list")
	public ModelAndView order(HttpServletRequest request) {
		
		// 创建模型视图，并获取传入的参数
		ModelAndView mva=new ModelAndView();
		String pageNo = request.getParameter("pageNo");
		String btime = request.getParameter("btime");
		String etime = request.getParameter("etime");
		
		// 设置分页信息，并创建查询语句
		StringBuffer where = new StringBuffer();
		PageInfo page = new PageInfo();
		page.setPageSize(25);
		int no = 0;
		if (pageNo != null && ! "".equals(pageNo)) {
			no = Integer.parseInt(pageNo);
		}
		if (no > 0) {
			page.setPageNo(no);
		} else {
			page.setPageNo(1);
		}
		if (btime != null && !"".equals(btime)) where.append(" and n.time >='" + btime + " 00:00:00'");
		if (etime != null && !"".equals(etime)) where.append(" and n.time <='" + etime + " 24:00:00'");
		
		// 获取当前登录的用户信息，如果登录角色是商家
		UserInfo user = (UserInfo) request.getSession().getAttribute("UserInfo");
		if(user.getIs_user().equals("1")) {
			where.append(" and n.merchant.shangjia_id='").append(user.getShanfJiaInfo().getShangjia_id()).append("' order by n.time desc");
			// 如果设置了查询时间段，添加查询条件
		}
		
		// 如果登录角色是代理
		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		if(daili != null){
//			System.out.println("代理登录！");
			String area[]=daili.getAreaid().split(",");
			String ids="(";
			for (int i=0; i<area.length; i++){
				ids += "'"+area[i].replace("|", "").replace("%", "")+"',";
//				System.out.println(ids);
			}
			if (ids.length() > 1){
				ids = ids.substring(0, ids.length()-1);
			}
			ids += ")";
			where.append(" and n.merchants.city.id in "+ids);
			where.append(" and n.huiyuan.shangJiaInfo.shangjia_id !='").append(daili.getShanfJiaInfo().getShangjia_id()).append("'");
		}

		mva.addAllObjects(merchantMoneyService.getListByPageWhere(where, page));
		mva.addObject("PAGE_INFO", page);
		mva.addObject("btime",btime);
		mva.addObject("etime",etime);
		mva.setViewName("/count/sjhy/list");
		return mva;
	}

	/**
	 * 导出流水
	 * @param request
	 * @param response
	 */
	@RequestMapping("/export")
	public void daochu(HttpServletRequest request, HttpServletResponse response){
		
		// 创建模型视图，并获取传入的参数
		ModelAndView mva=new ModelAndView();
		String pageNo = request.getParameter("pageNo");
		String btime = request.getParameter("btime");
		String etime = request.getParameter("etime");
		
		// 设置分页信息，并创建查询语句
		StringBuffer where = new StringBuffer();
		if (btime != null && !"".equals(btime)) where.append(" and n.time >='" + btime + " 00:00:00'");
		if (etime != null && !"".equals(etime)) where.append(" and n.time <='" + etime + " 24:00:00'");
		// 获取当前登录的用户信息，如果登录角色是商家
		UserInfo user = (UserInfo) request.getSession().getAttribute("UserInfo");
		if(user.getIs_user().equals("1")) {
			where.append(" and n.merchant.shangjia_id='").append(user.getShanfJiaInfo().getShangjia_id()).append("'");
			// 如果设置了查询时间段，添加查询条件
		
		}
		

		
		// 如果登录角色是代理
		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		if(daili != null){
//			String area[]=daili.getAreaid().split(",");
//			String ids="(";
//			for(int i=0;i<area.length;i++){
//				ids+="'"+area[i].replace("|", "").replace("%", "")+"',";
//			}
//			if(ids.length()>1){
//				ids=ids.substring(0,ids.length()-1);
//			}
//			ids+=")";
//			where.append(" and n.merchants.city.id in "+ids);
//			where.append(" and n.huiyuan.shangJiaInfo.shangjia_id !='").append(daili.getShanfJiaInfo().getShangjia_id()).append("'");
		}
		
		// 查询并导出数据
		List list01 = merchantMoneyService.getListByWhere(where);
//		String[] title = { "会员名称", "订单号", "订单完成时间", "归属店铺", "消费金额"};
		String[] title = { "日期", "会员名称", "资产动态", "店铺名称","详细说明"};
		String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "-liushui.xls";
		try{
			OutputStream os = response.getOutputStream();  
			response.reset();// 清空输出流     
			response.setHeader("Content-disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));// 设定输出文件头     
			response.setContentType("application/msexcel");// 定义输出类型    
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet sheet = wwb.createSheet("店铺流水", 0); 
			Label label;  
			//设置标题行  
			for (int i = 0; i < title.length; i++) {  
				// Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是z  
				// 在Label对象的子对象中指明单元格的位置和内容  
				label = new Label(i, 0, title[i]);  
				// 将定义好的单元格添加到工作表中  
				sheet.addCell(label);  
			}
			int h=1;
			for(int i=0;i<list01.size();i++){
				MerchantMoney mmoney = (MerchantMoney) list01.get(i);
				label = new Label(0, h, mmoney.getTime());  
				// 将定义好的单元格添加到工作表中
				sheet.addCell(label);
				label = new Label(1, h, mmoney.getHuiyuan().getName());  
				// 将定义好的单元格添加到工作表中  
				sheet.addCell(label);
				label = new Label(2, h, String.valueOf(mmoney.getMoney()));  
				// 将定义好的单元格添加到工作表中  
				sheet.addCell(label);
				label = new Label(3, h, mmoney.getMerchant().getName());  
				// 将定义好的单元格添加到工作表中  
				sheet.addCell(label);
				
				label = new Label(4, h, mmoney.getPs());  
				// 将定义好的单元格添加到工作表中  
				sheet.addCell(label);
				
				h++;
			}
			// 写入数据  
			wwb.write();  
			// 关闭文件  
			wwb.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}