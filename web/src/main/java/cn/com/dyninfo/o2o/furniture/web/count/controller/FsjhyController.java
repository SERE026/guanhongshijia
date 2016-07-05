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
import java.util.HashMap;
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
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;

/**
 * 非商家会员消费统计
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/fsjhy")
public class FsjhyController extends BaseController{

	
	      @Resource
	      private OrderService orderService;
	      
	      
	      /**
		 	 * 列表
		 	 * 
		 	 * @param request
		 	 * @return
		 	 */
		 	@RequestMapping("/list")
		 	public ModelAndView order(HttpServletRequest request) {
		 		StringBuffer where = new StringBuffer();
		 		ModelAndView mva=new ModelAndView();
		 		String btime = request.getParameter("btime");
		 		String etime = request.getParameter("etime");
		 		PageInfo page = new PageInfo();
				page.setPageSize(25);
				int no = 0;
				if (request.getParameter("pageNo") != null&&!request.getParameter("pageNo").equals("")) {
					no = Integer.parseInt(request.getParameter("pageNo"));

				}
				if (no > 0) {
					page.setPageNo(no);
				} else
					page.setPageNo(1);
				UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
		 		if(info.getIs_user().equals("1")){
		 			where.append(" and n.merchants.id ='").append(info.getShanfJiaInfo().getShangjia_id()).append("'");
		 		}
		 		if (btime != "" && btime != null) {
		 			where.append(" and n.suretime >='" + btime + "24:00:00'");
		 		}
		 		if (etime != "" && etime != null) {
		 			where.append(" and n.suretime <='" + etime + " 24:00:00'");
		 		}
		 		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		 		if(daili!=null){
					String area[]=daili.getAreaid().split(",");
					String ids="(";
					for(int i=0;i<area.length;i++){
						ids+="'"+area[i].replace("|", "").replace("%", "")+"',";
					}
					if(ids.length()>1){
						ids=ids.substring(0,ids.length()-1);
					}
					ids+=")";
					where.append(" and n.merchants.city.id in "+ids+"");
				}
		 		where.append(" and n.isPay='1' and n.status='0' and n.state<=3");
		 		HashMap<String, ?> mapp  = 	orderService.getListByPageWhere(where, page);
		 		List list01 = (List)mapp.get("DATA");
				page = (PageInfo) mapp.get("PAGE_INFO");
				mva.addObject("LIST", list01);
				mva.addObject("PAGE_INFO", page);
				mva.addObject("btime",btime);
				mva.addObject("etime",etime);
				mva.setViewName("/count/fsjhy/list");
		 		return mva;
		 	}
		 	
		 	@RequestMapping("/export")
		 	public void daochu(HttpServletRequest request,HttpServletResponse response){
		 		StringBuffer where = new StringBuffer();
		 		ModelAndView mva=new ModelAndView();
		 		String btime = request.getParameter("btime");
		 		String etime = request.getParameter("etime");
		 		PageInfo page = new PageInfo();
		 		page.setPageSize(60000);
				int no = 0;
				if (request.getParameter("pageNo") != null&&!request.getParameter("pageNo").equals("")) {
					no = Integer.parseInt(request.getParameter("pageNo"));

				}
				if (no > 0) {
					page.setPageNo(no);
				} else
					page.setPageNo(1);
				UserInfo info=(UserInfo) request.getSession().getAttribute("UserInfo");
		 		if(info.getIs_user().equals("1")){
		 			where.append(" and n.merchants.id ='").append(info.getShanfJiaInfo().getShangjia_id()).append("'");
		 		}
		 		if (btime != "" && btime != null) {
		 			where.append(" and n.suretime >='" + btime + "24:00:00'");
		 		}
		 		if (etime != "" && etime != null) {
		 			where.append(" and n.suretime <='" + etime + " 24:00:00'");
		 		}
		 		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		 		if(daili!=null){
					String area[]=daili.getAreaid().split(",");
					String ids="(";
					for(int i=0;i<area.length;i++){
						ids+="'"+area[i].replace("|", "").replace("%", "")+"',";
					}
					if(ids.length()>1){
						ids=ids.substring(0,ids.length()-1);
					}
					ids+=")";
					where.append(" and n.merchants.city.id in "+ids+"");
				}
		 		where.append(" and n.isPay='1' and n.status='0' and n.state<=3");
		 		HashMap<String, ?> mapp  = 	orderService.getListByPageWhere(where, page);
		 		List list01 = (List)mapp.get("DATA");
				page = (PageInfo) mapp.get("PAGE_INFO");
				String[] title = { "会员名称", "订单号", "订单完成时间", "归属店铺","消费店铺", "消费金额"};
				try{
					  OutputStream os = response.getOutputStream();  
					  response.reset();// 清空输出流     
					  response.setHeader("Content-disposition", "attachment; filename="+URLEncoder.encode("会员流水.xls", "UTF-8")+".xls");// 设定输出文件头     
					  response.setContentType("application/msexcel");// 定义输出类型    
					  WritableWorkbook wwb = Workbook.createWorkbook(os);
					  WritableSheet sheet = wwb.createSheet("工作表", 0); 
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
						   Order order=(Order) list01.get(i);
						   label = new Label(0, h, order.getHuiyuan().getName());  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label); 
						   label = new Label(1, h, order.getOrder_id());  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label);
						   label = new Label(2, h, order.getEndTime()!=null?order.getEndTime():"未完成");  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label);
						   label = new Label(3, h,order.getHuiyuan().getShangJiaInfo()!=null? order.getHuiyuan().getShangJiaInfo().getName():"无归属");  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label);
						   label = new Label(4, h, order.getMerchants()!=null? order.getMerchants().getName():"暂无数据");  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label);
						   
						   label = new Label(5, h, ""+( order.getOrderPrice()!=null&&order.getPointPrice()!=null? order.getOrderPrice()-order.getPointPrice():"暂无数据"));  
						   // 将定义好的单元格添加到工作表中  
						   sheet.addCell(label);
						   h++;
					   }
					// 写入数据  
					wwb.write();  
					// 关闭文件  
					wwb.close(); 
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
		 	}
}
