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

import java.util.List;
import java.util.Map;

import cn.com.dyninfo.o2o.furniture.util.PageInfo;

import cn.com.dyninfo.o2o.furniture.admin.service.IBaseService;

public interface FavoritesService extends IBaseService {
	public void addGoods(List<Map> list);
	public List getGoodsactive(int memberId,PageInfo page);
	public int getGoodsActiveCount(int memberId);
}
