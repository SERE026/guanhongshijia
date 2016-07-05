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

package cn.com.dyninfo.o2o.furniture.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;

public class ForwordTool {

	public static void checkeForword(HttpServletResponse reponse,HttpServletRequest reqest){
		String forWord=(String) reqest.getAttribute(Context.SESSION_FORWORD);
		if(forWord!=null){
			try{
//				System.out.print("TO"+forWord);
				reponse.sendRedirect(reqest.getContextPath()+"/"+forWord);
				reqest.getSession().removeAttribute(Context.SESSION_FORWORD);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public static void goToForword(HttpServletResponse reponse,HttpServletRequest reqest,String forWord){
		if(forWord!=null){
			try{
				reponse.sendRedirect(reqest.getContextPath()+"/"+forWord);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
