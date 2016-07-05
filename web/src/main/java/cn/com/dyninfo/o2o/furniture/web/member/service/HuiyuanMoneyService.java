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

package cn.com.dyninfo.o2o.furniture.web.member.service;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;
import cn.com.dyninfo.o2o.furniture.web.member.model.HuiyuanInfo;
import cn.com.dyninfo.o2o.furniture.web.order.model.Order;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Zffs;

public interface HuiyuanMoneyService extends IBaseService {

	/**
	 * 订单支付
	 * @param order
	 * @return
	 */
	public boolean addOder(Order order);
	
	/**
	 * 账户充值
	 * @param money
	 * @param zffs
	 * @return
	 */
	public boolean addTopup(double money,Zffs zffs,HuiyuanInfo huiyuan);
}
