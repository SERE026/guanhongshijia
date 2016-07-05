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

/**
 * 活动商品
 * 
 * @author ly
 * 
 */
public class PlayingGoodsBean {

	private String PlayingGoodsImg;
	private String PlayingGoodsName;
	private int goodId;
	private double nowPrice;
	private double oldPrice;
	private double discount;
	private int actId;
	private long endTime;

	public PlayingGoodsBean(String playingGoodsImg, String playingGoodsName, int goodId, double nowPrice,
			double oldPrice, double discount, int actId, long endTime) {
		PlayingGoodsImg = playingGoodsImg;
		PlayingGoodsName = playingGoodsName;
		this.goodId = goodId;
		this.nowPrice = nowPrice;
		this.oldPrice = oldPrice;
		this.endTime = endTime;
		this.discount = discount;
		this.actId = actId;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getPlayingGoodsImg() {
		return PlayingGoodsImg;
	}

	public void setPlayingGoodsImg(String playingGoodsImg) {
		PlayingGoodsImg = playingGoodsImg;
	}

	public String getPlayingGoodsName() {
		return PlayingGoodsName;
	}

	public void setPlayingGoodsName(String playingGoodsName) {
		PlayingGoodsName = playingGoodsName;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
