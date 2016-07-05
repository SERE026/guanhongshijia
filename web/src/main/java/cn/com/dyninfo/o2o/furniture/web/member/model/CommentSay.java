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

package cn.com.dyninfo.o2o.furniture.web.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/*
 * 晒单的回应评论
 */
@Entity
@Table(name = "T_COMMENTSAY_INFO")
public class CommentSay {

	@Id
	@AccessType(value = "property")
	@Column(name = "SAY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int say_id;

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INFO_ID")
	private HuiyuanInfo info; // 评论人

	@AccessType("property")
	@Column(name = "CONTENT")
	private String content; // 评论内容

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMENT_ID")
	private CommentInfo comment; // 被评论的晒单

	public int getSay_id() {
		return say_id;
	}

	public void setSay_id(int say_id) {
		this.say_id = say_id;
	}

	public HuiyuanInfo getInfo() {
		return info;
	}

	public void setInfo(HuiyuanInfo info) {
		this.info = info;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentInfo getComment() {
		return comment;
	}

	public void setComment(CommentInfo comment) {
		this.comment = comment;
	}
}