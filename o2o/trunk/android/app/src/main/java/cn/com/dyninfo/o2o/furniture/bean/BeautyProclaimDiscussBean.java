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

public class BeautyProclaimDiscussBean {

	private String head;
	private String txt;

	/**
	 * @Description 美丽宣言讨论
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-23 10:50:48
	 * @update 2014-6-18 17:14:23
	 */
	public BeautyProclaimDiscussBean(String head, String txt) {
		this.head = head;
		this.txt = txt;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "BeautyProclaimDiscussBean [head=" + head + ", txt=" + txt + "]";
	}

}
