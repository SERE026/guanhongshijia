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

package cn.com.dyninfo.o2o.furniture.web.member.widget;

import java.util.Map;

import cn.com.dyninfo.o2o.furniture.util.ForwordTool;

import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

public abstract class AbstractMemberWidget  extends Widget  implements IMemberWidget{

	public void display(Map pamtr) {
		Object obj=this.HttpRequest.getSession().getAttribute(Context.SESSION_MEMBER);
		if(obj==null){
			String forword=this.HttpRequest.getHeader("Referer");
			this.HttpRequest.getSession().setAttribute(Context.SESSION_FORWORD, forword);
			ForwordTool.goToForword(this.HttpResponse,this.HttpRequest,"login.html");
		}else{
		this.execute(pamtr);
		}
	}
}
