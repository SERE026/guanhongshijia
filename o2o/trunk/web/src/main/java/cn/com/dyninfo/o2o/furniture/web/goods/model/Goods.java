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

package cn.com.dyninfo.o2o.furniture.web.goods.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.AccessType;

import cn.com.dyninfo.o2o.furniture.util.StringUtil;

import cn.com.dyninfo.o2o.furniture.web.active.model.Active;
import cn.com.dyninfo.o2o.furniture.web.publish.model.ShangJiaInfo;

/***
 *商品
 * @author 008
 *
 */
@Entity
@Table(name="T_GOODS")
public class Goods {
	
	@Id
	@AccessType(value = "property")
	@Column(name="GOODS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int goods_id;
	
	@AccessType(value = "property")
	@Column(name="NAME")
	private String name;//商品名称

	@AccessType(value = "property")
	@Column(name="SHORT_DESC")
	private String shortDesc;   //商品描述

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARCHANTS_ID")
	private ShangJiaInfo merchants;//如果对象是商家 此字段应有值
	
	@AccessType(value = "property")
	@OneToOne(fetch=FetchType.LAZY,mappedBy="goods")
	private GoodsDelivery delivery;//配送方式
	
	@AccessType(value = "property")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;//货架
	
	@AccessType(value = "property")
	@Column(name="CODE")
	private String code;//商品编号
	
	@AccessType(value = "property")
	@Column(name="SHELVES")
	private String shelves="0";//是否上架 0是 1不是
	
	
	@AccessType(value = "property")
	@Column(name="TRYUSE")
	private String tryuse="0";//是否试用 0不是 1是
	
	@AccessType(value = "property")
	@Column(name="MFIMAGES")
	private String mfimages;//免费试用封面图片;分开

	@AccessType(value = "property")
	@Column(name="TRYNO")
	private int tryno=0;//试用份数
	
	@AccessType(value = "property")
	@Column(name="PEPOLENO")
	private int pepoleno=0;//试用人数
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="goods")
	private List<TryuseApply> applyList;//试用申请
	
	@AccessType(value = "property")
	@Column(name="BTIME")
	private String btime;//试用开始时间
	
	@AccessType(value = "property")
	@Column(name="ETIME")
	private String etime;///试用结束时间
	
	
	@AccessType(value = "property")
	@Column(name="IMG")
	private String img;//商品图片路径
	
	@AccessType(value = "property")
	@Column(name="SALESMONEY")
	private Double salesMoney = 0.0;//销售价格
	
	@AccessType(value = "property")
	@Column(name="BAZAARMONEY")
	private Double bazaarMoney = 0.0;//市场价格
	
	@AccessType(value = "property")
	@Column(name="HUIYUANMONEY")
	private Double huiyuanMoney = 0.0;//会员价格
	
	@AccessType(value = "property")
	@Column(name="COSTSMONEY")
	private Double costsMoney = 0.0;//成本价格
	
	@AccessType(value = "property")
	@Column(name="WEIGHT")
	private Double weight = 0.0;//重量
	
	
	@AccessType(value = "property")
	@Column(name="INVENTORY")
	private Double inventory = 0.0;//库存数量
	
	
	@AccessType(value = "property")
	@Column(name="GOODSDESCRIPTION")
	private String goodsDescription;//产品描述
	
	
	@AccessType(value = "property")
	@Column(name="GOODSPARAMETER")
	private String goodsParameter;//产品实拍
	
	@AccessType(value = "property")
	@Column(name="GOODSSTORY")
	private String goodsStory;//活动描述
	
	@AccessType(value = "property")
	@Column(name="GOODSAUTHORIZATION")
	private String goodsAuthorization;//产品授权
	
	/**
	 * 0最新商品1促销2精品推荐3热销产品  以逗号分割
	 */
	@AccessType(value = "property")
	@Column(name="BIAOQIAN")
	private String biaoqian;//标签 
	
	@AccessType(value = "property")
	@Column(name="ISHG")
	private int ishg;//是否申请进行会员换购 0是 1否
	
	@AccessType(value = "property")
	@Column(name="PRICE_RANGE")
	private String priceRange;//价格区间
	
	
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOODSSORT_ID")
	private GoodsSort goodsSort;// 商品分类
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOM_SORT_ID")
	private GoodsSort customSort;//自定义分类
	
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GOODSTYPE_ID")
	private GoodsType goodsType;//商品类型
	
