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

package cn.com.dyninfo.o2o.furniture.map;

public class PonitBean {

	private double mLat; // 纬度
	private double mLon; // 经度

	public PonitBean(double mLat, double mLon) {
		super();
		this.mLat = mLat;
		this.mLon = mLon;
	}

	public PonitBean() {
		super();
	}

	public double getmLat() {
		return mLat;
	}

	public void setmLat(double mLat) {
		this.mLat = mLat;
	}

	public double getmLon() {
		return mLon;
	}

	public void setmLon(double mLon) {
		this.mLon = mLon;
	}

	@Override
	public String toString() {
		return "PonitBean [mLat=" + mLat + ", mLon=" + mLon + "]";
	}
}
