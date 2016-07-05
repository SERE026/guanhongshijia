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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.com.dyninfo.o2o.furniture.web.framework.facade.Widget;

@Component("zfPlay_success")
@Scope("prototype")
public class ZfPaySucceed extends Widget {

	
	@Override
	public void display(Map pamtr) {
		System.out.println();
		System.out.println("-----------处理返回显示页面--------------------------------");
		System.out.println();
		this.putData("result", pamtr.get("result"));
		this.putData("money", pamtr.get("money"));
	}

}