	@AccessType(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;//品牌
	
	@AccessType(value = "property")
	@Column(name="INDEXS")
	private int indexs=99999;//排序
	
	
	@AccessType(value = "property")
	@Column(name="SJ_TIME")
	private String sj_time;//上架时间
	
	@AccessType(value = "property")
	@Column(name="NUM")
	private int num;//销售数量
	
	@AccessType(value = "property")
	@Column(name="SYS_TIME")
	private String sys_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//系统时间
	
	@AccessType(value = "property")
	@Column(name="STATE")
	private String state="0";//0 不删 1删除
	
	@AccessType(value = "property")
	@Column(name="TYPESPEC")
	private String typeSpec;//类型属性
	
	@AccessType(value = "property")
	@Column(name="DEFAULT_IAMAGE")
	private String defaultImage;//商品默认图片
	
	@AccessType(value = "property")
	@Column(name="IMAGES")
	private String images;//;分开
	
	
	
	@AccessType(value = "property")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="goods")
	private List<GoodsSpec> specList;//产品参数
	
	
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_0")
	private String specValue0;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_1")
	private String specValue1;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_2")
	private String specValue2;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_3")
	private String specValue3;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_4")
	private String specValue4;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_5")
	private String specValue5;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_6")
	private String specValue6;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_7")
	private String specValue7;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_8")
	private String specValue8;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_9")
	private String specValue9;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_10")
	private String specValue10;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_11")
	private String specValue11;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_12")
	private String specValue12;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_13")
	private String specValue13;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_14")
	private String specValue14;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_15")
	private String specValue15;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_16")
	private String specValue16;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_17")
	private String specValue17;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_18")
	private String specValue18;
	
	@AccessType(value = "property")
	@Column(name="SPEC_VALUE_19")
	private String specValue19;
	
	@Transient
	private float discount;
	
	@Transient
	private Double actionMoney=0.0;
	
	@Transient
	private String actionId;
	
	@Transient
	private Double goodMoney=0.0;
	
	@Transient
	private Active act;
	
	@Transient
	private List spec;
	
	@Transient
	private String description;
	
	@Transient
	private int actFlag;//0 普通 1游戏

	/**
	 * @return the description
	 */
	public String getDescription() {
		return StringUtil.replaceImage(this.getGoodsDescription());
	}

	/**
	 * @return the spec
	 */
	public List getSpec() {
		return spec;
	}

	/**
	 * @param spec the spec to set
	 */
	public void setSpec(List spec) {
		this.spec = spec;
	}

	public Double getActionMoney() {
		return actionMoney;
	}

	public void setActionMoney(Double actionMoney) {
		this.actionMoney = actionMoney;
	}

	public Double getGoodMoney() {
//		System.out.println(this.getName()+"==============="+this.getSalesMoney()+"========="+actionMoney);
//		System.out.println(this.getSalesMoney()-actionMoney);
		if(actionMoney==null)
			actionMoney=0.0;
		if(actionMoney==0.0){
			return this.getSalesMoney();
		}else{
			return actionMoney;
		}
	}

