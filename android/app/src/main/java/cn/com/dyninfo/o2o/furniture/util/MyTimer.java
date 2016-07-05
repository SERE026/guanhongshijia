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

import android.os.CountDownTimer;

public class MyTimer extends CountDownTimer {
	/**
	 * @Description 倒计时
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-7-10 上午11:13:42
	 * @param TotalTime
	 *            总时间
	 * @param IntervalTime
	 *            每次间隔时间
	 */
	public MyTimer(long TotalTime, long IntervalTime) {
		super(TotalTime, IntervalTime);
	}

	@Override
	public void onFinish() {
		System.out.println("结束倒计时...");
	}

	@Override
	public void onTick(long millisUntilFinished) {
		System.out.println("请等待60秒(" + millisUntilFinished / 1000 + ")...");
	}

}