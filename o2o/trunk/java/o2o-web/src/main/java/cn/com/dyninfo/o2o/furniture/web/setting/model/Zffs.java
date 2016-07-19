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
 * 支付方式
 * @author Zebe
 * @date 2014/4/15 更新
 * @ps 添加了新增扩展字段
 *
 */

@Entity
@Table(name="T_ZFFS")
public class Zffs implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="ZFFS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int zffs_id;//ID
	
	@AccessType(value = "property")
	@Column(name = "TYPE")
	private String type = "0";// 支付方式类型 0 支付宝即时到帐接口 1网银支付
	
	@AccessType(value = "property")
	@Column(name = "NAME", length = 200)
	private String name;// 支付方式名称
	
	@AccessType(value = "property")
	@Column(name = "WIDGET_NAME", length = 200)
	private String widget_name;// 支付方式挂件名称
	
	@AccessType(value = "property")
	@Column(name = "ZFB_ID")
	private String zfb_id;// 支付宝：合作伙伴id  网银：商户名称  环迅：商户号
	
	@AccessType(value = "property")
	@Column(name = "ZFB_CODE")
	private String zfb_code;// 支付宝：安全校验码  网银：商户代码  环迅：商户证书
	
	@AccessType(value = "property")
	@Column(name = "ZFB_ZHANGHAO")
	private String zfb_zhanghao;// 支付宝：卖家支付宝帐户 网银：商城密匙
	
	
	@AccessType(value = "property")
	@Column(name = "JIANCHEN")
	private String jianChen;// 网银：商户简称

	
	@AccessType(value = "property")
	@Column(name = "VALUE1")
	private String value1;// 扩展1
	
	@AccessType(value = "property")
	@Column(name = "VALUE2")
	private String value2;// 扩展2
	
	@AccessType(value = "property")
	@Column(name = "VALUE3")
	private String value3;// 扩展3
	
	@AccessType(value = "property")
	@Column(name = "VALUE4")
	private String value4;// 扩展4

	@AccessType(value = "property")
	@Column(name = "STATUS")
	private int status = 0;// 1为删除
	
	@AccessType(value = "property")
	@Column(name = "PS")
	private String ps ;// 支付方式说明
	
	
	
	
	/** 新增扩展 ******************************************/
	@AccessType(value = "property")
	@Column(name = "SUBJECT")
	private String subject ; // 主题
	
	@AccessType(value = "property")
	@Column(name = "BODY")
	private String body ; // 内容
	
	@AccessType(value = "property")
	@Column(name = "NOTIFY_URL")
	private String notify_url ; // 服务器异步通知路径（需要 http://xxx完整路径。不能加自定义参数如 ?id=123）
	
	@AccessType(value = "property")
	@Column(name = "RETURN_URL")
	private String return_url ;  // 服务器同步通知路径（需要 http://xxx完整路径。不能加自定义参数如 ?id=123）

	@AccessType(value = "property")
	@Column(name = "SHOW_URL")
	private String show_url ;  // 商品展示路径（需要 http://xxx完整路径。不能加自定义参数如 ?id=123）
	
	

	/**
	 * getters and setters
	 */
	public int getZffs_id() {
		return zffs_id;
	}

	public void setZffs_id(int zffs_id) {
		this.zffs_id = zffs_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWidget_name() {
		return widget_name;
	}

	public void setWidget_name(String widget_name) {
		this.widget_name = widget_name;
	}

	public String getZfb_id() {
		return zfb_id;
	}

	public void setZfb_id(String zfb_id) {
		this.zfb_id = zfb_id;
	}

	public String getZfb_code() {
		return zfb_code;
	}

	public void setZfb_code(String zfb_code) {
		this.zfb_code = zfb_code;
	}

	public String getZfb_zhanghao() {
		return zfb_zhanghao;
	}

	public void setZfb_zhanghao(String zfb_zhanghao) {
		this.zfb_zhanghao = zfb_zhanghao;
	}

	

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	/**
	 * @return the jianChen
	 */
	public String getJianChen() {
		return jianChen;
	}

	/**
	 * @param jianChen the jianChen to set
	 */
	public void setJianChen(String jianChen) {
		this.jianChen = jianChen;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



}
