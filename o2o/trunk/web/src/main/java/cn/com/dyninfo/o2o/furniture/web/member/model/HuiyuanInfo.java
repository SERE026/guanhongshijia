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

import java.io.Serializable;
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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.com.dyninfo.o2o.furniture.web.address.model.AreaInfo;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

@Entity
@Table(name="T_HUIYUAN_INFO")
public class HuiyuanInfo implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
	  @AccessType(value="property")
	  @Column(name="HUIYUAN_ID")
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int huiYuan_id;
	
	  @AccessType(value="property")
	  @Column(name="NAME")
	  private String name;  //用户账号
	  
	  @AccessType(value="property")
	  @Column(name="QQ")
	  private String qq;
	  
	  @AccessType(value="property")
	  @Column(name="QQID")
	  private String qqid;//
	  
	  @AccessType(value="property")
	  @Column(name="PASSWORD")
	  private String password;  //密码
	  
	  @AccessType(value="property")
	  @Column(name="USERNAME")
	  private String userName;  //昵称
	  
	  @AccessType(value="property")
	  @Column(name="NICKNAME")
	  private String nickname;  //真实姓名
	  
	  @AccessType(value="property")
	  @Column(name="TX_IMAGE")
	  private String txImage;  //头像
	  
	  @AccessType(value="property")
	  @Column(name="SEX")
	  private String sex="0";  //性别 2.男 1.女 0.保密
	  
	  @AccessType(value="property")
	  @Column(name="BIRTHDAY")
	  private String birthday;  //生日
	  
	  @AccessType(value="property")
	  @Column(name="EMAIL")
	  private String email;  //email
	  
	  @AccessType(value="property")
	  @Column(name="EMLSTATE")
	  private String emlstate="0";  //邮箱是否验证 0.没有 1.已经验证
	  
	  @AccessType(value="property")
	  @Column(name="IDCARD")
	  private String idcard;  //身份证
	  
	  
	  @AccessType(value="property")
	  @Column(name="TEL")
	  private String tel;  //固定电话
	  
	  @AccessType(value="property")
	  @Column(name="PHONE")
	  private String phone;  //手机
	  
	  @AccessType(value="property")
	  @Column(name="PHONESTATE")
	  private String phonestate="0";  //手机是否验证 0.没有 1.已经验证
	  
	  @AccessType(value="property")
	  @Column(name="RANK")
	  private String rank;  //会员等级
	  
	  @AccessType(value="property")
	  @Column(name="LOGINDATA")
	  private String loginData;  //注册时间
	  
	  @AccessType(value="property")
	  @Column(name="ENTERDATA")
	  private String enterData;  //上次登录时间
	  
	  @AccessType(value="property")
	  @Column(name="POSTCODE")
	  private String postcode;  //邮编
	  
	  @AccessType(value="property")
	  @Column(name="COUNT")
	  private int count;  //登录次数
	  
	  @AccessType("property")
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="PROVINCE_ID")
	  private AreaInfo province;//省
		
	  @AccessType("property")
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="CITY_ID")
	  private AreaInfo city;//市
		
	  @AccessType("property")
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="REGION_ID")
      @NotFound(action = NotFoundAction.IGNORE)
	  private AreaInfo region;//区
	  
	  @AccessType(value="property")
	  @Column(name="ADDRESS")
	  private String address;  //地址
	  
	  @AccessType("property")
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="shang_id")
	  private ShangJiaInfo shangJiaInfo ;//商家
	  
	  @AccessType(value="property")
	  @Column(name="STATUS")
	  private String status="0";  //1删除 0不删除

	  @AccessType(value="property")
	  @Column(name="JF")
	  private int jf=0;  //积分
	  
	  @AccessType(value="property")
	  @Column(name="MONEY")
	  private Double money=0d; // 账户余额


	  @AccessType(value="property")
	  @Column(name="JFDATA")
	  private String jfData;  //最后积分时间
	  
	 @AccessType(value = "property")
	 @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="huiyuan")
	 private  List<Loginfo> log;//积分日志
	 
	 @AccessType(value = "property")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "info")
	private List<CommentInfo> comment;// 发布的晒单

	@AccessType(value = "property")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "huiyuan")
	private List<AppLoginStatus> appLoginStatusList;// 已登录的设备列表

	public List<CommentInfo> getComment() {
		return comment;
	}

	public void setComment(List<CommentInfo> comment) {
		this.comment = comment;
	}

	public int getHuiYuan_id() {
		return huiYuan_id;
	}

	public void setHuiYuan_id(int huiYuan_id) {
		this.huiYuan_id = huiYuan_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public AreaInfo getProvince() {
		return province;
	}

	public void setProvince(AreaInfo province) {
		this.province = province;
	}

	public AreaInfo getCity() {
		return city;
	}

	public void setCity(AreaInfo city) {
		this.city = city;
	}

	public AreaInfo getRegion() {
		return region;
	}

	public void setRegion(AreaInfo region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginData() {
		return loginData;
	}

	public void setLoginData(String loginData) {
		this.loginData = loginData;
	}

	public String getEnterData() {
		return enterData;
	}

	public void setEnterData(String enterData) {
		this.enterData = enterData;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ShangJiaInfo getShangJiaInfo() {
		return shangJiaInfo;
	}

	public void setShangJiaInfo(ShangJiaInfo shangJiaInfo) {
		this.shangJiaInfo = shangJiaInfo;
	}

	public int getJf() {
		return jf;
	}

	public void setJf(int jf) {
		this.jf = jf;
	}

	public String getJfData() {
		return jfData;
	}

	public void setJfData(String jfData) {
		this.jfData = jfData;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmlstate() {
		return emlstate;
	}

	public void setEmlstate(String emlstate) {
		this.emlstate = emlstate;
	}

	public String getPhonestate() {
		return phonestate;
	}

	public void setPhonestate(String phonestate) {
		this.phonestate = phonestate;
	}

	public String getTxImage() {
		return txImage;
	}

	public void setTxImage(String txImage) {
		this.txImage = txImage;
	}

	public List<Loginfo> getLog() {
		return log;
	}

	public void setLog(List<Loginfo> log) {
		this.log = log;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return the qqid
	 */
	public String getQqid() {
		return qqid;
	}

	/**
	 * @param qqid the qqid to set
	 */
	public void setQqid(String qqid) {
		this.qqid = qqid;
	}

	/**
	 * @return the money
	 */
	public Double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Double money) {
		this.money = money;
	}

	public List<AppLoginStatus> getAppLoginStatusList() {
		return appLoginStatusList;
	}

	public void setAppLoginStatusList(List<AppLoginStatus> appLoginStatusList) {
		this.appLoginStatusList = appLoginStatusList;
	}
}
