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

package cn.com.dyninfo.o2o.furniture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @Description 自定义的 ListView ，配合CustomerScrollView 使用<br>
 *              与ScrollView兼容，如果不是包含在ScrollView里，请使用常规ListView
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-8 下午4:16:31
 * @update 2014-5-10 14:19:17
 */
public class CustomerListView extends ListView {

	public CustomerListView(Context context) {
		super(context);
	}

	public CustomerListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomerListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
