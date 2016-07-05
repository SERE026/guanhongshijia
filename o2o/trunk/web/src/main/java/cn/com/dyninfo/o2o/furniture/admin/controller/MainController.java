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

/**
 * @author jettang
 * May 31, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;
import cn.com.dyninfo.o2o.furniture.util.ResponseUtil;

import cn.com.dyninfo.o2o.furniture.admin.model.Log;
import cn.com.dyninfo.o2o.furniture.admin.model.ResInfo;
import cn.com.dyninfo.o2o.furniture.admin.model.UserInfo;
import cn.com.dyninfo.o2o.furniture.admin.service.LogService;
import cn.com.dyninfo.o2o.furniture.admin.service.MainService;
import cn.com.dyninfo.o2o.furniture.admin.service.ResService;
import cn.com.dyninfo.o2o.furniture.admin.service.UserService;
import cn.com.dyninfo.o2o.furniture.web.framework.context.LoginUser;
import cn.com.dyninfo.o2o.furniture.web.order.service.OrderService;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.service.ShangJiaService;




/**
 * @author jet.tang
 * May 31, 2010
 */
@Controller
@RequestMapping("/manage/main")
public class MainController {
	
	@Resource
	private MainService mainService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private ResService resService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private ShangJiaService shangjiaService;
	

	
	
	/**
	 * 登录后的主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/")
	public ModelAndView toMain(HttpServletRequest request,HttpServletResponse response){
		Object obj=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(obj instanceof UserInfo){
			UserInfo user=(UserInfo)obj;
//			System.out.println(user.getUser_name());
			UserInfo u=(UserInfo) request.getSession().getAttribute("UserInfo");
			if(u==null||!u.getLogin_id().equals(user.getLogin_id())){
				Log log=new Log();
				log.setIp(getRemortIP(request));
				log.setInfo("登录系统");
				logService.addObj(log);
			}
			LoginUser.addUser(user.getLogin_id());
			user=(UserInfo)userService.getObjById(user.getLogin_id());
			if(user.getIs_user().equals("1")){
				request.getSession().setAttribute("merchants", user.getShanfJiaInfo());
			}else if(user.getIs_user().equals("2")){
				request.getSession().setAttribute("daili", user);
			}
			request.getSession().setAttribute("UserInfo", user);
			return new ModelAndView("/main/main");
		}else{
			return new ModelAndView("redirect:/Dress/index.jsp");
		}
	}
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	public String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}  

	/**
	 * 右下首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/right")
	public ModelAndView right(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
		ShangJiaInfo  merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		UserInfo daili=(UserInfo) request.getSession().getAttribute("daili");
		
		/**
		 * 未付款订单数量
		 */
		String sql="select count(*) from T_ORDER n left join T_SHANGJIA_INFO s on n.MARCHANTS_ID=s.SHANGJIA_ID where 1=1 and n.STATUS=0 and n.STATE=0 ";
		/**
		 * 待发货订单数量
		 */
		String sql2="select count(*) from T_ORDER n left join T_SHANGJIA_INFO s on n.MARCHANTS_ID=s.SHANGJIA_ID where 1=1  and n.STATE=1 ";
		/**
		 * 申请退款订单数量
		 */
		String sql3="select count(*) from T_ORDER n left join T_SHANGJIA_INFO s on  n.MARCHANTS_ID=s.SHANGJIA_ID where 1=1  and n.STATE=4 ";
		/**
		 * 申请退货订单数量
		 */
		String sql4="select count(*) from T_ORDER n left join  T_SHANGJIA_INFO s on n.MARCHANTS_ID=s.SHANGJIA_ID where 1=1  and n.STATE=5 ";
		/**
		 * 归属会员数量
		 */
		String sql5="select count(*) from T_HUIYUAN_INFO n left join  T_SHANGJIA_INFO s on n.shang_id=s.SHANGJIA_ID where 1=1 ";
		
		if(merchants!=null){
			sql+= " and MARCHANTS_ID='"+merchants.getShangjia_id()+"' ";
			sql2+=" and MARCHANTS_ID='"+merchants.getShangjia_id()+"' ";
			sql3+=" and MARCHANTS_ID='"+merchants.getShangjia_id()+"' ";
			sql4+=" and MARCHANTS_ID='"+merchants.getShangjia_id()+"' ";
			sql5+=" and shang_id='"+merchants.getShangjia_id()+"' ";
			
		}
		
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
			sql+=" and s.CITY_ID in "+ids+"";
			sql2+=" and s.CITY_ID in "+ids+"";
			sql3+=" and s.CITY_ID in "+ids+"";
			sql4+=" and s.CITY_ID in "+ids+"";
			sql5+=" and s.CITY_ID in "+ids+"";
			
		}
