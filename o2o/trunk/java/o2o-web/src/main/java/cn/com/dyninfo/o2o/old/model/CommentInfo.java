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

package cn.com.dyninfo.o2o.old.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.web.order.model.OrderProduct;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

@Entity
@Table(name = "T_COMMENT_INFO")
public class CommentInfo {

	@Id
	@AccessType(value = "property")
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INFO_ID")
	private HuiyuanInfo info; // 评论人

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UINFO_ID")
	private UserInfo uinfo; // 回复人

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SINFO_ID")
	private ShangJiaInfo sinfo; // 被评论店铺

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GINFO_ID")
	private Goods ginfo; // 被评论商品

	@AccessType("property")
	@Column(name = "CONTENT")
	private String content; // 评论图片内容
	
	@AccessType("property")
	@Column(name = "INDEXS")
	private String indexs; // 排序
	
	@AccessType("property")
	@Column(name = "SAYCONTENT")
	private String saycontent; // 评论文字内容

	@AccessType("property")
	@Column(name = "PHOTOTITLE")
	private String phototitle; // 图片标题

	@AccessType("property")
	@Column(name = "REPLY_CONTENT")
	private String replyContent; // 回复内容

	@AccessType("property")
	@Column(name = "STATUS")
	private String status = "0"; // 0不删除 1删除

	@AccessType("property")
	@Column(name = "LEVE")
	private Double leve;// 星级

	@AccessType("property")
	@Column(name = "IS_SHOW")
	private String isShow;// 是否显示 0不显示 1显示

	@AccessType("property")
	@Column(name = "IMAGE_SRC")
	private String imageSrc;// ;图片分隔

	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERPRODUCT_ID")
	private OrderProduct orderProduct;// 对应订单产品

	@AccessType("property")
	@Column(name = "TIME")
	private String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Date());// 评论时间

	@AccessType(value = "property")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comment")
	private List<CommentSay> say;// 所有回复评论

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public HuiyuanInfo getInfo() {
		return info;
	}

	public void setInfo(HuiyuanInfo info) {
		this.info = info;
	}

	public ShangJiaInfo getSinfo() {
		return sinfo;
	}

	public void setSinfo(ShangJiaInfo sinfo) {
		this.sinfo = sinfo;
	}

	public Goods getGinfo() {
		return ginfo;
	}

	public void setGinfo(Goods ginfo) {
		this.ginfo = ginfo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public UserInfo getUinfo() {
		return uinfo;
	}

	public void setUinfo(UserInfo uinfo) {
		this.uinfo = uinfo;
	}

	public Double getLeve() {
		return leve;
	}

	public void setLeve(Double leve) {
		this.leve = leve;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getPhototitle() {
		return phototitle;
	}

	public void setPhototitle(String phototitle) {
		this.phototitle = phototitle;
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<CommentSay> getSay() {
		return say;
	}

	public void setSay(List<CommentSay> say) {
		this.say = say;
	}

	public String getSaycontent() {
		return saycontent;
	}

	public void setSaycontent(String saycontent) {
		this.saycontent = saycontent;
	}

	public String getIndexs() {
		return indexs;
	}

	public void setIndexs(String indexs) {
		this.indexs = indexs;
	}

}
