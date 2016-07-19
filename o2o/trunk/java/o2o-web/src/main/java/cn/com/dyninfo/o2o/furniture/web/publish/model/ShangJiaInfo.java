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

package cn.com.dyninfo.o2o.furniture.web.publish.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;

import cn.com.dyninfo.o2o.old.model.UserInfo;
import cn.com.dyninfo.o2o.old.model.AreaInfo;
import cn.com.dyninfo.o2o.old.model.Nrj;
/**
 * @author 商家信息表
 *	Oct 8, 2011
 */
@Entity
@Table(name="T_SHANGJIA_INFO")
public class ShangJiaInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@AccessType(value = "property")
	@Column(name="SHANGJIA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int shangjia_id;//ID
	
	@AccessType(value = "property")
	@Column(name = "NAME")
	private String name;// 商家名称
	
	@AccessType(value="property")
	@Column(name="SORT")
	private Integer sort=0;//商家类型 0实体连锁 1加盟商 
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DAILI_ID")
	private UserInfo daili;//代理商
	
	@AccessType(value="property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TYPE_ID")
	private MerchantType type;
	
	
	@AccessType(value = "property")
	@Column(name = "CONTACTPHONE")
	private String contactPhone;// 联系人电话
	
	
	@AccessType(value = "property")
	@Column(name = "QQ")
	private String qq;// QQ
	
	@AccessType(value = "property")
	@Column(name = "CONTACTNAME")
	private String contactName;// 联系人姓名
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROVINCE_ID")
	private AreaInfo province;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CITY_ID")
	private AreaInfo city;
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNT_ID")
	private AreaInfo county;
	
	@AccessType(value = "property")
	@Column(name = "ADDRESS")
	private String address;// 商家地址
	
	
	@AccessType(value = "property")
	@Column(name = "LONGITUDE")
	private float longitude;// 经度
	
	
	@AccessType(value = "property")
	@Column(name = "LATITUDE")
	private float latitude;// 纬度

	@AccessType(value = "property")
	@Column(name = "INTRO")
	private String intro;//介绍

	@AccessType(value = "property")
	@Column(name = "ORDER_INDEX")
	private String orderIndex;//商家排序 0最前面
	
	@AccessType(value = "property")
	@Column(name = "RECOMMENDED_INDEX")
	private String recommendedIndex="0";//推荐排序 >0为推荐 =0不推荐
	
	@AccessType(value = "property")
	@Column(name = "IMAGE")
	private String image;//形象图片
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserInfo user;  //商家登陆账号
	
	@AccessType("property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="shangJiaInfo",cascade=CascadeType.ALL)
	private Nrj nrj; //女人街
	
	@AccessType(value = "property")
	@Column(name = "AFFILIATION")
	private String affiliation;//归属码
	
	@AccessType(value = "property")
	@Column(name="STATE")
	private String state="0";//0 不删 1删除
	
	@AccessType(value = "property")
	@Column(name="DESC_INFO")
	private String desc;//店铺介绍
	
	
	@AccessType(value = "property")
	@Column(name = "APPKEY")
	private String appKey;//appkey
	
	@AccessType(value = "property")
	@Column(name = "DZ_IAMGE")
	private String dzImage;// 店招图片（逗号分隔）
	
	@AccessType(value = "property")
	@Column(name = "DZ_URL")
	private String dzUrl;// 店招外链（逗号分隔）
	
	@AccessType(value = "property")
	@Column(name = "NRJ_IAMGE")
	private String nrjImage;// 女人街图片（逗号分隔）
	
	
	@AccessType(value = "property")
	@Column(name = "FLAG")
	private int flag;//店铺样式
	
	@AccessType(value = "property")
	@Column(name = "MONEY")
	private Double money;
	
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


	public int getShangjia_id() {
		return shangjia_id;
	}


	public void setShangjia_id(int shangjiaId) {
		shangjia_id = shangjiaId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactPhone() {
		return contactPhone;
	}


	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
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


	public AreaInfo getCounty() {
		return county;
	}


	public void setCounty(AreaInfo county) {
		this.county = county;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}





	public String getOrderIndex() {
		return orderIndex;
	}


	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}


	public String getRecommendedIndex() {
		return recommendedIndex;
	}


	public void setRecommendedIndex(String recommendedIndex) {
		this.recommendedIndex = recommendedIndex;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAffiliation() {
		return affiliation;
	}


	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}


	public String getAppKey() {
		return appKey;
	}


	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}


//	public Nrj getNrj() {
//		return nrj;
//	}
//
//
//	public void setNrj(Nrj nrj) {
//		this.nrj = nrj;
//	}


	/**
	 * @return the type
	 */
	public MerchantType getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(MerchantType type) {
		this.type = type;
	}


	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}


	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}


	/**
	 * @return the dzImage
	 */
	public String getDzImage() {
		return dzImage;
	}


	/**
	 * @param dzImage the dzImage to set
	 */
	public void setDzImage(String dzImage) {
		this.dzImage = dzImage;
	}


	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}


	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Nrj getNrj() {
		return nrj;
	}


	public void setNrj(Nrj nrj) {
		this.nrj = nrj;
	}


	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}


	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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


	public String getDzUrl() {
		return dzUrl;
	}


	public void setDzUrl(String dzUrl) {
		this.dzUrl = dzUrl;
	}


	public String getNrjImage() {
		return nrjImage;
	}


	public void setNrjImage(String nrjImage) {
		this.nrjImage = nrjImage;
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

	
}