//		System.out.println(sql);
		mav.addObject("num1", mainService.getNum(sql));
		mav.addObject("num2", mainService.getNum(sql2));
		mav.addObject("num3", mainService.getNum(sql3));
		mav.addObject("num4", mainService.getNum(sql4));
		mav.addObject("num5", mainService.getNum(sql5));
		
		
		StringBuffer where=new StringBuffer();
		PageInfo page=new PageInfo();
		page.setPageNo(1);
		page.setPageSize(20);
		if(merchants!=null){
			where.append(" and n.merchants.shangjia_id="+merchants.getShangjia_id());
		}
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
			where.append(" and n.merchants.city.id in "+ids);
		}
		where.append("order by n.creatTime desc ");
		Map map=orderService.getListByPageWhere(where, page);
		mav.addObject("data", map.get("DATA"));
		mav.setViewName("/main/right");
		return mav;
	}
	@RequestMapping(value="/order")
	public void order(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml"); 
		Calendar time=Calendar.getInstance(); 
		StringBuffer str = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		str.append(" <chart bgColor=\"FFE4C4\" outCnvBaseFontColor=\"666666\" caption=\"近10天订单成交量统计图\"  ");
		str.append("    xAxisName=\"时间\" yAxisName=\"数量\" showLabels=\"1\" showValues=\"0\"   ");
		str.append("    plotFillAlpha=\"70\" numVDivLines=\"10\" showAlternateVGridColor=\"1\"   ");
		str.append("    AlternateVGridColor=\"e1f5ff\" divLineColor=\"999999\" baseFontColor=\"666666\"  ");
		str.append("    canvasBorderThickness=\"1\" showPlotBorder=\"0\" plotBorderThickness=\"0\"   ");
		str.append("    zgapplot=\"0\" zdepth=\"120\" exeTime=\"1.2\" dynamicShading=\"1\" YZWallDepth=\"5\"   ");
		str.append("    ZXWallDepth=\"5\" XYWallDepth=\"5\" canvasBgColor=\"BDB76B\" startAngX=\"0\"   ");
		str.append("    startAngY=\"0\" endAngX=\"5\" endAngY=\"-25\" divLineEffect=\"bevel\" baseFontSize=\"12\">  ");
		str.append(" <categories> ");
		
		StringBuffer numStr=new StringBuffer();
		numStr.append("<dataset seriesName=\"数量\" color=\"C8A1D1\" plotBorderColor=\"C8A1D1\" renderAs=\"line\"> ");
		StringBuffer moneyStr=new StringBuffer();
		moneyStr.append("<dataset seriesName=\"金额\" color=\"B1D1DC\" plotBorderColor=\"B1D1DC\" renderAs=\"line\"> ");
		
		
		String sql="select count(*) from T_ORDER n left join T_SHANGJIA_INFO s on  n.MARCHANTS_ID=s.SHANGJIA_ID  where 1=1  and n.STATE=3  ";
		String sql2="select sum(ORDER_PRICE) from T_ORDER n left join T_SHANGJIA_INFO s on  n.MARCHANTS_ID=s.SHANGJIA_ID  where 1=1  and n.STATE=3  ";
		ShangJiaInfo  merchants=(ShangJiaInfo) request.getSession().getAttribute("merchants");
		if(merchants!=null){
			sql +=" and MARCHANTS_ID="+merchants.getShangjia_id();
			sql2+=" and MARCHANTS_ID="+merchants.getShangjia_id();
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
			sql+=" and s.CITY_ID in "+ids+"";
			sql2+=" and s.CITY_ID in "+ids+"";
			
		}
		
		for(int i=0;i<10;i++){
			time.add(Calendar.DATE, -1);
			String t=new SimpleDateFormat("yyyy-MM-dd").format(time.getTime());
			String s1=sql+ " and SURETIME like '"+t+"%' ";
			String s2=sql2+" and SURETIME like '"+t+"%' ";
			str.append(" <category label=\""+t+"\" />  ");
			numStr.append("<set value=\""+mainService.getNum(s1)+"\" /> ");
			moneyStr.append("<set value=\""+mainService.getMoney(s2)+"\" /> ");
		}
		str.append("</categories> ");
		numStr.append("</dataset> ");
		moneyStr.append("</dataset> ");
		str.append(numStr).append(moneyStr);
		str.append("</chart> ");
		ResponseUtil.printl(response, str.toString(), "txt");
		
	}
	@RequestMapping(value="/{id}/c")
	public void chaxun(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml"); 
		ResInfo resInfo=(ResInfo)resService.getObjById(id);
		Set<ResInfo> resset=resInfo.getChildren();
		resset.size();
		try {
			PrintWriter out=response.getWriter();
			out.println("<?xml version='1.0' encoding='UTF-8'?>");
			out.println("<list1>");
			for(ResInfo res:resset){
				out.println("<get1 name='"+res.getRes_name()+"' menuid='"+res.getId()+"' url='"+((res.getUrl()!=null)?res.getUrl():"")+"'/>");
			}
			out.println("</list1>");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @param num
	 */
	@RequestMapping(value="/validCode")
	public void validCode(HttpServletRequest request,HttpServletResponse response,String num){
		try{
			int iWidth = 70, iHeight = 22;
		    BufferedImage image = new BufferedImage(iWidth, iHeight,BufferedImage.TYPE_INT_RGB);
		    //获取图形上下文
		    Graphics g = image.getGraphics();
		    //设定背景色
		    g.setColor(Color.white);
		    g.fillRect(0, 0, iWidth, iHeight);
		    //画边框
		    g.setColor(Color.BLUE);
		    g.drawRect(0, 0, iWidth - 1, iHeight - 1);
		    //取随机产生的认证码(4位数字)
		    //Math.random()方法来产生一个随机数，这个产生的随机数是0-1之间的一个double，我们可以把他乘以一定的数，比如说乘以100，他就是个100以内的随机
		    Random random = new Random();
		    String randChar = "yp9s1k5vb4NB6KH7GFDA8Ef";
		    String temp="" ;
		    String randtemp;
		    Color colors[]={Color.BLUE,Color.red,Color.GREEN,Color.ORANGE,Color.BLACK,Color.gray,Color.PINK,Color.GRAY};
		    for(int i=0;i<4;i++)
		    {
		        //将认证码显示到图象中
		    	
		    	randtemp=randChar.charAt(random.nextInt(23))+"";
		        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		    	g.setColor(colors[random.nextInt(8)]);
		    	g.drawString(randtemp, 5+i*13, 15);
		    	temp=temp+randtemp;
		    }
		    //将认证码存入SESSION
		    HttpSession session=request.getSession();
		    session.setAttribute("J_CODE", temp);
		    //随机产生88个干扰点,使图象中的认证码不易被其它程序探测到
		    for (int iIndex = 0; iIndex < 88; iIndex++) {
		    	if(iIndex%3==0) g.setColor(Color.RED);
		    	else if(iIndex%3==1) g.setColor(Color.ORANGE);
		    	else g.setColor(Color.GREEN);
		        int x = random.nextInt(iWidth);
		        int y = random.nextInt(iHeight);
		        g.drawLine(x, y, x, y);
		    }
		    //图象生效
		    g.dispose();
		    //输出图象到页面
		    ImageIO.write(image, "JPEG", response.getOutputStream());
		    response.flushBuffer();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 测试是否在线
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/testAlive")
	public ModelAndView testAlive(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html"); 
		try {
			PrintWriter out=response.getWriter();
			out.print(1);
			out.flush();
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/menu/{id}")
	public ModelAndView menu(@PathVariable String id, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/main/menu");
		mav.addObject("menu", resService.getObjById(id));
		return mav;
	}
	
	@RequestMapping("/update")
	public void update( HttpServletRequest request,HttpServletResponse response){
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		LoginUser.updateUser(user.getLogin_id());
	}
	
	@RequestMapping("/exit")
	public ModelAndView exit(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		try{
		UserInfo user=(UserInfo) request.getSession().getAttribute("UserInfo");
		LoginUser.exitUser(user.getLogin_id());
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getSession().removeAttribute("UserInfo");
		try {
			response.sendRedirect(request.getContextPath()+"/j_spring_security_logout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
