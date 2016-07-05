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

package cn.com.dyninfo.o2o.furniture.net;

/**
 * @Description
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-27 上午11:23:12
 */
public interface NetAsyncHandler {

	/**
	 * 执行中
	 */
	void onThrowable(Throwable t, Object cookie);

	/**
	 * 完成时
	 */
	void onCompleted(int statusCode, String Content, Object cookie);
}
