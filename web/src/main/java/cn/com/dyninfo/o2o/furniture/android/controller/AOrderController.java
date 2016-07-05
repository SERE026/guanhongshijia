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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;
import cn.com.dyninfo.o2o.furniture.util.TradeUtil;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.member.model.CommentInfo;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.member.service.CommentService;
import cn.com.dyninfo.o2o.furniture.web.member.service.HuiyuanService;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.order.model.Trade;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderProductServeice;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;
import cn.com.dyninfo.o2o.furniture.web.setting.service.ZffsService;

/**
 * android MyOrder
 * @author zhuwj
 *
 */
@Controller
@RequestMapping("/aorder")
public class AOrderController {
	@Resource
	 private HuiyuanService huiyuanService;
	@Resource
	private OrderService orderService;
	@Resource
	private CommentService commentService;
	@Resource
	private OrderProductServeice orderProductService;
	@Resource
	private ZffsService zffsService;
	
	String statu = "0";//0为成功 1为失败
	/**
	 * Order List
	 * @param request
	 * @param response	
	 * @param status 0.有效 1.未付款 2.已付款3.交易成功4.无效
	 * 
	 */
	@RequestMapping("/orderlist")
	public void orderList(HttpServletRequest request,HttpServletResponse response){
		statu = "0";
		String status=request.getParameter("status");
		String huiyuanid=request.getParameter("huiyuanid");
		HuiyuanInfo huiyuan=(HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
		request.getSession().setAttribute(Context.SESSION_MEMBER, huiyuan);
		String pageNo =  request.getParameter("pageNo");
		if(pageNo == null||pageNo.equals("")){
			pageNo = "1";
		}
//		System.out.println(request.getSession().getAttribute(Context.SESSION_MEMBER));
	 	PageInfo page=new PageInfo();
		page.setPageNo(Integer.parseInt(pageNo));
		page.setPageSize(10);
		StringBuffer where =new StringBuffer();
		where.append(" and n.huiyuan.huiYuan_id = '"+huiyuanid+"' ");
//		where.append(" and n.huiyuan.name = '237262911@qq.com' ");
		
		if(status.equals("0")){
			where.append(" and n.state != '6' ");
		}else if(status.equals("1")){
			where.append(" and n.state = '0' and n.isPay='0' ");
		}else if(status.equals("2")){
			where.append(" and n.state = '1' ");
		}else if(status.equals("3")){
			where.append(" and n.state = '3' ");
		}else if(status.equals("4")){
			where.append(" and n.state = '6' ");
		}
		where.append(" and n.status='0'");
		where.append(" order by n.time desc");
		Map map =  (Map) orderService.getListByPageWhere(where, page);
		List<Order> list=(List<Order>) map.get("DATA");
		String json = "[";
		for(Order order:list){
			String son="[";
			double countMoney=0d;
			for(int i=0;i<order.getOrderProductList().size();i++){
				son+="{\"name\":\""+order.getOrderProductList().get(i).getProduct().getName()+"\",\"goodMoney\":\""+order.getOrderProductList().get(i).getGoodMoney()+"\",\"num\":\""+order.getOrderProductList().get(i).getNum()+"\"},";
				countMoney=countMoney+order.getOrderProductList().get(i).getGoodMoney()*order.getOrderProductList().get(i).getNum();
			}
			if(order.getOrderProductList().size()>0){
				son=son.substring(0,son.lastIndexOf(","));
			}
			son+="]";
			json+="{\"order_id\":\""+order.getOrder_id()+"\",\"state\":\""+order.getState()+"\",\"creatTime\":\""+order.getCreatTime()+"\",\"orderProductList\":"+son+",\"countMoney\":\""+countMoney+"\",\"shippingPrice\":\""+order.getShippingPrice()+"\"},";
	}
		if(list.size()>0){
			json=json.substring(0,json.lastIndexOf(","));
		}
		json+="]";
//		System.out.println(json);
		if(list.size()==0){
			statu="1";
		}
		String newJson = "{\"status\":"+this.statu+",\"data\":"+json+"}";
		ResponseUtil.printl(response, newJson, "json");
	}
	/**
	 * Order Particulars
	 * 订单详情
	 * @param request
	 * @param response
	 * @param orderId
	 */
	@RequestMapping("/order")
	public void showOrder(HttpServletRequest request,HttpServletResponse response){
		statu = "0";
		String huiyuanid=request.getParameter("huiyuanid");
		HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
		request.getSession().setAttribute(Context.SESSION_MEMBER, info);
		String orderId = request.getParameter("orderId");
		Order order = (Order) orderService.getObjById(orderId); 
		String json = "";
		if(order!=null){
			int isShaidan =0;
			String son="[";
			double countMoney=0d;
			for(int i=0;i<order.getOrderProductList().size();i++){
				isShaidan+=Integer.parseInt( order.getOrderProductList().get(i).getShowstats());
				countMoney=countMoney+order.getOrderProductList().get(i).getGoodMoney()*order.getOrderProductList().get(i).getNum();
				son+="{\"name\":\""+order.getOrderProductList().get(i).getProduct().getName()+"\",\"goodMoney\":\""+order.getOrderProductList().get(i).getGoodMoney()+"\",\"num\":\""+order.getOrderProductList().get(i).getNum()+"\",\"xiaoji\":\""+countMoney+"\"},";
			}
			if(order.getOrderProductList().size()>0){
				son=son.substring(0,son.lastIndexOf(","));
			}
			son+="]";
			json+="{\"order_id\":\""+order.getOrder_id()
				+"\",\"state\":\""+order.getState()
				+"\",\"creatTime\":\""+order.getCreatTime()
				+"\",\"orderProductList\":"+son
				+",\"countMoney\":\""+countMoney
				+"\",\"shippingPrice\":\""+order.getShippingPrice()
				+"\",\"province\":\""+(order.getProvince()!=null?order.getProvince().getName():"")
				+"\",\"city\":\""+(order.getCity()!=null?order.getCity().getName():"")
				+"\",\"county\":\""+(order.getCounty()!=null?order.getCounty().getName():"")
				+"\",\"address\":\""+(order.getAddress()!=null?order.getAddress():"")
				+"\",\"receiveName\":\""+order.getReceiveName()+"\",\"creatTime\":\""+order.getCreatTime()
				+"\",\"receiveTel\":\""+(order.getReceivePhone()!=null?order.getReceivePhone():"")
				+"\",\"pointPrice\":\""+(order.getPointPrice()!=null?order.getPointPrice():"")
				+"\",\"zfmoney\":\""+order.getOrderPrice()
				+"\",\"dly\":\""+order.getDly()
				+"\",\"orderPrice\":\""+order.getOrderPrice()
				+"\",\"isShaiDan\":\""+isShaidan+"\"}";
		}
		System.out.println(json);
		statu ="0";
		String newJson = "{\"status\":"+statu+",\"data\":"+json+"}";
		ResponseUtil.printl(response, newJson, "json");
	}
	
	
	/**
	 * ABOUT CINFIRM RECEIPT
	 * 确认收货
	 * @param request
	 * @param response
	 * @param orderId
	 */
	@RequestMapping("/cinfirmReceipt")
	public void AboutCinfirmReceipt(HttpServletRequest request,HttpServletResponse response){
		statu = "0";
		String huiyuanid=request.getParameter("huiyuanid");
		HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
		request.getSession().setAttribute(Context.SESSION_MEMBER, info);
		String orderId = request.getParameter("orderId");
		Order order =(Order) orderService.getObjById(orderId);
		if(order.getIsPay().equals("1")){
			order.setState("3");
			orderService.updateObj(order);
			statu ="0";
		}else{
			statu ="1";
		}
		String json = "";
		if(order!=null){
			String son="[";
			double countMoney=0d;
			for(int i=0;i<order.getOrderProductList().size();i++){
				countMoney=countMoney+order.getOrderProductList().get(i).getGoodMoney()*order.getOrderProductList().get(i).getNum();
				son+="{\"name\":\""+order.getOrderProductList().get(i).getProduct().getName()+"\",\"goodMoney\":\""+order.getOrderProductList().get(i).getGoodMoney()+"\",\"num\":\""+order.getOrderProductList().get(i).getNum()+"\",\"xiaoji\":\""+countMoney+"\"},";
			}
			if(order.getOrderProductList().size()>0){
				son=son.substring(0,son.lastIndexOf(","));
			}
			son+="]";
			json+="{\"order_id\":\""+order.getOrder_id()+"\",\"state\":\""+order.getStatus()+"\",\"creatTime\":\""+order.getCreatTime()+"\",\"orderProductList\":"+son+",\"countMoney\":\""+countMoney+"\",\"shippingPrice\":\""+order.getShippingPrice()+"\",\"province\":\""+order.getProvince().getName()+"\",\"city\":\""+order.getCity().getName()+"\",\"county\":\""+order.getCounty().getName()+"\",\"address\":\""+order.getAddress()+"\",\"receiveName\":\""+order.getReceiveName()+"\",\"creatTime\":\""+order.getCreatTime()+"\",\"receiveTel\":\""+order.getReceiveTel()+" "+order.getReceivePhone()+"\",\"pointPrice\":\""+order.getPointPrice()+"\",\"zfmoney\":\""+info.getMoney()+"\",\"orderPrice\":\""+order.getOrderPrice()+"\"}";
		}
		System.out.println(json);
		
		String newJson = "{\"status\":"+statu+",\"data\":"+json+"}";
		ResponseUtil.printl(response, newJson, "json");
	}
	
	
	/**
	 *Bask single
	 * 晒单
	 * @param request
	 * @param response
	 * @param orderId
	 */
	@RequestMapping("/baskSingle")
	public void BaskSingle(HttpServletRequest request,HttpServletResponse response){
		statu = "0";
		String huiyuanid=request.getParameter("huiyuanid");
		HuiyuanInfo info=(HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
		request.getSession().setAttribute(Context.SESSION_MEMBER, info);
		String orderId = request.getParameter("orderId");
		Order order =(Order) orderService.getObjById(orderId);
		List<OrderProduct> orderProductList = order.getOrderProductList();
		String son="[";
		double countMoney=0d;
		for(int i=0;i<order.getOrderProductList().size();i++){
			countMoney=countMoney+order.getOrderProductList().get(i).getGoodMoney()*order.getOrderProductList().get(i).getNum();
			son+="{\"name\":\""+order.getOrderProductList().get(i).getProduct().getName()+"\",\"goodMoney\":\""+order.getOrderProductList().get(i).getGoodMoney()+"\",\"num\":\""+order.getOrderProductList().get(i).getNum()+"\",\"xiaoji\":\""+countMoney+"\"},";
		}
		if(order.getOrderProductList().size()>0){
			son=son.substring(0,son.lastIndexOf(","));
		}
		son+="]";
	
		String	json="{\"order_id\":\""+order.getOrder_id()+"\",\"state\":\""+order.getStatus()+"\",\"orderProductList\":"+son+"}";
		System.out.println(json);
		String newJson = "{\"status\":"+statu+",\"data\":"+json+"}";
		ResponseUtil.printl(response, newJson, "json");
	}
	
	
	/**
	 *Bask  single
	 * 晒单提交
	 * @param request
	 * @param response
	 * @param orderId
	 * @throws IOException 
	 */
	@RequestMapping("/commentBaskSingle")
	public void CommitBaskSingle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String huiyuanid=request.getParameter("huiyuanid");
		HuiyuanInfo info = (HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
		request.getSession().setAttribute(Context.SESSION_MEMBER, info);
		String msg = "";
		String uploadPath = "d:/status/upload/issue";// 上传目录
		String tempPath = "d:/status/upload/issue"; // 临时目录
		File tempFile = null;
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<String> imgStrList=new ArrayList<String>();
		String orderId = null;
		Order order = null;
		String  leve = null;
		String  saycontent = null;
		String imgOrder = null;
		String[] imgOrders=null;
		if (ServletFileUpload.isMultipartContent(request))
			try {
				System.out.println("晒单包含图片");
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(4096); // 设置缓冲区大小
				factory.setRepository(tempFile);// 缓冲路径
				ServletFileUpload upload = new ServletFileUpload(factory);
 				upload.setSizeMax(10 * 1024 * 1024); // 最大 10M（每单中一件宝贝可以上传4张图片，1订单可以包含N件宝贝）
				List<FileItem> files = upload.parseRequest(request);// 得到所有文件
				System.out.println("包含参数数量：" + files.size());
				Iterator iter = files.iterator();  
				int i = 0;
	            while(iter.hasNext()){
	            		FileItem item = (FileItem)iter.next();
	            		if(item.isFormField()){
	            			String name= item.getFieldName();
	            			String value = item.getString();
	            			//
	            			if(name.equals("orderId")){
	            				orderId = value;
	            				order = (Order) orderService.getObjById(orderId);
	            			}
	            			if(name.equals("leve")){
	            				leve = value;
	            			}
	            			if(name.equals("saycontent")){
	            				saycontent = value;
	            			}
	            			if(name.equals("imgOrder")){
	            				imgOrder = value;
	            				imgOrders=imgOrder.split(",");
	            			}
	            		}else{
	            			String fileName = item.getName();
	            			System.out.println(fileName);
	            			if (fileName != null) {
	    						// 文件名：客户端有处理，格式是：pic_时间戳.png，这里保存需要重新命名
	    						fileName = imgOrders[i]+"_"+ fileName;
	    						System.out.println("正在将图片保存到：" + uploadPath + fileName);
	    						i++;
	    						File save = new File(uploadPath, fileName);
	    						item.write(save);
	    						imgStrList.add(fileName);
	    					}
	            		}
				}
				String[] levels=leve.split(",");
				String imageSrc="";
				for(i=0;i<order.getOrderProductList().size();i++){
					CommentInfo commentInfo = new CommentInfo();
					for(int j=0;j<imgStrList.size();j++){
						String imgname=imgStrList.get(j);
						if(imgname.indexOf(i+"")==0){
							imageSrc+=imgname+";";
						}
					}
					commentInfo.setInfo(info);
					commentInfo.setSaycontent(saycontent);
					commentInfo.setImageSrc(imageSrc);
					OrderProduct product = order.getOrderProductList().get(i);
					product = (OrderProduct)orderProductService.getObjById(product.getOrder_product_id()+"");
					product.setShowstats("1");
					orderProductService.updateObj(product);
					commentInfo.setOrderProduct(product);
					commentInfo.setGinfo(product.getProduct().getGood());
					commentInfo.setIsShow("1");
					commentInfo.setLeve(Double.parseDouble(levels[i]));
					commentService.addObj(commentInfo);
					System.out.println("保存晒单成功！");
				}
				statu = "0";
				msg = "图片上传成功，你开心吗？O(∩_∩)O哈哈~";
			} catch (Exception e) {
				statu ="1";
				msg = "图片上传失败，你伤心吗?可能是你的太大！";
				e.printStackTrace();
			}
		else{
			String[] levels=leve.split(",");
			String[] saycontents=saycontent.split(":end-");
			for(int i=0;i<order.getOrderProductList().size();i++){
				CommentInfo commentInfo = new CommentInfo();
				OrderProduct product = order.getOrderProductList().get(i);
				product = (OrderProduct)orderProductService.getObjById(product.getOrder_product_id()+"");
				product.setShowstats("1");
				orderProductService.updateObj(product);
				commentInfo.setOrderProduct(product);
				commentInfo.setIsShow("1");
				commentInfo.setLeve(Double.parseDouble(levels[i]));
				commentInfo.setInfo(info);
				commentInfo.setGinfo(product.getProduct().getGood());
				commentInfo.setSaycontent(saycontents[i]);
				commentService.addObj(commentInfo);
				System.out.println("保存晒单成功！");
			}
			statu ="0";
			msg="晒单成功，但是没有上传图片哦";
		}
		String newJson = "{\"status\":\""+statu+"\"}";
		System.out.println(newJson);
		out.write(newJson);
		   out.flush();
		   out.close();
		
	}
	/**
	 *Bask single
	 * 去付款页面
	 * @param request
	 * @param response
	 * @param orderId
	 */
	@RequestMapping("/topay")
	public void topay(HttpServletRequest request,HttpServletResponse response){
		try{
			String huiyuanid=request.getParameter("huiyuanid");
			HuiyuanInfo info = (HuiyuanInfo) huiyuanService.getObjById(huiyuanid);
			request.getSession().setAttribute(Context.SESSION_MEMBER,info);
			String orderid=request.getParameter("orderid");
			Order order = (Order)orderService.getObjById(orderid);
			String tradeNo=TradeUtil.createTradeNumber();
			if(order!=null){
				Trade trade = new Trade();
				trade.setMoney(order.getOrderPrice());
				trade.setTrade_id(tradeNo);
				trade.setStatus(0);
				trade.setHuiyuan(info);
				trade.setFlag(1);
				trade.setZffs((Zffs)zffsService.getObjById("1"));
				zffsService.addObj(trade);
				String json="{\"status\":0,\"data\":[";
				json+="{\"tradeNo\":\""+order.getTradeNo()+"\",\"orderMoney\":\""+order.getOrderPrice()+"\"}]}";
				ResponseUtil.printl(response, json, "json");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
