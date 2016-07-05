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

public class SpecBean {

	private String id;
	private String txt;

	/**
	 * 
	 * @Description 商品详情页面需要的尺码、颜色等参数
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-9-2 17:45:20
	 * @param id
	 * @param txt
	 */
	public SpecBean(String id, String txt) {
		this.id = id;
		this.txt = txt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

}
