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
 * @Description 美丽宣言
 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
 * @date 2014-5-22 16:10:42
 * @update 2014-6-18 11:13:52
 */
public class BeautyProclaimBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String img;
	private String head;
	private String goodsName;
	private String desc;
	private String name;
	private long count;

	public BeautyProclaimBean(long id, String img, String goodsName, String head, String name, long count) {
		this.id = id;
		this.img = img;
		this.goodsName = goodsName;
		this.head = head;
		this.name = name;
		this.count = count;
	}

	public BeautyProclaimBean(long id, String img, String goodsName, String desc, String head, String name, long count) {
		this.id = id;
		this.img = img;
		this.goodsName = goodsName;
		this.desc = desc;
		this.head = head;
		this.name = name;
		this.count = count;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BeautyProclaimBean [img=" + img + ", goodsName =" + goodsName + ", name=" + name + ", count=" + count
				+ "]";
	}

}