	public float getDiscount() {
		
		try{
			if(bazaarMoney==null)
				bazaarMoney=0.0;
			if(salesMoney==null)
				salesMoney=0.0;
			float d=(float) (Math.round((salesMoney-discount)/bazaarMoney*10));
			return d;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0.0f;
	}

	public String getSj_time() {
		return sj_time;
	}

	public void setSj_time(String sjTime) {
		sj_time = sjTime;
	}

	public String getSys_time() {
		return sys_time;
	}

	public void setSys_time(String sysTime) {
		sys_time = sysTime;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() { return shortDesc; }

	public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

	public int getIndexs() {
		return indexs;
	}

	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}

	public void setGoodMoney(Double goodMoney) {
		this.goodMoney = goodMoney;
	}

	public GoodsSort getGoodsSort() {
		return goodsSort;
	}

	public void setGoodsSort(GoodsSort goodsSort) {
		this.goodsSort = goodsSort;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	/**
	 * @return the merchants
	 */
	public ShangJiaInfo getMerchants() {
		return merchants;
	}

	/**
	 * @param merchants the merchants to set
	 */
	public void setMerchants(ShangJiaInfo merchants) {
		this.merchants = merchants;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getSalesMoney() {
		return salesMoney;
	}

	public void setSalesMoney(Double salesMoney) {
		this.salesMoney = salesMoney;
	}

	public Double getBazaarMoney() {
		return bazaarMoney;
	}

	public void setBazaarMoney(Double bazaarMoney) {
		this.bazaarMoney = bazaarMoney;
	}

	public Double getHuiyuanMoney() {
		return huiyuanMoney;
	}

	public void setHuiyuanMoney(Double huiyuanMoney) {
		this.huiyuanMoney = huiyuanMoney;
	}

	public Double getCostsMoney() {
		return costsMoney;
	}

	public void setCostsMoney(Double costsMoney) {
		this.costsMoney = costsMoney;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getInventory() {
		return inventory;
	}

	public void setInventory(Double inventory) {
		this.inventory = inventory;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getGoodsParameter() {
		return goodsParameter;
	}

	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}

	public String getGoodsStory() {
		return goodsStory;
	}

	public void setGoodsStory(String goodsStory) {
		this.goodsStory = goodsStory;
	}

	public String getGoodsAuthorization() {
		return goodsAuthorization;
	}

	public void setGoodsAuthorization(String goodsAuthorization) {
		this.goodsAuthorization = goodsAuthorization;
	}

	

	public String getBiaoqian() {
		return biaoqian;
	}

	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getTypeSpec() {
		return typeSpec;
	}

	public void setTypeSpec(String typeSpec) {
		this.typeSpec = typeSpec;
	}

	public String getDefaultImage() {
		return defaultImage;
	}

	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	/**
	 * @return the specValue1
	 */
	public String getSpecValue1() {
		return specValue1;
	}

	/**
	 * @param specValue1 the specValue1 to set
	 */
	public void setSpecValue1(String specValue1) {
		this.specValue1 = specValue1;
	}

	/**
	 * @return the specValue2
	 */
	public String getSpecValue2() {
		return specValue2;
	}

	/**
	 * @param specValue2 the specValue2 to set
	 */
	public void setSpecValue2(String specValue2) {
		this.specValue2 = specValue2;
	}

	/**
	 * @return the specValue3
	 */
	public String getSpecValue3() {
		return specValue3;
	}

	/**
	 * @param specValue3 the specValue3 to set
	 */
	public void setSpecValue3(String specValue3) {
		this.specValue3 = specValue3;
	}

	/**
	 * @return the specValue4
	 */
	public String getSpecValue4() {
		return specValue4;
	}

	/**
	 * @param specValue4 the specValue4 to set
	 */
	public void setSpecValue4(String specValue4) {
		this.specValue4 = specValue4;
	}

	/**
	 * @return the specValue5
	 */
	public String getSpecValue5() {
		return specValue5;
	}

	/**
	 * @param specValue5 the specValue5 to set
	 */
	public void setSpecValue5(String specValue5) {
		this.specValue5 = specValue5;
	}

	/**
	 * @return the specValue6
	 */
	public String getSpecValue6() {
		return specValue6;
	}

	/**
	 * @param specValue6 the specValue6 to set
	 */
	public void setSpecValue6(String specValue6) {
		this.specValue6 = specValue6;
	}

	/**
	 * @return the specValue7
	 */
	public String getSpecValue7() {
		return specValue7;
	}

	/**
	 * @param specValue7 the specValue7 to set
	 */
	public void setSpecValue7(String specValue7) {
		this.specValue7 = specValue7;
	}

	/**
	 * @return the specValue8
	 */
	public String getSpecValue8() {
		return specValue8;
	}

	/**
	 * @param specValue8 the specValue8 to set
	 */
	public void setSpecValue8(String specValue8) {
		this.specValue8 = specValue8;
	}

	/**
	 * @return the specValue9
	 */
	public String getSpecValue9() {
		return specValue9;
	}

	/**
	 * @param specValue9 the specValue9 to set
	 */
	public void setSpecValue9(String specValue9) {
		this.specValue9 = specValue9;
	}

	/**
	 * @return the specValue10
	 */
	public String getSpecValue10() {
		return specValue10;
	}

	/**
	 * @param specValue10 the specValue10 to set
	 */
	public void setSpecValue10(String specValue10) {
		this.specValue10 = specValue10;
	}

	/**
	 * @return the specValue11
	 */
	public String getSpecValue11() {
		return specValue11;
	}

	/**
	 * @param specValue11 the specValue11 to set
	 */
	public void setSpecValue11(String specValue11) {
		this.specValue11 = specValue11;
	}

	/**
	 * @return the specValue12
	 */
	public String getSpecValue12() {
		return specValue12;
	}

	/**
	 * @param specValue12 the specValue12 to set
	 */
	public void setSpecValue12(String specValue12) {
		this.specValue12 = specValue12;
	}

	/**
	 * @return the specValue13
	 */
	public String getSpecValue13() {
		return specValue13;
	}

	/**
	 * @param specValue13 the specValue13 to set
	 */
	public void setSpecValue13(String specValue13) {
		this.specValue13 = specValue13;
	}

	/**
	 * @return the specValue14
	 */
	public String getSpecValue14() {
		return specValue14;
	}

	/**
	 * @param specValue14 the specValue14 to set
	 */
	public void setSpecValue14(String specValue14) {
		this.specValue14 = specValue14;
	}

	/**
	 * @return the specValue15
	 */
	public String getSpecValue15() {
		return specValue15;
	}

	/**
	 * @param specValue15 the specValue15 to set
	 */
	public void setSpecValue15(String specValue15) {
		this.specValue15 = specValue15;
	}

	/**
	 * @return the specValue16
	 */
	public String getSpecValue16() {
		return specValue16;
	}

	/**
	 * @param specValue16 the specValue16 to set
	 */
	public void setSpecValue16(String specValue16) {
		this.specValue16 = specValue16;
	}

	/**
	 * @return the specValue17
	 */
	public String getSpecValue17() {
		return specValue17;
	}

	/**
	 * @param specValue17 the specValue17 to set
	 */
	public void setSpecValue17(String specValue17) {
		this.specValue17 = specValue17;
	}

	/**
	 * @return the specValue18
	 */
	public String getSpecValue18() {
		return specValue18;
	}

	/**
	 * @param specValue18 the specValue18 to set
	 */
	public void setSpecValue18(String specValue18) {
		this.specValue18 = specValue18;
	}

	/**
	 * @return the specValue19
	 */
	public String getSpecValue19() {
		return specValue19;
	}

	/**
	 * @param specValue19 the specValue19 to set
	 */
	public void setSpecValue19(String specValue19) {
		this.specValue19 = specValue19;
	}

	/**
	 * @return the specList
	 */
	public List<GoodsSpec> getSpecList() {
		return specList;
	}

	/**
	 * @param specList the specList to set
	 */
	public void setSpecList(List<GoodsSpec> specList) {
		this.specList = specList;
	}

	/**
	 * @return the shelves
	 */
	public String getShelves() {
		return shelves;
	}

	/**
	 * @param shelves the shelves to set
	 */
	public void setShelves(String shelves) {
		this.shelves = shelves;
	}

	/**
	 * @return the specValue0
	 */
	public String getSpecValue0() {
		return specValue0;
	}

	/**
	 * @param specValue0 the specValue0 to set
	 */
	public void setSpecValue0(String specValue0) {
		this.specValue0 = specValue0;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}



	/**
	 * @return the delivery
	 */
	public GoodsDelivery getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(GoodsDelivery delivery) {
		this.delivery = delivery;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the customSort
	 */
	public GoodsSort getCustomSort() {
		return customSort;
	}

	/**
	 * @param customSort the customSort to set
	 */
	public void setCustomSort(GoodsSort customSort) {
		this.customSort = customSort;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the actionId
	 */
	public String getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the act
	 */
	public Active getAct() {
		return act;
	}

	/**
	 * @param act the act to set
	 */
	public void setAct(Active act) {
		this.act = act;
	}

	/**
	 * @return the priceRange
	 */
	public String getPriceRange() {
		return priceRange;
	}

	/**
	 * @param priceRange the priceRange to set
	 */
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	/**
	 * @return the actFlag
	 */
	public int getActFlag() {
		return actFlag;
	}

	/**
	 * @param actFlag the actFlag to set
	 */
	public void setActFlag(int actFlag) {
		this.actFlag = actFlag;
	}

	public int getIshg() {
		return ishg;
	}

	public void setIshg(int ishg) {
		this.ishg = ishg;
	}

	/**
	 * @return the tryuse
	 */
	public String getTryuse() {
		return tryuse;
	}

	/**
	 * @param tryuse the tryuse to set
	 */
	public void setTryuse(String tryuse) {
		this.tryuse = tryuse;
	}

	/**
	 * @return the btime
	 */
	public String getBtime() {
		return btime;
	}

	/**
	 * @param btime the btime to set
	 */
	public void setBtime(String btime) {
		this.btime = btime;
	}

	/**
	 * @return the etime
	 */
	public String getEtime() {
		return etime;
	}

	/**
	 * @param etime the etime to set
	 */
	public void setEtime(String etime) {
		this.etime = etime;
	}

	/**
	 * @return the tryno
	 */
	public int getTryno() {
		return tryno;
	}

	/**
	 * @param tryno the tryno to set
	 */
	public void setTryno(int tryno) {
		this.tryno = tryno;
	}

	/**
	 * @return the pepoleno
	 */
	public int getPepoleno() {
		return pepoleno;
	}

	/**
	 * @param pepoleno the pepoleno to set
	 */
	public void setPepoleno(int pepoleno) {
		this.pepoleno = pepoleno;
	}

	/**
	 * @return the applyList
	 */
	public List<TryuseApply> getApplyList() {
		return applyList;
	}

	/**
	 * @param applyList the applyList to set
	 */
	public void setApplyList(List<TryuseApply> applyList) {
		this.applyList = applyList;
	}

	public String getMfimages() {
		return mfimages;
	}

	public void setMfimages(String mfimages) {
		this.mfimages = mfimages;
	}



}
