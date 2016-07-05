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

package cn.com.dyninfo.o2o.furniture.web.setting.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author 网站设置
 *	Oct 8, 2011
 */
@Entity
@Table(name="T_WEB")
public class Web implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@AccessType(value = "property")
	@Column(name="WEB_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int web_id;//ID
	
	@AccessType(value = "property")
	@Column(name="BG_COLOR")
	private String bgColor;
	
	@AccessType(value = "property")
	@Column(name="BG_IMG")
	private String bgImage;
	
	@AccessType(value = "property")
	@Column(name = "SLT_W")
	private String slt_w;// 缩略图尺寸  宽
	
	
	@AccessType(value = "property")
	@Column(name = "SLT_H")
	private String slt_h;// 缩略图尺寸高
	
	@AccessType(value = "property")
	@Column(name = "GOODSXX_W")
	private String goodXX_w;// 商品详细页图片尺寸 宽
	
	@AccessType(value = "property")
	@Column(name = "GOODXX_H")
	private String goodXX_h;// 商品详细页图片尺寸 高
	
	@AccessType(value = "property")
	@Column(name = "GOOD_W")
	private String good_w;// 商品相册图片尺寸 宽
	
	@AccessType(value = "property")
	@Column(name = "GOOD_H")
	private String good_h;// 商品相册图片尺寸高
	
	@AccessType(value = "property")
	@Column(name = "IS_SY")
	private String is_sy = "0";// 是否 开启水印 0不是 1是
	
	
	@AccessType(value = "property")
	@Column(name = "SY_NAME")
	private String sy_name;// 水印文字
	
	/**
	 * 水印位置
	 * 0顶部居左 1顶部居中 2顶部居右
	 * 3左部居中 4图片中心 5右部居中
	 * 6底部居左 7底部居中 8底部居右
	 */
	@AccessType(value = "property")
	@Column(name = "SY_LOCATION")
	private String sy_location = "0";
	
	
	@AccessType(value = "property")
	@Column(name = "FONT_COLOR")
	private String font_color;// 文字颜色
	
	
	@AccessType(value = "property")
	@Column(name = "FONT_SIZE")
	private String font_size ;// 文字大小
	
	
	
	
	
	@AccessType(value = "property")
	@Column(name = "IS_CODE")
	private String is_code="0" ;// 是否开启 回复验证码 0 不是 1 是
	
	@AccessType(value = "property")
	@Column(name = "PAGE_SIZE")
	private String page_size ;// 评论分页条数
	
	@AccessType(value = "property")
	@Column(name = "IS_LMPL")
	private String is_lmpl = "0" ;// 是否开启 匿名评论0 不是 1 是
	
	@AccessType(value = "property")
	@Column(name = "IS_DISPALY")
	private String is_display="0" ;// 是否开启 直接显示0 不是 1 是
	
	@AccessType(value = "property")
	@Column(name = "TITLE")
	private String title;
	
	@AccessType(value = "property")
	@Column(name = "KEYWORD")
	private String keyWord;
	
	@AccessType(value = "property")
	@Column(name = "DESCRIPTION")
	private String description;

	public int getWeb_id() {
		return web_id;
	}

	public void setWeb_id(int webId) {
		web_id = webId;
	}

	public String getSlt_w() {
		return slt_w;
	}

	public void setSlt_w(String sltW) {
		slt_w = sltW;
	}

	public String getSlt_h() {
		return slt_h;
	}

	public void setSlt_h(String sltH) {
		slt_h = sltH;
	}

	public String getGoodXX_w() {
		return goodXX_w;
	}

	public void setGoodXX_w(String goodXXW) {
		goodXX_w = goodXXW;
	}

	public String getGoodXX_h() {
		return goodXX_h;
	}

	public void setGoodXX_h(String goodXXH) {
		goodXX_h = goodXXH;
	}

	public String getGood_w() {
		return good_w;
	}

	public void setGood_w(String goodW) {
		good_w = goodW;
	}

	public String getGood_h() {
		return good_h;
	}

	public void setGood_h(String goodH) {
		good_h = goodH;
	}

	public String getIs_sy() {
		return is_sy;
	}

	public void setIs_sy(String isSy) {
		is_sy = isSy;
	}

	public String getSy_name() {
		return sy_name;
	}

	public void setSy_name(String syName) {
		sy_name = syName;
	}

	public String getSy_location() {
		return sy_location;
	}

	public void setSy_location(String syLocation) {
		sy_location = syLocation;
	}

	public String getFont_color() {
		return font_color;
	}

	public void setFont_color(String fontColor) {
		font_color = fontColor;
	}

	public String getFont_size() {
		return font_size;
	}

	public void setFont_size(String fontSize) {
		font_size = fontSize;
	}

	public String getIs_code() {
		return is_code;
	}

	public void setIs_code(String isCode) {
		is_code = isCode;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String pageSize) {
		page_size = pageSize;
	}

	public String getIs_lmpl() {
		return is_lmpl;
	}

	public void setIs_lmpl(String isLmpl) {
		is_lmpl = isLmpl;
	}

	public String getIs_display() {
		return is_display;
	}

	public void setIs_display(String isDisplay) {
		is_display = isDisplay;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * @param keyWord the keyWord to set
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}
	
	
	
	
	
	

}
