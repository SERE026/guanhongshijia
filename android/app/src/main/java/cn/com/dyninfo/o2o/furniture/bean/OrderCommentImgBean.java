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

public class OrderCommentImgBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String img_1;
	private String img_2;
	private String img_3;
	private String img_4;

	/**
	 * @Description 订单评价
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-19 16:58:15
	 */
	public OrderCommentImgBean(String img_1, String img_2, String img_3, String img_4) {
		this.img_1 = img_1;
		this.img_2 = img_2;
		this.img_3 = img_3;
		this.img_4 = img_4;
	}

	public String getImg_1() {
		return img_1;
	}

	public String getImg_2() {
		return img_2;
	}

	public String getImg_3() {
		return img_3;
	}

	public String getImg_4() {
		return img_4;
	}

	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}

	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}

	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}

	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}

	@Override
	public String toString() {
		return "OrderCommentImgBean [img_1=" + img_1 + ", img_2=" + img_2 + ", img_3=" + img_3 + ", img_4=" + img_4
				+ "]";
	}

}
