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

package cn.com.dyninfo.o2o.furniture.bean;

import java.io.Serializable;

/**
 * @Description 女人街
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-4-23 14:14:57
 * @update 2014-6-13 14:32:46
 */
public class WomenStreetBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String storeID = "0";
	public String descp = "";
	public String imgUrl = "";

	public WomenStreetBean(String storeID, String descp, String imgUrl) {
		this.storeID = storeID;
		this.descp = descp;
		this.imgUrl = imgUrl;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
