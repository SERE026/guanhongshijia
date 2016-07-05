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

public class MessagesBean {

	private String id = "";
	private String title = "";
	private String txt = "";
	private String time = "";

	/**
	 * @Description 消息pojo
	 * @author <a href="http://t.cn/RvIApP5">ceychen</a>
	 * @date 2014-5-13 14:30:48
	 */
	public MessagesBean(String id, String title, String txt, String time) {
		this.id = id;
		this.title = title;
		this.txt = txt;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MessagesBean [id=" + id + ", title=" + title + ", txt=" + txt + ", time=" + time + "]";
	}

	
}
