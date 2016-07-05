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

import java.io.Serializable;

public class NetParam implements Serializable, Comparable {

	private static final long serialVersionUID = 2247322475L;
	String mName;
	String mValue;

	/**
	 * @Description 网络操作带的 param
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-27 上午10:57:28
	 */
	public NetParam(String name, String value) {
		this.mName = name;
		this.mValue = value;
	}

	@Override
	public boolean equals(Object arg0) {
		if (null == arg0) {
			return false;
		}
		if (this == arg0) {
			return true;
		}
		if (arg0 instanceof NetParam) {
			NetParam param = (NetParam) arg0;

			return this.mName.equals(param.mName) && this.mValue.equals(param.mValue);
		}
		return false;
	}

	public int compareTo(Object o) {
		int compared;
		NetParam param = (NetParam) o;
		compared = mName.compareTo(param.mName);
		if (0 == compared) {
			compared = mValue.compareTo(param.mValue);
		}
		return compared;
	}
}
