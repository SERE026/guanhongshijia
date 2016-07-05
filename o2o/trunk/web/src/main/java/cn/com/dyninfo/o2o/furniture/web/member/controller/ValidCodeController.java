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

package cn.com.dyninfo.o2o.furniture.web.member.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validCode")
public class ValidCodeController {
	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @param num
	 */
	@RequestMapping
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
}
