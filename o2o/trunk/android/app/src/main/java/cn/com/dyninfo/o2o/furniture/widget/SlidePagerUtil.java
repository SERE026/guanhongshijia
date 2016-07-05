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

package cn.com.dyninfo.o2o.furniture.widget;

import android.content.Context;

import cn.com.dyninfo.o2o.furniture.util.Sys;

/**
 * @Description Slidepager 导航栏相关配置（slide_pager.xml）
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-14 下午3:18:03
 */
public class SlidePagerUtil {

	/**
	 * @Description 每一个Tab的宽（90dp）
	 */
	public static int getItemWidth(Context context) {
		return Sys.Dp2Px(context, 90);
	}

	/**
	 * @Description Slide line img 的宽（80dp）
	 */
	public static int getSlideWidth(Context context) {
		return Sys.Dp2Px(context, 80);
	}
}