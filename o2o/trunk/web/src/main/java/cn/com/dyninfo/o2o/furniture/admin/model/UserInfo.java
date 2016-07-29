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

/**
 * @author jettang
 * May 17, 2010
 * 
 */
package cn.com.dyninfo.o2o.furniture.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;



import org.hibernate.annotations.AccessType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;


/**
 * @author jettang
 * May 17, 2010
 */
@Entity
@Table(name="BASE_USER_INFO")
public class UserInfo implements UserDetails,Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6565575872077898080L;

	@Id
	@AccessType(value = "property")
	@Column(name="LOGIN_ID",length=32)
	private String login_id;//LOGIN_ID
	
	@AccessType(value = "property")
	@Column(name="USER_NAME",length=200)
	private String user_name;//人员实际名称
	
	@AccessType(value = "property")
	@Column(name="PASSWD",length=128)
	private String passwd;//用户密码
	
	@AccessType(value = "property")
	@Column(name="ISUSED",length=1)
	private String isUsed;//是否启用  0否  1是
	
	@AccessType(value = "property")
	@Column(name="PS",columnDefinition ="text")
	private String ps;//描述
	
	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_OGNZ_USER", joinColumns={@JoinColumn(name="USER_ID")},  
	  inverseJoinColumns={@JoinColumn(name="OGNZ_ID")})
	@OrderBy(value ="index_order asc")
	private List<OgnzInfo> ognzs;//用户所在的组织结构对象
	
	@AccessType(value = "property")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)   
	@JoinTable(name="BASE_USER_ROLE", joinColumns={@JoinColumn(name="USER_ID")},  
			inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
	private List<RoleInfo> roles;//用户对应的角色
	
	@AccessType(value="property")
	@Column(name="OFF_TEL",length=255)
	private String offTel;//办公室电话
	
	@AccessType(value="property")
	@Column(name="MOBILE",length=255)
	private String mobile;//手机
	
	@AccessType("property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private ShangJiaInfo shanfJiaInfo; //商家资料
	  
	 @AccessType(value="property")
	 @Column(name="IS_USER",length=255)
	private String is_user="0";//1 商家  0管理人员 2代理商
	
	@AccessType(value="property")
	@Column(name="IMG",length=255)
	private String img;//照片
	
	@AccessType(value="property")
	@Column(name="EMAIL",length=255)
	private String email;//邮箱
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DAILI_ID")
	private  UserInfo daili;//代理

	@AccessType("property")
	@Column(name="AREANMAE",length=500)
	private String areaname;//地区名连接的字符
	
	@AccessType("property")
	@Column(name="AREAID",length=32)
	private String areaid;//地区id
	
	@AccessType(value="property")
	@Column(name="IS_DEFAULT",length=1)
	private String isDefault;//是否系统默认0否  1是
	
	@AccessType(value = "property")
	@Column(name = "INDEX_ORDER")
	private int index_order;// 排序
	
	@Transient
	private String ognzNames;//所在组织的名称
	
	@Transient
	private Double saleDouble;//销售人员业绩金额
	
	@Transient
	private int saleNum;//销售人员订单数量

	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="user")
	private  List<Log> log;//日志


	public List<Log> getLog() {
		return log;
	}

	public void setLog(List<Log> log) {
		this.log = log;
	}

	/**
	 * @param ognzNames the ognzNames to set
	 */
	public void setOgnzNames(String ognzNames) {
		this.ognzNames = ognzNames;
	}
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 * 返回角色权限
	 */
	
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authSet = new ArrayList<GrantedAuthority>();
		if(this.getRoles()!=null){
			for(RoleInfo role:this.getRoles()){
				authSet.add(role);
			}
		}
		return authSet;
	}
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 * 返回密码
	 */
	
	public String getPassword() {
		return this.getPasswd();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	
	public String getUsername() {
		// TODO 返回登陆ID
		return this.getLogin_id();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 * 账户是否过期
	 */
	
	public boolean isAccountNonExpired() {
		return this.getIsUsed().equals("1")?true:false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 * 是否账户被锁定
	 */
	
	public boolean isAccountNonLocked() {
		return this.getIsUsed().equals("1")?true:false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 * 是否凭证过期
	 */
	
	public boolean isCredentialsNonExpired() {
		return this.getIsUsed().equals("1")?true:false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 * 是否可用
	 */
	
	public boolean isEnabled() {
		return this.getIsUsed().equals("1")?true:false;
	}

	
	public String getBusinessEmail() {
		return email;
	}
	
	public String getFamilyName() {
		return null;
	}
	
	public String getGivenName() {
		return user_name;
	}
	
	public String getId() {
		return login_id;
	}
	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}


	public List<OgnzInfo> getOgnzs() {
		return ognzs;
	}

	public void setOgnzs(List<OgnzInfo> ognzs) {
		this.ognzs = ognzs;
	}

	public String getOffTel() {
		return offTel;
	}

	public void setOffTel(String offTel) {
		this.offTel = offTel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the roles
	 */
	public List<RoleInfo> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}
	
	/**
	 * @return the index_order
	 */
	public int getIndex_order() {
		return index_order;
	}
	/**
	 * @param index_order the index_order to set
	 */
	public void setIndex_order(int index_order) {
		this.index_order = index_order;
	}
	
	/**
	 * 得到部门名称
	 * @return
	 */
	public String getOgnzNames(){
		if(this.ognzs != null){
			ognzNames = "";
			for(int i =0; i<ognzs.size(); i++){
				OgnzInfo ognz = ognzs.get(i);
				ognzNames += ognz.getOgnz_name();
				if(i+1<ognzs.size())
					ognzNames += ",";
			}
		}
		return ognzNames;
	}

	/**
	 * @return the saleDouble
	 */
	public Double getSaleDouble() {
		return saleDouble;
	}

	/**
	 * @param saleDouble the saleDouble to set
	 */
	public void setSaleDouble(Double saleDouble) {
		this.saleDouble = saleDouble;
	}

	/**
	 * @return the saleNum
	 */
	public int getSaleNum() {
		return saleNum;
	}

	/**
	 * @param saleNum the saleNum to set
	 */
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	

	public ShangJiaInfo getShanfJiaInfo() {
		return shanfJiaInfo;
	}

	public void setShanfJiaInfo(ShangJiaInfo shanfJiaInfo) {
		this.shanfJiaInfo = shanfJiaInfo;
	}

	public String getIs_user() {
		return is_user;
	}

	public void setIs_user(String is_user) {
		this.is_user = is_user;
	}

	/**
	 * @return the daili
	 */
	public UserInfo getDaili() {
		return daili;
	}

	/**
	 * @param daili the daili to set
	 */
	public void setDaili(UserInfo daili) {
		this.daili = daili;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

}
