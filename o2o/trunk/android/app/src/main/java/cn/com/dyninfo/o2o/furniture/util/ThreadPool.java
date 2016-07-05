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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	static ExecutorService cachedService = null;
	static ExecutorService singleService = null;

	/**
	 * @Description 不固定线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:46:57
	 */
	public static ExecutorService getCachedThreadPool() {
		if (cachedService == null) {
			synchronized (ThreadPool.class) {
				if (cachedService == null)
					cachedService = Executors.newCachedThreadPool();
			}
		}
		return cachedService;
	}
	/**
	 * @Description 单线程池
	 * @author <a href="http://t.cn/RvIApP5">ceychen@foxmail.com</a>
	 * @date 2014-8-19 15:47:02
	 */
	public static ExecutorService getSingleThreadPool() {
		if (singleService == null) {
			synchronized (ThreadPool.class) {
				if (singleService == null)
					singleService = Executors.newSingleThreadExecutor();
			}
		}
		return singleService;
	}
}
